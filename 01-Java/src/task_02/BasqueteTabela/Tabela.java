package task_02.BasqueteTabela;

public class Tabela {

    String [] nomesTimesCasa = new String [100];
    int quantidadeJogos = 0;
    String [] nomesTimesVisitantes = new String [100];
    int [] pontuacaoTimesCasa = new int [100];
    int [] pontuacaoTimesVisitantes = new int [100];
    String [] datasJogos = new String [100];
    String [] times = new String [100];
    int quantidadeTimes = 0;
    int [] pontuacaoTimes = new int [100];

    public void adicionaJogos(String timeCasa, String timeVisitante, int pontuacaoCasa, int pontuacaoVisitante, String datajogo) {

        if (nomesTimesCasa[99] == null) {

            nomesTimesCasa[quantidadeJogos] = timeCasa;
            nomesTimesVisitantes[quantidadeJogos] = timeVisitante;
            pontuacaoTimesCasa[quantidadeJogos] = pontuacaoCasa;
            pontuacaoTimesVisitantes[quantidadeJogos] = pontuacaoVisitante;
            datasJogos[quantidadeJogos] = datajogo;

            quantidadeJogos++;

            System.out.println("\nJogo cadastrado com sucesso!");
        }else {
            System.out.println("Jogos maximos ja cadastrados");
        }
    }

    public void exibirJogos() {

        if(quantidadeJogos < 1) {
            System.out.println("\nNão há jogos.");
        }else {
            for (int i = 0; i < quantidadeJogos; i++) {

                System.out.println("\nJogo " + (i + 1) + ": ");
                System.out.println("\nTime Casa: " + nomesTimesCasa[i] +
                        "\nTime Visitante: " + nomesTimesVisitantes[i] +
                        "\nPontuação time casa: " + pontuacaoTimesCasa[i] +
                        "\nPontuação time visitante: " + pontuacaoTimesVisitantes[i] +
                        "\nData: " + datasJogos[i]);

            }
        }
    }

    public void timesDisponiveis() {

        for (int i = 0; i < quantidadeJogos; i++) {
            boolean casaBool = false;
            boolean visBool = false;

            for (int j = 0; j < quantidadeTimes; j++) {

                if (times[j] != null && times[j].equals(nomesTimesCasa[i])) {

                    casaBool = true;

                }
                if (times[j] != null && times[j].equals(nomesTimesVisitantes[i])) {

                    visBool = true;

                }
            }
            if (!casaBool) {

                times[quantidadeTimes] = nomesTimesCasa[i];
                quantidadeTimes++;

            }
            if (!visBool) {

                times[quantidadeTimes] = nomesTimesVisitantes[i];
                quantidadeTimes++;

            }
        }
    }

    public void pontuacaoTimes() {

        for (int i = 0; i < quantidadeTimes; i++) {

            for (int j = 0; j < quantidadeJogos; j++) {

                if (times[i].equals(nomesTimesCasa[j])) {

                    pontuacaoTimes[i] += pontuacaoTimesCasa[j];

                } else if (times[i].equals(nomesTimesVisitantes[j])) {

                    pontuacaoTimes[i] += pontuacaoTimesVisitantes[j];

                }
            }
        }
    }

    public void ordenacaoTabela() {

        for (int i = 0; i < quantidadeTimes - 1; i++) {

            int maxIndex = i;
            for (int j = i + 1; j < quantidadeTimes; j++) {

                if (pontuacaoTimes[j] > pontuacaoTimes[maxIndex]) {
                    maxIndex = j;
                }
            }

            int tempPontuacao = pontuacaoTimes[i];
            pontuacaoTimes[i] = pontuacaoTimes[maxIndex];
            pontuacaoTimes[maxIndex] = tempPontuacao;

            String tempTime = times[i];
            times[i] = times[maxIndex];
            times[maxIndex] = tempTime;

        }

        System.out.println("\nTabela de Pontuação: \n");

        for (int i = 0; i < quantidadeTimes; i++) {

            System.out.println((i + 1) + ". " + times[i] + " - " + pontuacaoTimes[i] + " pontos");

        }

    }

    public void buscarJogoTime(String time) {

        int jogos = 1;
        for (int i = 0; i < quantidadeJogos; i++) {
            if (nomesTimesCasa[i].equals(time) || nomesTimesVisitantes[i].equals(time)) {
                System.out.println("\nJogo " + (jogos) + " do " + time +  ": ");
                System.out.println("\nTime da Casa: " + nomesTimesCasa[i] +
                        "\nTime Visitante: " + nomesTimesVisitantes[i] +
                        "\nPontuação time da casa: " + pontuacaoTimesCasa[i] +
                        "\nPontuação time visitante: " + pontuacaoTimesVisitantes[i] +
                        "\nData: " + datasJogos[i]);
                jogos++;
            }
            if(jogos == 1) {
                System.out.println("Não foram encontrados jogos do time " + time + ".");
            }
        }

    }
}
