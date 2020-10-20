<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.java.productOrder.dto.ProductOrderDto, com.java.common.ProductSizeVO, com.java.common.OrderInfoVO"%>
<%@page import="com.java.member.dto.MemberDto, com.java.product.dto.ProductDto, com.java.review.dto.ReviewDto"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/views/review/star-rating/star-rating/css/star-rating.css"
	media="all" type="text/css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/views/review/star-rating/star-rating/css/themes/krajee-fa/theme.css"
	media="all" type="text/css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/views/review/star-rating/star-rating/css/themes/krajee-svg/theme.css"
	media="all" type="text/css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/views/review/star-rating/star-rating/css/themes/krajee-uni/theme.css"
	media="all" type="text/css" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="${pageContext.request.contextPath }/views/review/star-rating/star-rating/js/star-rating.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath }/views/review/star-rating/star-rating/js/themes/krajee-fa/theme.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath }/views/review/star-rating/star-rating/js/themes/krajee-svg/theme.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath }/views/review/star-rating/star-rating/js/themes/krajee-uni/theme.js"
	type="text/javascript"></script>

<style type="text/css">

</style>
</head>
<body>

	<!------ Include the above in your HEAD tag ---------->

<div class="container">


	<div class="row">
		<h2 style="text-align: center">결제정보</h2>
	<br>
	<table class="table table-sm mt-3 mb-5" summary="주문 기본정보를 위한 표">
								<caption>주문 기본정보</caption>
								<colgroup>
									<col width="129">
									<col width="255">
									<col width="129">
									<col width="255">
								</colgroup>
								<tbody>
									<tr>
										<th>주문번호</th>
										<td><strong>${orderinfo.oi_code_num }</strong></td>
										<th>휴대폰번호</th>
										<td>${orderinfo.oi_phone }</td>
									</tr>
									<tr>
										<th>주문자</th>
										<td>${orderinfo.oi_name }</td>
										<th>주문날짜</th>
										<td>${orderinfo.orderDate }</td>
									</tr>
									<tr>
										<th>배송지 주소</th>
										<td colspan="3">${orderinfo.add_addr_full }  ${orderinfo.add_addr_zipNo }</td>
									</tr>	
									<tr>
										<th>배송메모</th>
										<td colspan="3">${orderinfo.deliMessage }</td>
									</tr>	
									<tr>
										<th>결제방법</th>
										<td colspan="3">${orderinfo.howPay }</td>
									</tr>
									<tr>
										<th>상품금액</th>
										<td>${orderinfo.oi_originTotalPrice } 원</td>
										<th>주문금액</th>
										<td>${orderinfo.oi_totalPrice } 원</td>
									</tr>
								</tbody>
								
							</table>
								<div class="col-md-12 text-center">
									<button type="button" class="btn btn-default btn-md" onclick="window.close();">닫기</button>
								</div>
							</div>

</div>
</body>

</html>