package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.*;
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


        Pessoa pessoaReturn = pessoaRepository.save(objectMapper.convertValue(pessoa, Pessoa.class));

        return objectMapper.convertValue(pessoaReturn, PessoaDto.class);

    }

    public List<PessoaDto> list(){

        List<Pessoa> pessoas = pessoaRepository.findAll();

        return pessoas.stream()
                .map(pessoa -> {
                    PessoaDto pessoaDto = objectMapper.convertValue(pessoa, PessoaDto.class);
                    pessoaDto.setPessoa(pessoa);
                    pessoaDto.setContatos(pessoa.getContatos());
                    pessoaDto.setEnderecos(pessoa.getEnderecos());
                    pessoaDto.setPets(pessoa.getPets());
                    return pessoaDto;
                })
                .collect(Collectors.toList());
    }

    public PessoaDto update(Integer id, PessoaUpdateDto pessoaAtualizar) throws Exception {

        log.info("Atualizando pessoa");



        Pessoa pessoaRecuperada = objectMapper.convertValue(pessoaAtualizar, Pessoa.class);
        pessoaRecuperada.setIdPessoa(id);


        return objectMapper.convertValue(pessoaRepository.save(
                pessoaRecuperada), PessoaDto.class);
    }

    public void delete(Integer id) throws Exception {

        log.debug("Deletando pessoa");

        pessoaRepository.delete(objectMapper.convertValue(getPessoa(id), Pessoa.class));
    }

    public List<PessoaDto> listByName(String nome) {

        List<Pessoa> pessoas = pessoaRepository.findByNome(nome);
        List<PessoaDto> pessoaDtos = new ArrayList<>();
        for (Pessoa pessoa : pessoas) {
            pessoaDtos.add(objectMapper.convertValue(pessoa, PessoaDto.class));
        }

        return pessoaDtos;
    }

    public PessoaDto listById(Integer id) throws Exception {
        Pessoa pessoa = pessoaRepository.findById(id).get();
        return objectMapper.convertValue(getPessoa(id), PessoaDto.class);
    }

    private Pessoa getPessoa(Integer id) throws Exception {
        Pessoa pessoaRecuperada = pessoaRepository.findAll().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada!"));
        return pessoaRecuperada;
    }


    // PESSOAS COM ENDEREÇO
    public List<PessoaDto> listInEndereco(Integer idPessoa) throws Exception {

        if (idPessoa != null) {

            Pessoa pessoaRecuperada = getPessoa(idPessoa);

            PessoaDto pessoaDTO = convertDto(pessoaRecuperada);
            pessoaDTO.setEnderecos(pessoaRecuperada.getEnderecos());
            pessoaDTO.setPessoa(pessoaRecuperada);

            if (pessoaDTO.getEnderecos() != null && !pessoaDTO.getEnderecos().isEmpty()) {
                return List.of(pessoaDTO);
            }

        }


        return pessoaRepository.findAll().stream()
                .filter(pessoa -> pessoa.getEnderecos() != null && !pessoa.getEnderecos().isEmpty())
                .map(pessoa -> {
                    PessoaDto pessoaDTO = objectMapper.convertValue(pessoa, PessoaDto.class);
                    pessoaDTO.setEnderecos(pessoa.getEnderecos());
                    pessoaDTO.setPessoa(pessoa);
                    return pessoaDTO;
                })
                .toList();
    }

    // PESSOAS COM CONTATO
    public List<PessoaDto> listInContatos(Integer idPessoa) throws Exception {

        if (idPessoa != null) {
            Pessoa pessoaRecuperada = getPessoa(idPessoa);
            PessoaDto pessoaDTO =  convertDto(pessoaRecuperada);
            pessoaDTO.setContatos(pessoaRecuperada.getContatos());
            pessoaDTO.setPessoa(pessoaRecuperada);

            if (pessoaDTO.getContatos() != null && !pessoaDTO.getContatos().isEmpty()) {
                return List.of(pessoaDTO);
            }
        }

        return pessoaRepository.findAll().stream()
                .filter(pessoa -> pessoa.getContatos() != null && !pessoa.getContatos().isEmpty())
                .map(pessoa -> {
                    PessoaDto pessoaDTO = objectMapper.convertValue(pessoa, PessoaDto.class);
                    pessoaDTO.setContatos(pessoa.getContatos());
                    pessoaDTO.setPessoa(pessoa);
                    return pessoaDTO;
                })
                .toList();
    }

    // PESSOAS COM PETS
    public List<PessoaDto> listInPets(Integer idPessoa) throws Exception {

        if (idPessoa != null) {
            Pessoa pessoaRecuperada = getPessoa(idPessoa);
            PessoaDto pessoaDTO =  convertDto(pessoaRecuperada);
            pessoaDTO.setPets(pessoaRecuperada.getPets());
            pessoaDTO.setPessoa(pessoaRecuperada);

            if (pessoaDTO.getPets() != null && !pessoaDTO.getPets().isEmpty()) {
                return List.of(pessoaDTO);
            }

        }

        return pessoaRepository.findAll().stream()
                .filter(pessoa -> pessoa.getPets() != null && !pessoa.getPets().isEmpty())
                .map(pessoa -> {
                    PessoaDto pessoaDTO = objectMapper.convertValue(pessoa, PessoaDto.class);
                    pessoaDTO.setPets(pessoa.getPets());
                    pessoaDTO.setPessoa(pessoa);
                    return pessoaDTO;
                })
                .toList();
    }

    public List<PessoaRelatorioDto> listEditada(Integer id) throws Exception {
        if (id != null) {
            return pessoaRepository.listAllId(id);
        }
        return pessoaRepository.findAllRelatorio();
    }

    public List<PessoaRelatorioDto> listTotal() {
        return pessoaRepository.findAllRelatorio();
    }

    private PessoaDto convertDto(Pessoa pessoa) {
        return objectMapper.convertValue(pessoa, PessoaDto.class);
    }

}
