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
		<h2>Form Nhập Thông Tin</h2>
		<form action="${pageContext.request.contextPath}/check-in" // đường
			dẫn Checkincontroller method="POST">



			<%
			String error = (String) request.getAttribute("error");
			if (error != null && !error.isEmpty()) {
			%>
			<div class="alert alert-danger">
				<%=error%>
			</div>
			<%
			}
			%>



			<!--action : nơi chuyển toàn bộ dữ liệu đến trang index.jsp, nếu kh đặt moethod thì mặc định là GET  -->
			<div class="form-group">
				<label for="inputName">Tên:</label> <input type="text"
					class="form-control" id="inputName" name="name"
					placeholder="Nhập tên của bạn" required>
			</div>
			<div class="form-group">
				<label for="inputPhone">Số điện thoại:</label> <input type="tel"
					class="form-control" id="inputPhone" name="phone"
					placeholder="Nhập số điện thoại của bạn" required>
			</div>
			<div class="form-group">
				<label for="inputAdd">Địa chỉ:</label> <input type="tel"
					class="form-control" id="inputAdd" name="add"
					placeholder="Nhập địa chỉ toà nhà" required>
			</div>

			<div class="form-group">
				<label for="inputRoom">Số phòng:</label> <select
					class="form-control" id="inputRoom" name="idroom"
					placehoder="Chọn phòng" required>
					<option value="101">Phòng 101</option>
					<option value="102">Phòng 102</option>
					<option value="103">Phòng 103</option>
					<option value="201">Phòng 201</option>
					<option value="202">Phòng 202</option>
					<option value="203">Phòng 203</option>
					<option value="301">Phòng 301</option>
					<option value="302">Phòng 302</option>
					<option value="303">Phòng 303</option>
					<option value="401">Phòng 401</option>
					<option value="402">Phòng 402</option>
					<option value="403">Phòng 403</option>
					<option value="501">Phòng 501</option>
					<option value="502">Phòng 502</option>
					<option value="503">Phòng 503</option>
				</select>
			</div>

			<div class="form-group">
				<label for="inputIDcard">CCCD:</label> <input type="tel"
					class="form-control" id="inputIdcard" name="inputIdcard"
					placeholder="Nhập CCCD của bạn" required>

			</div>

			<button type="submit" class="btn btn-primary"
				style="padding: 6px 12px">Check in</button>
		</form>

	</div>


</body>
</html>
