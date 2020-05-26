package dao;

import static dao.DAO.fecharConexao;
import model.Edital;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EditalDAO extends DAO {

    public static void gravar(Edital edital) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "insert into edital "
                    + " values (" + edital.getNumeroRegistroEdital() + ", '" + edital.getDataInicio() + "', '" + edital.getDataTermino() + "', '" + edital.getVagas() + "', '" + edital.getnomeEdital() + "', '" + edital.isImplementacao()+ "', " ;

            if (edital.getCampus() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + edital.getCampus().getNumeroRegistroCampus();
            }
            stringSQL = stringSQL + ")";
            comando.execute(stringSQL);

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void alterar(Edital edital) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update edital set "
                    + "numeroRegistroEdital = '" + edital.getNumeroRegistroEdital() + "', "
                    + "nomeEdital = '" + edital.getnomeEdital()+ "' where numeroRegistroEdital= " + edital.getNumeroRegistroEdital();
            comando.execute(stringSQL);

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(Edital edital) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from edital where numeroRegistroEdital = "
                    + edital.getNumeroRegistroEdital();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static Edital obterEdital(int numeroRegistroEdital) throws ClassNotFoundException,
            SQLException {
        Connection conexao = null;
        Statement comando = null;
        Edital edital = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery(
                    "select * from edital where numeroRegistroEdital = " + numeroRegistroEdital);
            rs.first();
            edital = instanciarEdital(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return edital;
    }

    public static List<Edital> obterEditais()
            throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Edital> editais = new ArrayList<Edital>();
        Edital edital = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM EDITAL");
            while (rs.next()) {
                edital = instanciarEdital(rs);
                editais.add(edital);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return editais;
    }

    public static Edital instanciarEdital(ResultSet rs) throws SQLException {
        Edital edital = new Edital(rs.getInt("numeroRegistroEdital"), rs.getString("dataInicio"), rs.getString("dataTermino"), rs.getString("vagas"), rs.getString("nomeEdital"), rs.getInt("implementacao"), null);
        edital.setNumeroRegistroCampus(rs.getInt("numeroRegistroCampus"));
        return edital;
    }

}
