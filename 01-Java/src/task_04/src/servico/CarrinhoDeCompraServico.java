package servico;

import entidade.CarrinhoDeCompra;
import entidade.Cliente;
import entidade.ItemCarrinho;
import entidade.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarrinhoDeCompraServico {
    Scanner sc = new Scanner(System.in);
    CarrinhoDeCompra carrinhoDeCompra = new CarrinhoDeCompra();
    List<ItemCarrinho> itens = new ArrayList<>();

    public void adicionarItem(Produto produto) {

        System.out.print("Digite a quantidade a ser adicionado: ");
        int quantidade = sc.nextInt();
        sc.nextLine();

        if ( produto.getQuantidadeProduto() >= quantidade){
            ItemCarrinho item = new ItemCarrinho(produto,quantidade);
            itens.add(item);
            produto.setQuantidadeProduto(produto.getQuantidadeProduto() - quantidade);
            atualizarTotal();
            System.out.println("Produto adicionado com sucesso" + produto.getNomeProduto());
        }else {
            System.out.println("Quantidade isuficiente em estoque para o produto" + produto.getNomeProduto());
        }
    }

    public void removerItem(Produto produto) {

        System.out.print("Digite a quantidade a ser adicionado: ");
        int quantidade = sc.nextInt();

        if (produto == null) {
            System.out.println("Produto não encontrado");
            return;
        }

        for (ItemCarrinho item : itens) {
            if (item.getProduto().getNomeProduto().equalsIgnoreCase(produto.getNomeProduto())) {
                if (item.getQuantidade() >= quantidade) {
                    item.setQuantidade(item.getQuantidade() - quantidade);
                    produto.setQuantidadeProduto(produto.getQuantidadeProduto() + quantidade);
                    if (item.getQuantidade() == 0) {
                        itens.remove(item);
                    }
                    atualizarTotal();
                    System.out.println("Produto removido com sucesso " + produto.getNomeProduto());
                } else {
                    System.out.println("Quantidade a ser removida é maior que a quantidade no carrinho.");
                }
                return;
            }

        }
        System.out.println("Produto não encontrado no carrinho: " + produto.getNomeProduto());

    }

    public void exibirCarrinho() {
        if (itens.isEmpty()) {
            System.out.println("Não há itens no carrinho.");
        } else {

            System.out.println("Itens no carrinho:");
            for (ItemCarrinho item : itens) {
                System.out.println("Produto: " + item.getProduto().getNomeProduto() +
                        ", Quantidade: " + item.getQuantidade() +
                        ", Preço Unitário: " + item.getProduto().getValorProduto());
            }
        }
    }

    public void finalizarCompra(Cliente cliente) {
        System.out.println("Subtotal: " + carrinhoDeCompra.getTotal());

        if (formaDePagamento()) {
            exibirCarrinho();
            reciboDePagamento(cliente);
            itens.clear();
            atualizarTotal();
        }
    }

    public boolean formaDePagamento() {
        System.out.println("Deseja realizar o pagamento? ");
        System.out.println("S para sim ");
        System.out.println("N para não");
        String opcao = sc.nextLine();

        if (opcao.equalsIgnoreCase("S")) {
            System.out.println("Pagamento realizado com sucesso");

        } else if (opcao.equalsIgnoreCase("N")) {
            System.out.println("Pagamento não realizado. Itens ainda no carrinho.");
            return false;
        } else {
            System.out.println("Opção invalida. Tente novamente");
            return false;
        }
        return true;
    }

    public void reciboDePagamento(Cliente cliente) {

        System.out.println("==========RECIBO==========");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("CPF: " + cliente.getCpf());
        System.out.println("---------------------------");
        System.out.println("Itens da compra");
        for (ItemCarrinho item : itens) {
            System.out.println(item.getProduto().getNomeProduto() +
                    " x " +
                    item.getQuantidade() +
                    " - R$" +
                    item.getProduto().getValorProduto() +
                    " cada");
        }
        System.out.println("--------------------------------");
        System.out.println("Total: " + carrinhoDeCompra.getTotal());
        System.out.println("Obrigado pala sua compra!");
        System.out.println("================================");
    }

    private void atualizarTotal() {

        double total = 0.0;

        for (ItemCarrinho item : itens) {
            total += item.getProduto().getValorProduto() * item.getQuantidade();
        }

        carrinhoDeCompra.setTotal(total);
    }
}
