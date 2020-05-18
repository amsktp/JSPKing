<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>리터럴 표현식</title>
</head>

<%

	Map<String, String> nameMap = new HashMap<String, String>();
	
	nameMap.put("s01", "홍길동");
	nameMap.put("s02", "일지매");
	nameMap.put("s03", "카트린느");

	request.setAttribute("nameMap", nameMap);
	
%>

<body>

	${nameMap.get("s02")}
	${nameMap.get("s01")}
	${nameMap.s03}
</body>
</html>