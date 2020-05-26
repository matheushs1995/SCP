<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Professor</title>
        
        <style>
            body{
                background-color: #dddddd;
            }
         </style>
    </head>
    <body>
        <h1>Manter Professor- ${operacao}</h1>
        <form action="ManterProfessorController?acao=confirmarOperacao&operacao=${operacao}" 
              method="post" name="frmManterProfessor" onSubmit="validarFormulario(this)">

            <table>
                <tr>
                    <td colspan="2">Dados Pessoais:</td>
                    <td></td>
                </tr>

                <tr>
                    <td>CPF Usuario: </td>
                    <td><input type="text" name="txtCpf" value="${professor.getCpf()}" <c:if test="${operacao != 'Incluir'}" > readonly</c:if>></td>
                </tr>

                    <tr>

                    <tr><td colspan="1">Nome: </td>
                        <td colspan="3"><input type="text" size="59" name="txtNomeCompleto" value="${professor.nomeCompleto}" <c:if test="${operacao =='Excluir'}"> readonly=""</c:if>></td>
                    </tr>

                    <tr>
                        <td>Número de registro do professor </td>
                        <td><input type="text" name="txtNumeroRegistroProfessor" value="${professor.numeroRegistroProfessor}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr>
                        <td>Área de atuação </td>
                        <td><input type="text" name="txtAreaAtuacao" value="${professor.areaAtuacao}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr>
                        <td>Login: </td>
                        <td><input type="text" name="txtLogin" value="${professor.login}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr>
                        <td>Senha: </td>
                        <td><input type="password" name="txtSenha" value="${professor.senha}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr>
                        <td>Naturalidade: </td>
                        <td><input type="text" name="txtNaturalidade" value="${professor.naturalidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr>
                        <td>Nacionalidade: </td>
                        <td><input type="text" name="txtNacionalidade" value="${professor.nacionalidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr>
                        <td>RG: </td>
                        <td><input type="text" name="txtRg" value="${professor.rg}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr>
                        <td>Orgao Expedidor: </td>
                        <td><input type="text" name="txtOrgaoExpedidor" value="${professor.orgaoExpedidor}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr>
                        <td>UFRG: </td>
                        <td><input type="text" name="txtUfrg" value="${professor.ufrg}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr>
                        <td>Data Nascimento: </td>
                        <td><input type="text" name="txtDataNascimento" value="${professor.dataNascimento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr>
                        <td>Email: </td>
                        <td><input type="text" name="txtEmail" value="${professor.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    
                    <tr><td >Endereco: </td>
                        <td ><input type="text"  name="txtEndereco" value="${professor.endereco}" <c:if test="${operacao =='Excluir'}"> readonly=""</c:if>></td>
                    </tr>
                    
            </table>



            <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
            <tr><td><input type="button"  onClick="parent.location.href = 'index.jsp'"value="   Home    "></td> </tr>
        </form>
    </body>
</html>
