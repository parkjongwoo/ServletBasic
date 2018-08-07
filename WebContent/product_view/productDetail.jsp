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
<script type="text/javascript">
	function requestUpdate(){
		$("#form").submit();
	}	
</script>
</head>
<body>
	<div class="container">
		<h3>제품상세정보</h3>
		<form action="productUpdate" method="post" id="form">
		<input type="hidden" name="productid" value="${product.productid}"/>
			<table class="table table-bordered table-hover">
				<tr class="active">
					<th colspan="2">상품등록</th>
				</tr>
				<tr>
					<td>상품명</td>
					<td><input type="text" name="productname" value="${product.productname}"/></td>
				</tr>
				<tr>
					<td>상품설명</td>
					<td><input type="text" name="description" value="${product.description}"/></td>
				</tr>
				<tr>
					<td>상품가격</td>
					<td><input type="text" name="productprice" value="${product.productprice}"/></td>
				</tr>
			</table>
			<a href="javascript:requestUpdate()">수정</a> | <a href="productDelete?productid=${product.productid}">삭제</a>
		</form>
	</div>
</body>
</html>