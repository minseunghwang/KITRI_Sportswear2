<%@ page language="java" pageEncoding="UTf-8" import="com.java.notice.dto.NoticeDto, com.java.common.PaginationVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
					onclick="location.href='${pageContext.request.contextPath }/views/notice/addForm.jsp'">write</button>
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
					<c:forEach var="notice" items="${notices }">
						<tr class="text-center d-flex">
							<td class="text-center  col-1">${notice.num }</td>
							<td class="text-center  col-6" id="title" name="title"><a
								href="${pageContext.request.contextPath }/ReadNoticeController?num=${notice.num}"
								style="color: black;"> ${notice.title }</a></td>
							<td class="text-center  col-3">${notice.n_date }</td>
							<td class="text-center  col-2" id="view_count">${notice.view_count }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<!-- pagination -->
			<nav aria-label="...">
				<ul class="pagination justify-content-center">
				<c:if test="${1 != pn.page }">
					<li class="page-item">
						<a class="page-link" href="${pageContext.request.contextPath }/ListNoticeController?page=1" aria-label="Previous">
							<span aria-hidden="true">&laquo;</span>
						</a>
					</li>
					<li class="page-item">
						<a class="page-link" href="${pageContext.request.contextPath }/ListNoticeController?page=${param.page-1}" aria-label="Previous">
							<span aria-hidden="true">&lsaquo;</span>
						</a>
					</li>
				</c:if>

				<c:forEach var="pageNum" begin="${pn.startPage }" end="${pn.endPage }" step="1">
							
					<c:choose>
						<c:when test="${param.page eq pageNum}">
							<li class="page-item active" aria-current="page">
						</c:when>
						<c:otherwise>
							<li class="page-item">
						</c:otherwise>
					</c:choose>
								<a class="page-link" href="${pageContext.request.contextPath }/ListNoticeController?page=${pageNum }">${pageNum }</a>
					<c:if test="${param.page eq pageNum}">
									<span class="sr-only">(current)</span>
							</li>
					</c:if>
				</c:forEach>

				<c:if test="${pn.totalPage != pn.page }">
					<li class="page-item">
						<a class="page-link" href="${pageContext.request.contextPath }/ListNoticeController?page=${param.page+1}" aria-label="Next">
							<span aria-hidden="true">&rsaquo;</span>
						</a>
					</li>
					<li class="page-item">
						<a class="page-link" href="${pageContext.request.contextPath }/ListNoticeController?page=${pn.totalPage }" aria-label="Next">
							<span aria-hidden="true">&raquo;</span>
						</a>
					</li>
				</c:if>
					
				</ul>
			</nav>
		<!-- /pagination -->
	</div>
	<!-- footer -->
	<%@include file="/WEB-INF/views/common/footer2.jsp"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</body>