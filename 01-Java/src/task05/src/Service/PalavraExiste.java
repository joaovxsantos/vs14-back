package task05.src.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class PalavraExiste {
    private boolean existe;

    public PalavraExiste() {}

    /**
     * Esta função verifica a existência de uma palavra no dicionário.
     * A ideia para esta implementação foi inspirada em:
     * https://simplificandoredes.com/http-requisicoes-get-post-api-java/
     */

    public void verificarExistenciaPalavra(String palavra) throws IOException, InterruptedException {
        String urlStr = "https://api.dicionario-aberto.net/word/" + palavra.toLowerCase();
        HttpClient httpClient = HttpClient.newBuilder().build();
        // criar a requisição.
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .timeout(Duration.ofSeconds(10))
                .uri(URI.create(urlStr))
                .build();

        // enviando uma solicitação.
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        setExiste(parseNomeFromJson(response.body()));
        String b = response.body();
        System.out.println("Palavra: " + palavra);
    }

    private boolean parseNomeFromJson(String json) {
        // Realizar análise manual do JSON.
        // Verifica se o JSON contém a chave.
        String keyword = "\"word\":";
        int startIndex = json.indexOf(keyword);
        if (startIndex == -1) {
            return false;
        }

        // Move o índice para o início do valor após a chave.
        startIndex += keyword.length();

        // Encontra o final do valor.
        int endIndex = json.indexOf(",", startIndex);
        if (endIndex == -1) {
            endIndex = json.indexOf("}", startIndex);
        }

        if (startIndex < endIndex) {
            // Extrai o valor, removendo aspas e espaços extras.
            String word = json.substring(startIndex, endIndex).replace("\"", "").trim();
            return true;
        } else {
            return false;
        }
    }

    public boolean isExiste() {
        return existe;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }
}
