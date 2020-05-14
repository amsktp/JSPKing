<%@page import="spms.dto.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록</title>

</head>
<body>

	<jsp:include page="/Header.jsp"/>

	<jsp:include page="/MyPage.jsp"/>

	<h1>회원목록</h1>
	
	<p>
		<a href='add'>신규회원</a>
	</p>

<!-- 	스크립틀렛, 릿(scriptlet) -->
	<%
		ArrayList<MemberDto> memberList = 
			(ArrayList<MemberDto>)request.getAttribute("memberList");
	
// 		확장 for문 (iterater 패턴이 적용된 for)
		for(MemberDto memberDto : memberList) {
	%>
	<%=memberDto.getNo()%>
	<a href='update?no=<%=memberDto.getNo()%>'>
		<%=memberDto.getName() %>
	</a>
	<%=memberDto.getEmail() %>,
	<%=memberDto.getCreateDate() %>
	<a href='delete?no=<%=memberDto.getNo()%>'>[삭제]</a>
	<br/>
	<%
		}
	%>
	
		<jsp:include page="/Tail.jsp"/>
	
</body>
</html>