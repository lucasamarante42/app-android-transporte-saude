<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page session="true"%>

<spring:url value="/home" var="homeURL" />
<spring:url value="/logoutSuccessful" var="logoutURL" />


<spring:url value="/requisicoesviaapp/solicitacao-app" var="managerAllSolicitacaoAppURL" />
<spring:url value="/requisicoesviaapp/avaliacao-app" var="managerAllAvaliacaoAppURL" />
<spring:url value="/requisicoesviaapp/ouvidoria-app" var="managerAllOuvidoriaAppURL" />

<spring:url value="/agendamento/cadastro-agendamento" var="cadastroAgendamentoURL" />
<spring:url value="/agendamento/gerencia-all-agendamento" var="managerAllAgendamentoURL" />


<spring:url value="/automovel/gerencia-all-automovel" var="managerAllAutomovelURL" />	
<spring:url value="/automovel/cadastro-automovel" var="cadastroAutomovelURL" />


<spring:url value="/destino/gerencia-all-destino" var="managerAllDestinoURL" />
<spring:url value="/destino/cadastro-destino" var="cadastroDestinoURL" />


<spring:url value="/motorista/gerencia-all-motorista" var="managerAllMotoristaURL" />
<spring:url value="/motorista/cadastro-motorista" var="cadastroMotoristaURL" />
	

<spring:url value="/paciente/gerencia-all-paciente"	var="managerAllPacienteURL" />
<spring:url value="/paciente/cadastro-paciente"	var="cadastroPacienteURL" />


<spring:url value="/rota/gerencia-all-rota" var="managerAllRotaURL" />
<spring:url value="/rota/cadastro-rota" var="cadastroRotaURL" />


