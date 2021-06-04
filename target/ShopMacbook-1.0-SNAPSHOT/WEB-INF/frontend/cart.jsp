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

    ${test}

    <div class="row">
        <c:forEach var="cartItem" items="${cartItems}">
            <div style="display: flex;justify-content: space-between">
                <div style="display: flex;justify-content: flex-start">
                    <img src="${cartItem.getProduct().getImage()}" width="100"/>

                    <div>
                        <h5>${cartItem.getProduct().getName()}</h5>
                        <div>${cartItem.getQuantity()} x <span
                                style="color:red;font-weight: bold"><fmt:formatNumber currencyCode="en-US" value="${cartItem.getProduct().getPrice()}"/></span></div>
                    </div>
                </div>


                <div>
                    <div>
                        <a href="${pageContext.request.contextPath}/cart?action=updateQuantity&id=${cartItem.getProduct().getId()}&offset=1">+</a>
                    </div>
                    <div>
                        <a href="${pageContext.request.contextPath}/cart?action=updateQuantity&id=${cartItem.getProduct().getId()}&offset=-1">-</a>
                    </div>

                    <div>
                        <a href="${pageContext.request.contextPath}/cart?action=removeItem&id=${cartItem.getProduct().getId()}">x</a>
                    </div>
                </div>
            </div>
        </c:forEach>

        <div style="clear: both"></div>
        <div style="float:right;position: relative;overflow: hidden">
            <div>Tax: <fmt:formatNumber currencyCode="en-US" value="${tax}"/></div>
            <div>Tiền hàng: <fmt:formatNumber currencyCode="en-US" value="${subTotal}"/></div>
            <div>Tổng tiền phải trả: <fmt:formatNumber currencyCode="en-US" value="${total}"/></div>
        </div>

        <div style="clear: both"></div>
        <div style="margin:0px auto;width: 650px; display: flex;justify-content: space-between">
            <a class="btn btn-danger" style="width:300px;"
               href="${pageContext.request.contextPath}/cart?action=empty">
                Làm trống giỏ hàng
            </a>

            <a class="btn btn-success" style="width:300px;margin:0px auto"
               href="${pageContext.request.contextPath}/checkout">
                Đặt hàng
            </a>
        </div>

    </div>
</div>

<style>
    a {
        text-decoration: none !important;
    }
</style>
</body>
</html>
