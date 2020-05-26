package dao;

import static dao.DAO.fecharConexao;
import model.Projeto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Funcionario;
import model.Edital;


public class ProjetoDAO extends DAO {

    public static void gravar(Projeto projeto) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "insert into projeto values("
                     + projeto.getNumeroRegistroProjeto() + ", '" + projeto.getnomeProjeto()+"', '"
                     + projeto.isImplementacao() + "', '" + projeto.getDataInicio()+"', '"
                     + projeto.getDataTermino() + "', '" + projeto.getRenovacao()+"', '"
                     + projeto.getCargaHorariaSemanal() + "', '" + projeto.getJustificativaProblema()+"', '"
                     + projeto.getReferencialTeorico() + "', '" + projeto.getObjetivo()+"', '"+ projeto.getMetodologia()+"', '"
                     + projeto.getResultadoEsperado() + "', '" + projeto.getCronograma()+ "', '"
                     + projeto.getOrcamento() + "', '" + projeto.getReferenciaBibliografica()+ "', ";
                    
                            
            if (projeto.getOrientador()== null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + projeto.getOrientador().getNumeroRegistroProfessor();
            }
            
            stringSQL = stringSQL + ",";
            
            
            if (projeto.getEdital()== null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + projeto.getEdital().getNumeroRegistroEdital();
            }
            
            stringSQL = stringSQL + ",";
            
          
            
          
            if (projeto.getAreaConhecimento()== null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + projeto.getAreaConhecimento().getNumeroRegistroAreaConhecimento();
            }
            
           
            
            stringSQL = stringSQL + ")";
            comando.execute(stringSQL);


        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
    public static void alterar(Projeto projeto) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update projeto set "
                    + "numeroRegistroProjeto = '" + projeto.getNumeroRegistroProjeto() + "', "
                    + "nomeProjeto = '" + projeto.getnomeProjeto() + "' where numeroRegistroProjeto= " + projeto.getNumeroRegistroProjeto();
            comando.execute(stringSQL);

        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
    public static void excluir(Projeto projeto) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from projeto where numeroRegistroProjeto = "
                    + projeto.getNumeroRegistroProjeto();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
    public static Projeto obterProjeto(int numeroRegistroProjeto) throws ClassNotFoundException,
            SQLException {
        Connection conexao = null;
        Statement comando = null;
        Projeto projeto = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery(
                    "select * from projeto where numeroRegistroProjeto = " + numeroRegistroProjeto);
            rs.first();
            projeto = instanciarProjeto(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return projeto;
    }
    
    
    public static List<Projeto> obterProjetos()
            throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Projeto> projetos = new ArrayList<Projeto>();
        Projeto projeto = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM PROJETO");
            while (rs.next()) {
                projeto = instanciarProjeto(rs);
                projetos.add(projeto);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return projetos;
    }

    public static Projeto instanciarProjeto(ResultSet rs) throws SQLException {
        Projeto projeto = new Projeto(rs.getInt("numeroRegistroProjeto"), rs.getString("nomeProjeto"), rs.getString("implementacao"), rs.getString("dataInicio"), rs.getString("dataTermino"), rs.getString("renovacao"), rs.getString("cargaHorariaSemanal"), rs.getString("justificativaProblema"), rs.getString("referencialTeorico"), rs.getString("objetivo"), rs.getString("metodologia"), rs.getString("resultadoEsperado"), rs.getString("cronograma"), rs.getString("orcamento"), rs.getString("referenciaBibliografica"), null, null,null);
        
        projeto.setNumeroRegistroOrientador(rs.getInt("numeroRegistroOrientador"));
        projeto.setNumeroRegistroEdital(rs.getInt("numeroRegistroEdital"));
        projeto.setNumeroRegistroAreaConhecimento(rs.getInt("numeroRegistroAreaConhecimento"));
        return projeto;
    }

}
