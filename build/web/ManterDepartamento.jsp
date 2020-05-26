<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Departamento</title>
        <style>
            body{
                background-color: #dddddd;
            }
         </style>
    </head>
    <body>
        <h1>Manter Departamento - ${operacao}</h1>
        <form action="ManterDepartamentoController?acao=confirmarOperacao&operacao=${operacao}" 
              method="post" name="frmManterDepartamento" onSubmit="validarFormulario(this)">

            <table>
                <tr>
                <td>Campus: </td>
                <td> <select name="optCampus">
                        <c:forEach items="${campi}" var="campus"> 
                            <option value="${campus.numeroRegistroCampus}" <c:if test="${campus.numeroRegistroCampus == departamento.numeroRegistroCampus}"> selected</c:if>>${campus.nomeCampus}</option>  
                        </c:forEach> </select></td> </tr>

                <tr>
                <td>Numero do Registro do Departamento </td>
                <td><input type="text" name="txtNumeroRegistroDepartamento" value="${departamento.numeroRegistroDepartamento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td></tr>

                    <tr><td>Nome do Departamento </td>
                        <td><input type="text" name="txtNomeDepartamento" value="${departamento.nomeDepartamento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>

            </table>

            <table>
                <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
                <tr><td><input type="button"  onClick="parent.location.href = 'index.jsp'"value="   Home    "></td> </tr>
            </table>
        </form>
    </body>
</html>