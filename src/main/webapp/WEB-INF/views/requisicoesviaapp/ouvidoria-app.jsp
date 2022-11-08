<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<spring:url value="/home/" var="homeURL" />


<jsp:include page="../templates/header.jsp" />



<jsp:include page="../templates/nav.jsp" />



<div class="container">

	<div class="row">

		<div class="col-md-8">
			<h2>Ouvidoria</h2>
		</div>


		<div class="col-md-4 text-right h2">
			<a class="btn btn-default" href="${homeURL}"> VOLTAR</a>
		</div>

	</div>

	<hr />



	<div class="table-responsive">
		<table id="tbOuvidoriaApp" class="table table-list-search">
			<thead>
				<tr>
					<th>ID</th>
					<th>Cpf Paciente</th>
					<th>Data</th>
					<th>Tipo</th>
					<th>Descri��o</th>
					<th>Status</th>
					<th>A��es</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${consultaOuvidoria}" var="ouvidoriaApp">
					<tr>
						<td>${ouvidoriaApp.idOuvidoriaPac}</td>
						<td>${ouvidoriaApp.cpfPacienteOuvidoriaPac}</td>
						<td>${ouvidoriaApp.dataOuvidoriaPac}</td>
						<td>${ouvidoriaApp.tipoOuvidoriaPac}</td>
						<td>${ouvidoriaApp.descricaoOuvidoriaPac}</td>
						<td>${ouvidoriaApp.statusOuvidoriaPac}</td>


						<td><spring:url
								value="/requisicoesviaapp/atualizaVisualizacaoOuvidoria/${ouvidoriaApp.idOuvidoriaPac}"
								var="atualizaVisualizacaoOuvidoriaURL" />
							<button type="button" class="btn btn-success"
								onclick="location.href='${atualizaVisualizacaoOuvidoriaURL}'">MARCAR J� VISTO</button></td>



					</tr>
				</c:forEach>



			</tbody>
		</table>
	</div>

	<br>
</div>






<script type="text/javascript" class="init">
	

$(document).ready(function() {
	$('#tbOuvidoriaApp').DataTable({
        "bJQueryUI": true,
        "oLanguage": {
            "sProcessing":   "Processando...",
            "sLengthMenu":   "Mostrar _MENU_ registros",
            "sZeroRecords":  "N�o foram encontrados resultados",
            "sInfo":         "Mostrando de _START_ at� _END_ de _TOTAL_ registros",
            "sInfoEmpty":    "Mostrando de 0 at� 0 de 0 registros",
            "sInfoFiltered": "",
            "sInfoPostFix":  "",
            "sSearch":       "Buscar:",
            "sUrl":          "",
            "oPaginate": {
                "sFirst":    "Primeiro",
                "sPrevious": "Anterior ",
                "sNext":     " Seguinte",
                "sLast":     "�ltimo"
            }
        }
    });
} );


	</script>




<jsp:include page="../templates/footer.jsp" />


