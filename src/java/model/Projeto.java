package model;

import dao.DAO;
import dao.FuncionarioDAO;
import dao.ProfessorDAO;
import dao.ProjetoDAO;
import java.sql.SQLException;
import java.util.List;

public class Projeto extends DAO {

    private int numeroRegistroProjeto;
    private String nomeProjeto;
    private String implementacao;
    private String dataInicio;
    private String dataTermino;
    private String renovacao; 
    private String cargaHorariaSemanal;
    private String justificativaProblema;
    private String referencialTeorico;
    private String objetivo;
    private String metodologia;
    private String resultadoEsperado;
    private String cronograma;
    private String orcamento;
    private String referenciaBibliografica;
    private int numeroRegistroOrientador;
    private int numeroRegistroEdital;
    private int numeroRegistroAreaConhecimento;
    private Professor orientador;
    private Edital edital;
    private AreaConhecimento areaConhecimento;

    public Projeto(int numeroRegistroProjeto, String nomeProjeto, String implementacao, String dataInicio, String dataTermino, String renovacao, String cargaHorariaSemanal, String justificativaProblema, String referencialTeorico, String objetivo, String metodologia, String resultadoEsperado, String cronograma, String orcamento, String referenciaBibliografica, Professor orientador, Edital edital,AreaConhecimento areaConhecimento) {
        this.numeroRegistroProjeto = numeroRegistroProjeto;
        this.nomeProjeto = nomeProjeto;
        this.implementacao = implementacao;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.renovacao = renovacao;
        this.cargaHorariaSemanal = cargaHorariaSemanal;
        this.justificativaProblema = justificativaProblema;
        this.referencialTeorico = referencialTeorico;
        this.objetivo = objetivo;
        this.metodologia = metodologia;
        this.resultadoEsperado = resultadoEsperado;
        this.cronograma = cronograma;
        this.orcamento = orcamento;
        this.referenciaBibliografica = referenciaBibliografica;
        this.orientador=orientador;
        this.edital = edital;
       this.areaConhecimento=areaConhecimento;
    }
    
    
    

    public static List<Projeto> obterProjetos()
            throws ClassNotFoundException, SQLException {
        return ProjetoDAO.obterProjetos();
    }

    public static Projeto obterProjeto(int numeroRegistroProjeto)
            throws ClassNotFoundException, SQLException {
           return ProjetoDAO.obterProjeto(numeroRegistroProjeto);
         }

    
    public void gravar() throws SQLException, ClassNotFoundException {
         ProjetoDAO.gravar(this);
     }
      public void alterar() throws SQLException, ClassNotFoundException {
         ProjetoDAO.alterar(this);
     }
        public void excluir() throws SQLException, ClassNotFoundException {
         ProjetoDAO.excluir(this);
     }
        
        public Professor getOrientador() throws SQLException, ClassNotFoundException {
        if ((orientador == null) && (numeroRegistroOrientador != 0)) {
            orientador = ProfessorDAO.obterProfessor(numeroRegistroOrientador);
        }
        return orientador;
    }
        
        

    public int getNumeroRegistroProjeto() {
        return numeroRegistroProjeto;
    }

    public void setNumeroRegistroProjeto(int numeroRegistroProjeto) {
        this.numeroRegistroProjeto = numeroRegistroProjeto;
    }

    public String getnomeProjeto() {
        return nomeProjeto;
    }

    public void setnomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }

    public String isImplementacao() {
        return implementacao;
    }

    public void setImplementacao(String implementacao) {
        this.implementacao = implementacao;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(String dataTermino) {
        this.dataTermino = dataTermino;
    }

    public String getRenovacao() {
        return renovacao;
    }

    public void setRenovacao(String renovacao) {
        this.renovacao = renovacao;
    }

    public String getCargaHorariaSemanal() {
        return cargaHorariaSemanal;
    }

    public void setCargaHorariaSemanal(String cargaHorariaSemanal) {
        this.cargaHorariaSemanal = cargaHorariaSemanal;
    }

    public String getJustificativaProblema() {
        return justificativaProblema;
    }

    public void setJustificativaProblema(String justificativaProblema) {
        this.justificativaProblema = justificativaProblema;
    }

    public String getReferencialTeorico() {
        return referencialTeorico;
    }

    public void setReferencialTeorico(String referencialTeorico) {
        this.referencialTeorico = referencialTeorico;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getMetodologia() {
        return metodologia;
    }

    public void setMetodologia(String metodologia) {
        this.metodologia = metodologia;
    }

    public String getResultadoEsperado() {
        return resultadoEsperado;
    }

    public void setResultadoEsperado(String resultadoEsperado) {
        this.resultadoEsperado = resultadoEsperado;
    }

    public String getCronograma() {
        return cronograma;
    }

    public void setCronograma(String cronograma) {
        this.cronograma = cronograma;
    }

    public String getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(String orcamento) {
        this.orcamento = orcamento;
    }

    public String getReferenciaBibliografica() {
        return referenciaBibliografica;
    }

    public void setReferenciaBibliografica(String referenciaBibliografica) {
        this.referenciaBibliografica = referenciaBibliografica;
    }

    public String getNomeProjeto() {
        return nomeProjeto;
    }

    public void setNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }

    public int getNumeroRegistroEdital() {
        return numeroRegistroEdital;
    }

    public void setNumeroRegistroEdital(int numeroRegistroEdital) {
        this.numeroRegistroEdital = numeroRegistroEdital;
    }

    
    public void setOrientador(Professor orientador) {
        this.orientador = orientador;
    }

    public Edital getEdital() {
        return edital;
    }

    public void setEdital(Edital edital) {
        this.edital = edital;
    }

    public int getNumeroRegistroOrientador() {
        return numeroRegistroOrientador;
    }

    public void setNumeroRegistroOrientador(int numeroRegistroOrientador) {
        this.numeroRegistroOrientador = numeroRegistroOrientador;
    }

    public int getNumeroRegistroAreaConhecimento() {
        return numeroRegistroAreaConhecimento;
    }

    public void setNumeroRegistroAreaConhecimento(int numeroRegistroAreaConhecimento) {
        this.numeroRegistroAreaConhecimento = numeroRegistroAreaConhecimento;
    }

    public AreaConhecimento getAreaConhecimento() {
        return areaConhecimento;
    }

    public void setAreaConhecimento(AreaConhecimento areaConhecimento) {
        this.areaConhecimento = areaConhecimento;
    }

}
