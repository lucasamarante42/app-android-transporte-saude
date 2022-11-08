<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:errors path="cpfPacienteAgendamento" />
<form:errors path="idDestinoAgendamento" />
<form:errors path="idMotoristaAgendamento" />
<form:errors path="idAutomovelAgendamento" />
<form:errors path="idRotaAgendamento" />
<form:errors path="dataAgendamento" />
<form:errors path="horaAgendamento" />
<form:errors path="necessidadeAcompanhanteAgendamento" />
<form:errors path="statusAgendamento" />


<spring:url value="/agendamento/gerencia-all-agendamento"
	var="voltarManagerAllAgendamentoURL" />

<!DOCTYPE html>
<html lang="pt-br">
<jsp:include page="../templates/header.jsp" />

<body>
	<jsp:include page="../templates/nav.jsp" />



	<div class="container">




		<div style="margin-top: 30px;"
			class="mainbox col-md-8 col-md-offset-2 col-sm-9 col-sm-offset-2">

			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="panel-title">DETALHES</div>
				</div>


				<div class="panel-body" align="center">

					<h3>Agendamento</h3>

					<p>
						<b>ID:</b> ${agendamento.idAgendamento}
					</p>

					<p>
						<b>Cpf Paciente:</b> ${agendamento.cpfPacienteAgendamento}
					</p>

					<p>
						<b>Data:</b> ${agendamento.dataAgendamento}
					</p>

					<p>
						<b>Hora:</b> ${agendamento.horaAgendamento}
					</p>

					<p>
						<b>Necessidade de acompanhante:</b>
						${agendamento.necessidadeAcompanhanteAgendamento}
					</p>

					<p>
						<b>Status:</b> ${agendamento.statusAgendamento}
					</p>



					<hr>


					<h3>Destino</h3>

					<p>
						<b>ID:</b> ${agendamento.destino.idDestino}
					</p>

					<p>
						<b>Local:</b> ${agendamento.destino.nomeLocalDestino}
					</p>

					<p>
						<b>Endereço:</b> ${agendamento.destino.enderecoDestino}
					</p>

					<p>
						<b>Cidade:</b> ${agendamento.destino.cidadeDestino}
					</p>

					<p>
						<b>Telefone:</b> ${agendamento.destino.telefoneDestino}
					</p>

					
					
					<hr>


					<h3>Rota</h3>

					<p>
						<b>ID:</b> ${agendamento.rota.idRota}
					</p>

					<p>
						<b>Destino:</b> ${agendamento.rota.destinoRota}
					</p>

					<p>
						<b>Distância (km):</b> ${agendamento.rota.distanciaRota}
					</p>

					<p>
						<b>Tempo:</b> ${agendamento.rota.tempoEstimadoRota}
					</p>

					
					<hr>


					<h3>Automóvel</h3>

					<p>
						<b>ID:</b> ${agendamento.automovel.idAutomovel}
					</p>

					<p>
						<b>Automóvel:</b> ${agendamento.automovel.nomeAutomovel}
					</p>

					<p>
						<b>Marca:</b> ${agendamento.automovel.marcaAutomovel}
					</p>

					<p>
						<b>Capacidade (passageiros):</b> 
						${agendamento.automovel.capacidadePassageirosAutomovel}
					</p>
					
					<p>
						<b>Ano:</b> ${agendamento.automovel.anoAutomovel}
					</p>
					
					<p>
						<b>Pertencente:</b> ${agendamento.automovel.pertencenteAutomovel}
					</p>
					
					<p>
						<b>Status:</b> ${agendamento.automovel.statusAutomovel}
					</p>
					
					<p>
						<b>Motivo:</b> ${agendamento.automovel.motivoAutomovel}
					</p>
					
					
					
					
					<hr>


					<h3>Motorista</h3>

					<p>
						<b>ID:</b> ${agendamento.motorista.idMotorista}
					</p>

					<p>
						<b>Nome:</b> ${agendamento.motorista.nomeMotorista}
					</p>

					<p>
						<b>Celular:</b> ${agendamento.motorista.celularMotorista}
					</p>

					<p>
						<b>Status:</b> ${agendamento.motorista.statusMotorista}
					</p>
					
					<p>
						<b>Motivo:</b> ${agendamento.motorista.motivoMotorista}
					</p>
					
					
					


					<br>
					
					<div class="form-group">
							<div class="aab controls col-md-4 "></div>
							<div class="controls col-md-8 text-right ">

								<a class="btn btn-default"
									href="${voltarManagerAllAgendamentoURL}"> VOLTAR</a> 
							</div>
						</div>
					
				</div>
			</div>
		</div>















	</div>








	<jsp:include page="../templates/footer.jsp" />

</body>
</html>