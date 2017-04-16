<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>LOCADORA PASSATEMPO</title>
	 <!-- Bootstrap -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="estilo.css" rel="stylesheet">
</head>

<body>

<nav class="navbar navbar-inverse">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
					 data-toggle="collapse" data-target="#barra-navegacao">
					  <span class="sr-only">Alternar Menu</span>
					  <span class="icon-bar"></span>
					  <span class="icon-bar"></span>
					  <span class="icon-bar"></span> 
					</button>
					<a href="index.html" class="navbar-brand"> <span class="glyphicon glyphicon-fast-forward"></span> Locadora Passatempo</a>
				</div>
				
				<div class="collapse navbar-collapse" id="barra-navegacao">
				
				   <!-- Login -->
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> <span class="glyphicon glyphicon-user"></span> Login <span class="caret"></span></a>
                            <form class="dropdown-menu" name="loginUser" method="POST" action="ServletLogin">
                                <div class="input-group">
                                    <span class="input-group-addon" id="username">
                                        <span class="glyphicon glyphicon-user"></span>
                                    </span>
                                    <input type="text" class="form-control" placeholder="Username" aria-describedby="username" name="login-username">
                                </div>
                                <br>
                                <div class="input-group">
                                    <span class="input-group-addon" id="password">
                                        <span class="glyphicon glyphicon-lock"></span>
                                    </span>
                                    <input type="password" class="form-control" placeholder="Password" aria-describedby="password" name="login-password">
                                </div>
                                <div role="separator" class="divider"></div>
                                <input id="submit-login" type="submit" class="btn btn-primary" value="Entrar">
                            </form> 
                        </li>
                    </ul>
				  
				  
				</div>
				
			</div>
	</nav>   
	
    <div class="container">

        <div class="col-md-12 jumbotron">
			<h2 align="center"> CONSULTAR TÍTULO</h2>		
			
		<form class="form-horizontal" method="POST" action="#"> 
		<div class="row">
		  <div class="col-md-12">
		 
		  <div class="col-md-12">
		    <div class="input-group">
		      <input type="text" class="form-control" aria-label="...">
		      <div class="input-group-btn">
		        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Filtro <span class="caret"></span></button>
		        <ul class="dropdown-menu dropdown-menu-right">
		          <li><a href="#">Ator</a></li>
		          <li><a href="#">Título</a></li>
		          <li><a href="#">Categoria</a></li>		              
		        </ul>
		       <button class="btn button-primary">OK</button>
		      </div><!-- /btn-group -->
		      
		    </div><!-- /input-group -->
		  </div><!-- /.col-lg-6 -->
		</div><!-- /.row -->
			
       </div>    
       </form>       
       
    	</div>
    	
    	
    
		
		<div class="panel panel-success">
		  <div class="panel-heading">
		    <h3 class="panel-title">Títulos Encontrados</h3>
		  </div>
		  <div class="panel-body">
		    <div class="row">
			  <div class="col-sm-6 col-md-4">
			    <div class="thumbnail">
			      <img src="img/rambo1.png" alt="...">
			      <div class="caption">
			        <h3>rambo</h3>
			        <p>...</p>
			        <p><a href="#" class="btn btn-primary" role="button">Ler Mais</a></p>
			      </div>
			    </div>
			  </div>
			 </div>
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