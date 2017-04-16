<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Cadastro de Item</title>
	<!-- Bootstrap -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="estilo.css" rel="stylesheet">
</head>

<body>
	<%@ include file="menuFuncionario.jsp" %>
	
	<div class="container">

        <div class="col-md-12 jumbotron">
			<h2 align="center"> CADASTRO DE ITEM</h2>		
            <form class="form-horizontal" method="POST" action="ServletCadastrarItem">
              <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">Numero de Série</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="numSerie" id="inputNumSerie" placeholder="312321311">
                </div>
              </div>
              
               <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">Título</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="titulo" id="inputTitulo" >
                </div>
              </div>

              <div class="form-group">
                <label for="inputTipo" class="col-sm-2 control-label">Tipo</label>
                <div class="col-sm-10">
                  <select multiple class="form-control">
                    <option>Fita</option>
                    <option>DVD</option>
                    <option>BlueRay</option>                  
                  </select>
                </div>
              </div>
              
               <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">Data de Aquisição</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="dtAq" id="inputDtAq" placeholder="20/09/2017">
                </div>
              </div>

              <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                  <button type="submit" class="btn btn-default">Cadastrar</button>
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