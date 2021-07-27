<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Board List</title>
</head>
<body>
	<button onclick="javascript:history.back()">BACK TO THE PAGE</button>
	<table>
		<tr>
			<td>게시판 번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>등록날짜</td>
			<td>조회수</td>
			<td>댓글수</td>
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
</body>
</html>