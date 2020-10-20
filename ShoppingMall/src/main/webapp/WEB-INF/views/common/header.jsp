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
	
	<title>Shop Homepage - Start Bootstrap Template</title>
	
	  <!-- Bootstrap core CSS -->
  <link href="<%=request.getContextPath()%>/resource/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="<%=request.getContextPath()%>/resource/css/shop-item.css" rel="stylesheet">

</head>


<body>

<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">

		<!-- Main LOGO -->
		<div class="logo">
			<a href="<%=request.getContextPath()%>/MainListController">
				<img
				src="https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_92x30dp.png"
				width="100px" , height="50px">
			</a>
		</div>
		
		

		<!-- top-navbar -->
		<div class="container" style="flex-flow: column; max-width: none;">

			<!-- top-navbar -->

			<div class="container" id="top-navbar"
				style="max-width: -webkit-fill-available;">
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarResponsive" aria-controls="navbarResponsive"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarResponsive">
					<ul class="navbar-nav ml-auto">



						<!-- 비로그인 상태 -->
						<c:if test="${empty sessionScope.id }">
							<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath }/ListNoticeController">공지사항</a></li>
							<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/views/member/login.jsp">주문조회	</a></li>
							<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/views/member/signup.jsp">회원가입</a></li>
							<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/views/member/login.jsp">로그인</a></li>
							
						</c:if>

						<!-- 일반사용자 로그인 상태 -->
						<c:if test="${sessionScope.memberType == 1 }">
							<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath }/ListNoticeController">공지사항</a></li>
							<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath }/MypageController?o_state=1">마이페이지</a></li>
							<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath }/AllOrderListController?o_state=1">주문조회</a></li>
							<li class="nav-item"><a class="nav-link"
								href="<%=request.getContextPath()%>/LogoutController">로그아웃</a></li>


						</c:if>

						<!-- 관리자 로그인 상태 -->

						<c:if test="${sessionScope.memberType == 0 }">
			
							<li class="nav-item"><a class="nav-link" href="#">마이페이지</a></li>
							<li class="nav-item"><a class="nav-link"
								href="<%=request.getContextPath()%>/LogoutController">로그아웃</a></li>
							

						</c:if>


						<!-- <script type="text/javascript">
					doucment.write("사랑")
					
					var loginSession = null;
					document.write("<li class='nav-item'><a class='nav-link' href='#''>회원가입</a></li>");
					loginSession = (String) sessionStorage.getItem(id);
					console.log(loginSession)
						if(loginSession != "null" && loginSession != "") { /* 로그인상태인 경우 */
							if(V_HD_MEM_TYPE == "R" ) { /* 회원인 경우 */
								document.write("<li class='nav-item'><a class='nav-link' href='#''>회원가입</a></li>");
								document.write("<li><a href='javascript:fn_logIn(8);' onmousedown='javascript:fn_trkClickTrace(\"^최상단^마이페이지\");'>주문조회</a></li>");
							}else {
								document.write("<li><a href='javascript:fn_logIn(8);' onmousedown='javascript:fn_trkClickTrace(\"^최상단^마이페이지\");'>주문조회</a></li>");
							}
							document.write("<li class='login last'><a href='javascript:fn_logOut();'>로그아웃</a><div class='spt_bg ico_login'></div></li>");
						}else { /* 로그아웃 상태인 경우 */
							var myUrl = "https://shop.adidas.co.kr/PF060101.action";
							document.write("<li><a href='javascript:go_myPageMan(\""+myUrl+"\");' onmousedown='javascript:fn_trkClickTrace(\"^최상단^마이페이지\");' title='새창 로그인'>주문조회</a></li>");
							document.write("<li id='register_btn'><a href='javascript:fn_logIn(5);' onmousedown='javascript:fn_trkClickTrace(\"^최상단^회원가입\");'>회원가입</a></li>");
							document.write("<li class='login last'><a href='javascript:fn_logIn(0);' onmousedown='javascript:fn_trkClickTrace(\"^최상단^로그인\");' title='새창 로그인'>로그인</a><div class='spt_bg ico_login'></div></li>");
						}
					</script> -->


						<!-- <li class="nav-item active"><a class="nav-link" href="#">주문조회
								<span class="sr-only">(current)</span>
						</a></li>
						<li class="nav-item"><a class="nav-link" href="#">회원가입</a></li>
						<li class="nav-item"><a class="nav-link" href="/views/login.jsp">로그인</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Contact</a>
						</li> -->

						<!-- 네비게이션 검색창 -->



					</ul>
				</div>
			</div>

			<!-- bottom-navbar -->
			<div class="container" id="bottom-navbar"
				style="max-width: -webkit-fill-available;">


				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarResponsive" aria-controls="navbarResponsive"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarResponsive">
					<ul class="navbar-nav mr-auto">


						<!-- 비로그인 상태 -->
						<c:if test="${empty sessionScope.memberType}">
							<li class="nav-item active"><a class="nav-link"
								href="<%=request.getContextPath()%>/MainListController">Home
									<span class="sr-only">(current)</span>
							</a></li>
							<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/CategoryController?category=top&page=1">TOP</a></li>
							<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/CategoryController?category=bottom&page=1">BOTTOM</a>

						</c:if>

						<!-- 일반사용자 로그인 상태 -->
						<c:if test="${sessionScope.memberType == 1 }">
							<li class="nav-item active"><a class="nav-link"
								href="<%=request.getContextPath()%>/MainListController">Home
									<span class="sr-only">(current)</span>
							</a></li>
							<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/CategoryController?category=top&page=1">TOP</a></li>
							<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/CategoryController?category=bottom&page=1">BOTTOM</a>

						</c:if>

						<!-- 관리자 로그인 상태 -->

						<c:if test="${sessionScope.memberType == 0 }">
							<li class="nav-item">
								<a class="nav-link" href="<%=request.getContextPath()%>/ProductAllListController">상품관리</a>
							</li>
							<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/MemberManageController">회원관리</a></li>
							</li>
							<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath }/ListNoticeController"">공지사항</a></li>

						</c:if>

						<%-- <li class="nav-item active"><a class="nav-link"
							href="<%=request.getContextPath()%>/views/main/main.jsp">Home
								<span class="sr-only">(current)</span>
						</a></li>
						<li class="nav-item"><a class="nav-link" href="#">About</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Services</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="#">Contact</a>
						</li> --%>
					</ul>

					<div class="collapse navbar-collapse" id="navbarResponsive">
						<!-- 네비게이션 검색창 -->
						<ul class="navbar-nav ml-auto">
							<li class="nav-item">
								<div class="search_area">
									<div class="search">
										<form id="frmSrchTop" name="frmSrchTop" method="post"
											onsubmit="return false;" action="">
											<input type="text" name="S_PROD_NM_TOP" id="S_PROD_NM_TOP"
												class="sh" autocomplete="off"
												onfocus="this.value='';document.getElementById('S_SEARCH_WORDS_URL').value='';"
												onmousedown="dqtop_charLen(this.value);"
												onkeypress="keyDownTop('1',event);"
												onkeydown="keyDownTop('1',event);"> 
												<a href="#"
												onclick="fn_search_top();"
												onmousedown="javascript:fn_trkClickTrace('^최상단^검색');"
