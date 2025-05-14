<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HOANGNAM
  Date: 5/15/2025
  Time: 1:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/register" method="post">
    Username: <input name="username"/><br>
    Password: <input name="password" type="password"/><br>
    Email: <input name="email"/><br>
    <input type="submit" value="Register"/>
</form>
<c:if test="${not empty message}">
    <p style="color:red">${message}</p>
</c:if>
</body>
</html>
