<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Funcionario</title>
        
        <style>
            body{
                background-color: #dddddd;
            }
         </style>
    </head>
    <body>
        <h1>Manter Funcionario- ${operacao}</h1>
        <form action="ManterFuncionarioController?acao=confirmarOperacao&operacao=${operacao}" 
              method="post" name="frmManterFuncionario" onSubmit="validarFormulario(this)">

            <table>
                <tr>
                    <td >Cpf:</td>
                    <td><input type="text" name="txtCpf" value="${funcionario.cpf}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    
                </tr>    
                <tr>
                    <td>Número de registro do funcionário </td>
                    <td><input type="text" name="txtNumeroRegistroFuncionario" value="${funcionario.numeroRegistroFuncionario}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>


                    <tr><td colspan="1">Nome: </td>
                        <td colspan="3"><input type="text" size="59" name="txtNomeCompleto" value="${funcionario.nomeCompleto}" <c:if test="${operacao =='Excluir'}"> readonly=""</c:if>></td>
                    </tr>
                    <tr><td colspan="1">RG: </td>
                        <td colspan="3"><input type="text" size="59" name="txtRg" value="${funcionario.rg}" <c:if test="${operacao =='Excluir'}"> readonly=""</c:if>></td>
                    </tr>
                    <tr><td colspan="1">UFRG: </td>
                        <td colspan="3"><input type="text" size="59" name="txtUfrg" value="${funcionario.ufrg}" <c:if test="${operacao =='Excluir'}"> readonly=""</c:if>></td>
                    </tr>
                    <tr><td colspan="1">Orgao Expedidor: </td>
                        <td colspan="3"><input type="text" size="59" name="txtOrgaoExpedidor" value="${funcionario.getOrgaoExpedidor()}" <c:if test="${operacao =='Excluir'}"> readonly=""</c:if>></td>
                    </tr>

                    <tr><td colspan="1">Data Nascimento: </td>
                        <td colspan="3"><input type="text" size="59" name="txtDataNascimento" value="${funcionario.dataNascimento}" <c:if test="${operacao =='Excluir'}"> readonly=""</c:if>></td>
                    </tr>

                    <tr><td colspan="1">Endereco: </td>
                        <td colspan="3"><input type="text" size="59" name="txtEndereco" value="${funcionario.endereco}" <c:if test="${operacao =='Excluir'}"> readonly=""</c:if>></td>
                    </tr>

                    <tr><td colspan="1">Naturalidade: </td>
                        <td colspan="3"><input type="text" size="59" name="txtNaturalidade" value="${funcionario.naturalidade}" <c:if test="${operacao =='Excluir'}"> readonly=""</c:if>></td>
                    </tr>

                    <tr><td colspan="1">Nacionalidade: </td>
                        <td colspan="3"><input type="text" size="59" name="txtNacionalidade" value="${funcionario.nacionalidade}" <c:if test="${operacao =='Excluir'}"> readonly=""</c:if>></td>
                    </tr>



                    <tr>
                        <td>Cargo </td>
                        <td><input type="text" name="txtCargo" value="${funcionario.cargo}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr><td colspan="1">Login: </td>
                        <td colspan="3"><input type="text" size="59" name="txtLogin" value="${funcionario.login}" <c:if test="${operacao =='Excluir'}"> readonly=""</c:if>></td>
                    </tr>

                    <tr><td colspan="1">Senha: </td>
                        <td colspan="3"><input type="password" size="59" name="txtSenha" value="${funcionario.senha}" <c:if test="${operacao =='Excluir'}"> readonly=""</c:if>></td>
                    </tr>

                    <tr><td colspan="1">Email: </td>
                        <td colspan="3"><input type="text" size="59" name="txtEmail" value="${funcionario.email}" <c:if test="${operacao =='Excluir'}"> readonly=""</c:if>></td>
                </tr>
            </table>



            <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
            <tr><td><input type="button"  onClick="parent.location.href = 'index.jsp'"value="   Home    "></td> </tr>
        </form>
    </body>
</html>
