package br.com.dbc.vemser.pessoaapi.controller;


import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/contato") // localhost:8080/contato
public class ContatoController {

    private ContatoService contatoService;

    public ContatoController() {
        contatoService = new ContatoService();
    }



    @GetMapping
    public List<Contato> list() {
        log.info("Listando todos os contatos");
        return contatoService.list();
    }

    @GetMapping("/{idPessoa}")
    public List<Contato> listByPessoa(@PathVariable("idPessoa") Integer idPessoa) {
        log.info("Listando contatos da pessoa com id: {}", idPessoa);
        return contatoService.listByIdPessoa(idPessoa);
    }

    @PostMapping
    public Contato create(@RequestBody Contato contato) {
        log.info("Criando um novo contato: {}", contato);
        return contatoService.create(contato);
    }

    @PutMapping("/{idContato}")
    public Contato update(@PathVariable("idContato") Integer idContato, @RequestBody Contato contatoAtualizar) throws Exception {
        log.info("Atualizando contato com id: {} com as novas informações: {}", idContato, contatoAtualizar);
        return contatoService.update(idContato, contatoAtualizar);
    }

    @DeleteMapping("/{idContato}")
    public void delete(@PathVariable("idContato") Integer idContato) throws Exception {
        log.info("Deletando contato com id: {}", idContato);
        contatoService.delete(idContato);
    }
}
