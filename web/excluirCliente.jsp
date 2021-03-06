<%@page import="Hibernate.ConexaoSessionFactory"%>
<%@page import="model.domain.cliente.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Excluir Cliente</title>
	<!-- Bootstrap -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="estilo.css" rel="stylesheet">
</head>

<body>
	<%@ include file="menuFuncionario.jsp" %>
	
	<div class="container">

        <div class="col-md-12 jumbotron">
        
			<h2 align="center"> EXCLUIR CLIENTE</h2>
            <form class="form-horizontal" method="POST" action="ServletCadastrarCliente">            
            	
              <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">Nome do Cliente</label>
                  <div class="col-sm-10">
                      <select name="cliente" class="form-control">
                          <%
                              SessionFactory sf = ConexaoSessionFactory.getSessionFactory();
                              Session s = sf.openSession();
                              Criteria c  = s.createCriteria(Cliente.class);
                              c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
                              List l = c.list();
                              Iterator i = l.iterator();
                              
                              while(i.hasNext()){
                                  Cliente c1 = (Cliente) i.next();
                                  int id = c1.getNumIncricao();
                                  out.println("<option value='"+ id +"' >" +c1+"</option>");
                              }                          
                          %>
                          s.close();
                      </select>                
                </div>
              </div> 
                                    

              <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">               
                  <button type="submit" name="operacao" value="excluirCliente" class="btn btn-default">Excluir</button>
                </div>
              </div>
              </form>
    		</div>

    		<div id="footer" class="col-md-12">
    		    <h4 align="center"> Desenvolvido por Paulo Henrique - M18 <br> IFES - Campus Colatina</h4>
    		</div>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
</body>

</html>