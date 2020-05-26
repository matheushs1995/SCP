<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Alunos</title>

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
        <h2>SCP - PESQUISAR ALUNO</h2>

        <fieldset>
            <legend>Pesquisa Aluno</legend>
            <table border=1>

                <tr>
                    <th> Codigo Aluno</th>
                    <th> Nome Aluno</th>
                    <th colspan=2>Acao</th>        
                    </tr>
                    <c:forEach items="${alunos}" var="aluno">
                    <tr>      

                        <td><c:out value="${aluno.numeroRegistroAluno}" /></td>   
                        <td><c:out value="${aluno.nomeCompleto}" /></td>
                        <td><a href="ManterAlunoController?acao=prepararOperacao&operacao=Editar&numeroRegistroAluno=<c:out value="${aluno.numeroRegistroAluno}" />">Editar</a></td>
                        <td><a href="ManterAlunoController?acao=prepararOperacao&operacao=Excluir&numeroRegistroAluno=<c:out value="${aluno.numeroRegistroAluno}" />">Excluir</a></td>       
                    </tr>
                </c:forEach>
            </table>
        </fieldset>
        <form action ="ManterAlunoController?acao=prepararOperacao&operacao=Incluir"method="post"><input type="submit" name="btnIncluir"value="Incluir">
        </form>
    </body>
</html>
