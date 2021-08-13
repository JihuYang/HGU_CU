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
						href="<%=request.getContextPath()%>/admin?num=1">홈페이지 관리</a></li>
					<li class="nav-item mx-3"><a class="nav-link font-weight" style="background-color: rgb(239, 247, 253);"
						href="<%=request.getContextPath()%>/adminUser?num=1">회원 관리</a></li>
					<li class="nav-item mx-3"><a class="nav-link font-weight"
						href="<%=request.getContextPath()%>/adminReservation?num=1">예약 관리</a></li>
				</ul>
			</div>
		</nav>

		<div
			class="row h-auto align-items-center justify-content-center text-center my-5 ">

			<!-- 회원 리스트  -->
			<%@ include file="./ajaxContent/adminUserList.jsp"%>

		</div>
		<div class="row h-auto align-items-center text-center">
			<nav id="paginationBox">
				<ul class="pagination align-items-center justify-content-center">
					<c:if test="${page.prev}">
						<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/adminUser?num=${page.startPageNum - 1}${page.searchTypeKeyword}"
							aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
								<span class="sr-only">Previous</span>
						</a></li>
					</c:if>
					
					 <c:forEach begin="${page.startPageNum}" end="${page.endPageNum}" var="num">
					 	<c:if test="${selected != num}">
					 		<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/adminUser?num=${num}${page.searchTypeKeyword}">${num}</a></li>
					 	</c:if>
					 	
					 	<c:if test="${selected == num}">
					 		<li class="page-item active"><a class="page-link" href="#">${num}</a></li>
					 	</c:if>
 					</c:forEach>
 					
 					<c:if test="${page.next}">
	 					<li class="page-item"><a class="page-link"  href="<%=request.getContextPath()%>/adminUser?num=${page.endPageNum + 1}${page.searchTypeKeyword}"
							aria-label="Next"> <span aria-hidden="true">&raquo;</span> <span
								class="sr-only">Next</span>
						</a></li>
					</c:if>
				</ul>
			</nav>
		</div>
		<div class="float-end"><button class="btn btn-primary search-btn">저장</button></div>
	</div>

	<!-- Footer-->
	<jsp:include page="/WEB-INF/views/inc/footer.jsp" />

	<!-- Bootstrap core JS-->
	<script
		src="<%=request.getContextPath()%>/resources/js/pagenation.js"></script>

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