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
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/resources/js/jquery-3.6.0.min.js"/>"></script>
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
					<td><a href="<c:url value="/cloud/board/openBoard?bno=${list.bno}"/>">${list.title}</a></td>
					<td>${list.name}</td>
					<td>${list.regDate}</td>
					<td>${list.readCount}</td>
					<td>${list.replyCount}</td>
				</tr>
			</c:forEach>
		</table>
		
		<div class="row">
			<div class="col-lg-12">
				<form id="searchForm" action="/cloud/board/list" method="get">
					<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
					<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
					<select name="type">
						<option value="" <c:out value="${pagetMaker.cri.type == null ? 'selected' : ''}"/>>--
						</option>
						<option value="T" <c:out value="${pagetMaker.cri.type == 'T' ? 'selected' : ''}"/>>제목
						</option>
						<option value="C" <c:out value="${pagetMaker.cri.type == 'C' ? 'selected' : ''}"/>>내용
						</option>
						<option value="W" <c:out value="${pagetMaker.cri.type == 'W' ? 'selected' : ''}"/>>작성자
						</option>
						<option value="TC" <c:out value="${pagetMaker.cri.type == 'TC' ? 'selected' : ''}"/>>제목 or 내용
						</option>
						<option value="TW" <c:out value="${pagetMaker.cri.type == 'TW' ? 'selected' : ''}"/>>제목 or 작성자
						</option>
						<option value="TWC" <c:out value="${pagetMaker.cri.type == 'TWC' ? 'selected' : ''}"/>>제목 or 내용 or 작성자
						</option>
					</select>
					<input type="text" name="keyword"/>
					<button class="btn btn-primary">검색</button>
				</form>
			</div>
		</div>
		<div class="pull-right">
			<ul class="pagination">
		
				<c:if test="${pageMaker.prev}">
					<li class="paginate_button previous">
						<a href="${pageMaker.startPage -1}">이전</a>
					</li>
				</c:if>
			
				<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
					<li class="paginate_button ${pageMaker.cri.getPageNum() == num ? 'active' : '' }">
						<a href="${num}">${num}</a>
					</li>	
				</c:forEach>
				
				<c:if test="${pageMaker.next}">
					<li class="paginate_button next">
						<a href="${pageMaker.endPage + 1}">다음</a>
					</li>
				</c:if>
			</ul>
		</div>
		
		<form id="actionForm" action="/cloud/board/list" method="get">
			<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
			<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
			
			<input type="hidden" name="type" value='<c:out value="${pageMaker.cri.type}"/>'>
			<input type="hidden" name="keyword" value='<c:out value="${pageMaker.cri.keyword}"/>'> 
		</form>
	</div>
	
	<button onclick="location.href='/cloud/board/add'" class="btn">게시판 만들기</button>	
	
	<script>
		$(document).ready(function(){
			var result = '<c:out value="${result}"/>'
				
				var actionForm = $("#actionForm");	
				
				$(".paginate_button a").on("click",function(e){
					e.preventDefault();
					
					actionForm.find("input[name='pageNum']").val($(this).attr("href"));
					actionForm.submit();
				});
				
				var searchForm = $("#searchForm");
				
				$("#searchForm button").on("click",function(e){
					if(!searchForm.find("option:selected").val()){
						alert("검색조건을 선택하세요");
						return false;
					}
					
					if(!searchForm.find("input[name='keyword']").val()){
						alert("키워드를 입력하세요!");
						return false;
					}
					
					searchForm.find("input[name='pageNum']").val("1");
					
					e.preventDefault();
					
					searchForm.submit();
				});
		});
		
		
	</script>
</body>
</html>