<%@page import="model.domain.acervo.Titulo"%>
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
	<title>Consultar Titulo</title>
	<!-- Bootstrap -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="estilo.css" rel="stylesheet">
</head>

<body>
	<%@ include file="menuFuncionario.jsp" %>
	
	<div class="container">

        <div class="col-md-12 jumbotron">
        
			<h2 align="center"> CONSULTAR TÍTULO</h2>
            <form class="form-horizontal" method="POST" action="#"> 
              <br><br>
              <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Digite um nome para Filtrar">
              
              <table id="myTable" class="table table-striped table-bordered table-hover">
                 <thead>
                    <tr><th>Nome</th><th>Sinopse</th></tr>
                </thead>
        
                <tbody data-link='row' class='rowlink'>
                 <%
                      Session s = (Session) request.getAttribute("sessaoBD");
                      Criteria c = s.createCriteria(Titulo.class);
                      List l = c.list();
                      Iterator i = l.iterator();
                      
                      while(i.hasNext()){
                        Titulo t1 = (Titulo) i.next();
                        int id = t1.getId();                        
                        out.println("<tr><td>"+ t1.getNome() +"</td><td>"+t1.getSinopse()+"</td><td class='rowlink-skip'><a href='#'> "
                                + "Excluir</a></td><td class='rowlink-skip'><a href='#'> "
                                + "Alterar</a></td></tr> ");                        
                      } 
                  %> 
                  </tbody>
              </table>              
             
            </form>
    	</div>

    		<div id="footer" class="col-md-12">
    		    <h4 align="center"> Desenvolvido por Paulo Henrique - M18 <br> IFES - Campus Colatina</h4>
    		</div>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="funcoes.js"> </script>
</body>

</html>