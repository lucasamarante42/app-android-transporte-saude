<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:errors path="cpfPacienteAgendamento" />
<form:errors path="idDestinoAgendamento" />
<form:errors path="idMotoristaAgendamento" />
<form:errors path="idAutomovelAgendamento" />
<form:errors path="idRotaAgendamento" />
<form:errors path="dataAgendamento" />
<form:errors path="horaAgendamento" />
<form:errors path="necessidadeAcompanhanteAgendamento" />
<form:errors path="statusAgendamento" />


<spring:url value="/agendamento/gerencia-all-agendamento"
	var="voltarManagerAllAgendamentoURL" />

<!DOCTYPE html>
<html lang="pt-br">
<jsp:include page="../templates/header.jsp" />

<body>
	<jsp:include page="../templates/nav.jsp" />

	<script type="text/javascript">
		jQuery(function($) {

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
					<div class="panel-title">CADASTRO DE AGENDAMENTOS</div>
				</div>


				<div class="panel-body">

					<spring:url value="/agendamento/salvarAgendamento"
						var="saveAgendamentoURL" />

					<form:form class="form-horizontal" modelAttribute="agendamento"
						method="POST" action="${saveAgendamentoURL}">

						<form:hidden path="idAgendamento" />



						<div class="form-group required">
							<label for="cpf" class="control-label col-md-3">Cpf(apenas
								números)* </label>

							<div class="controls col-md-6 ">

								<form:input path="cpfPacienteAgendamento"
									class="input-md  textinput textInput form-control"
									placeholder="Ex: 999999999" maxlength="15"
									style="margin-bottom: 10px" type="text" />

							</div>
							<form:errors path="cpfPacienteAgendamento"
								cssStyle="color:red" />
						</div>


						<div class="form-group required">
							<label for="destino" class="control-label col-md-3">Destino*
							</label>

							<div class="controls col-md-6 ">

								<form:select path="idDestinoAgendamento" class="form-control">
									<option value="-1">Selecione o Destino</option>
									<c:forEach items="${destinos}" var="destino">

										<c:choose>
											<c:when
												test="${destino.idDestino eq idDestinoAgendamentoGet}">
												<option value="${destino.idDestino}" selected="true">${destino.nomeLocalDestino}</option>
											</c:when>
											<c:otherwise>
												<option value="${destino.idDestino}">${destino.nomeLocalDestino}</option>
											</c:otherwise>
										</c:choose>

									</c:forEach>
								</form:select>

							</div>
							<form:errors path="idDestinoAgendamento" cssStyle="color:red" />
						</div>


						<div class="form-group required">
							<label for="motorista" class="control-label col-md-3">Motorista*
							</label>

							<div class="controls col-md-6 ">

								<form:select path="idMotoristaAgendamento" class="form-control">

									<option value="-1">Selecione o Motorista</option>
									<c:forEach items="${motoristas}" var="motorista">

										<c:choose>
											<c:when
												test="${motorista.idMotorista eq idMotoristaAgendamentoGet}">
												<option value="${motorista.idMotorista}" selected="true">${motorista.nomeMotorista}</option>
											</c:when>
											<c:otherwise>
												<option value="${motorista.idMotorista}">${motorista.nomeMotorista}</option>
											</c:otherwise>
										</c:choose>


									</c:forEach>
								</form:select>

							</div>
							<form:errors path="idMotoristaAgendamento" cssStyle="color:red" />
						</div>


						<div class="form-group required">
							<label for="automovel" class="control-label col-md-3">Automóvel*
							</label>

							<div class="controls col-md-6 ">

								<form:select path="idAutomovelAgendamento" class="form-control">
									<option value="-1">Selecione o Automóvel</option>
									<c:forEach items="${automoveis}" var="automovel">


										<c:choose>
											<c:when
												test="${automovel.idAutomovel eq idAutomovelAgendamentoGet}">
												<option value="${automovel.idAutomovel}" selected="true">${automovel.nomeAutomovel}</option>
											</c:when>
											<c:otherwise>
												<option value="${automovel.idAutomovel}">${automovel.nomeAutomovel}</option>
											</c:otherwise>
										</c:choose>


									</c:forEach>
								</form:select>

							</div>
							<form:errors path="idAutomovelAgendamento" cssStyle="color:red" />
						</div>


						<div class="form-group required">
							<label for="rota" class="control-label col-md-3">Rota* </label>

							<div class="controls col-md-6 ">

								<form:select path="idRotaAgendamento" class="form-control">
									<option value="-1">Selecione a Rota</option>
									<c:forEach items="${rotas}" var="rota">


										<c:choose>
											<c:when test="${rota.idRota eq idRotaAgendamentoGet}">
												<option value="${rota.idRota}" selected="true">${rota.destinoRota}</option>
											</c:when>
											<c:otherwise>
												<option value="${rota.idRota}">${rota.destinoRota}</option>
											</c:otherwise>
										</c:choose>


									</c:forEach>
								</form:select>

							</div>
							<form:errors path="idRotaAgendamento" cssStyle="color:red" />
						</div>


						<div class="form-group required">
							<label for="data" class="control-label col-md-3">Data* </label>

							<div class="controls col-md-6 ">

								<form:input path="dataAgendamento"
									class="input-md  textinput textInput form-control"
									maxlength="15" style="margin-bottom: 10px" type="date" 
									max="2100-01-01"/>

							</div>
							<form:errors path="dataAgendamento" cssStyle="color:red" />
						</div>


						<div class="form-group required">
							<label for="hora" class="control-label col-md-3">Hora* </label>

							<div class="controls col-md-6 ">

								<form:input path="horaAgendamento"
									class="input-md  textinput textInput form-control"
									maxlength="15" style="margin-bottom: 10px" type="time" />

							</div>
							<form:errors path="horaAgendamento" cssStyle="color:red" />
						</div>


						<div class="form-group required">
							<label for="necacomp" class="control-label col-md-3">Necessidade
								Acompanhante* </label>

							<div class="controls col-md-6 ">

								<form:select path="necessidadeAcompanhanteAgendamento"
									class="form-control">
									<form:options items="${necessidadeAcompanhanteAgendamentoList}" />
								</form:select>

							</div>
							<form:errors path="necessidadeAcompanhanteAgendamento"
								cssStyle="color:red" />
						</div>


						<div class="form-group required">
							<label for="status" class="control-label col-md-3">Status*
							</label>

							<div class="controls col-md-6 ">

								<form:select path="statusAgendamento" class="form-control">
									<form:options items="${statusAgendamentoList}" />
								</form:select>

							</div>
							<form:errors path="statusAgendamento" cssStyle="color:red" />
						</div>




						<div class="form-group">
							<div class="aab controls col-md-4 "></div>
							<div class="controls col-md-8 text-right ">

								<a class="btn btn-default"
									href="${voltarManagerAllAgendamentoURL}"> VOLTAR</a> <input
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