<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${empty sessionScope.user}">
    <c:redirect url="login.jsp" />
</c:if>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Welcome</title>
        <link rel="stylesheet" href="assets/css/welcome.css"/>
    </style>
</head>
<body>
    <jsp:include page="header.jsp" />
    <div class="container">
        <form action="user" method="post">
            <input type="hidden" name="action" value="logout"/>
            <button type="submit">Logout</button>
        </form>

        <h1>Welcome, ${sessionScope.user.username}!</h1>

        <h2>Exam Categories</h2>

        <c:if test="${empty listCategory}">
            <p class="no-data">No exam categories found.</p>
        </c:if>

        <c:if test="${not empty listCategory}">
            <table>
                <thead>
                    <tr>
                        <th>Category Name</th>
                        <th>Description</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="cate" items="${listCategory}">
                        <tr>
                            <td>
                                <a href="main?action=viewExamByCategory&categoryId=${cate.categoryId}">
                                    ${cate.categoryName}
                                </a>
                            </td>
                            <td>${cate.description}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>

        <c:if test="${sessionScope.user.role == 'Instructor'}">
            <a href="main?action=createNewExam" class="create-link">Create New Exam</a>
        </c:if>

        <c:if test="${not empty listExam}">
            <h2>Exams</h2>
            <table>
                <thead>
                    <tr>
                        <th>Exam Name</th>
                        <th>Subject</th>
                        <th>Total Marks</th>
                        <th>Duration</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="ex" items="${listExam}">
                        <tr>
                            <td>
                                <a href="main?action=viewDetailExam&examId=${ex.examId}">
                                    ${ex.examTitle}
                                </a>
                            </td>
                            <td>${ex.subject}</td>
                            <td>${ex.totalMarks}</td>
                            <td>${ex.duration}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>

        <c:if test="${not empty message}">
            <p style="color: green">${message}</p>
        </c:if>

        <c:if test="${not empty error}">
            <p style="color: red">${error}</p>
        </c:if>
    </div>
    <jsp:include page="footer.jsp" />

</body>
</html>
