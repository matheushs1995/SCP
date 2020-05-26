<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Planos Individuais</title>

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
        <h2>SCP - PESQUISAR PLANO INDIVIDUAL</h2>

        <fieldset>
            <legend>Pesquisa Plano Individual</legend>
            <table border=1>

                <tr>
                    <th> Código Plano Individuais</th>
                    <th> Local de Realização Planos Individual</th>
                    <th colspan=2>Acao</th>        
                </tr>
                <c:forEach items="${planosindividuais}" var="planoindividual">
                    <tr>      

                        <td><c:out value="${planoindividual.numeroRegistroPlanoIndividual}" /></td>   
                        <td><c:out value="${planoindividual.localRealizacaoProjeto}" /></td>
                        <td><a href="ManterPlanoIndividualController?acao=prepararOperacao&operacao=Editar&numeroRegistroPlanoIndividual=<c:out value="${planoindividual.numeroRegistroPlanoIndividual}" />">Editar</a></td>
                        <td><a href="ManterPlanoIndividualController?acao=prepararOperacao&operacao=Excluir&numeroRegistroPlanoIndividual=<c:out value="${planoindividual.numeroRegistroPlanoIndividual}" />">Excluir</a></td>       
                    </tr>
                </c:forEach>
            </table>
            <form action ="ManterPlanoIndividualController?acao=prepararOperacao&operacao=Incluir"method="post"><input type="submit" name="btnIncluir"value="Incluir">
            </form>
    </body>
</html>
