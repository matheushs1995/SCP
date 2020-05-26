<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Projetos</title>
        
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
        <h2>SCP - PESQUISAR PROJETOS</h2>

        <fieldset>
            <legend>Pesquisa Projeto</legend>
        <table border=1>

            <tr>
                <th> Código Projeto</th>
                <th> Nome Projeto</th>
                
                <th colspan=2>Acao</th>        
                </th>
                <c:forEach items="${projetos}" var="projeto">
                <tr>      

                    <td><c:out value="${projeto.numeroRegistroProjeto}" /></td>   
                    <td><c:out value="${projeto.nomeProjeto}" /></td>
                   
                    
                    <td><a href="ManterProjetoController?acao=prepararOperacao&operacao=Editar&numeroRegistroProjeto=<c:out value="${projeto.numeroRegistroProjeto}" />">Editar</a></td>
                    <td><a href="ManterProjetoController?acao=prepararOperacao&operacao=Excluir&numeroRegistroProjeto=<c:out value="${projeto.numeroRegistroProjeto}" />">Excluir</a></td>       
                </tr>
            </c:forEach>
        </table>
        <form action ="ManterProjetoController?acao=prepararOperacao&operacao=Incluir"method="post"><input type="submit" name="btnIncluir"value="Incluir">
        </form>
    </body>
</html>
