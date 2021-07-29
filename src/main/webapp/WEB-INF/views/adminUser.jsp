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
<link href="./resources/css/styles.css" rel="stylesheet" />

</head>
<jsp:include page="/WEB-INF/views/inc/header.jsp" />
<link href="<%=request.getContextPath()%>/resources/css/admin.css" rel="stylesheet" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="https://kit.fontawesome.com/6333a60c65.js"></script>
<body id="page-top">
	<div class="container width-80 h-auto h-min">
		<div
			class="row h-25 align-items-center justify-content-center text-center">
			<div class="col-lg-6 align-self-center">
				<h3 class="font-weight-bold pt-title">관리자 페이지</h3>
			</div>
		</div>
		<nav class="navbar navbar-expand-lg bg-white justify-content-center">
			<div
				class="h-auto align-items-center justify-content-center text-center admin-nav-border">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item mx-3"><a class="nav-link font-weight"
						href="#">홈페이지 관리</a></li>
					<li class="nav-item mx-3"><a class="nav-link font-weight"
						href="#">회원 관리</a></li>
					<li class="nav-item mx-3"><a class="nav-link font-weight"
						href="#">예약 관리</a></li>
				</ul>
			</div>
		</nav>

		<div
			class="row h-auto align-items-center justify-content-center text-center my-5 ">

			<!-- 회원 리스트  -->
			<%@ include file="./ajaxContent/adminUserList.jsp"%>

		</div>
		<div class="row h-auto align-items-center text-center">
			<nav>
				<ul class="pagination align-items-center justify-content-center">
					<li class="page-item"><a class="page-link" href="#"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							<span class="sr-only">Previous</span>
					</a></li>
					<li class="page-item"><a class="page-link" href="#">1</a></li>
					<li class="page-item"><a class="page-link" href="#">2</a></li>
					<li class="page-item"><a class="page-link" href="#">3</a></li>
					<li class="page-item"><a class="page-link" href="#"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span> <span
							class="sr-only">Next</span>
					</a></li>
				</ul>
			</nav>
		</div>
	</div>

	<!-- Footer-->
	<jsp:include page="/WEB-INF/views/inc/footer.jsp" />

	<!-- Bootstrap core JS-->
	<script
		src="<%=request.getContextPath()%>/resources/assets/js/pagenation.js"></script>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
	<!-- SimpleLightbox plugin JS-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/SimpleLightbox/2.1.0/simpleLightbox.min.js"></script>
	<!-- Core theme JS-->
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<!-- * *                               SB Forms JS                               * *-->
	<!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>
</html>