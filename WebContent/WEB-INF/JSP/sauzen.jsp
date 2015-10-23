<%@page contentType='text/html' pageEncoding='UTF-8' session='false' trimDirectiveWhitespaces ='true'%> 
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html lang='nl'>
<head>
	<c:import url='/WEB-INF/JSP/head.jsp'><c:param name='title' value="Sauzen"/></c:import> 
</head>
<body>
<c:import url='/WEB-INF/JSP/menu.jsp'/> 
	<h1>Sauzen <c:forEach begin='1' end='5'>&#9733; <%-- de HTML code van een ster --%></c:forEach></h1>
	<p><span>${fouten.leeg}</span></p>
	<form method='post' id='verwijdersauzenform' action="<c:url value='/sauzen/verwijderen.htm'/>">
	    <c:forEach var="saus" items="${sauzen}">
	    	<h2><label> <input type='checkbox' name='id' value="${saus.nummer}" />${saus.naam}</label></h2>
	    	
	      <img src="images/${saus.naam}.png" alt="${saus.naam}" /> 
	      ingrediënten:	      
	       <c:forEach var="ingredient" items="${saus.ingredienten}" varStatus="status">
	         ${ingredient}<c:if test="${not status.last}">, </c:if>
	       </c:forEach>
	       
	    </c:forEach>
	    <input type='submit' value='Aangevinkte sauzen verwijderen' id='verwijdersauzenknop'>
	    </form>
	    
	<script>
 		document.getElementById('verwijdersauzenform').onsubmit = function(){
    		document.getElementById('verwijdersauzenknop').disabled = true;
    	};
	</script>
</body>
</html>


