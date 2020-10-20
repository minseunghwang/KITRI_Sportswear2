<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>




<!-- Bootstrap core JavaScript -->
<script
	src="<%=request.getContextPath()%>/resource/vendor/jquery/jquery.min.js"></script>
<script
	src="<%=request.getContextPath()%>/resource/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>



<script type="text/javascript">
 
function closeToEditMember() {
	opener.location.href="<%=request.getContextPath()%>/MemberManageEditController";

		self.close();

	}

	function check() {
		
		
		
		var pwdtxt = document.f.pwd;
		var addrtxt = document.f.addr;
		
		var params = $("#f").serialize();
		
		if (pwdtxt.value == "") {
			alert("빈공란이 존재합니다.");
			pwdtxt.value = "";
			pwdtxt.focus();
			return false;
		}

		if (addrtxt.value == "") {
			alert("빈공란이 존재합니다.");
			addrtxt.value = "";
			addrtxt.focus();
			return false;
		}
       
		
	
	$
				.ajax({
					url : "${pageContext.request.contextPath }/MemberManageEditController",
					type : "post",
					data : params,
					success : function(data) {

						opener.parent.location.reload();
						self.close();
					},
					error : function(request, status, error) {
						alert("code = " + request.status + " message = "
								+ request.responseText + " error = " + error);
					},
					complete : function(data) {
						//  실패했어도 완료가 되었을 때 처리
						alert("무ㅡㅓ징?.");
					}

				});

	alert("수정되었습니다.");
	
	}

	function checkrem() {
		var params = $("#f").serialize();
		var flag = confirm("정말 삭제하시겠습니까?")
		
		if(flag){
			$
			.ajax({
				url : "${pageContext.request.contextPath }/MemberManageDelController",
				type : "post",
				data : params,
				success : function(data) {

					opener.parent.location.reload();
					self.close();
				},
				error : function(request, status, error) {
					alert("code = " + request.status + " message = "
							+ request.responseText + " error = " + error);
				},
				complete : function(data) {
					//  실패했어도 완료가 되었을 때 처리
				}

			});
			
			alert("회원 삭제 되었습니다.")
					


		} else {
			alert("삭제가 취소되었습니다.");
		}
	}
</script>


</head>
<body>
<h1>POP up</h1>

<div class = "editusercomponent">
		<form name="f" id="f" method="post" onsubmit="return check()">
			<fieldset>
				<legend>내 정보 수정</legend>
				
				<div class="form-group">
					<label for="ViewID">ID</label> 
					<input type="text" class="form-control" name="id" value="${member.id}" readonly>
				</div>
				
				<div class="form-group">
					<label for="EditPwd">Password</label> <input
						type="password" class="form-control" name="pwd" value="${member.pwd }" >
				</div>
				
				<div class="form-group">
					<label for="ViewName">Name</label> <input
						type="text" class="form-control" name="name" value="${member.name }" readonly>
						
				</div>
				
				<div class="form-group">
					<label for="EidtEmail">Email address</label> <input
						type="email" class="form-control" name="email" value="${member.email }" aria-describedby="emailHelp" > 
				</div>
				<!-- 주소api 추후 추가 -->
				<div class="form-group">
					<label for="EditAddress">Address</label> <input
						type="text" class="form-control" name="addr" value="${member.addr }">
				</div>
				
			
				<input type="submit" value="수정" > 
				<input type="button" value="회원탈퇴" onclick="checkrem()"> 
				
			</fieldset>
		</form>
	</div>
	


</body>
</html>