">검색</a>
										</form>
									</div>
								</div>
							</li>

							<div class="market abtest">
								<!-- <script type="text/javascript">
									if (V_HD_MEM_CART_CNT != "null"
											&& V_HD_MEM_CART_CNT != "") { /* 로그인상태인 경우 */
										if (V_HD_MEM_CART_CNT > 0) {
											document
													.write("<a href='javascript:void(0);fn_goCart();' onmousedown='javascript:fn_trkClickTrace(\"^최상단^장바구니\");'><div><img src='//image.adidas.co.kr/images/adidas/common/cart_DT.png' alt='''></div><strong>"
															+ V_HD_MEM_CART_CNT
															+ "</strong></a>");
										} else {
											document
													.write("<a href='javascript:fn_logIn(7);'><div><img src='//image.adidas.co.kr/images/adidas/common/cart_DT.png' alt='''></div><strong>0</strong></a>");
											document
													.write("<div class='no_data_layer' style='display:none;'><span class='spt_bg'></span>장바구니가 비어있습니다.</div>");
										}
									} else {
										document
												.write("<a href='javascript:fn_logIn(7);'><div><img src='//image.adidas.co.kr/images/adidas/common/cart_DT.png' alt='''></div></a>");
										document
												.write("<div class='no_data_layer' style='display:none;'><span class='spt_bg'></span>장바구니가 비어있습니다.</div>");
									}
								</script> -->
								
								
								
								
								<a href="${pageContext.request.contextPath }/OrderlistController?o_state=0">
									<div>
										<img
											src="//image.adidas.co.kr/images/adidas/common/cart_DT.png"
											alt=""'="">
									</div>
								</a>
								<div class="no_data_layer" style="display: none;">
									<span class="spt_bg"></span>장바구니가 비어있습니다.
								</div>
							</div>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</nav>
	
</body>
</html>