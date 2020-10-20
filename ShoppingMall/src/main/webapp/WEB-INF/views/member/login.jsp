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

<title>Shop Homepage - 로그인</title>

<!-- Bootstrap core CSS -->
<link href="<%=request.getContextPath()%>/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="<%=request.getContextPath()%>/resources/css/shop-item.css" rel="stylesheet">
<style type="text/css">
.container{
	height: auto;
	min-height: 78%;
	padding-bottom: 70px;
}
.logincomponent{
	/* padding: 2em; */
    width: 400px;
    margin-left: 32%;
    padding-top: 100px;
    /* padding-bottom: 200px;
    height:600px; */
}


body{
	/* font:Apple SD Gothic Neo; */
	font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, "Noto Sans", sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol", "Noto Color Emoji";
}
.btns{
	
	margin-left: 30%;
}
.btn_login,
.btn_signup{
	display: inline-block;
}


</style>


<script language="javascript" src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
 

</head>
<body>
	<!-- Navigation -->
	<%-- <%@include file ="/views/common/header.jsp" %> --%>
	<%@include file ="/WEB-INF/views/common/header2.jsp" %>
	<!-- Page Container -->
	<div class="container">
	 <div class="row">
	<div class = "logincomponent">
		<form action="${pageContext.request.contextPath }/member/loginOk.do" name="f" method="post">
			<fieldset>
				<legend style="text-align:center;">LOG IN</legend>
					<br>
				<div class="form-group1">
					<!-- <label for="InputID">ID</label>  -->
					<input type="text" class="form-control" id="id" name="id" placeholder="ID">
				</div>
					<br>
				<div class="form-group1">
					<!-- <label for="InputPwd">Password</label>  -->
					<input type="password" class="form-control" id="pwd" name="pwd"
						placeholder="Password">
				</div>
					<br>
				<div class="btns">
					<div class="btn_login" id="btn_login">
						<button type="submit" class="btn btn-dark btn-block">Sign In</button>
					</div>
					<div class="btn_signup" id="btn_signup">
						<input type="button" class="btn btn-outline-dark btn-block" value="Sign Up"
							onclick="location.href='${pageContext.request.contextPath }/member/join.do'">
					</div>
				</div>
					<br>
					<br>
				<div class="searchUser" style="text-align:center;">
					<a style="color: black;text-decoration: none;" href="${pageContext.request.contextPath }/member/searchId.do">Search ID /</a>
					<a style="color: black;text-decoration: none;" href="${pageContext.request.contextPath }/member/searchPwd.do">Search PW</a>
				</div>
			</fieldset>
			<input type="hidden" name="previousUriToken" value="<%=request.getHeader("Referer") %>" />
		</form>
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
	<script src="resources/vendor/jquery/jquery.min.js"></script>
	<script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>