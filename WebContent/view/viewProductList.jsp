<%@page import="java.util.Locale"%>
<%@page import="java.text.NumberFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품 목록</title>
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
		<h3>상품 목록</h3>
		<table class="table table-hover table-bordered">
			<tr  class="active">
				<th>순번</th>
				<th>상품 번호</th>
				<th>상품명</th>
				<th>상품설명</th>
				<th>가격</th>
				<th>상세보기</th>
			</tr>
			<c:forEach var="product" items="${products}" begin="0" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td>${product.id}</td>
					<td>${product.name}</td>
					<td>${product.description}</td>
					<td>${currencyFormatter.format(product.price)}</td>
					<td><a href="viewProductDetails?productId=${product.id}">상세보기</a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="viewCart">장바구니보기</a>
	</div>
</body>
</html>