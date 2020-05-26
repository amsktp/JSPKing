<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>c:out 태그</title>
</head>

<body>

	<c:out value="출력할 값"/><br/>
	<c:out value="출력할 값">기본 값</c:out><br/>
	<c:out value="${null}">반가워요</c:out><br/>
	<c:out value="안녕하세요">반가워요</c:out><br/>
	<c:out value="${null}"/><br/>

</body>
</html>