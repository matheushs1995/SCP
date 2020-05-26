package dao;

import static dao.DAO.fecharConexao;
import model.Curso;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO extends DAO {

    public static void gravar(Curso curso) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "insert into curso "
                    + "values (" + curso.getNumeroRegistroCurso() + ", '" + curso.getNomeCurso()+ "', " ;

            if (curso.getNucleo() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + curso.getNucleo().getNumeroRegistroNucleo();
            }
            stringSQL = stringSQL + ")";
            comando.execute(stringSQL);

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void alterar(Curso curso) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            //arrumar
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update curso set "
                    +" numeroRegistroCurso = "+curso.getNumeroRegistroCurso()+ ","
                    + "nomeCurso = '" + curso.getNomeCurso() + "' where numeroRegistroCurso= " + curso.getNumeroRegistroCurso();

         comando.execute(stringSQL);   
            
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(Curso curso) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from curso where NumeroRegistroCurso = "
                    + curso.getNumeroRegistroCurso();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static Curso instanciarCurso(ResultSet rs) throws SQLException {
        Curso curso = new Curso(rs.getInt("numeroRegistroCurso"),rs.getString("nomeCurso"),null);
        curso.setNumeroRegistroNucleo(rs.getInt("numeroRegistroNucleo"));
        return curso;
    }

    public static List<Curso> obterCursos()
            throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Curso> cursos = new ArrayList<Curso>();
        Curso curso = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM CURSO");
            while (rs.next()) {
                curso = instanciarCurso(rs);
                cursos.add(curso);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return cursos;
    }

    public static Curso obterCurso(int numeroRegistroCurso) throws ClassNotFoundException,
            SQLException {
        Connection conexao = null;
        Statement comando = null;
        Curso curso = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery(
                    "select * from curso where numeroRegistroCurso = " + numeroRegistroCurso);
            rs.first();
            curso = instanciarCurso(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return curso;
    }

}
