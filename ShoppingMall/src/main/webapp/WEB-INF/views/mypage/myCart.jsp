<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.java.product.dto.ProductDto" %>
  <%@page import="com.java.productOrder.dto.ProductOrderDto" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Shop Homepage - My Cart</title>

<!-- Bootstrap core CSS -->
<link href="<%=request.getContextPath()%>/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="<%=request.getContextPath()%>/resources/css/shop-item.css" rel="stylesheet">
<style type="text/css">
.container{
	height: auto;
	min-height: 75%;
	padding-bottom: 70px;
}
.cartlistbox{
	margin-left: 50px;
	width:850px; 
	max-width:100%;
}
table{
	table-layout:fixed;
}

#product_name{
	word-break:break-all;
}
.btns{
	width: 100%;
	margin-left: 40%;
}

.btn_gopay{
	display: inline-block;
}
</style>


<script type="text/javascript">
 function showPopup(currentNum) {
	 
	 var num = currentNum;
	 if(confirm('장바구니에서 삭제하시겠습니까?')) {
		 location.href= "${pageContext.request.contextPath }/productorder/deleteOrder.do?o_state=0&num="+ num;
		 return;
	 } else {
		 return;
	 }
	 
	 
	 
 }


</script>




</head>
<body>

	
	
	<!-- Navigation -->
	<%-- <%@include file ="/views/common/header.jsp" %> --%>
	<%@include file ="/WEB-INF/views/common/header2.jsp" %>
		<c:if test="${not empty sessionScope.id }">
			<div class="container">
				<h1 class="my-4">My Page</h1>
			 	<div class="row">
			
				<!-- leftNavigation -->
				<jsp:include page = "/WEB-INF/views/common/mypageCategory.jsp" />
				<!-- /leftNavigation -->
		

				<div class="cartlistbox">
				
					<c:if test="${o_state==0 }">
						<h3>장바구니 목록</h3>
					</c:if>
	
				<form action="${pageContext.request.contextPath }/CartOrderController" name="f" method="post">
					<table class="table table-hover table-sm mt-3 mb-5">
						<thead class="thead-light1" style="background-color: white;">
							<tr class="text-center">
								<th scope="col">No.</th>
								<th scope="col">제품명</th>
								<th scope="col">사진</th>
								<th scope="col">사이즈</th>
								<th scope="col">수량</th>
								<th scope="col">결제금액</th>
								<th scope="col">주문하기</th>
								<th scope="col">삭제</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="o" items="${list }">
								<tr class="text-center">
									<td>${o.num }</td>
									<td id="product_name">${o.prod_name }</td>
									<td><a href="${pageContext.request.contextPath }/DetailController?num=${o.p_num }">
										<img src="${pageContext.request.contextPath }/resources/${o.prod_img }" width="100" height="100"></a>
										</td>
									<td>${o.p_size } </td>
									<td>${o.o_quantity}</td>
									<td>${o.total_price }</td>
									<td scope="row"><input type="checkbox" name=sel value=${o.num }></td>
									<td scope="row"><input type="button" class="btn btn-outline-secondary" value="삭제" onClick="showPopup('${o.num }')"></td>
	
								</tr>
							</c:forEach>
						</tbody>
					</table>
					
					<!-- 버튼 div -->
					<div class="form-group">
						<div class="btns">
							<div class="btn_gopay">
								<button type="submit" class="btn btn-outline-dark">결제</button>
							</div>
						</div>
					</div>
					
				</form>
					
					
				</div>
			</div>
		</div>
	

	</c:if>


<%--
	<!-- Footer -->
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; Your
				Website 2020</p>
		</div>
		<!-- /.container -->
	</footer>
 --%>
 
	<!-- footer -->
	<%@include file="/WEB-INF/views/common/footer2.jsp"%>

	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>