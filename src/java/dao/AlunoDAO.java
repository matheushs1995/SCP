package dao;

import static dao.DAO.fecharConexao;
import model.Aluno;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class AlunoDAO extends DAO {

    public static void gravar(Aluno aluno) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "insert into usuario "
                    + "values (" + aluno.getCpf()
                    + ", '" + aluno.getLogin()
                    + "', '" + aluno.getSenha()
                    + "', '" + aluno.getNomeCompleto()
                    + "', '" + aluno.getNaturalidade()
                    + "', '" + aluno.getNacionalidade()
                    + "', '" + aluno.getRg()
                    + "', '" + aluno.getOrgaoExpedidor()
                    + "', '" + aluno.getUfrg()
                    + "', '" + aluno.getDataNascimento()
                    + "', '" + aluno.getEmail()
                    + "', '" + aluno.getTipoUsuario()
                    + "', '" + aluno.getEndereco()+"')";

            comando.execute(stringSQL);

           
        } finally {
             stringSQL = "insert into aluno "
                    + "values (" + aluno.getNumeroRegistroAluno()
                    + ", '" + aluno.getNomeBanco()
                    + "', '" + aluno.getAgencia()
                    + "', '" + aluno.getNumeroConta()
                    + "', '" + aluno.getDadosResponsavel()
                    + "', " + aluno.getCurso_codCurso()
                    + ","   + aluno.getCpf();
             
             
            
             
            stringSQL = stringSQL + ")";
            comando.execute(stringSQL);
            
            fecharConexao(conexao, comando);
        }
    }

    public static void alterar(Aluno aluno) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update usuario set "
                    + "cpf = " + aluno.getCpf() + ", "
                    + "login = '" + aluno.getLogin() + "', "
                    + "senha = '" + aluno.getSenha() + "', "
                    + "nomeCompleto = '" + aluno.getNomeCompleto() + "', "
                    + "naturalidade = '" + aluno.getNaturalidade() + "', "
                    + "nacionalidade = '" + aluno.getNacionalidade() + "', "
                    + "rg = '" + aluno.getRg() + "', "
                    + "orgaoExpedidor = '" + aluno.getOrgaoExpedidor() + "', "
                    + "ufrg = '" + aluno.getUfrg() + "', "
                    + "dataNascimento = '" + aluno.getDataNascimento() + "', "
                    + "email = '" + aluno.getEmail() + "', "
                    + "tipoUsuario = '" + aluno.getTipoUsuario() + "', "
                    + "endereco = '" + aluno.getEndereco() + "' where cpf= " + aluno.getCpf();
     
            comando.execute(stringSQL);

            stringSQL = "update aluno set numeroRegistroAluno= " + aluno.getNumeroRegistroAluno() + ", "
                    + " nomeBanco = '" + aluno.getNomeBanco() + "', "
                    + " agencia = '" + aluno.getAgencia() + "', "
                    + " numeroConta = '" + aluno.getNumeroConta() + "', "
                    + " dadosResponsavel = '" + aluno.getDadosResponsavel() + "', "
                  
                    + " Curso_codcurso= ";

            if (aluno.getCurso() == null) {
                stringSQL = stringSQL + aluno.getCurso_codCurso();
            } else {
                stringSQL = stringSQL + aluno.getCurso().getNumeroRegistroCurso();
            }
            
            stringSQL=stringSQL+", Usuario_cpf= ";
            
            
            
            if (aluno.getUsuario() == null) {
                stringSQL = stringSQL + aluno.getCurso_codCurso();
            } else {
                stringSQL = stringSQL + aluno.getUsuario().getCpf();
            }
            
            
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(Aluno aluno) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from aluno where numeroRegistroAluno = "
                    + aluno.getNumeroRegistroAluno();
            comando.execute(stringSQL);
        } finally {
            
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from usuario where cpf = "
                    + aluno.getCpf();
            comando.execute(stringSQL);
            
            fecharConexao(conexao, comando);
        }

    }

    public static Aluno instanciarAluno(ResultSet rs) throws SQLException {
        Aluno aluno = new Aluno(rs.getInt("NumeroRegistroAluno"),rs.getString("nomeBanco"),rs.getString("agencia"),rs.getString("numeroConta"),rs.getString("dadosResponsavel"),rs.getInt("cpf"),rs.getString("login"),rs.getString("senha"),rs.getString("nomeCompleto"),rs.getString("naturalidade"),rs.getString("nacionalidade"),rs.getString("rg"),rs.getString("orgaoExpedidor"),rs.getString("ufrg"),rs.getString("dataNascimento"),rs.getString("email"),rs.getString("endereco"),rs.getString("tipoUsuario"),null,null);
        aluno.setCurso_codCurso(rs.getInt("Curso_codCurso"));
        aluno.setCpf(rs.getInt("Usuario_cpf"));

        return aluno;
    }

    public static List<Aluno> obterAlunos() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Aluno> alunos = new ArrayList<Aluno>();
        Aluno aluno = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM ALUNO, usuario where aluno.usuario_cpf = usuario.cpf");
            while (rs.next()) {
                aluno = instanciarAluno(rs);
                alunos.add(aluno);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return alunos;
    }

    public static Aluno obterAluno(int numeroRegistroAluno) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Aluno aluno = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from aluno,Usuario where aluno.usuario_cpf = usuario.cpf and aluno.numeroRegistroAluno= " + numeroRegistroAluno);
            rs.first();
            aluno = instanciarAluno(rs);

        } finally {
            fecharConexao(conexao, comando);
        }
        return aluno;
    }

}
