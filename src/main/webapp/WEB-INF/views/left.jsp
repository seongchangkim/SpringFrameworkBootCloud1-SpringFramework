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
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>main page</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/leftstyle.css"/>">
</head>
<body>
	<div class="container">
		<div class="navigation">
			<ul>
				<li class="list">
					<a href="/cloud/user/main">
						<span class="icon">
							<ion-icon name="home-outline"></ion-icon>
						</span>
						<span class="title">Home</span>
					</a>
				</li>
				<li class="list">
					<a href="/cloud/user/profile?id=<%=name%>">
						<span class="icon">
							<ion-icon name="person-outline"></ion-icon>
						</span>
						<span class="title">Profile</span>
					</a>
				</li>
				<li class="list">
					<a href="/cloud/recycleBin">
						<span class="icon">
							<ion-icon name="trash-outline"></ion-icon>
						</span>
						<span class="title">RecycleBin</span>
					</a>
				</li>
				<li class="list">
					<a href="#">
						<span class="icon">
							<ion-icon name="settings-outline"></ion-icon>
						</span>
						<span class="title">Setting</span>
					</a>
				</li>
				<li class="list">
					<a href="#">
						<span class="icon">
							<ion-icon name="help-outline"></ion-icon>
						</span>
						<span class="title">Help</span>
					</a>
				</li>
				<li class="list">
					<a href="/cloud/board/list">
						<span class="icon">
							<ion-icon name="laptop-outline"></ion-icon>
						</span>
						<span class="title">Board</span>
					</a>
				</li>
				<li class="list">
					<a href="/logout">
						<span class="icon">
							<ion-icon name="log-out-outline"></ion-icon>
						</span>
						<span class="title">Sign Out</span>
					</a>
				</li>
				<li>
					
				</li>
				<li class="profile">
					<%-- <div>
						<sec:authorize access="hasRole('ROLE_ADMIN')">
							여기는 관리자 페이지입니다. 
						</sec:authorize>
					</div> --%>
				</li>
				
			</ul>
		</div>
	</div>
	
	<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
	<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>

	<script>
		let memuToggle = document.querySelector('.toggle');
	
		// add active class in selected list item
		let list = document.querySelectorAll('.list');
		for(let i = 0; i<list.length; i++){
			list[i].onclick = function(){
				let j = 0;
				while(j < list.length){
					list[j++].className = 'list';
				}
				list[i].className = 'list active';
			}
		}
		
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
	</script>
</body>
</html>