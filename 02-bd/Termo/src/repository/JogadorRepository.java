package task05.src.repository;

import task05.src.Model.Jogador;
import task05.src.exceptions.BancoDeDadosException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JogadorRepository implements Repositorio<Integer, Jogador> {
    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        String sql = "SELECT jogador_seq.nextval mysequence from DUAL";

        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(sql);

        if (res.next()) {
            return res.getInt("mysequence");
        }
        return null;
    }

    @Override
    public Jogador adicionar(Jogador jogador) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            Integer proximoId = this.getProximoId(con);
            jogador.setIdJogador(proximoId);

            String sql = "INSERT INTO JOGADORES\n" +
                    "(ID_JOGADOR, NOME)\n" +
                    "VALUES(?, ?)\n";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, jogador.getIdJogador());
            stmt.setString(2, jogador.getNome());

            stmt.executeUpdate();
            return jogador;
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
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "DELETE FROM JOGADORES WHERE id_jogador = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            int res = stmt.executeUpdate();
            return res > 0;
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
    public boolean editar(Integer id, Jogador jogador) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE JOGADORES SET ");
            sql.append("nome = ?");
            sql.append(" WHERE id_jogador = ?");

            PreparedStatement stmt = con.prepareStatement(sql.toString());

            stmt.setString(1, jogador.getNome());
            stmt.setInt(2, id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();

            return res > 0;
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
    public List<Jogador> listar() throws BancoDeDadosException {
        List<Jogador> jogadores = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();
            Statement stmt = con.createStatement();

            String sql = "SELECT * FROM JOGADORES";

            // Executa-se a consulta
            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {
                Jogador jogador = new Jogador();
                jogador.setIdJogador(res.getInt("ID_JOGADOR"));
                jogador.setNome(res.getString("nome"));
                jogadores.add(jogador);
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
        return jogadores;
    }


    public Jogador buscarPorId(int id) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();
            String sql = "SELECT * FROM JOGADORES WHERE ID_JOGADOR = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet res = stmt.executeQuery();

            if (res.next()) {
                Jogador jogador = new Jogador();
                jogador.setIdJogador(res.getInt("ID_JOGADOR"));
                jogador.setNome(res.getString("nome"));
                return jogador;
            }
        } catch (SQLException e) {
            e.printStackTrace();
    }
        return null;
    }
}