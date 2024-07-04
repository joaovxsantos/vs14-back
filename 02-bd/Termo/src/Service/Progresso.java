package task05.src.Service;

import task05.src.Model.Jogador;

import java.util.ArrayList;
import java.util.List;

public class Progresso extends Jogador {
    private int partidasJogo;
    private int vitorias;
    private int derrotas;

    private static List<Progresso> todosJogadores = new ArrayList<>();

    public Progresso(String nome) {
        super(nome);
        this.derrotas = 0;
        this.vitorias = 0;
        this.partidasJogo = 0;
        todosJogadores.add(this);
    }

    public Progresso(String nome, int perdas, int vitorias, int partidasJogo) {
        super(nome);
        this.derrotas = perdas;
        this.vitorias = vitorias;
        this.partidasJogo = partidasJogo;
        todosJogadores.add(this);
    }

    public int getPartidasJogo() {
        return partidasJogo;
    }

    public void setPartidasJogo(int partidasJogo) {
        this.partidasJogo = partidasJogo;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int perdas) {
        this.derrotas = perdas;
    }

    public static List<Progresso> calcularRanking() {
        for (int i = 0; i < todosJogadores.size(); i++) {
            for (int j = i + 1; j < todosJogadores.size(); j++) {
                if (todosJogadores.get(i).getNome().equals(todosJogadores.get(j).getNome())) {
                    todosJogadores.get(i).setVitorias(todosJogadores.get(i).getVitorias() + todosJogadores.get(j).getVitorias());
                    todosJogadores.get(i).setDerrotas(todosJogadores.get(i).getDerrotas() + todosJogadores.get(j).getDerrotas());
                    todosJogadores.get(i).setPartidasJogo(todosJogadores.get(i).getPartidasJogo() + todosJogadores.get(j).getPartidasJogo());
                    todosJogadores.remove(j);
                    j--;
                }
            }
        }
        todosJogadores.sort((p1, p2) -> Integer.compare(p2.getVitorias(), p1.getVitorias()));
        return todosJogadores;
    }
}