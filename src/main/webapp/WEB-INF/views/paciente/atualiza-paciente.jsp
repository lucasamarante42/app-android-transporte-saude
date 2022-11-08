<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:errors path="cpfPaciente" />
<form:errors path="nomePaciente" />
<form:errors path="dataNascimentoPaciente" />
<form:errors path="celularPaciente" />
<form:errors path="emailPaciente" />
<form:errors path="historicoPaciente" />
<form:errors path="necessidadeEspecialPaciente" />
<form:errors path="necessidadeAcompanhantePaciente" />
<form:errors path="hemodialisePaciente" />


<spring:url value="/paciente/gerencia-all-paciente"	var="voltarManagerAllPacienteURL" />

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
					<div class="panel-title">ATUALIZAÇÃO DE PACIENTES</div>
				</div>


				<div class="panel-body">

					<spring:url value="/paciente/atualizarPaciente" var="atualizaPacienteURL" />

					<form:form class="form-horizontal" modelAttribute="paciente"
						method="POST" action="${atualizaPacienteURL}">

						<form:hidden path="idPaciente" />



						<div class="form-group required">
							<label for="cpf" class="control-label col-md-3">Cpf(apenas
								números)* </label>

							<div class="controls col-md-6 ">

								<form:input path="cpfPaciente"
									class="input-md  textinput textInput form-control"
									placeholder="Ex: 999999999" maxlength="15"
									style="margin-bottom: 10px" type="text" />

							</div>
							<form:errors path="cpfPaciente" cssStyle="color:red" />
						</div>
						
												
						<div class="form-group required">
							<label for="nome" class="control-label col-md-3">Nome* </label>

							<div class="controls col-md-6 ">

								<form:input path="nomePaciente"
									class="input-md  textinput textInput form-control" 
									style="margin-bottom: 10px" type="text" maxlength="75"
									placeholder="Ex: Lucas Amarante" />

							</div>
							<form:errors path="nomePaciente" cssStyle="color:red" />
						</div>


						<div class="form-group required">
							<label for="nascimento" class="control-label col-md-3">Data Nascimento* </label>

							<div class="controls col-md-6 ">

								<form:input path="dataNascimentoPaciente"
									class="input-md  textinput textInput form-control"
									style="margin-bottom: 10px" type="date" />

							</div>
							<form:errors path="dataNascimentoPaciente" cssStyle="color:red" />
						</div>


						<div class="form-group required">
							<label for="celular" class="control-label col-md-3">Celular*
							</label>

							<div class="controls col-md-6 ">

								<form:input path="celularPaciente"
									class="input-md  textinput textInput form-control"
									placeholder="Ex: (12)98125-3254" id="campoCelular" maxlength="18"
									style="margin-bottom: 10px" type="text" />

							</div>
							<form:errors path="celularPaciente" cssStyle="color:red" />
						</div>


						<div class="form-group required">
							<label for="email" class="control-label col-md-3">Email </label>

							<div class="controls col-md-6 ">

								<form:input path="emailPaciente"
									class="input-md  textinput textInput form-control"
									placeholder="Ex: lucas.amarante@gmail.com" maxlength="45"
									style="margin-bottom: 10px" type="text" />

							</div>
							<form:errors path="emailPaciente" cssStyle="color:red" />
						</div>


						<div class="form-group required">
							<label for="historico" class="control-label col-md-3">Histórico
							</label>

							<div class="controls col-md-6 ">

								<form:textarea path="historicoPaciente" class="form-control"
									rows="5"
									placeholder="Ex: Descrever o histórico do paciente caso houver..."
									maxlength="320" />

							</div>
							<form:errors path="historicoPaciente" cssStyle="color:red" />
						</div>


						<div class="form-group required">
							<label for="necespecial" class="control-label col-md-3">Necessidade Especial*
							</label>

							<div class="controls col-md-6 ">

								<form:select path="necessidadeEspecialPaciente" class="form-control">
									<form:options items="${necessidadeEspecialPacienteList}" />
								</form:select>

							</div>
							<form:errors path="necessidadeEspecialPaciente" cssStyle="color:red" />
						</div>


						<div class="form-group required">
							<label for="necacomp" class="control-label col-md-3">Necessidade Acompanhante*
							</label>

							<div class="controls col-md-6 ">

								<form:select path="necessidadeAcompanhantePaciente" class="form-control">					
									<form:options items="${necessidadeAcompanhantePacienteList}" />
								</form:select>

							</div>
							<form:errors path="necessidadeAcompanhantePaciente" cssStyle="color:red" />
						</div>


						<div class="form-group required">
							<label for="hemodialise" class="control-label col-md-3">Hemodiálise*
							</label>

							<div class="controls col-md-6 ">
																
								<form:select path="hemodialisePaciente" class="form-control">					
									<form:options items="${hemodialisePacienteList}" />
								</form:select>

							</div>
							<form:errors path="hemodialisePaciente" cssStyle="color:red" />
						</div>


						<div class="form-group">
							<div class="aab controls col-md-4 "></div>
							<div class="controls col-md-8 text-right ">

								<a class="btn btn-default"
									href="${voltarManagerAllPacienteURL}"> VOLTAR</a> <input
									type="submit" value="ATUALIZAR" class="btn btn btn-primary" />
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