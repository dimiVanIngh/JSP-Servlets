<%@page contentType='text/html' pageEncoding='UTF-8' trimDirectiveWhitespaces ='true'%> 
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%> 
<!doctype html>
<html lang='nl'>
<head>
	<vdab:head title='Sauzen'/>
</head>
<body>
	<vdab:menu/>
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


