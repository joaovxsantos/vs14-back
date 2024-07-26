package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.Pet;

import java.util.Set;


public class PessoaRelatorioDto {
    private Set<Contato> contato;
    private Set<Pet> pet;
    private Set<Endereco> endereco;
}
