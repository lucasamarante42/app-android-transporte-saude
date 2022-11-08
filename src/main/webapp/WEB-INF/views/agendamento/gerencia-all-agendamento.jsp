<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<spring:url value="/agendamento/cadastro-agendamento" var="addAgendamentoURL" />

<!DOCTYPE html>
<html lang="pt-br">
<jsp:include page="../templates/header.jsp" />

<body>
	<jsp:include page="../templates/nav.jsp" />

	<div class="container">


		<c:if test="${not empty mensagemErro}">
			<div>
				<div class="alert alert-danger">${mensagemErro}</div>
			</div>
		</c:if>

		<c:if test="${not empty mensagemOk}">
			<div>
				<div class="alert alert-success">${mensagemOk} ${idViewAtualiza}</div>
			</div>
		</c:if>		
		
		<div class="row">

			<div class="col-md-8">
				<h2>Agendamentos</h2>
			</div>

			<div class="col-md-4 text-right h2">
				<a class="btn btn-primary" href="${addAgendamentoURL}"><i
					class="fa fa-plus"></i> Novo Agendamento</a>
			</div>

		</div>

		<hr />


		<div class="table-responsive">
			<table class="table table-list-search" id="tabelaAgendamento">
				<thead>
					<tr>
						<th >ID</th>
						<th >Cpf Paciente</th>
						<th >Destino</th>
						<th >Motorista</th>
						<th >Automóvel</th>
						<th >Rota</th>
						<th >Data</th>
						<th >Hora</th>
						<th >Status</th>
						<th>Ações</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${listAgendamento}" var="agendamento">
						<tr>
							<td>${agendamento.idAgendamento}</td>
							<td>${agendamento.cpfPacienteAgendamento}</td>
							<td>${agendamento.destino.nomeLocalDestino}</td>
							<td>${agendamento.motorista.nomeMotorista}</td>
							<td>${agendamento.automovel.nomeAutomovel}</td>
							<td>${agendamento.rota.destinoRota}</td>
							<td>${agendamento.dataAgendamento}</td>
							<td>${agendamento.horaAgendamento}</td>
							<td>${agendamento.statusAgendamento}</td>
														
							<td>
							<spring:url 
								value="/agendamento/updateAgendamento/${agendamento.idAgendamento}"
									var="updateAgendamentoURL" />
									
								<button type="button" class="btn btn-warning"
									onclick="location.href='${updateAgendamentoURL}'">Atualizar</button>
									
							
							
							<spring:url 
								value="/agendamento/consultaAgendamento/${agendamento.idAgendamento}"
									var="consultaAgendamentoURL" />
									
								<button type="button" class="btn btn-success"
									onclick="location.href='${consultaAgendamentoURL}'">Detalhes</button>
									
									
							</td>



						</tr>
					</c:forEach>



				</tbody>
			</table>
		</div>



	</div>

<br>


<script type="text/javascript" class="init">

$(document).ready(function() {
	$('#tabelaAgendamento').DataTable({
        "bJQueryUI": true,
        "oLanguage": {
            "sProcessing":   "Processando...",
            "sLengthMenu":   "Mostrar _MENU_ registros",
            "sZeroRecords":  "Não foram encontrados resultados",
            "sInfo":         "Mostrando de _START_ até _END_ de _TOTAL_ registros",
            "sInfoEmpty":    "Mostrando de 0 até 0 de 0 registros",
            "sInfoFiltered": "",
            "sInfoPostFix":  "",
            "sSearch":       "Buscar:",
            "sUrl":          "",
            "oPaginate": {
                "sFirst":    "Primeiro",
                "sPrevious": "Anterior ",
                "sNext":     " Seguinte",
                "sLast":     "Último"
            }
        }
    });
} );

</script>





</body>


</html>