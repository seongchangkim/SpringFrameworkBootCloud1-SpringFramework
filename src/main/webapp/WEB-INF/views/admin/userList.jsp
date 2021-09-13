<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원 관리 목록</title>
	<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>" >
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	<style>
		table, tr, td{
			border: 1px solid #000;
			border-collapse : collapse;
			margin : 10px 5px;
		}
		.btn{
			margin : 10px 5px;
		}
	</style>
</head>
<body>
	<button onclick="javascript:history.back()" class="btn btn-warning btn-xs">이전 페이지</button>
	<table>
		<tr>
			<td>이름</td>
			<td>아이디</td>
			<td>이메일</td>
			<td>전화번호</td>
			<td>가입날짜</td>
			<td>수정날짜</td>
			<td>상세보기</td>
			<td>삭제</td>
		</tr>
		<c:forEach var="list" items="${list}">
			<tr>
				<td>${list.name}</td>
				<td>${list.id}</td>
				<td>${list.email}</td>
				<td>${list.tel}</td>
				<td>${list.regDate}</td>
				<td>${list.updateDate}</td>
				<td><a href="/cloud/admin/selectUserInfoDetail?id=${list.id}">상세보기</a></td>
				<td><a href="/cloud/admin/deleteUserInfo?id=${list.id}">삭제</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>