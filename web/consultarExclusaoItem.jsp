<%@page import="model.domain.acervo.Item"%>
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
	<title>Consultar Item Para Exclusão</title>
	<!-- Bootstrap -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="estilo.css" rel="stylesheet">
</head>

<body>
	<%@ include file="menuFuncionario.jsp" %>
	
	<div class="container">

        <div class="col-md-12 jumbotron">
        
			<h2 align="center"> CONSULTAR ITEM PARA EXCLUSÃO</h2>
              <br><br>             
                                                 
                              
             <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Digite um nome para Filtrar">          
                
              <table id="myTable" class="table table-striped table-bordered table-hover">
                 <thead>
                    <tr><th>Titulo</th><th>Tipo Item</th><th>Numero de Série</th><th>Data de Aquisição</th></tr>
                </thead>
        
                <tbody data-link='row' class='rowlink'>
                 <%
                      Session s = (Session) request.getAttribute("sessaoBD");
                      Criteria c = s.createCriteria(Item.class);
                      c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
                      List l = c.list();
                      Iterator i = l.iterator();                      
                      
                      while(i.hasNext()){
                        Item t1 = (Item) i.next();
                        int id = t1.getId(); 
                        out.println("<form class='form-horizontal' method='POST' action='ServletCadastrarItem'>");
                        out.println("<tr>");
                        out.println("<td>"+ t1.getTitulo() +"</td>"
                                    + "<td>"+t1.getTipoItem()+"</td>"
                                    + "<td>"+t1.getNumSerie()+"</td>"
                                    + "<td>"+t1.getDtAquisicao()+"</td>"                                                                  
                                    + " <td> <button type='submit' name='operacao' value='excluirItem' class='btn btn-default'  > Excluir  </button> ");
                            out.println("<input type='hidden' id='id' name='id' value ='" + t1.getId() + "'>");
                            out.println("<input type='hidden' id='titulo' name='titulo' value ='"+ t1.getTitulo()+"'>");
                            out.println("<input type='hidden' id='tipo' name='tipo' value ='"+ t1.getTipoItem()+"'>");
                            out.println("<input type='hidden' id='serie' name='serie' value ='"+ t1.getNumSerie() +"'>");
                            out.println("<input type='hidden' id='dtAq' name='dtAq' value ='"+ t1.getDtAquisicao()+"'>");                        
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