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

<title>Shop Homepage - 아이디 찾기</title>

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
	/* padding: 2em; */
    width: 400px;
    margin-left: 32%;
    padding-top: 100px;
  /*   padding-bottom: 200px; */
   /*  height:600px; */
}


body{
	font:Apple SD Gothic Neo;
}

#btn_findid{
	align:center;
	margin-left: 35%;
	text-align:center;
	
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
		
		<form action="${pageContext.request.contextPath }/member/getId.do" name="f" method="post">
			<fieldset>
				<legend style="text-align:center;">Search ID</legend>
					<br>
				<div class="form-group1">
					<!-- <label for="InputID">ID</label>  -->
					<input type="text" class="form-control" id="name" name="name" placeholder="Name">
				</div>
					<br>
				<div class="form-group1">
					<input type="email" class="form-control" id="email" name="email"
						placeholder="Email">
						<small 
						id="searchIdHelp" class="form-text text-muted">Enter your email address registered on your account.</small>
				</div>
					<br>
					
				
				<div class="form-group1">
					<button type="submit" id="btn_findid"class="btn btn-outline-dark">Search Id</button>
				</div>
					
				
					
				
			</fieldset>
			
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
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>