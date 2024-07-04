package servico;

import entidade.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ClienteServico {
    Scanner scanner = new Scanner(System.in);

    private List<Cliente> clientes;

    public ClienteServico(){
        this.clientes = new ArrayList<>();
    }

    public void adicionarCliente(){
        System.out.println("\nDados do cliente!");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();

        Cliente cliente = new Cliente(nome, cpf, idade);
        if (buscarCliente(cpf) == null){
            this.clientes.add(cliente);
            System.out.println("Cliente cadastrado com sucesso!");
        }else{
            System.out.print("Cliente já existe.");
        }
    }




    public Cliente buscarCliente(String cpf) {
        for (Cliente cliente : clientes) {
            if(cpf.equals(cliente.getCpf())) {
                System.out.println("Nome do cliente: " + cliente.getNome());
                System.out.println("CPF: " + cliente.getCpf());
                System.out.println("Idade: " + cliente.getIdade());
                System.out.println("----------------------");
                return cliente;
            }else {
                System.out.println("Cliente não encontrado!");
                return null;
            }
        }
        return null;
    }
}
