package task05.src;

import task05.src.Model.Jogador;
import task05.src.Service.Partida;
import task05.src.Service.Progresso;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MenuJogo {

    private Jogador jogador;

    Scanner sc = new Scanner(System.in);
    private List<Jogador> jogadores = new LinkedList<>();

    public MenuJogo(Jogador jogadores) {
        this.jogador = jogadores;
    }

    public MenuJogo() {
    }

    // metodo para chamar no main
    public void iniciarMenu() throws Exception {

        while (true) {
            exibirMenu();
            int opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    jogador = cadastrarJogador();
                    break;
                case 2:
                    if (jogador == null) {
                        System.out.println("Não há nenhum jogador cadastrado.");
                        break;
                    }
                    editarJogador();
                    break;
                case 3:
                    InstrucoesJogo.mostrarInstrucoes();
                    break;
                case 4:
                    if (jogador == null) {
                        jogador = cadastrarJogador();
                    };
                    Partida partida = new Partida(buscarJogador());
                    partida.iniciar();
                    break;
                case 5: //ranking
                    desenharRanking();
                    break;
                case 6:
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
        jogadores.add(novoJogador);
        System.out.println("\u001B[32m" + "Nome cadastrado com sucesso!" + "\u001B[0m");
        return new Jogador(nome);
    }

    public void editarJogador() {
        Jogador jogador = buscarJogador();

        if(jogador != null) {
            System.out.print("Jogador encontrado. Digite o novo nome: ");
            String novoNome = sc.nextLine();
            jogador.setNome(novoNome);
            System.out.println("Nome atualizado para: " + novoNome);
            System.out.println(" ");
        }
    }
    public  Jogador buscarJogador() {
        System.out.print("Digite o nome do jogador: ");
        String nome = sc.nextLine();

        for (Jogador jogador : jogadores) {
            if (jogador.getNome().equalsIgnoreCase(nome)) {
                return jogador;
            }
        }
        System.out.println(" ");
        System.out.println("\u001B[31m" + "Jogador não encontrado" + "\u001B[0m");
        return cadastrarJogador();
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

    public static void desenharRanking() {


        List<Progresso> ranking =  Progresso.calcularRanking();
        System.out.println(" _____________________________________ ");
        System.out.println("|         RANKING DE JOGADORES        |");
        System.out.println("|-------------------------------------|");
        System.out.println("| Pos | Nome               | Vitórias |");
        System.out.println("|-------------------------------------|");
        int posicao = 1;
        for (Progresso p : ranking) {
            System.out.printf("|  %-3d| %-17s  |   %-6d |\n", posicao, p.getNome(), p.getVitorias());
            posicao++;
        }
        System.out.println("|_____________________________________|");
        System.out.println(" ");
    }
}