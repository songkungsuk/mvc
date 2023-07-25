<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	view
	<form action="/user-info/delete" method="post">
	<input type="hidden" name="uiNum" value="${user.UI_NUM}">
	<table border="1">
		<tr>
			<td>번호</td>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이름</td>
		</tr>
		<tr>
			<td>${user.UI_NUM }</td>
			<td>${user.UI_ID }</td>
			<td>${user.UI_PWD }</td>
			<td>${user.UI_NAME }</td>
		</tr>
		<tr>
			<th colspan="2">
				<button onclick="location.href='/user-info/update?uiNum=${user.UI_NUM}'" type="button">수정</button>
				<button>삭제</button>
			</th>
		</tr>

	</table>
	</form>
</body>
</html>