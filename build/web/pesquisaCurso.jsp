<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Cursos</title>

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
        <h2>SCP - PESQUISAR CURSO</h2>

        <fieldset>
            <legend>Pesquisa Curso</legend>
            <table border=1>

                <tr>
                    <th> Código Curso</th>
                    <th> Nome Curso</th>
                    <th> Numero Registro Nucleo</th>
                    <th colspan=2>Acao</th>        
                    </th>
                    <c:forEach items="${cursos}" var="curso">
                    <tr>      

                        <td><c:out value="${curso.numeroRegistroCurso}" /></td>   
                        <td><c:out value="${curso.nomeCurso}" /></td>
                        <td><c:out value="${curso.numeroRegistroNucleo}" /></td>
                        <td><a href="ManterCursoController?acao=prepararOperacao&operacao=Editar&numeroRegistroCurso=<c:out value="${curso.numeroRegistroCurso}" />">Editar</a></td>
                        <td><a href="ManterCursoController?acao=prepararOperacao&operacao=Excluir&numeroRegistroCurso=<c:out value="${curso.numeroRegistroCurso}" />">Excluir</a></td>       
                    </tr>
                </c:forEach>
            </table>
        </fieldset>
        <form action ="ManterCursoController?acao=prepararOperacao&operacao=Incluir"method="post"><input type="submit" name="btnIncluir"value="Incluir">
        </form>
    </body>
</html>
