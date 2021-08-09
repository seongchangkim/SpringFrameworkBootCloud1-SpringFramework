<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="javatime" uri="http://sargue.net/jsptags/time" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Board List</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/resources/js/jquery-3.6.0.min.js"/>"></script>
	<style>
		.container{
			position : fixed;
			left:30%;
			width : 1000px;
		}
		
		.searchForm{
			position : relative;
			right : 100px;
			margin : 10px 0px;
		}
		
		.container div table{
			width : 800px;
			padding : 20px;
			margin : 20px;
		}
		
		.container div table tr{
			padding : 20px 15px;
		}
		
		.container div table tr th{
			padding : 13px 5px;
		}
		
		.container div table tr td{
			padding : 13px 5px;
		}
		
		.pagination{
			justify-content : center;
		}
		
		.emptyArea{
			padding : 300px 0px;
		}
		
		.emptyArea div p{
			display : block;
			margin : 100px 0;
		}
	</style>
</head>
<body>

	<sec:authorize access="hasRole('ROLE_USER')">
		<jsp:include page="../left.jsp" />
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<jsp:include page="../admin/adminLeft.jsp" />
	</sec:authorize>
	<div class="container text-center">
		<div class ="searchForm" align = "right">
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
		
			
		<div style="float : none; margin: 0 auto">
			<c:if test="${not empty list}">
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
							<td>
								<javatime:format value="${list.regDate}"/>
							</td>
							<td>${list.readCount}</td>
							<td>${list.replyCount}</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>	
			
			<c:if test="${empty list}">
				<table>
					<tr>
						<th>게시판 번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>등록날짜</th>
						<th>조회수</th>
						<th>댓글수</th>
					</tr>
					<tr>
						<td colspan="6">
							<div style="min-height : 474px;">
								<p>검색 결과가 없습니다.</p>
							</div>
						</td>
					</tr>
				</table>
			</c:if>
			
		<nav style="float : none; margin: 0 auto">
			<ul class="pagination">
					
				<c:if test="${pageMaker.prev}">
					<li class="page-item">
						<a href="${pageMaker.startPage -1}" class="page-link" aria-label="Previous">
							<span aria-hidden="true">&laquo;</span>
		      				<span class="sr-only">Previous</span>
						</a>
					</li>
				</c:if>
					
				<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
					<li class="page-item">
						<a href="${num}" class="page-link">${num}</a>
					</li>	
				</c:forEach>
							
				<c:if test="${pageMaker.next}">
					<li class="page-item">
						<a href="${pageMaker.endPage + 1}" class="page-link" aria-label="Next">
							<span aria-hidden="true">&raquo;</span>
		      				<span class="sr-only">Next</span>
						</a>
					</li>
				</c:if>
			</ul>
		</nav>						
		
		<form id="actionForm" action="/cloud/board/list" method="get">
			<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
			<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
				
			<input type="hidden" name="type" value='<c:out value="${pageMaker.cri.type}"/>'>
			<input type="hidden" name="keyword" value='<c:out value="${pageMaker.cri.keyword}"/>'> 
		</form>
	</div>
	
	<div class="form-row float-left">
		<button onclick="location.href='/cloud/board/add'" class="btn btn-primary btn-xs">게시판 만들기</button>	
	</div>
	
	</div>
	
	<script>
		$(document).ready(function(){
				var actionForm = $("#actionForm");	
				
				$(".page-item a").on("click",function(e){
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