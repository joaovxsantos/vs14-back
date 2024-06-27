package task_02.petshop;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        PetShop petShop = new PetShop();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nSistema de Gerencimento de PetShop");

            System.out.println(
                    "Opção 1 - Cadastrar novo Pet\n" +
                            "Opção 2 - Exibir todos os Pets\n" +
                            "Opção 3 - Buscar Pet pelo nome\n" +
                            "Opção 4 - Sair");

            opcao = scanner.nextInt();
            scanner.nextLine();
            opcoesMenu(opcao, scanner, petShop);
        }while (opcao != 4);

    }

    public static void opcoesMenu (int opcao, Scanner scanner, PetShop petShop) {
        switch (opcao) {
            case 1: {
                System.out.println("Digite o nome do Pet: ");
                String nomePet = scanner.nextLine();


                System.out.println("\nDigite o tipo do Pet: ");
                String tipoPet = scanner.nextLine();


                petShop.cadastrarPet(nomePet, tipoPet);

                break;
            }
            case 2: {
                petShop.exibirPet();
                break;
            }

            case 3: {
                System.out.println("Digite o nome do Pet: ");
                String nomePet = scanner.nextLine();

                petShop.buscarPet(nomePet);
                break;
            }

            case 4: {
                System.out.println("Saindo...");
                break;
            }

            default: {
                System.out.println("Opção inválida!");
            }
        }
    }
}