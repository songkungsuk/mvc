<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
회원등록
<form action="/user-info/insert" method="post">
<input type="text" name="uiId" placeholder="아이디"><br>
<input type="text" name="uiPwd" placeholder="비밀번호"><br>
<input type="text" name="uiName" placeholder="이름"><br>
<button>등록</button>
</form>
</body>
</html>