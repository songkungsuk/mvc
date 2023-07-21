<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%String root = request.getContextPath(); %>
	<h3>결과</h3>
	<h4>틀린횟수 <%=request.getAttribute("count")%></h4>
	<%if(request.getAttribute("correct") != null){
		out.println(request.getAttribute("correct"));
	}
	%>
	<button onclick="location.href='<%=root%>/find/find'">돌아가기</button>
</body>
</html>