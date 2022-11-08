<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<spring:url value="/home" var="homeURL" />


<spring:url value="/requisicoesviaapp/solicitacao-app"	var="managerAllSolicitacaoAppURL" />
<spring:url value="/requisicoesviaapp/ouvidoria-app"	var="managerAllOuvidoriaAppURL" />
<spring:url value="/requisicoesviaapp/avaliacao-app"	var="managerAllAvaliacaoAppURL" />

<spring:url value="/agendamento/gerencia-all-agendamento"	var="managerAllAgendamentoURL" />
<spring:url value="/automovel/gerencia-all-automovel"	var="managerAllAutomovelURL" />
<spring:url value="/destino/gerencia-all-destino"	var="managerAllDestinoURL" />
<spring:url value="/motorista/gerencia-all-motorista"	var="managerAllMotoristaURL" />
<spring:url value="/paciente/gerencia-all-paciente"	var="managerAllPacienteURL" />
<spring:url value="/rota/gerencia-all-rota"	var="managerAllRotaURL" />
<spring:url value="/usuario/gerencia-all-usuario" var="managerAllUsuarioURL" />


<!DOCTYPE html>
<html lang="pt-br">
<jsp:include page="../templates/header.jsp" />

<body>
	<jsp:include page="../templates/nav.jsp" />

	<div class="container">

		<h1>Dashboard</h1>
		<hr />


		<div class="row">


			<div class="col-xs-3 col-sm-3 col-lg-2">
				<a href="${managerAllAgendamentoURL}" class="btn btn-danger">
					<div class="row">
						<div class="col-xs-12 text-center">
							<p>
							<dt>AGENDAMENTOS</dt>
							</p>
						</div>
						<div class="col-xs-12 text-center">
							<i class="fa fa-heartbeat fa-5x"></i>
						</div>

					</div>
				</a>
			</div>


			<div class="col-xs-3 col-sm-3 col-lg-2">
				<a href="${managerAllAutomovelURL}" class="btn btn-warning">
					<div class="row">
						<div class="col-xs-12 text-center">
							<p>
							<dt>AUTOMÓVEIS</dt>
							</p>
						</div>
						<div class="col-xs-12 text-center">
							<i class="fa fa-car fa-5x"></i>
						</div>

					</div>
				</a>
			</div>



			<div class="col-xs-3 col-sm-3 col-lg-2">
				<a href="${managerAllDestinoURL}" class="btn btn-success">
					<div class="row">
						<div class="col-xs-12 text-center">
							<p>
							<dt>DESTINOS</dt>
							</p>
						</div>
						<div class="col-xs-12 text-center">
							<i class="fa fa-hospital-o fa-5x"></i>
						</div>

					</div>
				</a>
			</div>

			<div class="col-xs-3 col-sm-3 col-lg-2">
				<a href="${managerAllMotoristaURL}" class="btn btn-info">
					<div class="row">
						<div class="col-xs-12 text-center">
							<p>
							<dt>MOTORISTAS</dt>
							</p>
						</div>
						<div class="col-xs-12 text-center">
							<i class="fa fa-black-tie fa-5x"></i>
						</div>

					</div>
				</a>
			</div>

			<div class="col-xs-3 col-sm-3 col-lg-2">
				<a href="${managerAllPacienteURL}" class="btn btn-primary">
					<div class="row">
						<div class="col-xs-12 text-center">
							<p>
							<dt>PACIENTES</dt>
							</p>
						</div>
						<div class="col-xs-12 text-center">
							<i class="fa fa-users fa-5x"></i>
						</div>

					</div>
				</a>
			</div>

			<div class="col-xs-3 col-sm-3 col-lg-2">
				<a href="${homeURL}" class="btn btn-default">
					<div class="row">
						<div class="col-xs-12 text-center">
							<p>
							<dt>RELATÓRIOS</dt>
							</p>
						</div>
						<div class="col-xs-12 text-center">
							<i class="fa fa-file-text-o fa-5x"></i>
						</div>

					</div>
				</a>
			</div>




		</div>
		<br>
		<div class="row">

			


			<div class="col-xs-3 col-sm-3 col-lg-2">
				<a href="${managerAllRotaURL}" class="btn btn-success">
					<div class="row">
						<div class="col-xs-12 text-center">
							<p>
							<dt>ROTAS</dt>
							</p>
						</div>
						<div class="col-xs-12 text-center">
							<i class="fa fa-safari fa-5x"></i>
						</div>

					</div>
				</a>
			</div>




			<div class="col-xs-3 col-sm-3 col-lg-2">
				<a href="${managerAllUsuarioURL}" class="btn btn-primary">
					<div class="row">
						<div class="col-xs-12 text-center">
							<p>
							<dt>USUÁRIOS</dt>
							</p>
						</div>
						<div class="col-xs-12 text-center">
							<i class="fa fa-user-secret fa-5x"></i>
						</div>

					</div>
				</a>
			</div>



			<div class="col-xs-3 col-sm-3 col-lg-2">
				<a href="${managerAllSolicitacaoAppURL}" class="btn btn-default">
					<div class="row">
						<div class="col-xs-12 text-center">
							<p>
							<dt>SOLICITAÇÃO APP</dt>
							</p>
						</div>
						<div class="col-xs-12 text-center">
							<i class="fa fa-mobile-phone fa-5x"></i>
						</div>

					</div>
				</a>
			</div>


			<div class="col-xs-3 col-sm-3 col-lg-2">
				<a href="${managerAllOuvidoriaAppURL}" class="btn btn-default">
					<div class="row">
						<div class="col-xs-12 text-center">
							<p>
							<dt>OUVIDORIA APP</dt>
							</p>
						</div>
						<div class="col-xs-12 text-center">
							<i class="fa fa-mobile-phone fa-5x"></i>
						</div>

					</div>
				</a>
			</div>


			<div class="col-xs-3 col-sm-3 col-lg-2">
				<a href="${managerAllAvaliacaoAppURL}" class="btn btn-default">
					<div class="row">
						<div class="col-xs-12 text-center">
							<p>
							<dt>AVALIAÇÃO APP</dt>
							</p>
						</div>
						<div class="col-xs-12 text-center">
							<i class="fa fa-mobile-phone fa-5x"></i>
						</div>

					</div>
				</a>
			</div>





		</div>






<footer class="footer navbar-fixed-bottom">
	  <p class="text-center">&copy;2017 - Todos os direitos reservados - Desenvolvimento Web SGLPS </p>
		
</footer>




	</div>

	<jsp:include page="../templates/footer.jsp" />

</body>
</html>