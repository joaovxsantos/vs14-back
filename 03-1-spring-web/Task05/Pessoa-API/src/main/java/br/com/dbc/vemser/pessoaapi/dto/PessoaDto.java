package br.com.dbc.vemser.pessoaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.yaml.snakeyaml.events.Event;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDto {
    private Integer idPessoa;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private String email;

    public Integer idPessoa() {
        return idPessoa;
    }
}
