<%@ page language="java" pageEncoding="UTf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
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
<style type="text/css">
.container {
	height: auto;
	min-height: 70%;
	padding-bottom: 70px;
}

p {
	font-size: 30px;
	font: bold;
}
</style>

</head>
<body>
	<!-- Navigation -->
	<%-- <%@include file ="/views/common/header.jsp" %> --%>
	<%@include file="/WEB-INF/views/common/header2.jsp"%>
	<div class="container">
		<br>
		<h3 class="text-center my-4" align="center">공지사항</h3>
		<div align="center">
			<form
				action="${pageContext.request.contextPath }/notice/updateOk.do"
				method="post">
				<input type="hidden" name="page" value="${page }">
			<input type="hidden" name="num" value="${notice.num }">
				<table class="table table-sm mt-3 mb-5" cellspacing="0"
					style="width: 900px; height: 300px; border: none;">
					<tr style="height: 50px; border: none; font: bold;">
							<td><p>
									<input type="text" name="title" value="${notice.title }"
										size="40" style="background-color: white; border: none;">
								</p></td>
					</tr>

					<tr>
							<td><input type="text" name="content" size="100" align="center"
								style="width: 900px; height: 400px; background-color: white; border: none;"
								value="${notice.content }"></td>
					</tr>
				</table>


				<div style="display: inline-block;">
					<a class="btn btn-dark  btn-block" style="width: 100px;"
						href="${pageContext.request.contextPath }/notice/list.do?page=${page}"
						role="button">List</a>
				</div>
				<div class="button" style="display: inline-block;">
						<div style="display: inline-block;">
							<input type="submit" class="btn btn-outline-dark  btn-block"
								value="edit">
						</div>
				</div>
			</form>
		</div>
	</div>
	<br>
	<br>
	<!-- footer -->
	<%@include file="/WEB-INF/views/common/footer2.jsp"%>
</body>
</html>

