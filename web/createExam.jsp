<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="assets/css/createExam.css" />
    </head>
    <body>
        <div class="container">
            <h2>Create New Exam</h2>

            <form action="main?action=createNewExam" method="post">
                <label for="examTitle">Exam Title:</label>
                <input type="text" id="examTitle" name="examTitle" value="${examTitle}">

                <label for="subject">Subject:</label>
                <input type="text" id="subject" name="subject"  value="${subject}">

                <label for="categoryId">Category:</label>
                <select id="categoryId" name="categoryId">
                    <c:forEach var="cate" items="${listCategory}">
                        <option value="${cate.categoryId}">${cate.categoryName}</option>
                    </c:forEach>
                </select>

                <label for="totalMarks">Total Marks:</label>
                <input type="number" id="totalMarks" name="totalMarks" min="1"  value="${totalMarks}">

                <label for="duration">Duration (minutes):</label>
                <input type="number" id="duration" name="duration" min="1"value="duration">

                <input type="submit" value="Create Exam">
            </form>
            <div style="text-align: center;">
                <a href="main?action=viewCategory" class="back-btn">Back to Home</a>
            </div>

            <c:if test="${not empty error}">
                <p class="error">${error}</p>
            </c:if>
        </div>
    </body>
</html>
