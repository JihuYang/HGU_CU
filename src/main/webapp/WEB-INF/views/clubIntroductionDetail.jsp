<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
	href="../resources/assets/img/favicon.ico" />
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
<jsp:include page="/WEB-INF/views/inc/header.jsp" />

<!-- Core theme CSS (includes Bootstrap)-->
<link href="../../resources/css/styles.css" rel="stylesheet" />
<link href="../../resources/css/clubIntroductionDetail.css"
	rel="stylesheet" />

</head>
<script src="https://kit.fontawesome.com/6333a60c65.js"
	crossorigin="anonymous"></script>
<body id="page-top">
	<!-- Masthead-->
	<div class="container px-4 px-lg-5 h-auto">
		<div
			class="row gx-4 gx-lg-5 align-items-center justify-content-center text-center">
			<div class="col-lg-8 align-self-center">
				<h3 class="font-weight-bold pt-title">${categoryName} 동아리 소개</h3>
				<p class="text-muted mb-0">한동대 ${categoryName} 모든 동아리들을 응원합니다 !</p>
			</div>
			<div class="col-sm-10">
				<hr>
				<!-- 동아리 대표 내용  -->
				<div class="align">
					<c:forEach items="${clubDetailList}" var="clubDetailList" varStatus="status">
						<fmt:formatDate value="${clubDetailList.foundationDate}" var="formattedFdDate" type="date" pattern="yyyy-MM-dd" />
						<h5 class="text-align">[${clubDetailList.clubName}]</h5>
						<p class="text-align">창립일자: ${formattedFdDate}</p>
						<p class="text-align">대표자명: ${clubDetailList.clubCeoName}</p>
						<p class="text-align">연락처: ${clubDetailList.phone}</p>
						<p class="text-align">동방: ${clubDetailList.clubLocation}</p>
						<p class="text-align">인스타/페북: ${clubDetailList.snsLink}</p>
						<p class="text-align content-size">
							동아리 소개<br>${clubDetailList.clubDescription}
							<!-- 동아리 소개글<br>🌿2021 피치파이프 리크루팅🍑🌿<br>YES, WE ARE
							PITCHPIPE!<br>_<br>안녕하세요, 21학번 🌊함께하는 세대🌊 여러분!<br>하나님을
							찬양하는 아카펠라 동아리 피치파이프입니다🎶<br>저희와 함께 목소리로 하나님을 찬양할 21학번
							방울이💧분들을 모집합니다💚<br>😌 나는 찬양하는 것을 좋아한다!<br>🤔 아카펠라를 잘
							모르지만 한 번 도전해보고 싶다!<br>🤗 아카펠라로 아름다운 하모니를 만들어보고 싶다!<br>🥺
							피치파이프라는 동아리에 너무너무 들어오고 싶다!<br> <br>하신다면, 누구나 환영합니다
							😊🙌🏻<br>함께 찬양하고, 함께 기뻐하고, 함께 추억을 만들어나갈 21학번 새내기🐥들의 많은 지원을
							기다립니다✨<br>동아리 소개글<br>🌿2021 피치파이프 리크루팅🍑🌿<br>YES,
							WE ARE PITCHPIPE!<br>_<br>안녕하세요, 21학번 🌊함께하는 세대🌊 여러분!<br>하나님을
							찬양하는 아카펠라 동아리 피치파이프입니다🎶<br>저희와 함께 목소리로 하나님을 찬양할 21학번
							방울이💧분들을 모집합니다💚<br>😌 나는 찬양하는 것을 좋아한다!<br>🤔 아카펠라를 잘
							모르지만 한 번 도전해보고 싶다!<br>🤗 아카펠라로 아름다운 하모니를 만들어보고 싶다!<br>🥺
							피치파이프라는 동아리에 너무너무 들어오고 싶다!<br> <br>하신다면, 누구나 환영합니다
							😊🙌🏻<br>함께 찬양하고, 함께 기뻐하고, 함께 추억을 만들어나갈 21학번 새내기🐥들의 많은 지원을
							기다립니다✨ -->
						</p>
					</c:forEach>
				</div>
				<div class="logo">
					<div id="carouselExampleControls" class="carousel slide"
						data-bs-ride="carousel">
						<div class="carousel-inner">
							<div class="carousel-item active">
								<img
									src="https://cdn.pixabay.com/photo/2021/07/13/11/34/cat-6463284_960_720.jpg"
									class="d-block logo" alt="...">
							</div>
							<div class="carousel-item">
								<img
									src="https://cdn.pixabay.com/photo/2021/07/15/08/44/town-6467851_960_720.jpg"
									class="d-block logo" alt="...">
							</div>
							<div class="carousel-item">
								<img
									src="https://cdn.pixabay.com/photo/2021/07/14/18/34/poppies-6466826_960_720.jpg"
									class="d-block logo" alt="...">
							</div>
						</div>
						<button class="carousel-control-prev " type="button"
							data-bs-target="#carouselExampleControls" data-bs-slide="prev">
							<span class="carousel-control-prev-icon" aria-hidden="true"></span>
							<span class="visually-hidden">Previous</span>
						</button>
						<button class="carousel-control-next" type="button"
							data-bs-target="#carouselExampleControls" data-bs-slide="next">
							<span class="carousel-control-next-icon" aria-hidden="true"></span>
							<span class="visually-hidden">Next</span>
						</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/inc/footer.jsp" />
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
	<!-- SimpleLightbox plugin JS-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/SimpleLightbox/2.1.0/simpleLightbox.min.js"></script>
	<!-- Core theme JS-->
	<script src="/resources/js/scripts.js"></script>
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<!-- * *                               SB Forms JS                               * *-->
	<!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>
</html>
