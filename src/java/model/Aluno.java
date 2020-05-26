package model;

import dao.AlunoDAO;
import dao.UsuarioDAO;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class Aluno extends Usuario {

    private int numeroRegistroAluno;

    private String nomeBanco;
    private String agencia;
    private String numeroConta;
    private String dadosResponsavel;

    private Curso curso;
    private int Curso_codCurso;
    private Usuario usuario;
    private int cpf;
    
    public Aluno(int numeroRegistroAluno,String nomeBanco, String agencia, String numeroConta, String dadosResponsavel,int cpf, String login, String senha, String nomeCompleto, String naturalidade, String nacionalidade, String rg, String orgaoExpedidor, String ufrg, String dataNascimento, String email,String endereco, String tipoUsuario,Curso curso,Usuario usuario) {
        super(cpf,login,senha,nomeCompleto,naturalidade,nacionalidade,rg,orgaoExpedidor,ufrg,dataNascimento,email,endereco,"3");
        this.numeroRegistroAluno=numeroRegistroAluno;
        this.nomeBanco = nomeBanco;
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.dadosResponsavel = dadosResponsavel;
        this.curso=curso;
        this.usuario=usuario;
    }


    public static List<Aluno> obterAlunos()
            throws ClassNotFoundException, SQLException {
        return AlunoDAO.obterAlunos();

    }
    
    public static Aluno obterAluno(int numeroRegistroAluno)
            throws ClassNotFoundException, SQLException {
        return AlunoDAO.obterAluno(numeroRegistroAluno);
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
        AlunoDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        AlunoDAO.alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        AlunoDAO.excluir(this);
    }

    public int getNumeroRegistroAluno() {
        return numeroRegistroAluno;
    }

    public void setNumeroRegistroAluno(int numeroRegistroAluno) {
        this.numeroRegistroAluno = numeroRegistroAluno;
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getDadosResponsavel() {
        return dadosResponsavel;
    }

    public void setDadosResponsavel(String dadosResponsavel) {
        this.dadosResponsavel = dadosResponsavel;
    }


    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public int getCurso_codCurso() {
        return Curso_codCurso;
    }

    public void setCurso_codCurso(int Curso_codCurso) {
        this.Curso_codCurso = Curso_codCurso;
    }

    public void setCpf(int cpf){
        this.cpf=cpf;
    }
    
    public int getCpf(){
        return cpf;
    }
}
