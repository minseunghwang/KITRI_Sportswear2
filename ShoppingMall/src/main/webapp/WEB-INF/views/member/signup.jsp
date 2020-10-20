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

<title>Shop Homepage - 회원가입</title>

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
.enrollcomponent{
	/* padding: 2em; */
    width: 500px;
    margin-left: 27%;
    padding-top: 50px;
   /*  padding-bottom: 150px; */
}


body{
	font:Apple SD Gothic Neo;
}
.btns{
	width: 100%;
	margin-left: 40%;
}

.btn_signup{
	display: inline-block;
}

</style>
<script type="text/javascript">

function idCheck(root){//아이디 중복 확인을 누르면 입력한 아이디를 가지고 들어가야한다.
	   if($("input[name = 'id']").val() == ""){
	      alert("아이디를 입력하세요");
	      $("input[name = 'id']").focus();
	      return false;
	   }
	   
	   var url = root+"/member/idCheck.do?id=" + $("input[name = 'id']").val();
	   
	   window.open(url, "", "width = 250, height = 150");
	}

</script>

</head>
<body>
	<!-- Navigation -->
	<%-- <%@include file ="/views/common/header.jsp" %> --%>
	<%@include file ="/WEB-INF/views/common/header2.jsp" %>
	<!-- Page Container -->
	<div class="container">
	<div class = "enrollcomponent">
		
		<form action="${pageContext.request.contextPath }/member/joinOk.do" name="f" method="post">
			<fieldset>
				<legend style="text-align:center;">SIGN UP</legend>
				
				<div class="form-group">
					<label for="InputID">ID</label> 
					<input type="text" class="form-control" id="id" name="id">
					<input type="button" class="btn btn-primary" id="check_btn" value="중복확인" onclick="idCheck('${pageContext.request.contextPath }')"/>
				</div>
				
				<div class="form-group">
					<label for="InputPwd">Password</label> <input
						type="password" class="form-control" id="pwd" name="pwd"
						placeholder="Password">
				</div>
				
				<div class="form-group">
					<label for="InputName">Name</label> <input
						type="text" class="form-control" id="name" name="name">
				</div>
				
				<div class="form-group">
					<label for="InputEmail">Email address</label> <input
						type="email" class="form-control" id="email" name="email"
						aria-describedby="emailHelp" placeholder="Enter email"> <small
						id="emailHelp" class="form-text text-muted">We'll never
						share your email with anyone else.</small>
				</div>
				<!-- 주소api 추후 추가 -->
				<div class="form-group">
					<label for="InputAddress">Address</label> <input
						type="text" class="form-control" id="addr" name="addr">
				</div>
				<div class="btns">
					<div class="btn_signup">
						<button type="submit" class="btn btn-dark btn-block" >SignUp</button>
						<!-- <input type="button" class="btn btn-primary" id="check_btn" value="중복" onclick="idcheck();"> -->
							<!-- <div id="here"></div> -->
					</div>
				</div>
			</fieldset>
		</form>
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