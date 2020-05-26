<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>리터럴 표현식</title>
</head>

<body>
	
	<c:set var="name" value="이찬양" />
	<c:set var="age" value="25" />

	자신의 이름<br>
	자신의 나이를 변수로 만들어서 출력하시오<br><br>
	
	이름 : ${name}<br>
	나이 : ${age}<br>
</body>
</html>