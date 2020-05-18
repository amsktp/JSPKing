<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">.
<title>Insert title here</title>

<script type="text/javascript">
	
	function listPageMoveFnc(){
		
		location.href = '<%=request.getContextPath()%>/auth/login';
		
	}

</script>

</head>

<body>
	
	<p onclick="listPageMoveFnc();">329페이지 안녕하세요</p>

</body>
</html>