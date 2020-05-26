'   <%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Area de Conhecimento</title>

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
        <h2>SCP - PESQUISAR ÁREA CONHECIMENTO</h2>

        <fieldset>
            <legend>Pesquisa Área Conhecimento</legend>
            <table border=1>

                <tr>
                    <th> Código Área de Conhecimento</th>
                    <th> Nome Área de Conhecimento</th>
                    <th colspan=2>Acao</th>        
                    </th>
                    <c:forEach items="${areasConhecimentos}" var="areaConhecimento">
                    <tr>      

                        <td><c:out value="${areaConhecimento.numeroRegistroAreaConhecimento}" /></td>   
                        <td><c:out value="${areaConhecimento.nomeAreaConhecimento}" /></td>
                        <td><a href="ManterAreaConhecimentoController?acao=prepararOperacao&operacao=Editar&numeroRegistroAreaConhecimento=<c:out value="${areaConhecimento.numeroRegistroAreaConhecimento}" />">Editar</a></td>
                        <td><a href="ManterAreaConhecimentoController?acao=prepararOperacao&operacao=Excluir&numeroRegistroAreaConhecimento=<c:out value="${areaConhecimento.numeroRegistroAreaConhecimento}" />">Excluir</a></td>       
                    </tr>
                </c:forEach>
            </table>
        </fieldset>
        <form action ="ManterAreaConhecimentoController?acao=prepararOperacao&operacao=Incluir"method="post"><input type="submit" name="btnIncluir"value="Incluir">
        </form>
    </body>
</html>
