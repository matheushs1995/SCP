package model;

import dao.FuncionarioDAO;
import dao.UsuarioDAO;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class Funcionario extends Usuario {

    private int numeroRegistroFuncionario;
    private String cargo;
    private int cpf;
    private Usuario usuario;

    public static List<Funcionario> obterFuncionarios()
            throws ClassNotFoundException, SQLException {
        return FuncionarioDAO.obterFuncionarios();

    }

    public static Funcionario obterFuncionario(int numeroRegistroFuncionario)
            throws ClassNotFoundException, SQLException {
        return FuncionarioDAO.obterFuncionario(numeroRegistroFuncionario);
    }
     public Funcionario(int numeroRegistroFuncionario, String nomeCompleto,int cpf, String rg,String ufrg, String orgaoExpedidor,String dataNascimento,String endereco, String naturalidade, String nacionalidade,String cargo,  String login, String senha,   String email,String tipoUsuario,Usuario usuario) {
        super(cpf,login,senha,nomeCompleto,naturalidade,nacionalidade,rg,orgaoExpedidor,ufrg,dataNascimento,email,endereco,"1");
        this.numeroRegistroFuncionario = numeroRegistroFuncionario;
        this.cargo = cargo;
        this.usuario=usuario;
    }   
    

    public int getNumeroRegistroFuncionario() {
        return numeroRegistroFuncionario;
    }

    public void setNumeroRegistroFuncionario(int numeroRegistroFuncionario) {
        this.numeroRegistroFuncionario = numeroRegistroFuncionario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public Usuario getUsuario() throws SQLException, ClassNotFoundException {
        if ((usuario == null) && (cpf != 0)) {
            usuario = UsuarioDAO.obterUsuario(cpf);
        }
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void gravar() throws SQLException, ClassNotFoundException {
        FuncionarioDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        FuncionarioDAO.alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        FuncionarioDAO.excluir(this);
    }

}
