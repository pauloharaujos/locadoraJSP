<%@page import="model.domain.acervo.Item"%>
<%@page import="model.domain.acervo.Item"%>
<%@page import="model.domain.cliente.Cliente"%>
<%@page import="model.domain.cliente.Cliente"%>
<%@page import="Hibernate.ConexaoSessionFactory"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="model.domain.acervo.Titulo"%>
<%@page import="org.hibernate.Session"%>
<%@page import="model.domain.acervo.Titulo"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Efetuar Locacao</title>
	<!-- Bootstrap -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="estilo.css" rel="stylesheet">
</head>

<body>
	<%@ include file="menuFuncionario.jsp" %>
	
	<div class="container">
        <div class="col-md-12 jumbotron">
			<h2 align="center"> EFETUAR LOCAÇÃO</h2>		
            <form class="form-horizontal" method="POST" action="ServletEfetuarLocacao">
             
              <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">Nome do Item</label>
                  <div class="col-sm-10">
                      <select name="item" class="form-control">
                          <%
                              SessionFactory sf = ConexaoSessionFactory.getSessionFactory();
                              Session s = sf.openSession();
                              Criteria c  = s.createCriteria(Item.class);
                              c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
                              List l = c.list();
                              Iterator i = l.iterator();
                              
                              while(i.hasNext()){
                                  Item t1 = (Item) i.next();
                                  int id = t1.getId();
                                  out.println("<option value='"+ id +"' >" +t1+"</option>");
                              }         
                              s.close();
                          %>
                      </select>                
                </div>
              </div>     
              
              <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">Nome do Cliente</label>
                  <div class="col-sm-10">
                      <select name="cliente" class="form-control">
                          <%
                              sf = ConexaoSessionFactory.getSessionFactory();
                              s = sf.openSession();
                              c  = s.createCriteria(Cliente.class);
                              c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
                              l = c.list();
                              i = l.iterator();
                              
                              while(i.hasNext()){
                                  Cliente c1 = (Cliente) i.next();
                                  int id = c1.getNumIncricao();
                                  out.println("<option value='"+ id +"' >" +c1+"</option>");
                              }                          
                          %>
                      </select>                
                </div>
              </div> 
              
              <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">Valor (R$)</label>
                  <div class="col-sm-10">
                    <input type="text" name="valor" value="20" class="form-control" id="inputEmail3" placeholder="R$ 20,00">
                </div>
              </div>

                        

              <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Data Prevista</label>
                <div class="col-sm-10">
                  <input type="text" name="data" value="31/04/2017" class="form-control" id="inputEmail3" placeholder="20/08/2017">
              </div>
              </div>

              <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                  <button type="submit" name="operacao" value="incluirLocacao" class="btn btn-default">OK</button>
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