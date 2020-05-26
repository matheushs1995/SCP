/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AreaConhecimento;
import model.Edital;
import model.Funcionario;
import model.Professor;
import model.Projeto;


public class ManterProjetoController extends HttpServlet{
    

/**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        String acao = request.getParameter("acao");
        if (acao.equals("confirmarOperacao")) {
            confirmarOperacao(request,response);
        } else {
            if (acao.equals("prepararOperacao")) {
                prepararOperacao(request, response);

            }
        }
    }

    protected void prepararOperacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("professores",Professor.obterProfessores());
            request.setAttribute("editais", Edital.obterEditais());
            request.setAttribute("areasConhecimento", AreaConhecimento.obterAreasConhecimentos());
            
           if (!operacao.equals("Incluir")) {
                int numeroRegistroProjeto = Integer.parseInt(request.getParameter("numeroRegistroProjeto"));
                Projeto projeto = Projeto.obterProjeto(numeroRegistroProjeto);
                request.setAttribute("projeto", projeto);
            }
        
        RequestDispatcher view = request.getRequestDispatcher("/ManterProjeto.jsp");
        view.forward(request, response);
        }
    
    catch(ServletException e )  {
        throw e;
    }
    
    catch(IOException e ){
        throw new ServletException(e);
    }
    catch(SQLException e){ throw new ServletException(e); 
         }
    catch(ClassNotFoundException e) {

    throw new ServletException(e);
    }
        
        
}
   
       private void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, ServletException, IOException ,SQLException , ClassNotFoundException  {
           
           String operacao=request.getParameter("operacao");
           int numeroRegistroProfessor = Integer.parseInt(request.getParameter("optProfessor"));
           int numeroRegistroEdital = Integer.parseInt(request.getParameter("optEdital"));
           int numeroRegistroAreaConhecimento = Integer.parseInt(request.getParameter("optAreaConhecimento"));
          
           int numeroRegistroProjeto = Integer.parseInt(request.getParameter("txtNumeroRegistroProjeto"));
           String nomeProjeto = request.getParameter("txtNomeProjeto");
           String implementacao = request.getParameter("txtImplementacao");
           String dataInicio = request.getParameter("txtDataInicio");
           String dataTermino = request.getParameter("txtDataTermino");
           String renovacao = request.getParameter("txtRenovacao");
           String cargaHorariaSemanal = request.getParameter("txtCargaHorariaSemanal");
           String justificativaProblema = request.getParameter("txtJustificativaProblema");
           String referencialTeorico = request.getParameter("txtReferencialTeorico");
           String objetivo = request.getParameter("txtObjetivo");
           String metodologia = request.getParameter("txtMetodologia");
           String resultadoEsperado = request.getParameter("txtResultadoEsperado");
           String cronograma = request.getParameter("txtCronograma");
           String orcamento = request.getParameter("txtOrcamento");
           String referenciaBibliografica = request.getParameter("txtReferenciaBibliografica");
           
           try {
             Professor professor =null;
              if(numeroRegistroProfessor !=0 ) {
                 professor=Professor.obterProfessor(numeroRegistroProfessor);
              }
             Edital edital = null;
              if(numeroRegistroEdital !=0){
                  edital=Edital.obterEdital(numeroRegistroEdital);
              }
              
              AreaConhecimento areaConhecimento= null;
              if(numeroRegistroAreaConhecimento !=0){
                  areaConhecimento=AreaConhecimento.obterAreaConhecimento(numeroRegistroAreaConhecimento);
              }
              
             Projeto projeto = new Projeto (numeroRegistroProjeto, nomeProjeto, implementacao, dataInicio, dataTermino, renovacao, cargaHorariaSemanal, justificativaProblema, referencialTeorico, objetivo, metodologia, resultadoEsperado, cronograma, orcamento, referenciaBibliografica,professor,edital,areaConhecimento);
             
             if(operacao.equals("Incluir")){
                  projeto.gravar();
              }else{
                  if(operacao.equals("Editar")){
                      projeto.alterar();
                  } else{
                      if(operacao.equals("Excluir")){
                          projeto.excluir();
                      }
                  }
              }
             
                   RequestDispatcher view = 
                    request.getRequestDispatcher("PesquisarProjetoController");
         view.forward(request,response);
       } catch(IOException e) {
           throw new ServletException(e);
       } catch(SQLException e){
    throw new ServletException(e);
}catch (ClassNotFoundException e) {
    throw new ServletException(e);
}catch(ServletException e){
    throw new ServletException(e);
       }
       }
       // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
/**
 * Handles the HTTP
 * <code>GET</code> method.
 *
 * @param request servlet request
 * @param response servlet response
 * @throws ServletException if a servlet-specific error occurs
 * @throws IOException if an I/O error occurs
 */
@Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ManterProjetoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterProjetoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ManterProjetoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterProjetoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
        public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

 
}
