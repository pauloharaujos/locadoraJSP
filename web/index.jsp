<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="model.domain.acervo.Titulo"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>LOCADORA PASSATEMPO</title>
	 <!-- Bootstrap -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="estilo.css" rel="stylesheet">
</head>

<body>

<nav class="navbar navbar-inverse">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
					 data-toggle="collapse" data-target="#barra-navegacao">
					  <span class="sr-only">Alternar Menu</span>
					  <span class="icon-bar"></span>
					  <span class="icon-bar"></span>
					  <span class="icon-bar"></span> 
					</button>
					<a href="index.html" class="navbar-brand"> <span class="glyphicon glyphicon-fast-forward"></span> Locadora Passatempo</a>
				</div>
				
				<div class="collapse navbar-collapse" id="barra-navegacao">
				
				   <!-- Login -->
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> <span class="glyphicon glyphicon-user"></span> Login <span class="caret"></span></a>
                            <form class="dropdown-menu" name="loginUser" method="POST" action="ServletLogin">
                                <div class="input-group">
                                    <span class="input-group-addon" id="username">
                                        <span class="glyphicon glyphicon-user"></span>
                                    </span>
                                    <input type="text" class="form-control" placeholder="Username" aria-describedby="username" name="login-username">
                                </div>
                                <br>
                                <div class="input-group">
                                    <span class="input-group-addon" id="password">
                                        <span class="glyphicon glyphicon-lock"></span>
                                    </span>
                                    <input type="password" class="form-control" placeholder="Password" aria-describedby="password" name="login-password">
                                </div>
                                <div role="separator" class="divider"></div>
                                <input id="submit-login" type="submit" class="btn btn-primary" value="Entrar">
                            </form> 
                        </li>
                    </ul>
				  
				  
				</div>
				
			</div>
</nav>   
	
    <div class="container">
    
    <div class="col-md-12 jumbotron">   
			
            <h2 align="center"> CONSULTAR TÍTULO</h2>
            
           <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Digite um nome para Filtrar">          
                
              <table id="myTable" class="table table-striped table-bordered table-hover">
                 <thead>
                    <tr><th>Titulo</th><th>Sinopse</th><th>Ano</th><th>Categoria</th><th>Classe</th><th>Diretor</th></tr>
                </thead>
        
                <tbody data-link='row' class='rowlink'>
                 <%
                      Session s = (Session) request.getAttribute("sessaoBD");
                      Criteria c = s.createCriteria(Titulo.class);
                      c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
                      List l = c.list();
                      Iterator i = l.iterator();                    
                      
                      while(i.hasNext()){
                        Titulo t1 = (Titulo) i.next();
                        int id = t1.getId();                  
                            out.println("<form class='form-horizontal' method='POST' action='#'>");
                            out.println("<tr>");
                            out.println("<td>"+ t1.getNome() +"</td>"
                                    + "<td>"+t1.getSinopse()+"</td>"
                                    + "<td>"+t1.getAno()+"</td>"
                                    + "<td>"+t1.getCategoria()+"</td>"    
                                    + "<td>"+t1.getClasse()+"</td>"
                                    + "<td>"+t1.getDiretor()+"</td>");                      
                            out.println("</tr>");
                            out.println("</form>");                            
                        }
                  %> 
                  </tbody>
              </table>  
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