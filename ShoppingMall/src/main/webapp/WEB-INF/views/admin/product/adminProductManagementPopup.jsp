<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<style type="text/css">
		th, td{
			text-align: left;
		}

	</style>
	
	<script type="text/javascript">
		function quantityInsert(productNum) {
			
			var sel = document.getElementById("size");
			var size = sel.options[sel.selectedIndex].value;
			
			var quantity = document.getElementById("quantity").value;

			opener.location.href = '${pageContext.request.contextPath}/ProductSizeAddController?productNum=' + productNum + '&size=' + size + '&quantity=' + quantity;

			self.close();
		}
	
	</script>
</head>
<body>
		<fieldset>
			<legend>재고 관리</legend>
			
			<table>
				<tr> 
					<td colspan="2" style="text-align: center;">
						<img src="${product.img}"  width="100" height="150">
					</td>
				</tr>
				<tr>
					<th>상품명</th>
					<td>${product.name}</td>
				</tr>
				<tr>
					<th>가격</th>
					<td>${product.priceView}</td>
				</tr>
				<tr>
					<th>사이즈</th>
					<td>
						<select id="size">
							<option value="">사이즈 선택</option>
							<option value="XL">XL</option>
							<option value="L">L</option>
							<option value="M">M</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>입고 수량</th>
					<td>
						<input type="text" id="quantity">
					</td>
				</tr>
				
			</table>
		
			<input type="button" value="입고" onclick="quantityInsert('${product.num}');"> 
			<input type="button" value="닫기" onclick="self.close();"> 
			
		</fieldset>
	

</body>
</html>