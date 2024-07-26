package br.com.dbc.vemser.pessoaapi.dto;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PessoaTotalDto {




    public PessoaTotalDto() {

    }






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
