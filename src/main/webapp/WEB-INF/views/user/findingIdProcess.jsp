<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Finding Id Process</title>
</head>
<body>
	<div>
		<h4>${user.name}님, 아이디는 ${user.id}입니다.</h4>
		<br>
		<button onclick="location.href='/login'">로그인하기</button>
		<button onclick="location.href='/cloud/findingPassword'">비밀번호 찾기</button>
	</div>
</body>
</html>