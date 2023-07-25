<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>설명</td>
		</tr>
		<%
		Map<String, String> map = (Map<String, String>) request.getAttribute("class");
		%>
		<tr>
			<td><%=map.get("CI_NUM")%></td>
			<td><%=map.get("CI_NAME")%></td>
			<td><%=map.get("CI_DESC")%></td>
		</tr>
		<%

		%>

	</table>
</body>
</html>