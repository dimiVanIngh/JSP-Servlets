<%@page contentType="text/html" pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces ='true'%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%> 
<!doctype html>
<html lang="nl"> 
  <head>
  <vdab:head title='Inloggen'/>
  </head> 
  <body>
  <vdab:menu/> 
    <h1>Inlogform</h1>
    <form>
      <label>Wachtwoord:<c:if test="${not empty fouten}"><span>${fouten.inlog}</span></c:if>
      </label>
      <input type="submit" value="Inloggen">
    </form>
  </body>
</html>