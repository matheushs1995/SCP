package dao;

import static dao.DAO.fecharConexao;
import model.Nucleo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class NucleoDAO extends DAO {

    public static void gravar(Nucleo nucleo) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "insert into nucleo "
                    +"values ("+ nucleo.getNumeroRegistroNucleo() + ", '" + nucleo.getNomeNucleo()+ "', ";
                    
                            
            if (nucleo.getDepartamento()== null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + nucleo.getDepartamento().getNumeroRegistroDepartamento();
            }
            stringSQL = stringSQL + ")";
            comando.execute(stringSQL);

            
            

        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
    public static void alterar(Nucleo nucleo) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update nucleo set "
                    + "numeroRegistroNucleo = '" + nucleo.getNumeroRegistroNucleo() + "', "
                    + "nomeNucleo = '" + nucleo.getNomeNucleo() + "' where numeroRegistroNucleo= " + nucleo.getNumeroRegistroNucleo();
            comando.execute(stringSQL);

        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
    public static void excluir(Nucleo nucleo) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from nucleo where numeroRegistroNucleo = "
                    + nucleo.getNumeroRegistroNucleo();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
    
    public static Nucleo obterNucleo(int numeroRegistroNucleo) throws ClassNotFoundException,
            SQLException {
        Connection conexao = null;
        Statement comando = null;
        Nucleo nucleo = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery(
                    "select * from nucleo where numeroRegistroNucleo = " + numeroRegistroNucleo);
            rs.first();
            nucleo = instanciarNucleo(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return nucleo;
    }
    
    public static List<Nucleo> obterNucleos()
            throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Nucleo> nucleos = new ArrayList<Nucleo>();
        Nucleo nucleo = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM NUCLEO");
            while (rs.next()) {
                nucleo = instanciarNucleo(rs);
                nucleos.add(nucleo);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return nucleos;
    }

    public static Nucleo instanciarNucleo(ResultSet rs) throws SQLException {
        Nucleo nucleo1= new Nucleo(rs.getInt("numeroRegistroNucleo"),rs.getString("nomeNucleo"),null);
        nucleo1.setNumeroRegistroDepartamento(rs.getInt("numeroRegistroDepartamento"));
    
        return nucleo1;
    }

}
