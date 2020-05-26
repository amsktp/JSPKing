<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>parseDate</title>
</head>

<%

	Date date = new Date();

	String dateObj = String.valueOf(date);

	System.out.print(dateObj);
	
	application.setAttribute("dateObj", dateObj);
	application.setAttribute("date1", date);

	
%>

<body>
	
	<fmt:setLocale value="ENGLISH"/>

<%-- 	<fmt:parseDate var="date2" value="${dateObj}" pattern="EEE MMM dd HH:mm:ss z yyyy"/> --%>
	
<%-- 	${date2} --%>

	<fmt:formatDate value="${date1}"  pattern="EEE MMM dd HH:mm:ss z yyyy"/><br>

<!-- 	화 5월 19 11:19:00 KST 2020<br> -->
	
<!-- 	Tue May 19 11:18:46 KST 2020 -->
</body>
</html>