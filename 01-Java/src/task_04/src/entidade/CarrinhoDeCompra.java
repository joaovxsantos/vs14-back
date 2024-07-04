package entidade;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompra {

    private Cliente client;
    private List<ItemCarrinho> itens = new ArrayList<>();
    private double total;

    public CarrinhoDeCompra(Cliente client, List<ItemCarrinho> itens, double total) {
        this.client = client;
        this.itens = itens;
        this.total = total;
    }

    public CarrinhoDeCompra() {

    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    public List<ItemCarrinho> getItens() {
        return itens;
    }

    public void setItens(List<ItemCarrinho> itens) {
        this.itens = itens;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
