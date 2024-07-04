package task05.src.Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class PalavraSecreta {

    private String palavraSecreta;

    public String getPalavraSecreta() {
        return palavraSecreta;
    }

    public PalavraSecreta(String palavraSecreta) {
        this.palavraSecreta = palavraSecreta.toUpperCase();
    }

    // Método estático para sortear uma palavra secreta aleatória
    public static PalavraSecreta sortearPalavraSecreta() {
        Random random = new Random();
        int index = random.nextInt(addTexto().size());
        return new PalavraSecreta(addTexto().get(index));
    }

    // Método para verificar se a tentativa está correta
    public boolean tentativaCorreta(String tentativa) {
        return this.palavraSecreta.equalsIgnoreCase(tentativa);
    }

    /**
     * Lista de palavras reais para o jogo.
     * A ideia para esta implementação foi inspirada em:
     *https://www.devmedia.com.br/leitura-e-escrita-de-arquivos-de-texto-em-java/25529
     */
    public static ArrayList<String> addTexto() {
        ArrayList<String> palavras = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/palavras.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                palavras.add(linha);
            }
        } catch (IOException e) {
            System.err.println("Há um erro na leitura: " + e.getMessage());
        }
        if (!palavras.isEmpty()) {
            return palavras;
        }
        return null;
    }
}
