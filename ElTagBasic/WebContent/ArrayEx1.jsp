<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>리터럴 표현식</title>
</head>

<%
	pageContext.setAttribute("scoreArr", new int[]{
			90, 80, 70, 100
	});

	pageContext.setAttribute("nameArr", new String[]{
		"이찬양", "류제건", "홍길동", "ㅁㄴㅇ"	
	});
%>

<body>

	${scoreArr[2]}
	${nameArr[2]}

</body>
</html>