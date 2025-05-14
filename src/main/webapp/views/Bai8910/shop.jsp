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
<h2>Xin chào, ${player.username} - Số dư: ${player.balance} VNĐ</h2>

<h3>Danh sách hạt giống</h3>
<c:forEach var="s" items="${seeds}">
    <div>
        <img src="${s.imageUrl}" width="100px"/>
        <p>${s.seedsName}</p>
        <p>Giá: ${s.price} VNĐ</p>
    </div>
</c:forEach>
</body>
</html>
