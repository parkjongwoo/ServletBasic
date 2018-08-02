<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jstl usage</title>
<style type="text/css">
	table,tr,td {
		border-collapse: collapse;	
		border: solid 1px black; 
	}
</style>
</head>
<body>
	<h3>foreach 사용예</h3>

	<table >
		<tr>
			<th>과목</th>
		</tr>
		<c:forEach var="subject" items="${subjects}" begin="1" varStatus="status">
			<tr><td>${status.count}:${subject}</td></tr>
		</c:forEach>
	</table>
	
	<table >
		<tr>
			<th>과목</th>
			<c:forEach var="subject" items="${subjects}" begin="1" varStatus="status">
				<td>${status.count}:${subject}</td>
			</c:forEach>
		</tr>		
	</table>
</body>
</html>