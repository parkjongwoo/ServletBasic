<%@page import="java.util.Map"%>
<%@page import="el.model.Employ"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Employ myEmp = (Employ) request.getAttribute("info_emp");
		Map<String, String> myMap = (Map<String, String>) request.getAttribute("string_map");
	%>
	입력된 사원 정보는 아래와 같습니다.<br>
	<%=myEmp.toString()%><br><%-- 스크립틀릿 표현식 --%>
	${info_emp.toString()}<br><br><%-- el표현식. 각 스코프별(page,request,session,application) 저장객체를 검색하여 사용. 작은 스코프에서 큰 스코프 순으로 검색 --%>

	각속성접근<br> 
	스크립틀릿 사용<br> 
	도시:<%=myEmp.getAddress().getCity()%><br><%-- 스크립틀릿 표현식 --%>


	도시: ${info_emp.address.city }<br><%-- el 표현식 --%>
	대괄호 접근 도시: ${info_emp["address"]["city"] }<br><br> 
	
	String map 사용<br> 
	china키 출력:<%=myMap.get("china")%><br>	<%-- 스크립틀릿 표현식 --%>
	korea키 출력:<%=myMap.get("korea")%><br>	<%-- 스크립틀릿 표현식 --%>
	japan키 출력:<%=myMap.get("japan")%><br>	<%-- 스크립틀릿 표현식 --%>

	china키 출력: ${string_map.china}<br> <%-- Map<String,String>객체는 객체명.키이름 으로 밸류 접근가능 --%>
	korea키 출력: ${string_map.korea }<br>
	japan키 출력: ${string_map.japan }<br>
	
	객체 map 사용<br>
	one키 출력:${emp_map.one.name}<br>
	two키 출력:${emp_map.two.name}<br><br>
	
	Array 사용<br>
	0 출력:${emp_arr[0]}<br>
	1 출력:${emp_arr[1]}<br><br>
	
	List 사용<br>
	0 출력:${emp_list[0]}<br>
	1 출력:${emp_list[1]}<br><br>
	
	
	jstl c:forEach List iteration <br>	
	<c:forEach var="emp" items="${emp_list}" varStatus="idx" begin="0">
		no:${idx.count}&nbsp;
		name:${emp.name}&nbsp;
		empno:${emp.id}&nbsp;
		city:${emp.address.city}&nbsp;
		street:${emp.address.streetName}&nbsp;
		country:${emp.address.country}<br>
	</c:forEach>
	<br>
	
	jstl c:forEach Map iteration <br>	
	<c:forEach var="emp_map_entry" items="${emp_map}" varStatus="idx" begin="0">
		no:${idx.count}&nbsp;
		name:${emp_map_entry.value.name}&nbsp;
		empno:${emp_map_entry.value.id}&nbsp;
		city:${emp_map_entry.value.address.city}&nbsp;
		street:${emp_map_entry.value.address.streetName}&nbsp;
		country:${emp_map_entry.value.address.country}<br>
	</c:forEach>
	<br><br>
	
	<%
	request.setAttribute("j", 30);//스크립틀릿 request scope 변수 지정	
	%>
	<c:set var="s" value="20" scope="request"/><%-- jstl request scope 변수지정 --%>	
	k:${requestScope.k=10},<%-- el에서 값 지정 가능. 하지만 바로 html로 변환됨 --%>

	j:${j},s:${s}
	<h3>연산자</h3>
	\${j+s} : ${j+s}
	\${j%s} : ${j%s}
	\${j-s} : ${j-s}
	\${j/k} : ${j/k}<br>
	
	\${j>=k && j>=s} : ${j>=k && j>=s}<br>	
	\${j>=k || j>=s} : ${j>=k || j>=s}<br>
	
	\${j>=k?j:k} : ${j>=k?j:k}<br>
	
	<h3>ppp 선언하지 않은 attribute의 null체크</h3>
	<span>empty ppp 사용</span>${empty ppp}<br>
	<span>ppp!=null 사용</span>${ppp==null}<br>
	
</body>
</html>