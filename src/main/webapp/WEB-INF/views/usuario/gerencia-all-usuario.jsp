<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<spring:url value="/usuario/cadastro-usuario" var="addUsuarioURL" />

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
				<h2>Usuários</h2>
			</div>
		
			<div class="col-md-4 text-right h2">
			<a class="btn btn-primary" href="${addUsuarioURL}"><i class="fa fa-plus"></i> Novo Usuário</a>
			</div>
			
		</div>

		<hr />
		
		
			<div class="table-responsive">
				<table class="table table-list-search" id="tabelaUsuario">
					<thead>
						<tr>
							<th>ID</th>
							<th>Nome</th>
							<th>Cpf</th>
							<th>Cargo</th>
							<th>Celular</th>
							<th>Email</th>
							<th>Ações</th>
						</tr>
					</thead>
					<tbody>
						
							<c:forEach items="${listUsuario}" var="usuario">
								<tr>
									<td>${usuario.idUsuario}</td>
									<td>${usuario.nomeUsuario}</td>
									<td>${usuario.cpfUsuario}</td>
									<td>${usuario.cargoUsuario}</td>
									<td>${usuario.celularUsuario}</td>
									<td>${usuario.emailUsuario}</td>
									
									
									<td>									
									   <spring:url value="/usuario/updateUsuario/${usuario.idUsuario}"
											var="updateURL" /> 
									   <button type="button" class="btn btn-warning" 
									      onclick="location.href='${updateURL}'"> Atualizar </button>
									</td>

									

								</tr>
							</c:forEach>

						

					</tbody>
				</table>
			</div>
		


	</div>



<br>




	

</body>

	<script type="text/javascript"  class="init">
	

$(document).ready(function() {
	$('#tabelaUsuario').DataTable({
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
</html>