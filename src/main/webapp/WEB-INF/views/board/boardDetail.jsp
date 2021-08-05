<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page import="com.cloud.porforio.domain.Board" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="org.springframework.security.core.Authentication" %>
<%
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	Object principal = auth.getPrincipal();
	
	String id = "";
	if(principal != null){
		id = auth.getName();
	}
	
	Board board = (Board)request.getAttribute("board");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>${board.title}</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css"/>">
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
</head>
<body>
	<div class="position-absolute top-50 start-50 translate-middle w-75 h-75">
		<h2>${board.title}</h2>
		<br>
		<div>
			<a href="/cloud/board/downloadFile?bno=${file.getBno()}">
				${file.getOriginalFileName()}	
			</a>
		</div>
		<form method="post" name="boardDetailForm">
			<input type="hidden" name="bno" value="${board.bno}">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			<input type="hidden" name="pageNum" value="<c:out value="${cri.pageNum}"/>">
			<div class="mb-3">
		  		<label for="title" class="form-label">Writer</label>
		  		<input type="text" class="form-control" name="name" id="name" placeholder="writer" value="${board.name}" readonly="readonly">
			</div>
			<div class="mb-3">
		  		<label for="content" class="form-label">content</label>
		  		<textarea class="form-control" id="content" name="content" rows="3" 
		  	<% 
		  		if(!board.getId().equals(id)){
			%>
					readonly="readonly"
			<%
				}else{
			%>
					
			<%
				}
			%>>${board.content}</textarea>
			</div>
			
			<% if(board.getId().equals(id)){ %>
				<input type="submit" value="UPDATE" onclick="mySubmit(1)" class="btn btn-xs btn-primary"> 
			<% 
				}
			%>
			<% if(board.getId().equals(id)){ %>
				<input type="submit" value="DELETE" onclick="mySubmit(2)" class="btn btn-xs btn-warning">
			<% 
				}
			%>
			<input type="button" value="BACK TO THE PAGE" onClick="javascript:history.back();" class="btn btn-xs btn-info">
		</form>
	</div>
	
	<script>
		function mySubmit(index){
			if(index == 1){
				document.boardDetailForm.action='/cloud/board/updateBoard';
			}else if(index == 2){
				document.boardDetailForm.action='/cloud/board/deleteBoard';
			}
			document.boardDetailForm.submit();
		}
	</script>
</body>
</html>