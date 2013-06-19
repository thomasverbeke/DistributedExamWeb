<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="repository.*"%>
<%@page import="entity.*"%>
 
<jsp:useBean id="personDao" type="repository.PersonDao" scope="request" />
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
 
<html>
    <head>
        <title>JPA Test</title>
    </head>
 
    <body>
    	<h1>REST API</h1>
    	<a href="api/person/5.json">JSON (api/person/{id}.json)(javax.ws.rs)</a>
    	<a href="api/person/5.xml">XML (api/person/{id}.xml)(javax.ws.rs)</a>
    	<a href="api/thomas.json">JSON (api/{person_name}.json)</a>
    	<a href="api/david.json">Error handling</a>
    	<h1>SOAP API</h1>
    	
    	<h1>Add user</h1>
        <form method="POST" action="person.html">
            Name: <input type="text" name="name" />
            Age: <input type="text" name="age"/>
            <input type="submit" value="Add" />
        </form>
 
        <hr><ol> 
        <% for (Person guest : personDao.getAllPersons()) { %>
            <li> <%= guest %> </li>
        <% } %>
        </ol><hr>
        
        <h1>Other Stuff</h1>
        <a href="basic">Servlet</a>
 
       
     </body>
 </html>