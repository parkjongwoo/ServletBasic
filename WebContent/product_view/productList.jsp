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
<script type="text/javascript" >
	$(document).ready(function(){
		msg = "${message}";
		if(msg.trim().length>0){
			alert(msg);
		}
	})
</script>
</head>
<body>
	<div class="container">
		<h3>상품정보목록</h3>
		<table class="table table-bordered table-hover">
			<tr class="active">
				<th>순번</th>
				<th>상품번호</th>
				<th>상품명</th>
				<th>상품설명</th>
				<th>상품가격</th>
				<th>상세보기</th>
			</tr>
			<c:forEach var="product" items="${productList}" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td>${product.productid}</td>
				<td>${product.productname}</td>
				<td>${product.description}</td>
				<td>${product.productprice}</td>
				<td><a href="productDetail?productid=${product.productid}">상세보기</a></td>
			</tr>
			</c:forEach>
		</table>
		<a href="productForm">상품등록</a>
	</div>
</body>
</html>