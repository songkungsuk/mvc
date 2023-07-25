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
	<table border="1">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>장르</td>
			<td>조회수</td>
		</tr>
		<c:forEach items="${movies}" var="movie">
			<tr>
				<td>${movie.MI_NUM}</td>
				<td><a href="/movie-info/view?miNum=${movie.MI_NUM}">${movie.MI_TITLE}</a></td>
				<td>${movie.MI_GENRE}</td>
				<td>${movie.MI_CNT}</td>
			<tr>
		</c:forEach>
		<tr><td><button onclick="location.href='/movie-info/insert'">추가</button></td></tr>
	</table>
</body>
</html>