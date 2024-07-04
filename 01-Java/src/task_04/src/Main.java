import entidade.Cliente;
import entidade.Produto;
import servico.CarrinhoDeCompraServico;
import servico.ClienteServico;
import servico.ProdutoServico;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClienteServico clienteServico = new ClienteServico();
        ProdutoServico produtoServico = new ProdutoServico();
        Produto produto = new Produto();
        CarrinhoDeCompraServico carrinhoDeCompraServico = new CarrinhoDeCompraServico();

        Scanner scanner = new Scanner(System.in);
        int opt = 0;
        int optMenuCliente = 0;
        int optMenuProduto = 0;
        int optMenuCarrinho = 0;

        do {
            System.out.println("1. Menu de gerenciamento de cliente.");
            System.out.println("2. Menu de produtos.");
            System.out.println("3. Menu de compra.");
            System.out.println("4. Sair.");
            opt = scanner.nextInt();
            scanner.nextLine();

            switch (opt) {
                case 1:
                    do {
                        System.out.println("1. Cadastrar cliente.");
                        System.out.println("2. Voltar.");
                        optMenuCliente = scanner.nextInt();
                        scanner.nextLine();

                        switch (optMenuCliente){
                            case 1:
                                clienteServico.adicionarCliente();
                                break;
                            case 2:
                                System.out.println("Voltando...");
                                break;
                            default:
                                System.out.println("\nOpção inválida! Tente novamente.");
                        }
                    }while (optMenuCliente != 2);
                    break;
                case 2:
                    do {
                        System.out.println("1. Adicionar produto.");
                        System.out.println("2. Sair.");
                        optMenuProduto = scanner.nextInt();
                        scanner.nextLine();

                        switch (optMenuProduto){
                            case 1:
                                produtoServico.adicionarProduto();
                                break;
                            case 2:
                                System.out.println("Voltando...");
                                break;
                            default:
                                System.out.println("Opção inválida! Tente novamente.");
                        }
                    }while (optMenuProduto != 2);
                    break;
                case 3:
                    do {
                        System.out.println("\nAcessar o carrinho de compras");
                        System.out.println("            ");
                        System.out.println("1 - Adicionar produto ao carrinho");
                        System.out.println("2 - Remover um produto do carrinho");
                        System.out.println("3 - Visualizar Carrinho");
                        System.out.println("4 - Ir para o pagamento");
                        System.out.println("5 - Voltar");

                        optMenuCarrinho = scanner.nextInt();
                        scanner.nextLine();

                        switch(optMenuCarrinho) {
                            case 1:
                                System.out.println("Qual produto você quer adicionar");
                                String nomeProduto = scanner.nextLine();

                                produto = produtoServico.buscarProduto(nomeProduto);

                                if (produto == null){
                                    System.out.println("Produto não encontrado");
                                    return;
                                }
                                carrinhoDeCompraServico.adicionarItem(produto);
                                break;

                            case 2:
                                System.out.println("Qual produto você quer remover? ");
                                nomeProduto = scanner.nextLine();

                                produto = produtoServico.buscarProduto(nomeProduto);
                                carrinhoDeCompraServico.removerItem(produto);
                                break;
                            case 3:
                                carrinhoDeCompraServico.exibirCarrinho();
                                break;
                            case 4:
                                System.out.println("Digite seu cpf");
                                String cpf = scanner.nextLine();

                                Cliente cliente = clienteServico.buscarCliente(cpf);
                                carrinhoDeCompraServico.finalizarCompra(cliente);
                                break;
                            case 5:
                                System.out.println("\nVoltando...");
                                break;
                            default:
                                System.out.println("Opção inválida! Tente novamente");
                        }
                    }while(optMenuCarrinho != 5);
                    break;
                case 4:
                    System.out.println("\nSaindo ...");
                    break;
                default:
                    System.out.println("\nOpção inválida! Tente Novamente");
            }
        }while (opt != 4);

    }
}

