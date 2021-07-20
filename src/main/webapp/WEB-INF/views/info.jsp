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
        <section class="page-section align-items-center justify-content-center ">
            <div class="container px-4 px-lg-5 text-center">
                <h3 class="mb-5">총동아리연합회 소개</h3>
            </div>
            <div class="container px-4 px-lg-5 text-start">
                <h4 class="mb-4 ps-5 py-5">총동아리연합회란</h4>
            </div>   
            <div class="container px-4 px-lg-5 text-start">
                <h4 class="mb-4 ps-5 py-5">총동아리연합회 구성도</h4>
                <img src="./resources/assets/img/구성도.png" class="img-fluid col-8 mx-auto d-block" alt="총동아리연합회 구성도">
                
            </div>  
            <div class="container px-4 px-lg-5 text-start">
                <h4 class="mb-4 ps-5 py-5">총동아리연합회 집행부 조직도</h4>
                <img src="./resources/assets/img/조직도.jpg" class="img-fluid col-8 mx-auto d-block" alt="총동아리연합회 구성도">
            </div>                                 
        </section>

	<!-- Footer-->
	<jsp:include page="/WEB-INF/views/inc/footer.jsp" />

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
