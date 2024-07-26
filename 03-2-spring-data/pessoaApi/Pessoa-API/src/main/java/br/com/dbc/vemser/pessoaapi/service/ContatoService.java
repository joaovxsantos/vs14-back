package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDto;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDto;
import br.com.dbc.vemser.pessoaapi.dto.ContatoUpdateDto;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.excepction.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ContatoService {

    private final ContatoRepository contatoRepository;

    private final PessoaService pessoaService;

    private final ObjectMapper objectMapper;

    public ContatoService(ContatoRepository contatoRepo, PessoaService pessoaService, ObjectMapper objectMapper){
        this.contatoRepository = contatoRepo;
        this.pessoaService = pessoaService;
        this.objectMapper = objectMapper;
    }

    public ContatoDto create(ContatoCreateDto contato) throws Exception {


        pessoaService.listById(contato.idPessoa());

        log.debug("Criando contato: {}", contato);

        Contato contatoEntity = contatoRepository.save(objectMapper.convertValue(contato, Contato.class));

        return objectMapper.convertValue(contatoEntity, ContatoDto.class);
    }

    public List<ContatoDto> list(){
        System.out.println(contatoRepository.findAll());
        return contatoRepository.findAll().stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoDto.class))
                .collect(Collectors.toList());
    }

    public ContatoDto update(Integer id, @Valid ContatoUpdateDto contatoAtualizar) throws Exception {

        pessoaService.listById(contatoAtualizar.idPessoa());

        log.debug("Atualizando contato: {}", contatoAtualizar);

        Contato contatoRecuperado = objectMapper.convertValue(contatoAtualizar, Contato.class);
       contatoRecuperado.setIdContato(id);


        return objectMapper.convertValue(contatoRepository.save(contatoRecuperado), ContatoDto.class);
    }

    public void delete(Integer id) throws Exception {

        log.debug("Deletando contato: {}", id);

        contatoRepository.delete(getContato(id));
    }

    public List<ContatoDto> listId(int id) throws Exception {

        pessoaService.listById(id);

        List<Contato> contatos =  contatoRepository.findAll().stream().filter(contato -> contato.getIdContato() == id).toList();

        return contatos.stream().map(contato -> objectMapper.convertValue(contato, ContatoDto.class)).collect(Collectors.toList());
    }

    public ContatoDto listById(Integer id) throws Exception {
        return objectMapper.convertValue(getContato(id), ContatoDto.class);
    }

    private Contato getContato(Integer id) throws Exception {
        Contato contatoRecuperada = contatoRepository.findAll().stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado!"));

        return contatoRecuperada;
    }

}
