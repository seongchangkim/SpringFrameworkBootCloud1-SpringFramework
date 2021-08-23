<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder"  %>
<%@ page import="org.springframework.security.core.Authentication" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<sec:authorize access="hasRole('ROLE_USER')">
		<jsp:include page="left.jsp"/>
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<jsp:include page="admin/adminLeft.jsp"/>
	</sec:authorize>
	
	<div class="userForm">
		<c:forEach var="list" items="${list}">
			<font style="display:none;">${list.fileSize}</font>
			<c:set var="total" value="${total+list.fileSize}"/>
		</c:forEach>
		<form method="post" action="/cloud/upload" enctype="multipart/form-data" id="frm">
			<input type="hidden" name="id" value="<%=name%>">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			<input type="hidden" name="currentFileTotal" value="${total}">
					
			<sec:authorize access="hasRole('ROLE_USER')">
				<input type="hidden" name	="limitFile" value="16106127360">
			</sec:authorize>
			<!-- label을 id 지정하여 input file를 안보이게 하고 여기에 클릭하면 input file를 클릭 -->
			<label class="btn btn-info btn-xs" for="files">
					File Upload
			</label>
			<!-- onchange="this.form.submit()" : 파일 업로드 클릭 후 해당 파일을 선택하고 나서 자동 submit-->
			<input type="file" class="file" id="files" name="files" multiple="multiple" style="display:none;">
		</form>
		
		<div class="searchForm">
			<div class="form-group">
    			<input type="text" class="form-control" placeholder="Search">
  				<button type="button" class="btn btn-primary">
					<ion-icon name="search-outline"></ion-icon>
				</button>
  			</div>
		</div>
		
		<div style="position : absolute;top:5%; right:0%;margin:10px;">
			<%=name%>님, 환영합니다.
		</div>
	</div>
	<div class="wrap">
		<div class="grid1">
	        <div class="row">
	            <div class="col-xl-4 col-lg-4 mb-6">
	                <div class="bg-white rounded-lg p-5 shadow">
	                    <!-- <h2 class="h6 font-weight-bold text-center mb-4">UpLoad </h2> -->
	                    <div class="progress mx-auto" data-value='${(total/16106127360)}'> <span class="progress-left"> <span class="progress-bar border-primary"></span> </span> <span class="progress-right"> <span class="progress-bar border-primary"></span> </span>
	                        <div class="progress-value w-100 h-100 rounded-circle d-flex align-items-center justify-content-center">
	                            <div class="h2 font-weight-bold"><fmt:formatNumber value="${(total/16106127360)*100}" maxFractionDigits="1"/><sup class="small">%</sup></div>
	                        </div>
	                    </div>
	                    <div class="row text-center mt-4">
	                        <div class="col-6 border-right">
	                            <div class="h4 font-weight-bold mb-0">
	                            	<c:if test="${total >= 1099511627776 && total < 1125899906842624}">
										<fmt:formatNumber value="${total/1099511627776}" maxFractionDigits="1"/>GB
									</c:if>
	                            	<c:if test="${total >= 1073741824 && total < 1099511627776}">
										<fmt:formatNumber value="${total/1073741824}" maxFractionDigits="1"/>GB
									</c:if>
									<c:if test="${total >= 1048576 && total < 1073741824}">
										<fmt:formatNumber value="${total/1048576}" maxFractionDigits="1"/>MB
									</c:if>
									<c:if test="${total >= 1024 && total < 1048576}">
										<fmt:formatNumber value="${total/1024}" maxFractionDigits="1"/>KB
									</c:if>
									<c:if test="${total < 1024}">
										<fmt:formatNumber value="${total}" maxFractionDigits="1"/>B
									</c:if>
	                            </div><span class="small text-gray">Current Total Upload Size</span>
	                        </div>
	                        <div class="col-6">
	                            <div class="h4 font-weight-bold mb-0">
	                            	<sec:authorize access="hasRole('ROLE_USER')">
	                            		15GB
	                           	 	</sec:authorize>
	                            	<sec:authorize access="hasRole('ROLE_ADMIN')">
	                            		unlimited
	                            	</sec:authorize>
	                         	</div><span class="small text-gray">Max Total Upload Size</span>
	                        </div>
	                    </div>
	                </div>
	            </div>
	        </div>
	     </div> 
	
		<div class="grid2">
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
					<button class="btn btn-warning btn-xs" onclick="location.href='/cloud/deleteYNUpdateFile?fno=${list.fno}'">DELETE FILE</button>
				</div>
			</c:forEach>
			
		</div>
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
		
		$(function() {

            $(".progress").each(function() {

                var value = $(this).attr('data-value');
                var left = $(this).find('.progress-left .progress-bar');
                var right = $(this).find('.progress-right .progress-bar');

                if (value > 0) {
                    if (value <= 50) {
                        right.css('transform', 'rotate(' + percentageToDegrees(value) + 'deg)')
                    } else {
                        right.css('transform', 'rotate(180deg)') 
                        left.css('transform', 'rotate(' + percentageToDegrees(value - 50) + 'deg)')
                    }
                }
            })

            function percentageToDegrees(percentage) {
                return percentage / 100 * 360
            }
        });
	</script>
</body>
</html>