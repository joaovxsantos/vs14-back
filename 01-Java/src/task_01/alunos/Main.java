package task_01.alunos;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Digite a quantidade de alunos na turma: ");
        int quantAlunos = scanner.nextInt();

        for(int i = 0; i < quantAlunos; i++) {
            System.out.println("Digite o nome do aluno: ");
            String nomeAluno = scanner.next();

            System.out.println("Digite a primeira nota: ");
            float primeiraNota = scanner.nextFloat();

            System.out.println("Digite a segunda nota: ");
            float segundaNota = scanner.nextFloat();

            System.out.println("Digite a terceira nota: ");
            float terceiraNota = scanner.nextFloat();

            float media = (primeiraNota + segundaNota + terceiraNota) / 3;

            System.out.println("O aluno" + nomeAluno + " ficou com a média de: " + media);
        }
    }
}
