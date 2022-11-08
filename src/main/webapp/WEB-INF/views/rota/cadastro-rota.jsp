<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:errors path="destinoRota" />
<form:errors path="distanciaRota" />
<form:errors path="tempoEstimadoRota" />

<spring:url value="/rota/gerencia-all-rota"	var="voltarManagerAllRotaURL" />

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
				<div class="alert alert-success">${mensagemOk}</div>
			</div>
		</c:if>




		<div style="margin-top: 30px"
			class="mainbox col-md-10 col-md-offset-1 col-sm-9 col-sm-offset-2">

			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="panel-title">CADASTRO DE ROTAS</div>
				</div>


				<div class="panel-body">

					<spring:url value="/rota/salvarRota" var="saveRotaURL" />

					<form:form class="form-horizontal" modelAttribute="rota"
						method="POST" action="${saveRotaURL}">

						<form:hidden path="idRota" />



						<div class="form-group required">
							<label for="rota" class="control-label col-md-3">Rota*
							</label>

							<div class="controls col-md-6 ">

								<form:textarea path="destinoRota" class="form-control"
									rows="5"
									placeholder="Ex: Descrever a rota..."
									maxlength="345" />

							</div>
							<form:errors path="destinoRota" cssStyle="color:red" />
						</div>


						
						<div class="form-group required">
							<label for="distancia" class="control-label col-md-3">Distância(em Km)* </label>

							<div class="controls col-md-6 ">

								<form:input path="distanciaRota"
									class="input-md  textinput textInput form-control" 
									style="margin-bottom: 10px" type="text" maxlength="5"
									placeholder="Ex: 40" />


							</div>
							<form:errors path="distanciaRota" cssStyle="color:red" />
						</div>


						<div class="form-group required">
							<label for="tempo" class="control-label col-md-3">Tempo estimado* </label>

							<div class="controls col-md-6 ">


								<form:input path="tempoEstimadoRota"
									class="input-md  textinput textInput form-control"
									style="margin-bottom: 10px" type="time" />


							</div>
							<form:errors path="tempoEstimadoRota" cssStyle="color:red" />
						</div>



						<div class="form-group">
							<div class="aab controls col-md-4 "></div>
							<div class="controls col-md-8 text-right ">

								<a class="btn btn-default"
									href="${voltarManagerAllRotaURL}"> VOLTAR</a> <input
									type="submit" value="CADASTRAR" class="btn btn btn-primary" />
							</div>
						</div>
					</form:form>

					<div style="margin-top: 10px;">
						<label for="obrigatorio" align="right">*Campos
							obrigatórios</label>
					</div>

				</div>
			</div>
		</div>


	</div>








	<jsp:include page="../templates/footer.jsp" />

</body>
</html>