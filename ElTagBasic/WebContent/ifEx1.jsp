<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>if 속성 값이 참이면 컨텐츠 실행</title>
</head>




<!-- scope의 기본값은 page이다 -->

<body>

<%-- 	<c:if test="조건" var="변수명" scopt="보관소 4가지">
		컨텐츠(수행할 문장들)
	</c:if> --%>

	<c:if test="${10 > 20}" var="result">
		1: 10은 20보다 크다<br>
	</c:if>
	${result}<br>
	
	<c:if test="${10 < 20}" var="result2">
		2: 10은 20보다 크다
	</c:if>		
	${result2}<br>
	
</body>
</html>