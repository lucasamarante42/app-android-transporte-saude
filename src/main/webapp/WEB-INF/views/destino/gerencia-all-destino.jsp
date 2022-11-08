<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<spring:url value="/destino/cadastro-destino" var="addDestinoURL" />

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
				<h2>Destinos</h2>
			</div>

			<div class="col-md-4 text-right h2">
				<a class="btn btn-primary" href="${addDestinoURL}"><i
					class="fa fa-plus"></i> Novo Destino</a>
			</div>

		</div>

		<hr />


		<div class="table-responsive">
			<table class="table table-list-search" id="tabelaDestino">
				<thead>
					<tr>
						<th>ID</th>
						<th style="width: 25%">Local</th>
						<th style="width: 20%">Endereço</th>
						<th style="width: 15%">Cidade</th>
						<th style="width: 15%">Telefone</th>
						<th>Ações</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${listDestino}" var="destino">
						<tr>
							<td>${destino.idDestino}</td>
							<td>${destino.nomeLocalDestino}</td>
							<td>${destino.enderecoDestino}</td>
							<td>${destino.cidadeDestino}</td>
							<td>${destino.telefoneDestino}</td>
							
							<td><spring:url value="/destino/updateDestino/${destino.idDestino}"
									var="updateDestinoURL" />
									
								<button type="button" class="btn btn-warning"
									onclick="location.href='${updateDestinoURL}'">Atualizar</button></td>



						</tr>
					</c:forEach>



				</tbody>
			</table>
		</div>



	</div>

<br>


<script type="text/javascript" class="init">

$(document).ready(function() {
	$('#tabelaDestino').DataTable({
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