package task_03;

public class ContaBancaria {

    private String numeroConta;
    private String titular;
    private double saldo;


    public ContaBancaria(String numeroConta, String titular, double saldoInicial) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public ContaBancaria() {

    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public boolean sacar(double valor) {
        if (valor <= saldo) {
            this.saldo -= valor;
            return true;
        } else {
            System.out.println("\nVocê não pode sacar mais que o saldo atual da sua conta.");
        }
        return false;
    }
}