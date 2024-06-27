package task_02;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Papelaria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do produto");
        String nome = scanner.nextLine();

        System.out.println("Digite o valor do produto");
        float valor = scanner.nextFloat();

        montarTabela(nome, valor);
    }

    private static void montarTabela(String nome, float preco) {

        float desconto = 5.0f/100.0f * 2.0f;

        limpa();

        System.out.println("Promoção de " + nome + ":\n");

        for (int i = 1; i <= 10; i++) {

            float valorUnitario = preco - desconto * i;

            DecimalFormat df = new DecimalFormat("0.00");
            System.out.println(i +" x R$"  + df.format(valorUnitario) + " = R$" + df.format(valorUnitario * i));
        }
    }

    public static void limpa() {
        for(int i = 1; i <= 80; i++) {

            System.out.println("");

        }
    }
}