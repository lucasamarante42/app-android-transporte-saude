<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<spring:url value="/paciente/cadastro-paciente" var="addPacienteURL" />

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
				<h2>Pacientes</h2>
			</div>

			<div class="col-md-4 text-right h2">
				<a class="btn btn-primary" href="${addPacienteURL}"><i
					class="fa fa-plus"></i> Novo Paciente</a>
			</div>

		</div>

		<hr />


		<div class="table-responsive">
			<table class="table table-list-search" id="tabelaPaciente">
				<thead>
					<tr>
						<th >ID</th>
						<th >Cpf</th>
						<th >Nome</th>
						<th>Nascimento</th>
						<th>Celular</th>
						<th >Email</th>
						<th >Histórico</th>
						<th >Nec.Espec</th>
						<th >Nec.Acomp</th>
						<th >Hemod.?</th>
						<th>Ações</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${listPaciente}" var="paciente">
						<tr>
							<td>${paciente.idPaciente}</td>
							<td>${paciente.cpfPaciente}</td>
							<td>${paciente.nomePaciente}</td>
							<td>${paciente.dataNascimentoPaciente}</td>
							<td>${paciente.celularPaciente}</td>
							<td>${paciente.emailPaciente}</td>
							<td>${paciente.historicoPaciente}</td>
							<td>${paciente.necessidadeEspecialPaciente}</td>
							<td>${paciente.necessidadeAcompanhantePaciente}</td>
							<td>${paciente.hemodialisePaciente}</td>							
														
							<td><spring:url value="/paciente/updatePaciente/${paciente.idPaciente}"
									var="updatePacienteURL" />
									
								<button type="button" class="btn btn-warning"
									onclick="location.href='${updatePacienteURL}'">Atualizar</button></td>



						</tr>
					</c:forEach>



				</tbody>
			</table>
		</div>



	</div>

<br>


<script type="text/javascript" class="init">

$(document).ready(function() {
	$('#tabelaPaciente').DataTable({
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