<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:errors path="nomeAutomovel" />
<form:errors path="marcaAutomovel" />
<form:errors path="capacidadePassageirosAutomovel" />
<form:errors path="anoAutomovel" />
<form:errors path="pertencenteAutomovel" />
<form:errors path="statusAutomovel" />
<form:errors path="motivoAutomovel" />

<spring:url value="/automovel/gerencia-all-automovel" var="voltarManagerAllAutomovelURL" />

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
					<div class="panel-title">CADASTRO DE AUTOMÓVEIS</div>
				</div>


				<div class="panel-body">

					<spring:url value="/automovel/salvarAutomovel"
						var="saveAutomovelURL" />

					<form:form class="form-horizontal" modelAttribute="automovel"
						method="POST" action="${saveAutomovelURL}">

						<form:hidden path="idAutomovel" />


						<div class="form-group required">
							<label for="nome" class="control-label col-md-3">Nome do
								Automóvel* </label>

							<div class="controls col-md-6 ">

								<form:input path="nomeAutomovel"
									class="input-md  textinput textInput form-control"
									placeholder="Ex: Van " maxlength="30"
									style="margin-bottom: 10px" type="text" />


							</div>
							<form:errors path="nomeAutomovel" cssStyle="color:red" />
						</div>



						<div class="form-group required">
							<label for="marca" class="control-label col-md-3">Marca*
							</label>

							<div class="controls col-md-6 ">


								<form:input path="marcaAutomovel"
									class="input-md  textinput textInput form-control"
									placeholder="Ex: Chevrolet" maxlength="30"
									style="margin-bottom: 10px" type="text" />


							</div>
							<form:errors path="marcaAutomovel" cssStyle="color:red" />
						</div>


						<div class="form-group required">
							<label for="capacidade" class="control-label col-md-3">Capacidade(Núm.
								Pessoas)* </label>

							<div class="controls col-md-6 ">


								<form:input path="capacidadePassageirosAutomovel"
									class="input-md  textinput textInput form-control" min="1"
									max="50" style="margin-bottom: 10px" type="number" 
									placeholder="Ex: 5"/>


							</div>
							<form:errors path="capacidadePassageirosAutomovel"
								cssStyle="color:red" />
						</div>


						<div class="form-group required">
							<label for="ano" class="control-label col-md-3">Ano* </label>

							<div class="controls col-md-6 ">


								<form:input path="anoAutomovel"
									class="input-md  textinput textInput form-control"
									style="margin-bottom: 10px" type="number" 
									placeholder="Ex: 2017"/>


							</div>
							<form:errors path="anoAutomovel" cssStyle="color:red" />
						</div>



						<div class="form-group required">
							<label for="pertencente" class="control-label col-md-3">Pertencente*
							</label>

							<div class="controls col-md-6 ">


								<form:input path="pertencenteAutomovel"
									class="input-md  textinput textInput form-control"
									placeholder="Ex: Prefeitura ou Terceirizado" maxlength="30"
									style="margin-bottom: 10px" type="text" />


							</div>
							<form:errors path="pertencenteAutomovel" cssStyle="color:red" />
						</div>


						<div class="form-group required">
							<label for="status" class="control-label col-md-3">Status*
							</label>

							<div class="controls col-md-6 ">

								<form:select path="statusAutomovel" class="form-control">
									<form:options items="${statusAutomovelList}" />
								</form:select>

							</div>
							<form:errors path="statusAutomovel" cssStyle="color:red" />
						</div>


						<div class="form-group required">
							<label for="motivo" class="control-label col-md-3">Motivo </label>

							<div class="controls col-md-6 ">

								<form:textarea path="motivoAutomovel" class="form-control" rows="5"
									placeholder="Ex: Descrever o motivo para o status indisponível..."
									maxlength="150"	/>
								

							</div>
							<form:errors path="motivoAutomovel" cssStyle="color:red" />
						</div>





						<div class="form-group">
							<div class="aab controls col-md-4 "></div>
							<div class="controls col-md-8 text-right ">
							
							<a class="btn btn-default" href="${voltarManagerAllAutomovelURL}"> VOLTAR</a>
								<input type="submit" value="CADASTRAR"
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