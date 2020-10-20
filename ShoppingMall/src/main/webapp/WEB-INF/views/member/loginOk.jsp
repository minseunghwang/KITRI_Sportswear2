<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath }"/>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${type != null }">
		<c:set var="id" value="${id }" scope="session"/>	<!-- 동일 context(프로젝트) 내에서 계속 사용가능 -->
		<c:set var="type" value="${type }" scope="session"/>
		
		<script type="text/javascript">
		alert("로그인 성공");
		location.href="${root}/product/main.do";
		</script>
	</c:if>
	
	<c:if test="${type == null }">
		<script type="text/javascript">
		alert("로그인 실패. 아이디와 비밀번호를 확인하세요.");
		location.href="${root}/member/login.do";
		</script>
	</c:if>
</body>
</html>