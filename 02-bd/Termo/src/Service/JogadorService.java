package task05.src.Service;

import task05.src.Model.Jogador;
import task05.src.repository.JogadorRepository;
import task05.src.exceptions.BancoDeDadosException;

import java.util.List;

public class JogadorService {
    private JogadorRepository jogadorRepository;

    public JogadorService() {
        jogadorRepository = new JogadorRepository();
    }

    public void adicionarJogador(Jogador jogador) {
        try {
            jogadorRepository.adicionar(jogador);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }

    // remoção
    public void removerJogador(Integer id) {
        try {
            jogadorRepository.remover(id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    // atualização de um objeto
    public void editarJogador(Integer id, Jogador jogador) {
        try {
            jogadorRepository.editar(id, jogador);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    // leitura
    public void listar() {
        try {
            List<Jogador> listar = jogadorRepository.listar();
            listar.forEach(System.out::println);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    public Jogador buscarJogadorPorId(int id) {
        try {
            return jogadorRepository.buscarPorId(id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
        return null;
    }
}