<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Lịch sử đặt vé</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="assets/css/booking-history.css"/>

    </head>
    <body>
        <div class="container mt-4">
            <h3>Lịch sử đặt vé</h3>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Mã đặt</th><th>Phim</th><th>Suất</th><th>Ghế</th><th>Tổng</th><th>Trạng thái</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="bk" items="${bookingList}">
                    <tr>
                        <td>${bk.bookingId}</td>
                        <td>${bk.movieTitle}</td>
                        <td><fmt:formatDate value="${bk.startTime}" pattern="HH:mm dd/MM"/></td>
                    <td>${bk.seats}</td>
                    <td>${bk.total}đ</td>
                    <td>${bk.status}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <%@ include file="footer.jsp" %>
    </body>
</html>
