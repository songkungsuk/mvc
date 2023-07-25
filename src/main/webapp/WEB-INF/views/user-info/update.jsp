<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
update
<form action="/user-info/update" method="post">
<input type="hidden" name="uiNum"  value="${user.UI_NUM}"><br>
<input type="text" name="uiId" placeholder="아이디" value="${user.UI_ID }"><br>
<input type="text" name="uiPwd" placeholder="비밀번호"><br>
<input type="text" name="uiName" placeholder="이름" value="${user.UI_NAME }"><br>
<button>등록</button>
</form>
</body>
</html>