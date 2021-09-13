<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>회원 정보</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/profilestyle.css"/>">
</head>
<body>
	<sec:authorize access="hasRole('ROLE_USER')">
		<jsp:include page="../left.jsp"/>
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<jsp:include page="../admin/adminLeft.jsp"/>
	</sec:authorize>	
		
	<div class ="profileForm">
		<h2>회원 정보</h2>
		<div class="nameForm">
			<input type="text" id="name" name="name" placeholder="이름" value="${user.getName()}">
		</div>
				
		<div class="emailForm">
			<input type="text" id="email" name="email" placeholder="이메일" value="${user.getEmail()}">
		</div>
						
		<div class="telForm">
			<input type="text" id="tel" name="tel" class="tel" placeholder="전화번호" value="${user.getTel()}">
		</div>
		
		<sec:authorize access="hasRole('ROLE_USER')">
			<button onclick="location.href='/cloud/user/updateUserInfoPasswordVerify'" class="btn">회원 수정</button>
	  		<button onclick="javascript:history.back();" class="btn3">이전 페이지</button>
	    	<button onclick="location.href='/cloud/user/deleteUserInfoPasswordVerify'" class="btn2">회원 삭제</button>
		</sec:authorize>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<button onclick="location.href='/cloud/admin/updateUserInfoPasswordVerify'" class="btn">회원 수정</button>
	  		<button onclick="javascript:history.back();" class="btn3">이전 페이지</button>
	    	<button onclick="location.href='/cloud/admin/deleteUserInfoPasswordVerify'" class="btn2">회원 삭제</button>
		</sec:authorize>	
	</div>
</body>
</html>