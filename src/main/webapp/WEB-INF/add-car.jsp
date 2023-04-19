<%--
  Created by IntelliJ IDEA.
  User: ayoub
  Date: 19/04/2023
  Time: 13:11
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Car</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<c:import url="header.jsp"></c:import>

<form class="row g-3" method="post" action="add-car">
    <div class="input-group mb-2">
        <select name="catname" class="form-select">
            <option selected="">Category...</option>
            <c:forEach var="c" items="${categorys}">
            <option>${c.getName()}</option>
            </c:forEach>
        </select>
    </div>
    <div class="input-group mb-2">
        <input type="text" class="form-control" name="carname" placeholder="Name">
    </div>
    <div class="input-group mb-2">
        <input type="text" class="form-control" name="description" placeholder="Description">
    </div>
    <div class="input-group mb-2">
        <input type="text" class="form-control" name="urlimg" placeholder="Image link">
    </div>
    <div class="input-group mb-2">
        <input type="text" class="form-control" name="prix" placeholder="Prix">
    </div>
    </div>
    <div class="col-12">
        <button type="submit" class="btn btn-primary">Add Car</button>
    </div>
</form>
</body>
</html>
