<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.java.review.dto.ReviewDto, com.java.common.PaginationVO" %>

    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내가 쓴 리뷰 내역</title>
<link href="<%=request.getContextPath()%>/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="<%=request.getContextPath()%>/resources/css/shop-item.css" rel="stylesheet">


<!-- popup -->
<script type="text/javascript">

		function popUpClosed() {
			location.href="${pageContext.request.contextPath }/ListReviewController?page=1";
		} 
		
		function reviewUpdatePopup(num) {

 			var pop_title = "리뷰 수정";
			
			window.open("", pop_title, "width=800, height=650, left=400, top=100");
			
			var frmData = document.myreviewList;
			frmData.target = pop_title;
			frmData.action = "<%=request.getContextPath()%>/EachReviewPopupController?num="+num;
		}
		


	function showUpdatePopup(num){
		var title = "상품평 수정";

		var url = "<%=request.getContextPath()%>/EachReviewController?r_num="+num;
		var options = 'top=50, left=400, width=800, height=700, status=no, menubar=no, toolbar=no';
	    window.open(url, title, options);
	}
</script>


<style type="text/css">
.container{
	height: auto;
	min-height: 75%;
	padding-bottom: 70px;
}
.btn btn-link{
	position: absolute;
    top: 50%;
    left: 50%;
    width: 680px;
    min-height: 666px;
    padding: 0 20px 88px;
}
.reviewlistbox{
	margin-left: 50px;
	width:850px; 
	max-width:100%;
}
table{
	table-layout:fixed;
}

#content{
	word-break:break-all;
}
</style>

</head>
<body>
<!-- Navigation -->
	<%-- <%@include file ="/views/common/header.jsp" %> --%>
	<%@include file ="/WEB-INF/views/common/header2.jsp" %>
	<!-- Page Container -->

		<div class="container">
				
	        <h1 class="my-4">My Page</h1>
	        <div class="row">
		       <!-- leftNavigation -->
				<jsp:include page = "/WEB-INF/views/common/mypageCategory.jsp" />
				<!-- /leftNavigation -->
			<div class="reviewlistbox">
				
				<h3>내가 쓴 리뷰 목록</h3>
		<form id="myreviewList" name="myreviewList" method="post">
				<table class="table table-hover table-sm mt-3 mb-5">
				<thead class="thead-light1" style="background-color: white;">
					<tr class="text-center">
						<th scope="col">No. </th> 
						<th scope="col">별점 </th> 
						<th id="content" scope="col">리뷰 내용 </th>
						<th scope="col">이미지 </th> 
						<th scope="col">리뷰 쓴 날짜 </th> 
						<th scope="col">상품평 수정</th> 
					</tr>
				</thead>
				<tbody >
					<c:forEach var="r" items="${list }">
						<tr class="text-center">
							<td name="num" style="vertical-align: middle;">${r.num } </td>
							<td style="vertical-align: middle;"> ${r.rate } </td>
							<td style="vertical-align: middle;"> ${r.content } </td>
							<td style="vertical-align: middle;"> <img src="${r.img }" width="100" height="100"> </td>
							<td style="vertical-align: middle;">${r.r_date } </td>
							<%-- <td><a href="${pageContext.request.contextPath }/EachReviewController?r_num=${r.num }">수정하기</a> </td>
							<td><button type="button" class="btn btn-link" onclick="showUpdatePopup('${r.num }');">팝업 수정</button> </td> --%>
							<td style="vertical-align: middle;"><button type="submit" class="btn btn-outline-secondary" onclick="reviewUpdatePopup('${r.num }');">수정하기</button> </td>
						</tr>
					</c:forEach>
				</tbody>
				</table>
			</form>
		</div>
	</div>
						<!-- pagination -->
			
			<nav aria-label="...">
				<ul class="pagination justify-content-center">
				<c:if test="${1 != pn.page }">
					<li class="page-item">
						<a class="page-link" href="${pageContext.request.contextPath }/ListReviewController?page=1" aria-label="Previous">
							<span aria-hidden="true">&laquo;</span>
						</a>
					</li>
					<li class="page-item">
						<a class="page-link" href="${pageContext.request.contextPath }/ListReviewController?page=${param.page-1}" aria-label="Previous">
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
								<a class="page-link" href="${pageContext.request.contextPath }/ListReviewController?page=${pageNum }">${pageNum }</a>
					<c:if test="${param.page eq pageNum}">
									<span class="sr-only">(current)</span>
							</li>
					</c:if>
				</c:forEach>

				<c:if test="${pn.totalPage != pn.page }">
					<li class="page-item">
						<a class="page-link" href="${pageContext.request.contextPath }/ListReviewController?page=${param.page+1}" aria-label="Next">
							<span aria-hidden="true">&rsaquo;</span>
						</a>
					</li>
					<li class="page-item">
						<a class="page-link" href="${pageContext.request.contextPath }/ListReviewController?page=${pn.totalPage }" aria-label="Next">
							<span aria-hidden="true">&raquo;</span>
						</a>
					</li>
				</c:if>
					
				</ul>
			</nav>
			<br>
		<!-- /pagination -->
	</div>
	  			<!-- footer -->
	<%@include file="/WEB-INF/views/common/footer2.jsp"%>
	    
</body>
</html>