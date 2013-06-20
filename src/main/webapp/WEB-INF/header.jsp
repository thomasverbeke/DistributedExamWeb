<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<header id="page_header">
	<nav>
	    <ul>
	    	<li class="home_link">
	    		<a href="<c:url value="hello.htm"/>">Home</a>
	    	</li>
	    	<li>
	    		<a href="<c:url value="priceincrease.htm"/>"><fmt:message key="prices.increase"/></a>
	    	</li>
	    	<li>
	    		<a href="<c:url value="api/person/random.json"/>">Restlet? JSON</a>
	    	</li>
	    	<li>
	    		<a href="<c:url value="api/person/random.xml"/>">Restlet? XML</a>
	    	</li>
	    	<li>
	    		<a href="<c:url value="guest.htm"/>">JPA Test</a>
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