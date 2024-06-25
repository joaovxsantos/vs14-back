package task_01.produtos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do produto: ");
        String produtoNome = scanner.nextLine();

        System.out.println("Digite a descrição do produto: ");
        String produtoDescricao = scanner.nextLine();

        System.out.println("Digite o preço do produto: ");
        double produtoPreco = scanner.nextDouble();

        System.out.println("Digite a quantidade disponível em estoque: ");
        int produtoQuantidade = scanner.nextInt();

        System.out.println("Deseja aplicar um desconto percentual ao produto?\n1 - Sim \n2 - Não");
        int escolha = scanner.nextInt();

        if(escolha == 1) {
            System.out.println("Digite o valor percentual a ser aplicado como desconto: ");
            double descontoPorcentagem = scanner.nextDouble();
            double desconto = (descontoPorcentagem / 100) * produtoPreco;
            produtoPreco = produtoPreco - desconto;
        }

        System.out.println("Produto: " + produtoNome + "\nDescrição: " + produtoDescricao + "\nValor: R$ " + produtoPreco + "\nDisponível em estoque: " + produtoQuantidade);
    }
}
