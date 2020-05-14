<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

	window.onload = function() {
		
		var divObj = document.getElementById('numTable');

		var trLength = 5;
		
		var tableObj = document.createElement('table');
		tableObj.style.border = '1px solid black';
		tableObj.style.borderCollapse = 'collapse';
		
		var trObjList = [];
		
		trObjList[0] = document.createElement('tr');
		var tdObj = document.createElement('td');
		
		trObjList[0].appendChild(tdObj);
		tableObj.appendChild(trObjList[0]);
		
		for (var i = 1; i < trLength; i++) {
			trObjList[i] = trObjList[0].cloneNode(true);
			tableObj.appendChild(trObjList[i]);
		}

		
		for (var i = 0; i < trLength; i++) {
			trObjList[i].children[0].innerHTML = i+1;
		}
// 		alert(tableObj.children[0].children[0].innerHTML);

		divObj.appendChild(tableObj);
	
	}

</script>

</head>
<body>

	<div id='numTable'></div>

	<!-- 	<table style="border: 1px solid black; border-collapse: collapse;"> -->
	<!-- 		<tr><td>1</td></tr> -->
	<!-- 		<tr><td>2</td></tr> -->
	<!-- 		<tr><td>3</td></tr> -->
	<!-- 		<tr><td>4</td></tr> -->
	<!-- 	</table> -->

</body>
</html>