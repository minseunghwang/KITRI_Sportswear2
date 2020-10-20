<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Shop Item - Start Bootstrap Template</title>

<!-- Bootstrap core CSS -->
<link
	href="<%=request.getContextPath()%>/resource/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="<%=request.getContextPath()%>/resource/css/shop-item.css"
	rel="stylesheet">
	
	
	<!-- 팝업 스크립트 -->
	<script type="text/javascript">
	
	function showPopup(currentId) {
		
		var pop_title ="회원 관리";
		var id = currentId;
		window.open("", pop_title, "width=500, height=500, left=200, top=200");
		
		var frmData = document.memberList;
		frmData.target = pop_title;
		frmData.action = "<%=request.getContextPath()%>/MemberManagePopupController?currentId=" + currentId;
		console.log("currentId: " + currentId);
		console.log(frmData.action);
		
	
	}
			
		
	
	
	</script>
	
<style type="text/css">

body{
	font:Apple SD Gothic Neo;
}

	
</style>
	
</head>
<body>

	<nav id ="top">
          <%-- <jsp:include page = "/views/common/header.jsp" /><br><br> --%>
          <%@include file="/WEB-INF/views/common/header2.jsp"%><br><br>
    </nav>
    
    
	<div class="container">
		
		<div class="row">
		
			<!-- leftNavigation -->
			<jsp:include page = "/WEB-INF/views/common/leftNav.jsp" />
			<!-- /leftNavigation -->
		
			<div class="col-lg-10">
		
				<div class = "managememberbox">			
						<form id="memberList" name="memberList" method="post">
						<table class="table table-bordered">
							<thead class="thead-dark">
								<tr style="text-align: center;">
									<th scope="col"><input type="checkbox"></th>
									<th scope="col">ID</th>
									<th scope="col">PWD</th>
									<th scope="col">NAME</th>
									<th scope="col">EMAIL</th>
									<th scope="col">ADDRESS</th>
									<th scope="col">TYPE</th>
									<th scope="col">POINT</th>
									<th scope="col">Edit / Del</th>
								</tr>
							</thead>
							<c:forEach var="list" items="${members }" varStatus="status">
							<tbody>
								<tr style="text-align: center;">
									<td scope="row"><input type="checkbox"></td>
									<td>${list.id }</td>
									<td>${list.pwd }</td>
									<td>${list.name }</td>
									<td>${list.email }</td>
									<td>${list.addr }</td>
									<td>${list.type }</td>
									<td>${list.point }</td>
									<td><input type="submit" class="btn btn-secondary" value="Edit" onClick="showPopup('${list.id}')"></td>
								</tr>
							</tbody>
							</c:forEach>
							</table>
						
						</form>
				</div>
				<!-- /.managememberbox -->
				
			</div>
			<!-- /.col-lg-10 -->
			
		</div>
		<!-- /.row -->
		
	</div>
	<!-- /.container -->
	
	<!-- footer -->
	<%@include file="/WEB-INF/views/common/footer2.jsp"%>

</body>
</html>