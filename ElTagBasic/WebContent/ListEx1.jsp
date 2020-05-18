<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>리터럴 표현식</title>
</head>

<%

	List<String> nameList = new ArrayList<String>();

	nameList.add("홍길동");
	nameList.add("일지매");
	nameList.add("임꺽정");

	request.setAttribute("nameList", nameList);
%>

<body>

	${nameList[2]};
</body>
</html>