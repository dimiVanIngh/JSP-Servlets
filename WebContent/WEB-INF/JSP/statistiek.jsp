<%@page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces ='true'%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%> 
<!doctype html>
<html lang="nl">
  <head>
    <vdab:head title='Statistiek'/>
    <style>
    td:last-child {
      text-align:right;
    }
    </style>
  </head>
  <body>
  <vdab:menu/>
    <h1>Statistiek</h1>
    <c:if test="${not empty statistiek}">
      <table>
       <thead>
       <tr>
         <th>URL</th><th>aantal requests</th>
       </tr>
      </thead>
      <tbody>
        <c:forEach var="entry" items="${statistiek}">
          <tr>
            <td>${entry.key}</td>
            <td style="text-align:right;">${entry.value}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </c:if>
</body>
</html> 