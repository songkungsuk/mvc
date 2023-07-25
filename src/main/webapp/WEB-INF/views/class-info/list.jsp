<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="com.mvc.repository.ClassInfoRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/common.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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


		<c:forEach items="${classList}" var="classinfo">
			<tr>
				<td>${classinfo.CI_NUM }</td>
				<td>${classinfo.CI_NAME }</td>
				<td>${classinfo.CI_DESC }</td>
			</tr>
		</c:forEach>

<tr><td><button onclick="location.href='/class-info/insert'">신규 학생 등록</button></td></tr>
	</table>
</body>
</html>