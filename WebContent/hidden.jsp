<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>form hidden usage</title>
</head>
<body>
	<h2>form hidden usage</h2>
	<form action="showInfo" method="post">
		<input type="hidden" name="id" value="3001"/>
		이름<input type="text" name="name"/>
		<input type="submit" value="전송"/>
	</form>
	
	hidden:${id}<br>
	이름:${name}
</body>
</html>