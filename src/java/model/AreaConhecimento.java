package model;

import dao.AreaConhecimentoDAO;
import dao.DAO;
import dao.ProjetoDAO;
import java.sql.SQLException;
import java.util.List;

public class AreaConhecimento extends DAO{

    private int numeroRegistroAreaConhecimento;
    private String nomeAreaConhecimento;
    
    

    public AreaConhecimento(int numeroRegistroAreaConhecimento, String nomeAreaConhecimento) {
        this.numeroRegistroAreaConhecimento = numeroRegistroAreaConhecimento;
        this.nomeAreaConhecimento = nomeAreaConhecimento;
        
    }
   
    public static List<AreaConhecimento> obterAreasConhecimentos()
            throws ClassNotFoundException, SQLException {
        return AreaConhecimentoDAO.obterAreasConhecimentos();

    }

    public static AreaConhecimento obterAreaConhecimento(int numeroRegistroAreaConhecimento)
            throws ClassNotFoundException, SQLException {
           return AreaConhecimentoDAO.obterAreaConhecimento(numeroRegistroAreaConhecimento);
         }
    
    public void gravar() throws SQLException, ClassNotFoundException {
         AreaConhecimentoDAO.gravar(this);
     }
      public void alterar() throws SQLException, ClassNotFoundException {
         AreaConhecimentoDAO.editar(this);
     }
        public void excluir() throws SQLException, ClassNotFoundException {
         AreaConhecimentoDAO.excluir(this);
     }
    
        

    public int getnumeroRegistroAreaConhecimento() {
        return numeroRegistroAreaConhecimento;
    }

    public void setnumeroRegistroAreaConhecimento(int numeroRegistroAreaConhecimento) {
        this.numeroRegistroAreaConhecimento = numeroRegistroAreaConhecimento;
    }

    public String getnomeAreaConhecimento() {
        return nomeAreaConhecimento;
    }

    public void setnomeAreaConhecimento(String nomeAreaConhecimento) {
        this.nomeAreaConhecimento = nomeAreaConhecimento;
    }

 
 
 
    public int getNumeroRegistroAreaConhecimento() {
        return numeroRegistroAreaConhecimento;
    }

    public void setNumeroRegistroAreaConhecimento(int numeroRegistroAreaConhecimento) {
        this.numeroRegistroAreaConhecimento = numeroRegistroAreaConhecimento;
    }

    public String getNomeAreaConhecimento() {
        return nomeAreaConhecimento;
    }

    public void setNomeAreaConhecimento(String nomeAreaConhecimento) {
        this.nomeAreaConhecimento = nomeAreaConhecimento;
    }

}
