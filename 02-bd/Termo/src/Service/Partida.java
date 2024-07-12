package task05.src.Service;

import task05.src.Model.Jogador;
import task05.src.Model.PalavraSecreta;
import task05.src.Model.Teclado;
import task05.src.repository.RankingRepository;
import task05.src.repository.PalavrasRepository;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Partida {

    private Jogador jogador;
    private PalavraSecreta palavraSecreta;
    private PalavrasRepository palavraBD;
    private Teclado teclado;
    private int contadorVitorias;
    private int contadorDerrotas;
    private int jogadas;
    Cores cores;

    Scanner scanner = new Scanner(System.in);
    RankingService rankingService = new RankingService();

    public Partida(Jogador jogador) {
        this.jogador = jogador;
        this.teclado = new Teclado();
        Progresso progresso = new Progresso(jogador.getNome());
        this.contadorVitorias = progresso.getVitorias();
        this.contadorDerrotas = progresso.getDerrotas();
        this.jogadas = progresso.getPartidasJogo();
    }

    // Método para iniciar a partida
    public void iniciar() throws Exception {

        boolean continuarJogando = true;

        Progresso progresso = new Progresso(jogador.getNome());
        progresso.setIdJogador(jogador.getIdJogador());

        while (continuarJogando){
            palavraSecreta = PalavraSecreta.sortearPalavraSecreta();
            teclado.resetarTeclado();
            jogador.setTentativasRestantes(6);
            realizarTentativa();

            if (jogador.getTentativasRestantes() == 0) {
                System.out.println(" ");
                System.out.println("Fim de jogo! A palavra secreta era: " + "\u001B[32m" + palavraSecreta.getPalavraSecreta() + "\u001B[0m");
                contadorDerrotas ++;
            }
            jogadas++;
            System.out.println(" ");
            System.out.print("Deseja jogar novamente? (s/n): ");
            String resposta = scanner.nextLine();
            if (!resposta.equalsIgnoreCase("s")) {
                continuarJogando = false;
            }
        }

        progresso.setVitorias(contadorVitorias);
        progresso.setDerrotas(contadorDerrotas);
        progresso.setPartidasJogo(jogadas);
        rankingService.insertOrUpdateRanking(progresso);
        RankingRepository res = new RankingRepository();
        List<Map<String, Object>> rankings = res.listarRanking();
        for (Map<String, Object> ranking : rankings) {
            String nome = (String) ranking.get("NOME_JOGADOR");
            if (nome.equals(jogador.getNome())) {
                System.out.println(" ");
                System.out.println(" _______________________________________ ");
                System.out.println("|              PROGRESSO                |");
                System.out.println("|---------------------------------------|");
                System.out.println("|Partida: "+ranking.get("PARTIDAS_JOGADAS")+" | Derrota: "+ranking.get("DERROTAS")+" | Vitória: "+ranking.get("VITORIAS") + "  |");
                System.out.println("|_______________________________________|");
                System.out.println(" ");
            }
        }
    }

    public void realizarTentativa() throws Exception{
        while (jogador.getTentativasRestantes() > 0) {

            teclado.exibirTeclado();
            System.out.println(" ");
            System.out.println("Digite uma palavra que contenha 5 letras.");
            System.out.println(" ");
            jogador.setTentativasRestantes(jogador.getTentativasRestantes() - 1);
            System.out.println(jogador.getNome() + ", essa é sua tentativa número " + (6 - jogador.getTentativasRestantes()) + " de 6");
            System.out.println("Digite uma nova palavra:");
            String tentativa = scanner.nextLine().toUpperCase();

            PalavraExiste palavraExiste = new PalavraExiste();
            palavraExiste.verificarExistenciaPalavra(tentativa);

            if (palavraSecreta.tentativaCorreta(tentativa)) {
                System.out.println("Parabéns! Você acertou.");
                contadorVitorias++;
                break;
            } else if(tentativa.length() < 5 || tentativa.length() > 5){
                jogador.setTentativasRestantes(jogador.getTentativasRestantes() + 1);
                System.out.println("A palavra deve conter 5 letras. Digite novamente.");
                System.out.println("---------------------------------------------------------");
            } else if (!palavraExiste.isExiste()){
                jogador.setTentativasRestantes(jogador.getTentativasRestantes() + 1);
                System.out.println("A palavra digitada não existe no vocabulário brasileiro.");
                System.out.println("----------------------------------------------------------");
            } else {
                System.out.println(" ");
                exibirTentativaColorida(tentativa);
                System.out.println(" ");
                System.out.println("Tentativa incorreta.");
                System.out.println("Tentativas restantes: " + jogador.getTentativasRestantes());
                System.out.println("----------------------------------------------------------");
            }
        }
    }

    /**
     * Metodo usado para exibir os acertos e erros das palavras, o loop percorre cada caractere da palavra secreta
     * comparando com cada letra da palavra tentada.
     * No primeiro if ele compara se a letra existe e se ela esta na posição correta,
     * se estiver ele pinta o fundo de verde.
     * No if-else ele compara apenas se cada letra da palavra tentada exista na palavra secreta, se existir
     * ele pinta o fundo de vermelho
     * No else 71 ele conclui que a letra não está no local correto e não existe na palavra secreta
     * e pinta o fundo de preto
     */
    private void exibirTentativaColorida(String tentativa) throws Exception {
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < palavraSecreta.getPalavraSecreta().length(); i++) {
            String letraDaVez = String.valueOf(palavraSecreta.getPalavraSecreta().charAt(i));
            String letraTentada = String.valueOf(tentativa.charAt(i));

            if (letraDaVez.equals(letraTentada)) {
                teclado.setTeclaPosicaoCorreta(tentativa.charAt(i));
                resultado.append(cores.NEGRITO_TEXT.getCodes())
                        .append(cores.WHITE_TEXT.getCodes())
                        .append(cores.GREEN_BG.getCodes())
                        .append(letraTentada);
            } else if (palavraSecreta.getPalavraSecreta().contains(letraTentada)) {
                teclado.setTeclaPosicaoIncorreta(tentativa.charAt(i));
                resultado.append(cores.NEGRITO_TEXT.getCodes())
                        .append(cores.WHITE_TEXT.getCodes())
                        .append(cores.RED_BG.getCodes())
                        .append(letraTentada);
            } else {
                resultado.append(cores.NEGRITO_TEXT.getCodes())
                        .append(cores.WHITE_TEXT.getCodes())
                        .append(cores.BLACK_BG.getCodes())
                        .append(letraTentada);
            }
            resultado.append(" ");
            resultado.append(cores.RESET.getCodes());
        }
        System.out.println(resultado);
    }

}