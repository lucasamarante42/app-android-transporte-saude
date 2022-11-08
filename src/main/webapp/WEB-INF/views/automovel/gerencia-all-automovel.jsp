<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<spring:url value="/automovel/cadastro-automovel" var="addAutomovelURL" />

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
				<h2>Automóveis</h2>
			</div>

			<div class="col-md-4 text-right h2">
				<a class="btn btn-primary" href="${addAutomovelURL}"><i
					class="fa fa-plus"></i> Novo Automóvel</a>
			</div>

		</div>

		<hr />


		<div class="table-responsive">
			<table class="table table-list-search" id="tabelaAutomovel">
				<thead>
					<tr>
						<th>ID</th>
						<th style="width: 15%">Automóvel</th>
						<th>Marca</th>
						<th style="width: 5%">Núm.Pessoas</th>
						<th>Ano</th>
						<th>Pertence</th>
						<th>Status</th>
						<th style="width: 15%">Motivo</th>
						<th>Ações</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${listAutomovel}" var="automovel">
						<tr>
							<td>${automovel.idAutomovel}</td>
							<td>${automovel.nomeAutomovel}</td>
							<td>${automovel.marcaAutomovel}</td>
							<td>${automovel.capacidadePassageirosAutomovel}</td>
							<td>${automovel.anoAutomovel}</td>
							<td>${automovel.pertencenteAutomovel}</td>
							<td>${automovel.statusAutomovel}</td>
							<td>${automovel.motivoAutomovel}</td>

							<td><spring:url value="/automovel/updateAutomovel/${automovel.idAutomovel}"
									var="updateAutomovelURL" />
									
								<button type="button" class="btn btn-warning"
									onclick="location.href='${updateAutomovelURL}'">Atualizar</button></td>



						</tr>
					</c:forEach>



				</tbody>
			</table>
		</div>



	</div>

<br>


<script type="text/javascript" class="init">

$(document).ready(function() {
	$('#tabelaAutomovel').DataTable({
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