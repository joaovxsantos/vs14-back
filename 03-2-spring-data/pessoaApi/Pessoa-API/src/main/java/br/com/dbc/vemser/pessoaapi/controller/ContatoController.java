package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDto;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDto;
import br.com.dbc.vemser.pessoaapi.dto.ContatoUpdateDto;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Controller
@Validated
@RestController
@RequestMapping("/contato")
public class ContatoController {

    private final ContatoService contatoService;

    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }


    @GetMapping
    public ResponseEntity<List<ContatoDto>> list() {
        return new ResponseEntity<>(contatoService.list(), HttpStatus.OK) ;
    }

    @GetMapping("/byperson")
    public ResponseEntity<List<ContatoDto>> listId(@NotNull @RequestParam(value = "id")  int id) throws Exception {
        return new ResponseEntity<>(contatoService.listId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ContatoDto> create(@Valid @RequestBody ContatoCreateDto contato) throws Exception {
        return new ResponseEntity<>(contatoService.create(contato), HttpStatus.OK) ;
    }

    @PutMapping("/{idContato}")
    public ResponseEntity<ContatoDto> update(@NotNull @PathVariable("idContato")  Integer id,
                                             @Valid @RequestBody ContatoUpdateDto contatoAtualizar) throws Exception {
        return new ResponseEntity<>(contatoService.update(id, contatoAtualizar), HttpStatus.OK);
    }

    @DeleteMapping("/{idContato}")
    public void delete(@PathVariable("idContato") @NotNull Integer id) throws Exception {
        contatoService.delete(id);
    }
}
