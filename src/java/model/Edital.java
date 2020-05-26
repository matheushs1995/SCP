package model;

import dao.CampusDAO;
import dao.DAO;
import dao.EditalDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Edital extends DAO {

    private int numeroRegistroEdital;
    private String dataInicio; 
    private String dataTermino;
    private String vagas;
    private String nomeEdital;
    private int implementacao;
    private int numeroRegistroCampus;
    private Campus campus;

    public Edital(int numeroRegistroEdital, String dataInicio, String dataTermino, String vagas, String nomeEdital, int implementacao, Campus campus) {
        this.numeroRegistroEdital = numeroRegistroEdital;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.vagas = vagas;
        this.nomeEdital = nomeEdital;
        this.implementacao = implementacao;
        this.campus = campus;
    }

    public static List<Edital> obterEditais()
            throws ClassNotFoundException, SQLException {
        return EditalDAO.obterEditais();
    }

    public static Edital obterEdital(int numeroRegistroEdital)
            throws ClassNotFoundException, SQLException {
        return EditalDAO.obterEdital(numeroRegistroEdital);
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        EditalDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        EditalDAO.alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        EditalDAO.excluir(this);
    }

    public Campus getCampus() throws SQLException, ClassNotFoundException {
        if ((campus == null) && (numeroRegistroCampus != 0)) {
            campus = CampusDAO.obterCampus(numeroRegistroCampus);
        }
        return campus;
    }

    public int getNumeroRegistroEdital() {
        return numeroRegistroEdital;
    }

    public void setNumeroRegistro(int numeroRegistro) {
        this.numeroRegistroEdital = numeroRegistroEdital;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(String dataTermino) {
        this.dataTermino = dataTermino;
    }

    public String getVagas() {
        return vagas;
    }

    public void setVagas(String vagas) {
        this.vagas = vagas;
    }

    public String getnomeEdital() {
        return nomeEdital;
    }

    public void setnomeEdital(String nomeEdital) {
        this.nomeEdital = nomeEdital;
    }

    public int isImplementacao() {
        return implementacao;
    }

    public void setImplementacao(int implementacao) {
        this.implementacao = implementacao;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    public int getNumeroRegistroCampus() {
        return numeroRegistroCampus;
    }

    public void setNumeroRegistroCampus(int numeroRegistroCampus) {
        this.numeroRegistroCampus = numeroRegistroCampus;
    }

}
