<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>사계절</title>
</head>

<body>
	
	<c:set var="season" value="2" />

	<c:choose>
		<c:when test="${season <= 0}">
			다시입력해주세요<br>
		</c:when>
		
		<c:when test="${season <= 2}">
			겨울입니다<br>
		</c:when>
		
		<c:when test="${season <= 5}">
			봄입니다<br>
		</c:when>
		
		<c:when test="${season <= 8}">
			여름입니다<br>
		</c:when>
		
		<c:when test="${season <= 11}">
			가을입니다<br>
		</c:when>
		
		<c:when test="${season <= 12}">
			겨울입니다<br>
		</c:when>
	
		<c:otherwise>
			다시입력해주세요<br>
		</c:otherwise>
	
	</c:choose>
	
	
	
</body>
</html>