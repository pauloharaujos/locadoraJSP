<%@page import="model.domain.acervo.Diretor"%>
<%@page import="model.domain.acervo.Classe"%>
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
	<title>Alterar Titulo</title>
	<!-- Bootstrap -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="estilo.css" rel="stylesheet">
</head>

<body>
	<%@ include file="menuFuncionario.jsp" %>
	
	<div class="container">
		 

        <div class="col-md-12 jumbotron">
        
			<h2 align="center"> ALTERAR TITULO</h2>
            <form class="form-horizontal" method="POST" action="ServletCadastrarTitulo">            
           
                <div class="form-group">
            <%
               String id = request.getParameter("id");
               out.println("<input type='hidden' id='id' name='id' class='form-control' value='"+id+"'>");
            %>
            </div>
            
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Nome</label>
                <div class="col-sm-10">
                <%
                String nome = request.getParameter("nome");
                out.println("<input type='text' id='nome' name='nome' class='form-control' value='"+nome+"'>");
                %>
                 </div>                
            </div>
              
             <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">Sinopse</label>
                  <div class="col-sm-10">
                  <%
                  String sinopse = request.getParameter("sinopse");
                  out.println("<textarea id='sinopse' name='sinopse' class='form-control' rows='3' value='"+sinopse+"'> </textarea>");
                  %>
                 </div>                
             </div>    
            
             <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">Ano</label>
                  <div class="col-sm-10">
                  <%
                  String ano = request.getParameter("ano");
                  out.println("<input type='text' id='ano' name='ano' class='form-control' value='"+ano+"'>");
                  %>
                 </div>                
             </div>

            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Categoria</label>
                <div class="col-sm-10">
                    <%
                    String categoria = request.getParameter("categoria");
                    out.println("<input type='text' id='categoria' name='categoria' class='form-control' value='"+categoria+"'>");
                    %>
                </div>                
            </div>
                
            <div class="form-group">
                <label class="col-md-2 control-label" for="selectbasic">Classe</label>
                <div class="col-md-10">
                    <select id="selectbasic" name="classe" class="form-control">
                          <%
                              Session s = (Session) request.getAttribute("sessaoBD");
                              Criteria c  = s.createCriteria(Classe.class);
                              List l = c.list();
                              Iterator i = l.iterator();
                              
                              while(i.hasNext()){
                                  Classe c1 = (Classe) i.next();
                                  int idClasse = c1.getId();
                                  out.println("<option value='"+ idClasse +"' >" +c1+"</option>");
                              }                                 
                          %> 
                    </select>                                                 
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-2 control-label" for="selectbasic">Diretor</label>
                <div class="col-md-10">
                    <select id="selectbasic" name="diretor" class="form-control">
                          <%
                              s = (Session) request.getAttribute("sessaoBD");
                              c  = s.createCriteria(Diretor.class);
                              l = c.list();
                              i = l.iterator();
                              
                              while(i.hasNext()){
                                  Diretor d1 = (Diretor) i.next();
                                  int idDiretor= d1.getId();
                                  out.println("<option value='"+ idDiretor +"' >" +d1+"</option>");
                              }                                 
                          %> 
                    </select>                                                 
                </div>
            </div>
                    
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">                
                    <button type="submit" name="operacao" value="alterarTitulo" class="btn btn-default">Alterar</button>
                </div>
            </div>
            </form>
        </div>
                 

           
       </div>

    	<div id="footer" class="col-md-12">
            <h4 align="center"> Desenvolvido por Paulo Henrique - M18 <br> IFES - Campus Colatina</h4>
    	</div>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
</body>

</html>