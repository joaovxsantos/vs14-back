package task05.src.Model;

import task05.src.Service.Cores;

import java.util.HashSet;

import java.util.Set;


public class Teclado {



    Cores cores;


    // Matriz do teclado
    private static final char[][] teclado = {
            {'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P'},
            {'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L'},
            {'Z', 'X', 'C', 'V', 'B', 'N', 'M'}
    };

    private Set<Character> teclaPosicaoCorreta = new HashSet<>();
    private Set<Character> teclaPosicaoIncorreta = new HashSet<>();

    public void setTeclaPosicaoCorreta(Character teclaPosicaoCorreta) {
        if (teclaPosicaoIncorreta.contains(teclaPosicaoCorreta))
            teclaPosicaoIncorreta.remove(teclaPosicaoCorreta);
        this.teclaPosicaoCorreta.add(teclaPosicaoCorreta);
    }

    public void setTeclaPosicaoIncorreta(Character teclaPosicaoIncorreta) {
        this.teclaPosicaoIncorreta.add(teclaPosicaoIncorreta);
    }

    public void exibirTeclado() {
        System.out.println("  ");
        System.out.println(" -----------------------------------------");
        System.out.println(" |          TECLADO VIRTUAL              |");
        System.out.println(" -----------------------------------------");
        for (char[] linha : teclado) {
            System.out.print(" ");
            for (char tecla : linha) {
                if (teclaPosicaoCorreta.contains(tecla)) {
                    System.out.print("| " + cores.ANSI_GREEN.getCodes() + tecla + cores.ANSI_RESET.getCodes() + " ");
                } else if (teclaPosicaoIncorreta.contains(tecla)) {
                    System.out.print("| " + cores.ANSI_RED.getCodes() + tecla + cores.ANSI_RESET.getCodes() + " ");
                } else {
                    System.out.print("| " + tecla + " ");
                }
            }
            System.out.println("|");
            System.out.print(" ");
            for (char tecla : linha) {
                System.out.print("|___");
            }
            System.out.println("|");
        }
    }

    public void resetarTeclado() {
        teclaPosicaoCorreta.clear();
        teclaPosicaoIncorreta.clear();
    }
}
