<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="components/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${movie.title}</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
  <div class="row">
    <div class="col-md-4">
      <img src="${movie.posterUrl}" class="img-fluid rounded" alt="${movie.title}">
    </div>
    <div class="col-md-8">
      <h2>${movie.title}</h2>
      <p><strong>Thể loại:</strong> ${movie.genres}</p>
      <p><strong>Thời lượng:</strong> ${movie.duration} phút</p>
      <p><strong>Khởi chiếu:</strong> ${movie.releaseDate}</p>
      <p>${movie.description}</p>
      <a href="main?action=viewShowtimes&movieId=${movie.movieId}" class="btn btn-primary">Chọn lịch chiếu</a>
    </div>
  </div>
</div>
<%@ include file="components/footer.jsp" %>
</body>
</html>
