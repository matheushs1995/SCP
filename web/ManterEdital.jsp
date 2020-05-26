<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Edital</title>
        <style>
            body{
                background-color: #dddddd;
            }
         </style>
    </head>
    <body>
        <h1>Manter Edital - ${operacao}</h1>
        <form action="ManterEditalController?acao=confirmarOperacao&operacao=${operacao}" 
              method="post" name="frmManterEdital" onSubmit="validarFormulario(this)">

            <table>
                <tr>
                    <td>Campus: </td>
                    <td> <select name="optCampus">
                            <c:forEach items="${campi}" var="campus"> 
                                <option value="${campus.numeroRegistroCampus}" <c:if test="${campus.numeroRegistroCampus == edital.numeroRegistroCampus}"> selected</c:if>>${campus.nomeCampus}</option>  
                            </c:forEach> </select></td> </tr>

            
                <tr>
                    <td>Numero do Registro do Edital </td>
                    <td><input type="text" name="txtNumeroRegistroEdital" value="${edital.numeroRegistroEdital}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr><td>Data Inicio </td>
                        <td><input type="text" name="txtDataInicio" value="${edital.dataInicio}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr><td>Data Termino </td>
                        <td><input type="text" name="txtDataTermino" value="${edital.dataTermino}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr><td>Numero de Vagas </td>
                        <td><input type="text" name="txtVagas" value="${edital.vagas}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr><td>Nome do Edital </td>
                        <td><input type="text" name="txtNomeEdital" value="${edital.nomeEdital}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr>
                        <td>Campus: </td>
                        <td> <select name="optimplementacao" >
                                    <option value="sim">Sim</option>
                                    <option value="nao">Não</option>
                            </select></td> </tr>


            </table>

            <table>
                <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
                <tr><td><input type="button"  onClick="parent.location.href = 'index.jsp'"value="   Home    "></td> </tr>
            </table>
        </form>
    </body>
</html>