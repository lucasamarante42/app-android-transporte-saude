<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:errors path="nomeMotorista" />
<form:errors path="celularMotorista" />
<form:errors path="statusMotorista" />
<form:errors path="motivoMotorista" />

<spring:url value="/motorista/gerencia-all-motorista" var="voltarManagerAllMotoristaURL" />

<!DOCTYPE html>
<html lang="pt-br">
<jsp:include page="../templates/header.jsp" />

<body>
	<jsp:include page="../templates/nav.jsp" />


<script type="text/javascript">
  jQuery(function($){
	
	$("#campoCelular").mask("(99)99999-9999");

  });  
  
</script>


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
					<div class="panel-title">ATUALIZAÇÃO DE MOTORISTAS</div>
				</div>


				<div class="panel-body">

					<spring:url value="/motorista/atualizarMotorista" var="atualizaMotoristaURL" />

					<form:form class="form-horizontal" modelAttribute="motorista"
						method="POST" action="${atualizaMotoristaURL}">

						<form:hidden path="idMotorista" />


						<div class="form-group required">
							<label for="nome" class="control-label col-md-3">Nome* </label>

							<div class="controls col-md-6 ">

								<form:input path="nomeMotorista"
									class="input-md  textinput textInput form-control"
									placeholder="Ex: Lucas Amarante " maxlength="60"
									style="margin-bottom: 10px" type="text" />


							</div>
							<form:errors path="nomeMotorista" cssStyle="color:red" />
						</div>



						<div class="form-group required">
							<label for="celular" class="control-label col-md-3">Celular*
							</label>

							<div class="controls col-md-6 ">


								<form:input path="celularMotorista"
									class="input-md  textinput textInput form-control"
									placeholder="Ex: (12)98136-6712" id="campoCelular" maxlength="15"
									style="margin-bottom: 10px" type="text" />


							</div>
							<form:errors path="celularMotorista" cssStyle="color:red" />
						</div>


						<div class="form-group required">
							<label for="status" class="control-label col-md-3">Status*
							</label>

							<div class="controls col-md-6 ">

								<form:select path="statusMotorista" class="form-control">
									<form:options items="${statusMotoristaList}" />
								</form:select>

							</div>
							<form:errors path="statusMotorista" cssStyle="color:red" />
						</div>


						<div class="form-group required">
							<label for="motivo" class="control-label col-md-3">Motivo </label>

							<div class="controls col-md-6 ">

								<form:textarea path="motivoMotorista" class="form-control" rows="5"
									placeholder="Ex: Descrever o motivo para o status indisponível..."
									maxlength="95"	/>
								

							</div>
							<form:errors path="motivoMotorista" cssStyle="color:red" />
						</div>
						



						<div class="form-group">
							<div class="aab controls col-md-4 "></div>
							<div class="controls col-md-8 text-right ">
							
							<a class="btn btn-default" href="${voltarManagerAllMotoristaURL}"> VOLTAR</a>
								<input type="submit" value="ATUALIZAR"
									class="btn btn btn-primary" />
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