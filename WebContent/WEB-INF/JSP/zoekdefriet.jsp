<%@page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces ='true'%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%> 
<!doctype html>
<html lang="nl"> 
<head>
	<vdab:head title='Zoek de friet'/>
</head> 
<body>
  <vdab:menu/>
  <h1>Zoek de friet</h1>
  <form method='post'>
    <c:forEach items='${zoekDeFrietSpel.deurIsOpen}' var='deurIsOpen' varStatus="status">
      <button type='submit' name='volgnummer' value='${status.index}'>
      <c:choose>
        <c:when test='${deurIsOpen}'>
          <c:choose>
            <c:when test='${status.index == zoekDeFrietSpel.deurMetFriet}'>
              <img src='<c:url value="/images/gevonden.png"/>' alt='gevonden'/>
            </c:when>
            <c:otherwise>
              <img src='<c:url value="/images/deuropen.png"/>' alt='deur open'/>
            </c:otherwise>
          </c:choose>
        </c:when>
        <c:otherwise>
          <img src='<c:url value="/images/deurtoe.png"/>' alt='deur toe'/>
        </c:otherwise>
      </c:choose>
      </button>
    </c:forEach>
  </form>
  <c:url value="" var="nieuwSpelURL">
    <c:param name="nieuwSpel" value="true"/>
  </c:url>
  <form method="post" action="${nieuwSpelURL}">
    <input type="submit" value="Nieuw spel">
  </form>
</body>
</html>