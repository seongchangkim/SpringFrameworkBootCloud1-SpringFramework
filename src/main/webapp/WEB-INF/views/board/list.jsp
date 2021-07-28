<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Board List</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/boardliststyle.css"/>">
</head>
<body>
	<sec:authorize access="hasRole('ROLE_USER')">
		<jsp:include page="../left.jsp" />
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<jsp:include page="../admin/adminLeft.jsp" />
	</sec:authorize>
	<div class="boardContainer">
		<table>
			<tr>
				<th>게시판 번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>등록날짜</th>
				<th>조회수</th>
				<th>댓글수</th>
			</tr>
			<c:forEach var="list" items="${list}">
				<tr>
					<td>${list.bno}</td>
					<td>${list.title}</td>
					<td>${list.name}</td>
					<td>${list.regDate}</td>
					<td>${list.readCount}</td>
					<td>${list.replyCount}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<button onclick="location.href='/cloud/board/add'" class="btn">게시판 만들기</button>	
</body>
</html>