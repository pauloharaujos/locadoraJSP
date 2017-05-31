<%@page import="model.domain.cliente.Socio"%>
<%@page import="javafx.scene.input.KeyCode"%>
<%@page import="model.domain.acervo.Titulo"%>
<%@page import="model.domain.acervo.Diretor"%>
<%@page import="model.domain.acervo.Classe"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Alterar Socio</title>
	<!-- Bootstrap -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="estilo.css" rel="stylesheet">
</head>

<body>
	<%@ include file="menuFuncionario.jsp" %>
	
	<div class="container">
		 

        <div class="col-md-12 jumbotron">
        
			<h2 align="center"> ALTERAR SOCIO</h2>
            <form class="form-horizontal" method="POST" action="ServletCadastrarCliente">            
           
                <div class="form-group">
            <%
               String id = request.getParameter("id");
               out.println("<input type='hidden' id='id' name='id' class='form-control' value='"+id+"'>");
            %>
            </div>
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Nome</label>
                <div class="col-sm-10">
                <%
                String nome = request.getParameter("nome");
                out.println("<input type='text' id='nome' name='nome' class='form-control' value='"+nome+"'>");
                %>
                 </div>                
            </div>
                 
            <div class="form-group">
                <label for="inputTipo" class="col-sm-2 control-label">Sexo</label>
                <div class="col-sm-10">
                  <select name="sexo" class="form-control">
                    <option value="masculino">Masculino</option>
                    <option value="feminino">Feminino</option>                                    
                  </select>
                </div>
            </div>    
                 
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Data de Nascimento</label>
                <div class="col-sm-10">
                <%
                String dtNasc = request.getParameter("dtNasc");
                out.println("<input type='text' id='dtNasc' name='dtNasc' class='form-control' value='"+dtNasc+"'>");
                %>
                 </div>                
            </div>
                 
            <div class="form-group">
                <label for="inputTipo" class="col-sm-2 control-label">Ativo ?</label>
                <div class="col-sm-10">
                  <select name="ativo" class="form-control">
                    <option value="1">Sim</option>
                    <option value="0">Não</option>                                    
                  </select>
                </div>
            </div>                  

            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">CPF</label>
                <div class="col-sm-10">
                <%
                String cpf = request.getParameter("cpf");
                out.println("<input type='text' id='cpf' name='cpf' class='form-control' value='"+cpf+"'>");
                %>
                 </div>                
            </div>  
                 
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Endereço</label>
                <div class="col-sm-10">
                <%
                String endereco = request.getParameter("endereco");
                out.println("<input type='text' id='endereco' name='endereco' class='form-control' value='"+endereco+"'>");
                %>
                 </div>                
            </div>   
                 
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Telefone</label>
                <div class="col-sm-10">
                <%
                String telefone = request.getParameter("telefone");
                out.println("<input type='text' id='telefone' name='telefone' class='form-control' value='"+telefone+"'>");
                %>
                 </div>                
            </div>                 
                 
            </div>
                    
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">                
                    <button type="submit" name="operacao" value="alterarSocio" class="btn btn-default">Alterar</button>
                </div>
            </div>
            </form>
        </div>
           
       </div>

    	<div id="footer" class="col-md-12">
            <h4 align="center"> Desenvolvido por Paulo Henrique - M18 <br> IFES - Campus Colatina</h4>
    	</div>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
</body>

</html>