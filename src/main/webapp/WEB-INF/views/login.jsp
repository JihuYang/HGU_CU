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


</head>
<jsp:include page="/WEB-INF/views/inc/header.jsp" />
<link href="./resources/css/login.css" rel="stylesheet" />

<script src="https://kit.fontawesome.com/6333a60c65.js"
	crossorigin="anonymous"></script>
<body id="page-top">
	<!-- Masthead-->
	<div class="container px-4 px-lg-5 h-100">
		<div
			class="row gx-4 gx-lg-5 h-100 align-items-center justify-content-center text-center">
			<div class="col-lg-8 align-self-end ">
				<h3 class="font-weight-bold mb-3">로그인</h3>
			</div>
			<div class="col-lg-5 align-self-baseline login-form">
				<form>
					<div class="input-group mb-1">
						<input type="text" class="form-control" placeholder="아이디">
					</div>
					<div class="input-group mb-3">
						<input type="password" class="form-control" placeholder="비밀번호" />
					</div>
					<div class="input-group mb-3">
					<div class="g-signin2" data-onsuccess="onSignIn" onclick="location.href='<%=request.getContextPath()%>/loginGoogle'"></div>
					
						 <button type="button" class="btn btn-secondary " onclick="location.href='<%=request.getContextPath()%>/loginGoogle'">로그인</button>
<!-- 						<div class="g-signin2" data-onsuccess="onSignIn" data-theme="dark">로그인</div> -->						
						<button type="button" class="btn btn-secondary ">회원가입</button>
					</div>
				</form>
			</div>
		</div>

	</div>

	<!-- Footer-->
	<jsp:include page="/WEB-INF/views/inc/footer.jsp" />
	<script>
		function onSignIn(googleUser) {
			// Useful data for your client-side scripts:
			var profile = googleUser.getBasicProfile();
			console.log('Full Name: ' + profile.getName());
			console.log('Given Name: ' + profile.getGivenName());
			console.log('Family Name: ' + profile.getFamilyName());
			console.log("Image URL: " + profile.getImageUrl());
			console.log("Email: " + profile.getEmail());

			// The ID token you need to pass to your backend:
			var id_token = googleUser.getAuthResponse().id_token;
			console.log("ID Token: " + id_token);
		};
	</script>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
	<!-- SimpleLightbox plugin JS-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/SimpleLightbox/2.1.0/simpleLightbox.min.js"></script>
	<!-- Core theme JS-->
	<script src="<%=request.getContextPath()%>/resources/js/scripts.js"></script>

</body>
</html>
