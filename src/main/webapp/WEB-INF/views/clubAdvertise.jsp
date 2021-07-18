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
<jsp:include page="/WEB-INF/views/inc/header.jsp"/>
	
<!-- Core theme CSS (includes Bootstrap)-->
<link href="./resources/css/styles.css" rel="stylesheet" />
<link href="./resources/css/clubAdvertise.css" rel="stylesheet" />

</head>
<script src="https://kit.fontawesome.com/6333a60c65.js" crossorigin="anonymous"></script>
<body id="page-top">
	<!-- Masthead-->
	<div class="container px-4 px-lg-5 h-100">
		<div class="row gx-4 gx-lg-5 align-items-center justify-content-center text-center">
			<div class="col-lg-8 align-self-center">
				<h3 class="font-weight-bold pt-title">동아리 홍보</h3>
			</div>
			<!-- 홍보글 테이블 -->
			<div class="col-sm-10 align-self-baseline table-responsive table-height">
				<table class="table table-hover">
					<tr>
						<td><img src="https://cdn.pixabay.com/photo/2020/02/11/16/25/manarola-4840080_1280.jpg" class="img-thumbnail rounded img-size"></td>
						<td>
							<h5>♪2021년도 피치파이프 리쿠르팅♪(제목)</h5>
							<p class="text-muted">안녕하세요, 하나님을 찬양하는 아카펠라 동아리 피치파이프입니다.
								이번학기 신입기수들을 모집하려고 합니다 ! (게시글 일부)</p>
						</td>
					</tr>
					<tr>
						<td><img src="https://cdn.pixabay.com/photo/2021/01/28/21/12/wave-5959087_1280.jpg" class="img-thumbnail rounded img-size"></td>
						<td>
							<h5>(제목)</h5> 
							<p class="text-muted">(게시글 일부)</p>
						</td> 
					</tr>
					<tr>
						<td><img src="https://cdn.pixabay.com/photo/2021/01/28/21/12/wave-5959087_1280.jpg" class="img-thumbnail rounded img-size"></td>
						<td>
							<h5>(제목)</h5> 
							<p class="text-muted">(게시글 일부)</p>
						</td> 
					</tr>
				</table>
			</div>
			<div class="col-sm-10 justify-content-md-center">
				<form accept-charset="UTF-8" name="searchForm" action="<%=request.getContextPath()%>/clubAdvertise" method="POST" >
					<div class="rows">
						<!-- 검색 기능바 -->
						<select class="form-select form-select-sm search-selector">
							<option value="title" selected>제목</option>
							<option value="clubName">동아리 이름</option>
							<option value="content">내용</option>
						</select>
					</div>
					<div class="rows mb-3">
						<input class="form-control form-control-sm search-input" type="text">
						<button class="btn btn-primary search-btn" type="submit">검색</button>
					</div>
				</form>
				<a class="btn btn-primary writing-btn" href="#" role="button">글쓰기</a>
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
