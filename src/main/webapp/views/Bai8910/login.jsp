<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HOANGNAM
  Date: 5/14/2025
  Time: 3:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
    Username: <input name="username"/><br>
    Password: <input name="password" type="password"/><br>
    <input type="submit" value="Login"/>
</form>
<c:if test="${not empty message}">
    <p style="color:red">${message}</p>
</c:if>
</body>
</html>
