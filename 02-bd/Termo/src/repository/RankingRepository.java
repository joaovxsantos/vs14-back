package task05.src.repository;

import task05.src.Model.Jogador;
import task05.src.Service.Progresso;
import task05.src.exceptions.BancoDeDadosException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RankingRepository implements Repositorio <Integer, Progresso> {

  @Override
  public Integer getProximoId(Connection connection) throws SQLException {
    String sql = "SELECT ranking_seq.nextval mysequence from DUAL";

    Statement stmt = connection.createStatement();
    ResultSet res = stmt.executeQuery(sql);

    if (res.next()) {
      return res.getInt("mysequence");
    }
    return null;
  }

  @Override
  public Progresso adicionar(Progresso progresso) throws BancoDeDadosException {

    Connection con = null;

    try {
      con = ConexaoBancoDeDados.getConnection();

      Integer proximoId = this.getProximoId(con);


      String sql = "INSERT INTO RANKING (ID_RANKING, ID_JOGADOR, PARTIDAS_JOGADAS, VITORIAS, DERROTAS) VALUES (?, ?, ?, ?, ?)";
      PreparedStatement stmt = con.prepareStatement(sql);
      stmt.setInt(1, proximoId);
      stmt.setInt(2, progresso.getIdJogador());
      stmt.setInt(3, progresso.getPartidasJogo());
      stmt.setInt(4, progresso.getVitorias());
      stmt.setInt(5, progresso.getDerrotas());

      stmt.executeUpdate();
      return progresso;
    } catch (SQLException e) {
      throw new BancoDeDadosException(e.getCause());
    } finally {
      try {
        if (con != null) {
          con.close();
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

  @Override
  public boolean remover(Integer id) throws BancoDeDadosException {
    return false;
  }

  @Override
  public boolean editar(Integer id, Progresso progresso) throws BancoDeDadosException {
    return false;
  }

  @Override
  public List<Progresso> listar() throws BancoDeDadosException {
    return List.of();
  }

  public boolean updateRanking(Progresso progresso) throws BancoDeDadosException {

    Connection con = null;

    try {

      con = ConexaoBancoDeDados.getConnection();
      String sqlBuscar = "SELECT * FROM RANKING WHERE ID_JOGADOR = ?";
      PreparedStatement stmtBuscar = con.prepareStatement(sqlBuscar);
      stmtBuscar.setInt(1, progresso.getIdJogador());
      ResultSet res = stmtBuscar.executeQuery();

      Progresso progressoUpdate = new Progresso(progresso.getNome());

      if (res.next()) {
        progressoUpdate.setIdJogador(progresso.getIdJogador());
        progressoUpdate.setPartidasJogo(res.getInt("PARTIDAS_JOGADAS") + progresso.getPartidasJogo());
        progressoUpdate.setVitorias(res.getInt("VITORIAS") + progresso.getVitorias());
        progressoUpdate.setDerrotas(res.getInt("DERROTAS") + progresso.getDerrotas());
      }

      String sqlAtualizar = "UPDATE RANKING SET PARTIDAS_JOGADAS = ?, VITORIAS = ?, DERROTAS = ? WHERE ID_JOGADOR = ?";
      PreparedStatement stmt = con.prepareStatement(sqlAtualizar);

      stmt.setInt(1, progressoUpdate.getPartidasJogo());
      stmt.setInt(2, progressoUpdate.getVitorias());
      stmt.setInt(3, progressoUpdate.getDerrotas());
      stmt.setInt(4, progressoUpdate.getIdJogador());

      int affectedRows = stmt.executeUpdate();
      return affectedRows > 0;

    } catch (SQLException e) {
      throw new BancoDeDadosException(e.getCause());

    } finally {

      try {
        if (con != null) {
          con.close();
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

  public boolean listarById(Integer id) throws BancoDeDadosException {
    Connection con = null;

    try {
      con = ConexaoBancoDeDados.getConnection();

      String sql = "SELECT COUNT(*) AS total FROM RANKING WHERE id_jogador = ?";

      PreparedStatement stmt = con.prepareStatement(sql);

      stmt.setInt(1, id);

      ResultSet res = stmt.executeQuery();

      // check if ranking exists, if exists return true
      if (res.next() && res.getInt("total") > 0) {
        return true;
      } else {
        return false;
      }

    } catch (SQLException e) {
      throw new BancoDeDadosException(e.getCause());

    } finally {
      try {
        if (con != null) {
          con.close();
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

  }

  public boolean deleteRanking(Integer id) throws BancoDeDadosException {
    Connection con = null;
    PreparedStatement stmt = null;
    boolean deletado = false;

    try {
      con = ConexaoBancoDeDados.getConnection();
      String sql = "DELETE FROM RANKING WHERE ID_RANKING = ?";
      stmt = con.prepareStatement(sql);
      stmt.setInt(1, id);

      int rowsDeleted = stmt.executeUpdate();
      if (rowsDeleted > 0) {
        deletado = true;
      }

    } catch (SQLException e) {
      throw new BancoDeDadosException(e.getCause());
    } finally {
      try {
        if (stmt != null) {
          stmt.close();
        }
        if (con != null) {
          con.close();
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return deletado;
  }

  public static List<Map<String, Object>> listarRanking() throws BancoDeDadosException {
    Connection con = null;
    List<Map<String, Object>> rankings = new ArrayList<>();

    PreparedStatement stmt = null;
    ResultSet res = null;
    try {
      con = ConexaoBancoDeDados.getConnection();

      StringBuilder sql = new StringBuilder();
      sql.append("SELECT r.*, j.nome ");
      sql.append("FROM RANKING r ");
      sql.append("JOIN JOGADORES j ON j.id_jogador = r.ID_JOGADOR");

      // Criando PreparedStatement com a consulta montada
      stmt = con.prepareStatement(sql.toString());
      res = stmt.executeQuery();

      while (res.next()) {
        Map<String, Object> dados1 = new HashMap<>();

        int id_ranking = res.getInt("ID_RANKING");
        int vitorias = res.getInt("VITORIAS");
        int derrotas = res.getInt("DERROTAS");
        int partidas_jogadas = res.getInt("PARTIDAS_JOGADAS");
        String nome_jogador = res.getString("NOME");

        dados1.put("ID_RANKING", id_ranking);
        dados1.put("VITORIAS", vitorias);
        dados1.put("DERROTAS", derrotas);
        dados1.put("PARTIDAS_JOGADAS", partidas_jogadas);
        dados1.put("NOME_JOGADOR", nome_jogador);
        rankings.add(dados1);
      }

      res.close();
      stmt.close();
      con.close();

    } catch (SQLException e) {
      throw new BancoDeDadosException(e);
    }

    return rankings;
  }
  }
