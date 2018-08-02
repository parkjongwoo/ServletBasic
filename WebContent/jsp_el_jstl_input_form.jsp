<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>고용인 정보입력</title>
</head>
<body>
<form action="ElTestServlet" method="post">
	거리:<input type="text" name="e_street"><br>
	도시:<input type="text" name="e_city"><br>
	국가:<input type="text" name="e_country"><br>
	사원번호:<input type="text" name="e_empno"><br>
	사원명:<input type="text" name="e_empname"><br>
	<input type="submit" value="보내기">	
</form>
</body>
</html>