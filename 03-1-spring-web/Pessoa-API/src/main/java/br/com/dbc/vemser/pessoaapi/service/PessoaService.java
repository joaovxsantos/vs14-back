package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository, ObjectMapper objectMapper) {
        this.pessoaRepository = pessoaRepository;
        this.objectMapper = objectMapper;
    }

    public PessoaDTO create(PessoaCreateDTO pessoaCreateDTO) {
        Pessoa pessoa = objectMapper.convertValue(pessoaCreateDTO, Pessoa.class);
        Pessoa savedPessoa = pessoaRepository.create(pessoa);
        return objectMapper.convertValue(savedPessoa, PessoaDTO.class);
    }

    public List<PessoaDTO> list() {
        return pessoaRepository.list().stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public PessoaDTO update(Integer id, PessoaCreateDTO pessoaAtualizar) throws Exception {
        Pessoa pessoa = objectMapper.convertValue(pessoaAtualizar, Pessoa.class);
        Pessoa pessoaRecuperada = getPessoa(id);

        pessoaRecuperada.setCpf(pessoa.getCpf());
        pessoaRecuperada.setNome(pessoa.getNome());
        pessoaRecuperada.setDataNascimento(pessoa.getDataNascimento());

        return objectMapper.convertValue(pessoaRecuperada, PessoaDTO.class);
    }

    public void delete(Integer id) throws Exception {
        Pessoa pessoaRecuperada = getPessoa(id);
        pessoaRepository.delete(pessoaRecuperada);
    }

    public List<PessoaDTO> listByName(String nome) {
        return pessoaRepository.listByName(nome).stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    private Pessoa getPessoa(Integer id) throws Exception {
        return pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Pessoa não encontrada!"));
    }
}
