<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Acompanhamento Mensal</title>
        <style>
            body{
                background-color: #dddddd;
            }
         </style>
    </head>
    <body>
        <h1>Manter Acompanhamento Mensal- ${operacao}</h1>
        <form action="ManterAcompanhamentoMensalController?acao=confirmarOperacao&operacao=${operacao}" 
              method="post" name="frmManterAcompanhamentoMensal" onSubmit="validarFormulario(this)">

            <table>
                <tr>
                <td>Projeto: </td>
                <td> <select name="optProjeto">
                        <c:forEach items="${projetos}" var="projeto"> 
                            <option value="${projeto.numeroRegistroProjeto}" <c:if test="${projeto.numeroRegistroProjeto == acompanhamentoMensal.numeroRegistroProjeto}"> selected</c:if>>${projeto.nomeProjeto}</option>  
                        </c:forEach> </select></td>
                </tr>

            
                <tr>
                <td>Aluno: </td>
                <td> <select name="optAluno">
                        <c:forEach items="${alunos}" var="aluno"> 
                            <option value="${aluno.numeroRegistroAluno}" <c:if test="${aluno.numeroRegistroAluno == acompanhamentoMensal.numeroRegistroAluno}"> selected</c:if>>${aluno.nomeCompleto}</option>  
                        </c:forEach> </select></td> 
                </tr>

            
               <td>Numero do Registro do Acompanhamento Mensal </td>
                <td><input type="text" name="txtNumeroRegistroAcompanhamentoMensal" value="${acompanhamentoMensal.numeroRegistroAcompanhamentoMensal}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td></tr>

               <tr><td>Situação </td>
                <td><input type="text" name="txtSituacao" value="${acompanhamentoMensal.situacao}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>

               <tr><td>Avaliação do professor </td>
                <td><input type="text" name="txtAvaliacaoProfessor" value="${acompanhamentoMensal.avaliacaoProfessor}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>

               <tr><td>Comentários </td>
                <td><input type="text" name="txtComentario" value="${acompanhamentoMensal.comentario}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>

               
            </table>

            <table>
                <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
                <tr><td><input type="button"  onClick="parent.location.href = 'index.jsp'"value="   Home    "></td> </tr>
            </table>
        </form>
    </body>
</html>