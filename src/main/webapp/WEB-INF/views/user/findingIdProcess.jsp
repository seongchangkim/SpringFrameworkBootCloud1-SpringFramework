<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Finding Id Process</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/idfindingprocessstyle.css"/>">
</head>
<body>
	<div class="findingIdProcess">
		<h4>${user.getName()}님,</h4> 
		아이디는 <b>${user.getId()}</b>입니다.
		<br>
		<br>
		<button onclick="location.href='/cloud/login'" class="btn">로그인하기</button>
		<button onclick="location.href='/cloud/findingPassword'" class="btn2">비밀번호 찾기</button>
	</div>
</body>
</html>