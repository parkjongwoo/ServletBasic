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
<title>첫페이지</title>
<script type="text/javascript">
$(document).ready(function(){
	msg = "${message}";
	if(msg.trim().length>0){
		alert(msg);
	}
})
</script>
</head>
<body>
	<c:if test="${empty sessionScope.member}">
		<a href="memberForm">회원가입</a>
		<a href="loginForm">로그인</a>
	</c:if>
	<c:if test="${not empty sessionScope.member}">
		<a href="memberDetail">회원정보변경</a>
		<a href="logout">로그아웃</a>
	</c:if>
</body>
</html>