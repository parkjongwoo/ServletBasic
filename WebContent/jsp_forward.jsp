<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>페이지 포워딩</title>
</head>
<body>
아래에 있는 포워딩 태그로 인해 페이지가 이동됩니다. 이 문장은 볼 수 없습니다.
<jsp:forward page="jsp_scriptlet.jsp">
<jsp:param value="페이지가 jsp_forward.jsp으로부터 이동되었습니다." name="testParam"/>
</jsp:forward>
</body>
</html>