<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Nucleos</title>
        
        <style>

            body{
                background-color: #dddddd;
            }
            
            h2{
                text-align: center;
            }

            legend{
                font-family: fantasy;
                font-size: 30px;

            }

            fieldset{

                font-family: sans-serif;
            }

        </style>
    </head>
    <body>
        <h2>SCP - PESQUISAR NÚCLEO</h2>

        <fieldset>
            <legend>Pesquisa Núcleo</legend>
        <table border=1>

            <tr>
                <th> Código Núcleos</th>
                <th> Nome Núcleos</th>
                <th colspan=2>Acao</th>        
                </th>
                <c:forEach items="${nucleos}" var="nucleo">
                <tr>      

                    <td><c:out value="${nucleo.numeroRegistroNucleo}" /></td>   
                    <td><c:out value="${nucleo.nomeNucleo}" /></td>
                    <td><a href="ManterNucleoController?acao=prepararOperacao&operacao=Editar&numeroRegistroNucleo=<c:out value="${nucleo.numeroRegistroNucleo}" />">Editar</a></td>
                    <td><a href="ManterNucleoController?acao=prepararOperacao&operacao=Excluir&numeroRegistroNucleo=<c:out value="${nucleo.numeroRegistroNucleo}" />">Excluir</a></td>       
                </tr>
            </c:forEach>
        </table>
        <form action ="ManterNucleoController?acao=prepararOperacao&operacao=Incluir"method="post"><input type="submit" name="btnIncluir"value="Incluir">
        </form>
    </body>
</html>
