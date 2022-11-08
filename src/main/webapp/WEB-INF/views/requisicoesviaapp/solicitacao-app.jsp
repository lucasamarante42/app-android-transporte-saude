<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<spring:url value="/home/" var="homeURL" />


<jsp:include page="../templates/header.jsp" />




	<jsp:include page="../templates/nav.jsp" />




	<div class="container">
	
		<div class="row">

			<div class="col-md-8">
				<h2>Solicitações de Transporte</h2>
			</div>

					
			<div class="col-md-4 text-right h2">
				<a class="btn btn-default" href="${homeURL}"> VOLTAR</a>
			</div>

		</div> 
		<hr>
		



		<div class="table-responsive">
			<table id="tbSolicitacaoApp" class="table table-list-search">
				<thead>
					<tr>
						<th>ID</th>
						<th>Cpf Paciente</th>
						<th>Data</th>
						<th>Hora</th>
						<th>Acomp.?</th>
						<th>Status</th>
						<th>Ações</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${consultaSolicitacoes}" var="solicitacaoApp">
						<tr>
							<td>${solicitacaoApp.idSolicitacaoPacApp}</td>
							<td>${solicitacaoApp.cpfPacienteSolicitacaoPacApp}</td>
							<td>${solicitacaoApp.dataSolicitacaoPacApp}</td>
							<td>${solicitacaoApp.horaSolicitacaoPacApp}</td>
							<td>${solicitacaoApp.necessidadeAcompanhanteSolicitacaoPacApp}</td>
							<td>${solicitacaoApp.statusSolicitacaoPacApp}</td>


							<td>
							
							<spring:url	value="/agendamento/viaAppCadastroAgendamento/${solicitacaoApp.idSolicitacaoPacApp}"
									var="agendaSolicitacaoURL" />
								<button type="button" class="btn btn-success"
									onclick="location.href='${agendaSolicitacaoURL}'">AGENDAR
								</button>
							</td>


						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
		
		
		
		
		
		
		
		
		

	<br>
	

</div>




	<script type="text/javascript"  class="init">
	

$(document).ready(function() {
	$('#tbSolicitacaoApp').DataTable({
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






<jsp:include page="../templates/footer.jsp" />


