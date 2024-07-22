package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.TipoContato;
import org.springframework.stereotype.Repository;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class ContatoRepository {

    private static List<Contato> listaContatos = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public ContatoRepository() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //18/10/2020
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*1*/, 1, TipoContato.COMERCIAL, "12345678910", "pop"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*2*/, 2, TipoContato.RESIDENCIAL, "12345678911", "agro"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*3*/, 3, TipoContato.COMERCIAL, "12345678912", "tech"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*4*/, 4, TipoContato.RESIDENCIAL, "12345678916", "tudo"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*5*/, 5, TipoContato.RESIDENCIAL, "12345678917", "liso"));
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

    public List<Contato> listByIdPerson(int id) {
        return listaContatos.stream()
                .filter(contato -> contato.getIdPessoa() == id)
                .collect(Collectors.toList());
    }

    public Contato update(Contato contatoRecuperado, Contato contatoAtualizar) {

        contatoRecuperado.setIdPessoa(contatoAtualizar.getIdPessoa());
        contatoRecuperado.setDescricao(contatoAtualizar.getDescricao());
        contatoRecuperado.setNumero(contatoAtualizar.getNumero());

        return contatoRecuperado;
    }
}
