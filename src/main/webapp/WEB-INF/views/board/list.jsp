<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Board List</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/boardliststyle.css"/>">
</head>
<body>
	${pageMaker.prev}
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
					<td><a href="<c:url value="/cloud/board/openBoard?bno=${list.bno}"/>">${list.title}</a></td>
					<td>${list.name}</td>
					<td>${list.regDate}</td>
					<td>${list.readCount}</td>
					<td>${list.replyCount}</td>
				</tr>
			</c:forEach>
		</table>
	
		<div class="pull-right">
			<ul class="pagination">
		
				<c:if test="${pageMaker.prev}">
					<li class="paginate_button previous">
						<a href="/cloud/board/list?pageNum=${pageMaker.startPage -1}">이전</a>
					</li>
				</c:if>
			
				<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
					<li class="paginate_button ${pageMaker.cri.getPageNum() == num ? 'active' : '' }">
						<a href="/cloud/board/list?pageNum=${num}">${num}</a>
					</li>	
				</c:forEach>
				
				<c:if test="${pageMaker.next}">
					<li class="paginate_button next">
						<a href="/cloud/board/list?pageNum=${pageMaker.endPage + 1}">다음</a>
					</li>
				</c:if>
			</ul>
		</div>
	</div>
	<button onclick="location.href='/cloud/board/add'" class="btn">게시판 만들기</button>	
	
	
</body>
</html>