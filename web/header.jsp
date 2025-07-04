<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${empty sessionScope.user}">
    <c:redirect url="login.jsp" />
</c:if>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Online Exam System</title>
        <link rel="stylesheet" href="assets/css/style.css"/>
    </head>
    <body>
        <header>
            <div class="header-container">
                <h1>Online Exam System</h1>
            </div>
        </header>
    <body>
</html>
