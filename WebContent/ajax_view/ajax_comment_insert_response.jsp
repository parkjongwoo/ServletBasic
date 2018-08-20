<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<?xml version="1.0" encoding="UTF-8"?>
<root>
	<result>${result}</result>
	<c:choose>
		<c:when test="${result}">
	        <message>덧글이 등록되었습니다.</message>
	        <comment>
				<num>${insertedComment.num}</num>
				<writer>${insertedComment.writer}</writer>
				<content>${insertedComment.content}</content>
				<datetime>${insertedComment.datetime}</datetime>
			</comment>
	    </c:when>
		<c:otherwise>
	        <message>덧글 등록에 실패하였습니다.</message>
	    </c:otherwise>
    </c:choose>	
</root>