<%@page contentType="text/html" pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces ='true'%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%> 
<!doctype html>
<html lang="nl"> 
  <head>
  <vdab:head title='gastenboek'/>
  </head> 
  <body>
  <vdab:menu/> 
    <h1>Gastenboek</h1>
    <c:choose>
    	<c:when test="${empty param.toevoegen}"><a href="<c:url value='/gastenboek.htm?toevoegen=true'/>">Toevoegen</a></c:when>
    	<c:otherwise>
    		<form method="post" id ='toevoegenBericht'>
    			<label>Naam:<c:if test="${not empty fouten.naam}"><span>${fouten.naam}</span></c:if>
    			<input name="naam" value="${param.naam}" autofocus required type="text"></label>
      			<label>Bericht:<c:if test="${not empty fouten.bericht}"><span>${fouten.bericht}</span></c:if>
      			<textarea rows="5" cols="50" maxlength ="255" name="bericht" required>${param.bericht}</textarea>
      			</label>
      			<input type="submit" value="Toevoegen" id="toevoegenKnop">
    		</form>
    	</c:otherwise>
    </c:choose>
	
    <c:choose>
    	<c:when test="${not empty berichten}">
    		<dl>
    		<c:forEach var="bericht" items="${berichten}">
    			<dt><fmt:formatDate value='${bericht.timestamp}' type='both' dateStyle='short' timeStyle='short'/> &nbsp; ${bericht.naam }</dt>
    			<dd>${bericht.bericht}</dd>
    		</c:forEach>
    		</dl>
    	</c:when>
    	<c:otherwise><p>Er zijn nog geen berichten achter gelaten.</p></c:otherwise>
    </c:choose>
    <script>
 		document.getElementById('toevoegenBericht').onsubmit = function(){
    		document.getElementById('toevoegenKnop').disabled = true;
    	};
	</script>
  </body>
</html>