<%@ page language="java" pageEncoding="UTf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				action="${pageContext.request.contextPath }/EditNoticeController?num=${notice.num}"
				method="post">
				<%-- <table class="table table-sm mt-3 mb-5" cellspacing="0"
					style="width: 900px; height: 300px; border: none;">
					<tr>
						<c:if test="${sessionScope.memberType != 0 }">
							<td>title<input type="text" name="title"
								value="${notice.title }" size="100" readonly
								style="background-color: white; border: none;"></td>
						</c:if>
						<c:if test="${sessionScope.memberType == 0 }">
							<td>title<input type="text" name="title"
								value="${notice.title }" size="100"
								style="background-color: white; border: none;"></td>
						</c:if>
						<td>no.<input type="text" value="${notice.num }" name="num"
							size="20" readonly style="background-color: white; border: none;"></td>
					</tr>

					<tr>
						
						<td>date<input type="text" value="${notice.n_date }"
							size="20" readonly style="background-color: white; border: none;"></td>
						<td>view_count<input type="text"
							value="${notice.view_count }" name="num" size="20" readonly
							style="background-color: white; border: none;"></td>
					</tr>
					<tr>
						<c:if test="${sessionScope.memberType != 0 }">
							<td>content<input type="text" name="content" readonly
								size="100" style="background-color: white; border: none;">${notice.content }</td>
						</c:if>
						<c:if test="${sessionScope.memberType == 0 }">
							<tr>
								<td>content<input type="text" name="content" size="100"
									style="background-color: white; border: none;">${notice.content }</td>

								<td colspan="2"><br> <br> <br> <br> <br>
									<input class="form-control" type="submit" value="edit"
									style="background-color: #4CAF50; color: white;"> <input
									type="button" class="form-control" value="delete"
									style="background-color: #4CAF50; color: white;"
									onclick="location.href = '${pageContext.request.contextPath }/DeleteNoticeController?num='+${notice.num}">
								</td>
							</tr>
						</c:if>

					</tr>

				</table> --%>

				<table class="table table-sm mt-3 mb-5" cellspacing="0"
					style="width: 900px; height: 300px; border: none;">
					<tr style="height: 50px; border: none; font: bold;">
						<c:if test="${sessionScope.memberType != 0 }">
							<td><p>
									<input type="text" id="title" value="${notice.title }"
										size="40" readonly
										style="background-color: white; border: none;">
								</p></td>
						</c:if>
						<c:if test="${sessionScope.memberType == 0 }">
							<td><p>
									<input type="text" name="title" value="${notice.title }"
										size="40" style="background-color: white; border: none;">
								</p></td>
						</c:if>
					</tr>
					<tr>
						<td style='word-spacing: 10px'>
							<div class="inline">
								<span class="writer">관리자</span> <span class="n_date">${notice.n_date }</span>
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
						<c:if test="${sessionScope.memberType != 0 }">
							<td><input type="text" name="content" readonly size="100" align="center"
								style="width: 900px; height: 400px; background-color: white; border: none;"
								value="${notice.content }"></td>
						</c:if>
						<c:if test="${sessionScope.memberType == 0 }">
							<td><textarea class="form-control" name="content" size="100"  align="center"
									style="width: 900px; height: 400px; background-color: white; border: none;"
									>${notice.content }</textarea></td>
						</c:if>
					</tr>
				</table>


				<div style="display: inline-block;">
					<a class="btn btn-dark  btn-block" style="width: 100px;"
						href="${pageContext.request.contextPath }/ListNoticeController?page=1"
						role="button">List</a>
				</div>
				<div class="button" style="display: inline-block;">
					<c:if test="${sessionScope.memberType == 0 }">
						<div style="display: inline-block;">
							<input type="submit" class="btn btn-outline-dark  btn-block"
								value="edit">
						</div>
						<div style="display: inline-block;">
							<input type="button" class="btn btn-outline-danger  btn-block"
								value="delete"
								onclick="location.href = '${pageContext.request.contextPath }/DeleteNoticeController?num='+${notice.num}">
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

