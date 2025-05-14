<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<h1>Thêm nhân viên mới</h1>
<form:form action="${pageContext.request.contextPath}/employees" method="post" modelAttribute="employee">
    <div>
        <label>Tên:</label>
        <form:input path="name" />
    </div>
    <div>
        <label>Email:</label>
        <form:input path="email" />
    </div>
    <div>
        <label>Vị trí công việc:</label>
        <form:input path="position" />
    </div>
    <div>
        <input type="submit" value="Thêm nhân viên" />
    </div>
</form:form>

<a href="${pageContext.request.contextPath}/employees">Quay lại danh sách nhân viên</a>
</body>
</html>
