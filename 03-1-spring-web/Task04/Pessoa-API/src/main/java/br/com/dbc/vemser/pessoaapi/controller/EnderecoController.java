package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.excepction.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
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
    public ResponseEntity<Endereco> getEnderecoById(@PathVariable Integer idEndereco) throws RegraDeNegocioException {
        Endereco endereco = enderecoService.getEnderecoById(idEndereco);
        return ResponseEntity.ok(endereco);
    }

    @GetMapping("/pessoa/{idPessoa}")
    public ResponseEntity<List<Endereco>> getEnderecosByPessoaId(@PathVariable Integer idPessoa) {
        List<Endereco> enderecos = enderecoService.getEnderecosByPessoaId(idPessoa);
        return ResponseEntity.ok(enderecos);
    }


    @PostMapping("/{idPessoa}")
    public ResponseEntity<Endereco> createEndereco(@Valid @PathVariable Integer idPessoa, @RequestBody Endereco endereco) throws Exception {
        Endereco novoEndereco = enderecoService.createEndereco(idPessoa, endereco);
        return ResponseEntity.ok(novoEndereco);
    }


    @PutMapping("/{idContato}")
    public ResponseEntity<Endereco> updateEndereco(@Valid @PathVariable Integer idContato, @RequestBody Endereco endereco) throws Exception {
        Endereco enderecoAtualizado = enderecoService.updateEndereco(idContato, endereco);
        return ResponseEntity.ok(enderecoAtualizado);
    }

    @DeleteMapping("/{idEndereco}")
    public ResponseEntity<Void> deleteEndereco(@Valid @PathVariable Integer idEndereco) throws Exception {
        enderecoService.deleteEndereco(idEndereco);
        return ResponseEntity.ok().build();
    }
}
