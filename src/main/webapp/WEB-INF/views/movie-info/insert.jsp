<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/movie-info/insert" method="post">
<input type="text" name="MI_TITLE" placeholder="제목">
<input type="text" name="MI_DESC" placeholder="설명">
<input type="text" name="MI_GENRE" placeholder="장르">
<button>확인</button>
</form>
</body>
</html>