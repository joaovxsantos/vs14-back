package br.com.dbc.vemser.pessoaapi.controller;


import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/contato") // localhost:8080/contato
public class ContatoController {

    private ContatoService contatoService;

    public ContatoController() {
        contatoService = new ContatoService();
    }



    @GetMapping
    public List<Contato> list() {
        return contatoService.list();
    }

    @GetMapping("/{idPessoa}")
    public List<Contato> listByPessoa(@PathVariable("idPessoa") Integer idPessoa) {
        return contatoService.listByIdPessoa(idPessoa);
    }

    @PostMapping
    public Contato create(@Valid @RequestBody Contato contato) throws Exception {
        return contatoService.create(contato);
    }

    @PutMapping("/{idContato}")
    public Contato update(@Valid @PathVariable("idContato") Integer idContato, @RequestBody Contato contatoAtualizar) throws Exception {
        return contatoService.update(idContato, contatoAtualizar);
    }

    @DeleteMapping("/{idContato}")
    public void delete(@PathVariable("idContato") Integer idContato) throws Exception {
        contatoService.delete(idContato);
    }
}
