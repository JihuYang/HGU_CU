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



<!-- calendar를 위한 라이브러리 -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src='https://fullcalendar.io/releases/fullcalendar/3.9.0/lib/moment.min.js'></script>
<link href='https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.9.0/fullcalendar.min.css'rel='stylesheet'/>
<link href='https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.9.0/fullcalendar.print.css' rel='stylesheet' media='print'/>
<script src='https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.9.0/fullcalendar.min.js'></script>

<!-- calendar2를 위한 라이브러리 -->
<link href="./resources/css/fullcalendar.css" rel="stylesheet"/>
<script src="./resources/js/fullcalendar.js"></script>
<script src="./resources/js/daygrid.js"></script>

</head>
<jsp:include page="/WEB-INF/views/inc/header.jsp"/>
<script src="https://kit.fontawesome.com/6333a60c65.js"
	crossorigin="anonymous"></script>

<body id="page-top">
	<!-- Masthead-->
        <div class="R_container h-100">
      		<div class="side_bar">	
       			<div class="reservation" style="background-color:black"><a href="./reservation">
                	<div>
                		<i class="fa fa-home fa-3x white" aria-hidden="true"></i><br><div class="side_text">조회 및 예약하기</div>
                	</div></a>
               </div>   
	           <div class="reservation" style="background-color:gray"><a href="./myReservation">
	           	<div>
	           	<i class="fa fa-user fa-3x" aria-hidden="true"></i><br><div class="side_text">내 예약</div>
	           	</div></a>
	           </div>
	            
            </div>
           
        	<div class="content">
        	
            <h5>조회/예약하기</h5><br>
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
                <button type="button" class="btn_02" onclick="info()">이용안내</button>
                <button type="button" class="btn_02" onclick="info(); location.href='./reserve'">예약하기</button>
            </div>
            
            
            <script type="text/javascript">
  				function info() { 
  					alert("<이용안내>"
      						+"\n1. 각 공간의 이용시간을 준수합니다."
      						+"\n2. 예약은 사용 1일 전까지 신청가능합니다. 당일 예약은 불가합니다."
      						+"\n3. 밴드연습실의 경우, 별도의 hisnet 공지를 참고해주세요."
      						+"\n4. 공간 사용시 안전사고가 발생하지 않도록 주의합니다."
      						+"\n5. 이용시간 종료 전까지 이전 상태로 돌려놓습니다."

      						+"\n\n<주의사항>"
      						+"\n1. 예약자 이름을 바꾸는 식으로 연속 사용 불가합니다."
      						+"\n2. 취식은 금지합니다."
      						+"\n3. 위 주의사항들을 어겼을시 개인 혹은 소속단체에게 학칙이 정하는 선에서 불이익을 드릴 수 있습니다."
                  );
  				}
  			</script>

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
            
            <div id='calendar'></div>
         <script type="text/javascript">
         document.addEventListener('DOMContentLoaded', function() {
      		var calendarEl = document.getElementById('calendar');
      		
      		var calendar = new FullCalendar.Calendar(calendarEl, {
      		plugins: [ 'interaction', 'dayGrid', 'timeGrid' ],
      		defaultView: 'dayGridMonth', 
      		defaultDate: new Date(), 
      		header: { 
      		left: 'prev,next today',
      		center: 'title', 
      		right: '' 
      		}, 
      		}); 
      		 calendar.render(); });
         
         </script>
            
         </div>
	
			      
         	
	<!-- Footer-->
	<footer class="bg-light py-5">
		<div class="container px-4 px-lg-5">
			<div class="small text-center text-muted">Copyright &copy; 2021
				- 한동대학교 총동아리연합회</div>
		</div>
	</footer>


         </div>
            
            
            

		
	

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
