<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
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
    
    <script type="text/javascript">
			alert("상품 등록 완료");
			location.href="${pageContext.request.contextPath }/admin/product/adminProductManagement.do?page=1";
		</script>
		
    <!-- footer -->
	<%@include file="/WEB-INF/views/common/footer2.jsp"%>
	
    <!-- Optional JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
</body>
</html>