<%@page import="model.domain.cliente.Cliente"%>
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
	<title>Alterar Locação</title>
	<!-- Bootstrap -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="estilo.css" rel="stylesheet">
</head>

<body>
	<%@ include file="menuFuncionario.jsp" %>
	
	<div class="container">
		 

        <div class="col-md-12 jumbotron">
        
			<h2 align="center"> ALTERAR LOCAÇÃO</h2>
            <form class="form-horizontal" method="POST" action="ServletEfetuarLocacao">            
           
                <div class="form-group">
            <%
               String id = request.getParameter("id");
               out.println("<input type='hidden' id='id' name='id' class='form-control' value='"+id+"'>");
            %>
            </div> 
                
            <div class="form-group">
                <label class="col-md-2 control-label" for="selectbasic">Cliente</label>
                <div class="col-md-10">
                    <select id="selectbasic" name="cliente" class="form-control">
                          <%
                              Session s = (Session) request.getAttribute("sessaoBD");
                              Criteria c  = s.createCriteria(Cliente.class);
                              List l = c.list();
                              Iterator i = l.iterator();
                              
                              while(i.hasNext()){
                                  Cliente c1 = (Cliente) i.next();
                                  int idCliente = c1.getNumIncricao();
                                  out.println("<option value='"+ idCliente +"' >" +c1+"</option>");
                              }                                 
                          %> 
                    </select>                                                 
                </div>
            </div>
                            
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Valor</label>
                <div class="col-sm-10">
                <%
                String valor = request.getParameter("valor");
                out.println("<input type='text' id='valor' name='valor' class='form-control' value='"+valor+"'>");
                %>
                 </div>                
            </div>
                 
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Multa</label>
                <div class="col-sm-10">
                <%
                String multa = request.getParameter("multa");
                out.println("<input type='text' id='multa' name='multa' class='form-control' value='"+multa+"'>");
                %>
                 </div>                
            </div>
                 
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Data Locação</label>
                <div class="col-sm-10">
                <%
                String dtLocacao = request.getParameter("dtLocacao");
                out.println("<input type='text' id='dtLocacao' name='dtLocacao' class='form-control' value='"+dtLocacao+"'>");
                %>
                 </div>                
            </div>
                 
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Data Prevista</label>
                <div class="col-sm-10">
                <%
                String dtDevolucaoPrev = request.getParameter("dtDevolucaoPrev");
                out.println("<input type='text' id='dtDevolucaoPrev' name='dtDevolucaoPrev' class='form-control' value='"+dtDevolucaoPrev+"'>");
                %>
                 </div>                
            </div>
           
            </div>
                    
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">                
                    <button type="submit" name="operacao" value="alterarLocacao" class="btn btn-default">Alterar</button>
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