<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder"  %>
<%@ page import="org.springframework.security.core.Authentication" %>
<%
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	Object principal = auth.getPrincipal();
	
	String name="";
	if(principal != null){
		name = auth.getName();
	}
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>main page</title>
</head>
<body>
	<div>
		<sec:authorize access="hasRole('ROLE_USER')">
			환영합니다. <%=name %>님 
		</sec:authorize>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			여기는 관리자 페이지입니다. 
		</sec:authorize>
		<form action="/logout" method="post">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			<button>로그아웃</button>
		</form>
		<button onclick="location.href='/cloud/updateUserInfoPasswordVerity'">회원 정보 수정</button>
	</div>
</body>
</html>