<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Editais</title>

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
        <h2>SCP - PESQUISAR EDITAL</h2>

        <fieldset>
            <legend>Pesquisa Edital</legend>
            <table border=1>

                <tr>
                    <th> Código Departamentos</th>
                    <th> Data de Inicio</th>
                    <th> Data de Termino</th>
                    <th> Vagas</th>
                    <th> Nome Edital</th>
                    
                    <th> Numero Registro Campus</th>
                    <th colspan=2>Acao</th>        
                    </th>
                    <c:forEach items="${editais}" var="edital">
                    <tr>      
                        <td><c:out value="${edital.numeroRegistroEdital}" /></td>   
                        <td><c:out value="${edital.dataInicio}" /></td>
                        <td><c:out value="${edital.dataTermino}" /></td>
                        <td><c:out value="${edital.vagas}" /></td>
                        <td><c:out value="${edital.nomeEdital}" /></td>
                        <td><c:out value="${edital.numeroRegistroCampus}" /></td>
                        <td><a href="ManterEditalController?acao=prepararOperacao&operacao=Editar&numeroRegistroEdital=<c:out value="${edital.numeroRegistroEdital}" />">Editar</a></td>
                        <td><a href="ManterEditalController?acao=prepararOperacao&operacao=Excluir&numeroRegistroEdital=<c:out value="${edital.numeroRegistroEdital}" />">Excluir</a></td>
                    
                    </tr>
                </c:forEach>
            </table>
        </fieldset>
        <form action ="ManterEditalController?acao=prepararOperacao&operacao=Incluir"method="post"><input type="submit" name="btnIncluir"value="Incluir">
        </form>
    </body>
</html>
