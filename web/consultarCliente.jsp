<%@page import="model.domain.cliente.Socio"%>
<%@page import="model.domain.cliente.Dependente"%>
<%@page import="model.domain.cliente.Cliente"%>
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
	<title>Consultar Cliente</title>
	<!-- Bootstrap -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="estilo.css" rel="stylesheet">
</head>

<body>
	<%@ include file="menuFuncionario.jsp" %>
	
	<div class="container">

        <div class="col-md-12 jumbotron">
        
			<h2 align="center"> CONSULTAR CLIENTE</h2>
              <br><br>             
                                                 
                              
             <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Digite um nome para Filtrar">          
                
              <table id="myTable" class="table table-striped table-bordered table-hover">
                 <thead>
                    <tr><th>Nome</th><th>Numero de Inscrição</th><th>Sexo</th><th>Data de Nascimento</th><th>Ativo ?</th><th>Nome do Socio</th>
                    <th>CPF</th><th>Endereço</th><th>Telefone</th></tr>
                </thead>
        
                <tbody data-link='row' class='rowlink'>
                 <%
                      Session s = (Session) request.getAttribute("sessaoBD");
                      Criteria c = s.createCriteria(Cliente.class);
                      c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
                      List l = c.list();
                      Iterator i = l.iterator();                      
                      
                      while(i.hasNext()){
                        Cliente c1 = (Cliente) i.next();
                       
                        if( c1 instanceof Dependente ){
                          Dependente d1 = (Dependente) c1;
                          
                        out.println("<form class='form-horizontal' method='POST' action='#'>");
                        out.println("<tr>");
                        out.println("<td>"+ d1.getNome() +"</td>"
                                    + "<td>"+d1.getNumIncricao()+"</td>"
                                    + "<td>"+d1.getSexo()+"</td>"
                                    + "<td>"+d1.getDtNascimento()+"</td>"     
                                    + "<td>"+d1.getEstahAtivo()+"</td>"
                                    + "<td>"+d1.getSocio()+"</td>"
                                    );
                            out.println("</tr>");
                            out.println("</form>");    
                        }else{
                            Socio s1 = (Socio) c1;
                          
                            out.println("<form class='form-horizontal' method='POST' action='#'>");
                            out.println("<tr>");
                            out.println("<td>"+ s1.getNome() +"</td>"
                                        + "<td>"+s1.getNumIncricao()+"</td>"
                                        + "<td>"+s1.getSexo()+"</td>"
                                        + "<td>"+s1.getDtNascimento()+"</td>"     
                                        + "<td>"+s1.getEstahAtivo()+"</td>"
                                        + "<td> - </td>"
                                        + "<td>"+s1.getCpf()+"</td>"
                                        + "<td>"+s1.getEndereco()+"</td>"
                                        + "<td>"+s1.getTel()+"</td>"
                                        );
                            out.println("</tr>");
                            out.println("</form>");    
                        }
                                          
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