<%@page import="model.domain.acervo.Diretor"%>
<%@page import="model.domain.acervo.Classe"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="model.domain.acervo.Ator"%>
<%@page import="org.hibernate.Session"%>
<%@page import="Hibernate.ConexaoSessionFactory"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Cadastro de Titulo</title>
	<!-- Bootstrap -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="estilo.css" rel="stylesheet">
</head>

<body>
	<%@ include file="menuFuncionario.jsp" %>
	
	<div class="container">
    
        <div class="col-md-12 jumbotron">
			<h2 align="center"> CADASTRO DE TÍTULO</h2>		
            <form class="form-horizontal" method="POST" action="ServletCadastrarTitulo">
              <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">Nome</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="nome" id="inputNome" placeholder="Joao Almeida">
                </div>
              </div>

              <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Atores</label>
                <div class="col-sm-10">
                    <select multiple name="atores" class="form-control">
                          <%
                              SessionFactory sf = ConexaoSessionFactory.getSessionFactory();
                              Session s = sf.openSession();
                              Criteria c  = s.createCriteria(Ator.class);
                              List l = c.list();
                              Iterator i = l.iterator();
                              
                              while(i.hasNext()){
                                  Ator a = (Ator) i.next();
                                  int id = a.getId();
                                  out.println("<option value='"+ id +"' >" +a+"</option>");
                              }    
                              s.close();
                          %>
                          
                      </select> 
                </div>
              </div>
                      
              <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Diretor</label>
                <div class="col-sm-10">
                    <select name="diretor" class="form-control">
                          <%
                              sf = ConexaoSessionFactory.getSessionFactory();
                              s = sf.openSession();
                              c  = s.createCriteria(Diretor.class);
                              l = c.list();
                              i = l.iterator();
                              
                              while(i.hasNext()){
                                  Diretor d = (Diretor) i.next();
                                  int id = d.getId();
                                  out.println("<option value='"+ id +"' >" +d+"</option>");
                              }   
                              s.close();
                          %>
                      </select> 
                </div>
              </div>

              <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Categoria</label>
                <div class="col-sm-10">
                  <select name="categoria" class="form-control">
                    <option>Categoria 1</option>
                    <option>Categoria 2</option>
                    <option>Categoria 3</option>                    
                  </select>
                </div>
              </div>

              <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Classes</label>
                <div class="col-sm-10">
                  <select name="classe" class="form-control">
                          <%
                              sf = ConexaoSessionFactory.getSessionFactory();
                              s = sf.openSession();
                              c  = s.createCriteria(Classe.class);
                              l = c.list();
                              i = l.iterator();
                              
                              while(i.hasNext()){
                                  Classe c1 = (Classe) i.next();
                                  int id = c1.getId();
                                  out.println("<option value='"+ id +"' >" +c1+"</option>");
                              }    
                              s.close();
                          %>
                      </select> 
                </div>
              </div>

              <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Ano</label>
                <div class="col-sm-10">
                  <input type="text" class="form-control" name="ano" id="inputAno" placeholder="2000">
              </div>
              </div>

              <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Sinopse</label>
                <div class="col-sm-10">
                  <textarea class="form-control" rows="3" name="sinopse" placeholder="Descrição do Filme"></textarea>
              </div>
              </div>

              <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                  <button type="submit" name="operacao" value="incluirTitulo" class="btn btn-default">Cadastrar Titulo</button>
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