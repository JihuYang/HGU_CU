<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
	href="<%=request.getContextPath()%>/resources/css/clubIntroductionDetail.css"
	rel="stylesheet" />

</head>
<script src="https://kit.fontawesome.com/6333a60c65.js"></script>
<body id="page-top">
	<div class="container width-80 h-auto h-min">
		<div
			class="row h-auto align-items-center justify-content-center text-center">
			<div class="col-lg-6 align-self-end">
				<h3 class="font-weight-bold pt-title">${categoryName}동아리소개</h3>
				<p class="text-muted mb-0">한동대 ${categoryName} 모든 동아리들을 응원합니다 !</p>
			</div>
			<div class="col-sm-10 min-h">
				<hr>
				<!-- 동아리 대표 내용  -->
				<div class="align">
					<c:forEach items="${clubDetailList}" var="clubDetailList"
						varStatus="status">
						<fmt:formatDate value="${clubDetailList.foundationDate}"
							var="formattedFdDate" type="date" pattern="yyyy-MM-dd" />
						<h5 class="text-align">[${clubDetailList.clubName}]</h5>
						<p class="text-align">창립일자: ${formattedFdDate}</p>
						<p class="text-align">대표자명: ${clubDetailList.clubCeoName}</p>
						<p class="text-align">연락처: ${clubDetailList.phone}</p>
						<p class="text-align">동방: ${clubDetailList.clubLocation}</p>
						<p class="text-align">인스타그램: ${clubDetailList.instagramLink}</p>
						<p class="text-align">페이스북: ${clubDetailList.facebookLink}</p>
						<div class="text-align content-size">
						<c:set var="clubUserId" value="${clubDetailList.userId}" />
						동아리 설명글:<br/><br/>${clubDetailList.clubDescription} </div>				
					</c:forEach>
				</div>
				<div class="logo">
					<div id="carouselExampleControls" class="carousel slide"
						data-bs-ride="carousel">
						<div class="carousel-inner">
							<c:forEach var="clubImgList" items="${clubImgList}"
								varStatus="status" begin="0" end="0">
								<div class="carousel-item active">
									<img
										src="http://hsca219.cafe24.com/uploads/clubIntro/${clubImgList.originalUrl}"
										class="d-block logo" alt="...">
								</div>
							</c:forEach>
							<c:forEach var="clubImgList" items="${clubImgList}"
								varStatus="status" begin="1">
								<div class="carousel-item">
									<img
										src="<%=request.getContextPath()%>/resources/upload/clubIntro/${clubImgList.originalUrl}"
										class="d-block logo" alt="...">
								</div>
							</c:forEach>
							<!-- <div class="carousel-item active">
								<img
									src="https://cdn.pixabay.com/photo/2021/07/13/11/34/cat-6463284_960_720.jpg"
									class="d-block logo" alt="...">
							</div>
							<div class="carousel-item">
								<img
									src="https://cdn.pixabay.com/photo/2021/07/15/08/44/town-6467851_960_720.jpg"
									class="d-block logo" alt="...">
							</div>
							<div class="carousel-item ">
								<img
									src="https://cdn.pixabay.com/photo/2021/07/14/18/34/poppies-6466826_960_720.jpg"
									class="d-block logo" alt="...">
							</div> -->
						</div>
						<c:choose>
							<c:when test="${fn:length(clubImgList) == 0}">
        						업로드된 동아리 사진이 없습니다.
   							</c:when>
							<c:when test="${fn:length(clubImgList) == 1}">
							</c:when>
							<c:otherwise>
								<button class="carousel-control-prev " type="button"
									data-bs-target="#carouselExampleControls" data-bs-slide="prev">
									<span class="carousel-control-prev-icon" aria-hidden="true"></span>
									<span class="visually-hidden">Previous</span>
								</button>
								<button class="carousel-control-next" type="button"
									data-bs-target="#carouselExampleControls" data-bs-slide="next">
									<span class="carousel-control-next-icon" aria-hidden="true"></span>
									<span class="visually-hidden">Next</span>
								</button>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
			<!-- 버튼들 -->
				<div class="row justify-content-start mt-4 col-sm-10">
					<button class="btn btn-primary search-btn list-btn" onclick="location.href='<%=request.getContextPath()%>/clubIntroduction'">목록</button>
					<c:if test="${clubUserId eq userId || admin eq 0}">
					<button class="btn btn-primary search-btn list-btn"
						onclick="location.href='<%=request.getContextPath()%>/clubIntroduction/update/${clubDetailList[0].categoryId}/${clubDetailList[0].id}'">수정</button>
					<button class="btn btn-primary search-btn list-btn"
						onclick="deleteClubIntro()">삭제</button>
					</c:if>
				</div>
		</div>
	</div>
	<div id="clubIntroductionId" style="display:none;">${clubDetailList[0].id}</div>
	<script src="<%=request.getContextPath()%>/resources/js/club.js"></script>
	<jsp:include page="/WEB-INF/views/inc/footer.jsp" />
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
	<!-- SimpleLightbox plugin JS-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/SimpleLightbox/2.1.0/simpleLightbox.min.js"></script>
	<!-- Core theme JS-->
	<script src="<%=request.getContextPath()%>/resources/js/scripts.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/scripts.js"></script>
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<!-- * *                               SB Forms JS                               * *-->
	<!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
<!-- 	<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
 --></body>
</html>
