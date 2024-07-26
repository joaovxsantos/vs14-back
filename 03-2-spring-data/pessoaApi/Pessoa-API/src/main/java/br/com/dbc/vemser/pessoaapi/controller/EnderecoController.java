package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDto;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDto;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoUpdateDto;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<EnderecoDto> listById(@PathVariable int idEndereco) throws Exception {
        return new ResponseEntity<>(enderecoService.getEnderecoById(idEndereco), HttpStatus.OK);
    }


    @PostMapping("/{idPerson}")
    public ResponseEntity<EnderecoDto> create(@Valid @RequestBody EnderecoCreateDto endereco, @PathVariable int idPerson) throws Exception {
        return new ResponseEntity<>(enderecoService.create(idPerson, endereco), HttpStatus.OK);
    }

    @PutMapping("/{idEndereco}")
    public ResponseEntity<EnderecoDto> update(@PathVariable("idEndereco") Integer idEndereco,
                                              @Valid @RequestBody EnderecoUpdateDto enderecoAtualizar) throws Exception {
        return new ResponseEntity<>(enderecoService.update(idEndereco, enderecoAtualizar), HttpStatus.OK);
    }

    @DeleteMapping("/{idEndereco}")
    public void delete(@PathVariable("idEndereco") Integer id) throws Exception {
        enderecoService.delete(id);
    }

}
