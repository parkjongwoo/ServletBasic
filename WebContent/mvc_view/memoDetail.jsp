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
<title>상세보기</title>
<script type="text/javascript">
	function sendRequest(){
		var memoid = ${memo.memoid};
		var name = $("#name").val();
		var age = $("#age").val();
		
		location.href="memo_update?memoid="+memoid+"&name="+name+"&age="+age;
	}
</script>
</head>
<body>
	<div class="container">
		<h3>메모 상세</h3>
		<form>
			<table class="table table-bordered table-hover">
				<tr class="active">
					<th>속성명</th>
					<th>내용</th>
				<tr>
					<td>메모번호</td>
					<td>${memo.memoid}</td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" id="name" value="${memo.name}"/></td>
				</tr>
				<tr>
					<td>나이</td>
					<td><input type="text" id="age" value="${memo.age}"/></td>
				</tr>
			</table>			
		</form>		
		<a href="javascript:sendRequest()">수정</a>
		<a href="memo_delete?memoid=${memo.memoid}">삭제</a>
		<a href="memo_list">목록보기</a>
	</div>
</body>
</html>