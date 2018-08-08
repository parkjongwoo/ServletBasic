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
<title>목록보기</title>
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
	<div class="container">
		<h3>메모 목록</h3>
		<table class="table table-bordered table-hover">
			<tr class="active">
				<th>순번</th>
				<th>메모번호</th>
				<th>이름</th>
				<th>나이</th>
				<th>수정</th>
			</tr>
			<c:forEach var="memo" items="${memoList}" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td>${memo.memoid}</td>
					<td>${memo.name}</td>
					<td>${memo.age}</td>
					<td>
						<a href="memo_detail?memoid=${memo.memoid}">상세보기</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<a href="memo_input_v1">새메모입력_유효성검사1</a>
		<a href="memo_input_v2">새메모입력_유효성검사2</a>
	</div>
</body>
</html>