<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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

<title>파일전송</title>
</head>
<body>
	<div class="container">
		<h3>업로드할 파일을 선택하세요.</h3>
		<form class="" method="post" action="singleUpload"
			enctype="multipart/form-data"><!--  -->
			<div class="form-group">
				<label>작성자: </label> <input type="text" name="author" />
			</div>
			<div class="form-group">
				<label>업로드파일: </label> <input type="file" name="file_url"  />
			</div>
			<input type="submit" value="보내기"/> 			
		</form>
	</div>
</body>
</html>