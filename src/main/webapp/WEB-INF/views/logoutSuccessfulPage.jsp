<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<spring:url value="/login" var="loginURL" />
<%@page session="false"%>


  
<html>
<body>
	<h2>messages, whatever</h2>
	<a href="<c:url value="j_spring_security_logout" />" > Logout</a>

 
    <h1>Logout Successful!</h1>
    
    <div class="col-md-4 text-right h2">
				<a class="btn btn-primary" href="${loginURL}"><i
					class="fa fa-plus"></i> LOGIN</a>
			</div>
</body>
</html>