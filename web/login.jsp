<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel="stylesheet" href="assets/css/login.css" />

    </head>
    <body>
        <c:choose>
            <c:when test="${not empty sessionScope.user}">
                <c:redirect url="welcome.jsp"/>
            </c:when>
            <c:otherwise>
                <div class="login-container">
                    <h1>Login</h1>
                    <form action="main" method="post">
                        <input type="hidden" name="action" value="login" />
                        <label for="username">Username:</label>
                        <input type="text" id="username" name="username" required />

                        <label for="pass">Password:</label>
                        <input type="password" id="pass" name="password" required />

                        <input type="submit" value="Login" />
                    </form>

                    <!-- Register button -->
                    <form action="main" method="post">
                        <input type="hidden" name="action" value="register" />
                        <input type="submit" value="Register" class="register-btn" />
                    </form>

                    <c:if test="${not empty message}">
                        <div class="ok">${message}</div>
                    </c:if>

                    <c:if test="${not empty checkError}">
                        <div class="error">${checkError}</div>
                    </c:if>
                </div>
            </c:otherwise>
        </c:choose>
    </body>
</html>
