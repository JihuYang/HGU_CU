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
	href="./resources/assets/favicon.ico" />
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

</head>
<jsp:include page= "<%=\"./inc/\".concat(((String)request.getAttribute(\"header\")))%>" />



<link href="<%=request.getContextPath()%>/resources/css/home.css"
	rel="stylesheet" />

<script src="https://kit.fontawesome.com/6333a60c65.js"></script>
<body id="page-top" class="home-img">
	<!-- Masthead-->
	<div class="container width-80 h-auto h-min">
		<div
			class="row gx-4 gx-lg-5 h-100 align-items-center justify-content-center text-center">
			<div class="col-lg-8 align-self-end">
				<h3 class="font-weight-bold">총동아리연합회 홈페이지에 오신 것을 환영합니다</h3>
			</div>
			<div class="col-lg-5 align-self-baseline ">
				<p class="mb-5 text-muted">제 27대 총동아리연합회 ‘제자리’</p>
				<div class="input-group mb-3">
					<input type="text" class="form-control" name="keyword"
						placeholder="공지사항, 동아리 홍보, 동아리 소개, 자료실 검색">
					<button class="btn btn-outline-secondary" type="button"
						id="button-addon2" onclick="searchHome()">
						<i class="fas fa-search"></i>
					</button>
				</div>
			</div>
		</div>
	</div>

	<!-- Footer-->
	<jsp:include page="/WEB-INF/views/inc/footer.jsp" />

	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
	<!-- SimpleLightbox plugin JS-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/SimpleLightbox/2.1.0/simpleLightbox.min.js"></script>
	<!-- Core theme JS-->
	<script src="<%=request.getContextPath()%>/resources/js/scripts.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/home.js"></script>
</body>
</html>
