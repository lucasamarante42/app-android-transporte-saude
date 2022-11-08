<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<spring:url value="/home/" var="homeURL" />


<jsp:include page="../templates/header.jsp" />



<jsp:include page="../templates/nav.jsp" />



<div class="container">

	<div class="row">

		<div class="col-md-8">
			<h2>Avaliação</h2>
		</div>


		<div class="col-md-4 text-right h2">
			<a class="btn btn-default" href="${homeURL}"> VOLTAR</a>
		</div>

	</div>

	<hr />



	<div class="table-responsive">
		<table id="tbAvaliacaoApp" class="table table-list-search">
			<thead>
				<tr>
					<th>ID</th>
					<th>Cpf Paciente</th>
					<th>Data</th>
					<th>Avaliação</th>
					<th>Mensagem</th>
					<th>Status</th>
					<th>Ações</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${consultaAvaliacao}" var="avaliacaoApp">
					<tr>
						<td>${avaliacaoApp.idAvaliacaoPac}</td>
						<td>${avaliacaoApp.cpfPacienteAvaliacaoPac}</td>
						<td>${avaliacaoApp.dataAvaliacaoPac}</td>
						<td>${avaliacaoApp.avaliacaoAvaliacaoPac}</td>
						<td>${avaliacaoApp.mensagemAvaliacaoPac}</td>
						<td>${avaliacaoApp.statusAvaliacaoPac}</td>


						<td>
						<spring:url
								value="/requisicoesviaapp/atualizaVisualizacaoAvaliacao/${avaliacaoApp.idAvaliacaoPac}"
								var="atualizaVisualizacaoAvaliacaoURL" />
							<button type="button" class="btn btn-success"
								onclick="location.href='${atualizaVisualizacaoAvaliacaoURL}'">MARCAR JÁ VISTO
								</button>
						</td>



					</tr>
				</c:forEach>



			</tbody>
		</table>
	</div>

	<br>
</div>






<script type="text/javascript" class="init">
	

$(document).ready(function() {
	$('#tbAvaliacaoApp').DataTable({
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


