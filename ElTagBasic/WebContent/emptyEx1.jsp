<%@page import="tg.com.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Empty 연산자</title>
</head>

<%

	pageContext.setAttribute("title", "EL 연산자!");
	pageContext.setAttribute("titlTest", "");

	UserVo userVo = new UserVo(100, "홍길동", "test@test.com");
	UserVo userVo2 = new UserVo(10, "이찬양", "teㄷㄷㄷst@test.com");
	session.setAttribute("userVo", userVo);
	request.setAttribute("userVo", userVo2);
%>

<!-- 
	empty는 값이 비어 있거나 null인지를 조사할 때 사용하는 연산자이다
	값이 null이면 true를 반환한다.
	또한 문자열과 배열, Map, List 객체의 크기가 0인 경우에도
	true를 반환한다.
	그 이외에는 false를 반환한다.
 -->

<body>

	${empty title}		<br/>
	${empty title2}		<br/>
	${empty titleTest}	<br/><br/><br/>
	
	
	${sessionScope.userVo}<br/>
	${userVo}<br/><br/><br/><br/>
	
	
	${empty sessionScope.userVo}	<br/>
	${empty userVo}	<br/>
	${empty userVo2}	<br/>

</body>
</html>