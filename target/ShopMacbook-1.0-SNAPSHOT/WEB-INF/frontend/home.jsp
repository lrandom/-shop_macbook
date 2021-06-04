<%--
  Created by IntelliJ IDEA.
  User: Lrandom
  Date: 30/05/2021
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <jsp:include page="commons/nav.jsp"/>

    <br>
    <br>

    <div class="row">
        <c:forEach var="mac" items="${list}">
            <div class="col-md-3 col-xs-12">
                <div class="card" style="width: 18rem;">
                    <img src="${mac.getImage()}" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title"><a>${mac.getName()}</a></h5>
                        <p style="color:red;font-weight: bold;">${mac.getPrice()}</p>
                        <p class="card-text">${mac.getDescription()}</p>
                        <a href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/cart?action=addItem&id=${mac.getId()}" class="btn btn-primary">Add To Cart</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
