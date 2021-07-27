<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%
	String id = (String)request.getAttribute("id");
	String password = (String)request.getAttribute("password");
%>
<html>
<head>
	<meta charset="UTF-8">
	<title>Update Password Form</title>
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
			var findingPasswordForm = document.updatePasswordForm;
			updatePasswordForm.onsubmit = function(){
				if(updatePasswordForm.pw.value != updatePasswordForm.r_pw.value){
					alert('비밀번호과 비밀번호 확인이 일치하지 않습니다.');
					return false;
				}
				
				if(!updatePasswordForm.pw.value){
					alert('변경할 비밀번호를 입력하세요!');
					updatePasswordForm.pw.focus();
					return false;
				}
				
				if(!updatePasswordForm.r_pw.value){
					alert('변경할 비밀번호 확인을 입력하세요!');
					updatePasswordForm.r_pw.focus();
					return false;
				}
			}
		};
	</script>
	<div class="updatePasswordForm">
		<h2>Update Password</h2>
		<form action="/cloud/user/updatePassword" method="post" name="updatePasswordForm">
			<input type="hidden" name = "id" value="<%=id%>">
			<input type="hidden" name = "v_pw" value="<%=password%>">
			
			<div class="passForm">
				<input type="password" id="pw" name="password" placeholder="pw">
			</div>
		
			<div class="passForm">
				<input type="password" id="r_pw" placeholder="r_pw">
			</div>
			
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			<input type="submit" value="update password" class="btn">
		</form>
		<button onclick="javascript:history.back();" class="btn2">BACK TO THE PAGE</button>
	</div>

	
	
</body>
</html>