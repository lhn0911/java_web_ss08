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
<h1>Thêm sản phẩm mới</h1>
<form:form action="${pageContext.request.contextPath}/products/add" method="post" modelAttribute="product">
    <div>
        <label>ID:</label>
        <form:input path="id" />
    </div>
    <div>
        <label>Tên sản phẩm:</label>
        <form:input path="name" />
    </div>
    <div>
        <label>Số lượng:</label>
        <form:input path="quantity" type="number" />
    </div>
    <div>
        <label>Giá:</label>
        <form:input path="price" type="number" step="0.01" />
    </div>
    <div>
        <input type="submit" value="Thêm sản phẩm" />
    </div>
</form:form>
<a href="${pageContext.request.contextPath}/products">Quay lại danh sách</a>
</body>
</html>
