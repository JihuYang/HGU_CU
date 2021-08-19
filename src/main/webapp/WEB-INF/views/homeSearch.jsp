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

</head>
<jsp:include page="/WEB-INF/views/inc/header.jsp" />
<link href="<%=request.getContextPath()%>/resources/css/homeSearch.css"
	rel="stylesheet" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="https://kit.fontawesome.com/6333a60c65.js"></script>
<body id="page-top">
	<div class="container width-80 h-auto h-min">
		<div
			class="row h-auto align-items-center justify-content-center text-center">
			<form accept-charset="UTF-8" name="searchForm"
				class="background-gray py-4 search-margin">
				<div class="rows justify-content-center">
					<select class="form-select form-select-sm search-selector" name="searchType">
						<option value="title" <c:if test="${page.searchType eq 'title'}">selected</c:if> >제목</option>
						<option value="content" <c:if test="${page.searchType eq 'content'}">selected</c:if> >내용</option>
						<option value="title_content" <c:if test="${page.searchType eq 'title_content'}">selected</c:if>>제목+내용</option>
					</select>
				</div>
				<div class="rows justify-content-center">
					<input class="form-control form-control-sm search-input backgrond-white" type="text" name="keyword" value="${page.keyword}">
					<button class="btn btn-primary search-btn" type="button" id="searchBtn" onclick="searchInSearchPage()">검색</button>
				</div>
			</form>
			<div class="tag-list mb-5 text-start">
				<input type="button" class="tag backgrond-white py-2"
					name="btn_name" value="전체" /> <input type="button"
					class="tag backgrond-white py-2" name="btn_name"
					value="공지사항 ${communityInfoListCount}" /> <input type="button"
					class="tag backgrond-white py-2" name="btn_name"
					value="자료실 ${communityMaterialListCount}" /> <input type="button"
					class="tag backgrond-white py-2" name="btn_name"
					value="동아리 소개 ${clubIntroListCount}" /> <input type="button"
					class="tag backgrond-white py-2" name="btn_name"
					value="동아리 홍보 ${clubAdvertiseListCount}" />
			</div>
		</div>
		<div
			class="row h-auto align-items-center justify-content-center text-center">
			<div class="text-start p-3">
				<h4>공지사항 내 검색결과 ${communityInfoListCount}건</h4>
			</div>
			<!-- 공지사항 리스트  -->
			<%@ include file="./ajaxContent/communityInfoList.jsp"%>
			<div class="text-start p-3">
				<h4>자료실 내 검색결과 ${communityMaterialListCount}건</h4>
			</div>
			<!-- 자료실 리스트  -->
			<%@ include file="./ajaxContent/communityMaterialList.jsp"%>
			<div class="text-start p-3">
				<h4>동아리 소개 내 검색결과 ${clubIntroListCount}건</h4>
			</div>
			<!-- 동아리 소개 리스트 -->
			<c:if test="${empty clubIntroList}">
					<div class="mt-5rem">
					<hr>
					<h5><span class="noResult">'${page.keyword}'</span>에 대한 검색 결과를 찾지 못하였습니다.</h5>
					<p class="text-muted">* 단어의 철자가 정확한지 확인해 주세요<br>* 띄어쓰기가 정확한지 획인해 주세요</p>
					</div>
			</c:if>
			<c:if test="${ !empty clubIntroList}">
			<div class="club-content" style="display: flex;">
				<div class="row logo-display">
					<jsp:include page="/WEB-INF/views/ajaxContent/clubIntroduction.jsp" />
				</div>
			</div>
			</c:if>
			<div class="text-start p-3">
				<h4>동아리 홍보 내 검색결과 ${clubAdvertiseListCount}건</h4>
			</div>
			<div
				class="col-sm-10 align-self-baseline table-responsive table-height">
				<jsp:include page="/WEB-INF/views/ajaxContent/clubAdvertise.jsp" />
			</div>
		</div>

	</div>

	<!-- Footer-->
	<jsp:include page="/WEB-INF/views/inc/footer.jsp" />
	<!-- Bootstrap core JS-->
	<script
		src="<%=request.getContextPath()%>/resources/js/home.js"></script>

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