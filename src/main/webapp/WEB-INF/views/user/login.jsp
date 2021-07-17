<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>login</title>
</head>
<body>
	<form action="/login" method="post">
		<label id="id">아이디 : </label>
		<input type="text" id="id" name="id">
		<br>
		
		<label id="password">비밀번호 : </label>
		<input type="password" id="password" name="password"/>
		<br>
		
		<input type="submit" value="로그인"/>
	</form>
	<button type="button" onclick="location.href='/register'">회원가입</button>
</body>
</html>