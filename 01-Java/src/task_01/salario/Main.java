package task_01.salario;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do funcionário:");
        String nomeFuncionario = scanner.nextLine();

        System.out.println("Digite o salário mensal do funcionário:");
        float salarioMensal = scanner.nextFloat();

        System.out.println("Digite o número de meses trabalhados no ano (1-12):");
        int mesesTrabalhados = scanner.nextInt();

        float salarioAnual = salarioMensal * mesesTrabalhados;

        System.out.print("Nome do funcionário: " + nomeFuncionario + "\nSalário anual: R$ " + salarioAnual);

    }
}
