<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="col-lg-auto">

		<div class="list-group">
			<a href="${pageContext.request.contextPath }/admin/product/adminProductManagement.do?page=1" class="list-group-item">상품 목록</a>
			<a href="${pageContext.request.contextPath }/admin/product/adminProductAddForm.do" class="list-group-item">상품 등록</a>
			<a href="${pageContext.request.contextPath }/admin/memberManage/memberManage.do" class="list-group-item">회원 관리</a>
		</div>

	</div>
	
</body>
</html>