package task_03;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        GerenciadorBanco gerenciadorBanco = new GerenciadorBanco();
        ContaBancaria contaBancaria = new ContaBancaria();

        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        do {
            System.out.println("\nSistema Bancário");
            System.out.println("1 - Cadastrar novo cliente");
            System.out.println("2 - Depósito");
            System.out.println("3 - Saque");
            System.out.println("4 - Listar contas bancárias");
            System.out.println("5 - Remover conta bancária");
            System.out.println("6 - Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {


                case 1: {

                    System.out.print("Digite o número da conta: ");
                    String numeroConta = scanner.nextLine();

                    System.out.print("Digite o nome do titular: ");
                    String titular = scanner.nextLine();

                    System.out.print("Digite o saldo inicial: ");
                    double saldoInicial = scanner.nextDouble();

                    if (saldoInicial >= 0) {
                        scanner.nextLine();

                        contaBancaria = new ContaBancaria(numeroConta, titular, saldoInicial);
                        gerenciadorBanco.adicionarConta(contaBancaria);

                        System.out.println("Conta cadastrada com sucesso!");
                    } else {
                        System.out.println("\nNão é possível abrir uma conta com saldo negativo");
                    }

                    break;
                }
                case 2: {
                    System.out.print("Digite o número da conta: ");
                    String numeroConta = scanner.nextLine();

                    contaBancaria = gerenciadorBanco.buscarConta(numeroConta);

                    if (contaBancaria != null) {
                        System.out.print("Digite o valor do depósito: ");
                        contaBancaria.depositar(scanner.nextDouble());
                        System.out.println("\nSaldo atual: " + contaBancaria.getSaldo());
                    }
                    break;
                }
                case 3: {
                    System.out.print("Digite o número da conta: ");
                    String numeroConta = scanner.nextLine();

                    contaBancaria = gerenciadorBanco.buscarConta(numeroConta);

                    if (contaBancaria != null) {
                        System.out.print("Digite o valor do saque: ");
                        contaBancaria.sacar(scanner.nextDouble());
                        System.out.println("Saldo atual: " + contaBancaria.getSaldo());
                    }

                    break;
                }
                case 4: {
                    gerenciadorBanco.listarContas();
                    break;
                }

                case 5: {
                    System.out.print("Digite o número da conta: ");
                    String numeroConta = scanner.nextLine();

                    contaBancaria = gerenciadorBanco.buscarConta(numeroConta);

                    if (contaBancaria != null) {
                        gerenciadorBanco.removerConta(numeroConta);
                        System.out.println("\nConta removida com sucesso!");
                    } else {
                        System.out.println("Conta não encontrada");
                    }
                    break;
                }

                case 6: {
                    System.out.println("\nSaindo...");
                    break;
                }

                default: {
                    System.out.println("\nOpção inválida! Tente novamente");
                }
            }


        } while (opcao != 6);
    }
}