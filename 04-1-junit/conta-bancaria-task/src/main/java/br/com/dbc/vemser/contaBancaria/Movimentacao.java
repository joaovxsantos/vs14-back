package br.com.dbc.vemser.contaBancaria;

public interface Movimentacao {
    boolean sacar(double valor);
    boolean depositar(double valor);
    boolean transferir(Conta conta, double valor);
}
