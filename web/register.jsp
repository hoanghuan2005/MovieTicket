<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
        <style>
            body {
                font-family: 'Segoe UI', sans-serif;
                background-color: #f4f6f8;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
                margin: 0;
            }

            .register-container {
                background-color: #fff;
                padding: 30px 40px;
                border-radius: 10px;
                box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
                width: 100%;
                max-width: 400px;
            }

            h1 {
                text-align: center;
                color: #2c3e50;
                margin-bottom: 24px;
            }

            form input[type="text"],
            form input[type="password"] {
                width: 93.5%;
                padding: 10px 12px;
                margin-bottom: 16px;
                border: 1px solid #ccc;
                border-radius: 6px;
                font-size: 16px;
            }

            form input[type="submit"] {
                width: 100%;
                background-color: #3498db;
                color: white;
                padding: 12px;
                border: none;
                border-radius: 6px;
                font-size: 16px;
                cursor: pointer;
            }

            form input[type="submit"]:hover {
                background-color: #2980b9;
            }

            .error-message {
                color: #e74c3c;
                text-align: center;
                margin-top: 10px;
            }
            .back-to-login {
                display: inline-block;
                margin-top: 15px;
                color: #3498db;
                text-decoration: none;
                font-size: 14px;
            }

            .back-to-login:hover {
                text-decoration: underline;
            }
        </style>
    </head>
    <body>
        <div class="register-container">
            <h1>Register</h1>
            <form action="main" method="post">
                <input type="hidden" name="action" value="register" />
                <input type="text" name="username" placeholder="Username" required />
                <input type="text" name="name" placeholder="Full Name" required />
                <input type="password" name="password" placeholder="Password" required />
                <input type="submit" value="Register" />
            </form>

            <c:if test="${not empty message}">
                <p class="error-message">${message}</p>
            </c:if>

            <a class="back-to-login" href="login.jsp">← Back to Login</a>
        </div>
    </body>
</html>
