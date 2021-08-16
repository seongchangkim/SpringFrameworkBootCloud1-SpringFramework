<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="tf"  tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="org.springframework.security.core.Authentication" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>${board.title}</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css"/>">
	<script src="<c:url value="/resources/js/jquery-3.6.0.min.js"/>"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	<style>
		.fileForm{
			padding : 10px 0px;
		}
		.BoardDetailForm{
			margin : 60px;
		}
		.BoardDetailForm h2{
			margin : 10px 0px 0px 0px;
		}
		.replyForm{
			margin : 60px;
		}
		#deleteReplyButton, #updateReplyButton{
			margin : 20px 0px 0px 0px;
		}
	</style>
</head>
<body>
	<div class="BoardDetailForm">
		<h2>${board.title}</h2>
		<hr>
		<c:if test="${file != null}">
			<div class="fileForm">
				첨부파일 : <br>
				<c:forEach var="file" items="${file}">
					<a href="/cloud/board/downloadFile?idx=${file.idx}">
						${file.originalFileName}	
					</a>
					<c:if test="${file.filesize >= 1073741824}">
						(<fmt:formatNumber value="${file.filesize/1073741824}" maxFractionDigits="1"/>GB)
					</c:if>
					<c:if test="${file.filesize >= 1048576 && file.filesize < 1073741824}">
						(<fmt:formatNumber value="${file.filesize/1048576}" maxFractionDigits="1"/>MB)
					</c:if>
					<c:if test="${file.filesize >= 1024 && file.filesize < 1048576}">
						(<fmt:formatNumber value="${file.filesize/1024}" maxFractionDigits="1"/>KB)
					</c:if>
					<c:if test="${file.filesize < 1024}">
						(<fmt:formatNumber value="${file.filesize}" maxFractionDigits="1"/>B)
					</c:if>
					<br>
				</c:forEach>
			</div>
		</c:if>
		
		<form method="post" name="boardDetailForm" id="boardDetailForm">
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
				<input type="submit" value="UPDATE" formaction="/cloud/board/updateBoard" class="btn btn-xs btn-warning"> 
			</c:if>
			<c:if test="${board.id == userId}">
				<input type="submit" value="DELETE" formaction="/cloud/board/deleteBoard" class="btn btn-xs btn-danger">
			</c:if>
			<input type="button" value="BACK TO THE PAGE" onclick="javascript:history.back();" class="btn btn-xs btn-info">
		</form>
	</div>
	
		<div class="replyForm">
			<form method="post" action="/cloud/reply/add" id="replyForm">
				<input type="hidden" name="id" value="${username}">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
				<input type="hidden" name="name" value="${username}">
				<input type="hidden" name="bno" value="${board.bno}">
				<div class="mb-3">
		  			<label for="reply" class="form-label">reply</label>
		  			<textarea class="form-control" id="reply" name="reply" rows="2"></textarea>
		  		</div> 
				<input type="submit" value="ADD" class="btn btn-xs btn-primary">
			</form>
		</div>
		 
		<div class="replyForm">
			<c:forEach var="list" items="${replyList}">
				<div>
					<form method="post" name="replyProcessForm" id="replyProcessForm">
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
				  			<textarea class="form-control" id="updateReply" name="reply" rows="2" 
				  				<c:if test="${list.id != userId}"> 
				  					readonly="readonly"	
				  				</c:if>
				  			>${list.reply}</textarea>
				  			<c:if test="${list.id == userId}">
				  				<input type="submit" value="UPDATE REPLY" formaction="/cloud/reply/updateReply" class="btn btn-xs btn-warning" id="updateReplyButton">	
				  			</c:if>
				  			<c:if test="${list.id == userId}">
				  				<input type="submit" value="DELETE REPLY" formaction="/cloud/reply/deleteReply" class="btn btn-xs btn-danger" id="deleteReplyButton">	
				  			</c:if>
				  		</div>
					</form>
				</div>
			</c:forEach>
		</div>
	
	<script>	
	$(document).ready(function(){
		$('#boardDetailForm').submit(function(){
			var content = $('#content').val();
			if(!content){
				alert('내용을 입력하세요!');
				return false;
			}
		});
			
		$('#replyForm').submit(function(){
			var reply = $('#reply').val();
			if(!reply){
				alert('댓글을 입력하세요!');
				return false;
			}
		});
		
		$('#replyProcessForm').submit(function(){
			var reply = $('#updateReply').val();
			if(!reply){
				alert('댓글을 입력하세요!');
				return false;
			}
		});
	});
		
	</script>
</body>
</html>