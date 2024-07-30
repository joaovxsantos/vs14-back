package br.com.dbc.vemser.pessoaapi.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter


public class PessoaRelatorioDto {
    private Integer idPessoa;
    private String email;
    private String nome;
    private String numero;
    private String cep;
    private String cidade;
    private String estado;
    private String pais;
    private String petNome;
}
