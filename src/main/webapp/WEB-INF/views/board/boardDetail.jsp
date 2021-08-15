<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="tf"  tagdir="/WEB-INF/tags" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="org.springframework.security.core.Authentication" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>${board.title}</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css"/>">
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	<style>
		.container{
			margin : 50px;
		}
		.replyForm{
			margin : 60px;
		}
	</style>
</head>
<body>
	<div class="container">
		<h2>${board.title}</h2>
		<hr>
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
			<input type="hidden" name="type" value='<c:out value="${cri.type}"/>'>
			<input type="hidden" name="keyword" value='<c:out value="${cri.keyword}"/>'>
			<div class="mb-3">
		  		<label for="title" class="form-label">Writer</label>
		  		<input type="text" class="form-control" name="name" id="name" placeholder="writer" value="${board.name}" readonly="readonly">
			</div>
			<div class="mb-3">
		  		<label for="content" class="form-label">content</label>
		  		<textarea class="form-control" id="content" name="content" rows="3" 
		  		<c:if test="${board.id != userId}">
						readonly="readonly"
				</c:if>
				>${board.content}</textarea>
			</div>
			
			<c:if test="${board.id == userId}">
				<input type="submit" value="UPDATE" onclick="mySubmit(1)" class="btn btn-xs btn-primary"> 
			</c:if>
			<c:if test="${board.id == userId}">
				<input type="submit" value="DELETE" onclick="mySubmit(2)" class="btn btn-xs btn-warning">
			</c:if>
			<input type="button" value="BACK TO THE PAGE" onClick="javascript:history.back();" class="btn btn-xs btn-info">
		</form>
	</div>
	
		<div class="replyForm">
			<form method="post" action="/cloud/reply/add">
				<input type="hidden" name="id" value="${username}">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
				<input type="hidden" name="name" value="${username}">
				<input type="hidden" name="bno" value="${board.bno}">
				<div class="mb-3">
		  			<label for="reply" class="form-label">reply</label>
		  			<textarea class="form-control" id="reply" name="reply" rows="2"></textarea>
		  		</div> 
				<input type="submit" value="ADD">
			</form>
		</div>
		 
		<div class="replyForm">
			<c:forEach var="list" items="${replyList}">
				<div>
					<form method="post" name="replyProcessForm">
						<input type="hidden" name="rno" value="${list.rno}">
						<input type="hidden" name="bno" value="${list.bno}">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"> 
						<div class="mb-3">
				  			<label for="reply" class="form-label">${list.name}</label>	
				  			<c:if test="${list.updatedate == null}">
				  				<p class="form-row float-right">
				  					<tf:formatDateTime value="${list.regdate}" pattern="yyyy-MM-dd ahh:mm:ss" />
				 				</p>
				  			</c:if>
				  			<c:if test="${list.updatedate != null}">
				  				<p class="form-row float-right">
				  					<tf:formatDateTime value="${list.updatedate}" pattern="yyyy-MM-dd ahh:mm:ss" />에 수정됨
				  				</p>
				  			</c:if>
				  			<textarea class="form-control" id="reply" name="reply" rows="2" 
				  				<c:if test="${list.id != userId}"> 
				  					readonly="readonly"	
				  				</c:if>
				  			>${list.reply}</textarea>
				  			<c:if test="${list.id == userId}">
				  				<input type="submit" value="UPDATE REPLY" onclick="myProcess()">	
				  			</c:if>
				  			<c:if test="${list.id == userId}">
				  				<input type="button" value="DELETE REPLY" onclick="location.href='/cloud/reply/deleteReply?rno=${list.rno}'">	
				  			</c:if>
				  		</div>
					</form>
				</div>
			</c:forEach>
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
		
		function myProcess(){
			
				document.replyProcessForm.action='/cloud/reply/updateReply';
			
				
			
			
			document.replyProcessForm.submit();
		}
		
	</script>
</body>
</html>