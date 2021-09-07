<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>비밀번호 찾기</title>
	<script src="/resources/js/jquery-3.6.0.min.js"></script>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/findingpasswordstyle.css"/>">
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
			var findingPasswordForm = document.findingPasswordForm;
			findingPasswordForm.onsubmit = function(){
				
				if(!findingPasswordForm.id.value){
					alert('아이디를 입력하세요!');
					findingPasswordForm.id.focus();
					return false;
				}
				
				if(!findingPasswordForm.name.value){
					alert('이름을 입력하세요!');
					findingPasswordForm.name.focus();
					return false;
				}
				
				if(!findingPasswordForm.email.value){
					alert('이메일을 입력하세요!');
					findingPasswordForm.email.focus();
					return false;
				}
				
				if(!findingPasswordForm.tel.value){
					alert('전화번호를 입력하세요!');
					findingPasswordForm.tel.focus();
					return false;
				}
			}
		};
	</script>
	<script>
		$(document).ready(function() {
			   $(function () {
				   		/* 전화번호를 입력시 하이폰 추가 */
			            $('#tel').keydown(function (event) {
			             var key = event.charCode || event.keyCode || 0;
			             $text = $(this); 
			             if (key !== 8 && key !== 9) {
			                 if ($text.val().length === 3) {
			                     $text.val($text.val() + '-');
			                 }
			                 if ($text.val().length === 8) {
			                     $text.val($text.val() + '-');
			                 }
			             }
			
			             return (key == 8 || key == 9 || key == 46 || (key >= 48 && key <= 57) || (key >= 96 && key <= 105));
						 // Key 8번 백스페이스, Key 9번 탭, Key 46번 Delete 부터 0 ~ 9까지, Key 96 ~ 105까지 넘버패트
						 // 한마디로 JQuery 0 ~~~ 9 숫자 백스페이스, 탭, Delete 키 넘버패드외에는 입력못함
			         })
			   });
			});
		</script>
	<div class="findingPasswordForm">
		<h2>비밀번호 찾기</h2>
		<form action="/cloud/findingPassword" method="post" name="findingPasswordForm">
			<div class="idForm">
				<input type="text" id="id" name="id" placeholder="아이디">
			</div>
			
			<div class="nameForm">
				<input type="text" id="name" name="name" placeholder="이름">
			</div>
			
			<div class="emailForm">
				<input type="text" id="email" name="email" placeholder="이메일">
			</div>
					
			<div class="telForm">
				<input type="text" id="tel" name="tel" class="tel" placeholder="전화번호">
			</div>
			
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			<input type="submit" value="비밀번호 찾기" class="btn">
		</form>
		<button onclick="javascript:history.back();" class="btn2">이전 페이지</button>
	</div>
	
</body>
</html>