package br.com.dbc.vemser.pessoaapi.entity;


import lombok.*;
import javax.persistence.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "contato")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_contato")
    @SequenceGenerator(name = "seq_contato", sequenceName = "seq_contato", allocationSize = 1)
    @Column(name = "id_contato")
    private Integer idContato;


    @JoinColumn(name = "id_pessoa", referencedColumnName = "id_pessoa")
    @ManyToOne()
    private Pessoa pessoa;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "tipo")
    private TipoContato tipoContato;

    @Column(name = "numero")
    private String numero;

    @Column(name = "descricao")
    private String descricao;
}