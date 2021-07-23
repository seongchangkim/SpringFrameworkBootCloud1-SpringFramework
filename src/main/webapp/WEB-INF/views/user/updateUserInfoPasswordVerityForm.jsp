<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="org.springframework.security.core.Authentication" %>
<!DOCTYPE html>
<%
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	Object principal = auth.getPrincipal();
	
	String id = "";
	if(principal != null){
		id = auth.getName();
	}
%>
<html>
<head>
	<meta charset="UTF-8">
	<title>Update UserInfo Password Verity Form</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/loginstyle.css"/>">
</head>
<body>
	<script>
		//window 객체 - 웹브라우저에 대한 전반적인 정보 취득이나 제어 등에 관련된 객체 
		//window.onload?
		//위로부터 차례대로 읽어 들이는 프로그래밍 본연의 작동 방식과, 실행 이전에 에러 체크를 하지 않고 
		//실행을 하는 인터프리터 언어적 특성으로 인해 자바스크립트는 작성 위치에 따라 오작동을 일으키기도 한다. 
		//그 문제를 해결하기 위해서 자바스크립트가 문서가 준비한 상황 이후에 발동하도록만 한다면 
		//문서 앞에 선언해도 상관없게 되는 함수		
		
		window.onload = function(){
			var updateUserInfoPasswordVerityForm = document.updateUserInfoPasswordVerityForm;
			updateUserInfoPasswordVerityForm.onsubmit = function(){
				
				if(!updateUserInfoPasswordVerityForm.password.value){
					alert('비밀번호를 입력하세요!');
					updateUserInfoPasswordVerityForm.password.focus();
					return false;
				}
			}
		};
	</script>
	<div class="updateUserInfoPasswordVerityForm">
		<h2>Password Verity</h2>
		<form action="/cloud/updateUserInfoPasswordVerity" method="post" name="updateUserInfoPasswordVerityForm">
			<input type="hidden" name = "id" value="<%=id%>">
			
			<div class="passForm">
				<input type="password" id="pw" name="password" placeholder="pw">
			</div>
		
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			<input type="submit" value="PASSWORD VERITY" class="btn">
		</form>
		<button onclick="javascript:history.back();" class="btn2">BACK TO THE PAGE</button>
	</div>
</body>
</html>