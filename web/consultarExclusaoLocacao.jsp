<%@page import="model.domain.cliente.Locacao"%>
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
	<title>Cancelar Locação</title>
	<!-- Bootstrap -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="estilo.css" rel="stylesheet">
</head>

<body>
	<%@ include file="menuFuncionario.jsp" %>
	
	<div class="container">

        <div class="col-md-12 jumbotron">
        
			<h2 align="center"> CANCELAR LOCAÇÃO</h2>
              <br><br>             
                                                 
                              
             <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Digite um nome para Filtrar">          
                
              <table id="myTable" class="table table-striped table-bordered table-hover">
                 <thead>
                    <tr><th>Item</th><th>Cliente</th><th>Valor</th><th>Multa</th><th>Data da Locação</th><th>Data Devolução Prevista</th></tr>
                </thead>
        
                <tbody data-link='row' class='rowlink'>
                 <%
                      Session s = (Session) request.getAttribute("sessaoBD");
                      Criteria c = s.createCriteria(Locacao.class);
                      c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
                      List l = c.list();
                      Iterator i = l.iterator();
                                            
                      while(i.hasNext()){
                        Locacao l1 = (Locacao) i.next();
                        int id = l1.getId(); //                      
                            out.println("<form class='form-horizontal' method='POST' action='ServletEfetuarLocacao'>");
                            out.println("<tr>");
                            out.println("<td>"+ l1.getItem() +"</td>"
                                    + "<td>"+l1.getCliente()+"</td>"
                                    + "<td>"+l1.getValorCobrado()+"</td>"
                                    + "<td>"+l1.getMultaCobrada()+"</td>"    
                                    + "<td>"+l1.getDtLocacao()+"</td>"
                                    + "<td>"+l1.getDtDevolucaoPrevista()+"</td>"                                
                                    + " <td> <button type='submit' name='operacao' value='cancelarLocacao' class='btn btn-default'  > Cancelar  </button> ");
                            out.println("<input type='hidden' id='id' name='id' value ='" + l1.getId() + "'>");                                         
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