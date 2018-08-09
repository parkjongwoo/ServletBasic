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
		<form action="pwRecheck" method="post">
			<div class="page-header">
				<h1>비밀번호확인</h1>
			</div>
			<div class="form-group form-group-lg">
				<label class="col-sm-2 control-label" for="memberid">아이디:</label>
				<div class="col-sm-10">
					<p class="form-control-static">skyholds1</p><!-- 세션 저장 loginId로 교체 -->
					<input class="form-control" type="hidden" name="memberid" id="memberid" value="skyholds1">
				</div>				
			</div>
			<div class="form-group form-group-lg">
				<label class="col-sm-2 control-label" for="pasword">비밀번호입력:</label>
				<div class="col-sm-10">
					<input class="form-control" type="password" name="pw" id="pasword">
				</div>
			</div>
			<div class="form-group form-group-lg">
				<input class="col-sm-12 btn btn-default input-lg" type="submit"
					value="비밀번호확인">
			</div>
		</form>
	</div>
</body>
</html>