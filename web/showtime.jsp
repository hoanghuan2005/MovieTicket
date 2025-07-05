<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="components/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chọn lịch chiếu</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
  <h3>Chọn rạp & lịch chiếu cho: ${movie.title}</h3>
  <c:forEach var="cinema" items="${cinemaList}">
    <h5 class="mt-4">${cinema.name} - ${cinema.address}</h5>
    <div class="d-flex flex-wrap gap-2">
      <c:forEach var="showtime" items="${cinema.showtimes}">
        <a href="main?action=selectSeat&showtimeId=${showtime.showtimeId}" class="btn btn-outline-primary btn-sm">
          <fmt:formatDate value="${showtime.startTime}" pattern="HH:mm dd/MM"/>
          - ${showtime.price}đ
        </a>
      </c:forEach>
    </div>
  </c:forEach>
</div>
<%@ include file="components/footer.jsp" %>
</body>
</html>
