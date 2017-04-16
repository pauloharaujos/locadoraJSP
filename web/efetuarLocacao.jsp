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
			<h2 align="center"> EFETUAR LOCAOAO</h2>		
            <form class="form-horizontal" method="POST" action="#">
              <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">Titulo</label>
                  <div class="col-sm-10">
                    <input type="email" class="form-control" id="inputEmail3" placeholder="Rambo">
                </div>
              </div>
              
              <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">Cliente</label>
                  <div class="col-sm-10">
                    <input type="email" class="form-control" id="inputEmail3" placeholder="Paulo">
                </div>
              </div>
              
              <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">Valor (R$)</label>
                  <div class="col-sm-10">
                    <input type="email" class="form-control" id="inputEmail3" placeholder="R$ 20,00">
                </div>
              </div>

                        

              <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Data Prevista</label>
                <div class="col-sm-10">
                  <input type="email" class="form-control" id="inputEmail3" placeholder="20/08/2017">
              </div>
              </div>
             

              <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                  <button type="submit" class="btn btn-default">OK</button>
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