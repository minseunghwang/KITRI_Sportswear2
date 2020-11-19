<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>




<!-- Bootstrap core JavaScript -->
<script
	src="<%=request.getContextPath()%>/resources/vendor/jquery/jquery.min.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>



<script type="text/javascript">
 
function closeToEditMember() {
		opener.location.href="<%=request.getContextPath()%>/admin/memberManage/memberManagePopupEdit.do";

		self.close();

	}

	function check() {
		
		var pwdtxt = document.f.pwd;
		var addrtxt = document.f.addr;
		
		var params = $("#f").serialize();
		
		var id = $("#id").val();
		var pwd = $("#pwd").val();
		var name = $("#name").val();
		var email = $("#email").val();
		var addr = $("#addr").val();
		
		if (pwdtxt.value == "") {
			alert("������� �����մϴ�.");
			pwdtxt.value = "";
			pwdtxt.focus();
			return false;
		}

		if (addrtxt.value == "") {
			alert("������� �����մϴ�.");
			addrtxt.value = "";
			addrtxt.focus();
			return false;
		}
		
      
		$.ajax({
					url : "${pageContext.request.contextPath }/admin/memberManage/memberManagePopupEdit.do",
					type : "post",
					data : {
						"id" : id,
						"pwd" : pwd,
						"name" : name,
						"email" : email,
						"addr" : addr
					},
				    dataType: "json",	
					success : function(data) {
						alert("�����Ǿ����ϴ�.");
						opener.parent.location.reload();
						self.close();
					},
					error : function(request, status, error) {
						alert("������");
						alert(error);
						console.log("code = " + request.status + " message = " + request.responseText + " error = " + error);
					}
				});
	}

	function checkrem() {
		var params = $("#f").serialize();
		var flag = confirm("���� �����Ͻðڽ��ϱ�?")
		
		if(flag){
			$
			.ajax({
				url : "${pageContext.request.contextPath }/admin/memberManage/memberManagePopupDelete.do",
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
					//  �����߾ �Ϸᰡ �Ǿ��� �� ó��
				}

			});
			
			alert("ȸ�� ���� �Ǿ����ϴ�.")
					


		} else {
			alert("������ ��ҵǾ����ϴ�.");
		}
	}
</script>


</head>
<body>
<h1>POP up</h1>

<div class = "editusercomponent">
		<form name="f" id="f" method="post" onsubmit="return check()">
			<fieldset>
				<legend>�� ���� ����</legend>
				
				<div class="form-group">
					<label for="ViewID">ID</label> 
					<input type="text" class="form-control" id="id" name="id" value="${member.id}" readonly>
				</div>
				
				<div class="form-group">
					<label for="EditPwd">Password</label> <input
						type="password" class="form-control" id="pwd" name="pwd" value="${member.pwd }" >
				</div>
				
				<div class="form-group">
					<label for="ViewName">Name</label> <input
						type="text" class="form-control" name="name" id="name" value="${member.name }">
						
				</div>
				
				<div class="form-group">
					<label for="EidtEmail">Email address</label> <input
						type="email" class="form-control" name="email" id="email" value="${member.email }" aria-describedby="emailHelp" > 
				</div>
				<!-- �ּ�api ���� �߰� -->
				<div class="form-group">
					<label for="EditAddress">Address</label> <input
						type="text" class="form-control" name="addr" id="addr" value="${member.addr }">
				</div>
				
			
				<input type="submit" value="����" > 
				<input type="button" value="ȸ��Ż��" onclick="checkrem()"> 
				
			</fieldset>
		</form>
	</div>
	


</body>
</html>