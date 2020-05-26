package model;

import dao.CampusDAO;
import dao.DAO;
import dao.DepartamentoDAO;
import dao.NucleoDAO;
import java.sql.SQLException;
import java.util.List;

public class Nucleo extends DAO {

    private int numeroRegistroNucleo;
    private String nomeNucleo;
    private int numeroRegistroDepartamento;
    
    private Departamento departamento;
    
    
    public Nucleo(int numeroRegistroNucleo, String nomeNucleo, Departamento departamento) {
        this.numeroRegistroNucleo = numeroRegistroNucleo;
        this.nomeNucleo = nomeNucleo;
        this.departamento = departamento;
        
        
    }
    
    public static List<Nucleo> obterNucleos()
            throws ClassNotFoundException, SQLException {
        return NucleoDAO.obterNucleos();

    }
        public static Nucleo obterNucleo(int numeroRegistroNucleo)
            throws ClassNotFoundException, SQLException {
           return NucleoDAO.obterNucleo(numeroRegistroNucleo);
         }

   
        
    public void gravar() throws SQLException, ClassNotFoundException {
         NucleoDAO.gravar(this);
     }
      public void alterar() throws SQLException, ClassNotFoundException {
         NucleoDAO.alterar(this);
     }
        public void excluir() throws SQLException, ClassNotFoundException {
         NucleoDAO.excluir(this);
     }

    
    
    public Departamento getDepartamento() throws SQLException, ClassNotFoundException {
        if ((departamento == null) && (numeroRegistroDepartamento != 0)) {
            departamento = DepartamentoDAO.obterDepartamento(numeroRegistroDepartamento);
        }
        return departamento;
    }
    
    
    
    
    public int getNumeroRegistroNucleo() {
        return numeroRegistroNucleo;
    }

    public void setNumeroRegistroNucleo(int numeroRegistroNucleo) {
        this.numeroRegistroNucleo = numeroRegistroNucleo;
    }

    public String getNomeNucleo() {
        return nomeNucleo;
    }

    public void setNomeNucleo(String nomeNucleo) {
        this.nomeNucleo = nomeNucleo;
    }

    public void setDepartamento (Departamento departamento) {
        this.departamento=departamento;
    }

    public int numeroRegistroDepartamento() {
        return numeroRegistroDepartamento;
    }


    public int getNumeroRegistroDepartamento() {
        return numeroRegistroDepartamento;
    }

    public void setNumeroRegistroDepartamento(int numeroRegistroDepartamento) {
        this.numeroRegistroDepartamento = numeroRegistroDepartamento;
    }

    
}
