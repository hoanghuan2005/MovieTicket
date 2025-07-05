<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="components/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5" style="max-width: 500px;">
  <h3 class="text-center">Đăng ký</h3>
  <form action="main" method="post">
    <input type="hidden" name="action" value="register"/>
    <div class="mb-3">
      <label class="form-label">Họ tên</label>
      <input type="text" name="name" class="form-control" required>
    </div>
    <div class="mb-3">
      <label class="form-label">Email</label>
      <input type="email" name="email" class="form-control" required>
    </div>
    <div class="mb-3">
      <label class="form-label">Số điện thoại</label>
      <input type="text" name="phone" class="form-control">
    </div>
    <div class="mb-3">
      <label class="form-label">Mật khẩu</label>
      <input type="password" name="password" class="form-control" required>
    </div>
    <button type="submit" class="btn btn-success w-100">Đăng ký</button>
  </form>
</div>
<%@ include file="components/footer.jsp" %>
</body>
</html>
