<%@page import="tg.com.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>빈(Bean) 객체에서 값 꺼내기</title>
</head>

<%

// 	UserVo userVo = new UserVo(100, "홍길동", "hong@test.com");

	UserVo userVo = new UserVo(100, "홍길동", "hong@test.com");


	session.setAttribute("userVo", userVo);
	
%>

<body>

	${userVo.userNo}
	${userVo.userName}
	${userVo.userEmail}
	${userVo}

</body>
</html>