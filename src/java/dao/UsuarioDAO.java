package dao;

import static dao.DAO.fecharConexao;
import model.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class UsuarioDAO extends DAO {

    public static void gravar(Usuario usuario) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "insert into usuario "
                    + "values (" + usuario.getCpf()
                    + ", '" + usuario.getLogin()
                    + "', '" + usuario.getSenha()
                    + "', '" + usuario.getNomeCompleto()
                    + "', '" + usuario.getNaturalidade()
                    + "', '" + usuario.getNacionalidade()
                    + "', '" + usuario.getRg()
                    + "', '" + usuario.getOrgaoExpedidor()
                    + "', '" + usuario.getUfrg()
                    + "', '" + usuario.getDataNascimento()
                    + "', '" + usuario.getEmail()
                    + "', '" + usuario.getTipoUsuario()
                    + "', " + usuario.getEndereco(); 
                    
                    
            stringSQL = stringSQL + ")";
            comando.execute(stringSQL);

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void alterar(Usuario usuario) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update usuario set "
                    + "cpf = '" + usuario.getCpf() + "', "
                    + "login = '" + usuario.getLogin() + "', "
                    + "senha = '" + usuario.getSenha() + "', "
                    + "nomeCompleto = '" + usuario.getNomeCompleto() + "', "
                    + "naturalidade = '" + usuario.getNaturalidade() + "', "
                    + "nacionalidade = '" + usuario.getNacionalidade() + "', "
                    + "rg = '" + usuario.getRg() + "', "
                    + "orgaoExpedidor = '" + usuario.getOrgaoExpedidor() + "', "
                    + "ufrg = '" + usuario.getUfrg() + "', "
                    + "dataNascimento = '" + usuario.getDataNascimento() + "', "
                    + "email = '" + usuario.getEmail() + "', "
                    + "tipoUsuario = '" + usuario.getTipoUsuario();

            comando.execute(stringSQL);

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(Usuario usuario) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from usuario where cpf = "
                    + usuario.getCpf();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }

    }

    public static Usuario instanciarUsuario(ResultSet rs) throws SQLException {
        Usuario usuario = new Usuario(rs.getInt("cpf"),rs.getString("login"),rs.getString("senha"),rs.getString("nomeCompleto"),rs.getString("naturalidade"),rs.getString("nacionalidade"),rs.getString("rg"),rs.getString("orgaoExpedidor"),rs.getString("ufrg"),rs.getString("dataNascimento"),rs.getString("email"),rs.getString("endereco"),rs.getString("tipoUsuario"));
        return usuario;
    }

    public static List<Usuario> obterUsuarios() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Usuario> usuarios = new ArrayList<Usuario>();
        Usuario usuario = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM USUARIO");
            while (rs.next()) {
                usuario = instanciarUsuario(rs);
                usuarios.add(usuario);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return usuarios;
    }
    
    public static Usuario obterUsuario(int cpf) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Usuario usuario = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from Usuario where usuario.cpf = usuario.cpf and usuario.cpf = " + cpf);
            rs.first();
            usuario = instanciarUsuario(rs);

        } finally {
            fecharConexao(conexao, comando);
        }
        return usuario;
    }

}
