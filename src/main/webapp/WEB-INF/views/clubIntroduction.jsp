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
<link href="../resources/css/styles.css" rel="stylesheet" />
<link href="../resources/css/clubIntroduction.css" rel="stylesheet" />


</head>
<script src="https://kit.fontawesome.com/6333a60c65.js"
	crossorigin="anonymous"></script>
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
		<div
			class="row gx-4 gx-lg-5 align-items-center justify-content-center text-center">
			<div class="col-lg-8 align-self-center">
				<h3 class="font-weight-bold pt-title">공연분과 동아리 소개</h3>
				<p class="text-muted mb-0">한동대 공연분과 모든 동아리들을 응원합니다 !</p>
			</div>
			<div class="col-sm-10 justify-content-md-center">
				<hr>
				<!--  검색창  -->
				<div class=" col-sm-4 align-self-baseline search-bar">
					<div class="input-group mb-3">
						<input type="text" class="form-control" placeholder="검색">
						<button class="btn btn-outline-secondary" type="button"
							id="button-addon2">
							<i class="fas fa-search"></i>
						</button>
					</div>
				</div>
				<!-- 동아리 내 -->
				<div>
					<!-- <a  href="#" class="col logos">
						<img alt="logo" class="img-thumbnail" src="https://cdn.pixabay.com/photo/2021/07/09/02/29/family-6398107_960_720.jpg">
						<div class="overlay">
							<div class="hover_text">[제자리]<br>창립연도: 1995.05.12<br>대표자명: 방승민<br>연락처: 010 – xxxx - xxxx<br>인스타/페북: <br>동방: 302호</div>
						</div>
					</a>
					<a  href="#" class="col logos">
						<img alt="logo2" class="img-thumbnail image" src="https://cdn.pixabay.com/photo/2020/10/07/18/40/dog-5635960_960_720.jpg">
						<div class="overlay">
							<div class="hover_text">이미지에 마우스를 올리면 나타나는 텍스트입니다.</div>
						</div>
					</a>
					<a href="#" class="col logos">
						<img alt="logo3" class="img-thumbnail" src="https://cdn.pixabay.com/photo/2020/10/12/22/15/glass-5650335_960_720.jpg">
						<div class="overlay">
							<div class="hover_text">이미지에 마우스를 올리면 나타나는 텍스트입니다.</div>
						</div>
					</a>
					<a href="#" class="col logos">
						<img alt="logo4" class="img-thumbnail" src="https://cdn.pixabay.com/photo/2021/07/13/11/34/cat-6463284_960_720.jpg">
						<div class="overlay">
							<div class="hover_text">이미지에 마우스를 올리면 나타나는 텍스트입니다.</div>
						</div>
					</a> -->
					<div class="col-xs-6 col-sm-3">
						<div class="overlay-item overlay-effect">
							<img
								src="https://cdn.pixabay.com/photo/2021/07/09/02/29/family-6398107_960_720.jpg"
								alt="" />
							<div class="mask">
								<p>
									[제자리]<br>창립연도: 1995.05.12<br>대표자명: 방승민<br>연락처:
									010 – xxxx - xxxx<br>인스타/페북: <br>동방: 302호
								</p>
								<a href="#" class="btn btn-default">Read More</a>
							</div>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="overlay-item overlay-effect">
							<img
								src="https://cdn.pixabay.com/photo/2020/10/07/18/40/dog-5635960_960_720.jpg"
								alt="" />
							<div class="mask">
								<p>
									[피치파이프 ]<br>창립연도: 1995.05.12<br>대표자명: 방승민<br>연락처:
									010 – xxxx - xxxx<br>인스타/페북: <br>동방: 302호
								</p>
								<a href="#" class="btn btn-default">Read More</a>
							</div>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="overlay-item overlay-effect">
							<img
								src="https://cdn.pixabay.com/photo/2020/10/12/22/15/glass-5650335_960_720.jpg"
								alt="" />
							<div class="mask">
								<p>
									[하향 ]<br>창립연도: 1995.05.12<br>대표자명: 방승민<br>연락처:
									010 – xxxx - xxxx<br>인스타/페북: <br>동방: 302호
								</p>
								<a href="#" class="btn btn-default">Read More</a>
							</div>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="overlay-item overlay-effect">
							<img
								src="https://cdn.pixabay.com/photo/2021/07/13/11/34/cat-6463284_960_720.jpg"
								alt="" />
							<div class="mask">
								<p>
									[MIC]<br>창립연도: 1995.05.12<br>대표자명: 방승민<br>연락처:
									010 – xxxx - xxxx<br>인스타/페북: <br>동방: 302호
								</p>
								<a href="#" class="btn btn-default">Read More</a>
							</div>
						</div>
					</div>
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
	<script src="../resources/js/scripts.js"></script>
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<!-- * *                               SB Forms JS                               * *-->
	<!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>
</html>
