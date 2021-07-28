<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Board add</title>
	<link>
</head>
<body>
	<div>
		<form action="/cloud/board/add" method="post">
			<div class="mb-3">
	  			<label for="title" class="form-label">writer</label>
	  			<input type="text" class="form-control" name="name" id="name" placeholder="writer">
			</div>
			<div class="mb-3">
	  			<label for="title" class="form-label">Email address</label>
	  			<input type="text" class="form-control" name="title" id="title" placeholder="title">
			</div>
			<div class="mb-3">
	  			<label for="exampleFormControlTextarea1" class="form-label">Example textarea</label>
	  			<textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
			</div>
	</form>
	</div>
	
</body>
</html>