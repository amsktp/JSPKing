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
	
	<c:forEach var="" varStatus="indexVal" begin="1" end="6">
	
		<h${indexVal.index}>JSTL 예제 ${indexVal.index}</h${indexVal.index}>
<!-- 		태그 안에 EL태그는 절대 사용하지 않는다 -->

	</c:forEach>

	<br><br>
	
	<c:forEach varStatus="indexVal" begin="1" end="6">
	
		<h1>JSTL 예제 ${indexVal.index}</h1>
	
	</c:forEach>
	
	
	
</body>
</html>