package dao;

import static dao.DAO.fecharConexao;
import model.AcompanhamentoMensal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AcompanhamentoMensalDAO extends DAO {

   public static void gravar(AcompanhamentoMensal acompanhamento) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "insert into acompanhamentoMensal "
                    + "values (" + acompanhamento.getNumeroRegistroAcompanhamentoMensal() + ", '" + acompanhamento.getSituacao()+"', '"+
                     acompanhamento.getAvaliacaoProfessor() + "', '" + acompanhamento.getComentario()+"', "+
                     acompanhamento.getAluno().getNumeroRegistroAluno()+", "+
                     + acompanhamento.getProjeto().getNumeroRegistroProjeto()+")";

         comando.execute(stringSQL);   
            
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void alterar(AcompanhamentoMensal acompanhamentoMensal) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update acompanhamentoMensal set "
                    + " numeroRegistroAcompanhamentoMensal = " + acompanhamentoMensal.getNumeroRegistroAcompanhamentoMensal() + ", "
                    + " situacao = '" +acompanhamentoMensal.getSituacao()  + "', "
                    + " avaliacaoProfessor = '" +acompanhamentoMensal.getAvaliacaoProfessor()  + "', "
                    + " comentario = '" +acompanhamentoMensal.getComentario()  + "', "
                    + " numeroRegistroAluno= ";
                    
            
            if (acompanhamentoMensal.getAluno() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + acompanhamentoMensal.getAluno().getNumeroRegistroAluno();
            } 
            
            stringSQL=stringSQL+", numeroRegistroProjeto= ";
            
            if (acompanhamentoMensal.getProjeto() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + acompanhamentoMensal.getProjeto().getNumeroRegistroProjeto();
            }        
                    
                    
                    
            stringSQL=stringSQL+" where numeroRegistroAcompanhamentoMensal= " + acompanhamentoMensal.getNumeroRegistroAcompanhamentoMensal();

            
            comando.execute(stringSQL);

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(AcompanhamentoMensal acompanhamentoMensal) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from acompanhamentoMensal where numeroRegistroAcompanhamentoMensal = "
                    + acompanhamentoMensal.getNumeroRegistroAcompanhamentoMensal();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static AcompanhamentoMensal instanciarAcompanhamentoMensal(ResultSet rs) throws SQLException {
        AcompanhamentoMensal acompanhamentoMensal = new AcompanhamentoMensal(
                rs.getInt("numeroRegistroAcompanhamentoMensal"),
                rs.getString("situacao"),
                rs.getString("avaliacaoProfessor"),
                rs.getString("comentario"),
                null, null);

        acompanhamentoMensal.setNumeroRegistroAluno(rs.getInt("numeroRegistroAluno"));
        acompanhamentoMensal.setNumeroRegistroProjeto(rs.getInt("numeroRegistroProjeto"));

        return acompanhamentoMensal;
    }

    public static List<AcompanhamentoMensal> obterAcompanhamentosMensais() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<AcompanhamentoMensal> acompanhamentos = new ArrayList<AcompanhamentoMensal>();
        AcompanhamentoMensal acompanhamento = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM ACOMPANHAMENTOMENSAL");
            while (rs.next()) {
                acompanhamento = instanciarAcompanhamentoMensal(rs);
                acompanhamentos.add(acompanhamento);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return acompanhamentos;
    }

    public static AcompanhamentoMensal obterAcompanhamentoMensalDAO(int numeroRegistroAcompanhamentoMensal) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        AcompanhamentoMensal acompanhamentoMensal = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from AcompanhamentoMensal where numeroRegistroAcompanhamentoMensal= " + numeroRegistroAcompanhamentoMensal);
            rs.first();
            acompanhamentoMensal = instanciarAcompanhamentoMensal(rs);

        } finally {
            fecharConexao(conexao, comando);
        }
        return acompanhamentoMensal;
    }

}
