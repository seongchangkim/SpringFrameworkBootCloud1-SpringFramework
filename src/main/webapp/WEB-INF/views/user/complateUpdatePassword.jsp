<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Completed Updated Password</title>
</head>
<body>
	<h4><%=request.getAttribute("name") %>님의 비밀번호를 정상적으로 변경되었습니다.</h4>
	<button onclick="location.href='/cloud/login'">로그인 하러 가기</button>
</body>
</html>