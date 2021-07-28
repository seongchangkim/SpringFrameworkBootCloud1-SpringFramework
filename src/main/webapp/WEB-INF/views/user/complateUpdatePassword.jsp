<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Completed Updated Password</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/complateupdatepasswordprocessstyle.css"/>">
</head>
<body>
	<div class="complateUpdatePasswordForm">
		<h4><%=request.getAttribute("name")%>님의 비밀번호를 정상적으로 변경되었습니다.</h4>
		<button onclick="location.href='/cloud/login'" class="btn">로그인 하러 가기</button>
	</div>
</body>
</html>