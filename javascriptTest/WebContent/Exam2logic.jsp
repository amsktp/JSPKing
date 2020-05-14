<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	function firstEvent() {

		var firstDivObj = document.getElementById('firstDiv');
		var secondDivObj = document.getElementById('secondDiv');

		firstDivObj.appendChild(secondDivObj);
	}
</script>

</head>
<body>

	<div id='firstDiv' style="border: 10px solid red;">난 첫번째 div 야</div>
	<div id='secondDiv' style="border: 3px solid blue;">난 두번째 div 야</div>

	<button onclick="firstEvent();">날 누르면 관계 변겅</button>
	
	새로 생기는게 아니라 있던게 옮겨간다는 것
</body>
</html>