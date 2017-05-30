<%@page import="model.domain.acervo.Titulo"%>
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
	<title>Alterar Item</title>
	<!-- Bootstrap -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="estilo.css" rel="stylesheet">
</head>

<body>
	<%@ include file="menuFuncionario.jsp" %>
	
	<div class="container">
		 

        <div class="col-md-12 jumbotron">
        
			<h2 align="center"> ALTERAR ITEM</h2>
            <form class="form-horizontal" method="POST" action="ServletCadastrarItem">            
           
                <div class="form-group">
            <%
               String id = request.getParameter("id");
               out.println("<input type='hidden' id='id' name='id' class='form-control' value='"+id+"'>");
            %>
            </div>

            <div class="form-group">
                <label class="col-md-2 control-label" for="selectbasic">Titulo</label>
                <div class="col-md-10">
                    <select id="selectbasic" name="titulo" class="form-control">
                          <%
                              Session s = (Session) request.getAttribute("sessaoBD");
                              Criteria c  = s.createCriteria(Titulo.class);
                              List l = c.list();
                              Iterator i = l.iterator();
                              
                              while(i.hasNext()){
                                  Titulo t1 = (Titulo) i.next();
                                  int idTitulo = t1.getId();
                                  out.println("<option value='"+ idTitulo +"' >" +t1+"</option>");
                              }                                 
                          %> 
                    </select>                                                 
                </div>
            </div>
 
              <div class="form-group">
                <label for="inputTipo" class="col-sm-2 control-label">Tipo</label>
                <div class="col-sm-10">
                  <select name="tipo" class="form-control">
                    <option value="fita">Fita</option>
                    <option value="dvd">DVD</option>
                    <option value="blueray">BlueRay</option>                  
                  </select>
                </div>
              </div>
            
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Número de Série</label>
                <div class="col-sm-10">
                <%
                String serie = request.getParameter("serie");
                out.println("<input type='text' id='serie' name='serie' class='form-control' value='"+serie+"'>");
                %>
                 </div>                
            </div>
                 
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Data de Aquisição</label>
                <div class="col-sm-10">
                <%
                String dtAq = request.getParameter("dtAq");
                out.println("<input type='text' id='dtAq' name='dtAq' class='form-control' value='"+dtAq+"'>");
                %>
                 </div>                
            </div>
      
            </div>
                    
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">                
                    <button type="submit" name="operacao" value="alterarItem" class="btn btn-default">Alterar</button>
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