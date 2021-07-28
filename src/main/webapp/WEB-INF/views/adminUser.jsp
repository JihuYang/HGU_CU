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
<link href="./resources/css/admin.css" rel="stylesheet" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="https://kit.fontawesome.com/6333a60c65.js"></script>
<body id="page-top">
	<!-- Masthead-->
	<div class="container width-80 h-auto">
		<div
			class="row h-auto align-items-center justify-content-center text-center">
			<div class="col-lg-6 align-self-end">
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
			class="row h-auto align-items-center justify-content-center text-center mt-5 ">

			<!-- 공지사항 리스트  -->
			<%-- 			<%@ include file="./ajaxContent/communityInfoList.jsp"%>
 --%>
			<table class="table align-items-center justify-content-center text-center ">
				<thead class="p-4">
					<tr class="tr-border">
						<th scope="col" class="col-1" id="username">이름</th>
						<th scope="col" class="col-3" id="contact">연락처</th>
						<th scope="col" class="col-3" id="email">이메일</th>
						<th scope="col" class="col-2" id="club">소속단체</th>
						<th scope="col" class="col-1" id="authority">권한</th>
					</tr>
				</thead>
				<tbody class="align-items-center p-4">
					<tr>
						<td id="username">양지후</td>
						<td id="contact">01055640429</td>
						<td id="email">21900433@handong.edu</td>
						<td id="club">하향</td>
						<td id="authority">
							<div class="dropdown">
								<button class="btn btn-secondary dropdown-toggle authority-btn" type="button"
									id="dropdownMenuButton1" data-bs-toggle="dropdown"
									aria-expanded="false">권한 설정</button>
								<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
									<li><a class="dropdown-item" href="#">일반회원</a></li>
									<li><a class="dropdown-item" href="#">동아리대표</a></li>
									<li><a class="dropdown-item" href="#">차단</a></li>
									<li><a class="dropdown-item" href="#">관리자</a></li>
								</ul>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="row h-auto align-items-center text-center">
			<form accept-charset="UTF-8" name="searchForm">
				<div class="rows justify-content-center">
					<select class="form-select form-select-sm search-selector">
						<option value="title" selected>제목</option>
						<option value="content">내용</option>
					</select>
				</div>
				<div class="rows justify-content-center">
					<input class="form-control form-control-sm search-input"
						type="text">
					<button class="btn btn-primary search-btn" type="submit">검색</button>
				</div>
			</form>
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
	<jsp:include page="/WEB-INF/views/inc/footer.jsp"/>

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