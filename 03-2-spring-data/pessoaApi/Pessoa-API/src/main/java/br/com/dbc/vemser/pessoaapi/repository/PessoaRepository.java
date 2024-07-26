package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.dto.PessoaRelatorioDto;
import br.com.dbc.vemser.pessoaapi.dto.PessoaTotalDto;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public interface PessoaRepository extends JpaRepository <Pessoa, Integer> {
    List<Pessoa> findByNome(String nome);

    @Query("SELECT DISTINCT new br.com.dbc.vemser.pessoaapi.dto.PessoaRelatorioDto (p.idPessoa," +
            " p.email," +
            " p.nome," +
            " c.numero," +
            " e.cep," +
            " e.cidade," +
            " e.estado," +
            " e.pais," +
            " pp.nome)" +
            "  FROM pessoa p left join p.contatos c left join p.enderecos e left join p.pets pp ")
    List<PessoaTotalDto> findAllRelatorio();

    @Query("""
            SELECT DISTINCT new br.com.dbc.vemser.pessoaapi.dto.PessoaTotalDto(p) FROM pessoa p \
            LEFT JOIN p.contatos c \
            LEFT JOIN p.pets pe \
            LEFT JOIN p.enderecos e\s""")
    List<PessoaRelatorioDto> listAll();

    @Query("""
            SELECT DISTINCT new br.com.dbc.vemser.pessoaapi.dto.PessoaTotalDto(p) FROM pessoa p \
            LEFT JOIN p.contatos c \
            LEFT JOIN p.pets pe \
            LEFT JOIN p.enderecos e \
            WHERE p.idPessoa = :id\s""")
    List<PessoaRelatorioDto> listAllId(Integer id);
}
