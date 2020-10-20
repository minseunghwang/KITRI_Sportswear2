<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="com.java.common.Common" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="en">

<head>

   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
   <meta name="description" content="">
   <meta name="author" content="">
   
   <title>Shop Item - Start Bootstrap Template</title>
   
   <!-- Bootstrap core CSS -->
   <link href="<%=request.getContextPath()%>/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
   
   <!-- Custom styles for this template -->
   <link href="<%=request.getContextPath()%>/resources/css/shop-item.css" rel="stylesheet">

   <!-- Bootstrap core JavaScript -->
   <script src="<%=request.getContextPath()%>/resources/vendor/jquery/jquery.min.js"></script>
   <script src="<%=request.getContextPath()%>/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>


   <style type="text/css">
      #detail-img {
         margin-top: 30px;
      }
      
      #viewImg {
         margin-left: 30px;
         margin-top: 30px;
      }
      
      #product-info {
         margin-top: 30px;
         padding-left: 200px;
      }

      #btn_cart{
         margin-top: 10px;
      }

      #select-quantity{
         padding:10px;
      }
      #profile-img{
         float: right;
      }
      #review-img{
         margin:5px;
      }
      #review-id{
         display:inline;
      }
      #review-date{
         float:right;
      }
      <!-- 더보기 -->
       .showstep1{
        max-height: 50;
        overflow: hidden;
       }
       .showstep2{
           max-height: 150;
           overflow: hidden;
       }
       
       .hide{
           display: none;
       }
       #rate{
         text-decoration:none; 
       }
   </style>   



   <script type="text/javascript">
      
   
      <!-- 장바구니 클릭 상품 번호 전달 -->
       function addCart(productNum) {
         
         if(${sessionScope.id == null }){
            if(confirm('로그인이 필요한 서비스 입니다. 로그인 하시겠습니까?')){
               location.href = "<%=request.getContextPath()%>/views/member/login.jsp";
               /* location.href= "${pageContext.request.contextPath }/LoginController"; */
               return;
            }else{
               return;   
            }
         } else{
            
            var unSizeCheck = $("#selected").length ? false : true;
            if(unSizeCheck){
               alert('사이즈를 선택해주세요');
               return;
            }
            
            if(confirm('장바구니에 추가하시겠습니까?')){
               
               var size = $("#selected").text();
               var quantity = $("#select-quantity").text();
               var allData = {"productNum": productNum, "size": size, "quantity": quantity};
         
               $.ajax({
                  type: "post",
                  async: false,
                  url: "${pageContext.request.contextPath }/AddProductCartController",
                  data: allData,
                  success: function (result) {
                     /* var resultMessage = $.trim(result); */
                         if(result == "AddCart Success"){
                        if(confirm('장바구니에 추가되었습니다. 장바구니로 이동하시겠습니까?')){
                           <%-- location.herf = "<%=request.getContextPath()%>/OrderlistController?o_state=0"; --%>
                           location.href= "${pageContext.request.contextPath }/OrderlistController?o_state=0";
                        }
                     }else if(result == "Already Existed"){
                        if(confirm('장바구니에 이미 해당 상품이 있습니다. 장바구니로 이동하시겠습니까?')){
                           <%-- location.herf = "<%=request.getContextPath()%>/OrderlistController?o_state=0"; --%>
                           location.href= "${pageContext.request.contextPath }/OrderlistController?o_state=0";
                        }
                     }else if(result == "Sold Out"){
                        alert('재고가 부족합니다');
                     }else{
                        alert('error');
                     }

                  }
               });
               
            }
            
         } 

         
      }
      
      function directOrder(productNum) {

         
         if(${sessionScope.id == null }){
            if(confirm('로그인이 필요한 서비스 입니다. 로그인 하시겠습니까?')){
               location.href = "<%=request.getContextPath()%>/views/member/login.jsp";
               /* location.href= "${pageContext.request.contextPath }/LoginController"; */
               return;
            }else{
               return;   
            }
         } else {
            
            var unSizeCheck = $("#selected").length ? false : true;
            if(unSizeCheck){
               alert('사이즈를 선택해주세요');
               return;
            }
            var size = $("#selected").text();
            var quantity = $("#select-quantity").text();
            var allData = {"productNum": productNum, "size": size, "quantity": quantity};
      
            location.href ="<%=request.getContextPath()%>/DirectOrderPageController?productNum=" +productNum +"&size=" +size+"&quantity=" + quantity;
            
            
         } 

         
      }
         
         
      
      
      function addReview(id) {
         alert(id);
         if(id == null){
            alert('로그인 후 시도해주세요');
         }else{
            alert('구매 후 시도해주세요');
         }
      }
   
       function priceView(price) {
         var commaCount = 0;
         var priceString = price.toString();

         var priceView = "";
         var count = 0;
         
         for(var i=1; i<=priceString.length; i++){
            priceView += priceString.charAt(priceString.length-i);
            ++count;
            if(count % 3 == 0){
               priceView += ',';
            } 
         }
         
         priceView = priceView.split("").reverse().join("");
         
         if(priceView.charAt(0) == ','){
            priceView = priceView.substr(1);
         }
         return priceView;
      } 
      
      
      $(document).ready(function(){
         var DefaultPrice = ${product.price };
         $.ajax({
            url : "${pageContext.request.contextPath }/product/detailImgList.do",
            type : "get",
            data : "p_num=" + ${product.num},
            success : function(result) {
               arr = $.parseJSON(result);
               var html = "<img id='smallImg' src='${pageContext.request.contextPath }/resources/${product.img }' width='50' height='75'><br><br>";
               for(i = 0; i<arr.length; i++){
                  html += "<img id='smallImg' src='${pageContext.request.contextPath }/resources/" + arr[i].img + "' width='50' height='75'><br><br>";
               }
               $("#detail-img").html(html);
            }
         });

         
         <!-- 상세 이미지에 마우스 올려놓으면 우측 확대이미지 변경 -->
         
         $(document).on('mouseover', '#smallImg', function () {
            var img = $(this).attr('src');
            $('#viewImg').attr('src', img);
         });
         
         <!-- "상품평 전체 보기" 클릭 시 하단 Product reviews로 이동 -->
         $("#rate").click(function scroll_move() {
            var offset = $("#product-reviews").offset();
            $("html").animate({scrollTop:offset.top}, 400);
         });
         <!-- 사이즈 선택 -->
         $("ul.size-selected li").click(function () {
            $("ul.size-selected li").attr("class", "btn btn-outline-secondary");
            $("ul.size-selected li").attr("id", "un-selected")
            $(this).attr("class", "btn btn-secondary");
            $(this).attr("id", "selected");
         });
         
         <!-- 상품 수량 빼기 -->
         $("#decQuantity").click(function countDown() { 
            var quantity = Number($("#select-quantity").text());
            if(quantity >= 2){
               $("#select-quantity").html(quantity-1);   
               $(".quantity-total-price").html('￦'+ priceView((quantity-1) * DefaultPrice));            
            }
            if(quantity == 2){
               $("#countDown").attr("src", "sample_img/ico_decQ_disabled.png");
            }
            
         });
         
         <!-- 상품 수량 증가 -->
         $("#incQuantity").click(function countUp() {
            var quantity = Number($("#select-quantity").text());
            $("#select-quantity").html(quantity+1);
            $(".quantity-total-price").html('￦'+ priceView((quantity+1) * DefaultPrice));
            $("#countDown").attr("src", "sample_img/ico_decQ.png");

         });
         
         
      });
      
      <!-- 더보기 리스너-->
      document.addEventListener('DOMContentLoaded', function(){ //DOM 생성 후 이벤트 리스너 등록
          //더보기 버튼 이벤트 리스너
          document.querySelector('.btn_open').addEventListener('click', function(e){
              
              let classList = document.querySelector('.detailinfo').classList; // 더보기 프레임의 클래스 정보 얻기
              let contentHeight = document.querySelector('.detailinfo > .content').offsetHeight; //컨텐츠 높이 얻기

              // 2단계이면 전체보기로
              if(classList.contains('showstep2')){
                  classList.remove('showstep2');
              }
              // 1단계이면 2단계로
              if(classList.contains('showstep1')){
                  classList.remove('showstep1');
                  if(contentHeight > 600){
                      classList.add('showstep2');
                  }else{
                      document.querySelector('.btn_open').classList.add('hide');
                  }
              }
              //전체보기시 더보기 버튼 감추기 & 감추기 버튼 표시
              if(!classList.contains('showstep1') && !classList.contains('showstep2')){
                  e.target.classList.add('hide');
                  document.querySelector('.btn_close').classList.remove('hide');
                  
              }
              
          });
      });
      
      // 감추기 버튼 이벤트 리스너
