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

	<h1>회원목록</h1>
	<p>
		<a href='add'>신규회원</a>
	</p>

<!-- 	스크립틀렛, 릿(scriptlet) -->


<%-- <%
		ArrayList<MemberDto> memberList = 
			(ArrayList<MemberDto>)request.getAttribute("memberList");
%>  --%>

	<jsp:useBean
		id="memberList"  
 		scope="request"  
 		class="java.util.ArrayList" 
 		type="java.util.ArrayList<spms.dto.MemberDto>" 
 	/>	 
	
	<jsp:useBean 
		id="testActionTag"
		scope="request"
		class="spms.dto.MemberDto"
	/>	
	
	
	<jsp:setProperty
		property="password"
		name="testActionTag"
		value="amazing"
	/>
	
	<%
// 		확장 for문 (iterater 패턴이 적용된 for)

		System.out.println(testActionTag);
		
		for(MemberDto memberDto : memberList) {
	%>

	<%=memberDto.getNo()%>
	
	<a href='update?no=<%=memberDto.getNo()%>'>
		<%=memberDto.getName() %>
	</a>
	
	<jsp:getProperty property="password" name="testActionTag"/>
	<%=testActionTag.getPassword() %>
		
	<%=memberDto.getEmail() %>,

	<%=memberDto.getCreateDate() %>

	<a href='./delete?no=<%=memberDto.getNo()%>'>[삭제]</a>
	<br/>
	<%
		}
	%>
	
		<jsp:include page="/Tail.jsp"/>
	
</body>
</html>