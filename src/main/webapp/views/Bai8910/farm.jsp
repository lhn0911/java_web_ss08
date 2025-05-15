<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HOANGNAM
  Date: 5/15/2025
  Time: 6:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Your Farm (20 plots)</h2>
<table border="1">
  <tr>
    <c:forEach var="plot" items="${farm}" varStatus="status">
    <td style="text-align: center; width: 120px; height: 120px;">
      <p>Plot ${plot.position}</p>
      <c:choose>
        <c:when test="${plot.seed != null}">
          <img src="${plot.seed.imageUrl}" width="100"/><br/>
          <p>${plot.seed.seedsName}</p>
        </c:when>
        <c:otherwise>
          <form method="post" action="plant">
            <input type="hidden" name="plotPosition" value="${plot.position}"/>
            <select name="seedId">
              <c:forEach var="ws" items="${warehouse}">
                <c:if test="${ws.quantity > 0}">
                  <option value="${ws.seeds.id}">
                      ${ws.seeds.seedsName} (${ws.quantity})
                  </option>
                </c:if>
              </c:forEach>
            </select><br/>
            <button type="submit">Plant</button>
          </form>
        </c:otherwise>
      </c:choose>
    </td>
    <c:if test="${status.count % 5 == 0}">
  </tr><tr>
  </c:if>
  </c:forEach>
</tr>
</table>

<br/>
<a href="${pageContext.request.contextPath}/home">Back to Home</a>
</body>
</html>
