<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
	
	<!-- Bootstrap core JavaScript -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	
	<style type="text/css">
		img{
			max-width: 100%;
		}
		.carousel slide{
			position : absolute;
			z-index: 100;
		}
		#content_div{
			width: 80%;
			height: 30%;
			margin-left: 10%;
		}
		#product_name{
			margin-top:2px;
			margin-bottom:2px;
		}
		
	</style>

</head>
<body>

	<jsp:include page="/WEB-INF/views/common/header2.jsp" />

	<main role="main">
	
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class=""></li>
				<li data-target="#myCarousel" data-slide-to="1" class=""></li>
				<li data-target="#myCarousel" data-slide-to="2" class="active"></li>
			</ol>
			<div class="carousel-inner">
				<div class="carousel-item">
					<img src="<%=request.getContextPath()%>/resources/upload_img/main_wide_pic.jpg" class="first-slide"  alt="First slide">
					<div class="container">
						<div class="carousel-caption text-left">
							<h1 style="text-shadow:1px 1px 2px darkgray">Start with the gear that does it all</h1>
							<p>Your new essentials are here. Go from warmup to chill out in our abrasion-resistant, breathable, and modern layers</p>
							<p>
								<br>
								<!-- <a class="btn btn-lg btn-primary" href="#" role="button">Sign up today</a> -->
							</p>
						</div>
					</div>
				</div>
				<div class="carousel-item">
					<img src="<%=request.getContextPath()%>/resources/upload_img/main_wide_pic2.jpg" class="second-slide" alt="Second slide">
					<div class="container">
						<div class="carousel-caption">
							<h1 style="text-shadow:1px 1px 2px darkgray">Happy Untact Home Training with Us!</h1>
							<p>Enjoy the energetic and healthy <b>SWEAT LIFE</b> with us at your home</p>
							<p>
								<br>
								<!-- <a class="btn btn-lg btn-primary" href="#" role="button">Learn more</a> -->
							</p>
						</div>
					</div>
				</div>
				<div class="carousel-item active">
					<img src="<%=request.getContextPath()%>/resources/upload_img/main_wide_pic3.jpg" class="third-slide" alt="Third slide">
					<div class="container">
						<div class="carousel-caption text-right">
							<h1>2020 Autumn Collection</h1>
							<p>F/W 신상품 출시</p>
							<p>
								<br>
								<!-- <a class="btn btn-lg btn-primary" href="#" role="button">Browse gallery</a> -->
							</p>
						</div>
					</div>
				</div>
			</div>
			<a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span class="sr-only">Previous</span>
			</a>
			<a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span> <span class="sr-only">Next</span>
			</a>
		</div>
	
		<br><br>
	
		<div class="container marketing">
			<h2>What's New</h2> 
			<br>
			<!-- Three columns of text below the carousel -->
			<div class="row" style="text-align: center;">
			<c:forEach var="newProduct" items="${newProducts }">
				<div class="col-lg-4">
					
						<img class="rounded-circle" src="${pageContext.request.contextPath }/resources/${newProduct.img}" alt="Generic placeholder image" width="250" height="250">
							<br><br>
						<h4 id="product_name">${newProduct.name}</h4> <br>
						<div id="content_div">
							<p style="text-break:break-all;">${newProduct.content}
							</p>
						</div>
						<p>
							<a class="btn btn-secondary" href="${pageContext.request.contextPath }/product/productDetail.do?num=${newProduct.num }&page=1" role="button">View details »</a>
						</p>
						<br>
				</div>
			</c:forEach>

			</div>
			<!-- /.row -->
	
	
			<!-- START THE FEATURETTES -->
	
			<hr class="featurette-divider">
	
			<div class="row featurette">
				<div class="col-md-7">
					<br><br><br><br><br><br><br><br><br>
					<h2 class="featurette-heading" style="text-align:center;">
						PRO ATHLETE <!-- <span class="text-muted"> Development of the Performance</span> -->
					</h2>
					<p class="lead" style="text-align:center;"> For the hardest workers in the room.</p>
				</div>
				<div class="col-md-5">
					<img class="featurette-image img-fluid mx-auto" data-src="holder.js/500x500/auto" alt="500x500" style="width: 500px; height: 500px;" src="<%=request.getContextPath()%>/resources/upload_img/main_collection7-1.jpg" data-holder-rendered="true">
				</div>
			</div>
	
			<hr class="featurette-divider">
	
			<div class="row featurette">
				<div class="col-md-7 order-md-2">
					<br><br><br><br><br><br><br><br><br>
					<h2 class="featurette-heading" style="text-align:center;">
						Your day is a Workout. <span class="text-muted">As original as you</span>
					</h2>
					<p class="lead" style="text-align:center;">일상 속 모든 움직임을 위한 옷</p>
				</div>
				<div class="col-md-5 order-md-1">
					<img class="featurette-image img-fluid mx-auto" data-src="holder.js/500x500/auto" alt="500x500" src="<%=request.getContextPath()%>/resources/upload_img/main_collection8-1.jpg" data-holder-rendered="true" style="width: 500px; height: 500px;">
				</div>
			</div>
	
			<hr class="featurette-divider">
	
			<div class="row featurette">
				<div class="col-md-7">
					<br><br><br><br><br><br><br><br><br>
					
						<h2 class="featurette-heading" style="text-align:center;">
							Online Exclusive Gear is  <span class="text-muted">HERE</span>
						</h2>
						<p class="lead" style="text-align:center;">Free Shipping. Free Returns.</p>
					</div>
				
				<div class="col-md-5">
					<img class="featurette-image img-fluid mx-auto" data-src="holder.js/500x500/auto" alt="500x500" src="<%=request.getContextPath()%>/resources/upload_img/main_collection2.jpg" data-holder-rendered="true" style="width: 500px; height: 500px;">
				</div>
			</div>
	
			<hr class="featurette-divider">
	
			<!-- /END THE FEATURETTES -->
	
		</div>


	</main>
	
 	<jsp:include page="/WEB-INF/views/common/footer2.jsp" /> 

	<!-- Optional JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
</body>
</html>