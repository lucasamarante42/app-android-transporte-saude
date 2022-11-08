<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">


<title>GERENCIAMENTO LOGÍSTICA E SAÚDE</title>

<spring:url value="/resources/css/bootstrap.min.css"
	var="bootstrapMinURL" />
<spring:url value="/resources/css/bootstrap-toggle.min.css"
	var="bootstrapTOURL" />

<spring:url value="/resources/css/style.css" var="styleURL" />
<spring:url
	value="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.2/css/font-awesome.min.css"
	var="fontURL" />

<link href="${bootstrapMinURL}" rel="stylesheet">
<link href="${bootstrapTOURL}" rel="stylesheet">
<link href="${styleURL}" rel="stylesheet">
<link href="${fontURL}" rel="stylesheet">


<spring:url value="/resources/js/bootstrap.min.js"
	var="bootstrapMinJSURL"></spring:url>
<spring:url value="/resources/js/jquery-3.2.1.min.js" var="jqueryURL"></spring:url>

<script src="${jqueryURL}"></script>
<script src="${bootstrapMinJSURL}"></script>

<spring:url
	value="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css"
	var="dtcssURL" />
<link href="${dtcssURL}" rel="stylesheet">

<spring:url value="https://code.jquery.com/jquery-1.12.4.js"
	var="jqueryURL" />

<script type="text/javascript" src="${jqueryURL}"></script>

<spring:url
	value="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"
	var="dataTableBScssURL" />

<script src="${dataTableBScssURL}"></script>


<spring:url value="/resources/js/jquery.mask.min.js" var="maskMinURL" />

<script src="${maskMinURL}"></script>

<spring:url value="/resources/js/jquery.maskedinput.js"
	var="maskInputURL" />

<script src="${maskInputURL}"></script>


</head>

<body background="resources/img/back_sglps.jpg">

	<div class="container">




		<div style="margin-top: 100px" class="mainbox col-md-6 col-md-offset-3">



			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="panel-title">LOGIN</div>
				</div>


				<div class="panel-body">

					<form class="form-horizontal" method="POST"
						action="${pageContext.request.contextPath}/j_spring_security_check">

						<div class="form-group required">
							<label for="user" class="control-label col-md-3">Usuário
							</label>

							<div class="controls col-md-7 ">

								<input name="username"
									class="input-md  textinput textInput form-control"
									maxlength="30" style="margin-bottom: 10px" type="text" />

							</div>
						</div>

						<div class="form-group required">
							<label for="pass" class="control-label col-md-3">Senha </label>

							<div class="controls col-md-7 ">

								<input name="password"
									class="input-md  textinput textInput form-control"
									maxlength="30" style="margin-bottom: 10px" type="password" />

							</div>

						</div>



						<div class="form-group">


							<div class="aab controls col-md-5 "></div>
							<div class="controls col-md-4">
								<input type="submit" value="ENTRAR" class="btn btn btn-primary" />
							</div>

						</div>
					</form>

					<!-- /login?error=true -->
					<c:if test="${param.error == 'true'}">
						<div style="color: red; margin: 20px;">Falha no login:
							Usuário/Senha incorretos!</div>
					</c:if>
				</div>
			</div>
		</div>
	</div>
</body>
</html>