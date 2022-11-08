<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:errors path="nomeUsuario" />
<form:errors path="cpfUsuario" />
<form:errors path="cargoUsuario" />
<form:errors path="celularUsuario" />
<form:errors path="emailUsuario" />

<spring:url value="/usuario/gerencia-all-usuario" var="voltarManagerAllUsuarioURL" />


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
					<div class="panel-title">ATUALIZAÇÃO DE USUÁRIOS</div>
				</div>


				<div class="panel-body">

					<spring:url value="/usuario/atualizarUsuario" var="atualizaUsuarioURL" />

					<form:form class="form-horizontal" modelAttribute="usuario"
						method="POST" action="${atualizaUsuarioURL}">

						<form:hidden path="idUsuario" />


						<div class="form-group required">
							<label for="name" class="control-label col-md-3">Nome
								Completo* </label>

							<div class="controls col-md-6 ">

								<form:input path="nomeUsuario"
									class="input-md  textinput textInput form-control"
									placeholder="Ex: Lucas Amarante" maxlength="60"
									style="margin-bottom: 10px" type="text" />


							</div>
							<form:errors path="nomeUsuario" cssStyle="color:red" />
						</div>



						<div class="form-group required">
							<label for="cpf" class="control-label col-md-3">CPF(apenas
								números)* </label>

							<div class="controls col-md-6 ">


								<form:input path="cpfUsuario"
									class="input-md  textinput textInput form-control"
									placeholder="Ex: 999999999" maxlength="13"
									style="margin-bottom: 10px" type="text" />


							</div>
							<form:errors path="cpfUsuario" cssStyle="color:red" />
						</div>


						<div class="form-group required">
							<label for="cargo" class="control-label col-md-3">Cargo*
							</label>

							<div class="controls col-md-6 ">


								<form:input path="cargoUsuario"
									class="input-md  textinput textInput form-control"
									placeholder="Ex: Operador" maxlength="30"
									style="margin-bottom: 10px" type="text" />


							</div>
							<form:errors path="cargoUsuario" cssStyle="color:red" />
						</div>


						<div class="form-group required">
							<label for="celular" class="control-label col-md-3">Celular*
							</label>

							<div class="controls col-md-6 ">


								<form:input path="celularUsuario"
									class="input-md  textinput textInput form-control"
									placeholder="Ex: (12)98125-3254" id="campoCelular" maxlength="20"
									style="margin-bottom: 10px" type="text" />


							</div>
							<form:errors path="celularUsuario" cssStyle="color:red" />
						</div>



						<div class="form-group required">
							<label for="email" class="control-label col-md-3">Email </label>

							<div class="controls col-md-6 ">


								<form:input path="emailUsuario"
									class="input-md  textinput textInput form-control"
									placeholder="Ex: lucas.amarante@gmail.com" maxlength="50"
									style="margin-bottom: 10px" type="text" />


							</div>
							<form:errors path="emailUsuario" cssStyle="color:red" />
						</div>



						<div class="form-group">
							<div class="aab controls col-md-4 "></div>
							<div class="controls col-md-8 text-right ">
							
							<a class="btn btn-default" href="${voltarManagerAllUsuarioURL}"> VOLTAR</a>
							
							<input type="submit" value="ATUALIZAR"	class="btn btn btn-primary" />
												
																
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