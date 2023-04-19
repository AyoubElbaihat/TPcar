<%--
  Created by IntelliJ IDEA.
  User: ayoub
  Date: 19/04/2023
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List car</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<c:import url="header.jsp"></c:import>
<div class="container">
    <h1>Cars</h1>
    <div class="row row-cols-1 row-cols-md-2 row-cols-lg-4 g-3 align-content-center">
        <c:forEach var="c" items="${categorys}">
            <div class="col">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">${c.getName()}</h5>
                        <a href="${pageContext.request.contextPath}/auth/delete-category?id=${c.getId()}">Delete</a>
                        <a href="${pageContext.request.contextPath}/auth/edit-category?id=${c.getId()}">Edit</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/5.2.0/js/bootstrap.min.js"></script>
</body>
</html>
