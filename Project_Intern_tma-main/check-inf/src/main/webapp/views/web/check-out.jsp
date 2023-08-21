<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h2>Form Check out</h2>
		<form action="${pageContext.request.contextPath}/check-out"
			method="get">
			<!--action : nơi chuyển toàn bộ dữ liệu đến trang index.jsp, nếu kh đặt moethod thì mặc định là GET  -->
		
			<div class="form-group">
				<label for="inputAdd">Mã khách hàng:</label> <input type="tel"
					class="form-control" id="inputAdd" name="add"
					placeholder="Nhập Mã khách hàng" required>
			</div>


			<div class="form-group">
				 <label for="inputRoom">Số phòng:</label>
        <input type="tel" class="form-control" id="inputRoom" name="idroom" placeholder="Nhập số phòng" required> 
				
			</div>
<!-- 
			<div class="form-group">
				<label for="inputEmail">CCCD:</label> <input type="tel"
					class="form-control" id="inputEmail" name = "inputIdcard"
					placeholder="Nhập CCCD của bạn">

			</div>
 -->
			<button type="submit" class="btn btn-primary"
				onclick="addData()  style ="padding: 6px 12px">Check out</button>
		</form>
	</div>


</body>
</html>
