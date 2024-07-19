package br.com.dbc.vemser.pessoaapi.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Endereco {
    private Integer idPessoa;
    private Integer id;

    @NotNull
    private TipoEndereco tipo;

    @NotEmpty
    @Max(value = 250, message = "Ultrapassou 250 caracteres")
    private String logradouro;

    @NotNull
    private Integer numero;
    private String complemento;

    @NotEmpty
    @NotNull
    @Max(value = 8)
    private String cep;

    @NotEmpty
    @NotNull
    @Max(value = 250)
    private String cidade;

    @NotNull
    private String estado;

    @NotNull
    private String pais;




    public Endereco(Integer idPessoa, TipoEndereco tipo, String logradouro, Integer numero, String complemento, String cep, String cidade, String estado, String pais, Integer id) {
        this.idPessoa = idPessoa;
        this.tipo = tipo;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.id = id;
    }


    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public TipoEndereco getTipo() {
        return tipo;
    }

    public void setTipo(TipoEndereco tipo) {
        this.tipo = tipo;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
