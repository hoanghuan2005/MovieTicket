<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="header.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Xác nhận đặt vé</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="assets/css/booking-confirm.css"/>
    </head>
    <body>
        <div class="container mt-4">
            <h3>Xác nhận đặt vé</h3>
            <p><strong>Phim:</strong> ${movie.title}</p>
            <p><strong>Suất:</strong> <fmt:formatDate value="${showtime.startTime}" pattern="HH:mm dd/MM/yyyy"/></p>
        <p><strong>Ghế:</strong> ${selectedSeats}</p>
        <p><strong>Tổng tiền:</strong> ${totalAmount}đ</p>

        <form action="main" method="post">
            <input type="hidden" name="action" value="makePayment"/>
            <input type="hidden" name="bookingId" value="${bookingId}"/>
            <button type="submit" class="btn btn-primary">Thanh toán</button>
        </form>
    </div>
    <%@ include file="footer.jsp" %>
</body>
</html>
