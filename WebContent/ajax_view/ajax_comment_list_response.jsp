<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<?xml version="1.0" encoding="UTF-8"?>
<root>
	<c:forEach var="comment" items="${commentList}" varStatus="status" begin="0" >
		<comment>
			<num>${comment.num}</num>
			<writer>${comment.writer}</writer>
			<content>${comment.content}</content>
			<datetime>${comment.datetime}</datetime>
		</comment>
	</c:forEach>
</root>