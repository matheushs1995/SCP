package model;

import dao.AcompanhamentoMensalDAO;
import dao.DAO;
import java.sql.SQLException;
import java.util.List;
import dao.AlunoDAO;
import dao.CursoDAO;
import dao.ProjetoDAO;

public class AcompanhamentoMensal extends DAO {

    private int numeroRegistroAcompanhamentoMensal;
    private String situacao;
    private String avaliacaoProfessor;
    private String comentario;
    private int numeroRegistroAluno;
    private Aluno aluno;
    private int numeroRegistroProjeto;
    private Projeto projeto;

    public static List<AcompanhamentoMensal> obterAcompanhamentosMensais()
            throws ClassNotFoundException, SQLException {
        return AcompanhamentoMensalDAO.obterAcompanhamentosMensais();
    }

    public static AcompanhamentoMensal obterAcompanhamentoMensal(int numeroRegistroAcompanhamentoMensal)
            throws ClassNotFoundException, SQLException {
        return AcompanhamentoMensalDAO.obterAcompanhamentoMensalDAO(numeroRegistroAcompanhamentoMensal);
    }
    
    public AcompanhamentoMensal(int numeroRegistroAcompanhamentoMensal, String situacao, String avaliacaoProfessor, String comentario, Aluno aluno, Projeto projeto) {
        this.numeroRegistroAcompanhamentoMensal = numeroRegistroAcompanhamentoMensal;
        this.situacao = situacao;
        this.avaliacaoProfessor = avaliacaoProfessor;
        this.comentario = comentario;
        this.aluno = aluno;
        this.projeto = projeto;
    }

    public int getNumeroRegistroAcompanhamentoMensal() {
        return numeroRegistroAcompanhamentoMensal;
    }

    public void setNumeroRegistroAcompanhamentoMensal(int numeroRegistroAcompanhamentoMensal) {
        this.numeroRegistroAcompanhamentoMensal = numeroRegistroAcompanhamentoMensal;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getAvaliacaoProfessor() {
        return avaliacaoProfessor;
    }

    public void setAvaliacaoProfessor(String avaliacaoProfessor) {
        this.avaliacaoProfessor = avaliacaoProfessor;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getNumeroRegistroAluno() {
        return numeroRegistroAluno;
    }

    public void setNumeroRegistroAluno(int numeroRegistroAluno) {
        this.numeroRegistroAluno = numeroRegistroAluno;
    }

    public Aluno getAluno() throws SQLException, ClassNotFoundException {
        if((aluno == null) && (numeroRegistroAluno != 0)) {
            aluno = AlunoDAO.obterAluno(numeroRegistroAluno);
        }
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public int getNumeroRegistroProjeto() throws SQLException, ClassNotFoundException {
        if((projeto == null) && (numeroRegistroProjeto !=0)) {
            projeto = ProjetoDAO.obterProjeto(numeroRegistroProjeto);
        }
        return numeroRegistroProjeto;
    }

    public void setNumeroRegistroProjeto(int numeroRegistroProjeto) {
        this.numeroRegistroProjeto = numeroRegistroProjeto;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }
    public void gravar() throws SQLException, ClassNotFoundException {
        AcompanhamentoMensalDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        AcompanhamentoMensalDAO.alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        AcompanhamentoMensalDAO.excluir(this);
    }

}
