package task_01.jogo;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a hora e minutos de início do jogo\n");
        System.out.println("Hora: ");
        int horaInicial = scanner.nextInt();
        System.out.println("Minutos: ");
        int minutoInicial = scanner.nextInt();


        System.out.println("Digite a hora e minutos de termino do jogo\n");
        System.out.println("Hora: ");
        int horaFinal = scanner.nextInt();
        System.out.println("Minutos: ");
        int minutoFinal = scanner.nextInt();


        int inicioMinutos = horaInicial * 60 + minutoInicial;
        int finalMinutos = horaFinal * 60 + minutoFinal;

        int duracaoEmMinutos =  finalMinutos - inicioMinutos;

        int duracaoHoras = duracaoEmMinutos / 60;
        int duracaoMinutos = duracaoEmMinutos % 60;

        System.out.println("Duração do jogo: " + duracaoHoras + " horas e " + duracaoMinutos + " minutos.");
    }
}
