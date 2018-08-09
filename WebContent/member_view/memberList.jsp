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
<title>회원목록</title>
</head>
<body>
	<div class="container">
		<table class="table table-bordered table-hover">
			<tr class="active">
				<th>번호</th>
				<th>아이디</th>
				<th>상세보기</th>
			</tr>
			<c:forEach var="member" items="${memberList}" varStatus="status">
				<tr>
					<th>${status.count}</th>
					<th>${member.memberid}</th>
					<th><a href="memberDetail?memberid=${member.memberid}">상세보기</a></th>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>