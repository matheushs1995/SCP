package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Aluno;
import model.Curso;
import model.Usuario;


public class ManterAlunoController extends HttpServlet {

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
            request.setAttribute("cursos", Curso.obterCursos());
            
            request.setAttribute("usuarios", Usuario.obterUsuarios());
            
            

            
            if (!operacao.equals("Incluir")) {
                int numeroRegistroAluno = Integer.parseInt(request.getParameter("numeroRegistroAluno"));
                Aluno aluno = Aluno.obterAluno(numeroRegistroAluno);

                request.setAttribute("aluno", aluno);
            }

            RequestDispatcher view = request.getRequestDispatcher("/ManterAluno.jsp");
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
        int cpf = Integer.parseInt(request.getParameter("txtCpf"));
        int numeroRegistroCurso = Integer.parseInt(request.getParameter("optCurso"));

        int numeroRegistroAluno = Integer.parseInt(request.getParameter("txtNumeroRegistroAluno"));
        String nomeCompleto = request.getParameter("txtNomeCompleto");
        String rg = request.getParameter("txtRg");
        String ufrg = request.getParameter("txtUfrg");
        String orgaoExpedidor = request.getParameter("txtOrgaoExpedidor");
        String dataNascimento = request.getParameter("txtDataNascimento");
        String dadosResponsavel = request.getParameter("txtDadosResponsavel");
        String endereco = request.getParameter("txtEndereco");
        String naturalidade = request.getParameter("txtNaturalidade");
        String nacionalidade = request.getParameter("txtNacionalidade");
        String nomeBanco = request.getParameter("txtNomeBanco");
        String numeroConta = request.getParameter("txtNumeroConta");
        String agencia = request.getParameter("txtAgencia");
        String email = request.getParameter("txtEmail");
        String login = request.getParameter("txtLogin");
        String senha = request.getParameter("txtSenha");
        
        
        

        try {
            

            Curso curso = null;
            if (numeroRegistroCurso != 0) {
                curso = Curso.obterCurso(numeroRegistroCurso);

            }

            Aluno aluno = new Aluno(numeroRegistroAluno,nomeBanco, agencia,numeroConta,dadosResponsavel,cpf,login,senha,nomeCompleto,naturalidade,nacionalidade, rg, orgaoExpedidor,ufrg,dataNascimento,email,endereco,"3",null,null);
            aluno.setCpf(cpf);
            aluno.setCurso_codCurso(numeroRegistroCurso);
            
            if (operacao.equals("Incluir")) {
                aluno.gravar();

            } else {
                if (operacao.equals("Editar")) {
                    aluno.alterar();

                } else {
                    if (operacao.equals("Excluir")) {
                        aluno.excluir();
                    }
                }
            }

            RequestDispatcher view
                    = request.getRequestDispatcher("PesquisarAlunoController");
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
            Logger.getLogger(ManterAreaConhecimentoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterAreaConhecimentoController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterAreaConhecimentoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterAreaConhecimentoController.class.getName()).log(Level.SEVERE, null, ex);
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
