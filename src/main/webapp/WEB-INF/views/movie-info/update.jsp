<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/movie-info/update" method="post">
<input type="hidden" name="MI_NUM" value="${movie.MI_NUM }">
<input type="text" name="MI_TITLE" placeholder="제목" value="${movie.MI_TITLE }">
<input type="text" name="MI_DESC" placeholder="설명" value="${movie.MI_DESC }">
<input type="text" name="MI_GENRE" placeholder="장르" value="${movie.MI_GENRE }">
<button>확인</button>
</form>
</body>
</html>