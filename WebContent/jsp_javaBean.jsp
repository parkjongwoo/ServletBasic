<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 자바빈 사용 --%>
	<jsp:useBean id="today" class="java.util.Date"></jsp:useBean><%-- 지역변수로 객체 등록됨 --%>
	<jsp:useBean id="empPark" class="goott.three.Employ"></jsp:useBean>
	<jsp:setProperty name="empPark" property="id" value="3398"/><%-- 값을 지정할때 setProperty --%>
	<jsp:setProperty name="empPark" property="firstName" value="jongwoo"/>
	<jsp:setProperty name="empPark" property="lastName" value="park"/>
	<jsp:getProperty name="empPark" property="lastName"/><%-- 값을 가져올때 getProperty. 해당값을 html에 표시하게 됨 --%>
	오늘은 <%= today.toString() %><br>
	고용인 정보는 <br>
	<%= empPark.toString() %>
</body>
</html>