package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.TipoContato;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class ContatoRepository {
    private static List<Contato> listaContatos = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public ContatoRepository() {
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*1*/, 1, TipoContato.ofTipo(1), "12345678910", "Descrição Contato 1"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*2*/, 2, TipoContato.ofTipo(2), "12345678911", "Descrição Contato 2"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*3*/, 3, TipoContato.ofTipo(1), "12345678912", "Descrição Contato 3"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*4*/, 4, TipoContato.ofTipo(2), "12345678916", "Descrição Contato 4"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*5*/, 5, TipoContato.ofTipo(1), "12345678917", "Descrição Contato 5"));
    }

    public Contato create(Contato contato) {
        contato.setIdContato(COUNTER.incrementAndGet());
        listaContatos.add(contato);
        return contato;
    }

    public List<Contato> list() {
        return listaContatos;
    }

    public void delete(Contato contato) {
        listaContatos.remove(contato);
    }

    public List<Contato> listByIdPessoa(String nome) {
        return listaContatos.stream()
                .filter(contato -> contato.getDescricao().toUpperCase().contains(nome.toUpperCase()))
                .collect(Collectors.toList());
    }


}
