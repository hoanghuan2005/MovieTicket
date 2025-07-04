

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Result Page</title>
        <link rel="stylesheet" href="assets/css/viewResult.css"/>
    </head>
    <body>
        <div class="container">
            <h2>Thank You!</h2>
            <p>You have successfully completed the exam.</p>

            <div class="score-box">
                Your Score: ${result.score} / ${totalQuestions}
            </div>

            <a href="main?action=viewCategory" class="btn-home">Back to Home</a>
        </div>
    </body>
</html>
