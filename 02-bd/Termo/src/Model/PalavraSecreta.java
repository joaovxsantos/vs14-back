package task05.src.Model;

import task05.src.repository.PalavrasRepository;

import java.sql.SQLException;

public class PalavraSecreta {

    private String palavraSecreta;

    public String getPalavraSecreta() {
        return palavraSecreta;
    }

    public PalavraSecreta(String palavraSecreta) {
        this.palavraSecreta = palavraSecreta;
    }

    public static PalavraSecreta sortearPalavraSecreta() throws SQLException {
        String palavraSorteada = addTexto();
        return new PalavraSecreta(palavraSorteada);
    }

    private static String addTexto() throws SQLException {
        PalavrasRepository repository = new PalavrasRepository();
        return repository.getPalavra();
    }

    // Método para verificar se a tentativa está correta
    public boolean tentativaCorreta(String tentativa) {
        return this.palavraSecreta.equalsIgnoreCase(tentativa);
    }
}
