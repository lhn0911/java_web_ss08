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
<h2>Form Đăng Ký</h2>
<form:form method="post" modelAttribute="user" action="${pageContext.request.contextPath}/register">
    <div>
        <label>Tên:</label>
        <form:input path="name"/>
        <form:errors path="name" cssClass="error"/>
    </div>
    <div>
        <label>Email:</label>
        <form:input path="email"/>
        <form:errors path="email" cssClass="error"/>
    </div>
    <div>
        <label>Số điện thoại:</label>
        <form:input path="phone"/>
        <form:errors path="phone" cssClass="error"/>
    </div>
    <div>
        <input type="submit" value="Đăng ký"/>
    </div>
</form:form>
</body>
</html>
