<%@page import="Hibernate.ConexaoSessionFactory"%>
<%@page import="java.util.List"%>
<%@page import="model.domain.acervo.Item"%>
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
	<title>Excluir Item</title>
	<!-- Bootstrap -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="estilo.css" rel="stylesheet">
</head>

<body>
	<%@ include file="menuFuncionario.jsp" %>
	
	<div class="container">
        <div class="col-md-12 jumbotron">
        
			<h2 align="center"> EXCLUIR ITEM</h2>
            <form class="form-horizontal" method="POST" action="ServletCadastrarItem">            
            	
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
                                  Item i1 = (Item) i.next();
                                  int id = i1.getId();
                                  out.println("<option value='"+ id +"' >" +i1+"</option>");
                              }      
                              s.close();
                          %>
                      </select>                
                </div>
              </div> 
                                    

              <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">               
                  <button type="submit" name="operacao" value="excluirItem" class="btn btn-default">Excluir</button>
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