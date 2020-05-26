<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Area de Conhecimento</title>
        <style>
            body{
                background-color: #dddddd;
            }
         </style>
    </head>
    <body>
        <h1>Manter Area de Conhecimento - ${operacao}</h1>
        <form action="ManterAreaConhecimentoController?acao=confirmarOperacao&operacao=${operacao}" 
              method="post" name="frmManterAreaConhecimento" onSubmit="validarFormulario(this)">

            
            
            <table>
                <td>Numero do Registro da Area de Conhecimento </td>
                <td><input type="text" name="txtNumeroRegistroAreaConhecimento" value="${areaConhecimento.numeroRegistroAreaConhecimento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td></tr>


                    <tr><td>Nome: </td>
                        <td><input type="text" name="txtNomeAreaConhecimento" value="${areaConhecimento.nomeAreaConhecimento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>

            </table>

            <table>
                <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
                <tr><td><input type="button"  onClick="parent.location.href = 'index.jsp'"value="   Home    "></td> </tr>
            </table>
        </form>
    </body>
</html>