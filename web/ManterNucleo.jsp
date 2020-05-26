<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Nucleo</title>
        
        <style>
            body{
                background-color: #dddddd;
            }
         </style>
    </head>
    <body>
        <h1>Manter Nucleo - ${operacao}</h1>
        <form action="ManterNucleoController?acao=confirmarOperacao&operacao=${operacao}" 
              method="post" name="frmManterNucleo" onSubmit="validarFormulario(this)">

            <table>
                
            
                <td>Departamento: </td>
                <td> <select name="optDepartamento">
                        <c:forEach items="${departamentos}" var="departamento"> 
                            <option value="${departamento.numeroRegistroDepartamento}" <c:if test="${departamento.numeroRegistroDepartamento == nucleo.numeroRegistroDepartamento}"> selected</c:if>>${departamento.nomeDepartamento}</option>  
                        </c:forEach> </select></td> </tr>
            
                <td>Numero do Registro do Nucleo: </td>
                <td><input type="text" name="txtNumeroRegistroNucleo" value="${nucleo.numeroRegistroNucleo}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td></tr>

                    <tr><td>Nome do Nucleo </td>
                        <td><input type="text" name="txtNomeNucleo" value="${nucleo.nomeNucleo}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>

            </table>

            <table>
                <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
                <tr><td><input type="button"  onClick="parent.location.href = 'index.jsp'"value="   Home    "></td> </tr>
            </table>
        </form>
    </body>
</html>