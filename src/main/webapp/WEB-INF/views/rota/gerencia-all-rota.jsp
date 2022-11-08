<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<spring:url value="/rota/cadastro-rota" var="addRotaURL" />

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
				<h2>Rotas</h2>
			</div>

			<div class="col-md-4 text-right h2">
				<a class="btn btn-primary" href="${addRotaURL}"><i
					class="fa fa-plus"></i> Nova Rota</a>
			</div>

		</div>

		<hr />


		<div class="table-responsive">
			<table class="table table-list-search" id="tabelaRota">
				<thead>
					<tr>
						<th style="width: 15%">ID</th>
						<th style="width: 40%">Rota</th>
						<th style="width: 15%">Distância(em Km)</th>
						<th style="width: 15%">Tempo estimado</th>
						<th>Ações</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${listRota}" var="rota">
						<tr>
							<td>${rota.idRota}</td>
							<td>${rota.destinoRota}</td>
							<td>${rota.distanciaRota}</td>
							<td>${rota.tempoEstimadoRota}</td>
														
							<td><spring:url value="/rota/updateRota/${rota.idRota}"
									var="updateRotaURL" />
									
								<button type="button" class="btn btn-warning"
									onclick="location.href='${updateRotaURL}'">Atualizar</button></td>



						</tr>
					</c:forEach>



				</tbody>
			</table>
		</div>



	</div>

<br>


<script type="text/javascript" class="init">

$(document).ready(function() {
	$('#tabelaRota').DataTable({
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