<%@page import="java.util.Date"%><%-- 사용할 클래스 임포트 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page 
	session="true" 
	autoFlush="true" 
	info="jsp 테스트 페이지" 
	errorPage="error_page.jsp" 
	isErrorPage="false"
	trimDirectiveWhitespaces="false"
	isELIgnored="false"
	deferredSyntaxAllowedAsLiteral="true"%>
<%! //서블릿에 멤버 변수 및 메서드로 추가할때 ! 붙여 사용 
	public String getTodayDate(){
		return new Date().toString();
	
	}
	public int getLength(String s){
		return s.length();
	}
	public String memberString = "ghghgh";
%>
<%
	// page directive attribute 설명
	//contentType : response header의 contentType을 정의
	//pageEncoding : 
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>스크립틀릿 예제</title>
</head>
<body>
	<!-- 주석 html주석은 소스에 포함됩니다. 해석은 안됩니다.-->
	<%-- 첫번째스크립틀릿 주석 : 스크립틀릿 주석은 소스에 포함도 안되고 해석도 안됩니다.--%>
	<%//일반 코드 작성시 !없이 사용
		String message = "My first scriptlet";	
	%>
	<hr/>
	<%-- 두번째스크립틀릿 주석. 스크립틀릿에는 ;로 문장 마침이 필수 입니다. --%>
	<%
		out.print(message);	
	%>
	<%-- 
	jsp -> servlet으로 톰캣이 변경. 이 과정에 jsp에서 호출해서 사용가능한 객체가 추가되는데
	이중 하나인 out은 html코드로의 출력을 담당. --%>
	
	오늘은<%= getTodayDate() %>입니다.<!-- 표현식: 간단히 jsp에서 값을 html로 출력시 이퀄(=)을 첨가합니다. ;필요없음. -->
</body>
</html>