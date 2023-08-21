<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- import thư viện jstl -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
		<h2>Danh Sách Thông Tin Khách Hàng</h2>
		<form action="Filter" method="post" name="filterForm">
			
			<div class="form-row">
				<div class="form-group col-md-3">
					<label for="nameFilter">Tên khách hàng</label> <input type="text"
						class="form-control" name="name_customer"
						placeholder="Nhập tên khách hàng">
				</div>
				<div class="form-group col-md-3">
					<label for="phoneFilter">Số điện thoại</label> <input type="text"
						class="form-control" name="phone_number"
						placeholder="Nhập số điện thoại">
				</div>
				<div class="form-group col-md-3">
					<label for="addressFilter">Địa chỉ</label> <input type="text"
						class="form-control" name="add_customer"
						placeholder="Nhập địa chỉ">
				</div>
				<div class="form-group col-md-3">
					<label for="roomFilter">Id phòng</label> <input type="text"
						class="form-control" name="id_room" placeholder="Nhập Id phòng">
				</div>

			</div>
			<!-- nút lọc -->
			<button type="submit" value = "Filter" class="btn btn-primary">Lọc</button>
			
			
			<a href="${pageContext.request.contextPath}/check-in"
				class="btn btn-primary" style="padding: 6px 12px">Check-in</a>
				
			
			<a href="${pageContext.request.contextPath}/check-inf/check-out"
				class="btn btn-primary" style="padding: 6px 12px">Check-out</a>
			
		</form>
		<table class="table table-bordered">
			<tr>
				<th>Mã KH</th>
				<th>Tên KH</th>
				<th>Số điện thoại</th>
				<th>Địa chỉ</th>
				<th>CCCD</th>
				<th>Id phòng</th>
			</tr>
			<%
			String res = request.getAttribute("check")+"";
			if(res.equals("1")){
			%>
			<c:forEach items="${customers}" var="customer">
				<tr>
					<td>${customer.getId_customer()}</td>
					<td>${customer.getName_customer()}</td>
					<td>${customer.getPhone_number()}</td>
					<td>${customer.getAdd_customer()}</td>
					<td>${customer.getId_card()}</td>
					<td>${customer.getId_room()}</td>
				</tr>
			</c:forEach>
			
			<%}else{ %>
			<c:forEach items="${lists}" var="customer">
				<tr>
					<td>${customer.getId_customer()}</td>
					<td>${customer.getName_customer()}</td>
					<td>${customer.getPhone_number()}</td>
					<td>${customer.getAdd_customer()}</td>
					<td>${customer.getId_card()}</td>
					<td>${customer.getId_room()}</td>
				</tr>
			</c:forEach>
			<%} %>
		</table>

	</div>
</body>
</html>
