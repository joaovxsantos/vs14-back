package entidade;
public class Produto {

    private String nomeProduto;
    private int identificadorProduto;
    private double valorProduto;
    private int quantidadeProduto;


    public Produto(String nomeProduto, int identificadorProduto, double valorProduto, int quantidadeProduto) {
        this.nomeProduto = nomeProduto;
        this.identificadorProduto = identificadorProduto;
        this.valorProduto = valorProduto;
        this.quantidadeProduto = quantidadeProduto;
    }

    public Produto() {

    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getIdentificadorProduto() {
        return identificadorProduto;
    }

    public void setIdentificadorProduto(int identificadorProduto) {
        this.identificadorProduto = identificadorProduto;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }
}
