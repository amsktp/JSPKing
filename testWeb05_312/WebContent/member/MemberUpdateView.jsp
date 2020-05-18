<%@page import="spms.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보</title>

</head>
	
<%
	MemberDto memberDto = (MemberDto) request.getAttribute("memberDto");
%>

<body>

	<h1>회원정보</h1>

	<form action='./update' method='post'>

		번호: <input type='text' name='no' value='<%=memberDto.getNo()%>' readonly='readonly'><br/>
		이름: <input type='text' name='name' value='<%=memberDto.getName()%>'><br/>
		이메일: <input type='text' name='email' value='<%=memberDto.getEmail()%>'><br/>
		가입일: <%=memberDto.getCreateDate() %><br>
		<input type='submit' value='저장'>
		
		<input type='button' value='삭제' onclick='location.href="./delete?no=<%=memberDto.getNo()%>"'>
		
		<input type='button' value='취소' onclick='location.href="./list"'>

	</form>

</body>
</html>