package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.EmailService;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDto;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDto;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoUpdateDto;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDto;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.excepction.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class EnderecoService {

    private final PessoaRepository pessoaRepository;
    private final EnderecoRepository enderecoRepository;
    private final ObjectMapper objectMapper;
    private final EmailService emailService;



public EnderecoDto create(Integer idPerson, @Valid EnderecoCreateDto endereco) throws Exception {
    log.debug("Criando endereco: {}", endereco);

    Pessoa pessoa = pessoaRepository.findById(idPerson).orElseThrow(() -> new RegraDeNegocioException("Pessoa de id informado não encontrado"));

    Endereco enderecoEx = objectMapper.convertValue(endereco, Endereco.class);

    Endereco enderecoEntity = enderecoRepository.save(enderecoEx);

    EnderecoDto enderecoSalvo = objectMapper.convertValue(enderecoEntity, EnderecoDto.class);
    enderecoSalvo.setPessoa(pessoa);

    return enderecoSalvo;
}

    public List<EnderecoDto> list() {
//        emailService.sendSimpleMessage();

        return enderecoRepository.findAll()
                .stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDto.class))
                .collect(Collectors.toList());
    }

    public EnderecoDto update(Integer id, EnderecoUpdateDto enderecoAtualizar) throws Exception {
        log.debug("Atualizando endereco: {}", enderecoAtualizar);

        Endereco enderecoRecuperado = getEndereco(id);

        enderecoRecuperado.setLogradouro(enderecoAtualizar.getLogradouro());
        enderecoRecuperado.setTipo(enderecoAtualizar.getTipo());
        enderecoRecuperado.setNumero(enderecoAtualizar.getNumero());
        enderecoRecuperado.setComplemento(enderecoAtualizar.getComplemento());
        enderecoRecuperado.setCep(enderecoAtualizar.getCep());
        enderecoRecuperado.setCidade(enderecoAtualizar.getCidade());
        enderecoRecuperado.setEstado(enderecoAtualizar.getEstado());
        enderecoRecuperado.setPais(enderecoAtualizar.getPais());


        //salvando no banco
        enderecoRepository.save(enderecoRecuperado);

//        emailService.getContentFromTemplate("eu", pessoaService.listById(enderecoAtualizar.getIdPessoa()));
        return objectMapper.convertValue(enderecoRecuperado, EnderecoDto.class);
    }
//
    public void delete(Integer id) throws Exception {
        log.debug("Endereço deletado : {}", id);
        Endereco  endereco = getEndereco(id);
//        emailService.getContentFromTemplate("ed", pessoaService.listById(endereco.getIdPessoa()));
        enderecoRepository.delete(endereco);
    }


    public EnderecoDto getEnderecoById(int id) throws Exception {
        return objectMapper.convertValue(getEndereco(id), EnderecoDto.class);

    }

    private Endereco getEndereco(Integer id) throws Exception {
        return enderecoRepository.findById(id).get();
    }

    private EnderecoDto convertEntityToDTO(Endereco endereco) {
        return objectMapper.convertValue(endereco, EnderecoDto.class);
    }

}
