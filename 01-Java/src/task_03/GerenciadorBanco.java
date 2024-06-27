package task_03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GerenciadorBanco {

    private List<ContaBancaria> contas;

    public GerenciadorBanco() {
        this.contas = new ArrayList<>();
    }

    public void adicionarConta(ContaBancaria conta) {
        contas.add(conta);
    }

    public void removerConta(String numeroConta) {
        ContaBancaria conta = buscarConta(numeroConta);
        if (conta != null) {
            this.contas.remove(conta);
        }
    }

    public ContaBancaria buscarConta(String numeroConta) {

        boolean contaExiste = false;

        for (ContaBancaria conta : contas) {
            if (conta.getNumeroConta().equals(numeroConta)) {
                contaExiste = true;
                return conta;
            }
        }

        if (!contaExiste) {
            System.out.println("\nConta não encontrada");
        }

        return null;
    }


    public void listarContas() {

        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta bancária encontrada");
        } else {
            for (ContaBancaria conta : contas) {
                System.out.println("Número da Conta: " + conta.getNumeroConta());
                System.out.println("Titular: " + conta.getTitular());
                System.out.println("Saldo: " + conta.getSaldo());
                System.out.println("----------------------");
            }
        }
    }
}
