package dao;

import static dao.DAO.fecharConexao;
import model.Professor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class ProfessorDAO extends DAO {

    public static void gravar(Professor professor) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "insert into usuario "
                    + "values (" + professor.getCpf()
                    + ", '" + professor.getLogin()
                    + "', '" + professor.getSenha()
                    + "', '" + professor.getNomeCompleto()
                    + "', '" + professor.getNaturalidade()
                    + "', '" + professor.getNacionalidade()
                    + "', '" + professor.getRg()
                    + "', '" + professor.getOrgaoExpedidor()
                    + "', '" + professor.getUfrg()
                    + "', '" + professor.getDataNascimento()
                    + "', '" + professor.getEmail()
                    + "', '" + professor.getTipoUsuario()
                    + "', '" + professor.getEndereco()+"')";
            comando.execute(stringSQL);

            
        } finally {
            stringSQL = "insert into professor "
                    + "values (" + professor.getNumeroRegistroProfessor()
                    + ", '" + professor.getAreaAtuacao()
                    + "'," + professor.getUsuario().getCpf()+")";

            comando.execute(stringSQL);
            
            fecharConexao(conexao, comando);
        }
    }

    public static void alterar(Professor professor) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
           stringSQL = "update usuario set "
                    + "cpf = " + professor.getCpf() + ", "
                    + "login = '" + professor.getLogin() + "', "
                    + "senha = '" + professor.getSenha() + "', "
                    + "nomeCompleto = '" + professor.getNomeCompleto() + "', "
                    + "naturalidade = '" + professor.getNaturalidade() + "', "
                    + "nacionalidade = '" + professor.getNacionalidade() + "', "
                    + "rg = '" + professor.getRg() + "', "
                    + "orgaoExpedidor = '" + professor.getOrgaoExpedidor() + "', "
                    + "ufrg = '" + professor.getUfrg() + "', "
                    + "dataNascimento = '" + professor.getDataNascimento() + "', "
                    + "email = '" + professor.getEmail() + "', "
                    + "tipoUsuario = '" + professor.getTipoUsuario() + "', "
                    + "endereco = '" + professor.getEndereco() + "' where cpf= " + professor.getCpf();
     

            comando.execute(stringSQL);

            stringSQL = "update professor set numeroRegistroProfessor= " + professor.getNumeroRegistroProfessor() + ", "
                    + "areaAtuacao = '" + professor.getAreaAtuacao() + "', Usuario_cpf = ";

            if (professor.getUsuario() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + professor.getUsuario().getCpf();
            }
            
            stringSQL = stringSQL + " where numeroRegistroProfessor="+professor.getNumeroRegistroProfessor();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(Professor professor) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from professor where numeroRegistroProfessor = "
                    + professor.getNumeroRegistroProfessor();
            comando.execute(stringSQL);
        } finally {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from usuario where cpf = "
                    + professor.getCpf();
            comando.execute(stringSQL);
            fecharConexao(conexao, comando);
        }

    }

    public static Professor instanciarProfessor(ResultSet rs) throws SQLException {
        Professor professor = new Professor(rs.getInt("numeroRegistroProfessor"),rs.getString("areaAtuacao"),rs.getInt("cpf"),rs.getString("login"),rs.getString("senha"),rs.getString("nomeCompleto"),rs.getString("naturalidade"),rs.getString("nacionalidade"),rs.getString("rg"),rs.getString("orgaoExpedidor"),rs.getString("ufrg"),rs.getString("dataNascimento"),rs.getString("email"),rs.getString("endereco"),rs.getString("tipoUsuario"));
        professor.setCpf(rs.getInt("Usuario_cpf"));
        return professor;
    }

    public static Professor obterProfessor(int numeroRegistroProfessor) throws ClassNotFoundException,
            SQLException {
        Connection conexao = null;
        Statement comando = null;
        Professor professor = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from professor, Usuario where professor.Usuario_cpf = usuario.cpf and numeroRegistroProfessor = " + numeroRegistroProfessor);
            rs.first();
            professor = instanciarProfessor(rs);

        } finally {
            fecharConexao(conexao, comando);
        }
        return professor;
    }

    public static List<Professor> obterProfessores()
            throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Professor> professores = new ArrayList<Professor>();
        Professor professor = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM PROFESSOR,Usuario where professor.Usuario_cpf = usuario.cpf");
            while (rs.next()) {
                professor = instanciarProfessor(rs);
                professores.add(professor);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return professores;
    }

}
