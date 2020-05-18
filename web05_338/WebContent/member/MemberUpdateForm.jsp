<%@page import="spms.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보</title>

</head>
	
<body>

	<jsp:include page="/Header.jsp"/>

	<h1>회원정보</h1>

	<form action='./update' method='post'>

		번호: <input type='text' name='no' value='${memberDto.no}' readonly='readonly'><br/>
		이름: <input type='text' name='name' value='${memberDto.name}'><br/>
		이메일: <input type='text' name='email' value='${memberDto.email}'><br/>
		가입일: ${requestScope.memberDto.createDate}<br>
		<input type='submit' value='저장'>
		<input type='button' value='삭제' onclick='location.href="./delete?no=${memberDto.no}"'>
		<input type='button' value='취소' onclick='location.href="./list"'>

	</form>

	로그인 한 사람: ${sessionScope.memberDto.name}
	
	<jsp:include page="/Tail.jsp"/>
</body>
</html>