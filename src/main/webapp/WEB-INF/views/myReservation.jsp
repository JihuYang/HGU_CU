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
       			<div class="reservation" style="background-color:gray"><a href="./reservation">
                	<div>
                		<i class="fa fa-home fa-3x white" aria-hidden="true"></i><br><div class="side_text">조회 및 예약하기</div>
                	</div></a>
               </div>   
	           <div class="reservation" style="background-color:black"><a href="./myReservation.jsp">
	           	<div>
	           	<i class="fa fa-user fa-3x" aria-hidden="true"></i><br><div class="side_text">내 예약</div>
	           	</div></a>
	           </div>
	            
            </div>
           
        	<div class="content">
        	
            <h5>내 예약 목록</h5><br>
            <div>
            	<input type="checkbox" class="btn-check" id="btn-check-2-ccr1" checked autocomplete="off">
				<label class="btn btn-outline-secondary" for="btn-check-2-ccr1">CCR - 대형</label>
				<input type="checkbox" class="btn-check" id="btn-check-2-ccr2" checked autocomplete="off">
				<label class="btn btn-outline-secondary" for="btn-check-2-ccr2">CCR - 중대형</label>
				<input type="checkbox" class="btn-check" id="btn-check-2-ccr3" checked autocomplete="off">
				<label class="btn btn-outline-secondary" for="btn-check-2-ccr3">CCR - 중형</label>
				<input type="checkbox" class="btn-check" id="btn-check-2-ccr4" checked autocomplete="off">
				<label class="btn btn-outline-secondary" for="btn-check-2-ccr4">CCR - 소형</label>
				<input type="checkbox" class="btn-check" id="btn-check-2-room1" checked autocomplete="off">
				<label class="btn btn-outline-secondary" for="btn-check-2-room1">지하연습실 - 대형</label>
				<input type="checkbox" class="btn-check" id="btn-check-2-room2" checked autocomplete="off">
				<label class="btn btn-outline-secondary" for="btn-check-2-room2">지하연습실 - 중형</label>
				<input type="checkbox" class="btn-check" id="btn-check-2-room3" checked autocomplete="off">
				<label class="btn btn-outline-secondary" for="btn-check-2-room3">지하연습실 - 소형</label>
				<input type="checkbox" class="btn-check" id="btn-check-2-room4" checked autocomplete="off">
				<label class="btn btn-outline-secondary" for="btn-check-2-room4">밴드연습실</label><br>
            </div>     

            
            <div>
	            <select id="selectbox" class="form-select form-select-sm" aria-label=".form-select-sm example">
				  <option selected>정렬 방법 선택</option>
				  <option value="1">신청일 순</option>
				  <option value="2">사용일 순</option>
				</select>
			
                <table class="table">
				  <thead class="table-light">
				    <td>NO</td>
				    <td>공간</td>
				    <td>승인여부</td>
				    <td>사용날짜</td>
				    <td>사용시간</td>
				    <td>사용목적</td>
				    <td>신청인</td>
				    <td>신청일</td>
				    <td>예약상태</td>
				  </thead>
				  <tbody>
				    
				  </tbody>
				</table>
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
