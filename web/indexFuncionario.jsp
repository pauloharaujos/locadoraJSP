<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">

<head>
	<meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Funcionario</title>

	<!-- Bootstrap -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="estilo.css" rel="stylesheet">

</head>

<body>

	<%@ include file="menuFuncionario.jsp" %>
	
    <div class="container">

        <div class="col-md-12 jumbotron">
			<h2 align="center"> CADASTRO DE TITULO</h2>		
            <form class="form-horizontal" method="POST" action="#">
              <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">Nome</label>
                  <div class="col-sm-10">
                    <input type="email" class="form-control" id="inputEmail3" placeholder="Joao Almeida">
                </div>
              </div>

              <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Atores</label>
                <div class="col-sm-10">
                  <select multiple class="form-control">
                    <option>João Almeida</option>
                    <option>Roberto Mendes</option>
                    <option>Hugo Galter</option>
                    <option>Alexandre Costa</option>
                    <option>Joana Assis</option>
                  </select>
                </div>
              </div>

              <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Categoria</label>
                <div class="col-sm-10">
                  <select multiple class="form-control">
                    <option>João Almeida</option>
                    <option>Roberto Mendes</option>
                    <option>Hugo Galter</option>
                    <option>Alexandre Costa</option>
                    <option>Joana Assis</option>
                  </select>
                </div>
              </div>

              <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Classes</label>
                <div class="col-sm-10">
                  <select multiple class="form-control">
                    <option>João Almeida</option>
                    <option>Roberto Mendes</option>
                    <option>Hugo Galter</option>
                    <option>Alexandre Costa</option>
                    <option>Joana Assis</option>
                  </select>
                </div>
              </div>

              <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Ano</label>
                <div class="col-sm-10">
                  <input type="email" class="form-control" id="inputEmail3" placeholder="2000">
              </div>
              </div>

              <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Sinopse</label>
                <div class="col-sm-10">
                  <textarea class="form-control" rows="3" placeholder="Descrição do Filme"></textarea>
              </div>
              </div>

              <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                  <button type="submit" class="btn btn-default">Enviar</button>
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