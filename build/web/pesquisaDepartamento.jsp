<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Departamentos</title>

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
        <h2>SCP - PESQUISAR DEPARTAMENTO</h2>

        <fieldset>
            <legend>Pesquisa Departamento</legend>
            <table border=1>

                <tr>
                    <th> Código Departamentos</th>
                    <th> Nome Departamento</th>
                    <th> Numero Registro Campus</th>
                    
                    <th colspan=2>Acao</th>        
                </tr>
                <c:forEach items="${departamentos}" var="departamento">
                    <tr>      
                        <td><c:out value="${departamento.numeroRegistroDepartamento}" /></td>
                        <td><c:out value="${departamento.nomeDepartamento}" /></td>
                        <td><c:out value="${departamento.numeroRegistroCampus}" /></td>


                        <td><a href="ManterDepartamentoController?acao=prepararOperacao&operacao=Editar&numeroRegistroDepartamento=<c:out value="${departamento.numeroRegistroDepartamento}" />">Editar</a></td>
                        <td><a href="ManterDepartamentoController?acao=prepararOperacao&operacao=Excluir&numeroRegistroDepartamento=<c:out value="${departamento.numeroRegistroDepartamento}" />">Excluir</a></td>       
                    </tr>
                </c:forEach>
            </table>
        </fieldset>
        <form action ="ManterDepartamentoController?acao=prepararOperacao&operacao=Incluir"method="post"><input type="submit" name="btnIncluir"value="Incluir">
        </form>
    </body>
</html>
