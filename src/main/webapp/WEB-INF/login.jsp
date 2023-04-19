<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: ayoub
  Date: 19/04/2023
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<body>
<c:import url="header.jsp"></c:import>
<form action="${pageContext.request.contextPath}/login" method="post">
  <input type="text" name="username" placeholder="username">
  <input type="password" name="password" placeholder="password">
  <button type="submit">Login</button>
</form>

<c:if test="${isError == true}">
  <p>Bad credentials.</p>
</c:if>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/5.2.0/js/bootstrap.min.js"></script>
</body>
</html>
