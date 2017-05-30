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
	<title>Consultar Titulo Para Exclusão</title>
	<!-- Bootstrap -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="estilo.css" rel="stylesheet">
</head>

<body>
	<%@ include file="menuFuncionario.jsp" %>
	
	<div class="container">

        <div class="col-md-12 jumbotron">
        
			<h2 align="center"> CONSULTAR TÍTULO PARA EXCLUSÃO</h2>
              <br><br>             
                                                 
                              
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
                      String op = request.getParameter("op");
                      
                      while(i.hasNext()){
                        Titulo t1 = (Titulo) i.next();
                        int id = t1.getId(); 
//                        if(op.equals("alterar")){
                            out.println("<form class='form-horizontal' method='POST' action='ServletCadastrarTitulo'>");
                            out.println("<tr>");
                            out.println("<td>"+ t1.getNome() +"</td>"
                                    + "<td>"+t1.getSinopse()+"</td>"
                                    + "<td>"+t1.getAno()+"</td>"
                                    + "<td>"+t1.getCategoria()+"</td>"    
                                    + "<td>"+t1.getClasse()+"</td>"
                                    + "<td>"+t1.getDiretor()+"</td>"                                
                                    + " <td> <button type='submit' name='operacao' value='excluirTitulo' class='btn btn-default'  > Excluir  </button> ");
                            out.println("<input type='hidden' id='id' name='id' value ='" + t1.getId() + "'>");
                            out.println("<input type='hidden' id='nome' name='nome' value ='"+ t1.getNome()+"'>");
                            out.println("<input type='hidden' id='sinopse' name='sinopse' value ='"+ t1.getSinopse()+"'>");
                            out.println("<input type='hidden' id='ano' name='ano' value ='"+ t1.getAno() +"'>");
                            out.println("<input type='hidden' id='categoria' name='categoria' value ='"+ t1.getCategoria()+"'>");
                            out.println("<input type='hidden' id='classe' name='classe' value ='"+ t1.getClasse()+"'>");
                            out.println("<input type='hidden' id='diretor' name='diretor' value ='"+ t1.getDiretor()+"'>");                        
                            out.println("</tr>");
                            out.println("</form>");                            
                        }

//                      } 
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