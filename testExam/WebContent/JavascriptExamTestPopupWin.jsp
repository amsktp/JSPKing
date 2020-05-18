<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script type="text/javascript" src="./JavascriptExamTestPopupWinAnswer.js"></script>

<script type="text/javascript">

	function childWinClose() {
		
		
	}

	function sendParent() {
		
		
		
		
	}


</script>

<style type="text/css">
img {
	width: 300px;
	height: 300px;
}

#rootContainer {
    margin: auto;
    width: 250px;
    border: 3px solid green;
    padding: 10px;
}
</style>
</head>
<body>
	<div id='rootContainer'>
		
		<form action="./JavascriptTest.jsp" method="post">
			<input type="text" id='childInfo' value="부모창에서 전송 버튼을 클릭" size="30px">
			<input type="button" value="부모창 정보 전달" onclick="sendParent();">
			<input type="button" value="확인" onclick="childWinClose();">
		</form>
	</div>
	
	<input type="hidden" id='parentTagSelectId'>
	<input type="hidden" id='availableVal'>
</body>
</html>