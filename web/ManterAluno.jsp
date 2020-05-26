<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Aluno</title>
        <style>
            body{
                background-color: #dddddd;
            }
         </style>
    </head>
    <body>
        <h1>Manter Aluno - ${operacao}</h1>
        <form action="ManterAlunoController?acao=confirmarOperacao&operacao=${operacao}" 
              method="post" name="frmManterAluno" onSubmit="validarFormulario(this)">

            <table>
                <tr><td colspan="2">Dados Pessoais:</td></tr>

                <tr>
                    <td>CPF Usuario: </td>
                    <td><input type="text" name="txtCpf" value="${aluno.cpf}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr><td colspan="1">Nome: </td>
                        <td colspan="3"><input type="text" size="59" name="txtNomeCompleto" value="${aluno.nomeCompleto}" <c:if test="${operacao =='Excluir'}"> readonly=""</c:if>></td>
                    </tr>

                    <tr>
                        <td>Curso: </td>
                        <td> <select name="optCurso">
                            <c:forEach items="${cursos}" var="curso"> 
                                <option value="${curso.numeroRegistroCurso}" <c:if test="${ aluno.getCurso_codCurso() == curso.numeroRegistroCurso }"> selected</c:if>>${curso.nomeCurso}</option>  
                            </c:forEach> </select></td> </tr>



               <tr>     
                <td>Número de registro do aluno </td>
                <td><input type="text" name="txtNumeroRegistroAluno" value="${aluno.numeroRegistroAluno}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>

                <tr>
                    <td>Nome do banco </td>
                    <td><input type="text" name="txtNomeBanco" value="${aluno.nomeBanco}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>

                <tr>
                    <td>Agência bancária </td>
                    <td><input type="text" name="txtAgencia" value="${aluno.agencia}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                
                <tr>
                    <td>Número da conta: </td>
                    <td><input type="text" name="txtNumeroConta" value="${aluno.numeroConta}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>

                <tr>
                    <td>Dados do responsável: </td>
                    <td><input type="text" name="txtDadosResponsavel" value="${aluno.dadosResponsavel}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                
                <tr>
                    <td>Endereco: </td>
                    <td><input type="text" name="txtEndereco" value="${aluno.endereco}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                
                
                
                <tr>
                    <td>Login: </td>
                    <td><input type="text" name="txtLogin" value="${aluno.login}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                
                <tr>
                    <td>Senha: </td>
                    <td><input type="password" name="txtSenha" value="${aluno.senha}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                
                <tr>
                    <td>Naturalidade: </td>
                    <td><input type="text" name="txtNaturalidade" value="${aluno.naturalidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                
                <tr>
                    <td>Nacionalidade: </td>
                    <td><input type="text" name="txtNacionalidade" value="${aluno.nacionalidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                
                <tr>
                    <td>RG: </td>
                    <td><input type="text" name="txtRg" value="${aluno.rg}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                
                <tr>
                    <td>Orgao Expedidor: </td>
                    <td><input type="text" name="txtOrgaoExpedidor" value="${aluno.orgaoExpedidor}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                
                <tr>
                    <td>UFRG: </td>
                    <td><input type="text" name="txtUfrg" value="${aluno.ufrg}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                
                <tr>
                    <td>Data Nascimento: </td>
                    <td><input type="text" name="txtDataNascimento" value="${aluno.dataNascimento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                
                <tr>
                    <td>Email: </td>
                    <td><input type="text" name="txtEmail" value="${aluno.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                
                
                

            </table>



            <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
            <tr><td><input type="button"  onClick="parent.location.href = 'index.jsp'"value="   Home    "></td> </tr>
        </form>
    </body>
</html>
