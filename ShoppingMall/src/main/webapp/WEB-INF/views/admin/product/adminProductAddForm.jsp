<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
	
	<style type="text/css">
		html{
			height: 100%;
		}
	
	</style>
	
	<script src="<%=request.getContextPath()%>/resources/vendor/jquery/jquery.min.js" type="text/javascript"></script>
	<script type="text/javascript">

		$(document).ready(function() {
	
			$("#detail_img1").hide();
			$("#detail_img2").hide();
			$("#detail_img3").hide();
			
			$("#addbtn").click(function() {
				if(!$("#detail_img1").is(":visible")){
					$("#detail_img1").show();
				}else if(!$("#detail_img2").is(":visible")){
					$("#detail_img2").show();
				}else if(!$("#detail_img3").is(":visible")){
					$("#detail_img3").show();
				}
			});
			$("#delbtn").click(function() {
				if($("#detail_img3").is(":visible")){
					$("#detail_img3").hide();
				}else if($("#detail_img2").is(":visible")){
					$("#detail_img2").hide();
				}else if($("#detail_img1").is(":visible")){
					$("#detail_img1").hide();
				}
			});
	
		});
		
	</script>
</head>
<body>

	<!-- Navigation -->
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

				<form action="${pageContext.request.contextPath }/admin/product/adminProductAddFormOk.do" method="post" enctype="multipart/form-data" onsubmit="return check()">
					<table class="table table-bordered">
						<thead class="thead-dark">
							<tr style="text-align: center;">
								<th scope="col">구분</th>
								<th>Content</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th scope="col">상품명</th>
								<td><input type="text" name="name"></td>
							<tr>
							<tr>
								<th scope="col">카테고리</th>
								<td>
									<select name="category">
										<option disabled selected>-----필수-----</option>
										<option value="top">상의</option>
										<option value="bottom">하의</option>
									</select>
								</td>
							</tr>
							<tr>
								<th scope="col">가격</th>
								<td><input type="text" name="price"></td>
							</tr>
							<tr>
								<th scope="col">대표 이미지</th>
								<td><input type="file" name="file"></td>
							</tr>
							<tr>
								<th scope="col">상세 이미지1</th>
								<td>
									<input type="file" name="file1">
									<input class="btn btn-outline-success" type="button" id="addbtn" value="Img Add">
									<input class="btn btn-outline-danger" type="button" id="delbtn" value="Img Del">
								</td>
							</tr>
							<tr id="detail_img1">
								<th scope="col">상세 이미지2</th>
								<td><input type="file" name="file2"></td>
							</tr>
							<tr id="detail_img2">
								<th scope="col">상세 이미지3</th>
								<td><input type="file" name="file3"></td>
							</tr>
							<tr id="detail_img3">
								<th scope="col">상세 이미지4</th>
								<td><input type="file" name="file4"></td>
							</tr>
							<tr>
								<th rowspan="2">상세설명</th>
								<td><textarea rows="5" cols="100" name="content"></textarea></td>
							</tr>
							<tr>
								<td>
									<input class="btn btn-success" type="submit" value="Upload">
									<input class="btn btn-primary" type="reset" value="Reset">
								</td>
							</tr>
						</tbody>
					</table>
				</form>
			
			</div>
			<!-- /.col-lg-10 -->
			
		</div>
		<!-- /.row -->
		
	</div>
	<!-- /.container -->

	<!-- footer -->
	<%@include file="/WEB-INF/views/common/footer2.jsp"%>

	<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>

</body>
</html>