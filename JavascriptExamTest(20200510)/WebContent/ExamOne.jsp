<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	table, tr, td{
		border: 1px solid black;
	}
	
	
	
	
	
	
	
	
</style>

<title>개인 정보 등록하기</title>


</head>

<body>
	
	<form action="#" method="get">
		<table>
			<tr>
				<td>회&nbsp;사&nbsp;명</td>
				<td><input type="text" name="companyName"></td>
			</tr>
			<tr>
				<td>이&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;름</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>메&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일</td>
				<td><input type="text" name="mail" value=""></td>
			</tr>
			<tr>
				<td>주&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;소</td>
				<td><input type="text" name="addr"></td>
			</tr>
			<tr>
				<td>전&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;화</td>
				<td><input type="text" name="tel" maxlength="13"></td>
			</tr>
		</table>
		<input type="button" style="width: 100px;" value="명함 만들기" onclick="businessCardMakeFnc();">
	</form>
	
	<h2>명함</h2>
	<div id='businessCardDiv'>
		<div></div>
		<div></div>
		<div></div>
		<hr style="background-color: gray;">
		<div></div>
		<div></div>
	</div>
	
</body>

</html>