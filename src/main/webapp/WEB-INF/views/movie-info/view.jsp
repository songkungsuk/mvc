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
<form action="/movie-info/delete?miNum= ${movie.MI_NUM}" method="post">
	<table border="1">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>내용</td>
			<td>장르</td>
			<td>제작일</td>
			<td>조회수</td>
		</tr>

		<tr>
			<td>${movie.MI_NUM}</td>
			<td>${movie.MI_TITLE}</td>
			<td>${movie.MI_DESC}</td>
			<td>${movie.MI_GENRE}</td>
			<td>${movie.MI_CREDAT}</td>
			<td>${movie.MI_CNT}</td>
		<tr>
		<tr>
		<td><button type="button" onclick="location.href='/movie-info/update?miNum=${movie.MI_NUM}'">수정</button></td>
		<td><button>삭제</button></td>
		</tr>
	</table>
	</form>
</body>
</html>