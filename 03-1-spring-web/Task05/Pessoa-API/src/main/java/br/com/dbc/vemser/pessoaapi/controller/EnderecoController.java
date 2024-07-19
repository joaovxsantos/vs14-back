package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<List<Endereco>> getAllEnderecos() {
        return new ResponseEntity<>(enderecoService.getAllEnderecos(), HttpStatus.OK);
    }

    @GetMapping("/{idEndereco}")
    public ResponseEntity<Endereco> getEnderecoById(@PathVariable Integer idEndereco) {
        Endereco endereco = enderecoService.getEnderecoById(idEndereco);
        return ResponseEntity.ok(endereco);
    }

    @GetMapping("/pessoa/{idPessoa}")
    public ResponseEntity<List<Endereco>> getEnderecosByPessoaId(@PathVariable Integer idPessoa) {
        List<Endereco> enderecos = enderecoService.getEnderecosByPessoaId(idPessoa);
        return ResponseEntity.ok(enderecos);
    }

    @PostMapping("/{idPessoa}")
    public ResponseEntity<Endereco> createEndereco(@PathVariable Integer idPessoa, @RequestBody Endereco endereco) {
        Endereco novoEndereco = enderecoService.createEndereco(idPessoa, endereco);
        return ResponseEntity.ok(novoEndereco);
    }

    @PutMapping("/{idEndereco}")
    public ResponseEntity<Endereco> updateEndereco(@PathVariable Integer idEndereco, @RequestBody Endereco endereco) {
        Endereco enderecoAtualizado = enderecoService.updateEndereco(idEndereco, endereco);
        return ResponseEntity.ok(enderecoAtualizado);
    }

    @DeleteMapping("/{idEndereco}")
    public ResponseEntity<Void> deleteEndereco(@PathVariable Integer idEndereco) {
        enderecoService.deleteEndereco(idEndereco);
        return ResponseEntity.noContent().build();
    }
}
