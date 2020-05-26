<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>forEach 반복적인 작업을 정의할 때</title>
</head>

<%
	List<String> nameList = new ArrayList<String>();

	nameList.add("홍길동");
	nameList.add("일지매");
	nameList.add("임꺽정");

	request.setAttribute("nameList", nameList);
%>


<body>
	
<%-- 	<c:forEach var="변수명" items="목록데이터"  --%>
<%-- 				begin="시작인덱스" end="종료인덱스" --%>
<%-- 				step="인덱스 간격" varStatus="인덱스 값"> --%>
<!-- 		내용들	 -->
<%-- 	</c:forEach> --%>

	<ul>
		<c:forEach var="name" items="${nameList}">
			<li>${name}</li>
		</c:forEach>
	</ul>
	
	<ol>
		<c:forEach var="name" items="${nameList}" begin="0" end="1">
			<li>${name}</li>
		</c:forEach>
	</ol>

	<div>
		<c:forEach var="name" items="${nameList}" varStatus="indexVal">
			<span>${indexVal.index}</span><span>${name}</span>
		</c:forEach>
	</div>>
	


</body>
</html>