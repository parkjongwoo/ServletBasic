<%@ page import="java.util.Date"%><%-- 외부 패키지 가져오기 --%>
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
	public String memberString = "ghghghdfgsd";
%>
<%
	// page directive attribute 설명
	//contentType : response header의 contentType을 정의
	//pageEncoding : ?? 톰캣에서 참조하는 현재 페이지의 캐릭터 인코딩 값. contentType의 charset은 브라우저에서 참조하는 페이지 인코딩 값.
	//session : 현재페이지를 세션관리 대상에 포함할지 여부. true면 현재 페이지에 세션을 생성한다. 기본값 true
	//autoFlush : 버퍼가 가득차면 응답을 자동으로 보냄. 기본값 true
	//errorPage : 서블릿 실행시 예외 발생하면 대신 표시할 페이지. 애러가 발생하면 표시된다.
	//isErrorPage : 이 페이지가 다른 페이지의 errorPage로 등록되어 있는지 여부. 기본값 false
	//trimDirectiveWhitespaces : 페이지의 공백문자를 제거. 페이지내 xml 등을 포함할 때 공백을 제거해야하는 경우 사용. 기본값 false
	//isELIgnored : el 문구를 무시할지 여부. 기본값 false
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
	
	오늘은<%=getTodayDate()%>입니다.<!-- 표현식: 간단히 jsp에서 값을 html로 출력시 이퀄(=)을 첨가합니다. ;필요없음. -->
	
	<p>${param.testParam} 이 testParam으로 전달 되었습니다</p>
</body>
</html>