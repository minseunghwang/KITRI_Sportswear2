<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.java.productOrder.dto.ProductOrderDto"%>
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
<%
	request.setCharacterEncoding("UTF-8");
%>

<!-- Bootstrap core CSS -->
<link
	href="<%=request.getContextPath()%>/resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="<%=request.getContextPath()%>/resources/css/shop-item.css"
	rel="stylesheet">

<link
	href="<%=request.getContextPath()%>/resources/vendor/bootstrap/css/orderPageCss.css"
	rel="stylesheet">

<!-- Bootstrap core JavaScript -->
<script
	src="<%=request.getContextPath()%>/resources/vendor/jquery/jquery.min.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- iamport.payment.js -->
<script type="text/javascript"
	src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>

<script type="text/javascript">
	function goPopup() {
		// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
		var pop = window
				.open(
						"${pageContext.request.contextPath }/views/common/jusoPopup.jsp",
						"pop",
						"width=570,height=420, scrollbars=yes, resizable=yes");

		// 모바일 웹인 경우, 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrMobileLinkUrl.do)를 호출하게 됩니다.
		//var pop = window.open("/popup/jusoPopup.jsp","pop","scrollbars=yes, resizable=yes"); 
	}
	/** API 서비스 제공항목 확대 (2017.02) **/
	function jusoCallBack(roadFullAddr, roadAddrPart1, addrDetail,
			roadAddrPart2, engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn,
			detBdNmList, bdNm, bdKdcd, siNm, sggNm, emdNm, liNm, rn, udrtYn,
			buldMnnm, buldSlno, mtYn, lnbrMnnm, lnbrSlno, emdNo) {
		// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
		document.form.roadAddrPart1.value = roadAddrPart1;
		document.form.roadAddrPart2.value = roadAddrPart2;
		document.form.addrDetail.value = addrDetail;
		document.form.zipNo.value = zipNo;
		document.form.add_addr_full.value = roadFullAddr;
		console.log(document.form.add_addr_full.value);
	}
