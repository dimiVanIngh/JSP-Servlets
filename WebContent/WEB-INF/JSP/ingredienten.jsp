<%@page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces ='true'%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%> 
<!doctype html>
<html lang="nl"> 
  <head>
  <vdab:head title='Ingredi&euml;nten'/>
  </head> 
  <body>
  <vdab:menu/> 
    <h1>Ingrediënten</h1>
    <form>
      <label>Ingrediënt:<c:if test="${not empty fouten}"><span>${fouten.ingredient}</span></c:if>
      <input name="ingredient" value="${param.ingredient}" autofocus required type='search'>
      </label>
      <input type="submit" value="Zoeken">
    </form>
    <c:if test="${not empty sauzen}">
      <ul> 
        <c:forEach var="saus" items="${sauzen}"> 
          <li>${saus.naam}</li>
      </c:forEach>
      </ul>
    </c:if>
    <c:if test="${empty sauzen and empty fouten}">
      <div>Geen sauzen gevonden</div>
    </c:if>
  </body>
</html>