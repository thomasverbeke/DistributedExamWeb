<%@ include file="/WEB-INF/include.jsp"%>

<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Spring MVC Exam</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	  	<c:url value="/static/css/main.css" var="resourceUrl"/>
		<link media="screen" rel="stylesheet" href="${resourceUrl}" type="text/css" />
</head>
<body>
<jsp:include page="header.jsp" />
<form:form method="post" action="validationform.htm"  commandName="validationForm">
	  <table>
	    <tr>      
	        <td>
	          <fmt:message key="name"/>: <form:input path="name"/>
	        </td>
	        <td>
	          <form:errors path="name" cssClass="error"/>
	        </td>
	    </tr>
	 
	    <tr>	      
	        <td>
	          <fmt:message key="age"/>: <form:input path="age"/>
	        </td>
	        <td>
	          <form:errors path="age" cssClass="error"/>
	        </td>
	    </tr>
	    
	  </table>
	  <br>
	  <input type="submit" value=<fmt:message key="execute"/>>
	</form:form> 
</body>
</html>


