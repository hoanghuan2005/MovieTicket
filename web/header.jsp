<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="assets/css/header.css"/>
<nav class="navbar navbar-expand-lg navbar-dark">
    <div class="container">
        <a class="navbar-brand" href="home.jsp"><i class="fa-solid fa-film"></i> MovieBooking</a>
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav ms-auto">
                <c:choose>
                    <c:when test="${not empty sessionScope.user}">
                        <li class="nav-item"><a class="nav-link" href="main?action=bookingHistory">Lịch sử đặt vé</a></li>
                        <li class="nav-item"><a class="nav-link" href="main?action=logout">Đăng xuất</a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item"><a class="nav-link" href="login.jsp">Đăng nhập</a></li>
                        <li class="nav-item"><a class="nav-link" href="register.jsp">Đăng ký</a></li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>
</nav>
