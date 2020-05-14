<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">

	#bigDivObj span {
		border: 1px solid black;
	}

</style>

<script type="text/javascript">

	window.onload = function() {
		
		var bigDivObj = document.getElementById('bigDivObj');

		var divLength = 4;
		var spanLength = divLength * 2;
		
		var divObjList = [];
		for (var i = 0; i < divLength; i++) {
			divObjList[i] = document.createElement('div');
		}
		
		var spanObjList = [];
		for (var i = 0; i < spanLength; i++) {
			spanObjList[i] = document.createElement('span');		
		}
		
		for (var i = 0; i < spanLength; i++) {
			spanObjList[i].innerHTML = (parseInt(i/2) + 1);
		}
		
		for (var i = 0; i < spanLength; i++) {
			divObjList[parseInt(i/2)].appendChild(spanObjList[i]);
		}
		
		for (var i = 0; i < divLength; i++) {
			bigDivObj.appendChild(divObjList[i]);
		}
		
	}

</script>

</head>
<body>

	<div id='bigDivObj' style="border: 1px solid black; width: 30px">

<!-- 		<div> -->
<!-- 			<span style="border: 1px solid black;">1</span><span>1</span> -->
<!-- 		</div> -->
<!-- 		<div> -->
<!-- 			<span>2</span><span>2</span> -->
<!-- 		</div> -->
<!-- 		<div> -->
<!-- 			<span>3</span><span>3</span> -->
<!-- 		</div> -->
<!-- 		<div> -->
<!-- 			<span>4</span><span>4</span> -->
<!-- 		</div> -->

	</div>

</body>
</html>