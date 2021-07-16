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
<link href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.15.3/css/fontawesome.min.css" rel="stylesheet">
<!-- Core theme CSS (includes Bootstrap)-->
<link href="./resources/css/styles.css" rel="stylesheet" />
<link href="./resources/css/home.css" rel="stylesheet" />
<link href="./resources/css/reservation.css" rel="stylesheet" />
<link href="./resources/css/calendar.css" rel="stylesheet"/>


</head>
<jsp:include page="/WEB-INF/views/inc/header.jsp"/>
<script src="https://kit.fontawesome.com/6333a60c65.js"
	crossorigin="anonymous"></script>

<body id="page-top">
	<!-- Masthead-->
        <div class="R_container h-100">
      		<div class="side_bar">	
       			<div id="reservation">
                	<div>
                		<i class="fa fa-home fa-3x white" aria-hidden="true"></i><br>조회 및 예약하기
                	</div>
               </div>   
	           <div id="myReservation">
	           	<div>
	           	<i class="fa fa-user fa-3x" aria-hidden="true"></i><br>내 예약
	           	</div>
	           </div>
	            
            </div>
            
	        <div id="top_margin"></div>
        	<div class="content">
        	
            <h4>조회/예약하기</h4><br>
            <div>
                <button type="button" class="btn">CCR - 대형</button>
                <button type="button" class="btn">CCR - 중대형</button>
                <button type="button" class="btn">CCR - 중형</button>
                <button type="button" class="btn">CCR - 소형</button>
                <button type="button" class="btn">지하연습실 - 대형</button>
                <button type="button" class="btn">지하연습실 - 중형</button>
                <button type="button" class="btn">지하연습실 - 소형</button>
                <button type="button" class="btn">밴드연습실</button>
            </div>
            <div class="section2">
                <button type="button" class="btn_02">이용안내</button>
                <button type="button" class="btn_02">예약하기</button>
            </div>

            <table>
                <tr>
                    <td>공간</td>
                    <td>CCR-대형</td>
                </tr>
                <tr>
                    <td>수용 가능 인원</td>
                    <td>1500명</td>
                </tr>
                <tr>
                    <td>추가 설명</td>
                    <td>대형 CCR 입니다</td>
                </tr>
            </table>

            <div class="section3">
                <div>예약</div>
                <div>지난예약</div>
            </div>
            
         </div>
         </div>
            
            
            
            
            <!-- calendar -->

		
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
