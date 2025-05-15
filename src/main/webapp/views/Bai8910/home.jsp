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
<h2>Welcome to the Farm Game</h2>
<c:if test="${not empty currentUser}">
    <div>
        <a href="shop">Shop</a> |
        <a href="warehouse">Warehouse</a> |
        <a href="farm">Farm</a>
    </div>
</c:if>
<c:if test="${empty currentUser}">
    <a href="registerUser">Register</a> | <a href="login">Login</a>
</c:if>
</body>
</html>
