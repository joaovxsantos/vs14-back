package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@Validated
@RestController
@RequestMapping("/pessoa") // localhost:8080/pessoa
public class PessoaController {

    private final PessoaService pessoaService;


    public PessoaController(PessoaService pessoaService) {
           this.pessoaService = pessoaService;
    }


    @GetMapping("/hello") // GET localhost:8080/pessoa/hello
    public String hello() {
        return "Hello world!";
    }

    @GetMapping("/hello-2") // GET localhost:8080/pessoa/hello-2
    public String hello2() {
        return "Hello world 2!";
    }

    @GetMapping // GET localhost:8080/pessoa
    public List<Pessoa> list() {
        return pessoaService.list();
    }

    @GetMapping("/byname") // GET localhost:8080/pessoa/byname?nome=Rafa
    public List<Pessoa> listByName(@RequestParam(value = "nome") String nome) {
        return pessoaService.listByName(nome);
    }

    @PostMapping // POST localhost:8080/pessoa
    public Pessoa create(@Valid @RequestBody Pessoa pessoa) {
        return pessoaService.create(pessoa);
    }

    @PutMapping("/{idPessoa}") // PUT localhost:8080/pessoa/1000
    public Pessoa update(@PathVariable("idPessoa") Integer id,
                         @Valid @RequestBody Pessoa pessoaAtualizar) throws Exception {
        return pessoaService.update(id, pessoaAtualizar);
    }

    @DeleteMapping("/{idPessoa}") // DELETE localhost:8080/pessoa/10
    public void delete(@PathVariable("idPessoa") Integer id) throws Exception {
        pessoaService.delete(id);
    }
}
