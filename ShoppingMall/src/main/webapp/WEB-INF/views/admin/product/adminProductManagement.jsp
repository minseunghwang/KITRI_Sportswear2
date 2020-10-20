<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
	
	<!-- Bootstrap core JavaScript -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="<%=request.getContextPath()%>/resource/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<style type="text/css">
		#tbody_tr > td{
			vertical-align:middle;
		}
	</style>
	
	<script type="text/javascript">
	
		function productDel(num) {
			var confirm_value = confirm('정말 삭제하시겠습니까?');
			if(confirm_value){
				location.href = "<%=request.getContextPath()%>/ProductDelController?num=" + num;
			}
		}

		function showPopup(num) {
			var pop_title = "재고 현황";

			window.open("", pop_title, "width=300, height=400, left=200, top=200");
			
			var frmData = document.productList;
			frmData.target = pop_title;
			frmData.action = "<%=request.getContextPath()%>/ProductManagementPopupController?num=" + num;
		} 
		
	</script>

</head>
<body>

	<!-- Navigation -->
	<nav id ="top">
          <%-- <jsp:include page = "/views/common/header.jsp" /><br><br> --%>
          <jsp:include page = "/WEB-INF/views/common/header2.jsp" /><br><br>
    </nav>
     
	<div class="container">

    	<div class="row">
			
			<!-- leftNavigation -->
			<jsp:include page = "/WEB-INF/views/common/leftNav.jsp" />
			<!-- /leftNavigation -->

			<div class="col-lg-10">

				<form id="productList" name="productList" method="post">
					<table class="table table-hover" id="table-borderdt">
						<thead class="thead-dark">
							<tr style="text-align: center;">
								<th scope="col"><input type="checkbox"></th>
								<th scope="col">No.</th>
								<th scope="col">Image</th>
								<th scope="col" width="193px">Name</th>
								<th scope="col">quantity</th>
								<th scope="col">Price</th>
								<th scope="col">Reg.Date</th>
								<th scope="col">Record</th>
								<th scope="col">Del</th>
								<th scope="col">Prod.Info</th>
							</tr>
						</thead>
						<c:forEach var="p" items="${products }">
						<tbody>
							<tr id="tbody_tr" style="text-align: center;">
								<td scope="row"><input type="checkbox"></td>
								<td>${p.num }</td>
								<td><img src="${p.img}" width="50" height="75"></td>
								<td  style="text-align:justify;">${p.name }</td>
								<td>
									<c:if test="${empty p.sizes }">
										<strong><li style="color: red; list-style: none;">out of stock</li></strong>
									</c:if>
									<c:forEach var="s" items="${p.sizes }">
										${s.psize } : ${s.quantity }<br>
									</c:forEach>
								</td>
								<td>${p.priceView }</td>
								<td>${p.e_date }</td>
								<td>${p.record }</td>
								<td><input type="button" class="btn btn-outline-danger" value="Del" onClick="productDel('${p.num}')"></td>
								<td><input type="submit" class="btn btn-outline-info" name="productListNum" value="info" onClick="showPopup('${p.num}')"></td>
							</tr>
						</tbody>
						</c:forEach>
						
					</table>
				</form>
				
			</div>
			<!-- /.col-lg-10 -->

		</div>
		<!-- /.row -->
		
		<!-- pagination -->
			<br> <br>
			<nav aria-label="...">
				<ul class="pagination justify-content-center">
				<c:if test="${1 != pn.page }">
					<li class="page-item">
						<a class="page-link" href="${pageContext.request.contextPath }/ProductAllListController?page=1" aria-label="Previous">
							<span aria-hidden="true">&laquo;</span>
						</a>
					</li>
					<li class="page-item">
						<a class="page-link" href="${pageContext.request.contextPath }/ProductAllListController?page=${param.page-1}" aria-label="Previous">
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
								<a class="page-link" href="${pageContext.request.contextPath }/ProductAllListController?page=${pageNum }">${pageNum }</a>
					<c:if test="${param.page eq pageNum}">
									<span class="sr-only">(current)</span>
					</c:if>
				</c:forEach>

				<c:if test="${pn.totalPage != pn.page }">
					<li class="page-item">
						<a class="page-link" href="${pageContext.request.contextPath }/ProductAllListController?page=${param.page+1}" aria-label="Next">
							<span aria-hidden="true">&rsaquo;</span>
						</a>
					</li>
					<li class="page-item">
						<a class="page-link" href="${pageContext.request.contextPath }/ProductAllListController?page=${pn.totalPage }" aria-label="Next">
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

	<!-- footer -->
	<%@include file="/WEB-INF/views/common/footer2.jsp"%>
	
    <!-- Optional JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>

</body>
</html>