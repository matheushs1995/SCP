package dao;

import static dao.DAO.fecharConexao;
import model.Campus;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CampusDAO extends DAO {

    public static void gravar(Campus campus) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "insert into campus (numeroRegistroCampus,nomeCampus)"
                    + " values (" + campus.getNumeroRegistroCampus() + ", '" + campus.getNomeCampus() + "')";
            comando.execute(stringSQL);

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void editar(Campus campus) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update campus set "
                    + " numeroRegistroCampus = " + campus.getNumeroRegistroCampus() + ", "
                    + " nomeCampus = '" + campus.getNomeCampus();

            stringSQL = stringSQL + "' where numeroRegistroCampus= " + campus.getNumeroRegistroCampus();
            comando.execute(stringSQL);

            comando.execute(stringSQL);

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(Campus campus) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from campus where numeroRegistroCampus = " + campus.getNumeroRegistroCampus();
            comando.execute(stringSQL);

        } finally {
            fecharConexao(conexao, comando);
        }

    }

    public static Campus obterCampus(int numeroRegistroCampus) throws ClassNotFoundException,
            SQLException {
        Connection conexao = null;
        Statement comando = null;
        Campus campus = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery(
                    "SELECT * FROM CAMPUS where numeroRegistroCampus=" + numeroRegistroCampus);
            rs.first();
            campus = instanciarCampus(rs);

        } finally {
            fecharConexao(conexao, comando);
        }
        return campus;
    }

    public static List<Campus> obterCampi() throws ClassNotFoundException,
            SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Campus> campi = new ArrayList<Campus>();
        Campus campus = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM CAMPUS");
            while (rs.next()) {
                campus = instanciarCampus(rs);
                campi.add(campus);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return campi;
    }

    public static Campus instanciarCampus(ResultSet rs) throws SQLException {
        Campus campus = new Campus(rs.getInt("numeroRegistroCampus"), rs.getString("nomeCampus"));
        return campus;
    }

}
