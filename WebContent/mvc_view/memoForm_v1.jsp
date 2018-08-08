<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>메모등록</title>
<script type="text/javascript">
<%--$(document).ready(function(){
	<c:forEach var="error" items="${errors}">
		alert("${error}");
	</c:forEach>
})--%>
</script>
</head>
<body>
	<div class="container">
		<form method="post" action="memo_save_v1">
		<h3>메모입력</h3>
			<table class="table table-hover table-bordered">
				<tr>
					<td><label>이름</label></td>
					<td><input type="text" name="name" value="${memoForm.name}"/></td>
				</tr>
				<tr>
					<td><label>나이</label></td>
					<td><input type="text" name="age" value="${memoForm.age}"/></td>
				</tr>								
			</table>			
			<input type="reset" value="초기화" />
			<input type="submit" value="보내기" />
			<c:forEach var="error" items="${errors}">
				${error}
			</c:forEach>		
		</form>
	</div>
</body>
</html>