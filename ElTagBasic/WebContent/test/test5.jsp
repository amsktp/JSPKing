<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>사계절</title>
</head>

<%

	ArrayList<String> teamList = new ArrayList();	
	
	teamList.add("류제건");
	teamList.add("이찬양");
	teamList.add("정의광");
	teamList.add("박지훈");
	teamList.add("양우진");

	pageContext.setAttribute("teamList", teamList);
%>



<body>
	
	<c:forEach var="team" items="${teamList}">
	
		<div style="border:1px solid black;">
			${team}
		</div>

	</c:forEach>

	<br><br>
	
	
	
</body>
</html>