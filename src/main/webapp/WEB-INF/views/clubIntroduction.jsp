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
	href="<%=request.getContextPath()%>/resources/css/clubIntroduction.css"
	rel="stylesheet" />


</head>
<script src="https://kit.fontawesome.com/6333a60c65.js"></script>
<body id="page-top">
	<div class="container width-80 h-auto h-min">
		<div
			class="row h-auto align-items-center justify-content-center text-center">
			<div class="col-lg-6 align-self-end">
				<h3 class="font-weight-bold pt-title">${categoryName} 동아리 소개</h3>
				<p class="text-muted mb-0">한동대 ${categoryName} 모든 동아리들을 응원합니다 !</p>
			</div>
			<div class="col-sm-10 justify-content-md-center">
				<hr>
				<!--  검색창  -->
				<div class=" col-sm-4 align-self-baseline search-bar">
					<div class="input-group mb-3">
						<input type="text" class="form-control" placeholder="동아리이름"
							name="keyword" value="${keyword}">
						<c:if test="${categoryName eq null}">
							<button class="btn btn-outline-secondary" type="button"
								id="button-addon2" onclick="search()">
								<i class="fas fa-search"></i>
							</button>
						</c:if>
						<c:if test="${categoryName ne null}">
							<button class="btn btn-outline-secondary" type="button"
								id="button-addon2" onclick="searchInCategory(${newCategoryId})">
								<i class="fas fa-search"></i>
							</button>
						</c:if>
					</div>
				</div>
				<!-- 동아리 내용 -->
				<c:if test="${empty clubIntroList}">
					<div class="mt-5rem">
						<h5>
							<span class="noResult">'${keyword}'</span>에 대한 검색 결과를 찾지 못하였습니다.
						</h5>
						<p class="text-muted">
							* 단어의 철자가 정확한지 확인해 주세요<br>* 띄어쓰기가 정확한지 획인해 주세요
						</p>
					</div>
				</c:if>
				<c:if test="${ !empty clubIntroList}">
					<div class="club-content">
						<div class="row">
							<jsp:include
								page="/WEB-INF/views/ajaxContent/clubIntroduction.jsp" />
						</div>
					</div>
				</c:if>

				<c:if test="${admin < 2}">
				<div class="btn-container">
					<a class="btn btn-primary writing-btn"
						href="<%=request.getContextPath()%>/clubIntroduction/write"
						role="button">글쓰기</a>
				</div>
				</c:if>

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
	<script src="<%=request.getContextPath()%>/resources/js/club.js"></script>

	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<!-- * *                               SB Forms JS                               * *-->
	<!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
<!-- 	<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
 --></body>
</html>
