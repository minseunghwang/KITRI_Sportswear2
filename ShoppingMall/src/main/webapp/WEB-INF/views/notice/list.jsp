<%@ page language="java" pageEncoding="UTf-8" import="com.java.notice.dto.NoticeDto, com.java.common.PaginationVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page import="java.util.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.sql.*"%>

<!-- <%@ page import="notice.* "%> -->

<!DOCTYPE html>
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Insert title here</title>
<!-- Bootstrap core CSS -->
<link
	href="<%=request.getContextPath()%>/resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Custom styles for this template -->
<link href="<%=request.getContextPath()%>/resources/css/shop-item.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<%--  
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

 <script src="<%=request.getContextPath()/resource/js/jquery.twbsPagination.js" type="text/javascript"></script> 
--%>
<style type="text/css">
.container{
	height: auto;
	min-height: 77.5%;
	padding-bottom: 70px;
}

</style>

<!--     <script>
      $( document ).ready( function() {
        var jb = $( 'rnum' ).get();
        for ( var i = 0; i < rnum.length; i++) {
          $( 'div' ).append( '<p>' + rnum[i].innerHTML + '</p>' );
        }
      } );
    </script> -->
    
</head>
<body>
<!-- Navigation -->
	<%-- <%@include file ="/views/common/header.jsp" %> --%>
	<%@include file ="/WEB-INF/views/common/header2.jsp" %>

	<div class="container">
		<br>
		<h3 class="text-center my-4"align ="center">공지사항</h3>
		<div class="button" align="right">
			<c:if test="${sessionScope.memberType == 0 }">
				<button id="addbtn" type="button" class="btn btn-dark " style="width:100px;"
					onclick="location.href='${pageContext.request.contextPath }/notice/addForm.do'">write</button>
			</c:if>
		</div>
		<br>
		<div class="table" align="center">
			<table class="table table-hover  table-sm mt-3 mb-5" >
				<thead class="thead-light ">
					<tr class="d-flex ">
						<th class="text-center col-1">no.</th>
						<th class="text-center col-6">title</th>
						<th class="text-center col-3">date</th>
						<th class="text-center col-2">views</th>
					</tr>
				</thead>
				<tbody id="page_content">
				<c:set var="num" value="${count - ((currentPage-1) * noticeSize) }"/>
					<c:forEach var="notice" items="${notices }">
						<tr class="text-center d-flex">
							<td class="text-center  col-1">${num }</td>
							<td class="text-center  col-6" id="title" name="title"><a
								href="${pageContext.request.contextPath }/notice/search.do?num=${notice.num}&page=${currentPage}"
								style="color: black;"> ${notice.title }</a></td>
							<td class="text-center  col-3"><fmt:formatDate value="${notice.n_date}" pattern="yyyy.MM.dd" /></td>
							<td class="text-center  col-2" id="view_count">${notice.view_count }</td>
						</tr>
						<c:set var="num" value="${num-1 }"></c:set>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<!-- /pagination -->
		
		<!-- pagination -->
		<fmt:parseNumber var="pageCount" value="${count/noticeSize + (count%noticeSize==0?0:1)}" integerOnly="true"/>
		 <!-- 3항식으로 표현함 count=전체 게시글 개수 boardSize=내가 정한 개수에서 두개 나눴을 때 나머지 0이면0, 나머지 0아니면 +1해줌
		  -->
		  <!-- 여기서 ${pageCount}찍어주면 1.3처럼 나옴 처리 나중에 해주면 됨 -->
		  <c:set var="pageBlock" value="${5}"/>		<%-- 페이징 넘버 표시할 갯수 --%>
		  
		  <fmt:parseNumber var="result" value="${(currentPage-1)/pageBlock}" integerOnly="true"/>
		  <c:set var="startPage" value="${result*pageBlock +1}"/>
		  <c:set var="endPage" value="${startPage+pageBlock-1}"/>
		  <%--${startPage}, ${endPage}, --%>
		  
	
	<c:if test="${endPage > pageCount }">
		<c:set var="endPage" value="${pageCount }"/>
	</c:if>
	<%--${startPage}, ${endPage} --%>
		<nav aria-label="...">
			<ul class="pagination justify-content-center">
			
				<c:if test="${startPage > pageBlock }">
				<li class="page-item">
					<a class="page-link" href="${pageContext.request.contextPath }/notice/list.do?page=${startPage-pageBlock}" aria-label="Previous">
						<span aria-hidden="true">&laquo;</span>
					</a>
				</li>
				</c:if>
				
				<c:forEach var="i" begin="${startPage }" end="${endPage }">
					<c:choose>
						<c:when test="${param.page eq i}">
							<li class="page-item active" aria-current="page">
						</c:when>
						<c:otherwise>
							<li class="page-item">
						</c:otherwise>
					</c:choose>
								<a class="page-link" href="${pageContext.request.contextPath }/notice/list.do?page=${i }">${i }</a>
					<c:if test="${param.page eq i}">
									<span class="sr-only">(current)</span>
							</li>
					</c:if>
				</c:forEach>
					
				<c:if test="${endPage < pageCount }">
				<li class="page-item">
					<a class="page-link" href="${pageContext.request.contextPath }/notice/list.do?page=${startPage+pageBlock}"aria-label="Next"> 
						<span aria-hidden="true">&raquo;</span>
					</a>
				</li>
				</c:if>
			</ul>
		</nav>
	</div>
	<!-- footer -->
	<%@include file="/WEB-INF/views/common/footer2.jsp"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</body>