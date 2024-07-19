package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/pessoa") // localhost:8080/pessoa
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping("/hello") // GET localhost:8080/pessoa/hello
    public String hello() {
        log.info("Leitura Hello World");
        return "Hello world!";
    }

    @GetMapping("/hello-2") // GET localhost:8080/pessoa/hello-2
    public String hello2() {
        log.info("Leitura Hello World 2");
        return "Hello world 2!";
    }

    @GetMapping // GET localhost:8080/pessoa
    public List<PessoaDTO> list() {
        log.info("Listando todas as pessoas");
        return pessoaService.list();
    }

    @GetMapping("/byname") // GET l
    // ocalhost:8080/pessoa/byname?nome=Rafa
    public List<PessoaDTO> listByName(@RequestParam(value = "nome") String nome) {
        log.info("Listando a pessoa de acordo com o Nome");
        return pessoaService.listByName(nome);
    }

    @PostMapping // POST localhost:8080/pessoa
    public PessoaDTO create(@RequestBody PessoaCreateDTO pessoaCreateDTO) {
        log.info("Criando uma pessoa");
        return pessoaService.create(pessoaCreateDTO);
    }

    @PutMapping("/{idPessoa}") // PUT localhost:8080/pessoa/1000
    public PessoaDTO update(@PathVariable("idPessoa") Integer id,
                            @RequestBody PessoaCreateDTO pessoaAtualizar) throws Exception {
        log.info("Atualizando uma pessoa");
        return pessoaService.update(id, pessoaAtualizar);
    }

    @DeleteMapping("/{idPessoa}") // DELETE localhost:8080/pessoa/10
    public void delete(@PathVariable("idPessoa") Integer id) throws Exception {
        log.info("Deletando uma pessoa");
        pessoaService.delete(id);
    }
}
