<%@page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces ='true'%> 
<%-- Op de vorige regel wordt session="false" niet vermeld --%>
<%-- Zo komt session="true" (de default) --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="nl"> 
<head>
<c:import url="head.jsp">
  <c:param name='title' value='Raad de saus' />
</c:import>
</head> 
<body>
  <c:import url='/WEB-INF/JSP/menu.jsp'/> 
  <h1>Raad de saus</h1>
  <p>Te raden saus: ${sausRadenSpel.sausMetPuntjes}</p>
	letter:
  <c:url value="" var="nieuwSpelURL">
    <c:param name="nieuwSpel" value="true"/>
  </c:url>
  <c:url value="" var="raadSausURL">
    <c:param name="raadSaus" value="true"/>
  </c:url>
  <form method="post" action="${raadSausURL}">
 	<input type="text" name="gok" autofocus/>
    <input type="submit" value="Raden">
  </form>
  <form method="post" action="${nieuwSpelURL}">
    <input type="submit" value="Nieuw spel">
  </form>
  <img src=<c:url value='images/${sausRadenSpel.verkeerdeBeurten}.png' /> alt="Hangman">
</body>
</html>