<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Campus</title>

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
        <h2>SCP - PESQUISAR CÂMPUS</h2>

        <fieldset>
            <legend>Pesquisa Câmpus</legend>
            <table border=1>

                <tr>
                    <th> Código Câmpus</th>
                    <th> Nome Câmpus</th>
                    <th colspan=2>Acao</th>        
                    </th>
                    <c:forEach items="${campi}" var="campus">
                    <tr>      

                        <td>${campus.numeroRegistroCampus}</td>   
                        <td>${campus.nomeCampus}</td>
                        <td><a href="ManterCampusController?acao=prepararOperacao&operacao=Editar&numeroRegistroCampus=<c:out value="${campus.numeroRegistroCampus}" />">Editar</a></td>
                        <td><a href="ManterCampusController?acao=prepararOperacao&operacao=Excluir&numeroRegistroCampus=<c:out value="${campus.numeroRegistroCampus}" />">Excluir</a></td>       
                    </tr>
                </c:forEach>
            </table>
        </fieldset>
        <form action ="ManterCampusController?acao=prepararOperacao&operacao=Incluir"method="post"><input type="submit" name="btnIncluir"value="Incluir">
        </form>
    </body>
</html>
