package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoDto;
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


@RestController
@RequestMapping("/endereco")
public class EnderecoController {


    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }


    @GetMapping
    public ResponseEntity<List<EnderecoDto>> getAllEnderecos() {
        return new ResponseEntity<>(enderecoService.list(), HttpStatus.OK);
    }

    @GetMapping("/{idEndereco}")
    public ResponseEntity<EnderecoDto> getEnderecoById(@PathVariable Integer idEndereco) throws Exception {
        return new ResponseEntity<>(enderecoService.getEnderecoById(idEndereco), HttpStatus.OK);
    }

    @GetMapping("/pessoa/{idPessoa}")
    public ResponseEntity<List<EnderecoDto>> getEnderecosByPessoaId(@PathVariable Integer idPessoa) throws Exception {
        return new ResponseEntity<>(enderecoService.getEnderecosByPessoaId(idPessoa), HttpStatus.OK);
    }


    @PostMapping("/{idPessoa}")
    public ResponseEntity<EnderecoDto> createEndereco(@Valid @PathVariable Integer idPessoa, @RequestBody Endereco endereco) throws Exception {
       return new ResponseEntity<>(enderecoService.createEndereco(idPessoa, endereco), HttpStatus.OK);
    }


    @PutMapping("/{idContato}")
    public ResponseEntity<EnderecoDto> updateEndereco(@Valid @PathVariable Integer idContato, @RequestBody Endereco endereco) throws Exception {

        return new ResponseEntity<>(enderecoService.updateEndereco(idContato, endereco), HttpStatus.OK);
    }

    @DeleteMapping("/{idEndereco}")
    public ResponseEntity<Void> deleteEndereco(@Valid @PathVariable Integer idEndereco) throws Exception {
        enderecoService.deleteEndereco(idEndereco);
        return ResponseEntity.ok().build();
    }
}
