
package model;

import dao.AlunoDAO;
import dao.DAO;
import dao.PlanoIndividualDAO;
import dao.ProjetoDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlanoIndividual extends DAO {

    private int numeroRegistroPlanoIndividual;
    private String localRealizacaoProjeto;
    private String envolvimento;
    private String resultadoEsperado;
    private String cronogramaAtividade;
    private int numeroRegistroAluno;
    private int numeroRegistroProjeto;
    private Aluno aluno;
    private Projeto projeto;

    public PlanoIndividual(int numeroRegistroPlanoIndividual, String localRealizacaoProjeto, String envolvimento, String resultadoEsperado, String cronogramaAtividade, Aluno aluno, Projeto projeto) {
        this.numeroRegistroPlanoIndividual = numeroRegistroPlanoIndividual;
        this.localRealizacaoProjeto = localRealizacaoProjeto;
        this.envolvimento = envolvimento;
        this.resultadoEsperado = resultadoEsperado;
        this.cronogramaAtividade = cronogramaAtividade;
        this.aluno = aluno;
        this.projeto = projeto;
    }

    public static List<PlanoIndividual> obterPlanosIndividuais()
            throws ClassNotFoundException, SQLException {
        return PlanoIndividualDAO.obterPlanosIndividuais();

    }

    public static PlanoIndividual obterPlanoIndividual(int numeroRegistroPlanoIndividual)
            throws ClassNotFoundException, SQLException {
        return PlanoIndividualDAO.obterPlanoIndividual(numeroRegistroPlanoIndividual);
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        PlanoIndividualDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        PlanoIndividualDAO.alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        PlanoIndividualDAO.excluir(this);
    }

    public Aluno getAluno() throws SQLException, ClassNotFoundException {
        if ((aluno == null) && (numeroRegistroAluno != 0)) {
            aluno = AlunoDAO.obterAluno(numeroRegistroAluno);
        }
        return aluno;
    }

    public Projeto getProjeto() throws SQLException, ClassNotFoundException {
        if ((projeto == null) && (numeroRegistroProjeto != 0)) {
            projeto = ProjetoDAO.obterProjeto(numeroRegistroProjeto);
        }
        return projeto;
    }

    public int getNumeroRegistroPlanoIndividual() {
        return numeroRegistroPlanoIndividual;
    }

    public void setNumeroRegistroPlanoIndividual(int numeroRegistroPlanoIndividual) {
        this.numeroRegistroPlanoIndividual = numeroRegistroPlanoIndividual;
    }

    public String getLocalRealizacaoProjeto() {
        return localRealizacaoProjeto;
    }

    public void setLocalRealizacaoProjeto(String localRealizacaoProjeto) {
        this.localRealizacaoProjeto = localRealizacaoProjeto;
    }

    public String getEnvolvimento() {
        return envolvimento;
    }

    public void setEnvolvimento(String envolvimento) {
        this.envolvimento = envolvimento;
    }

    public String getResultadoEsperado() {
        return resultadoEsperado;
    }

    public void setResultadoEsperado(String resultadoEsperado) {
        this.resultadoEsperado = resultadoEsperado;
    }

    public String getCronogramaAtividade() {
        return cronogramaAtividade;
    }

    public void setCronogramaAtividade(String cronogramaAtividade) {
        this.cronogramaAtividade = cronogramaAtividade;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public int getNumeroRegistroAluno() {
        return numeroRegistroAluno;
    }

    public void setNumeroMatriculaAluno(int numeroRegistroAluno) {
        this.numeroRegistroAluno = numeroRegistroAluno;
    }

    public int getNumeroRegistroProjeto() {
        return numeroRegistroProjeto;
    }

    public void setNumeroRegistroProjeto(int numeroRegistroProjeto) {
        this.numeroRegistroProjeto = numeroRegistroProjeto;
    }

}
