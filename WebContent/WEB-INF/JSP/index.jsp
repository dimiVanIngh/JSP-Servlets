<%@page contentType='text/html' pageEncoding='UTF-8' session='false'
	trimDirectiveWhitespaces='true'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html lang="nl">
<head>
<c:import url='/WEB-INF/JSP/head.jsp'>
	<c:param name='title' value='Frituur Frida' />
</c:import>
</head>
<body>
	<h1>Frituur Frida</h1>
	<h2>Vandaag zijn we ${begroeting}</h2>
	<img src="images/${begroeting}.png" alt="${begroeting}">
	<h2>Adres</h2>
	<p>
		${adres}<br> ${adres.gemeente}
	</p>
	<a href="sauzen.htm">Sauzen</a>
	<div>
		Telefoonnummer helpdesk: <a href="tel:+${initParam.telefoonHelpDesk.replace('/',' ')}">${initParam.telefoonHelpDesk}</a>
	</div>
	<div>
		Telefoonnummer helpdesk: <a href="tel:+${telefoonNummerHelpDesk.replace('/',' ')}">${telefoonNummerHelpDesk}</a>
	</div>
</body>
</html>