<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="model.domain.cliente.Socio"%>
<%@page import="Hibernate.ConexaoSessionFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Cadastro de Dependente</title>
	<!-- Bootstrap -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="estilo.css" rel="stylesheet">
</head>

<body>
	<%@ include file="menuFuncionario.jsp" %>
	
	<div class="container">

        <div class="col-md-12 jumbotron">
        
			<h2 align="center"> CADASTRO DE DEPENDENTE</h2>
            <form class="form-horizontal" method="POST" action="ServletCadastrarCliente">            
            	
              <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">Nome</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="nome" id="inputNome" placeholder="Joao Almeida">
                </div>
              </div>  
                
              <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">Data de Nascimento</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="dtNasc" id="inputDtNasc" placeholder="20/08/1996">
                </div>
              </div>
              
               <div class="form-group">
                  <label for="inputSexo" class="col-sm-2 control-label">Sexo</label>
                  <div class="col-sm-10">
                     <select name="sexo" class="form-control">
                          <option value="masculino">Masculino</option>
                          <option value="feminino">Feminino</option>
                      </select>		                    					   
		  </div>
                </div>
                 
              
              <div class="form-group">
                  <label for="inputAtivo" class="col-sm-2 control-label">Ativo ?</label>
                  <div class="col-sm-10">
                      <select name="ativo" class="form-control">
                          <option value="1">Sim</option>
                          <option value="0">Não</option>
                      </select>	                    					   
		  </div>
                </div>
                
                <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Sócio</label>
                <div class="col-sm-10">
                    <select name="socio" class="form-control">
                          <%
                              SessionFactory sf = ConexaoSessionFactory.getSessionFactory();
                              Session s = sf.openSession();
                              Criteria c  = s.createCriteria(Socio.class);
                              List l = c.list();
                              Iterator i = l.iterator();
                              
                              while(i.hasNext()){
                                  Socio so = (Socio) i.next();
                                  int id = so.getNumIncricao();
                                  out.println("<option value='"+ id +"' >" +so+"</option>");
                              }                          
                          %>
                      </select> 
                </div>
              </div>              
              </div>                    
           </div>  
                      
              <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                  <button type="submit" name="operacao" value="incluirDependente" class="btn btn-default">Cadastrar</button>
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