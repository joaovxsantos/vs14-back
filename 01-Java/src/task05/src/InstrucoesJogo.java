package task05.src;

public class InstrucoesJogo {
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";

  public static void mostrarInstrucoes() {
    System.out.println(
              " \n" +
              "                    _____ _____ ____  __  __  ___  \n" +
              "                   |_   _| ____|  _ \\|  \\/  |/ _ \\ \n" +
              "                     | | |  _| | |_) | |\\/| | | | |\n" +
              "                     | | | |___|  _ <| |  | | |_| |\n" +
              "                     |_| |_____|_| \\_\\_|  |_|\\___/ ");
    System.out.println(" ");
    System.out.println(
                    "***************************************************************************\n" +
                    "*                                                                         *\n" +
                    "*                **************************************                   *\n" +
                    "*                *      Instruções do Jogo TERMO      *                   *\n" +
                    "*                **************************************                   *\n" +
                            "*                                                                         *\n" +
                    "* No jogo TERMO, você precisa descobrir uma palavra certa em 6 tentativas.*\n" +
                    "*                                                                         *\n" +
                    "* A palavra é escolhida aleatoriamente pelo jogo e contém 5 letras.       *\n" +
                    "*                                                                         *\n" +
                    "* Digite uma palavra e o jogo mostrará quais letras existem e se estão na *\n" +
                    "* posição correta.                                                        *\n" +
                    "*                                                                         *\n" +
                    "* As letras que estão na palavra, mas não estão na posição correta,       *\n" +
                    "* ficarão na cor " + ANSI_RED + "VERMELHA" + ANSI_RESET + ".                                                 *\n" +
                    "*                                                                         *\n" +
                    "* As letras que estão na palavra e na posição correta são mostradas       *\n" +
                    "* com a cor " + ANSI_GREEN + "VERDE" + ANSI_RESET + ".                                                        *\n" +
                    "*                                                                         *\n" +
                    "* Se você acertar a palavra, você vence o jogo.                           *\n" +
                    "* Lembre-se, você tem 6 tentativas para acertar a palavra.                *\n" +
                    "*                                                                         * \n" +
                    "*                          BOA SORTE !                                    *\n" +
                    "***************************************************************************" +
            "  \n"
    );
  }
}
