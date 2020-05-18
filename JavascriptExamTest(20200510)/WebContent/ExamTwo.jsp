<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<style type="text/css">
table, tr, td {
	border: 1px solid black;
}

table {
	border-collapse: collapse;
	width: 210px;
}

</style>

<title>회원가입</title>

<script type="text/javascript">
	function registerFnc() {
		
	}
</script>
</head>
<body>

	<form action="#" method="post">
		<table id='userAccountTable'>
			<tr>
				<td>id</td>
				<td><input type="text" id='id' class='id' name="id" size="15"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" id='name' class='name' name="name" size="15"></td>
			</tr>
			<tr>
				<td>password</td>
				<td><input type="password" id='pwd' class='pwd' name="pwd" size="15"></td>
			</tr>
			<tr>
				<td>password확인</td>
				<td><input type="password" id='pwdChk' class='pwdChk' name="pwdChk" size="15"></td>
			</tr>
		</table>
	</form>
</body>
</html>