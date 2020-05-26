<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Plano Individual</title>
        
        <style>
            body{
                background-color: #dddddd;
            }
         </style>
    </head>
    <body>
        <h1>Manter Plano Individual - ${operacao}</h1>
        <form action="ManterPlanoIndividualController?acao=confirmarOperacao&operacao=${operacao}" 
              method="post" name="frmManterPlanoIndividual" onSubmit="validarFormulario(this)">

            <table>
                <tr>
                <td>Aluno: </td>
                <td> <select name="optAluno">
                        <c:forEach items="${alunos}" var="aluno">
                            <option value="${aluno.numeroRegistroAluno}" <c:if test="${aluno.numeroRegistroAluno == planoIndividual.numeroRegistroAluno}"> selected</c:if>>${aluno.nomeCompleto}</option>  
                        </c:forEach> </select></td> </tr>

                <tr>
                <td>Projeto: </td>
                <td> <select name="optProjeto">
                        <c:forEach items="${projetos}" var="projeto"> 
                            <option value="${projeto.numeroRegistroProjeto}" <c:if test="${projeto.numeroRegistroProjeto == areaConhecimento.numeroRegistroProjeto}"> selected</c:if>>${projeto.nomeProjeto}</option>  
                        </c:forEach> </select></td> </tr>

            

                <td>Numero do Registro do Plano Individual </td>
                <td><input type="text" name="txtNumeroRegistroPlanoIndividual" value="${planoIndividual.numeroRegistroPlanoIndividual}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td></tr>

                    <td>Local de Realizacao </td>
                    <td><input type="text" name="txtLocalRealizacaoProjeto" value="${planoIndividual.localRealizacaoProjeto}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td></tr>

                    <td>Envolvimento </td>
                    <td><input type="text" name="txtEnvolvimento" value="${planoIndividual.envolvimento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td></tr>

                    <td>Resultado Esperado </td>
                    <td><input type="text" name="txtResultadoEsperado" value="${planoIndividual.resultadoEsperado}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td></tr>

                    <td>Cronograma da Atividade </td>
                    <td><input type="text" name="txtCronogramaAtividade" value="${planoIndividual.cronogramaAtividade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td></tr>


            </table>

            <table>
                <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
                <tr><td><input type="button"  onClick="parent.location.href = 'index.jsp'"value="   Home    "></td> </tr>
            </table>
        </form>
    </body>
</html>