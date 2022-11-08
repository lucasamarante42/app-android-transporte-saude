<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>



<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">


<title>GERENCIAMENTO LOGÍSTICA E SAÚDE</title>
                                  
<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapMinURL"/>
<spring:url value="/resources/css/bootstrap-toggle.min.css" var="bootstrapTOURL"/>

<spring:url value="/resources/css/style.css" var="styleURL"/>
<spring:url value="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.2/css/font-awesome.min.css" var="fontURL"/>

<link href="${bootstrapMinURL}" rel="stylesheet">
<link href="${bootstrapTOURL}" rel="stylesheet">
<link href="${styleURL}" rel="stylesheet">
<link href="${fontURL}" rel="stylesheet">


<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapMinJSURL" ></spring:url>
<spring:url value="/resources/js/jquery-3.2.1.min.js" var="jqueryURL"></spring:url>

<script src="${jqueryURL}"></script>
<script src="${bootstrapMinJSURL}" ></script>

<spring:url value="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css" var="dtcssURL"/>
<link href="${dtcssURL}" rel="stylesheet">

<spring:url value="https://code.jquery.com/jquery-1.12.4.js" var="jqueryURL"/>

<script type="text/javascript" src="${jqueryURL}"></script>

<spring:url value="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js" var="dataTableBScssURL"/>

<script src="${dataTableBScssURL}" ></script> 


<spring:url value="/resources/js/jquery.mask.min.js" var="maskMinURL"/>

<script src="${maskMinURL}" ></script> 

<spring:url value="/resources/js/jquery.maskedinput.js" var="maskInputURL"/>

<script src="${maskInputURL}" ></script> 


</head>

