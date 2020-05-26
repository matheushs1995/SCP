package model;

import dao.CampusDAO;
import dao.DAO;
import java.sql.SQLException;
import java.util.List;

public class Campus extends DAO {

    private int numeroRegistroCampus;
    private String nomeCampus;

    public Campus(int numeroRegistroCampus, String nomeCampus) {
        this.numeroRegistroCampus = numeroRegistroCampus;
        this.nomeCampus = nomeCampus;
    }

    public static List<Campus> obterCampi()
            throws ClassNotFoundException, SQLException {
        return CampusDAO.obterCampi();
    }

    public static Campus obterCampus(int numeroRegistroCampus)
            throws ClassNotFoundException, SQLException {
        return CampusDAO.obterCampus(numeroRegistroCampus);
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        CampusDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        CampusDAO.editar(this);
    }

    public void editar() throws SQLException, ClassNotFoundException {
        CampusDAO.editar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        CampusDAO.excluir(this);
    }

    public int getNumeroRegistroCampus() {
        return numeroRegistroCampus;
    }

    public void setNumeroRegistroCampus(int numeroRegistroCampus) {
        this.numeroRegistroCampus = numeroRegistroCampus;
    }

    public String getNomeCampus() {
        return nomeCampus;
    }

    public void setNomeCampus(String nomeCampus) {
        this.nomeCampus = nomeCampus;
    }

}
