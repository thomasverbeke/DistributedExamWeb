<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<header id="page_header">
	<nav>
	    <ul>
	    	<li class="home_link">
	    		<a href="<c:url value="person.htm"/>">Home</a>
	    	</li>
	    	<li>
	    		<a href="<c:url value="validationform.htm"/>"><fmt:message key="header.adduser"/></a>
	    	</li>
	    	<li>
	    		<a href="<c:url value="api/person/5.json"/>">REST /API/ID JSON</a>
	    	</li>
	    	<li>
	    		<a href="<c:url value="api/person/5.xml"/>">REST /API/ID XML</a>
	    	</li>
	    	<li>
	    		<a href="<c:url value="api/thomas.json"/>">REST /API/NAME</a>
	    	</li>
	    	
	    	<li>
	    		<a href="<c:url value="api/personalt/4.json"/>">ALT JSON</a>
	    	</li>
	    	<li>
	    		<a href="<c:url value="api/personalt/4.xml"/>">ALT XML</a>
	    	</li>
	    	
	    	<li id="languageSelection">
				<aside>
			    	<ul>
			    		<li>
			    			<a href="?lang=en">en</a>
			    		</li>
			    		<li>
			    			<a href="?lang=nl">nl</a>
			    		</li>
			    	</ul>
				</aside>
	    	</li>
	    </ul>
	</nav>
</header>