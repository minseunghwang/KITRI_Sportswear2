<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.java.product.dto.ProductDto" %>
  <%@page import="com.java.productOrder.dto.ProductOrderDto, com.java.common.PaginationVO" %>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 내역 조회</title>
<link href="<%=request.getContextPath()%>/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="<%=request.getContextPath()%>/resources/css/shop-item.css" rel="stylesheet">

<style type="text/css">
.container{
	height: auto;
	min-height: 100%;
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
.allorderlistbox{
	margin-left: 50px;
	width:850px; 
	max-width:100%;
}
table{
	table-layout:fixed;
}
.code_num_link{
	color: black; 
	text-decoration: none;
	cursor: pointer;
}

#product_name{
	word-break:break-all;
}
#btn_paymentinfo{
	width:50%;
}
</style>
<!-- 팝업 스크립트 -->
	<script type="text/javascript">
	
	function popUpClosed() {
		var code_num = document.getElementById('code_num').value;
		var param = encodeURI(code_num);
		location.href="${pageContext.request.contextPath }/AllOrderListController2?o_state=1"; 
		
	}
	
	function showPopup(code_num) {

			var pop_title = "주문결제정보 조회";

		window.open("", pop_title, "width=800, height=500, left=400, top=200");
		
		var frmData = document.allorderList;
		frmData.target = pop_title;
		frmData.action = "${pageContext.request.contextPath }/productorder/paymentInfo.do?code_num=" + code_num;
	}
			
		
	
	
	</script>
</head>
<body>
	<!-- Navigation -->
	<%-- <%@include file ="/views/common/header.jsp" %> --%>
	<%@include file ="/WEB-INF/views/common/header2.jsp" %>
	
	<div class="container">
					
		<h1 class="my-4">My Page</h1>
		 <div class="row">
			
			<!-- leftNavigation -->
			<jsp:include page = "/WEB-INF/views/common/mypageCategory.jsp" />
			<!-- /leftNavigation -->
			<div class="allorderlistbox">
				
				<h3>주문배송조회</h3>

				<form id="allorderList" name="allorderList" method="post">
					<table class="table table-hover table-sm mt-3 mb-5" >
					<thead class="thead-light1" style="background-color: white;" >
						<tr class="text-center">
							<th scope="col">주문코드</th> 
							<th scope="col">주문일</th>
							<th scope="col">상품명</th>
							<th scope="col">상품 이미지</th>
							<th scope="col">총 결제금액</th> 
							<th scope="col">결제정보</th> 
						</tr>
					</thead>
					<tbody>
						<c:forEach var="o" items="${list }">
							<tr class="text-center">
								<td name="code_num" style="vertical-align: middle;" onclick="location.href='${pageContext.request.contextPath }/productorder/orderDetail.do?code_num=${o.code_num }'">${o.code_num }</td>
								<td class="code_num_link" style="vertical-align: middle;" onclick="location.href='${pageContext.request.contextPath }/productorder/orderDetail.do?code_num=${o.code_num }'">${o.max_o_date }</td>
								<td class="code_num_link" style="vertical-align: middle;" onclick="location.href='${pageContext.request.contextPath }/productorder/orderDetail.do?code_num=${o.code_num }'">${o.prod_name } <span style="font-size:12px;">..포함 ${o.ctnrow} 개</span></td>
								<td class="code_num_link" onclick="location.href='${pageContext.request.contextPath }/productorder/orderDetail.do?code_num=${o.code_num }'"><img src="${pageContext.request.contextPath }/resources/${o.prod_img }" width="100" height="100"></td>
								<td class="code_num_link" style="vertical-align: middle;" onclick="location.href='${pageContext.request.contextPath }/productorder/orderDetail.do?code_num=${o.code_num }'">${o.priceView } </td>
								<td style="vertical-align: middle;" align=center> <button type="submit" class="btn btn-outline-dark btn-block" id="btn_paymentinfo" onclick="showPopup('${o.code_num }');">View</button>  </td>																		
							</tr>	
						</c:forEach>
					</tbody>
					</table>
				</form>
			</div>
		</div>
		
		<!-- pagination -->
			<br> <br>
			<nav aria-label="...">
				<ul class="pagination justify-content-center">
				<c:if test="${1 != pn.page }">
					<li class="page-item">
						<a class="page-link" href="${pageContext.request.contextPath }/AllOrderListController?page=1&o_state=1" aria-label="Previous">
							<span aria-hidden="true">&laquo;</span>
						</a>
					</li>
					<li class="page-item">
						<a class="page-link" href="${pageContext.request.contextPath }/AllOrderListController?page=${param.page-1}&o_state=1" aria-label="Previous">
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
								<a class="page-link" href="${pageContext.request.contextPath }/AllOrderListController?page=${pageNum }&o_state=1">${pageNum }</a>
					<c:if test="${param.page eq pageNum}">
									<span class="sr-only">(current)</span>
							</li>
					</c:if>
				</c:forEach>

				<c:if test="${pn.totalPage != pn.page }">
					<li class="page-item">
						<a class="page-link" href="${pageContext.request.contextPath }/AllOrderListController?page=${param.page+1}&o_state=1" aria-label="Next">
							<span aria-hidden="true">&rsaquo;</span>
						</a>
					</li>
					<li class="page-item">
						<a class="page-link" href="${pageContext.request.contextPath }/AllOrderListController?page=${pn.totalPage }&o_state=1" aria-label="Next">
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