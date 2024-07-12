package task05.src;

import task05.src.Model.Jogador;
import task05.src.Service.OpcoesMenu;
import task05.src.Service.Partida;
import task05.src.Service.JogadorService;
import task05.src.Service.Progresso;
import task05.src.exceptions.BancoDeDadosException;
import task05.src.repository.RankingRepository;

import java.util.*;

public class MenuJogo {

    private Jogador jogador;
    JogadorService jogadorService = new JogadorService();
    Scanner sc = new Scanner(System.in);

    public MenuJogo(Jogador jogadores) {
        this.jogador = jogadores;
    }

    public MenuJogo() {
    }

    // metodo para chamar no main
    public void iniciarMenu() throws Exception {

        while (true) {
            exibirMenu();
            OpcoesMenu opcoesMenuEnum = OpcoesMenu.valueOf(lerOpcao());

            switch (opcoesMenuEnum) {
                case CADASTRAR_JOGADOR:
                    jogador = cadastrarJogador();
                    break;
                case EDITAR_JOGADOR:
                    editarJogador();
                    break;
                case INSTRUCOES_JOGO:
                    InstrucoesJogo.mostrarInstrucoes();
                    break;
                case INICIAR_PARTIDA:
                    jogadorService.listar();
                    System.out.println("Digite o id do jogador ou 0 para cadastrar um novo jogador");
                    int id = sc.nextInt();
                    sc.nextLine();
                    if (id == 0){
                        jogador = cadastrarJogador();
                    } else {
                        jogador = jogadorService.buscarJogadorPorId(id);
                    }
                    Partida partida = new Partida(jogador);
                    partida.iniciar();
                    break;
                case RANKING: //ranking
                    desenharRanking();
                    break;
                case SAIR:
                    //sair
                    System.out.println(" ");
                    System.out.println("Saindo do jogo...");
                    sc.close();
                    System.exit(0);
                    return;
                default:
                    System.out.println("\u001B[31m" + "Opção inválida. Digite um número válido." + "\u001B[0m");
            }
        }
    }

    private void exibirMenu() {
        System.out.println("---------------------------------------");
        System.out.println("|             JOGO TERMO              |");
        System.out.println("---------------------------------------");
        System.out.println("| 1 - Cadastrar Jogador               |");
        System.out.println("| 2 - Editar informações do Jogador   |");
        System.out.println("| 3 - Instruções                      |");
        System.out.println("| 4 - Jogar                           |");
        System.out.println("| 5 - Ranking                         |");
        System.out.println("| 6 - Sair                            |");
        System.out.println("---------------------------------------");

        System.out.println();
    }

    // realiza a leitura da opção que o usuario digitou e valida
    private int lerOpcao() {
        try {
            System.out.print("Digite a sua opção: ");
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("\u001B[31m" + "Opção inválida. Digite um número válido." + "\u001B[0m");
            return lerOpcao();
        }
    }

    private Jogador cadastrarJogador() {
        String nome;
        System.out.println(" ");
        System.out.println("Cadastrar novo jogador");
        System.out.println("\u001B[31m" + "O nome deve ter no mínimo 3 letras e não pode conter números." + "\u001B[0m");
        do {
            System.out.print("Digite o nome do novo jogador: ");
            nome = sc.nextLine();
        } while (!isNomeValido(nome));
        Jogador novoJogador = new Jogador(nome);
        jogadorService.adicionarJogador(novoJogador);
        System.out.println("\u001B[32m" + "Nome cadastrado com sucesso!" + "\u001B[0m");
        return new Jogador(nome);
    }

    public void editarJogador() {
        System.out.println("Escolha o id da pessoa você deseja editar?");
        jogadorService.listar();
        int index = sc.nextInt();
        sc.nextLine();

        if(jogadorService.buscarJogadorPorId(index) == null){
            System.out.println(" ");
            System.out.println("\u001B[31m" + "Jogador não encontrado" + "\u001B[0m");
            return;
        }

        System.out.println("1 - Editar nome do jogador");
        System.out.println("2 - Excluir jogador");

        int opcao = sc.nextInt();
        sc.nextLine();

        if(opcao == 1){
            System.out.println("Digite o novo nome do jogador: ");
            Jogador jogadorEditado = new Jogador();
            jogadorEditado.setNome(sc.nextLine());
            jogadorService.editarJogador(index, jogadorEditado);
        } else if(opcao == 2){
            jogadorService.removerJogador(index);
        } else {
            System.out.println(" ");
            System.out.println("\u001B[31m" + "Opção inválida" + "\u001B[0m");
        }
    }

    private boolean isNomeValido(String nome) {
        if (nome.length() < 3) {
            System.out.println(" ");
            System.out.println("\u001B[31m" + "O nome deve ter no mínimo 3 letras." + "\u001B[0m");
            return false;
        }
        for (char c : nome.toCharArray()) {
            if (Character.isDigit(c)) {
                System.out.println(" ");
                System.out.println("\u001B[31m" + "O nome não pode conter números." + "\u001B[0m");
                return false;
            }
        }
        return true;
    }

    public static void desenharRanking() throws BancoDeDadosException {
        RankingRepository res = new RankingRepository();
        List<Map<String, Object>> rankings = res.listarRanking();
        System.out.println(" _____________________________________ ");
        System.out.println("|         RANKING DE JOGADORES        |");
        System.out.println("|-------------------------------------|");
        System.out.println("| Pos | Nome               | Vitórias |");
        System.out.println("|-------------------------------------|");
        int posicao = 1;
        List<Map<String, Integer>> jogadorRanking = new ArrayList<>();
        for (Map<String, Object> r: rankings){
            String nome = (String) r.get("NOME_JOGADOR");
            int vitorias = (int) r.get("VITORIAS");

            // Verifica se o jogador já está presente em jogadorRanking
            boolean jogadorExistente = false;
            for (Map<String, Integer> jogador : jogadorRanking) {
                if (jogador.containsKey(nome)) {
                    jogador.put(nome, jogador.get(nome) + vitorias);
                    jogadorExistente = true;
                    break;
                }
            }

            // Se o jogador não existir, adiciona um novo mapa
            if (!jogadorExistente) {
                Map<String, Integer> jogadorInfo = new HashMap<>();
                jogadorInfo.put(nome, vitorias);
                jogadorRanking.add(jogadorInfo);
            }
        }

        jogadorRanking.sort(Comparator.comparing(m -> m.get(m.keySet().iterator().next()), Comparator.reverseOrder()));
        for (Map<String, Integer> p : jogadorRanking) {
            System.out.printf("|  %-3d| %-17s  |   %-6d |\n", posicao, p.keySet().iterator().next(), p.get(p.keySet().iterator().next()));
            posicao++;
        }
        System.out.println("|_____________________________________|");
        System.out.println(" ");
    }
}