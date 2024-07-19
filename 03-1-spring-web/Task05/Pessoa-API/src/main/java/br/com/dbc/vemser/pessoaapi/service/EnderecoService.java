package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public List<Endereco> getAllEnderecos() {
        return enderecoRepository.list();
    }

    public Endereco getEnderecoById(Integer idEndereco) {
        return enderecoRepository.list().stream().filter(e -> e.getIdPessoa().equals(idEndereco)).findFirst().orElse(null);
    }

    public List<Endereco> getEnderecosByPessoaId(Integer idPessoa) {
        return enderecoRepository.list().stream().filter(e -> e.getIdPessoa().equals(idPessoa)).collect(Collectors.toList());
    }

    public Endereco createEndereco(Integer idPessoa, Endereco endereco) {
        endereco.setIdPessoa(idPessoa);
        enderecoRepository.create(endereco);
        return endereco;
    }

    public Endereco updateEndereco(Integer idEndereco, Endereco enderecoAtualizado) {
        Endereco endereco = getEnderecoById(idEndereco);
        enderecoRepository.update(endereco, enderecoAtualizado);
        return endereco;
    }

    public void deleteEndereco(Integer idEndereco) {
        Endereco buscaEndereco = getEnderecoById(idEndereco);
        enderecoRepository.delete(buscaEndereco);
    }
}
