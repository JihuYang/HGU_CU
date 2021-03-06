<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<meta name="google-signin-scope" content="profile email">
<meta name="google-signin-client_id"
	content="330229354393-gevcnmd1sbv0fvmjovljh695o8pjq8q6.apps.googleusercontent.com">
<script src="https://apis.google.com/js/platform.js" async defer></script>
<title>한동대학교 총동아리연합회</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon"
	href="./resources/assets/img/favicon.ico" />
<!-- Bootstrap Icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<!-- Google fonts-->
<link
	href="https://fonts.googleapis.com/css?family=Merriweather+Sans:400,700"
	rel="stylesheet" />
<link
	href="https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic"
	rel="stylesheet" type="text/css" />
<!-- SimpleLightbox plugin CSS-->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/SimpleLightbox/2.1.0/simpleLightbox.min.css"
	rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="./resources/css/styles.css" rel="stylesheet" />
<%@ page import = "com.walab.hgu.DTO.UserDTO" %>


</head>
<jsp:include page="/WEB-INF/views/inc/headerLogout.jsp" />
<link href="<%=request.getContextPath()%>/resources/css/login.css" rel="stylesheet" />
<link href="<%=request.getContextPath()%>/resources/js/register.js" rel="stylesheet" />


<script src="https://kit.fontawesome.com/6333a60c65.js"></script>
<body id="page-top">
	<!-- Masthead-->
	<div class="container px-4 px-lg-5 h-100">
	<form method="POST" enctype="multipart/form-data" id="registerForm" name="registerForm"
				action="<%=request.getContextPath()%>/register/registerSave" 
				onsubmit="return confirm('회원가입을 하시겠습니까?');">
		<div
			class="row gx-4 gx-lg-5 h-100 align-items-center justify-content-center text-center">
			<div class="col-lg-8 align-self-end ">
				<h3 class="font-weight-bold mb-3">${tempUser.name}님의 회원가입을
					진행합니다.</h3>
			</div>
			<div class="col-lg-5 align-self-baseline login-form">
				<div class="input-group mb-1">
					<input type="text" id="userName" name="userName"
						class="form-control" placeholder="이름을 입력하세요."
						value="${tempUser.name}" readonly>
				</div>
				<div class="input-group mb-1">
					<input type="text" id="email" name="email" class="form-control"
						placeholder="이메일을 입력하세요." value="${tempUser.email}" readonly>
				</div>
				<div class="input-group mb-1">
					<input type="tel" id="phone" name="phone" class="form-control phoneNumber" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" maxlength="13"
						placeholder="전화번호를 입력하세요.('-' 없이)" required="required">
				</div>
				<div class="m-3">
					<button id="userInfoBtn" class="btn btn-secondary submit-btn mt-5">회원가입</button>
				</div>
			</div>
		</div>
	</form>

	</div>

	<!-- Footer-->
	<jsp:include page="/WEB-INF/views/inc/footer.jsp" />
	<!-- Bootstrap core JS-->
	<script>
	<%-- $(document).ready(function() {

		$("#userInfoBtn").click(function() {
			if (confirm("회원가입을 하시겠습니까?")) {
				$.ajax({
					url: "/register/registerSave",
					type: "POST",
					async: false,
					data: {
						name: $('input[name="userName"]').val(),
						email: $('input[name="email"]').val(),
						phone: $('input[name="phone"]').val(),
					},
					success: function(data) {
						console.log(name);
						alert("회원가입이 완료되었습니다.");
						location.href="<%=request.getContextPath()%>/";
					},
					error: function(request, status, error) {
						console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
					}
				});
			}
		}); 


	})--%>
	
	$(document).on("keyup", ".phoneNumber", function() {
		$(this).val( $(this).val().replace(/[^0-9]/g, "").replace(/(^02|^0505|^1[0-9]{3}|^0[0-9]{2})([0-9]+)?([0-9]{4})$/,"$1-$2-$3").replace("--", "-") ); 
	});
	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
	<!-- SimpleLightbox plugin JS-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/SimpleLightbox/2.1.0/simpleLightbox.min.js"></script>
	<!-- Core theme JS-->
	<script src="<%=request.getContextPath()%>/resources/js/scripts.js"></script>
</html>
