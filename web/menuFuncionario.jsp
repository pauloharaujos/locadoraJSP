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
					<a href="indexFuncionario.jsp" class="navbar-brand"> <span class="glyphicon glyphicon-fast-forward"></span> Locadora Passatempo</a>
				</div>
				
				<div class="collapse navbar-collapse" id="barra-navegacao">
				  <ul class="nav navbar-nav navbar-right">
				   
				    <li class="dropdown">
				    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
				    <span class="glyphicon glyphicon-user"></span> Cliente <span class="caret"></span>
				    </a>
				    <ul class="dropdown-menu">
                                     <li> <a href="consultarCliente.jsp"> <span class="glyphicon glyphicon-search"></span> Consultar Cliente</a> </li>
				     <li> <a href="cadastrarSocio.jsp"><span class="glyphicon glyphicon-plus"></span> Cadastrar S�cio</a> </li>
				     <li> <a href="cadastrarDependente.jsp"><span class="glyphicon glyphicon-plus"></span> Cadastrar Dependente</a> </li>
				     <li> <a href="consultarAlteracaoCliente.jsp"> <span class="glyphicon glyphicon-refresh"></span> Alterar Cliente</a> </li>
				     <li> <a href="desativarCliente.jsp"> <span class="glyphicon glyphicon-eye-close"></span> Desativar Cliente</a> </li>
				     <li> <a href="reativarCliente.jsp"> <span class="glyphicon glyphicon-share-alt"></span> Reativar Cliente</a> </li>
				     <li> <a href="consultarExclusaoCliente.jsp"> <span class="glyphicon glyphicon-remove"></span> Excluir Cliente</a>
				    </ul>
				    </li>
				    
				    <li class="dropdown">
				    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
				    <span class="glyphicon glyphicon-calendar"></span> Loca��o <span class="caret"></span>
				    </a>
				    <ul class="dropdown-menu">
				     <li> <a href="efetuarLocacao.jsp"><span class="glyphicon glyphicon-plus"></span> Efetuar Loca��o</a> </li>
				     <li> <a href="consultarAlteracaoLocacao.jsp"><span class="glyphicon glyphicon-refresh"></span> Alterar Loca��o</a> </li>
				     <li> <a href="consultarExclusaoLocacao.jsp"> <span class="glyphicon glyphicon-remove"></span> Cancelar Loca��o</a> </li>
				     <li> <a href="efetuarDevolucao.jsp"> <span class="glyphicon glyphicon-share-alt"></span> Efetuar Devolu��o</a> </li>
				    
				    </ul>
				    </li>
				   
				   <li class="dropdown">
				    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
				    <span class="glyphicon glyphicon-user"></span> Ator <span class="caret"></span>
				    </a>
				    <ul class="dropdown-menu">
				     <li> <a href="cadastrarAtor.jsp"><span class="glyphicon glyphicon-plus"></span> Cadastrar Ator</a> </li>
				     <li> <a href="consultarAlteracaoAtor.jsp"><span class="glyphicon glyphicon-refresh"></span> Alterar Ator</a> </li>
				     <li> <a href="consultarExclusaoAtor.jsp"> <span class="glyphicon glyphicon-remove"></span> Excluir Ator</a> </li>
				    </ul>
				    </li>
				    
				    <li class="dropdown">
				    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
				    <span class="glyphicon glyphicon-user"></span> Diretor <span class="caret"></span>
				    </a>
				    <ul class="dropdown-menu">
				     <li> <a href="cadastrarDiretor.jsp"><span class="glyphicon glyphicon-plus"></span> Cadastrar Diretor</a> </li>
				     <li> <a href="consultarAlteracaoDiretor.jsp"><span class="glyphicon glyphicon-refresh"></span> Alterar Diretor</a> </li>
				     <li> <a href="consultarExclusaoDiretor.jsp"> <span class="glyphicon glyphicon-remove"></span> Excluir Diretor</a> </li>
				    </ul>
				    </li>
				    
				     <li class="dropdown">
				    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
				    <span class="glyphicon glyphicon-signal"></span> Classe <span class="caret"></span>
				    </a>
				    <ul class="dropdown-menu">
				     <li> <a href="cadastrarClasse.jsp"><span class="glyphicon glyphicon-plus"></span> Cadastrar Classe</a> </li>
				     <li> <a href="consultarAlteracaoClasse.jsp"><span class="glyphicon glyphicon-refresh"></span> Alterar Classe</a> </li>
				     <li> <a href="consultarExclusaoClasse.jsp"><span class="glyphicon glyphicon-remove"></span> Excluir Classe</a> </li>
				    </ul>
				    </li>
				    
				     <li class="dropdown">
				    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
				    <span class="glyphicon glyphicon-film"></span> Item <span class="caret"></span>
				    </a>
				    <ul class="dropdown-menu">
				     <li> <a href="cadastrarItem.jsp"><span class="glyphicon glyphicon-plus"></span> Cadastrar Item</a> </li>
				     <li> <a href="consultarAlteracaoItem.jsp"><span class="glyphicon glyphicon-refresh"></span> Alterar Item</a> </li>
				     <li> <a href="consultarItem.jsp"> <span class="glyphicon glyphicon-search"></span> Consultar Item</a> </li>
				     <li> <a href="consultarExclusaoItem.jsp"><span class="glyphicon glyphicon-remove"></span> Excluir Item</a> </li>
				    </ul>
				    </li>
				    
				     <li class="dropdown">
				    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
				    <span class="glyphicon glyphicon-facetime-video"></span> Titulo <span class="caret"></span>
				    </a>
				    <ul class="dropdown-menu">
				     <li> <a href="cadastrarTitulo.jsp"><span class="glyphicon glyphicon-plus"></span> Cadastrar Titulo</a> </li>
				     <li> <a href="consultarAlteracaoTitulo.jsp"><span class="glyphicon glyphicon-refresh"></span> Alterar Titulo</a> </li>            
                                      
				      <li> <a href="consultarTitulo.jsp"> <span class="glyphicon glyphicon-search"></span> Consultar Titulo</a> </li>                                                                
				     <li> <a href="consultarExclusaoTitulo.jsp"><span class="glyphicon glyphicon-remove"></span> Excluir Titulo</a> </li>
				    </ul>
				    </li>
				   
				   <li class="dropdown">
				    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
				    <span class="glyphicon glyphicon-cog"></span> Ol� Paulo <span class="caret"></span>
				    </a>
				    <ul class="dropdown-menu">
				     <li> <a href="#"><span class="glyphicon glyphicon-pencil"></span> Editar</a> </li>
				     <li> <a href="#"> <span class="glyphicon glyphicon-off"></span> Sair</a> </li>
				    </ul>
				    </li>
				  </ul>
				</div>
				
			</div>
	</nav>