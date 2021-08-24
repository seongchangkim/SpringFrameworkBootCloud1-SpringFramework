<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>RecycleForm</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css"/>">
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/mainstyle.css"/>">
	<script src="<c:url value="/resources/js/jquery-3.6.0.min.js"/>"></script>
</head>
<body>
	<sec:authorize access="hasRole('ROLE_USER')">
		<jsp:include page="../left.jsp" />
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<jsp:include page="../admin/adminLeft.jsp" />
	</sec:authorize>
	<div class="fileList">
		<c:forEach var="list" items="${list}">
			<div>
				
				<div>
					<img src="
					<c:if test="${fn:contains(list.storedFilePath,'.7z')}">
						<c:url value="/resources/images/7z.jpg"/>
					</c:if>
					<c:if test="${fn:contains(list.storedFilePath,'.avi')}">
						<c:url value="/resources/images/avi.jpg"/>
					</c:if>
					<c:if test="${fn:contains(list.storedFilePath,'.doc')}">
						<c:url value="/resources/images/doc.png"/>
					</c:if>
					<c:if test="${fn:contains(list.storedFilePath,'.gif')}">
						<c:url value="/resources/images/gif.jpg"/>
					</c:if>
					<c:if test="${fn:contains(list.storedFilePath,'.jpg')}">
						<c:url value="/resources/images/jpg.png"/>
					</c:if>
					<c:if test="${fn:contains(list.storedFilePath,'.mp3')}">
						<c:url value="/resources/images/mp3.jpg"/>
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
						<c:url value="/resources/images/ppt.jpg"/>
					</c:if>
					<c:if test="${fn:contains(list.storedFilePath,'.rar')}">
						<c:url value="/resources/images/rar.jpg"/>
					</c:if>
					<c:if test="${fn:contains(list.storedFilePath,'.tar')}">
						<c:url value="/resources/images/tar.jpg"/>
					</c:if>
					<c:if test="${fn:contains(list.storedFilePath,'.txt')}">
						<c:url value="/resources/images/txt.jpg"/>
					</c:if>
					<c:if test="${fn:contains(list.storedFilePath,'.zip')}">
						<c:url value="/resources/images/zip.jpg"/>
					</c:if>
					">
				</div>
				<p class="fileName">${list.originalFileName}</p>
				<p>
					<c:if test="${list.fileSize >= 1073741824}">
						<fmt:formatNumber value="${list.fileSize/1073741824}" maxFractionDigits="1"/>GB
					</c:if>
					<c:if test="${list.fileSize >= 1048576 && list.fileSize < 1073741824}">
						<fmt:formatNumber value="${list.fileSize/1048576}" maxFractionDigits="1"/>MB
					</c:if>
					<c:if test="${list.fileSize >= 1024 && list.fileSize < 1048576}">
						<fmt:formatNumber value="${list.fileSize/1024}" maxFractionDigits="1"/>KB
					</c:if>
					<c:if test="${list.fileSize < 1024}">
						<fmt:formatNumber value="${list.fileSize}" maxFractionDigits="1"/>B
					</c:if>
				</p>
				<button class="btn btn-danger btn-xs" onclick="location.href='/cloud/emptytrash?fno=${list.fno}'">EMPTY TRASH</button>
				<button class="btn btn-info btn-xs" onclick="location.href='/cloud/restore?fno=${list.fno}'">RESTORE</button>
			</div>
		</c:forEach>
	</div>
</body>
</html>