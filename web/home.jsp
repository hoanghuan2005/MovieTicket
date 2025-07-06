<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Movie Booking - Home</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css"/>
        <link rel="stylesheet" href="assets/css/home.css"/>

    </head>
    <body>
        <div class="container mt-4">
            <h2>Phim đang chiếu</h2>
            <div class="row">
                <c:forEach var="movie" items="${nowShowingList}">
                    <div class="col-md-3 mb-4">
                        <div class="card h-100">
                            <img src="${movie.posterUrl}" class="card-img-top" alt="${movie.title}">
                            <div class="card-body">
                                <h5 class="card-title">${movie.title}</h5>
                                <a href="main?action=movieDetail&id=${movie.movieId}" class="btn btn-primary btn-sm">Chi tiết</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>

            <h2 class="mt-5">Phim sắp chiếu</h2>
            <div class="row">
                <c:forEach var="movie" items="${comingSoonList}">
                    <div class="col-md-3 mb-4">
                        <div class="card h-100">
                            <img src="${movie.posterUrl}" class="card-img-top" alt="${movie.title}">
                            <div class="card-body">
                                <h5 class="card-title">${movie.title}</h5>
                                <a href="main?action=movieDetail&id=${movie.movieId}" class="btn btn-secondary btn-sm">Chi tiết</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <div id="chat-widget">
            <div id="chat-header">Tư vấn phim</div>
            <div id="chat-body">
                <div id="chat-messages"></div>
                <input type="text" id="chat-input" placeholder="Bạn cần tư vấn gì?" />
                <button onclick="sendMessage()">Send</button>
            </div>
        </div>
        <%@ include file="footer.jsp" %>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    </body>
    <script src="assets/js/bot.js" defer></script>
</html>
