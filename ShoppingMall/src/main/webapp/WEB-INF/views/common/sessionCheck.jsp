<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script type="text/javascript">
	$(document).ready(){
		if(${empty sessionScope.id}){
			alert('로그인 후 이용해 주세요');
			location.href = "{pageContext.request.contextPath }/member/login.do";
		}
		
	}
</script>

</head>
<body>

</body>
</html>