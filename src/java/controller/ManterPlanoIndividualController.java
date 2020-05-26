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
import model.Aluno;
import model.PlanoIndividual;
import model.Projeto;

/**
 *
 * @author Kassio
 */
public class ManterPlanoIndividualController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
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
            confirmarOperacao(request, response);
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
            request.setAttribute("alunos", Aluno.obterAlunos());
            request.setAttribute("projetos", Projeto.obterProjetos());

            if (!operacao.equals("Incluir")) {
                int numeroRegistroPlanoIndividual = Integer.parseInt(request.getParameter("numeroRegistroPlanoIndividual"));
                PlanoIndividual planoIndividual = PlanoIndividual.obterPlanoIndividual(numeroRegistroPlanoIndividual);
                request.setAttribute("planoIndividual", planoIndividual);
            }

            RequestDispatcher view = request.getRequestDispatcher("/ManterPlanoIndividual.jsp");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        } catch (SQLException e) {
            throw new ServletException(e);
        } catch (ClassNotFoundException e) {

            throw new ServletException(e);
        }

    }

    private void confirmarOperacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, ServletException, IOException, SQLException, ClassNotFoundException {

        String operacao = request.getParameter("operacao");
        int numeroRegistroAluno = Integer.parseInt(request.getParameter("optAluno"));
        int numeroRegistroProjeto = Integer.parseInt(request.getParameter("optProjeto"));

        int numeroRegistroPlanoIndividual = Integer.parseInt(request.getParameter("txtNumeroRegistroPlanoIndividual"));
        String localRealizacaoProjeto = request.getParameter("txtLocalRealizacaoProjeto");
        String envolvimento = request.getParameter("txtEnvolvimento");
        String resultadoEsperado = request.getParameter("txtResultadoEsperado");
        String cronogramaAtividade = request.getParameter("txtCronogramaAtividade");

        try {
            Aluno aluno = null;
            if (numeroRegistroAluno != 0) {
                aluno = Aluno.obterAluno(numeroRegistroAluno);
            }

            Projeto projeto = null;
            if (numeroRegistroProjeto != 0) {
                projeto = Projeto.obterProjeto(numeroRegistroProjeto);
            }

            PlanoIndividual planoIndividual = new PlanoIndividual(numeroRegistroPlanoIndividual, localRealizacaoProjeto, envolvimento, resultadoEsperado, cronogramaAtividade, aluno, projeto);

            if (operacao.equals("Incluir")) {
                planoIndividual.gravar();
            } else {
                if (operacao.equals("Editar")) {
                    planoIndividual.alterar();
                } else {
                    if (operacao.equals("Excluir")) {
                        planoIndividual.excluir();
                    }
                }
            }

            RequestDispatcher view
                    = request.getRequestDispatcher("PesquisarPlanoIndividualController");
            view.forward(request, response);
        } catch (IOException e) {
            throw new ServletException(e);
        } catch (SQLException e) {
            throw new ServletException(e);
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        } catch (ServletException e) {
            throw new ServletException(e);
        }
    }
       // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
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
            Logger.getLogger(ManterPlanoIndividualController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterPlanoIndividualController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
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
            Logger.getLogger(ManterPlanoIndividualController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterPlanoIndividualController.class.getName()).log(Level.SEVERE, null, ex);
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
