<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Funcionarios</title>

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
        <h2>SCP - PESQUISAR FUNCIONÁRIO</h2>

        <fieldset>
            <legend>Pesquisa Funcionário</legend>
            <table border=1>

                <tr>
                    <th> Código Funcionário</th>
                    <th> Cargo</th>
                    <th colspan=2>Acao</th>        
                    </th>
                    <c:forEach items="${funcionarios}" var="funcionario">
                    <tr>      

                        <td><c:out value="${funcionario.numeroRegistroFuncionario}" /></td>   
                        <td><c:out value="${funcionario.cargo}" /></td>
                        <td><a href="ManterFuncionarioController?acao=prepararOperacao&operacao=Editar&numeroRegistroFuncionario=<c:out value="${funcionario.numeroRegistroFuncionario}" />">Editar</a></td>
                        <td><a href="ManterFuncionarioController?acao=prepararOperacao&operacao=Excluir&numeroRegistroFuncionario=<c:out value="${funcionario.numeroRegistroFuncionario}" />">Excluir</a></td>       
                    </tr>
                </c:forEach>
            </table>
        </fieldset>
        <form action ="ManterFuncionarioController?acao=prepararOperacao&operacao=Incluir"method="post"><input type="submit" name="btnIncluir"value="Incluir">
        </form>
    </body>
</html>
