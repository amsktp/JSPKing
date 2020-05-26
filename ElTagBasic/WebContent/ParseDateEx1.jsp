<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>fmf:parseDate 날짜 형식으로 작성된 문자열을 분석하여 java.util.Date객체를 생성한다</title>
</head>

<body>
	
	<fmt:parseDate var="date" value="2020-05-19" pattern="yyyy-MM-dd"/>
	${date}<br>
	<fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/>
</body>
</html>