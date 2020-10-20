<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.java.member.dto.MemberDto"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Shop Homepage - 비밀번호 찾기</title>

<!-- Bootstrap core CSS -->
<link href="<%=request.getContextPath()%>/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="<%=request.getContextPath()%>/resources/css/shop-item.css" rel="stylesheet">
<style type="text/css">
.container{
	height: auto;
	min-height: 77.5%;
	padding-bottom: 70px;
}
.searchIDcomponent{
	padding: 2em;
    width: 400px;
    margin-left: 30%;
    padding-top: 100px;
    padding-bottom: 200px;
    height:600px;
}
.spantext{
	text-align: center;
}

body{
	font:Apple SD Gothic Neo;
}
.btns{
	width: 100%;
	margin-left:30%;
}
.btn_login,
.btn_findpwd{
	display: inline-block;
}
</style>

</head>
<body>
	<!-- Navigation -->
	<%-- <%@include file ="/views/common/header.jsp" %> --%>
	<%@include file ="/WEB-INF/views/common/header2.jsp" %>
	<!-- Page Container -->
	<div class="container">
	 <div class="row">
	<div class = "searchIDcomponent">
		
		
			<fieldset>
				<legend style="text-align:center;">Search Password</legend>
					<br>
				
				<div class="form-group1">
					<c:if test="${id ==null}">
						<p class="spantext"> You entered a wrong id or email address.</p>
					</c:if>
					<c:if test="${id !=null}">
						<p class="spantext">Your temporary password is  ' <b>${pwd } </b> '</p>
					</c:if>
				</div>
					<br>
					
				<div class="btns">
					<div class="btn_login">
						<input type="button" class="btn btn-dark" value="Go to Signin" 
						onclick="location.href='${pageContext.request.contextPath }/member/login.do'">
					</div>
				</div>
					
				
			</fieldset>
			
		
		</div>
	</div>
	</div>




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