package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoDto;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDto;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.excepction.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class EnderecoService {

    private final PessoaService pessoaService;
    private final EnderecoRepository enderecoRepository;
    private final ObjectMapper objectMapper;

    public EnderecoService(EnderecoRepository enderecoRepository, PessoaService pessoaService, ObjectMapper objectMapper){
        this.enderecoRepository = enderecoRepository;
        this.pessoaService = pessoaService;
        this.objectMapper = objectMapper;
    }

    public EnderecoDto createEndereco(Integer idPerson, Endereco endereco) throws Exception {

        log.debug("Criando endereco: {}", endereco);

        PessoaDto pessoa = pessoaService.listById(idPerson);


        Endereco enderecoEx = objectMapper.convertValue(endereco, Endereco.class);

        enderecoEx.setIdPessoa(pessoa.idPessoa());

        Endereco enderecoEntity = enderecoRepository.create(enderecoEx);

        return objectMapper.convertValue(enderecoEntity, EnderecoDto.class);
    }

    public List<EnderecoDto> list() {

        return enderecoRepository.list()
                .stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDto.class))
                .collect(Collectors.toList());
    }

    public EnderecoDto updateEndereco(Integer id, Endereco enderecoAtualizar) throws Exception {

        log.debug("Atualizando endereco: {}", enderecoAtualizar);


        enderecoRepository.update(getEndereco(id), objectMapper.convertValue(enderecoAtualizar, Endereco.class));

        return objectMapper.convertValue(enderecoAtualizar, EnderecoDto.class);
    }

    public void deleteEndereco(Integer id) throws Exception {
        log.debug("Endereço deletado : {}", id);
        Endereco  endereco = getEndereco(id);
        enderecoRepository.delete(endereco);
    }

    public List<EnderecoDto> getEnderecosByPessoaId(int id) throws Exception {

        pessoaService.listById(id);

        List<Endereco> enderecos = enderecoRepository.list().stream().filter(endereco -> endereco.getIdPessoa().equals(id)).toList();

        return enderecos.stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, EnderecoDto.class))
                .collect(Collectors.toList());
    }

    public EnderecoDto getEnderecoById(int id) throws Exception {
        return objectMapper.convertValue(getEndereco(id), EnderecoDto.class);
    }

    private Endereco getEndereco(Integer id) throws Exception {
        return enderecoRepository.list().stream()
                .filter(endereco -> endereco.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrado!"));
    }

}
