<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="com.mvc.repository.ClassInfoRepository"%>
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
		List<Map<String, String>> classList = (List<Map<String, String>>) request.getAttribute("classList");
		for (Map<String, String> map : classList) {
		%>
		<tr>
			<td><%=map.get("CI_NUM") %></td>
			<td><a href="<%=root%>/class-info/view?ciNum=<%=map.get("CI_NUM") %>"><%=map.get("CI_NAME") %></a></td>
			<td><%=map.get("CI_DESC") %></td>
		</tr>
		<%
		}
		%>

	</table>
</body>
</html>