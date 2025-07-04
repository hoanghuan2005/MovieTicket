<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${empty sessionScope.user}">
    <c:redirect url="login.jsp" />
</c:if>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Take Exam</title>
        <link rel="stylesheet" href="assets/css/takeExam.css"/>
    </head>
    <body>
        <div class="container">
            <h2>Take Exam</h2>

            <form action="main" method="post">
                <input type="hidden" name="action" value="submitExam" />
                <input type="hidden" name="examId" value="${examId}" />

                <c:forEach var="q" items="${listQuestion}" varStatus="loop">
                    <div class="question">
                        <h4>Question ${loop.index + 1}: ${q.questionText}</h4>

                        <label><input type="radio" name="answer_${q.questionId}" value="A" required /> A. ${q.optionA}</label>
                        <label><input type="radio" name="answer_${q.questionId}" value="B" /> B. ${q.optionB}</label>
                        <label><input type="radio" name="answer_${q.questionId}" value="C" /> C. ${q.optionC}</label>
                        <label><input type="radio" name="answer_${q.questionId}" value="D" /> D. ${q.optionD}</label>
                    </div>
                </c:forEach>

                <input type="submit" value="Submit Exam" />
            </form>
        </div>
    </body>
</html>
