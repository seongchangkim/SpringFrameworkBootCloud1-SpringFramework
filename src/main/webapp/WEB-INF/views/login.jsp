<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>login</title>
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
			var login = document.loginForm;
			login.onsubmit = function(){
				if(!login.id.value){
					alert('아이디를 입력하세요!');
					login.id.focus();
					return false;
				}
				
				if(!login.password.value){
					alert('비밀번호를 입력하세요!');
					login.password.focus();
					return false;
				}
			}
		};
	</script>
	<div class="loginForm">
		<h2>Login</h2>
		<form action="/cloud/login" method="post" name="loginForm">
			<div class="idForm">
				<input type="text" id="id" name="id" placeholder="id">
			</div>
			
			<div class="passForm">
				<input type="password" id="pw" name="password" placeholder="pw"/>
			</div>
			
			<input type="submit" value="LOG IN" class="btn"/>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		</form>
		<div class="bottomText">
			Don't you have ID? <a href="/cloud/register">sign up</a>
			<br>
			<a href="/cloud/findingId">finding ID</a>
		</div>
	</div>
	
</body>
</html>