<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<spring:url value="/motorista/cadastro-motorista" var="addMotoristaURL" />

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
				<h2>Motoristas</h2>
			</div>

			<div class="col-md-4 text-right h2">
				<a class="btn btn-primary" href="${addMotoristaURL}"><i
					class="fa fa-plus"></i> Novo Motorista</a>
			</div>

		</div>

		<hr />


		<div class="table-responsive">
			<table class="table table-list-search" id="tabelaMotorista">
				<thead>
					<tr>
						<th>ID</th>
						<th style="width: 25%">Nome</th>
						<th style="width: 15%">Celular</th>
						<th style="width: 15%">Status</th>
						<th style="width: 25%">Motivo</th>
						<th>Ações</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${listMotorista}" var="motorista">
						<tr>
							<td>${motorista.idMotorista}</td>
							<td>${motorista.nomeMotorista}</td>
							<td>${motorista.celularMotorista}</td>
							<td>${motorista.statusMotorista}</td>
							<td>${motorista.motivoMotorista}</td>
							
							<td><spring:url value="/motorista/updateMotorista/${motorista.idMotorista}"
									var="updateMotoristaURL" />
									
								<button type="button" class="btn btn-warning"
									onclick="location.href='${updateMotoristaURL}'">Atualizar</button></td>



						</tr>
					</c:forEach>



				</tbody>
			</table>
		</div>



	</div>

<br>


<script type="text/javascript" class="init">

$(document).ready(function() {
	$('#tabelaMotorista').DataTable({
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