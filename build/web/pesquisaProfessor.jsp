<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Professores</title>

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



        <h2>SCP - PESQUISAR PROFESSORES</h2>

        <fieldset>
            <legend>Pesquisa Professor</legend>
            <table border=1>

                <tr>
                    <th> Código Professor</th>
                    <th> Nome Professor</th>
                    <th colspan=2>Acao</th>        
                    </th>
                    <c:forEach items="${professores}" var="professor">
                    <tr>      

                        <td><c:out value="${professor.numeroRegistroProfessor}" /></td>   
                        <td><c:out value="${professor.nomeCompleto}" /></td>
                        <td><a href="ManterProfessorController?acao=prepararOperacao&operacao=Editar&numeroRegistroProfessor=<c:out value="${professor.numeroRegistroProfessor}" />">Editar</a></td>
                        <td><a href="ManterProfessorController?acao=prepararOperacao&operacao=Excluir&numeroRegistroProfessor=<c:out value="${professor.numeroRegistroProfessor}" />">Excluir</a></td>       
                    </tr>
                </c:forEach>
            </table>
        </fieldset>

        <form action ="ManterProfessorController?acao=prepararOperacao&operacao=Incluir"method="post"><input type="submit" name="btnIncluir"value="Incluir">
        </form>
    </body>
</html>
