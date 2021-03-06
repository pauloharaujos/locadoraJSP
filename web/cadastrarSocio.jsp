<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Cadastro de Socio</title>
	<!-- Bootstrap -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="estilo.css" rel="stylesheet">
</head>

<body>
	<%@ include file="menuFuncionario.jsp" %>
	
	  <div class="container">

        <div class="col-md-12 jumbotron">
        
			<h2 align="center"> CADASTRO DE SÓCIO</h2>
            <form class="form-horizontal" method="POST" action="ServletCadastrarCliente">            
            	
              <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">Nome</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="nome" id="inputNome" placeholder="Joao Almeida">
                </div>
              </div>
             
             <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">CPF</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="cpf" id="inputCPF" placeholder="124.213.213.98">
                </div>
              </div>
              
              <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">Endereço</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="endereco" id="inputEndereco" placeholder="Avenida Angelo Giuberti, nº 375">
                </div>
              </div>
                
               <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">Telefone</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="telefone" id="inputTelefone" placeholder="(27) 99999-9999">
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
              </div>         
            </div>  

              <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                  <button type="submit" name="operacao" value="incluirSocio" class="btn btn-default">Cadastrar</button>
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