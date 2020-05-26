package model;

import dao.CampusDAO;
import dao.DAO;
import dao.DepartamentoDAO;
import java.sql.SQLException;
import java.util.List;

public class Departamento extends DAO {

    private int numeroRegistroDepartamento;
    private String nomeDepartamento;
    private int numeroRegistroCampus;
    private Campus campus;

    public Departamento(int numeroRegistroDepartamento, String nomeDepartamento, Campus campus) {
        this.numeroRegistroDepartamento = numeroRegistroDepartamento;
        this.nomeDepartamento = nomeDepartamento;
        this.campus = campus;
    }

    public static List<Departamento> obterDepartamentos()
            throws ClassNotFoundException, SQLException {
        return DepartamentoDAO.obterDepartamentos();
    }

    public static Departamento obterDepartamento(int numeroRegistroDepartamento)
            throws ClassNotFoundException, SQLException {
        return DepartamentoDAO.obterDepartamento(numeroRegistroDepartamento);
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        DepartamentoDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        DepartamentoDAO.editar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        DepartamentoDAO.excluir(this);
    }

    public Campus getCampus() throws SQLException, ClassNotFoundException {
        if ((campus == null) && (numeroRegistroCampus != 0)) {
            campus = CampusDAO.obterCampus(numeroRegistroCampus);
        }
        return campus;
    }

    public int getNumeroRegistroDepartamento() {
        return numeroRegistroDepartamento;
    }

    public void setNumeroRegistroDepartamento(int numeroRegistroDepartamento) {
        this.numeroRegistroDepartamento = numeroRegistroDepartamento;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    public String getNomeDepartamento() {
        return nomeDepartamento;
    }

    public void setNomeDepartamento(String nomeDepartamento) {
        this.nomeDepartamento = nomeDepartamento;
    }

    public int getNumeroRegistroCampus() {
        return numeroRegistroCampus;
    }

    public void setNumeroRegistroCampus(int numeroRegistroCampus) {
        this.numeroRegistroCampus = numeroRegistroCampus;
    }

}
