<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	list
	<table border="1">
		<tr>
			<td>번호</td>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이름</td>
		</tr>
		<c:forEach items="${userList}" var="user">
			<tr>
				<td>${user.UI_NUM }</td>
				<td><a href="/user-info/view?uiNum=${user.UI_NUM}">${user.UI_ID }</a></td>
				<td>${user.UI_PWD }</td>
				<td>${user.UI_NAME }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>