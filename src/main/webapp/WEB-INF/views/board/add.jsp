<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Board Register</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css"/>">
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	<style>
		*{
			padding : 0;
			margin : 0;
		}
		body{
			
			background-color: #4B6375;
		}
		h2{
			margin : 30px 0px;
		}
		.container{
			background-color : #fff;
			postion : absolute;
			top : 50%;
			left : 50%;
			width : 75%;
			height : 75%;
			padding : 20px;
			margin : 150px;
			border-radius : 20px;
		}
	</style>
</head>
<body>
	
	<div class="container">
		<h2>Board Register</h2>
		<form action="/cloud/board/add" method="post" enctype="multipart/form-data">
			<input type="hidden" name="id" value="${user.id}">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			
			<div class="mb-3">
	  			<label for="title" class="form-label">Writer</label>
	  			<input type="text" class="form-control" name="name" id="name" placeholder="writer" value="${user.name}" readonly="readonly">
			</div>
			<div class="mb-3">
	  			<label for="title" class="form-label">Title</label>
	  			<input type="text" class="form-control" name="title" id="title" placeholder="title">
			</div>
			<div class="mb-3">
	  			<label for="files" class="form-label">File Upload</label>
	  			<input type="file" id="files" name="files" multiple="multiple">
			</div>
			<div class="mb-3">
	  			<label for="content" class="form-label">content</label>
	  			<textarea class="form-control" id="content" name="content" rows="3"></textarea>
			</div>
			
			<input type="submit" value="BOARD REGISTER" class="btn btn-primary btn-xs">
			<button type="button" class="btn btn-info btn-xs" onclick="javascript:history.back();">BACK TO THE PAGE</button> 
		</form>
	</div>
	
</body>
</html>