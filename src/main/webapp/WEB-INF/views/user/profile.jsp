<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Your Profile</title>
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
		<h2>Your Profile</h2>
		<div class="nameForm">
			<input type="text" id="name" name="name" placeholder="name" value="${user.getName()}">
		</div>
				
		<div class="emailForm">
			<input type="text" id="email" name="email" placeholder="email" value="${user.getEmail()}">
		</div>
						
		<div class="telForm">
			<input type="text" id="tel" name="tel" class="tel" placeholder="tel" value="${user.getTel()}">
		</div>
			
	  	<button onclick="location.href='/cloud/user/updateUserInfoPasswordVerify'" class="btn">회원 수정</button>
	  	<button onclick="javascript:history.back();" class="btn3">뒤로 가기</button>
	    <button onclick="location.href='/cloud/user/deleteUserInfoPasswordVerify'" class="btn2">회원 삭제</button>
	</div>
</body>
</html>