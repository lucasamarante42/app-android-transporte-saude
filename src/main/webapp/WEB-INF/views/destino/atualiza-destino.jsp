<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:errors path="nomeLocalDestino" />
<form:errors path="enderecoDestino" />
<form:errors path="cidadeDestino" />
<form:errors path="telefoneDestino" />

<spring:url value="/destino/gerencia-all-destino" var="voltarManagerAllDestinoURL" />

<!DOCTYPE html>
<html lang="pt-br">
<jsp:include page="../templates/header.jsp" />

<body>
	<jsp:include page="../templates/nav.jsp" />


<script type="text/javascript">
  jQuery(function($){
	
	$("#campoTelefone").mask("(99)9999-9999");

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
					<div class="panel-title">ATUALIZAÇÃO DE DESTINOS</div>
				</div>


				<div class="panel-body">

					<spring:url value="/destino/atualizarDestino" var="atualizaDestinoURL" />

					<form:form class="form-horizontal" modelAttribute="destino"
						method="POST" action="${atualizaDestinoURL}">

						<form:hidden path="idDestino" />


						<div class="form-group required">
							<label for="nome" class="control-label col-md-3">Local do
								Destino* </label>

							<div class="controls col-md-6 ">

								<form:input path="nomeLocalDestino"
									class="input-md  textinput textInput form-control"
									placeholder="Ex: Hospital Centro Sul " maxlength="100"
									style="margin-bottom: 10px" type="text" />


							</div>
							<form:errors path="nomeLocalDestino" cssStyle="color:red" />
						</div>



						<div class="form-group required">
							<label for="endereco" class="control-label col-md-3">Endereço*
							</label>

							<div class="controls col-md-6 ">


								<form:input path="enderecoDestino"
									class="input-md  textinput textInput form-control"
									placeholder="Ex: Rua dos Ipês, 80 - Centro" maxlength="100"
									style="margin-bottom: 10px" type="text" />


							</div>
							<form:errors path="enderecoDestino" cssStyle="color:red" />
						</div>


						<div class="form-group required">
							<label for="cidade" class="control-label col-md-3">Cidade* </label>

							<div class="controls col-md-6 ">


								<form:input path="cidadeDestino"
									class="input-md  textinput textInput form-control" 
									maxlength="50"	placeholder="Ex: Cruzeiro" 
									style="margin-bottom: 10px" type="text" />


							</div>
							<form:errors path="cidadeDestino"
								cssStyle="color:red" />
						</div>
		


						<div class="form-group required">
							<label for="telefone" class="control-label col-md-3">Telefone*
							</label>

							<div class="controls col-md-6 ">


								<form:input path="telefoneDestino"
									class="input-md  textinput textInput form-control"
									placeholder="Ex: (12)3144-3254" id="campoTelefone" maxlength="20"
									style="margin-bottom: 10px" type="text" />


							</div>
							<form:errors path="telefoneDestino" cssStyle="color:red" />
						</div>




						<div class="form-group">
							<div class="aab controls col-md-4 "></div>
							<div class="controls col-md-8 text-right ">
							
							<a class="btn btn-default" href="${voltarManagerAllDestinoURL}"> VOLTAR</a>
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