<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<form action="addToCart" method="post">
			<h3>상품 상세</h3>
			<table class="table table-hover table-bordered">
				<tr>
					<th>상품 번호</th>
					<th>상품명</th>
					<th>상품설명</th>
					<th>가격</th>
					<th>구매수량</th>
					<th>장바구니</th>
				</tr>
				<tr>
					<td>${product.id}<input type="hidden" name="productId"
						value="${product.id}"></td>
					<td>${product.name}</td>
					<td>${product.description}</td>
					<td>${currencyFormatter.format(product.price)}</td>
					<td><input type="text" name="quantity"  class="form-control" ></td>
					<td><input type="submit" value="장바구니 넣기"  class="form-control" ></td>
				</tr>
			</table>

		</form>
		<a href="products">상품 목록보기</a>
	</div>
</body>
</html>