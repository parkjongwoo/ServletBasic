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
<title>회원가입</title>
</head>
<body>
	<div class="container">
		<form action="memberInput" method="post">
			<div class="page-header">
				<h1>회원가입</h1>
			</div>
			<div class="form-group form-group-lg">
				<label class="col-sm-2 control-label" for="memberid">아이디:</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" name="memberid" value="${memberForm.memberid}"
						id="memberid"><a href="idcheck?memberid=${memberForm.memberid}">중복체크</a> <span class="help-block text-danger">${errors.memberidError}</span>
				</div>
			</div>
			<div class="form-group form-group-lg">
				<label class="col-sm-2 control-label" for="password1">비밀번호:</label>
				<div class="col-sm-10">
					<input class="form-control" type="password" name="pw1"
						id="password1"> <span class="help-block text-danger">${errors.pw1Error}</span>
				</div>
			</div>
			<div class="form-group form-group-lg">
				<label class="col-sm-2 control-label" for="password2">비밀번호확인:</label>
				<div class="col-sm-10">
					<input class="form-control" type="password" name="pw2" id="password2">
				</div>
			</div>
			<div class="form-group page-header">
				<h3>필수정보</h3>
			</div>
			<div class="form-group form-group-lg">
				<label class="col-sm-2 control-label" for="name">이름:</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" name="name" id="name" value="${memberForm.name}">
					<span class="help-block text-danger">${errors.nameError}</span>
				</div>
			</div>
			<div class="form-group form-group-lg">
				<label class="col-sm-2 control-label">성별:</label>
				<div class="col-sm-10">
				<c:choose>
			    <c:when test="${memberForm.gender eq '여자'}">
			        <label ><input type="radio" name="gender" id="gender1" value="남자">남자</label> 
					<label ><input type="radio" name="gender" id="gender2" checked="checked" value="여자" >여자</label>	
			    </c:when>
			    <c:otherwise>
	        		<label ><input type="radio" name="gender" id="gender1" checked="checked" value="남자">남자</label> 
					<label ><input type="radio" name="gender" id="gender2"  value="여자" >여자</label>	
    			</c:otherwise>			    
				</c:choose>					
				</div>
			</div>
			<div class="form-group form-group-lg">
				<label class="col-sm-2 control-label" for="email">이메일:</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" name="email" id="email" value="${memberForm.email}">
					<span class="help-block text-danger">${errors.emailError}</span>
				</div>
			</div>
			<input class="col-sm-12 btn btn-default input-lg" type="submit"
				value="가입하기">
		</form>
	</div>
</body>
</html>