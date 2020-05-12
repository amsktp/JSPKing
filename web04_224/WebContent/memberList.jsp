<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<title>회원목록</title>
</head>
<body>
	<h1>회원목록</h1>
	<p>
		<a href='./add'>신규 회원</a>
	</p>
	<form action='./list' method='post'>
		1,<a href='./update?mNo=1'>이찬양</a>,s1@test.com,2020-05-06
		<input type='hidden' name='mNo' value='1'><input type='submit' value='회원탈퇴'>
		
	</form>
	<br>
</body>
</html>
