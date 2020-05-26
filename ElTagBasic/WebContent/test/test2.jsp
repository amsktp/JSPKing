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

	<c:set var="partnerName" value="고재민" />
	<c:set var="partnerAge" value="44" />

	자신과 짝의 나이를 비교해서
	많은 사람의 이름을 출력하시오
	
<!-- 	단, 지훈 vs 성욱 -->
	
	<br><br><br>
	
	${name} vs ${partnerName} <br><br>
	
<!-- 	내가 나이 많을 때 -->
	<c:if test="${age > partnerAge}">
		${name}형
	</c:if>
	
<!-- 	짝이 나이 많을 때 -->
	<c:if test="${age < partnerAge}">
		${partnerName}형
	</c:if>
	
<!-- 	나이가 같을 때 -->
	<c:if test="${age == partnerAge}">
		친구
	</c:if>
	
	
</body>
</html>