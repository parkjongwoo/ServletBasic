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
	<form action="memberInput" method="post">
		<div class="page-header">
			<h1>로그인</h1>
		</div>
		<div class="form-group form-group-lg">
			<label class="col-sm-2 control-label" for="memberid">아이디:</label>
			<div class="col-sm-10">
				<input class="form-control" type="text" name="memberid"
					value="${memberForm.memberid}" id="memberid"> <span
					class="help-block text-danger">${errors.memberidError}</span>
			</div>
		</div>
		<div class="form-group form-group-lg">
			<label class="col-sm-2 control-label" for="password">비밀번호:</label>
			<div class="col-sm-10">
				<input class="form-control" type="password" name="password"
					value="" id="memberid"> <span
					class="help-block text-danger">${errors.memberidError}</span>
			</div>
		</div>
	</form>
</body>
</html>