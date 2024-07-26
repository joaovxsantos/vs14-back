package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.entity.Pet;
import lombok.*;
import org.yaml.snakeyaml.events.Event;

import java.time.LocalDate;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PessoaDto {
    private Pessoa pessoa;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private String email;
    private Set<Endereco> enderecos;
    private Set<Contato> contatos;
    private Set<Pet> pets;
}
