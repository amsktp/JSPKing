<%@page import="tg.com.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>산술 연산자</title>
</head>


<body>

	\${10+20} = ${10+20}			<br>
	\${10-20} = ${10-20}			<br>

	나누기 \${10 div 20} = ${10 div 20}	<br>
	\${10 / 20} = ${10 / 20}	<br>
	
	\${10 % 20} = ${10 % 20}	<br>
	\${10 mod 20} = ${10 mod 20}	<br><br><br>


	
</body>
</html>