package servico;


import entidade.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProdutoServico {

    private List<Produto> produtos;
    Scanner scanner = new Scanner(System.in);

    public ProdutoServico(){this.produtos = new ArrayList<>();}

    public void adicionarProduto() {
        System.out.println("Digite o nome do produto: ");
        String nomeProduto = scanner.nextLine();

        System.out.println("Digite o valor do produto");
        double valorProduto = scanner.nextDouble();

        scanner.nextLine();

        System.out.println("Digite a quantidade do produto: ");
        int quantidadeProduto = scanner.nextInt();

        scanner.nextLine();

        System.out.println("Digite o identificador do produto");
        int idProduto = scanner.nextInt();

        scanner.nextLine();

        Produto produto = new Produto(nomeProduto, idProduto, valorProduto, quantidadeProduto);
        produtos.add(produto);
        System.out.println("Produto adicionado com sucesso!");
    }


    public Produto buscarProduto(String nome) {
        for (Produto produto : produtos) {
                if (nome.equals(produto.getNomeProduto())) {
                    System.out.println("--------------------------------");
                    System.out.println(produto.getNomeProduto() + " #" + produto.getIdentificadorProduto());
                    System.out.println("Valor: R$ " + produto.getValorProduto());
                    System.out.println("Em estoque: " +  produto.getQuantidadeProduto());
                    System.out.println("--------------------------------");
                    return produto;
                }
            }
        return null;
    }

}