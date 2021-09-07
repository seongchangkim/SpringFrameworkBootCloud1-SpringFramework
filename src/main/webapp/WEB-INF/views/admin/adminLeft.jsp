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
	<title></title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/leftstyle.css"/>">
</head>
<body>
	<div class="container">
		<div class="navigation">
			<ul>
				<li class="list">
					<a href="/cloud/admin/main">
						<span class="icon">
							<ion-icon name="home-outline"></ion-icon>
						</span>
						<span class="title">홈</span>
					</a>
				</li>
				<li class="list">
					<a href="/cloud/admin/profile?id=<%=name%>">
						<span class="icon">
							<ion-icon name="person-outline"></ion-icon>
						</span>
						<span class="title">프로필</span>
					</a>
				</li>
				<li class="list">
					<a href="/cloud/admin/userList">
						<span class="icon">
							<ion-icon name="people-outline"></ion-icon>
						</span>
						<span class="title">사용자 관리</span>
					</a>
				</li>
				<li class="list">
					<a href="/cloud/recycleBin">
						<span class="icon">
							<ion-icon name="trash-outline"></ion-icon>
						</span>
						<span class="title">휴지통</span>
					</a>
				</li>
				<!--
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
				-->
				<li class="list">
					<a href="/cloud/board/list">
						<span class="icon">
							<ion-icon name="laptop-outline"></ion-icon>
						</span>
						<span class="title">게시판</span>
					</a>
				</li>
				<li class="list">
					<a href="/logout">
						<span class="icon">
							<ion-icon name="log-out-outline"></ion-icon>
						</span>
						<span class="title">로그아웃</span>
					</a>
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
	</script>
</body>
</html>