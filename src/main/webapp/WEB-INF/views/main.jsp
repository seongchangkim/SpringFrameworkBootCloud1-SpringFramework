<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder"  %>
<%@ page import="org.springframework.security.core.Authentication" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css"/>">
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/mainstyle.css"/>">
	<script src="<c:url value="/resources/js/jquery-3.6.0.min.js"/>"></script>
</head>
<body>
	<jsp:include page="left.jsp"></jsp:include>
	<div class="fileAddDeleteForm">
		<%-- <jsp:include page="<%=pagefile%>" /> --%>
		<c:set var="total" value="0"/>
		<div>
			<c:forEach var="list" items="${list}">
				<font style="display:none;">${list.fileSize}</font>
				<c:set var="total" value="${total+list.fileSize}"/>
			</c:forEach>
			<div>
				<font id="currentFileTotal"><c:out value="${total}"/></font>/<font id="limitFile">16106127360</font>
			</div>
		</div>
		<form method="post" action="/cloud/upload" enctype="multipart/form-data" id="frm">
			<input type="hidden" name="id" value="<%=name%>">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			<input type="hidden" name="currentFileTotal" value="${total}">
			<input type="hidden" name	="limitFile" value="16106127360">
			<!-- label을 id 지정하여 input file를 안보이게 하고 여기에 클릭하면 input file를 클릭 -->
			<label class="btn btn-primary btn-xs" for="files">
				업로드
			</label>
			<!-- onchange="this.form.submit()" : 파일 업로드 클릭 후 해당 파일을 선택하고 나서 자동 submit-->
			<input type="file" class="file" id="files" name="files" multiple="multiple" style="display:none;">
		</form>
	</div>
	<div class="fileList">
		<c:forEach var="list" items="${list}">
			<div>
				<img src="
					<c:if test="${fn:contains(list.storedFilePath,'.7z')}">
						<c:url value="/resources/images/7z.png"/>
					</c:if>
					<c:if test="${fn:contains(list.storedFilePath,'.avi')}">
						<c:url value="/resources/images/avi.png"/>
					</c:if>
					<c:if test="${fn:contains(list.storedFilePath,'.doc')}">
						<c:url value="/resources/images/doc.png"/>
					</c:if>
					<c:if test="${fn:contains(list.storedFilePath,'.gif')}">
						<c:url value="/resources/images/gif.png"/>
					</c:if>
					<c:if test="${fn:contains(list.storedFilePath,'.jpg')}">
						<c:url value="/resources/images/jpg.png"/>
					</c:if>
					<c:if test="${fn:contains(list.storedFilePath,'.mp3')}">
						<c:url value="/resources/images/mp3.png"/>
					</c:if>
					<c:if test="${fn:contains(list.storedFilePath,'.mp4')}">
						<c:url value="/resources/images/mp4.png"/>
					</c:if>
					<c:if test="${fn:contains(list.storedFilePath,'.pdf')}">
						<c:url value="/resources/images/pdf.png"/>
					</c:if>
					<c:if test="${fn:contains(list.storedFilePath,'.png')}">
						<c:url value="/resources/images/png.png"/>
					</c:if>
					<c:if test="${fn:contains(list.storedFilePath,'.ppt')}">
						<c:url value="/resources/images/ppt.png"/>
					</c:if>
					<c:if test="${fn:contains(list.storedFilePath,'.rar')}">
						<c:url value="/resources/images/rar.png"/>
					</c:if>
					<c:if test="${fn:contains(list.storedFilePath,'.tar')}">
						<c:url value="/resources/images/tar.png"/>
					</c:if>
					<c:if test="${fn:contains(list.storedFilePath,'.txt')}">
						<c:url value="/resources/images/txt.png"/>
					</c:if>
					<c:if test="${fn:contains(list.storedFilePath,'.zip')}">
						<c:url value="/resources/images/zip.png"/>
					</c:if>
				">
				<a href="/cloud/download?fno=${list.fno}">${list.originalFileName}</a>
				<p>${list.fileSize}</p>
				<button class="btn btn-warning btn-xs" onclick="location.href='/cloud/deleteYNUpdateFile?fno=${list.fno}'">DELETE FILE</button>
			</div>
		</c:forEach>
		
	</div>
	<script>
		var storedFiles = [];
		document.getElementById("files").addEventListener('change',function(){
			var currentFileTotal = parseInt($('input[name=currentFileTotal]').val());
			var limitFile = parseInt($('input[name=limitFile]').val());
			
			var getRequestFile = 0;
			
			var fileList = this.files;
			for(var i = 0; i<fileList.length ; i++){
				storedFiles.push(fileList[i]);
				getRequestFile += fileList[i].size; 
			}
			
			console.log(currentFileTotal+getRequestFile);
			console.log(limitFile);
			console.log(storedFiles);
			var formData = new FormData(this.form);
			
			for(var i = 0; i<fileList.length ; i++){
				formData.append('files',storedFiles[i]);
			}
			for(var pair of formData.entries()){
				console.log(pair[0] + ',' + pair[1]);
			}
			
			if((currentFileTotal+getRequestFile) < limitFile){
				this.form.submit();
			}else if(getRequestFile > 2147483648){
				alert('한 요청 당 업로드 파일 용량은 2GB입니다.');
				return false;
			}else{
				alert('업로드 할 수 있는 파일 용량이 초과 되었습니다.');
				return false;
			}
			
		});
		
	</script>
</body>
</html>