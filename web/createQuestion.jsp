<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${empty sessionScope.user}">
    <c:redirect url="login.jsp" />
</c:if>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Create Question</title>
        <link rel="stylesheet" href="assets/css/createQuestion.css" />
    </head>
    <body>
        <div class="container">
            <h2>Create New Question</h2>

            <form action="main" method="post">
                <input type="hidden" name="action" value="addQuestion" />
                <input type="hidden" name="examId" value="${examId}" />

                <label for="questionText">Question Text:</label>
                <textarea id="questionText" name="questionText" rows="3" required>${question_text}</textarea>

                <label for="optionA">Option A:</label>
                <input type="text" id="optionA" name="optionA" value="${optionA}" required />

                <label for="optionB">Option B:</label>
                <input type="text" id="optionB" name="optionB" value="${optionB}" required />

                <label for="optionC">Option C:</label>
                <input type="text" id="optionC" name="optionC" value="${optionC}" required />

                <label for="optionD">Option D:</label>
                <input type="text" id="optionD" name="optionD" value="${optionD}" required />

                <label for="correctOption">Correct Answer:</label>
                <select id="correctOption" name="correctOption" required>
                    <option value="A" <c:if test="${correctOption == 'A'}">selected=""</c:if>>A</option>
                    <option value="B" <c:if test="${correctOption == 'B'}">selected=""</c:if>>B</option>
                    <option value="C" <c:if test="${correctOption == 'C'}">selected=""</c:if>>C</option>
                    <option value="D" <c:if test="${correctOption == 'D'}">selected=""</c:if>>D</option>
                    </select>

                    <input type="submit" value="Create Question" />
                </form>
                <div style="text-align: center;">
                    <a href="main?action=viewDetailExam&examId=${examId}" class="back-btn">Back to Exam Detail</a>
                </div>



            <c:if test="${not empty message}">
                <p class="message success">${message}</p>
            </c:if>

            <c:if test="${not empty error}">
                <p class="message error">${error}</p>
            </c:if>

            <c:if test="${not empty listQuestion}">
                <table class="project-table">
                    <thead>
                        <tr>
                            <th>STT</th>
                            <th>Question</th>
                            <th>Correct Answer</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="q" items="${listQuestion}" varStatus="loop">
                            <tr>
                                <td>${loop.index + 1}</td>
                                <td>${q.questionText}</td>
                                <td>
                                    ${q.correctOption}
                                    <c:choose>
                                        <c:when test="${q.correctOption == 'A'}">. ${q.optionA}</c:when>
                                        <c:when test="${q.correctOption == 'B'}">. ${q.optionB}</c:when>
                                        <c:when test="${q.correctOption == 'C'}">. ${q.optionC}</c:when>
                                        <c:when test="${q.correctOption == 'D'}">. ${q.optionD}</c:when>
                                    </c:choose>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
    </body>
</html>
