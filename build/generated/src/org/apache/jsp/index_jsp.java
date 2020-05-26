package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>SPC - MENU</title>\n");
      out.write("\n");
      out.write("        <style>\n");
      out.write("            body{\n");
      out.write("                background-color: #dddddd;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            h2{\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            legend{\n");
      out.write("\n");
      out.write("\n");
      out.write("                font-family: fantasy;\n");
      out.write("                font-size: 30px;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #menu{\n");
      out.write("                position: absolute;\n");
      out.write("                left:450px;\n");
      out.write("                top: 150px;\n");
      out.write("                \n");
      out.write("                 \n");
      out.write("                border-radius: 10px;\n");
      out.write("                font-family: sans-serif;\n");
      out.write("            }\n");
      out.write("            #text{\n");
      out.write("                position: absolute;\n");
      out.write("                background-color: #eeeeee;\n");
      out.write("                left: 400px;\n");
      out.write("                top:120px;\n");
      out.write("                height: 400px;\n");
      out.write("                width: 400px;\n");
      out.write("                border-radius: 30px;\n");
      out.write("            }\n");
      out.write("            a{\n");
      out.write("                font-size: 20px;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div>\n");
      out.write("            <h2>SCP - MENU</h2>\n");
      out.write("            <div id=\"text\"></div>\n");
      out.write("            <div id=\"menu\">\n");
      out.write("                \n");
      out.write("                    <legend name=\"\">MENU</legend>\n");
      out.write("                    <label><a href=\"PesquisarAcompanhamentoMensalController\">Manter Acompanhamento Mensal</a></label><br />\n");
      out.write("                    <label><a href=\"PesquisarAlunoController\">Manter Aluno</a></label><br />\n");
      out.write("                    <label><a href=\"PesquisarCampusController\">Manter Campus</a></label><br />\n");
      out.write("                    <label><a href=\"PesquisarCursoController\">Manter Curso</a></label><br />\n");
      out.write("                    <label><a href=\"PesquisarDepartamentoController\">Manter Departamento</a></label><br />\n");
      out.write("                    <label><a href=\"PesquisarEditalController\">Manter Edital</a></label><br />\n");
      out.write("                    <label><a href=\"PesquisarFuncionarioController\">Manter Funcionario</a></label><br />\n");
      out.write("                    <label><a href=\"PesquisarNucleoController\">Manter Núcleo</a></label><br />\n");
      out.write("                    <label><a href=\"PesquisarPlanoIndividualController\">Manter Plano Individual</a></label><br />\n");
      out.write("                    <label><a href=\"PesquisarProfessorController\">Manter Professor</a></label><br />\n");
      out.write("                    <label><a href=\"PesquisarProjetoController\">Manter Projeto</a></label><br />\n");
      out.write("                    <label><a href=\"PesquisarAreaConhecimentoController\">Manter Area Conhecimento</a></label><br />\n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
