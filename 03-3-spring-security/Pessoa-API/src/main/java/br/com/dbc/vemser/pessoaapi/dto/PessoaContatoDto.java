package br.com.dbc.vemser.pessoaapi.dto;


import br.com.dbc.vemser.pessoaapi.entity.Contato;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public final class PessoaContatoDto {
    private Integer idPessoa;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private String email;
    private Set<Contato> contato;
}