package dao;

import static dao.DAO.fecharConexao;
import model.Funcionario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;

public class FuncionarioDAO extends DAO {

    public static void gravar(Funcionario funcionario) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();

            if (true) {
                stringSQL = "insert into usuario "
                        + "values (" + funcionario.getCpf()
                        + ", '" + funcionario.getLogin()
                        + "', '" + funcionario.getSenha()
                        + "', '" + funcionario.getNomeCompleto()
                        + "', '" + funcionario.getNaturalidade()
                        + "', '" + funcionario.getNacionalidade()
                        + "', '" + funcionario.getRg()
                        + "', '" + funcionario.getOrgaoExpedidor()
                        + "', '" + funcionario.getUfrg()
                        + "', '" + funcionario.getDataNascimento()
                        + "', '" + funcionario.getEmail()
                        + "', '" + funcionario.getTipoUsuario()
                        + "', '" + funcionario.getEndereco()
                        + "')";

                comando.execute(stringSQL);
            }

           

        } finally {
             stringSQL = "insert into funcionario "
                    + "values (" + funcionario.getNumeroRegistroFuncionario()
                    + ", '" + funcionario.getCargo() + "', " + funcionario.getCpf();

            stringSQL = stringSQL + ")";
            comando.execute(stringSQL);
            
            fecharConexao(conexao, comando);
        }
    }

    public static void alterar(Funcionario funcionario) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update usuario set "
                    + "cpf = " + funcionario.getCpf() + ", "
                    + "login = '" + funcionario.getLogin() + "', "
                    + "senha = '" + funcionario.getSenha() + "', "
                    + "nomeCompleto = '" + funcionario.getNomeCompleto() + "', "
                    + "naturalidade = '" + funcionario.getNaturalidade() + "', "
                    + "nacionalidade = '" + funcionario.getNacionalidade() + "', "
                    + "rg = '" + funcionario.getRg() + "', "
                    + "orgaoExpedidor = '" + funcionario.getOrgaoExpedidor() + "', "
                    + "ufrg = '" + funcionario.getUfrg() + "', "
                    + "dataNascimento = '" + funcionario.getDataNascimento() + "', "
                    + "email = '" + funcionario.getEmail() + "', "
                    + "tipoUsuario = '" + funcionario.getTipoUsuario() + "', "
                    + "endereco = '" + funcionario.getEndereco() + "' where cpf= " + funcionario.getCpf();
     
            comando.execute(stringSQL);

            stringSQL = "update funcionario set numeroRegistroFuncionario= " + funcionario.getNumeroRegistroFuncionario() + ", "
                    + "cargo = '" + funcionario.getCargo() + "', Usuario_cpf= ";

            if (funcionario.getUsuario() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + funcionario.getUsuario().getCpf();
            }

            stringSQL=stringSQL + " where numeroRegistroFuncionario= " +funcionario.getNumeroRegistroFuncionario();
                    
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(Funcionario funcionario) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from funcionario where numeroRegistroFuncionario = "
                    + funcionario.getNumeroRegistroFuncionario();
            comando.execute(stringSQL);
            
        } finally {
            stringSQL = "delete from usuario where cpf = "
                    + funcionario.getCpf();
            comando.execute(stringSQL);
            
            fecharConexao(conexao, comando);
        }

    }

    public static Funcionario instanciarFuncionario(ResultSet rs) throws SQLException {
        Funcionario funcionario = new Funcionario(
                rs.getInt("numeroRegistroFuncionario"), rs.getString("nomeCompleto"),
                rs.getInt("cpf"), rs.getString("rg"), rs.getString("ufrg"), rs.getString("orgaoExpedidor"), rs.getString("dataNascimento"),rs.getString("endereco"), rs.getString("naturalidade"), rs.getString("nacionalidade"),rs.getString("cargo"), rs.getString("login"), rs.getString("senha"), rs.getString("email"), rs.getString("tipoUsuario"), null
        );
        funcionario.setCpf(rs.getInt("Usuario_cpf"));
        return funcionario;
    }

    public static List<Funcionario> obterFuncionarios()
            throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        Funcionario funcionario = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM FUNCIONARIO, Usuario where funcionario.usuario_cpf = usuario.cpf");
            while (rs.next()) {
                funcionario = instanciarFuncionario(rs);
                funcionarios.add(funcionario);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return funcionarios;
    }

    public static Funcionario obterFuncionario(int numeroRegistroFuncionario) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Funcionario funcionario = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from funcionario, Usuario where funcionario.usuario_cpf = usuario.cpf and numeroRegistroFuncionario = " + numeroRegistroFuncionario);
            rs.first();
            funcionario = instanciarFuncionario(rs);

        } finally {
            fecharConexao(conexao, comando);
        }
        return funcionario;
    }

}
