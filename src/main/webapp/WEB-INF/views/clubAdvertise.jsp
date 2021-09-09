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
<jsp:include page= "<%=\"./inc/\".concat(((String)request.getAttribute(\"header\")))%>" />


<!-- Core theme CSS (includes Bootstrap)-->
<link href="<%=request.getContextPath()%>/resources/css/styles.css"
	rel="stylesheet" />
<link
	href="<%=request.getContextPath()%>/resources/css/clubAdvertise.css"
	rel="stylesheet" />

</head>
<script src="https://kit.fontawesome.com/6333a60c65.js"></script>
<body id="page-top">
	<div class="container px-4 px-lg-5 h-auto h-min">
		<div
			class="row gx-4 gx-lg-5 align-items-center justify-content-center text-center">
			<div class="col-lg-8 align-self-center">
				<h3 class="font-weight-bold pt-title">동아리 홍보</h3>
			</div>
			<!-- 홍보글 테이블 -->
			<div class="col-sm-10 align-self-baseline table-responsive table-height">
				<jsp:include page="/WEB-INF/views/ajaxContent/clubAdvertise.jsp"/>
			</div>
			<div class="col-sm-10 justify-content-md-center position mt-5">
				<div class="search-form">
					<form accept-charset="UTF-8" class="form-form" name="searchForm"
						action="<%=request.getContextPath()%>/clubAdvertise" method="POST">
						<div class="rows">
							<!-- 검색 기능바 -->
							<select class="form-select form-select-sm search-selector"
								name="searchType">
								<option value="title"
									<c:if test="${page.searchType eq 'title'}">selected</c:if>>제목</option>
								<option value="content"
									<c:if test="${page.searchType eq 'content'}">selected</c:if>>내용</option>
								<option value="title_content"
									<c:if test="${page.searchType eq 'title_content'}">selected</c:if>>제목+내용</option>
							</select>
						</div>
						<div class="rows mb-3">
							<input hidden="hidden" /> <input
								class="form-control form-control-sm search-input" type="text"
								name="keyword" value="${page.keyword}">
							<button class="btn btn-primary search-btn" type="button"
								id="searchBtn" onclick="search()">검색</button>
						</div>
					</form>
				</div>
				<nav id="paginationBox">
					<ul class="pagination align-items-center justify-content-center">
						<c:if test="${page.prev}">
							<li class="page-item"><a class="page-link"
								href="<%=request.getContextPath()%>/clubAdvertise?num=${page.startPageNum - 1}${page.searchTypeKeyword}"
								aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
									<span class="sr-only">Previous</span>
							</a></li>
						</c:if>

						<c:forEach begin="${page.startPageNum}" end="${page.endPageNum}"
							var="num">
							<c:if test="${selected != num}">
								<li class="page-item"><a class="page-link"
									href="<%=request.getContextPath()%>/clubAdvertise?num=${num}${page.searchTypeKeyword}">${num}</a></li>
							</c:if>

							<c:if test="${selected == num}">
								<li class="page-item active"><a class="page-link" href="#">${num}</a></li>
							</c:if>
						</c:forEach>

						<c:if test="${page.next}">
							<li class="page-item"><a class="page-link"
								href="<%=request.getContextPath()%>/clubAdvertise?num=${page.endPageNum + 1}${page.searchTypeKeyword}"
								aria-label="Next"> <span aria-hidden="true">&raquo;</span> <span
									class="sr-only">Next</span>
							</a></li>
						</c:if>
					</ul>
					<c:if test="${admin < 2}">
						<a class="btn btn-primary writing-btn"
							href="<%=request.getContextPath()%>/clubAdvertise/write"
							role="button">글쓰기</a>
					</c:if>
				</nav>
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
	<script
		src="<%=request.getContextPath()%>/resources/js/clubAdvertise.js"></script>
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<!-- * *                               SB Forms JS                               * *-->
	<!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>
</html>