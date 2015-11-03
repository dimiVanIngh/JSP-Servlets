<%@page contentType='text/html' pageEncoding='UTF-8' session='false' trimDirectiveWhitespaces='true'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%> 
<fmt:setBundle basename='resourceBundles.teksten'/>
<!doctype html>
<html lang="nl">
<head>
	<fmt:message key='frituurFrida' var="ff"/>
	<vdab:head title='${ff}'/>
</head>
<body>
	<vdab:menu/> 
	<h1><fmt:message key='frituurFrida'/></h1>
	<h1><fmt:message key='vandaagZijnWe${openGesloten}'/></h1>
    <fmt:message key='afbeelding${openGesloten}' var='afbeelding'/>
    <img src='<c:url value="/images/${afbeelding}.png"/>' 
      alt="<fmt:message key='${openGesloten}'/>">
    <h2><fmt:message key='adres'/></h2>

	<p>
		${adres}<br> ${adres.gemeente}
	</p>
	<div>
		Telefoonnummer helpdesk: <a href="tel:+${initParam.telefoonHelpDesk.replace('/','')}">${initParam.telefoonHelpDesk.replace('/','')}</a>
	</div>
	<div>
		Telefoonnummer helpdesk: <a href="tel:+${telefoonNummerHelpDesk.replace('/','')}">${telefoonNummerHelpDesk}</a>
	</div>

</body>
</html>