/*       document.querySelector('.btn_close').addEventListener('click', function(e){
          e.target.classList.add('hide');
          document.querySelector('.btn_open').classList.remove('hide'); // 더보기 버튼 감춤
          document.querySelector('.detailinfo').classList.add('showstep1'); // 초기 감춤 상태로 복귀
      });
       */
       
      //컨텐츠 로딩 완료 후 높이 기준으로 클래스 재처리
      window.addEventListener('load', function(){
          let contentHeight = document.querySelector('.detailinfo > .content').offsetHeight; //컨텐츠 높이 얻기
          if(contentHeight <= 300){
              document.querySelector('.detailinfo').classList.remove('showstep1'); // 초기값보다 작으면 전체 컨텐츠 표시
              document.querySelector('.btn_open').classList.add('hide'); // 버튼 감춤
          }
      });
   </script>


</head>

<body>

	<!-- Navigation -->
	<%-- <%@include file="/views/common/header.jsp"%> --%>
	<%@include file="/WEB-INF/views/common/header2.jsp"%>

	<!-- Page Content -->
	<div class="container" >
		<article class="row">
		
			<div class="col-lg-1 rounded" id="detail-img">
				<!-- ajax로 해당 상품 디테일 이미지 생성 -->
			</div>
			
			<div class="col-lg-4">
				<img class="card-img-top img-fluid rounded" id="viewImg" src="${pageContext.request.contextPath }/resources/${product.img }">
			</div>
			<div class="col-lg-7" id="product-info">
			
				<!-- 평점 총합 변수 선언 -->
				<c:set var="totalReRating" value="0" />
				
				<!-- 해당 상품의 모든 리뷰 forEach -->
				<c:forEach var="review" items="${reviewsAll}" varStatus="status">
					<!-- 평점 총합에 누적 -->
					<c:set var="totalReRating" value="${totalReRating + review.rate}"/>
					<!-- 마지막 리뷰일 경우 -->
					<c:if test="${status.last }">
						<!-- 평점 평균 반올림 -->
						<c:set var="avgReRating" value="${totalReRating / status.count}" />
						<c:set var="avgReRating" value="${avgReRating + (((avgReRating%1)>=0.5)?(1-(avgReRating%1)):-(avgReRating%1)) }" />
					</c:if>
				</c:forEach>
			
				<!-- 채워진 별 -->															
				<c:forEach var="colorStar" begin="1" end="${avgReRating}">
					<small class="text-warning">&#9733;</small>
				</c:forEach>
				
				<!-- 빈 별 -->
				<c:forEach var="emptyStar" begin="1" end="${5 - avgReRating}">
					<small class="text-warning">&#9734;</small>
				</c:forEach>
				<small>${reviewsAll.size() } </small><a href="#" id="rate" onclick="scroll_move()" >상품평 전체 보기</a><br><br>
				
				<h3>${product.name }</h3><br>
				<h4 class="quantity-total-price">￦${product.priceView }</h4><br>
				<p>${product.content }</p>
				<br>
				<ul class="size-selected">
					<li class="btn btn-outline-secondary" id="un-selected" value="XL">XL</li>
					<li class="btn btn-outline-secondary" id="un-selected" value="L">L</li>
					<li class="btn btn-outline-secondary" id="un-selected" value="M">M</li>
				</ul>
				<br>
				<div class="select-amount">
					<a href="#" id="decQuantity" onclick="countDown()">
						<img src="${pageContext.request.contextPath }/resources/sample_img/ico_decQ_disabled.png" id="countDown">
					</a>
					<span id="select-quantity">1</span>
					<a href="#" id="incQuantity" onclick="countUp()">
						<img src="${pageContext.request.contextPath }/resources/sample_img/ico_incQ.png" id="countUp">
					</a>
				</div>
				<br><br>
				
				<div style="text-align: center;">
					<div id="btn_buy" >
						<input class="btn btn-outline-dark btn-lg btn-block" type="button" value="결제하기" onClick="directOrder('${product.num}');">
					</div>
					<div id="btn_cart">
						<input class="btn btn-dark btn-lg btn-block" type="button" value="장바구니" onClick="addCart('${product.num}');">
					</div>
				</div>
			</div>
			

		</article>
		<br> <br>
		<!-- /.card -->
		<div class="card card-outline-secondary my-4">
			<div class="card-header" id="product-reviews">
				<h6>Product Reviews</h6>
			</div>
			<div class="card-body" style="padding-bottom:0">
			
				<c:if test="${0 == reviews.size() }">
					<p>리뷰가 없습니다.</p>
				</c:if>
				
				<c:forEach var="review" items="${reviews }">
					<div class="reviewer-info">
						<div class="stars-part">
							<!-- 채워진 별 -->															
							<c:forEach var="colorStar" begin="1" end="${review.rate}">
								<span class="text-warning">&#9733;</span>
							</c:forEach>
							
							<!-- 빈 별 -->
							<c:forEach var="emptyStar" begin="1" end="${5 - review.rate}">
								<span class="text-warning">&#9734;</span>
							</c:forEach>
							&nbsp;&nbsp;&nbsp;
							<c:if test="${review.rate>=4 }">
								<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-emoji-laughing" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
								  <path fill-rule="evenodd" d="M8 15A7 7 0 1 0 8 1a7 7 0 0 0 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
								  <path fill-rule="evenodd" d="M12.331 9.5a1 1 0 0 1 0 1A4.998 4.998 0 0 1 8 13a4.998 4.998 0 0 1-4.33-2.5A1 1 0 0 1 4.535 9h6.93a1 1 0 0 1 .866.5z"/>
								  <path d="M7 6.5c0 .828-.448 0-1 0s-1 .828-1 0S5.448 5 6 5s1 .672 1 1.5zm4 0c0 .828-.448 0-1 0s-1 .828-1 0S9.448 5 10 5s1 .672 1 1.5z"/>
								</svg>
							</c:if>
							
							<c:if test="${review.rate==3 }">
								<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-emoji-smile" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
								  <path fill-rule="evenodd" d="M8 15A7 7 0 1 0 8 1a7 7 0 0 0 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
								  <path fill-rule="evenodd" d="M4.285 9.567a.5.5 0 0 1 .683.183A3.498 3.498 0 0 0 8 11.5a3.498 3.498 0 0 0 3.032-1.75.5.5 0 1 1 .866.5A4.498 4.498 0 0 1 8 12.5a4.498 4.498 0 0 1-3.898-2.25.5.5 0 0 1 .183-.683z"/>
								  <path d="M7 6.5C7 7.328 6.552 8 6 8s-1-.672-1-1.5S5.448 5 6 5s1 .672 1 1.5zm4 0c0 .828-.448 1.5-1 1.5s-1-.672-1-1.5S9.448 5 10 5s1 .672 1 1.5z"/>
								</svg>
							</c:if>
							
							<c:if test="${review.rate<3 }">
								<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-emoji-frown" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
								  <path fill-rule="evenodd" d="M8 15A7 7 0 1 0 8 1a7 7 0 0 0 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
								  <path fill-rule="evenodd" d="M4.285 12.433a.5.5 0 0 0 .683-.183A3.498 3.498 0 0 1 8 10.5c1.295 0 2.426.703 3.032 1.75a.5.5 0 0 0 .866-.5A4.498 4.498 0 0 0 8 9.5a4.5 4.5 0 0 0-3.898 2.25.5.5 0 0 0 .183.683z"/>
								  <path d="M7 6.5C7 7.328 6.552 8 6 8s-1-.672-1-1.5S5.448 5 6 5s1 .672 1 1.5zm4 0c0 .828-.448 1.5-1 1.5s-1-.672-1-1.5S9.448 5 10 5s1 .672 1 1.5z"/>
								</svg>
							</c:if>
						</div>
						<div class="writer-date">
							<!-- <img src="sample_img/user_basic.png" width="50" id="profile-img"> -->
							<p class="text-muted" id="review-id">작성자 &nbsp;&nbsp;<b>${review.m_id }</b></p>
							<p class="text-muted" id="review-date">작성일 &nbsp;&nbsp;${review.r_date }</p>
						</div>
						<br>
						<!--  -->
						<div class="image-content" style="box-sizing: border-box; overflow:hidden;">
							<div id="image" style="width:75px;  float:left;">
								<img width="50px" height="75" src="${pageContext.request.contextPath }/resources/${review.img}" id="review-img">
							</div>
							<div class="content" id="content" style="width:100%; height:50">${review.content }</div>	
							<!-- <a href="#" class="btn_open">더보기</a>
							<a href="#" class="btn_close hide">감추기</a> -->
						</div>
						
						
						<hr>
						
					</div>
				</c:forEach>
					
					
	
				<%-- <input type="button" class="btn btn-success" value="Leave a Review" onClick="addReview(<%=(String)session.getAttribute("id")%>);" > --%> <!-- 미완성 -->
			</div>
			
			<c:if test="${0 != reviews.size() }">
				<div class="page" id="page" style="margin-bottom:0;">
				<!-- pagination -->
			
					<nav aria-label="...">
						<ul class="pagination justify-content-center">
						<c:if test="${1 != pn.page }">
							<li class="page-item">
								<a class="page-link" href="${pageContext.request.contextPath }/product/detailImgList.do?num=${product.num }&page=1" aria-label="Previous">
									<span aria-hidden="true">&laquo;</span>
								</a>
							</li>
							<li class="page-item">
								<a class="page-link" href="${pageContext.request.contextPath }/product/detailImgList.do?num=${product.num }&page=${param.page-1}" aria-label="Previous">
									<span aria-hidden="true">&lsaquo;</span>
								</a>
							</li>
						</c:if>
		
						<c:forEach var="pageNum" begin="${pn.startPage }" end="${pn.endPage }" step="1">
									
							<c:choose>
								<c:when test="${param.page eq pageNum}">
									<li class="page-item active" aria-current="page">
								</c:when>
								<c:otherwise>
									<li class="page-item">
								</c:otherwise>
							</c:choose>
										<a class="page-link" href="${pageContext.request.contextPath }/product/detailImgList.do?num=${product.num }&page=${pageNum }">${pageNum }</a>
							<c:if test="${param.page eq pageNum}">
											<span class="sr-only">(current)</span>
									</li>
							</c:if>
						</c:forEach>
		
						<c:if test="${pn.totalPage != pn.page }">
							<li class="page-item">
								<a class="page-link" href="${pageContext.request.contextPath }/product/detailImgList.do?num=${product.num }&page=${param.page+1}" aria-label="Next">
									<span aria-hidden="true">&rsaquo;</span>
								</a>
							</li>
							<li class="page-item">
								<a class="page-link" href="${pageContext.request.contextPath }/product/detailImgList.do?num=${product.num }&page=${pn.totalPage }" aria-label="Next">
									<span aria-hidden="true">&raquo;</span>
								</a>
							</li>
						</c:if>
							
						</ul>
					</nav>
			
			<!-- /pagination -->
			</div>
			</c:if>
			
			
		</div>
		<!-- /.card -->
		
		
		
		<br>
		<br>
	
	</div>
	
	<!-- /.container -->
<%--
	<!-- Footer -->
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; Your Website 2020</p>
		</div>
		<!-- /.container -->
	</footer>
 --%>
			<!-- footer -->
	<%@include file="/WEB-INF/views/common/footer2.jsp"%>

</body>

</html>