package model;

import dao.EditalDAO;
import dao.ProfessorDAO;
import dao.UsuarioDAO;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class Professor extends Usuario {

    private int numeroRegistroProfessor;
    private String areaAtuacao;
    private int cpf;
    private Usuario usuario;

    public static List<Professor> obterProfessores()
            throws ClassNotFoundException, SQLException {
        return ProfessorDAO.obterProfessores();
    }

     public Professor(int numeroRegistroProfessor, String areaAtuacao,int cpf, String login, String senha, String nomeCompleto, String naturalidade, String nacionalidade, String rg, String orgaoExpedidor, String ufrg, String dataNascimento, String email,String endereco, String tipoUsuario) {
        super(cpf,login,senha,nomeCompleto,naturalidade,nacionalidade,rg,orgaoExpedidor,ufrg,dataNascimento,email,endereco,"2");
        this.numeroRegistroProfessor=numeroRegistroProfessor;
        this.areaAtuacao = areaAtuacao;
        
    }
     
    public static Professor obterProfessor(int numeroRegistroProfessor)
            throws ClassNotFoundException, SQLException {
        return ProfessorDAO.obterProfessor(numeroRegistroProfessor); 
     
    }
    public int getNumeroRegistroProfessor() {
        return numeroRegistroProfessor;
    }

    public void setNumeroRegistroProfessor(int numeroRegistroProfessor) {
        this.numeroRegistroProfessor = numeroRegistroProfessor;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
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
        ProfessorDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        ProfessorDAO.alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        ProfessorDAO.excluir(this);
    }

}
