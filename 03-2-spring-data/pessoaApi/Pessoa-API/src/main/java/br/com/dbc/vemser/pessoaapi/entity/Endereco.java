    package br.com.dbc.vemser.pessoaapi.entity;

    import lombok.*;

    import javax.persistence.*;

    @AllArgsConstructor
    @NoArgsConstructor
    @Setter
    @Getter
    @ToString
    @Entity(name = "endereco")
    public class Endereco {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_endereco")
        @SequenceGenerator(name = "seq_endereco", sequenceName = "seq_endereco", allocationSize = 1)
        @Column(name = "id_endereco")
        private Integer id;

        @Column(name = "tipo")
        private TipoEndereco tipo;
        @Column(name = "logradouro")

        private String logradouro;
        @Column(name = "numero")
        private Integer numero;
        @Column(name = "complemento")
        private String complemento;
        @Column(name = "cep")
        private String cep;
        @Column(name = "cidade")
        private String cidade;
        @Column(name = "estado")
        private String estado;
        @Column(name = "pais")
        private String pais;
    }
