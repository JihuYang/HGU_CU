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
<link href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.15.3/css/fontawesome.min.css" rel="stylesheet">
<!-- Core theme CSS (includes Bootstrap)-->
<link href="<%=request.getContextPath()%>/resources/css/styles.css" rel="stylesheet" />
<link href="<%=request.getContextPath()%>/resources/css/home.css" rel="stylesheet" />
<link href="<%=request.getContextPath()%>/resources/css/reservation.css" rel="stylesheet" />
<link rel='stylesheet' href='https://fullcalendar.io/releases/fullcalendar/3.9.0/fullcalendar.min.css'>

</head>
<jsp:include page="/WEB-INF/views/inc/header.jsp"/>
<script src="https://kit.fontawesome.com/6333a60c65.js"></script>

<body id="page-top">
        <div class="R_container h-auto h-min">
      		<div class="side_bar">	
       			<div class="reservation" style="background-color:#212721">
                	<div OnClick="location.href ='./reservation'" style="cursor:pointer;">
                		<i class="fa fa-home fa-2x white" aria-hidden="true" style="padding-top:10px;"></i><br><div class="side_text">조회 및 예약하기</div>
                	</div>
               </div>   
	           <div class="reservation" style="background-color:#D0D0CE">
	           	<div OnClick="location.href ='./myReservation'" style="cursor:pointer;">
	           	<i class="fa fa-user fa-2x" aria-hidden="true" style="padding-top:10px;"></i><br><div class="side_text">내 예약</div>
	           	</div>
	           </div>
            </div>
           
        	<div class="content">
        	
            <h3 style="text-align:center;">조회/예약하기</h3><br><br>
            <div>
            
            <c:forEach items="${spaceList}" var="spaceList">			
				<input type="button" class="btn" name="btn_name" value="${spaceList.name}" onclick="btn_listener(event)"/>
			</c:forEach>
			
			<br>
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

  
  				function btn_listener(event){
	  				var name=event.target.value;
	  				
	  				<c:forEach items="${spaceList}" var="space" >
	  					if("${space.name}"==name){
		  					document.getElementById("space_name").innerHTML="${space.name}";
			                document.getElementById("space_capacity").innerHTML="${space.capacity}";
			                document.getElementById("sapce_description").innerHTML="${space.description}";
	  					}
	  				</c:forEach>	          
			    }
  			
  			</script>
  			 </div>
		 
            <table id="space-table">
	                <tr>
	                    <td>공간</td>
	                    <td id="space_name"></td>
	                </tr>
	                <tr>
	                    <td>수용 가능 인원</td>
	                    <td id="space_capacity"></td>
	                </tr>
	                <tr>
	                    <td>추가 설명</td>
	                    <td id="sapce_description"></td>
	                </tr>
	            </table>
        
 
            <div class="section3">
                <div>예약</div>
                <div>지난예약</div>
            </div>
            
            <br>
            
            
  
        <div id='calendar'></div>
	
		<script src='https://fullcalendar.io/releases/fullcalendar/3.9.0/lib/moment.min.js'></script>
		<script src='https://fullcalendar.io/releases/fullcalendar/3.9.0/lib/jquery.min.js'></script>
		<script src='https://fullcalendar.io/releases/fullcalendar/3.9.0/fullcalendar.min.js'></script> 



		<script type="text/javascript">
		 $(function() {
			  $('#calendar').fullCalendar({
			    selectable: true,
			    allDaySlot: false,
			    longPressDelay: 0,
			    header: {
			      left: 'prev,next today',
			      center: 'title',
			      right: 'month,agendaWeek,agendaDay'
			    },
			    dayClick: function(date, jsEvent, view) {
			    	if(view.name == 'month' || view.name == 'basicWeek') {
			    	    $('#calendar').fullCalendar('changeView', 'agendaDay');
			    	    $('#calendar').fullCalendar('gotoDate', date);      
			    	  }
			    	},
			    select: function(startDate, endDate) {
			    },
			    
			    events: [
				 	{
				 		id: 1,
				 		title: "${reservationInfoList[0].spaceName}",
				 		start: '${reservationInfoList[0].reservationDate}T${reservationInfoList[0].startTime}',
				 		allDay: false,
				 		rendering:'list-item'
				 	},
				 	{
				 		id: 2,
				 		title: 'Test2',
				 		start: '2021-07-13T14:00:00',
				 		end: '2021-07-13T16:00:00',
				 		allDay: false
				 	},
				 	{
				 		id: 3,
				 		title: 'Test3',
				 		start: '2021-07-13T14:00:00',
				 		end: '2021-07-13T16:00:00',
				 		allDay: false
				 	}
				 ],
				 eventColor: '#326295'
			  
			  });


			});
	
		</script>
		
	<!-- 	
  		<script src='https://cdn.jsdelivr.net/npm/fullcalendar@5.5.1/main.min.js'></script>
  		<script>
  		document.addEventListener('DOMContentLoaded', function() {
  		    var calendarEl = document.getElementById('calendar');

  		    var calendar = new FullCalendar.Calendar(calendarEl, {
  		      headerToolbar: {
  		        left: 'prev,next today',
  		        center: 'title',
  		        right: 'dayGridMonth,timeGridWeek,timeGridDay'
  		      },
  		      navLinks: true, // can click day/week names to navigate views
  		      businessHours: true, // display business hours
  		      editable: true,
  		      selectable: true,
  		      events: [
  		        {
  		          title: 'Business Lunch',
  		          start: '2021-08-03T13:00:00',
  		          constraint: 'businessHours'
  		        },
  		        {
  		          title: 'Meeting',
  		          start: '2021-08-13T11:00:00',
  		          constraint: 'availableForMeeting', // defined below
  		          color: '#257e4a'
  		        },
  		        {
  		          title: 'Conference',
  		          start: '2021-08-18',
  		          end: '2020-09-20',
  		          display: 'list-item'
  		        },
  		        {
  		          title: 'Party',
  		          start: '2021-08-29T20:00:00'
  		        },

  		        // areas where "Meeting" must be dropped
  		        {
  		          groupId: 'availableForMeeting',
  		          start: '2021-08-11T10:00:00',
  		          end: '2021-08-11T16:00:00',
  		        },
  		        {
  		          groupId: 'availableForMeeting',
  		          start: '2021-08-13T10:00:00',
  		          end: '2021-08-13T16:00:00',
  		          display: 'background'
  		        },

  		        // red areas where no events can be dropped
  		        {
  		          start: '2021-08-24',
  		          end: '2021-08-28',
  		          overlap: false,
  		          display: 'background',
  		          color: '#ff9f89'
  		        },
  		        {
  		          start: '2021-08-06',
  		          end: '2021-08-08',
  		          overlap: false,
  		          display: 'background',
  		          color: '#ff9f89'
  		        }
  		      ]
  		    });

  		    calendar.render();
  		  });
  		
  		</script> -->
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
