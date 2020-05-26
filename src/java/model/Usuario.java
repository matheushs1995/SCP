package model;

import dao.UsuarioDAO;
import dao.DAO;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class Usuario extends DAO {
    
    private int cpf;
    private String login;
    private String senha;
    private String nomeCompleto;
    private String naturalidade;
    private String nacionalidade;
    private String rg;
    private String orgaoExpedidor;
    private String ufrg;
    private String dataNascimento;
    private String email;
    private String tipoUsuario;
    private String endereco;

    public Usuario(int cpf, String login, String senha, String nomeCompleto, String naturalidade, String nacionalidade, String rg, String orgaoExpedidor, String ufrg, String dataNascimento, String email,String endereco, String tipoUsuario) {
        this.cpf = cpf;
        this.login = login;
        this.senha = senha;
        this.nomeCompleto = nomeCompleto;
        this.naturalidade = naturalidade;
        this.nacionalidade = nacionalidade;
        this.rg = rg;
        this.orgaoExpedidor = orgaoExpedidor;
        this.ufrg = ufrg;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.tipoUsuario = tipoUsuario;
        this.endereco=endereco;
    }
   

    public static List<Usuario> obterUsuarios()
            throws ClassNotFoundException, SQLException {
        return UsuarioDAO.obterUsuarios();
    }

    public static Usuario obterUsuario(int cpf) throws ClassNotFoundException, SQLException {
        return UsuarioDAO.obterUsuario(cpf);

    }

    

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getOrgaoExpedidor() {
        return orgaoExpedidor;
    }

    public void setOrgaoExpedidor(String orgaoExpedidor) {
        this.orgaoExpedidor = orgaoExpedidor;
    }

    public String getUfrg() {
        return ufrg;
    }

    public void setUfrg(String ufrg) {
        this.ufrg = ufrg;
    }

    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    

}
