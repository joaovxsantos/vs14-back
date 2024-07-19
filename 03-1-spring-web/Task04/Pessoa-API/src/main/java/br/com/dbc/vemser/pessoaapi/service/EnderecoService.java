package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.excepction.RegraDeNegocioException;
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

    public Endereco getEnderecoById(Integer idEndereco) throws RegraDeNegocioException {




        return enderecoRepository.list().stream().filter(e -> e.getId().equals(idEndereco)).findFirst().orElseThrow(()-> new RegraDeNegocioException("Endereço não encontrado"));
    }


    public List<Endereco> getEnderecosByPessoaId(Integer idPessoa) {

        return enderecoRepository.list().stream().filter(e -> e.getIdPessoa().equals(idPessoa)).collect(Collectors.toList());
    }

    public Endereco createEndereco(Integer idPessoa, Endereco endereco) throws Exception {
        Boolean isValid = getPessoa(idPessoa);

        if(!isValid) {
            throw  new RegraDeNegocioException("Pessoa não encontrada! ");
        }

        return enderecoRepository.create(idPessoa, endereco);
    }

    public Endereco updateEndereco(Integer idEndereco, Endereco enderecoAtualizado) throws Exception {
        Endereco endereco = getEnderecoById(idEndereco);

        return enderecoRepository.update(endereco, enderecoAtualizado);
    }

    public void deleteEndereco(Integer idEndereco) throws Exception {

        Endereco buscaEndereco = getEndereco(idEndereco);
        enderecoRepository.delete(buscaEndereco);
    }

    private Endereco getEndereco(Integer id) throws Exception {

        Endereco enderecoRecuperado = enderecoRepository.list().stream()
                .filter(endereco -> endereco.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada!"));
        return enderecoRecuperado;
    }

    private Boolean getPessoa(Integer id) throws Exception {
        return enderecoRepository.list().stream().anyMatch(endereco -> endereco.getIdPessoa().equals(id));
    }
}