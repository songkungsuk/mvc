<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">
	function changeOp(obj) {
		var action = '/calc/ + obj.value';
		alert(action);	
		document.getElementById('frm').action = action;
	}
	</script>
</head>
<body>
<h1>두수를 더하기</h1>
	<form id="frm" action="<%=root%>/calc/result">
		<input type="text" name="num1"> 
		<select onchange="changeOp(this))">
			<option value="p" selected>더하기</option>
			<option value="s">빼기</option>
			<option value="m" >곱하기</option>
			<option value="d">나누기</option>
		</select>
		<input type="text" name="num2"><br>
		<button onclick="location.href='<%=root%>/calc/result'">제출</button>
	</form>

</body>
</html>