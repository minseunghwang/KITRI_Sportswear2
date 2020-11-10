<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="com.java.common.PaginationVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Shop Homepage - Start Bootstrap Template</title>

<!-- Bootstrap core CSS -->
<link href="<%=request.getContextPath()%>/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="<%=request.getContextPath()%>/resources/css/shop-item.css" rel="stylesheet">
	<style type="text/css">
		#back_img{
			min-width: 100%;
		}
		ul.orderby-menu{
			float: right;
		}
		ul.orderby-menu li{
			display: inline;				/*  세로나열을 가로나열로 변경 */
			border-left:1px solid #999;		/* 각 메뉴의 왼쪽에 "|" 표시(분류 표시) */
			font:bold 12px Dotum;           /* 폰트 설정 - 12px의 돋움체 굵은 글씨로 표시 */
            padding:0 10px;					/* 각 메뉴 간격 */
		}
		ul.orderby-menu li a{
			color: black;					/* css 152 line */
		}
		ul.orderby-menu li:first-child {
			border-left: none;				/* 메뉴 분류중 제일 왼쪽의 "|"는 삭제 */
		}
	</style>
	<script type="text/javascript">
		
	
	</script>

</head>
<body>

	<nav id="top">
		<%-- <jsp:include page="/views/common/header.jsp" /><br> --%>
		<jsp:include page="/WEB-INF/views/common/header2.jsp" />
	</nav>


	<!-- Page Content -->


	<div id="Advertising-signboard">


		<div>
			<div>

				<c:choose>
					<c:when test="${param.category eq 'top' }">
						<img id="back_img" src="${pageContext.request.contextPath }/resources/upload_img/wideimage14.jpg">
					</c:when>
					<c:otherwise>
						<img id="back_img" src="${pageContext.request.contextPath }/resources/upload_img/wideimage16.jpg">
					</c:otherwise>
				</c:choose>
			</div>
		</div>



	</div>



	<div class="container">

		<div class="row">
			
			<div class="col-lg-12">

				<br>
				<hr>
				
				<div>
					<strong style="float: left;">${products.size() }</strong><span style="float: left;">&nbsp;개의 상품</span>
					<ul class="orderby-menu">
						<li><a href="${pageContext.request.contextPath }/product/category.do?category=${param.category}&page=1&orderBy=e_date">신상품</a></li>
						<li><a href="${pageContext.request.contextPath }/product/category.do?category=${param.category}&page=1&orderBy=price">낮은가격</a></li>
						<li><a href="${pageContext.request.contextPath }/product/category.do?category=${param.category}&page=1&orderBy=record">인기상품</a></li>
						<li><a href="${pageContext.request.contextPath }/product/category.do?category=${param.category}&page=1&orderBy=rate">평점순</a></li>
					</ul>
				</div>
				<br><br><br>
				
				<div class="row">
					<c:forEach var="product" items="${products }">
					
						<div class="col-lg-3 col-md-6 mb-4">
							<div class="card h-100">

								<a href="${pageContext.request.contextPath }/product/productDetail.do?num=${product.num }&page=1">
									<img class="card-img-top" src="${pageContext.request.contextPath }/resources/${product.img }" height="316.25" alt="">

								</a>
								<div class="card-body">
									<h6 class="card-title">
										<a style="color: black;text-decoration: none;" href="${pageContext.request.contextPath }/product/productDetail.do?num=${product.num }&page=1"><b>${product.name }</b></a>
									</h6>
									<h7>￦ ${product.priceView }</h7>
								</div>
								<div class="card-footer">			
									<!-- 평점 총합 변수 선언 -->
									<c:set var="totalReRating" value="0" />
									
									<!-- 해당 상품의 모든 리뷰 forEach -->
									<c:forEach var="reviews" items="${product.reviews}" varStatus="status">
										<!-- 평점 총합에 누적 -->
										<c:set var="totalReRating" value="${totalReRating + reviews.rate}"/>
										<!-- 마지막 리뷰일 경우 -->
										<c:if test="${status.last }">
											<!-- 평점 평균 반올림 -->
											<c:set var="avgReRating" value="${totalReRating / status.count}" />
											<c:set var="avgReRating" value="${avgReRating + (((avgReRating%1)>=0.5)?(1-(avgReRating%1)):-(avgReRating%1)) }" />
										</c:if>
									</c:forEach>
															
									<!-- 채워진 별 -->															
									<c:forEach var="colorStar" begin="1" end="${avgReRating}">
										<small class="text-warning">&#9733;</small>
									</c:forEach>
									
									<!-- 빈 별 -->
									<c:forEach var="emptyStar" begin="1" end="${5 - avgReRating}">
										<small class="text-warning">&#9734;</small>
									</c:forEach>
									
									<!-- 평점 초기화 -->
									<c:set var="totalReRating" value="0" />
									<c:set var="avgReRating" value="0" />
									<small>Reviews ${product.reviews.size() }</small>
								</div>
							</div>
						</div>

					</c:forEach>

				</div>
				<!-- /.row -->

			</div>
			<!-- /.col-lg-12 -->

		</div>
		<!-- /.row -->
		
			<!-- pagination -->
			<br> <br>
			<nav aria-label="...">
				<ul class="pagination justify-content-center">
				<c:if test="${1 != pn.page }">
					<li class="page-item">
						<a class="page-link" href="${pageContext.request.contextPath }/product/category.do?category=${param.category}&page=1&orderBy=${param.orderBy }" aria-label="Previous">
							<span aria-hidden="true">&laquo;</span>
						</a>
					</li>
					<li class="page-item">
						<a class="page-link" href="${pageContext.request.contextPath }/product/category.do?category=${param.category}&page=${param.page-1}&orderBy=${param.orderBy }" aria-label="Previous">
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
								<a class="page-link" href="${pageContext.request.contextPath }/product/category.do?category=${param.category}&page=${pageNum }&orderBy=${param.orderBy }">${pageNum }</a>
					<c:if test="${param.page eq pageNum}">
									<span class="sr-only">(current)</span>
					</c:if>
				</c:forEach>

				<c:if test="${pn.totalPage != pn.page }">
					<li class="page-item">
						<a class="page-link" href="${pageContext.request.contextPath }/product/category.do?category=${param.category}&page=${param.page+1}&orderBy=${param.orderBy }" aria-label="Next">
							<span aria-hidden="true">&rsaquo;</span>
						</a>
					</li>
					<li class="page-item">
						<a class="page-link" href="${pageContext.request.contextPath }/product/category.do?category=${param.category}&page=${pn.totalPage }&orderBy=${param.orderBy }" aria-label="Next">
							<span aria-hidden="true">&raquo;</span>
						</a>
					</li>
				</c:if>
					
				</ul>
			</nav>
			<br>
		<!-- /pagination -->
			
	</div>
	<!-- /.container -->
<%--
	<!-- Footer -->
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; Your Website 2020</p>
		</div>
		<!-- /.container -->
	</footer>
 --%>
 
		<!-- footer -->
	<%@include file="/WEB-INF/views/common/footer2.jsp"%>

	<!-- Bootstrap core JavaScript -->
	<script src="<%=request.getContextPath()%>/resources/vendor/jquery/jquery.min.js"></script>
   	<script src="<%=request.getContextPath()%>/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>