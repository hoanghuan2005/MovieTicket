<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${empty sessionScope.user}">
    <c:redirect url="login.jsp" />
</c:if>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Exam Detail</title>
        <link rel="stylesheet" href="assets/css/detail.css"/>
    </head>
    <body>
        <div class="container">
            <h2>Exam Details</h2>

            <div class="info">
                <p><span class="label">Exam Title:</span> <span class="value">${exam.examTitle}</span></p>
                <p><span class="label">Subject:</span> <span class="value">${exam.subject}</span></p>
                <p><span class="label">Category Name:</span> <span class="value">${category.categoryName}</span></p>
                <p><span class="label">Total Marks:</span> <span class="value">${exam.totalMarks}</span></p>
                <p><span class="label">Duration (minutes):</span> <span class="value">${exam.duration}</span></p>
            </div>

            <c:if test="${sessionScope.user.role == 'Instructor'}">
                <div class="actions">
                    <a href="main?action=addQuestion&examId=${exam.examId}">Add Question</a>
                </div>
            </c:if>

            <c:if test="${sessionScope.user.role == 'Student' || sessionScope.user.role == 'Instructor'}">
                <div class="actions">
                    <a href="main?action=takeExam&examId=${exam.examId}">Take Exam</a>
                </div>
            </c:if>

            <div class="actions">
                <a href="main?action=viewCategory" class="back-btn">Back to Home</a>
            </div>
        </div>
    </body>
</html>
