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
<jsp:include page="/WEB-INF/views/inc/header.jsp"/>

<!-- Core theme CSS (includes Bootstrap)-->
<link href="../resources/css/styles.css" rel="stylesheet" />
<link href="../resources/css/clubIntroduction.css" rel="stylesheet" />


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
			<div class="col-sm-10 justify-content-md-center">
				<hr>
				<!--  검색창  -->
				<div class=" col-sm-4 align-self-baseline search-bar">
					<div class="input-group mb-3">
						<input type="text" class="form-control" placeholder="검색">
						<button class="btn btn-outline-secondary" type="button"
							id="button-addon2">
							<i class="fas fa-search"></i>
						</button>
					</div>
				</div>
				<!-- 동아리 내 -->
				<div class="club-content"style="display:flex; margin-top:80px;">
					<div class="row logo-display">
						<c:forEach items="${clubIntroList}" var="clubIntroList" varStatus="status">
							<fmt:formatDate value="${clubIntroList.foundationDate}" var="formattedFdDate" type="date" pattern="yyyy-MM-dd" />
							<div class="col-xs-6 col-sm-4 pd-0">
								<div class="overlay-item overlay-effect">
									<img src="<%=request.getContextPath()%>/resources/img/${clubIntroList.originalUrl}" alt="임시" />
									<a href="<%=request.getContextPath()%>/clubIntroduction/${clubIntroList.categoryId}/${clubIntroList.id}" class="mask">		
										[${clubIntroList.clubName}]<br>창립일자: ${formattedFdDate}<br>대표자명: ${clubIntroList.clubCeoName}<br>연락처:
										${clubIntroList.phone}<br>동방: ${clubIntroList.clubLocation}<br>인스타/페북: ${clubIntroList.snsLink}
									</a>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>	
			</div>
		</div>	
	</div>
	<!-- Footer-->
	<jsp:include page="/WEB-INF/views/inc/footer.jsp"/>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
	<!-- SimpleLightbox plugin JS-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/SimpleLightbox/2.1.0/simpleLightbox.min.js"></script>
	<!-- Core theme JS-->
	<script src="<%=request.getContextPath()%>/resources/js/scripts.js"></script>
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<!-- * *                               SB Forms JS                               * *-->
	<!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>
</html>
