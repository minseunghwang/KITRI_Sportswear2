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
			<form>
				

				<table class="table table-sm mt-3 mb-5" cellspacing="0"
					style="width: 900px; height: 300px; border: none;">
					<tr style="height: 50px; border: none; font: bold;">
						<%-- <c:if test="${sessionScope.memberType != 0 }"> --%>
							<td><p>
									<input type="text" id="title" value="${notice.title }"
										size="40" readonly
										style="background-color: white; border: none;">
								</p></td>
					<%-- 	</c:if>
						<c:if test="${sessionScope.memberType == 0 }">
							<td><p>
									<input type="text" name="title" value="${notice.title }"
										size="40" style="background-color: white; border: none;">
								</p></td>
						</c:if> --%>
					</tr>
					<tr>
						<td style='word-spacing: 10px'>
							<div class="inline">
								<span class="writer">관리자</span> <span class="n_date"><fmt:formatDate value="${notice.n_date}" pattern="yyyy.MM.dd" /></span>
								<svg width="1em" height="1em" viewBox="0 0 16 16"
									class="bi bi-eye" fill="currentColor"
									xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd"
										d="M16 8s-3-5.5-8-5.5S0 8 0 8s3 5.5 8 5.5S16 8 16 8zM1.173 8a13.134 13.134 0 0 0 1.66 2.043C4.12 11.332 5.88 12.5 8 12.5c2.12 0 3.879-1.168 5.168-2.457A13.134 13.134 0 0 0 14.828 8a13.133 13.133 0 0 0-1.66-2.043C11.879 4.668 10.119 3.5 8 3.5c-2.12 0-3.879 1.168-5.168 2.457A13.133 13.133 0 0 0 1.172 8z" />
  									<path fill-rule="evenodd"d="M8 5.5a2.5 2.5 0 1 0 0 5 2.5 2.5 0 0 0 0-5zM4.5 8a3.5 3.5 0 1 1 7 0 3.5 3.5 0 0 1-7 0z" />
								</svg>
								<span class="view_count">${notice.view_count }</span>
							</div>
						</td>
					</tr>

					<tr>
							<td><input type="text" name="content" readonly size="100" align="center"
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
					<c:if test="${sessionScope.memberType == 0 }">
						<div style="display: inline-block;">
							<input type="button" class="btn btn-outline-dark  btn-block"
								value="edit"
								onclick="location.href = '${pageContext.request.contextPath }/notice/update.do?num='+${notice.num}+'&page='+${page}">
						</div>
						<div style="display: inline-block;">
							<input type="button" class="btn btn-outline-danger  btn-block"
								value="delete"
								onclick="location.href = '${pageContext.request.contextPath }/notice/deleteOk.do?num='+${notice.num}+'&page='+${page}">
						</div>

					</c:if>
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

