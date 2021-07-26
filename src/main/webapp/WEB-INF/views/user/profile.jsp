<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Your Profile</title>
	<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>" >
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
</head>
<body>
	<jsp:include page="../left.jsp"></jsp:include>
	<div class ="position-absolute top-50 start-50 translate-middle w-50 h-50">
		<div class="mb-3 row">
    	 <label for="name" class="col-sm-2 col-form-label">name</label>
    	 <div class="col-sm-10">
      		<input type="text" readonly class="form-control-plaintext" id="name" value="${user.getName()}">
    	 </div>
  		</div>
		<div class="mb-3 row">
    	 <label for="email" class="col-sm-2 col-form-label">Email</label>
    	 <div class="col-sm-10">
      		<input type="text" readonly class="form-control-plaintext" id="email" value="${user.getEmail()}">
    	 </div>
  		</div>
  		<div class="mb-3 row">
    	 <label for="tel" class="col-sm-2 col-form-label">tel</label>
    	 <div class="col-sm-10">
      		<input type="text" readonly class="form-control-plaintext" id="tel" value="${user.getTel()}">
    	 </div>
  		</div>
  		<button onclick="location.href='/cloud/user/updateUserInfoPasswordVerify'" class="btn btn-lg btn-warning">회원 수정</button>
    	<button onclick="location.href='/cloud/user/deleteUserInfoPasswordVerify'" class="btn btn-lg btn-danger">회원 삭제</button>
	</div>
</body>
</html>