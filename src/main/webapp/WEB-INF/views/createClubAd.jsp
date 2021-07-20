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
<link href="./resources/css/createClubAd.css" rel="stylesheet" />

</head>
<script src="https://kit.fontawesome.com/6333a60c65.js" crossorigin="anonymous"></script>
<body id="page-top">
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-light fixed-top py-3"
		id="mainNav">
		<div class="container px-4 px-lg-5">
			<a class="navbar-brand" href="#page-top">한동대학교 총동아리연합회</a>
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ms-auto my-2 my-lg-0">
					<li class="nav-item"><a class="nav-link" href="#about">총동연
							소개</a></li>
					<li class="nav-item"><a class="nav-link" href="#services">동아리
							소개</a></li>
					<li class="nav-item"><a class="nav-link" href="#portfolio">시설
							예약</a></li>
					<li class="nav-item"><a class="nav-link" href="#contact">커뮤니티</a></li>
					<li class="nav-item"><a class="nav-link" href="#contact">동아리
							홍보</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- Masthead-->
	<div class="container px-4 px-lg-5 h-100">
		<div class="row gx-4 gx-lg-5 align-items-center justify-content-center text-center">
			<div class="col-lg-8 align-self-center">
				<h3 class="font-weight-bold pt-title">동아리 홍보</h3>
			</div>
			<!-- 홍보글 테이블 -->
			<div class="col-sm-10 justify-content-md-center">
				<form accept-charset="UTF-8" name="searchForm" action="<%=request.getContextPath()%>/createClubAd" method="POST" >
					<div class="title-bar">
						<p class="rows title-bold">제목</p><input class="form-control title-input" type="text">
					</div>
					<div class="mb-3">
						<textarea class="form-control textarea" rows="13"></textarea>
					</div>
					<div class="mb-3">
  						<input class="form-control file" type="file" multiple>
					</div>
					<div>
						<a class="btn btn-primary back-btn bottom-btn" href="./clubAdvertise" role="button">뒤로</a>
						<button class="btn btn-primary submit-btn bottom-btn" type="submit">저장</button> 
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- Footer-->
	<footer class="bg-light py-5">
		<div class="container px-4 px-lg-5">
			<div class="small text-center text-muted">Copyright &copy; 2021
				- 한동대학교 총동아리연합회</div>
		</div>
	</footer>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
	<!-- SimpleLightbox plugin JS-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/SimpleLightbox/2.1.0/simpleLightbox.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<!-- * *                               SB Forms JS                               * *-->
	<!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>
</html>
