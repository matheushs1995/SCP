package dao;

import static dao.DAO.fecharConexao;
import model.PlanoIndividual;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlanoIndividualDAO extends DAO {

    public static void gravar(PlanoIndividual planoindividual) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "insert into planoindividual "
                     +"values ("+ planoindividual.getNumeroRegistroPlanoIndividual() + ", '" + planoindividual.getLocalRealizacaoProjeto() + "', '" + planoindividual.getEnvolvimento() + "', '" + planoindividual.getResultadoEsperado() + "', '" + planoindividual.getCronogramaAtividade()+ "', " ;
                             
            if (planoindividual.getAluno() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + planoindividual.getAluno().getNumeroRegistroAluno()+ ", " ;
            }
            
           
            if(planoindividual.getProjeto()== null){
                stringSQL = stringSQL + null;
            } else{
                stringSQL = stringSQL + planoindividual.getProjeto().getNumeroRegistroProjeto();
            }

            stringSQL = stringSQL + ")";
            comando.execute(stringSQL);
            
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
    public static void alterar(PlanoIndividual planoIndividual) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update planoIndividual set "
                    + "numeroRegistroPlanoIndividual = '" + planoIndividual.getNumeroRegistroPlanoIndividual() + "', "
                    + "localRealizacaoProjeto = '" + planoIndividual.getLocalRealizacaoProjeto()+ "', "
                    + "envolvimento = '" + planoIndividual.getEnvolvimento()+ "', "
                    + "resultadoEsperado = '" + planoIndividual.getResultadoEsperado()+ "', "
                    + "cronogramaAtividade = '" + planoIndividual.getCronogramaAtividade()+ "' where numeroRegistroPlanoIndividual= " + planoIndividual.getNumeroRegistroPlanoIndividual();
            comando.execute(stringSQL);

        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
    public static void excluir(PlanoIndividual planoIndividual) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from planoIndividual where numeroRegistroPlanoIndividual = "
                    + planoIndividual.getNumeroRegistroPlanoIndividual();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
    public static PlanoIndividual obterPlanoIndividual(int numeroRegistroPlanoIndividual) throws ClassNotFoundException,
            SQLException {
        Connection conexao = null;
        Statement comando = null;
        PlanoIndividual planoIndividual = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery(
                    "select * from planoIndividual where numeroRegistroPlanoIndividual = " + numeroRegistroPlanoIndividual);
            rs.first();
            planoIndividual = instanciarPlanoIndividual(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return planoIndividual;
    }
    
    
    public static List<PlanoIndividual> obterPlanosIndividuais()
            throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<PlanoIndividual> planosIndividuais = new ArrayList<PlanoIndividual>();
        PlanoIndividual planoIndividual = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM PLANOINDIVIDUAL");
            while (rs.next()) {
                planoIndividual = instanciarPlanoIndividual(rs);
                planosIndividuais.add(planoIndividual);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return planosIndividuais;
    }

    public static PlanoIndividual instanciarPlanoIndividual(ResultSet rs) throws SQLException {
        PlanoIndividual planoIndividual = new PlanoIndividual(rs.getInt("numeroRegistroPlanoIndividual"), rs.getString("localRealizacaoProjeto"), rs.getString("envolvimento"), rs.getString("resultadoEsperado"), rs.getString("cronogramaAtividade"), null, null);
        planoIndividual.setNumeroMatriculaAluno(rs.getInt("numeroRegistroAluno"));
        planoIndividual.setNumeroRegistroProjeto(rs.getInt("numeroRegistroProjeto"));
        return planoIndividual;
    }

}
