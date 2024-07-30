package br.com.dbc.vemser.pessoaapi.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PessoaTotalDto {

    private Integer idPessoa;
    private String email;
    private String nome;
    private Integer numero;
    private String cep;
    private String cidade;
    private String estado;
    private String pais;
    private String nomePet;
}
