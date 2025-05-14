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
<h1>Danh sách nhân viên</h1>
<a href="${pageContext.request.contextPath}/employees/add">Thêm nhân viên mới</a>

<c:if test="${not empty message}">
    <p style="color: green;">${message}</p>
</c:if>

<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>Tên</th>
        <th>Email</th>
        <th>Vị trí công việc</th>
    </tr>
    <c:forEach var="employee" items="${employees}">
        <tr>
            <td>${employee.name}</td>
            <td>${employee.email}</td>
            <td>${employee.position}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
