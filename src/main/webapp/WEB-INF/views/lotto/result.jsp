<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>맞춘개수</h1>
	<h2><%=request.getAttribute("correct")%></h2>
	<%
	int correct = (int) request.getAttribute("correct");
	if (correct == 6) {
		out.print("<h1>축하합니다 전부 맞추셧습니다</h1>");
	}
	%>
	<br>
	<h1>로또번호</h1>
	<%
	List<String> lottonums = (List<String>) request.getAttribute("lotto_num");
	%>
	<table border="1" style="text-indent:30 px;">
		<tr>
			<%
			for (String str : lottonums) {
			%>
			<td>
				<%
				out.print(str);
				%>
			
			<td>
				<%
				}
				%>
			
		</tr>
	</table>
</body>
</html>