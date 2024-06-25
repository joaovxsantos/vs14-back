package task_01.votos;

import java.util.Scanner;

public class ComputarVotos {
    static Scanner scanner = new Scanner(System.in);

    public static void totalVotos() {
            System.out.print("Eleições Municipais!\n");
            System.out.println("Digite o total de votos válidos: ");
            int votosValidos = scanner.nextInt();
            System.out.println("Digite o total de votos brancos: ");
            int votosBrancos = scanner.nextInt();
            System.out.println("Digite o total de votos nulos: ");
            int votosNulos = scanner.nextInt();

            int totalVotos = votosValidos + votosBrancos + votosNulos;

        int votosValidosPorcentagem = (votosValidos * 100) / totalVotos;
        int votosBrancosPorcentagem = (votosBrancos * 100) / totalVotos;
        int votosNulosPorcentagem = (votosNulos * 100) / totalVotos;

            System.out.print("Total de votos: " + totalVotos + "\nVotos válidos: " + votosValidos + " (" + votosValidosPorcentagem + "%)" + "\nVotos brancos: " + votosBrancos + " (" + votosBrancosPorcentagem + "%)" + "\nVotos nulos: " + votosNulos + " (" + votosNulosPorcentagem + "%)");
    }
}

