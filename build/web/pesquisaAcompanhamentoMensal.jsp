<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SPC - Pesquisa de Acompanhamento Mensal</title>

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

        <h2>SCP - PESQUISAR ACOMPANHAMENTO MENSAL</h2>

        <fieldset>
            <legend>Pesquisa Acompanhamento Mensal</legend>
            <table border=1>

                <tr>
                    <th> Código Acompanhamento Mensal</th>
                    <th> Situação Acompanhamento Mensal</th>
                    <th> Avaliação do Professor</th>
                    <th> Comentário</th>
                    <th> Numero Registro Aluno</th>
                    <th> Numero Registro Projeto</th>

                    <th colspan=2>Acao</th>
                    
                </tr>
                <c:forEach items="${acompanhamentos}" var="acompanhamento">
                    <tr>      

                        <td>${acompanhamento.numeroRegistroAcompanhamentoMensal}</td>   
                        <td>${acompanhamento.situacao}</td>
                        <td>${acompanhamento.avaliacaoProfessor}</td>
                        <td>${acompanhamento.comentario}</td>
                        <td>${acompanhamento.numeroRegistroAluno}</td>
                        <td>${acompanhamento.numeroRegistroProjeto}</td>
                        <td><a href="ManterAcompanhamentoMensalController?acao=prepararOperacao&operacao=Editar&numeroRegistroAcompanhamentoMensal=<c:out value="${acompanhamento.numeroRegistroAcompanhamentoMensal}" />">Editar</a></td>
                        <td><a href="ManterAcompanhamentoMensalController?acao=prepararOperacao&operacao=Excluir&numeroRegistroAcompanhamentoMensal=<c:out value="${acompanhamento.numeroRegistroAcompanhamentoMensal}" />">Excluir</a></td>       
                    </tr>
                </c:forEach>
            </table>

        </fieldset>
        <form action ="ManterAcompanhamentoMensalController?acao=prepararOperacao&operacao=Incluir"method="post"><input type="submit" name="btnIncluir"value="Incluir">
        </form>
    </body>
</html>
