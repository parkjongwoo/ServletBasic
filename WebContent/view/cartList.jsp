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
		<a href="products">상품 목록보기</a>
		<h3>장바구니 내역</h3>
		<table class="table table-hover table-bordered">
			<tr  class="active">
				<th>순번</th>
				<th>상품 번호</th>
				<th>상품명</th>
				<th>상품설명</th>
				<th>수량</th>
				<th>단가</th>
				<th>금액</th>
			</tr>
			<c:set scope="page" var="tot_quantity" value="0"/>
			<c:forEach var="shoppingItem" items="${cart}" begin="0"
				varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td>${shoppingItem.product.id}</td>
					<td>${shoppingItem.product.name}</td>
					<td>${shoppingItem.product.description}</td>
					<td class="quantity">${shoppingItem.quantity}</td>
					<td class="price">${currencyFormatter.format(shoppingItem.product.price)}</td>
					<td class="total">${currencyFormatter.format(total=shoppingItem.product.price*shoppingItem.quantity)}</td>										
				</tr>
				<c:set scope="page" var="tot_quantity" value="${tot_quantity+shoppingItem.quantity}"/>
				<c:set scope="page" var="tot_total" value="${tot_total+total}"/>
			</c:forEach>
			<tr  class="active">
				<td colspan="4">합계</td>				
				<td>${tot_quantity}</td>
				<td>--</td>
				<td>${currencyFormatter.format(tot_total)}</td>
			</tr>
		</table>
	</div>
</body>
</html>