<%--
  Created by IntelliJ IDEA.
  User: Lrandom
  Date: 30/05/2021
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page  pageEncoding="UTF-8"  %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="ec" uri="/WEB-INF/tlds/utils" %>
<fmt:setLocale value="vi_VN"/>
<fmt:setBundle basename="main"/>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
            crossorigin="anonymous"></script>
    <meta charset="UTF-8"/>
</head>
<body>
<div class="container">
    <jsp:include page="./../commons/nav.jsp"/>

<%--    <ec:EchoHello/>
   <ec:EchoHello/>
   <ec:EchoHello/>
   <ec:EchoHello/>
   <ec:EchoHello/>
   <ec:EchoHello/>

    <ec:BlockSwearWord content="Holy shit, You are bitch, right?"></ec:BlockSwearWord>--%>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">
                <fmt:message key="Name"/>
            </th>
            <th scope="col"><fmt:message key="Operation"/> </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${list}">
            <tr>
                <th scope="row">${item.getId()}</th>
                <td>${item.getName()}</td>
                <td>
                    <a class="btn btn-danger"
                       href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}/${pageContext.request.contextPath}/admin/category/delete?id=${item.getId()}"
                       onclick="return confirm('Bạn có muốn xoá')">Delete</a>
                    <a class="btn btn-warning"
                       href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}/${pageContext.request.contextPath}/admin/category/update?id=${item.getId()}">Update</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <jsp:include page="./../commons/footer.jsp"/>
</div>
</body>
</html>
