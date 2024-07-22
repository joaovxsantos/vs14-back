package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDto;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDto;
import br.com.dbc.vemser.pessoaapi.dto.PessoaUpdateDto;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.excepction.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    private final ObjectMapper objectMapper;


    public PessoaService(PessoaRepository pessoaRepository, ObjectMapper objectMapper) {
        this.pessoaRepository = pessoaRepository;
        this.objectMapper = objectMapper;

    }

    public PessoaDto create(@Valid PessoaCreateDto pessoa) throws Exception {

        log.debug("Criando nova pessoa");


        Pessoa pessoaReturn = pessoaRepository.create(objectMapper.convertValue(pessoa, Pessoa.class));

        return objectMapper.convertValue(pessoaReturn, PessoaDto.class);

    }

    public List<PessoaDto> list(){

        List<Pessoa> pessoas = pessoaRepository.list();

        return pessoas.stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDto.class))
                .collect(Collectors.toList());
    }

    public PessoaDto update(Integer id, PessoaUpdateDto pessoaAtualizar) throws Exception {

        log.debug("Atualizando pessoa");

        return objectMapper.convertValue(pessoaRepository.update(
                objectMapper.convertValue(getPessoa(id), Pessoa.class).getIdPessoa(),
                objectMapper.convertValue(pessoaAtualizar, Pessoa.class)), PessoaDto.class);
    }

    public void delete(Integer id) throws Exception {

        log.debug("Deletando pessoa");

        pessoaRepository.delete(objectMapper.convertValue(getPessoa(id), Pessoa.class));
    }

    public List<PessoaDto> listByName(String nome) {

        List<Pessoa> pessoas = pessoaRepository.listByName(nome);
        List<PessoaDto> pessoaDtos = new ArrayList<>();
        for (Pessoa pessoa : pessoas) {
            pessoaDtos.add(objectMapper.convertValue(pessoa, PessoaDto.class));
        }

        return pessoaDtos;
    }

    public PessoaDto listById(Integer id) throws Exception {
        return objectMapper.convertValue(getPessoa(id), PessoaDto.class);
    }

    private Pessoa getPessoa(Integer id) throws Exception {
        Pessoa pessoaRecuperada = pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada!"));
        return pessoaRecuperada;
    }

}
