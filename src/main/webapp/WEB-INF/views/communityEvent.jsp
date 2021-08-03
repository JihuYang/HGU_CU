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
<link href="<%=request.getContextPath()%>/resources/css/styles.css" rel="stylesheet" />

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

			<div id='datepicker'></div>

			<div class="modal fade" tabindex="-1" role="dialog">
				<div class="modal-dialog modal-dialog-centered" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
							<div id="modal-title">
								<h3>
									<input class="modal-title form-control" style="margin: 0 auto;"
										type="text" name="title" id="title" placeholder="제목 추가" />
								</h3>
							</div>
						</div>
						
						<div class="event-modal-body">
							<div class="grid-item1">장소</div>
							<div class="grid-item2" >
								<input type="text" name="place" id="place" />
							</div>
					
							<div class="grid-item1">시간</div>
							<div class="grid-item2">
								<input class="modal-time" type="text" name="start_at"
									id="starts-at" />
								<label class="col-xs-4 mx-3 b-primary" for="end-at">-</label>
								<input class="modal-time" type="text" name="end_at"
									id="starts-at" />
							</div>
						</div>
						
						<div class="modal-footer">
							<button type="button" class="btn" id="save-event">저장</button>
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
			    longPressDelay: 0,
			    header: {
			      left: "prev,next today",
			      center: "title",
			      right: "month,agendaWeek,agendaDay"
			    },
			    defaultView: "month",
			    navLinks: true, // can click day/week names to navigate views
			    selectable: true,
			    selectHelper: true,
			    editable: true,
			    eventLimit: true, // allow "more" link when too many events
			    select: function(start, end) {
			      // Display the modal.
			      // You could fill in the start and end fields based on the parameters
			      $(".modal").modal("show");
			      $(".modal")
			        .find("#title")
			        .val("");
			      $(".modal")
			        .find("#place")
			        .val("");
			      $(".modal")
			        .find("#starts-at")
			        .val("");
			      $("#save-event").show();
			      $("input").prop("readonly", false);
			    },
			    eventRender: function(event, element) {
			      //dynamically prepend close button to event
			      element
			        .find(".fc-content")
			        .prepend("<span class='closeon material-icons'>&#xe5cd;</span>");
			      element.find(".closeon").on("click", function() {
			        $("#calendar").fullCalendar("removeEvents", event._id);
			      });
			    },
			    eventClick: function(calEvent, jsEvent) {
			      // Display the modal and set event values.
			      $(".modal").modal("show");
			      $(".modal")
			        .find("#title")
			        .val(calEvent.title);
			      $(".modal")
			        .find("#place")
			        .val(calEvent.place);
			      $(".modal")
			        .find("#starts-at")
			        .val(calEvent.start);
			      $("#save-event").hide();
			      $("input").prop("readonly", true);
			    }
			  });
			  /* // Bind the dates to datetimepicker.
			  $("#starts-at").datetimepicker(); */
			  //click to save "save"
			  $("#save-event").on("click", function(event) {
			    var title = $("#title").val();
			    if (title) {
			      var eventData = {
			        title: title,
			        start: $("#starts-at").val(),
			        place: $("#place").val()
			        
			      };
			      $("#calendar").fullCalendar("renderEvent", eventData, true); // stick? = true
			    }
			    $("#calendar").fullCalendar("unselect");
			    // Clear modal inputs
			    $(".modal")
			      .find("input")
			      .val("");
			    // hide modal
			    $(".modal").modal("hide");
			  });
			  $("textarea").autosize();
			});
		</script>
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
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<!-- * *                               SB Forms JS                               * *-->
	<!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>
</html>
