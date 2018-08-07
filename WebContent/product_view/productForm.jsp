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
		<h3>새상품정보입력</h3>
		<form action="productInsert" method="post">
			<table class="table table-bordered table-hover">
				<tr class="active">
					<th colspan="2">상품등록</th>
				</tr>
				<tr>
					<td>상품명</td>
					<td><input type="text" name="productname" /></td>
				</tr>
				<tr>
					<td>상품설명</td>
					<td><input type="text" name="description" /></td>
				</tr>
				<tr>
					<td>상품가격</td>
					<td><input type="text" name="productprice" /></td>
				</tr>
			</table>
			<input type="reset" value="초기화"/><input type="submit" value="상품등록">			
		</form>
	</div>
</body>
</html>