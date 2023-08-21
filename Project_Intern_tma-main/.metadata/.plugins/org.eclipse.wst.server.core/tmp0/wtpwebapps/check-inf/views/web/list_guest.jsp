<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
  <div class="container">
    <h2>Danh Sách Thông Tin Khách Hàng</h2>
    <input type="text" class="form-control" id="searchInput" placeholder="Tìm kiếm theo tên" onkeyup="searchData()">
    <table class="table table-bordered">
      <thead>
        <tr>
        	<th>Mã KH</th>
          <th>Tên KH</th>
          <th>Số điện thoại</th>
          <th>Email</th>
          <th>Thao tác</th>
        </tr>
      </thead>
      <tbody id="dataBody">
      </tbody>
    </table>
  </div>


</body>
</html>
