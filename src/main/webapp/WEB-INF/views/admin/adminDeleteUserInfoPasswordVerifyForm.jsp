<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page import="org.springframework.security.core.Authentication" %>
<%
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	Object principal = auth.getPrincipal();
	
	String id = "";
	if(principal != null){
		id = auth.getName();
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>회원 삭제 비밀번호 확인</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/loginstyle.css"/>">
</head>
<body>
	<script>
		window.onload = function(){
			var deleteUserInfoPasswordVerify = document.deleteUserInfoPasswordVerifyForm;
			deleteUserInfoPasswordVerify.onsubmit = function(){
				if(!deleteUserInfoPasswordVerify.pw.value){
					alert('비밀번호를 입력하세요!');
					deleteUserInfoPasswordVerifyForm.pw.focus();
					return false;
				}
			}
		}
	</script>
	<div class="deleteUserInfoPasswordVerifyForm">
		<form action="/cloud/admin/deleteUserInfoPasswordVerify" method="post" name="deleteUserInfoPasswordVerifyForm">
			<input type="hidden" name="id" value="<%=id %>">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"> 
			
			<h2>비밀번호 확인</h2>
			<div class="passForm">
				<input type="password" name="password" id="pw" placeholder="비밀번호">
			</div>
			
			<input type="submit" class="btn" value="비밀번호 확인">
		</form>
		<button onclick="javascript=history.back();" class="btn2">이전 페이지</button>
	</div>
</body>
</html>