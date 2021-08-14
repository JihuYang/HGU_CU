<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<link href="<%=request.getContextPath()%>/resources/css/styles.css" rel="stylesheet" />

<link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" />

</head>
<jsp:include page="/WEB-INF/views/inc/header.jsp" />
<link href="<%=request.getContextPath()%>/resources/css/community.css" rel="stylesheet"/>

<link rel='stylesheet' href='https://fullcalendar.io/releases/fullcalendar/3.9.0/fullcalendar.min.css'>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="https://kit.fontawesome.com/6333a60c65.js"></script>
<body id="page-top">
	<div class="container width-80 h-auto h-min">
		<div
			class="row align-items-center justify-content-center text-center">
			<div class="col-lg-6 align-self-end">
				<h3 class="font-weight-bold pt-title">행사일정</h3>				
			</div>
		</div>
		<div
			class="row h-auto align-items-center justify-content-center text-center">

			<div class="modal fade" tabindex="-1" role="dialog" id="addModal">
				<div class="modal-dialog modal-dialog-centered" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
							<div id="modal-title">
								<h3>
									<input class="modal-title form-control" style="margin: 0 auto;"
										type="text" name="title" id="title" placeholder="행사 이름" />
								</h3>
							</div>
						</div>
						
						<div class="event-modal-body">
							<div class="grid-item1">내용</div>
							<div class="grid-item2" >
								<input type="text" name="eventContent" id="eventContent" />
							</div>
							<div class="grid-item1">장소</div>
							<div class="grid-item2" >
								<input type="text" name="eventSpace" id="eventSpace" />
							</div>
							<div class="grid-item1">날짜(시작)</div>
							<div class="grid-item2">
								<input type="datetime-local" id="startDate"/>
							</div>
					
							<div class="grid-item1">날짜(끝)</div>
							<div class="grid-item2">
								<input type="datetime-local" id="endDate"/>
							</div>
						</div>
						
						<div class="modal-footer">
							<button type="button" class="btn" onclick="createCommutinyEvent()">저장</button>
						</div>
					</div>
				</div>
			</div>
			

			<div id='calendar'></div>
			<!-- partial -->

			<script
				src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>
			<script
				src='https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.15.1/moment-with-locales.min.js'></script>
			<script
				src='https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.0.1/fullcalendar.js'></script>
			<script
				src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>
			<script
				src='https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.42/js/bootstrap-datetimepicker.min.js'></script>

			<script type="text/javascript">
			
			$(function() {
			  $('#calendar').fullCalendar({
			    selectable: true,
			    timeZone: 'Asia/seoul',
			    longPressDelay: 0,
			    header: {
			      left: "prev,next today",
			      center: "title",
			      right: "month,agendaWeek"
			    },
			    defaultView: "month",
			    dayMaxEvents: true,
			    navLinks: true, // can click day/week names to navigate views
			    selectHelper: true,
			    editable: true,
			    eventLimit: true, // allow "more" link when too many events
			    events:[
				   <c:forEach items="${eventList}" var="eventList">
				   <fmt:formatDate value="${eventList.startDate}" var="startDate" type="date" pattern="yyyy-MM-dd'T'HH:mm:ss"/>
				   <fmt:formatDate value="${eventList.endDate}" var="endDate" type="date" pattern="yyyy-MM-dd'T'HH:mm:ss"/>
				   {
				 		id: 1,
				 		title: '${eventList.eventName}',
				 		start: '${startDate}',
				 		end:'${endDate}',
				 		allDay: false,
				 		textColor:'white',
				 		place:'${eventList.eventSpace}',
				 		content:'${eventList.eventContent}',
				 		color: '#326295'
				 	},
				 	</c:forEach>
				 	{
				 		title: "",
				 		start: "1990-01-01",
				 		allDay: false
				 	}
			   ],
			   eventClick: function(event) {
		            // opens events in a popup window
		            // window.open(event.url, 'gcalevent', 'width=700,height=600');
		    		var title = event.title;
		    		document.getElementById('title').readOnly = true;
		    		var content = event.content;
		    		document.getElementById('eventContent').readOnly = true;
		    		var place = event.place;
		    		document.getElementById('eventSpace').readOnly = true;
		    		var startDate = event.start;
		    		document.getElementById('startDate').readOnly = true;

		    		/*
		    		var purpose = $('#purpose'+clickedId).text();
		    		var space = $('#space'+clickedId).text();
		    		var phone = $('#phone'+clickedId).text();
		    		var email = $('#email'+clickedId).text();
		    		var reservationDate = $('#reservationDate'+clickedId).text();
		    		var startTime = $('#startTime'+clickedId).text();
		    		var endTime = $('#endTime'+clickedId).text();
		    		*/
		    		
		    		$('#addModal').modal('show');
		    		$('#title').val(title);
		    		$('#eventContent').val(content);
		    		$('#eventSpace').val(place);
		    		$('#startDate').val(startDate);
		    		/*
		    		$('#purpose').val(purpose);
		    		$("#spaceSelect").val(space).attr("selected", "selected");
		    		$('#phone').val(phone);
		    		$('#email').val(email);
		    		$('#reservationDate').val(reservationDate);
		    		$("#startTime").val(startTime).attr("selected", "selected");
		    		$("#endTime")[0].innerHTML="<option value='"+endTime+"' selected>"+endTime+"</option>";
		    		*/
		            return false;
		        }
			  });
			}); 
		</script>
		</div>
		
		<div class="row justify-content-end mb-4" style="width:90%;">
			<button class="btn btn-primary search-btn" id="eventAddBtn">추가</button>
		</div>
	</div>
	
	<script>
		$("#eventAddBtn").on('click', function(){
			$('#addModal').modal('show');
		});
	</script>

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
	<script src="<%=request.getContextPath()%>/resources/js/event.js"></script>
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<!-- * *                               SB Forms JS                               * *-->
	<!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>
</html>