<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">

	table {
		border-collapse: collapse;
	}

	table,tr,td {
		border: 1px solid black; 
	}


</style>

<script type="text/javascript">

	var tableObj = '';

	function infoFnc() {
		
		var idDivObj = document.getElementById('idDiv');
		var pwdDivObj = document.getElementById('pwdDiv');
		var tableDivObj = document.getElementById('tableDiv');
		
		var idText = idDivObj.value;
		var pwdText = pwdDivObj.value;
		
		if(tableObj == ''){
			
			tableObj = document.createElement('table');
		
			var trObj = '';
			var trLength = 2;
			
			var tdObj = '';
			var tdLength = 2;
			
			for (var i = 0; i < trLength; i++) {
				trObj = document.createElement('tr');
				
				for (var n = 0; n < tdLength; n++) {
					tdObj = document.createElement('td');
					trObj.appendChild(tdObj);
				}
				tableObj.appendChild(trObj);
			}
		}
		
// 		var tdObjList = tableObj.getElementsByTagName('td');
		
// 		tdObjList[0].innerHTML = '이름';
// 		tdObjList[1].innerHTML = idText;
// 		tdObjList[2].innerHTML = '별명';
// 		tdObjList[3].innerHTML = pwdText;

//		위에는 안좋은 태그

		var trObjList = tableObj.children;

		trObjList[0].children[0].innerHTML = '이름';
		trObjList[0].children[1].innerHTML = idText;
		trObjList[1].children[0].innerHTML = '별명';
		trObjList[1].children[1].innerHTML = pwdText;
		
		tableDivObj.appendChild(tableObj)
	}
	
	
	
</script>

</head>
<body>

	<div>
		이름 : <input id='idDiv' type="text" value="">
	</div>

	<div>
		별명: <input id='pwdDiv' type="text" value="">
	</div>

	<div id='tableDiv'>
	
<!-- 		<table style="border: 1px solid black; border-collapse: collapse;"> -->
<!-- 			<tr  style="border: 1px solid black;"> -->
<!-- 				<td style="border: 1px solid black;">이름</td> -->
<!-- 				<td style="border: 1px solid black;">박성욱</td> -->
<!-- 			</tr> -->

<!-- 			<tr style="border: 1px solid black;"> -->
<!-- 				<td style="border: 1px solid black;">별명</td> -->
<!-- 				<td style="border: 1px solid black;">교수님</td> -->
<!-- 			</tr> -->
<!-- 		</table> -->
	
	</div>
	
	<button onclick="infoFnc()">날 누르면 테이블이 만들어져</button>
</body>
</html>