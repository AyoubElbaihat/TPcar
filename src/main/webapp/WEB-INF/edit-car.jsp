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
    <title>Edit Car</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<c:import url="header.jsp"></c:import>

<section class="h-100">
    <div class="container h-100">
        <div class="row justify-content-sm-center h-100">
            <div class="col-xxl-4 col-xl-5 col-lg-5 col-md-7 col-sm-9">
                <div class="text-center my-5">
                    <img src="https://cdn.pixabay.com/photo/2018/05/21/12/50/icon-3418201__340.png" alt="logo" width="100">
                </div>
                <div class="card shadow-lg">
                    <div class="card-body p-5">
                        <h1 class="fs-4 card-title fw-bold mb-4">Edit Car</h1>
                        <form method="post" action="${pageContext.request.contextPath}/auth/edit-car">
                            <div class="mb-3">
                                <select name="catname" class="form-select">
                                    <option selected="">Select a category...</option>
                                    <c:forEach var="c" items="${categorys}">
                                        <option>${c.getName()}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="mb-3">
                                <label class="mb-2 text-muted" >Name</label>
                                <input type="text" class="form-control" name="carname" placeholder="Name" value="${carname}">
                            </div>
                            <div class="mb-3">
                                <label class="mb-2 text-muted" >Description</label>
                                <input type="text" class="form-control" name="description" value="${description}">
                            </div>
                            <div class="mb-3">
                                <label class="mb-2 text-muted" >Image link</label>
                                <input type="text" class="form-control" name="urlimg" value="${urlimg}">
                            </div>
                            <div class="mb-3">
                                <label class="mb-2 text-muted" >Prix</label>
                                <input type="text" class="form-control" name="prix" value="${prix}">
                            </div>
                            <div class="input-group mb-2">
                                <input type="hidden" class="form-control" name="id" value="${id}">
                            </div>
                            <div class="d-flex align-items-center">
                                <button type="submit" class="btn btn-primary ms-auto">
                                    Edit Car
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
