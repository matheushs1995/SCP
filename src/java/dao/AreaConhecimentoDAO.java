
package dao;

import static dao.AlunoDAO.instanciarAluno;
import static dao.DAO.fecharConexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.AreaConhecimento;

public class AreaConhecimentoDAO extends DAO {

    public static void gravar(AreaConhecimento areaConhecimento) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "insert into areaConhecimento "
                    + " values (" + areaConhecimento.getNumeroRegistroAreaConhecimento() + ", '" + areaConhecimento.getNomeAreaConhecimento();

            
            stringSQL = stringSQL + "')";
            comando.execute(stringSQL);

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void editar(AreaConhecimento areaConhecimento) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update areaConhecimento set "
                    + "numeroRegistroAreaConhecimento = " + areaConhecimento.getnumeroRegistroAreaConhecimento() + ", "
                    + "nome = '" + areaConhecimento.getnomeAreaConhecimento() + "' where numeroRegistroAreaConhecimento= " + areaConhecimento.getnumeroRegistroAreaConhecimento();
            comando.execute(stringSQL);

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(AreaConhecimento areaConhecimento) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from areaConhecimento where numeroRegistroAreaConhecimento = "
                    + areaConhecimento.getNumeroRegistroAreaConhecimento();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static AreaConhecimento instanciarAreaConhecimento(ResultSet rs) throws SQLException {
        AreaConhecimento areaConhecimento = new AreaConhecimento(
                rs.getInt("numeroRegistroAreaConhecimento"),
                rs.getString("nome"));
          return areaConhecimento;
    }

    public static AreaConhecimento obterAreaConhecimento(int numeroRegistroAreaConhecimento) throws ClassNotFoundException,
            SQLException {
        Connection conexao = null;
        Statement comando = null;
        AreaConhecimento areaConhecimento = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery(
                    "select * from areaConhecimento where numeroRegistroAreaConhecimento = " + numeroRegistroAreaConhecimento);
            rs.first();
            areaConhecimento = instanciarAreaConhecimento(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return areaConhecimento;
    }

    public static List<AreaConhecimento> obterAreasConhecimentos()
            throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<AreaConhecimento> areasConhecimentos = new ArrayList<AreaConhecimento>();
        AreaConhecimento areaConhecimento = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM AREACONHECIMENTO");
            while (rs.next()) {
                areaConhecimento = instanciarAreaConhecimento(rs);
                areasConhecimentos.add(areaConhecimento);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return areasConhecimentos;
    }

}