</script>
</head>
<body>
	<!-- header -->
	<%@include file="/WEB-INF/views/common/header2.jsp"%>


	<!-- Page Content -->
	<div class="container"
		style="padding-top: 10px; padding-bottom: 150px;">
		<form
			action="${pageContext.request.contextPath }/directOrderController"
			name="form" id="form" method="post">

			<!-- 전송할 모든 정보 -->
		


			<div class="row">


				<!-- /.col-lg-9 -->
				<div class="col-lg-8">

					<div class="enrollcomponent">

						<fieldset>
							<div>
								<legend>배송지 정보</legend>
							</div>
							<div class="form-group">
								<label for="InputPwd">수취인 이름</label> <input type="text"
									class="form-control" id="add_name" name="add_name"
									value=${member.name }>
							</div>

							<div class="form-group">
								<label for="InputPwd">휴대전화1</label> <input type="text"
									class="form-control" id="add_phone1" name="add_phone1"
									value="01012345678">
							</div>
							<div class="form-group">
								<label for="InputPwd">휴대전화2</label> <input type="text"
									class="form-control" id="add_phone2" name="add_phone2"
									value="01098765432">
							</div>

							<div class="form-group">
								<label for="InputName">이메일 주소</label> <input type="text"
									class="form-control" id="add_email" name="add_email"
									value=${member.email}>
							</div>

							<div>

								<!-- 배송지 주소 API -->
								<table>
									<colgroup>
										<col style="width: 20%">
										<col>
									</colgroup>
									<tbody>
										<tr>
											<th>우편번호</th>
											<td><input type="hidden" id="confmKey" name="confmKey"
												value=""> <input type="text" id="zipNo" name="zipNo"
												readonly style="width: 100px"> <input type="button"
												value="주소검색" onclick="goPopup();"></td>
										</tr>
										<tr>
											<th>도로명주소</th>
											<td><input type="text" id="roadAddrPart1"
												name="roadAddrPart1" style="width: 85%">
												<input type="hidden" name="add_addr_full" id="add_addr_full" value="">
												</td>
										</tr>
										<tr>
											<th>상세주소</th>
											<td><input type="text" id="addrDetail" name="addrDetail"
												style="width: 40%" value=""> <input type="text"
												id="roadAddrPart2" name="roadAddrPart2" style="width: 40%"
												value=""></td>
												
										</tr>
									</tbody>
								</table>

							</div>

							<div>
								<label>배송 방법</label>
								<ul class="size-selected" id="oi_howDeli" name="oi_howDeli">
									<li class="btn btn-outline-secondary" id="un-selected"
										value="come">방문수령</li>
									<li class="btn btn-outline-secondary" id="un-selected"
										value="tackbae">택배</li>
									<li class="btn btn-outline-secondary" id="un-selected"
										value="quick">퀵</li>
								</ul>
							</div>


							<div>
								<label>배송 요청 사항</label> <input type="text" class="form-control"
									id="oi_deliMessage" name="oi_deliMessage"
									value="배송 또는 주문시 요청 사항을 입력해주세요.">
									
							</div>
							
								<input type="hidden" id="orderName" name="orderName" value=${orderName }> 
								<input type="hidden" id="oi_originTotalPrice" name="oi_originTotalPrice" value=${order_totalPrice }> 
								<input type="hidden" id="oi_usePoint" name="oi_usePoint" value=${member.point }> 
			





							<br>
							<div style="text-align: center;">
								<button type="button" class="btn btn-primary" id="check_module">결제하기</button>
							</div>
						</fieldset>

					</div>


				</div>

				<div class="col-lg-4">

					<div class="prods_info" id="test_box" style="top: 58px;">




						<c:forEach var="o" items="${list }">
							<div class="prodlist">
								<div class="box last container" style="border: outset;">
									<a
										href="<%=request.getContextPath()%>/DetailController?num=${o.p_num}"
										target="_blank">
										<div class="img">
											<img src="${o.prod_img }" class="prd" width="60" height="60">
										</div>
									</a>
									
									
								<%-- 	<a
										href="<%=request.getContextPath()%>/DetailController?num=${o.p_num}&page=1"
										target="_blank">
										<div class="img">
											<img src="${o.prod_img }" class="prd" width="60" height="60">
										</div>
									</a> --%>
									
									
									
									<!-- 부가상품 -->
									<div class="info">
										<div class="tit">
											<a
												href="<%=request.getContextPath()%>/DetailController?num=${o.p_num}"
												target="_blank" class="">${o.prod_name }</a>
												<input type="hidden" name="productOrderNum" value="${o.num }">
										</div>

										<div class="details">사이즈: ${o.p_size } / 수량 :
											${o.o_quantity }</div>
										<div class="price-container">
											<span class="prc">${o.total_price }<span class="won">원</span></span>
										</div>
									</div>
								</div>
							</div>

						</c:forEach>


						<!-- //prodlist -->
						<div class="total_amount">총 주문 상품 : ${order_totalQuantity}개</div>
						<div class="price_box">
							<div class="box clfix">
								<strong>총 주문 가격</strong>
								<div class="price-container">
									<span class="prc"><span class="won">${order_totalPrice }원</span></span>
								</div>
							</div>
							<div class="box clfix">
								<strong>적립금 사용</strong>
								<div class="price-container">
									<span class="prc sale">point</span>
								</div>
							</div>
							<div class="box clfix" style="border-bottom-width: 0;">
								<strong>보유한 총 Point ${member.point} / Point 사용하기</strong>
							</div>



							<div class="box deliv clfix">
								<strong>배송비 <span class="deliv_tooltip"> <span
										class="spt_bg"></span> <span class="tooltip-layer">
											<div class="arrow spt_bg"></div> <span id="chgContents">
												<div class="tooltip-contents"
													style="width: 230px; line-height: 19px;">5만원 이상 구매시
													무료배송 (도서 산간 지역은 추가 배송비 발생) " ajax로 구현 "</div>
										</span>
									</span>
								</span>
								</strong>
								<div class="price-container">
									<span class="prc" id="viewDlvFee"> <span class="won">원</span></span>
								</div>
							</div>

							<!-- 무료배송비 -->
							<div class="box total_p clfix">
								<strong>총 결제금액</strong>
								<div class="price-container">
									<span class="prc" id="TOTAL_PAY_AMT_STR">${productInfo.total_price }<span
										class="won">원 ajax 로 구현</span></span>


									<p class="point">
										예상 적립 포인트 <strong><span id="preSaveRate">${preSave_point }</span>point
											(5%)</strong>
									</p>
								</div>
							</div>
						</div>
						<!-- //price_box -->
					</div>

				</div>


				<!-- /.col-lg-9 -->

			</div>
			<!-- /.row -->
		</form>
	</div>
	<!-- /.container -->

	<!-- Footer -->



	<footer class="py-5 bg-dark">
		<%@include file="/WEB-INF/views/common/footer2.jsp"%>

	</footer>

	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<script>
		$("#check_module").click(function() {
			var IMP = window.IMP; // 생략가능
			
						
					var grpl = $("input[name=productOrderNum]").length;
					//배열 생성
					var grparr = new Array(grpl);
					//배열에 값 주입
					for(var i=0; i<grpl; i++){                          
						grparr[i] = $("input[name=productOrderNum]").eq(i).val();
				    }
			
			// 전송할 데이터
			
			//주문자 관련 정보
			
			
			var productOrderNum = document.getElementsByName("productOrderNum").value;
			console.log("배열로보낸것:" +productOrderNum);
			console.log("배열배열 : " + grparr);
			var voi_deliMessage = document.getElementById("oi_deliMessage").value;
			var voi_originTotalPrice = document.getElementById("oi_originTotalPrice").value;
			var voi_usePoint = document.getElementById("oi_usePoint").value;
			var voi_addr_roadAddrPart1 = document.getElementById("roadAddrPart1").value;
			var voi_addr_roadAddrPart2 = document.getElementById("roadAddrPart2").value;
			var voi_addr_addrDetail = document.getElementById("addrDetail").value;
			//배송지 관련 정보 
			var vadd_name = document.getElementById("add_name").value;
			var vadd_phone1 = document.getElementById("add_phone1").value;
			var vadd_phone2 = document.getElementById("add_phone2").value;
			var vadd_email = document.getElementById("add_email").value;
			var vadd_addr_full = document.getElementById("add_addr_full").value;
			var vadd_addr_zipNo = document.getElementById("zipNo").value;
			var vadd_addr_roadAddrPart1 = document.getElementById("roadAddrPart1").value;
			var vadd_addr_roadAddrPart2 = document.getElementById("roadAddrPart2").value;
			var vadd_addr_addrDetail = document.getElementById("addrDetail").value;
			
			
			
			
			

			IMP.init('imp51699412');
			// 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
			// i'mport 관리자 페이지 -> 내정보 -> 가맹점식별코드
			IMP.request_pay({
				pg : 'inicis', // version 1.1.0부터 지원.
				/*
				 'kakao':카카오페이,
				 html5_inicis':이니시스(웹표준결제)
				 'nice':나이스페이
				 'jtnet':제이티넷
				 'uplus':LG유플러스
				 'danal':다날
				 'payco':페이코
				 'syrup':시럽페이
				 'paypal':페이팔
				 */

				pay_method : 'card',
				/*
				 'samsung':삼성페이,
				 'card':신용카드,
				 'trans':실시간계좌이체,
				 'vbank':가상계좌,
				 'phone':휴대폰소액결제
				 */
				merchant_uid : 'merchant_' + new Date().getTime(),
				/*
				 merchant_uid에 경우
				 https://docs.iamport.kr/implementation/payment
				 위에 url에 따라가시면 넣을 수 있는 방법이 있습니다.
				 참고하세요.
				 나중에 포스팅 해볼게요.
				 */
				name : '${orderName}',
				//결제창에서 보여질 이름
//				amount : '${order_totalPrice }',
				amount : '101',
				//가격
				buyer_email : '${member.email}',
				buyer_name : '${member.name}',
				buyer_tel : '01012345678',
				buyer_addr : '${member.addr}',
				buyer_postcode : '123-456',
				m_redirect_url : 'https://www.yourdomain.com/payments/complete'
			/*
			 모바일 결제시,
			 결제가 끝나고 랜딩되는 URL을 지정
			 (카카오페이, 페이코, 다날의 경우는 필요없음. PC와 마찬가지로 callback함수로 결과가 떨어짐)
			 */
			}, function(rsp) {
				console.log(rsp);
				if (rsp.success) {
					
					$.ajax({
			            type : 'post',
			            async: false,
			            url : '${pageContext.request.contextPath }/OrderDataSaveController',
			            data : {
			            	code_num : rsp.imp_uid,
			                oi_howPay : rsp.pay_method,
			                oi_totalPrice : rsp.paid_amount,
			                oi_status : rsp.status,
			                order_name : rsp.name,
			                oi_name : rsp.buyer_name,
			                oi_email : rsp.buyer_email,
			                oi_phone : rsp.buyer_tel,
			                oi_addr_full : rsp.buyer_addr,
			                oi_addr_zipNo : rsp.buyer_postcode,
			                oi_addr_roadAddrPart1 : voi_addr_roadAddrPart1,
			                oi_addr_roadAddrPart2 : voi_addr_roadAddrPart2,
			                oi_addr_addrDetail : voi_addr_addrDetail,
			                oi_orderDate : rsp.paid_at,
			                oi_deliMessage : voi_deliMessage,
			                oi_originTotalPrice : voi_originTotalPrice,
			                oi_usePoint : voi_usePoint,
			                add_name : vadd_name,
			                add_phone1 : vadd_phone1,	
			                add_phone2 : vadd_phone2,
			                add_email : vadd_email,
			                add_addr_full : vadd_addr_full,
			                add_addr_zipNo : vadd_addr_zipNo,
			                add_addr_roadAddrPart1 : vadd_addr_roadAddrPart1,
			                add_addr_roadAddrPart2 : vadd_addr_roadAddrPart2,
			                add_addr_addrDetail : vadd_addr_addrDetail,
			                oi_productOrderNum : grparr
			                	
			            },
			            error: function(xhr, status, error){
			                alert("실패실패" + error);
			            },
			            success : function(json){
			                alert("결제가 성공적으로 완료되었습니다. 감사합니다.")
			                
			                location.href = "${pageContext.request.contextPath }/OrderlistController?o_state=1"; 
			            }
			        });

				    } else {
				      alert("결제에 실패하였습니다. 에러 내용: " +  rsp.error_msg);
				    }
				
			});
		});
	</script>





</body>
</html>