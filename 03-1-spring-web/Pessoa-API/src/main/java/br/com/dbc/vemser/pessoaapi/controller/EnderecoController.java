package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;


    @GetMapping
    public ResponseEntity<List<Endereco>> getAllEnderecos() {
        log.info("Pegando todos os enredeços");
        return new ResponseEntity<>(enderecoService.getAllEnderecos(), HttpStatus.OK);
    }

    @GetMapping("/{idEndereco}")
    public ResponseEntity<Endereco> getEnderecoById(@PathVariable Integer idEndereco) {
        log.info("Pegando endereço através do ID");
        Endereco endereco = enderecoService.getEnderecoById(idEndereco);
        return ResponseEntity.ok(endereco);
    }

    @GetMapping("/pessoa/{idPessoa}")
    public ResponseEntity<List<Endereco>> getEnderecosByPessoaId(@PathVariable Integer idPessoa) {
        log.info("Pegando endereço da Pessoa");
        List<Endereco> enderecos = enderecoService.getEnderecosByPessoaId(idPessoa);
        return ResponseEntity.ok(enderecos);
    }

    @PostMapping("/{idPessoa}")
    public ResponseEntity<Endereco> createEndereco(@PathVariable Integer idPessoa, @RequestBody Endereco endereco) {
        log.info("Atualizando endereço da pessoa");
        Endereco novoEndereco = enderecoService.createEndereco(idPessoa, endereco);
        return ResponseEntity.ok(novoEndereco);
    }

    @PutMapping("/{idEndereco}")
    public ResponseEntity<Endereco> updateEndereco(@PathVariable Integer idEndereco, @RequestBody Endereco endereco) {
        log.info("Criando endereço");
        Endereco enderecoAtualizado = enderecoService.updateEndereco(idEndereco, endereco);
        return ResponseEntity.ok(enderecoAtualizado);
    }

    @DeleteMapping("/{idEndereco}")
    public ResponseEntity<Void> deleteEndereco(@PathVariable Integer idEndereco) {
        enderecoService.deleteEndereco(idEndereco);
        log.info("Deletando endereço");
        return ResponseEntity.noContent().build();
    }
}
