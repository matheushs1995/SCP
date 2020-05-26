package model;

import dao.CursoDAO;
import dao.DAO;
import dao.NucleoDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Curso extends DAO {

    private int numeroRegistroCurso;
    private String nomeCurso;
    private int numeroRegistroNucleo;
    private Nucleo nucleo;

    public static List<Curso> obterCursos()
            throws ClassNotFoundException, SQLException {
        return CursoDAO.obterCursos();

    }

    public Curso(int numeroRegistroCurso, String nomeCurso, Nucleo nucleo) {
        this.numeroRegistroCurso = numeroRegistroCurso;
        this.nomeCurso = nomeCurso;
        this.nucleo = nucleo;

    }

    public Curso(int aInt, String string) {

    }

    public int getNumeroRegistroCurso() {
        return numeroRegistroCurso;
    }

    public void setNumeroRegistroCurso(int numeroRegistroCurso) {
        this.numeroRegistroCurso = numeroRegistroCurso;
    }
    
    public static Curso obterCurso(int numeroRegistroCurso) throws ClassNotFoundException, SQLException {
        return CursoDAO.obterCurso(numeroRegistroCurso);
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public Nucleo getNucleo() throws ClassNotFoundException, SQLException {
        if ((nucleo == null) && (numeroRegistroNucleo != 0)) {
            nucleo = NucleoDAO.obterNucleo(numeroRegistroNucleo);
        }
        return nucleo;
    }

    public void setNucleo(Nucleo nucleo) {
        this.nucleo = nucleo;
    }

    public int getNumeroRegistroNucleo() {
        return numeroRegistroNucleo;
    }

    public void setNumeroRegistroNucleo(int numeroRegistroNucleo) {
        this.numeroRegistroNucleo = numeroRegistroNucleo;
    }
    
    public void gravar() throws SQLException, ClassNotFoundException {
        CursoDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        CursoDAO.alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        CursoDAO.excluir(this);
    }

}
