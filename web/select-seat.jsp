<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="components/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chọn ghế</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
  .seat { width:30px; height:30px; }
  .seat.available { background:#6c757d; }
  .seat.selected { background:#28a745; }
  .seat.sold { background:#dc3545; cursor:not-allowed; }
</style>
<script>
  function toggleSeat(button){
    if(button.classList.contains('sold')) return;
    button.classList.toggle('selected');
  }
</script>
</head>
<body>
<div class="container mt-4">
  <h3>Chọn ghế - Suất: <fmt:formatDate value="${showtime.startTime}" pattern="HH:mm dd/MM/yyyy"/></h3>
  <form action="main" method="post">
    <input type="hidden" name="action" value="confirmBooking"/>
    <input type="hidden" name="showtimeId" value="${showtime.showtimeId}"/>
    <div class="d-flex flex-column gap-1">
      <c:forEach var="row" begin="0" end="${seatMap.rows-1}">
        <div>
          <c:forEach var="col" begin="0" end="${seatMap.cols-1}">
            <c:set var="seat" value="${seatMap.seats[row][col]}"/>
            <button type="button"
                    class="seat btn ${seat.sold ? 'sold' : 'available'}"
                    onclick="toggleSeat(this)"
                    data-seat-id="${seat.seatId}">
            </button>
          </c:forEach>
        </div>
      </c:forEach>
    </div>
    <button type="submit" class="btn btn-success mt-3">Tiếp tục</button>
  </form>
</div>
<%@ include file="components/footer.jsp" %>
</body>
</html>
