package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDto;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDto;
import br.com.dbc.vemser.pessoaapi.dto.PessoaUpdateDto;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;



@RestController
@RequestMapping("/pessoa") // localhost:8080/pessoa
public class PessoaController {



    private final PessoaService pessoaService;



    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }


    @GetMapping // GET localhost:8080/pessoa
    public ResponseEntity<List<PessoaDto>> list() {
        return new ResponseEntity<>(pessoaService.list(), HttpStatus.OK);
    }

    @GetMapping("/byname") // GET localhost:8080/pessoa/byname?nome=Rafa
    public ResponseEntity<List<PessoaDto>> listByName(@RequestParam(value = "nome") String nome) {
        return new ResponseEntity(pessoaService.listByName(nome), HttpStatus.OK);
    }

    @GetMapping("/{idPessoa}")
    public ResponseEntity<PessoaDto> listById(@PathVariable(value = "idPessoa") Integer idPessoa) throws Exception {
        return new ResponseEntity<>(pessoaService.listById(idPessoa), HttpStatus.OK);
    }

    @GetMapping("/tem_endereco")
    public ResponseEntity<List<PessoaDto>> listInEndereco(@RequestParam(value = "idPessoa", required = false) Integer idPessoa) throws Exception {
        return new ResponseEntity<>(pessoaService.listInEndereco(idPessoa), HttpStatus.OK);
    }

    @GetMapping("/tem_pet")
    public ResponseEntity<List<PessoaDto>> listInPets(@RequestParam(value = "idPessoa", required = false) Integer idPessoa) throws Exception {
        return new ResponseEntity<>(pessoaService.listInEndereco(idPessoa), HttpStatus.OK);
    }

    @GetMapping("/tem_contato")
    public ResponseEntity<List<PessoaDto>> listInContatos(@RequestParam(value = "idPessoa", required = false) Integer idPessoa) throws Exception {
        return new ResponseEntity<>(pessoaService.listInContatos(idPessoa), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PessoaDto> create(@Valid @RequestBody PessoaCreateDto pessoa) throws Exception {
        return new ResponseEntity<>(pessoaService.create(pessoa), HttpStatus.OK);
    }

    @PutMapping("/{idPessoa}")
    public ResponseEntity<PessoaDto> update(@PathVariable("idPessoa") Integer id,
                                            @Valid @RequestBody PessoaUpdateDto pessoaAtualizar) throws Exception {
        return new ResponseEntity<>(pessoaService.update(id, pessoaAtualizar), HttpStatus.OK);
    }


    @DeleteMapping("/{idPessoa}")
    public void delete(@PathVariable("idPessoa") Integer id) throws Exception {
        pessoaService.delete(id);
    }
}
