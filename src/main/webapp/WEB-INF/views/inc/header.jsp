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
<link href="./resources/css/header.css" rel="stylesheet" />

</head>
<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-light fixed-top py-5 bg-white"
	id="mainNav">
	<div class="container px-4 px-lg-5">
		<img src="https://www.handong.edu/site/handong/res/img/sub_802-02.png" class="logo"></img>
		<a class="navbar-brand" onclick="location.href='./'">한동대학교 총동아리연합회<br><span id="name">HANDONG GLOBAL UNIVERSITY CLUB UNION</span></a>
		<button class="navbar-toggler navbar-toggler-right" type="button"
			data-bs-toggle="collapse" data-bs-target="#navbarResponsive"
			aria-controls="navbarResponsive" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse align-items-center" id="navbarResponsive">
			<ul class="navbar-nav ms-auto my-2 my-lg-0">
				<li class="nav-item"><a class="nav-link" >총동연 소개</a></li>
				<li class="nav-item"><a class="nav-link" href="">동아리 소개</a></li>
				<li class="nav-item"><a class="nav-link" href="">시설 예약</a></li>
				<li class="nav-item"><a class="nav-link" href="">커뮤니티</a></li>
				<li class="nav-item"><a class="nav-link" href="">동아리 홍보</a></li>
				<li class="nav-item ">
					<button type="button" class=" login-btn btn-outline-secondary ">회원가입</button>
					<button type="button" class=" login-btn btn-outline-secondary " onclick="location.href='./login'">로그인</button>
				</li>
			</ul>
		</div>
	</div>
</nav>
</html>
