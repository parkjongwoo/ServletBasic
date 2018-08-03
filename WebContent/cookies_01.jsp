<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>input your address</h2>
	<form method="post" action="setCookie">
		<input type="text" name="addr" /> <input type="submit" value="전송" />
	</form>
	<a href="delCookie">쿠키지우기</a>
	<c:if test="${!empty cookie}">
		<c:forEach var="c" items="${cookie}">
			${c.value.name}:${c.value.value}<br>			
		</c:forEach>
	</c:if>	
</body>
</html>