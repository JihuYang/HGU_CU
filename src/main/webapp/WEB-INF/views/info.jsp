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
	<style>
		.ps-5-custom {
			    padding-left: 3rem !important;
			}
			
		@media screen and (max-width: 1023px){
			.px-4{
				padding-right: 0px !important;
				padding-left: 0px !important;
			}
			.ps-5-custom {
			    padding-left: 0 !important;
			}
			.width-80 {
			    width: 95%;
			}
		}
	</style>
</head>
<jsp:include page= "<%=\"./inc/\".concat(((String)request.getAttribute(\"header\")))%>" />


<script src="https://kit.fontawesome.com/6333a60c65.js"></script>
<body id="page-top">
	<div class="container width-80 h-auto h-min">
		<div
			class="row h-25 align-items-center justify-content-center text-center">
			<div class="col-lg-6 align-self-end">
				<h3 class="font-weight-bold pt-title">총동아리연합회 소개</h3>
			</div>
		</div>
		<div class="container px-4 px-lg-5 text-start">
			<h4 class="mb-4 ps-5-custom pt-5">총동아리연합회란</h4>
			<div class="mb-4 ps-5-custom py-5">총동아리연합회는 교내의 동아리들에게 봉사하기 위해 조직된 동아리 대표기구로서 
			소속 동아리의 관리 및 제반 업무를 담당합니다.<br>
			 총학생회 및 학교 행사시 동아리 관련 부문을 담당합니다. <br>
			 총동아리연합회는 회장단을 비롯하여 총무국,
				지원국, 행정국, 소통국 4개의 국으로 구성되어 있습니다. <br><br>
				총무국 : 총무국은 예산 및 물품 관리, 집행부 내 업무 지원을
				담당하는 국입니다. <br>지원국 : 지원국은 동아리 역량강화, 동아리 홍보 관련 업무를 담당하는 국입니다. <br>행정국 : 행정국은
				장비 및 시설대여, 각종 회의 관련 업무를 담당하는 국입니다. <br>소통국 : 소통국은 밴드연습실, CCR, 지하연습실 등과
				관련하여 집행부와 학생들 간의 소통을 담당하는 국입니다.</div>
		</div>
		<div class="container px-4 px-lg-5 text-start">
			<h4 class="mb-4 ps-5-custom py-5">총동아리연합회 구성도</h4>
			<img src="./resources/assets/img/구성도.svg"
				class="img-fluid col-8 mx-auto d-block" alt="총동아리연합회 구성도">

		</div>
		<div class="container px-4 px-lg-5 text-start">
			<h4 class="mb-4 ps-5-custom py-5">총동아리연합회 집행부 조직도</h4>
			<img src="./resources/assets/img/조직도.svg"
				class="img-fluid col-8 mx-auto d-block" alt="총동아리연합회 집행부 조직도">
		</div>
		<div class="container px-4 px-lg-5 text-start">
			<h4 class="mb-4 ps-5-custom py-5">총동아리연합회칙</h4>
			<a class="col-8 mx-auto d-block btn mb-5"
				href="<%=request.getContextPath()%>/resources/assets/img/총동아리연합회칙 개정안(2021.06 개정).pdf"
				>총동아리연합회칙 다운로드</a>
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
</body>
</html>
