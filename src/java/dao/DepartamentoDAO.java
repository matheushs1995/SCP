
package dao;

import static dao.DAO.fecharConexao;
import model.Departamento;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoDAO extends DAO {

    public static void gravar(Departamento departamento) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "insert into departamento"
                    + " values (" + departamento.getNumeroRegistroDepartamento() + ", '" + 
                    departamento.getNomeDepartamento()+ "', ";

            if (departamento.getCampus() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + departamento.getCampus().getNumeroRegistroCampus();
            }
            stringSQL = stringSQL + ")";
            comando.execute(stringSQL);

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void editar(Departamento departamento) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update departamento set "
                    + " numeroRegistroDepartamento = " + departamento.getNumeroRegistroDepartamento() + ", "
                    + " nomeDepartamento = '" + departamento.getNomeDepartamento()+"'," 
                    + " numeroRegistroCampus= ";
            if (departamento.getCampus() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + departamento.getCampus().getNumeroRegistroCampus();
            } 
            
            stringSQL=stringSQL+ " where numeroRegistroDepartamento= " + departamento.getNumeroRegistroDepartamento();
            comando.execute(stringSQL);

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(Departamento departamento) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from departamento where numeroRegistroDepartamento = "
                    + departamento.getNumeroRegistroDepartamento();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static Departamento instanciarDepartamento(ResultSet rs) throws SQLException {
        Departamento departamento = new Departamento(rs.getInt("numeroRegistroDepartamento"), rs.getString("nomeDepartamento"), null);
        departamento.setNumeroRegistroCampus(rs.getInt("numeroRegistroCampus"));
        return departamento;
    }

    public static Departamento obterDepartamento(int numeroRegistroDepartamento) throws ClassNotFoundException,
            SQLException {
        Connection conexao = null;
        Statement comando = null;
        Departamento departamento = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery(
                    "select * from departamento where numeroRegistroDepartamento = " + numeroRegistroDepartamento);
            rs.first();
            departamento = instanciarDepartamento(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return departamento;
    }

    public static List<Departamento> obterDepartamentos()
            throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Departamento> departamentos = new ArrayList<Departamento>();
        Departamento departamento = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM DEPARTAMENTO");
            while (rs.next()) {
                departamento = instanciarDepartamento(rs);
                departamentos.add(departamento);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return departamentos;
    }

}
