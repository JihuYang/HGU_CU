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

</head>
<jsp:include page="/WEB-INF/views/inc/header.jsp" />
<link href="./resources/css/home.css" rel="stylesheet" />

<script src="https://kit.fontawesome.com/6333a60c65.js"
	crossorigin="anonymous"></script>
<body id="page-top">
	<!-- Masthead-->
	<div class="container px-4 px-lg-5 h-100">
		<div
			class="row gx-4 gx-lg-5 h-75 align-items-center justify-content-center text-center">
			<div class="col-lg-6 align-self-end">
				<h3 class="font-weight-bold">공지사항</h3>
			</div>
			
			<table class="table text-center">
				<thead>
					<tr>
						<th scope="col" class="col-1 text-center">번호</th>
						<th scope="col" class="col-6 text-center">제목</th>
						<th scope="col" class="col-1 text-center">작성자</th>
						<th scope="col" class="col-1 text-center">날짜</th>
						<th scope="col" class="col-1 text-center">조회</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th scope="row">1</th>
						<td class="text-start">[지원모집] 총동아리연합회 ’제자리’ 국장/국원 모집</td>
						<td>관리자</td>
						<td>2021.06.23</td>
						<td>15</td>	
					</tr>
					<tr>
						<th scope="row">2</th>
						<td class="text-start">[행정국] 오피스아워 운영 시간 변경</td>
						<td>관리자</td>
						<td>2021.06.25</td>
						<td>30</td>	
					</tr>
				</tbody>
			</table>
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