<spring:url value="/usuario/cadastro-usuario" var="cadastroUsuarioURL" />
<spring:url value="/usuario/gerencia-all-usuario" var="managerAllUsuarioURL" />


  <style>
   .dropdown-submenu{position:relative;}
   .dropdown-submenu>.dropdown-menu{top:0;left:100%;margin-top:-6px;margin-left:-1px;-webkit-border-radius:0 6px 6px 6px;-moz-border-radius:0 6px 6px 6px;border-radius:0 6px 6px 6px;}
   .dropdown-submenu>a:after{display:block;content:" ";float:right;width:0;height:0;border-color:transparent;border-style:solid;border-width:5px 0 5px 5px;border-left-color:#cccccc;margin-top:5px;margin-right:-10px;}
   .dropdown-submenu:hover>a:after{border-left-color:#555;}
   .dropdown-submenu.pull-left{float:none;}.dropdown-submenu.pull-left>.dropdown-menu{left:-100%;margin-left:10px;-webkit-border-radius:6px 0 6px 6px;-moz-border-radius:6px 0 6px 6px;border-radius:6px 0 6px 6px;}

  </style>

<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${homeURL}">INÍCIO</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">


				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">REQUISIÇÕES VIA APP<span class="caret"></span></a>

					<ul class="dropdown-menu">
						<li><a href="${managerAllSolicitacaoAppURL}">SOLICITAÇÃO DE TRANSPORTES</a></li>
						<li><a href="${managerAllAvaliacaoAppURL}">AVALIAÇÃO</a></li>
						<li><a href="${managerAllOuvidoriaAppURL}">OUVIDORIA</a></li>

					</ul></li>


				<li class="dropdown "><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">AGENDAMENTOS<span class="caret"></span></a>

					<ul class="dropdown-menu">
						<li><a href="${managerAllAgendamentoURL}">GERENCIAR	AGENDAMENTOS</a></li>
						<li><a href="${cadastroAgendamentoURL}">NOVO AGENDAMENTO</a></li>

					</ul>
				</li>



				<li class="dropdown "><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">LOGÍSTICA 
					
					<span class="caret"></span></a>

					<ul class="dropdown-menu">
						<li class="dropdown dropdown-submenu">
						 	<a href="#" class="dropdown-toggle" data-toggle="dropdown">AUTOMÓVEIS</a>
						 	
						 		<ul class="dropdown-menu">
								 <li>
									<a href="${managerAllAutomovelURL}">GERENCIAR AUTOMÓVEIS</a>
								 </li>
								 <li>
									<a href="${cadastroAutomovelURL}">NOVO AUTOMÓVEL</a>
								 </li>
								 
							 	</ul>						 	
						</li>
						
						
						
						<li class="dropdown dropdown-submenu">
						 	<a href="#" class="dropdown-toggle" data-toggle="dropdown">DESTINOS</a>
						 	
						 		<ul class="dropdown-menu">
								 <li>
									<a href="${managerAllDestinoURL}">GERENCIAR DESTINOS</a>
								 </li>
								 <li>
									<a href="${cadastroDestinoURL}">NOVO DESTINO</a>
								 </li>
								 
							 	</ul>						 	
						</li>
						
						
						<li class="dropdown dropdown-submenu">
						 	<a href="#" class="dropdown-toggle" data-toggle="dropdown">MOTORISTAS</a>
						 	
						 		<ul class="dropdown-menu">
								 <li>
									<a href="${managerAllMotoristaURL}">GERENCIAR MOTORISTAS</a>
								 </li>
								 <li>
									<a href="${cadastroMotoristaURL}">NOVO MOTORISTA</a>
								 </li>
								 
							 	</ul>						 	
						</li>
						
						
						<li class="dropdown dropdown-submenu">
						 	<a href="#" class="dropdown-toggle" data-toggle="dropdown">ROTAS</a>
						 	
						 		<ul class="dropdown-menu">
								 <li>
									<a href="${managerAllRotaURL}">GERENCIAR ROTAS</a>
								 </li>
								 <li>
									<a href="${cadastroRotaURL}">NOVA ROTA</a>
								 </li>
								 
							 	</ul>						 	
						</li>
												
						
					</ul>
				</li>




				<li class="dropdown "><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">PACIENTES <span class="caret"></span></a>

					<ul class="dropdown-menu">
						<li><a href="${managerAllPacienteURL}">GERENCIAR PACIENTES</a></li>
						<li><a href="${cadastroPacienteURL}">NOVO PACIENTE</a></li>

					</ul>
				</li>


				<li class="dropdown "><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">RELATÓRIOS<span class="caret"></span></a>

					<ul class="dropdown-menu">
						<li><a href="${addURL}">AGENDAMENTOS</a></li>
						<li><a href="${addURL}">AUTOMÓVEIS</a></li>
						<li><a href="${addURL}">DESTINOS</a></li>
						<li><a href="${addURL}">MOTORISTAS</a></li>
						<li><a href="${listURL}">PACIENTES</a></li>
						<li><a href="${addURL}">ROTAS</a></li>
						<li><a href="${addURL}">USUÁRIOS</a></li>

					</ul>
				</li>




				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">USUÁRIOS <span class="caret"></span></a>

					<ul class="dropdown-menu">
						<li><a href="${managerAllUsuarioURL}">GERENCIAR USUÁRIOS</a></li>
						<li><a href="${cadastroUsuarioURL}">NOVO USUÁRIO</a></li>


					</ul>
				</li>



				<li class="dropdown "><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">SOBRE <span class="caret"></span></a>

					<ul class="dropdown-menu">
						<li><a href="${listURL}">CONTATO</a></li>
						<li><a href="${addURL}">SUPORTE</a></li>

					</ul>
				</li>





			</ul>











			<ul class="nav navbar-nav navbar-right">
				<li><a href="${pageContext.request.contextPath}/j_spring_security_logout" >
				<span class="glyphicon glyphicon-log-out"></span>
						LOGOUT</a></li>


			</ul>




		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>



<script type="text/javascript">
(function($){
	$(document).ready(function(){
		$('ul.dropdown-menu [data-toggle=dropdown]').on('click', function(event) {
			event.preventDefault(); 
			event.stopPropagation(); 
			$(this).parent().siblings().removeClass('open');
			$(this).parent().toggleClass('open');
		});
	});
})(jQuery);
</script>
