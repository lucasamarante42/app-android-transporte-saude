<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<spring:url value="/home" var="homeURL" />

<!DOCTYPE html>
<html lang="pt-br">
<jsp:include page="../templates/header.jsp" />

<title>${title}</title>
</head>
<body>



	<div class="container">
		<div class="jumbotron">
			<h1 align="center">${errorTitle}</h1>
			<h3 align="center">${errorDescription}</h3>
			<hr />



			<p align="center">${contactAdm}</p>
			
			<div class="aab controls col-md-4 "></div>
			<div class="controls col-md-8 text-right ">

				<a class="btn btn-default" href="${homeURL}">VOLTAR</a>

			</div>
		</div>

		
			
		



	</div>







</body>
</html>