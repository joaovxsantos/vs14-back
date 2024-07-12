package task05.src.Model;

public class Jogador extends Pessoa {
    private int tentativasRestantes;

    private Integer idJogador;


    public Jogador(String nome) {
        super(nome);
        this.tentativasRestantes = 6;
    }

    public void setIdJogador(Integer idJogador) {
        this.idJogador = idJogador;
    }

    public Integer getIdJogador() {
        return idJogador;
    }

    public Jogador() {
        super();
    }

    public int getTentativasRestantes() {
        return tentativasRestantes;
    }

    public void setTentativasRestantes(int tentativasRestantes) {
        this.tentativasRestantes = tentativasRestantes;
    }



    @Override
    public String toString() {
        return  "------------------------\n" +
                "ID: " + idJogador + " | Nome: " + getNome() + "\n" +
                "------------------------";
    }
}