package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {


//    @Query("SELECT e FROM endereco e WHERE e.pais = :pais")
//    List<Endereco> findByPais(@Param("pais") String pais);
//
//
//
//
//    @Query("SELECT e FROM endereco e WHERE e.idPessoa = :pessoaId")
//    List<Endereco> findByIdPessoa(@Param("pessoaId") Integer pessoaId);
//
//    @Query("SELECT c FROM contato c WHERE c.tipoContato = :tipo")
//    List<Contato> findByTipo(@Param("tipo") String tipo);
//
//    @Query("SELECT p FROM pessoa p where p.dataNascimento BETWEEN :startDate AND :endDate")
//    List<Pessoa> findByDataNasc(@Param("startdate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
