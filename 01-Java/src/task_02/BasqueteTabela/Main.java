package task_02.BasqueteTabela;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tabela tabela = new Tabela();
        boolean haJogos = false;

        int opcao;
        do {
            System.out.println("\nTabela campeonato de basquete\n" +
                    "1 - Inserir novo jogo\n" +
                    "2 - Exibir todos os jogos\n" +
                    "3 - Buscar jogos por time\n" +
                    "4 - Exibir classificação dos times\n" +
                    "5 - Sair");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:{

                    System.out.println("\nDigite o nome do time da casa: ");
                    String timeCasa = scanner.nextLine();

                    System.out.println("\nDigite o nome do time visitante: ");
                    String timeVisitante = scanner.nextLine();

                    System.out.println("\nDigite a pontuacao do time da casa: ");
                    int pontuacaoCasa = scanner.nextInt();
                    scanner.nextLine();


                    System.out.println("\nDigite a pontuacao do time visitante: ");
                    int pontuacaoVisitante = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("\nDigite a data do jogo (formato: dd/MM/yyyy): ");
                    String data = scanner.nextLine();

                    tabela.adicionaJogos(timeCasa, timeVisitante, pontuacaoCasa, pontuacaoVisitante, data);
                    haJogos = true;
                    break;
                }

                case 2:{
                    tabela.exibirJogos();
                    break;
                }

                case 3:{
                    if(!haJogos) {
                        System.out.println("\nNão há jogos.");
                    }else {
                        System.out.println("Digite o nome do time que deseja buscar: ");
                        tabela.buscarJogoTime(scanner.nextLine());
                    }
                    break;
                }

                case 4:{
                    if(!haJogos) {
                        System.out.println("\nNão há jogos.");
                    }else {
                        tabela.timesDisponiveis();
                        tabela.pontuacaoTimes();
                        tabela.ordenacaoTabela();
                    }
                    break;
                }

                case 5:{
                    System.out.println("Saindo...");
                }
            }


        } while (opcao != 5);

    }


}
