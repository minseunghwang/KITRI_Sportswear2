<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
.list-group-item{
	cursor: pointer;
	color: black; 
	text-decoration: none;
}

</style>

</head>
<body>

	<div class="col-lg-auto">

		<div class="list-group list-group-flush">
	        	<%-- <a href="${pageContext.request.contextPath }/OrderlistController?o_state=1" class="list-group-item" style="text-decoration: none;">주문조회</a> --%>
	        	<a href="${pageContext.request.contextPath }/productorder/orderInquiry.do?o_state=1&page=1" class="list-group-item" style="text-decoration: none;">주문조회</a>
	        	<a href="${pageContext.request.contextPath }/review/myReviewList.do?page=1" class="list-group-item" style="text-decoration: none;">내가 쓴 리뷰 관리</a>
	          	<a href="${pageContext.request.contextPath }/member/editPage.do" class="list-group-item " style="text-decoration: none;">내 정보 수정</a>
		</div>

	</div>

</body>
</html>