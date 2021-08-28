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
<link href="<%=request.getContextPath()%>/resources/css/styles.css"
	rel="stylesheet" />

<link href="<%=request.getContextPath()%>/resources/css/header.css"
	rel="stylesheet" />

<link href="<%=request.getContextPath()%>/resources/js/header.js"
	rel="stylesheet" />
<script src="https://code.jquery.com/jquery-1.11.3.js"
	type="text/javascript"></script>

<script src="<%=request.getContextPath()%>/resources/js/header.js"></script>


</head>
<!-- Navigation-->
<nav
	class="navbar navbar-expand-lg navbar-light fixed-top py-2 bg-white respy-4"
	id="mainNav">
	<div class="container px-4 px-lg-5 respx-3 ">
		<img src="<%=request.getContextPath()%>/resources/assets/img/logo.png"
			class="logo navbar-brand"
			onclick="location.href='<%=request.getContextPath()%>/'">
		<!--한동대학교 총동아리연합회<br>
		<span id="name">HANDONG GLOBAL UNIVERSITY CLUB UNION</span></a> -->
		<button class="navbar-toggler navbar-toggler-right" type="button"
			data-bs-toggle="collapse" data-bs-target="#navbarResponsive"
			aria-controls="navbarResponsive" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<div class="justify-content-md-center">
				<ul class="navbar-nav my-2 my-lg-0">
					<li class="nav-item nav-bottom-border mx-2"
						onclick="location.href='<%=request.getContextPath()%>/info'"><a
						class="nav-link">총동연 소개</a></li>
					<li class="nav-item nav-bottom-border mx-2 dropdown"
						id="dropdown-display"><a class="nav-link dropdown-toggle"
						data-toggle="dropdown"
						onclick="location.href='<%=request.getContextPath()%>/clubIntroduction'">동아리
							소개</a>
						<ul class="dropdown-menu" id="dropdown-content">
							<c:forEach items="${categoryNameList}" var="categoryNameList"
								varStatus="status">
								<li><a class="dropdown-item"
									href="<%=request.getContextPath()%>/clubIntroduction/${categoryNameList.id}">${categoryNameList.categoryName}</a></li>
							</c:forEach>
						</ul></li>
					<li class="nav-item nav-bottom-border mx-2"><a
						class="nav-link"
						onclick="location.href='<%=request.getContextPath()%>/reservation'">시설
							예약</a></li>
					<li class="nav-item nav-bottom-border mx-2 dropdown"
						id="dropdown-display-community"><a
						class="nav-link dropdown-toggle" data-toggle="dropdown"
						onclick="location.href='<%=request.getContextPath()%>/communityInfo?num=1'">커뮤니티</a>
						<ul class="dropdown-menu dropdown-menu-community"
							id="dropdown-content-community">
							<li><a class="dropdown-item"
								onclick="location.href='<%=request.getContextPath()%>/communityInfo?num=1'">공지사항</a></li>
							<li><a class="dropdown-item"
								onclick="location.href='<%=request.getContextPath()%>/communityMaterials?num=1'">자료실</a></li>
							<li><a class="dropdown-item"
								onclick="location.href='<%=request.getContextPath()%>/communityEvent'">행사일정</a></li>
							<li><a class="dropdown-item"
								onclick="location.href='<%=request.getContextPath()%>/communityComplaints'">민원</a></li>
						</ul></li>
					<li class="nav-item nav-bottom-border mx-2"><a
						class="nav-link"
						onclick="location.href='<%=request.getContextPath()%>/clubAdvertise?num=1'">동아리
							홍보</a></li>
					<li class="nav-item nav-bottom-border mx-2"><a
						class="nav-link"
						onclick="location.href='<%=request.getContextPath()%>/admin?num=1'">관리자</a></li>

				</ul>

			</div>
			<div class="justify-content-md-end">
				<ul class="navbar-nav my-2 my-lg-0">
					<li class="nav-item button-padding button-left border-none">
						<button type="button" class=" login-btn btn-outline-secondary ">회원가입</button>
					</li>
					<li class="nav-item button-padding border-none">
						<button type="button" class=" login-btn btn-outline-secondary "
							onclick="location.href='<%=request.getContextPath()%>/login'">로그인</button>
					</li>
				</ul>
			</div>
		</div>
	</div>
</nav>
</html>
