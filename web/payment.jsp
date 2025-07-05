<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="components/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thanh toán</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4" style="max-width: 500px;">
  <h3>Thanh toán</h3>
  <p><strong>Mã đặt vé:</strong> ${booking.bookingId}</p>
  <p><strong>Số tiền:</strong> ${booking.totalAmount}đ</p>
  <form action="main" method="post">
    <input type="hidden" name="action" value="paymentResult"/>
    <input type="hidden" name="bookingId" value="${booking.bookingId}"/>
    <div class="mb-3">
      <label class="form-label">Phương thức</label>
      <select name="method" class="form-select" required>
        <option value="CreditCard">Thẻ tín dụng</option>
        <option value="Momo">Momo</option>
        <option value="VNPay">VNPay</option>
      </select>
    </div>
    <button type="submit" class="btn btn-success w-100">Thanh toán</button>
  </form>
</div>
<%@ include file="components/footer.jsp" %>
</body>
</html>
