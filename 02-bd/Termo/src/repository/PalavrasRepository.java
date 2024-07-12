package task05.src.repository;

import task05.src.exceptions.BancoDeDadosException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PalavrasRepository {

  Connection con = ConexaoBancoDeDados.getConnection();

  public PalavrasRepository() throws SQLException {
  }

  public String getPalavra() throws SQLException {
    String sql = "SELECT palavra FROM (SELECT palavra FROM palavras ORDER BY DBMS_RANDOM.VALUE) WHERE ROWNUM = 1";

    Statement stmt = con.createStatement();
    ResultSet res = stmt.executeQuery(sql);

    if (res.next()) {
      return res.getString("palavra");
    }
    return null;
  }

  public boolean addPalavra(String palavra) throws SQLException {
    String sql = "INSERT INTO palavras (id, palavra) VALUES (seq_palavras_id.NEXTVAL, ?)";

    try (PreparedStatement stmt = con.prepareStatement(sql)) {
      stmt.setString(1, palavra);
      int rowsAffected = stmt.executeUpdate();
      return rowsAffected > 0;
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

  public boolean deletePalavra(String palavra) throws SQLException {
    String sql = "DELETE FROM palavras WHERE palavra = ?";

    try (PreparedStatement stmt = con.prepareStatement(sql)) {
      stmt.setString(1, palavra);
      int rowsAffected = stmt.executeUpdate();
      return rowsAffected > 0;
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

  public boolean updatePalavra(int id, String novaPalavra) throws SQLException {
    String sql = "UPDATE palavras SET palavra = ? WHERE id = ?";

    try (PreparedStatement stmt = con.prepareStatement(sql)) {
      stmt.setString(1, novaPalavra);
      stmt.setInt(2, id);
      int rowsAffected = stmt.executeUpdate();
      return rowsAffected > 0;
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
}
