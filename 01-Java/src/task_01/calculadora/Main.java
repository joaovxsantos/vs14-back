package task_01.calculadora;
import java.util.Scanner;


public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Calculadora");
        System.out.println("Selecione uma operação:\n 1 - Adição\n 2 - Subtração\n 3 - Divisão\n 4 - Multiplicação\n 5 - Cálculo de área de um círculo\n 6 - Cálculo de área de um retângulo\n 7 - Cálculo de área de um triângulo\n 8 - Cálculo de diâmetro de um círculo ");

        int operacao = scanner.nextInt();

        switch (operacao) {
            case 1 :
                System.out.println("Digite o primeiro valor:");
                float num1 = scanner.nextFloat();
                System.out.println("Digite o segundo valor:");
                float num2 = scanner.nextFloat();
                System.out.print("Resultado da adição: " + (num1 + num2));
                break;
            case 2 :
                System.out.println("Digite o primeiro valor:");
                num1 = scanner.nextFloat();
                System.out.println("Digite o segundo valor:");
                num2 = scanner.nextFloat();
                System.out.print("Resultado da subtração: " + (num1 - num2));
                break;
            case 3 :
                System.out.println("Digite o primeiro valor:");
                num1 = scanner.nextFloat();
                System.out.println("Digite o segundo valor:");
                num2 = scanner.nextFloat();
                System.out.print("Resultado da divisão: " + (num1 / num2));
                break;
            case 4 :
                System.out.println("Digite o primeiro valor:");
                num1 = scanner.nextFloat();
                System.out.println("Digite o segundo valor:");
                num2 = scanner.nextFloat();
                System.out.print("Resultado da multiplicação: " + (num1 * num2));
                break;

            case 5:
                System.out.print("Digite  raio do circulo: ");
                float raio = scanner.nextFloat();
                System.out.print("Area do circulo: " + (3.14 * (raio * raio)));
                break;

            case 6:
                System.out.print("Digite a base do retângulo: ");
                float base = scanner.nextFloat();
                System.out.print("Digite a altura do retângulo: ");
                float altura = scanner.nextFloat();
                System.out.print("Area do retângulo: " + (base * altura));
                break;
            case 7:
                System.out.print("Digite a base do triângulo: ");
                base = scanner.nextFloat();
                System.out.print("Digite a altura do triângulo: ");
                altura = scanner.nextFloat();
                System.out.print("Area do triângulo: " + (base * altura) / 2);
                break;
            case 8:
                System.out.print("Digite  raio do circulo: ");
                raio = scanner.nextFloat();
                System.out.print("Diâmetro do circulo: " + (raio * 2));
                break;

            default:
                System.out.print("Escolha inválida.");
        }
    }
}
