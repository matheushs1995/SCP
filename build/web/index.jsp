<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SPC - MENU</title>

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

            #menu{
                position: absolute;
                left:450px;
                top: 150px;
                
                 
                border-radius: 10px;
                font-family: sans-serif;
            }
            #text{
                position: absolute;
                background-color: #eeeeee;
                left: 400px;
                top:120px;
                height: 400px;
                width: 400px;
                border-radius: 30px;
            }
            a{
                font-size: 20px;
            }
            

        </style>
    </head>
    <body>
        <div>
            <h2>SCP - MENU</h2>
            <div id="text"></div>
            <div id="menu">
                
                    <legend name="">MENU</legend>
                    <label><a href="PesquisarAcompanhamentoMensalController">Manter Acompanhamento Mensal</a></label><br />
                    <label><a href="PesquisarAlunoController">Manter Aluno</a></label><br />
                    <label><a href="PesquisarCampusController">Manter Campus</a></label><br />
                    <label><a href="PesquisarCursoController">Manter Curso</a></label><br />
                    <label><a href="PesquisarDepartamentoController">Manter Departamento</a></label><br />
                    <label><a href="PesquisarEditalController">Manter Edital</a></label><br />
                    <label><a href="PesquisarFuncionarioController">Manter Funcionario</a></label><br />
                    <label><a href="PesquisarNucleoController">Manter Núcleo</a></label><br />
                    <label><a href="PesquisarPlanoIndividualController">Manter Plano Individual</a></label><br />
                    <label><a href="PesquisarProfessorController">Manter Professor</a></label><br />
                    <label><a href="PesquisarProjetoController">Manter Projeto</a></label><br />
                    <label><a href="PesquisarAreaConhecimentoController">Manter Area Conhecimento</a></label><br />
                
            </div>
            
        </div>
    </body>
</html>
