<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Curso</title>
        <style>
            body{
                background-color: #dddddd;
            }
         </style>
    </head>
    <body>
        <h1>Manter Curso- ${operacao}</h1>
        <form action="ManterCursoController?acao=confirmarOperacao&operacao=${operacao}" 
              method="post" name="frmManterCurso" onSubmit="validarFormulario(this)">

            <table>
                <tr>
                <td>Nucleo: </td>
                <td> <select name="optNucleo">
                        <c:forEach items="${nucleos}" var="nucleo"> 
                            <option value="${nucleo.numeroRegistroNucleo}" <c:if test="${nucleo.numeroRegistroNucleo== curso.numeroRegistroNucleo}"> selected</c:if>>${nucleo.nomeNucleo}</option>  
                        </c:forEach> </select></td> </tr>

            
                <tr>
                    <td>Numero do Registro do Curso </td>
                    <td><input type="text" name="txtNumeroRegistroCurso" value="${curso.numeroRegistroCurso}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr>
                        <td>Nome do Curso </td>
                        <td><input type="text" name="txtNomeCurso" value="${curso.nomeCurso}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>

            </table>

            <table>
                <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
                <tr><td><input type="button"  onClick="parent.location.href = 'index.jsp'"value="   Home    "></td> </tr>
            </table>
        </form>
    </body>
</html>