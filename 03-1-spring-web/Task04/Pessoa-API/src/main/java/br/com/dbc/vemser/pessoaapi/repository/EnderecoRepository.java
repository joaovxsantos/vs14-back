package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.TipoEndereco;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class EnderecoRepository {
    private static List<Endereco> listaEnderecos = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public EnderecoRepository() {
        listaEnderecos.add(new Endereco(1, TipoEndereco.RESIDENCIAL, "Rua", 108, "Fundos", "21341250", "Rio de Janeiro", "RJ", "Brasil", COUNTER.incrementAndGet()));
        listaEnderecos.add(new Endereco(1, TipoEndereco.RESIDENCIAL, "Rua", 108, "Fundos", "21341250", "Rio de Janeiro", "RJ", "Brasil", COUNTER.incrementAndGet()));
        listaEnderecos.add(new Endereco(1, TipoEndereco.RESIDENCIAL, "Rua", 108, "Fundos", "21341250", "Rio de Janeiro", "RJ", "Brasil", COUNTER.incrementAndGet()));
        listaEnderecos.add(new Endereco(1, TipoEndereco.RESIDENCIAL, "Rua", 108, "Fundos", "21341250", "Rio de Janeiro", "RJ", "Brasil", COUNTER.incrementAndGet()));
        listaEnderecos.add(new Endereco(1, TipoEndereco.RESIDENCIAL, "Rua", 108, "Fundos", "21341250", "Rio de Janeiro", "RJ", "Brasil", COUNTER.incrementAndGet()));
    }

    public Endereco create(Integer id, Endereco endereco) {
        endereco.setId(COUNTER.incrementAndGet());
        endereco.setIdPessoa(id);
        listaEnderecos.add(endereco);
        return endereco;
    }

    public List<Endereco> list() {
        return listaEnderecos;
    }

    public void delete(Endereco endereco) {
        listaEnderecos.remove(endereco);
    }

    public List<Endereco>listById(Integer id) {
        return listaEnderecos.stream()
                .filter(endereco -> endereco.getId().equals(id))
                .collect(Collectors.toList());
    }

    public Endereco update(Endereco endereco, Endereco enderecoAtualizado) {
        endereco.setLogradouro(enderecoAtualizado.getLogradouro());
        endereco.setNumero(enderecoAtualizado.getNumero());
        endereco.setComplemento(enderecoAtualizado.getComplemento());
        endereco.setCep(enderecoAtualizado.getCep());
        endereco.setCidade(enderecoAtualizado.getCidade());
        endereco.setEstado(enderecoAtualizado.getEstado());
        endereco.setPais(enderecoAtualizado.getPais());
        endereco.setTipo(enderecoAtualizado.getTipo());

        return endereco;
    };
}
