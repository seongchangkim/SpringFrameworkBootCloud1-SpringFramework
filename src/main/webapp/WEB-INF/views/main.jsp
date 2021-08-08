<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder"  %>
<%@ page import="org.springframework.security.core.Authentication" %>
<%
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	Object principal = auth.getPrincipal();
	
	String name="";
	if(principal != null){
		name = auth.getName();
	}
	
	String pagefile = request.getParameter("page");
	if(pagefile==null) {pagefile="main";}
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>main page</title>
	<script src="<c:url value="/resources/js/jquery-3.6.0.min.js"/>"></script>
</head>
<body>
	<jsp:include page="left.jsp"></jsp:include>
	<div>
		<jsp:include page="<%=pagefile%>" />
		<form method="post" action="/cloud/upload" name="upLoadFileForm">
			<input type="hidden" name="id" value="<%=name%>">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			<input type="file" id="files" name="files" multiple="multiple" onClick="myFunction()">
		</form>
	</div>
	
	<script>
		if(document.upLoadFileForm.files.val() ===  null){
			alert('파일 업로드 하세요!');
		}
	</script>
	<script>
		function myFunction(){
			const files = document.getElementById('files').value;
			
			if()
		}
	</script>
</body>
</html>