<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>고용인 정보입력, 서블릿 사용 리스트 만들기</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<form action="jsp2servletTestServlet" method="post">
		거리:<input type="text" name="e_street"><br> 
		도시:<input type="text" name="e_city"><br> 
		국가:<input type="text" name="e_country"><br> 
		사원번호:<input type="text" name="e_empno"><br> 
		사원명:<input type="text" name="e_empname"><br> 
		<input type="submit" value="보내기">
	</form>
	<table class="table table-hover">
		<tr>
			<th>no</th><th>사원번호</th><th>사원명</th><th>주소.도로명</th><th>주소.도시</th><th>주소.국가</th>
		</tr>
		<c:forEach var="emp" items="${emps}" begin="0"
			varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td>${emp.empno}</td>
				<td>${emp.name}</td>
				<td>${emp.street}</td>
				<td>${emp.city}</td>
				<td>${emp.country}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>