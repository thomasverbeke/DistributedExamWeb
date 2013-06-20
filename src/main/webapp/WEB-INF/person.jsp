<%@ include file="/WEB-INF/include.jsp"%>

<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="repository.*"%>
<%@page import="entity.*"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 
<html>
    <head>
	<meta charset="UTF-8">
	<title><fmt:message key="title"/></title>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	  	<c:url value="/static/css/main.css" var="resourceUrl"/>
		<link media="screen" rel="stylesheet" href="${resourceUrl}" type="text/css" />
	</head>
 
    <body>
    	<jsp:include page="header.jsp" />
    		<div id="container">
    	
	    		<h1><fmt:message key="heading"/></h1>
	    	
	    		<h1><fmt:message key="menu.adduser"/></h1>
	    		<a href="validationform.htm"><fmt:message key="link"/></a>
	    	
	    		<h1><fmt:message key="menu.userlist"/></h1>
	       		<table class="single_table">
				<c:forEach items="${model.persons}" var="person">
					<tr>
						<td class="per20"><c:out value="${person.name}" /></td>
						<td><i><c:out value="${person.age}" /></i></td>
						
						<c:forEach items="${person.roles}" var="role">
							<td class="per20"><i><c:out value="${role.roleName}" /></i></td>
						</c:forEach>
						
						<c:forEach items="${person.datas}" var="data">
							<td class="per20"><i><c:out value="${data.fileName}" /></i></td>
						</c:forEach>
					</tr>
				</c:forEach>
			</table>
	        
	        <h1><fmt:message key="menu.otherstuff"/></h1>
	        <a href="basic">Servlet</a>
        </div>
 	</body>
 </html>