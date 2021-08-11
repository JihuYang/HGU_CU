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

</head>
<jsp:include page="/WEB-INF/views/inc/header.jsp" />
<link href="<%=request.getContextPath()%>/resources/css/community.css" rel="stylesheet"/>

<link rel='stylesheet' href='https://fullcalendar.io/releases/fullcalendar/3.9.0/fullcalendar.min.css'>
<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.42/css/bootstrap-datetimepicker.min.css'>
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
			
			<div id='calendar'></div>


<div id='datepicker'></div>

<div class="modal fade" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4><input class="modal-title" type="text" name="title" id="title" placeholder="Event Title/Description" /></h4>
      </div>
      <div class="modal-body">
        <div class="row">
          <div class="col-xs-12">
            <label class="col-xs-4" for="starts-at">Starts at</label>
            <input type="text" name="starts_at" id="starts-at" />
          </div>
        </div>
        <div class="row">
          <div class="col-xs-12">
            <label class="col-xs-4" for="ends-at">Ends at</label>
            <input type="text" name="ends_at" id="ends-at" />
          </div>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" id="save-event">Save</button>
      </div>
    </div>
    <!-- /.modal-content -->
  </div>
  <!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<script>
$(document).ready(function() {
	  $("#calendar").fullCalendar({
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
	        .find("#starts-at")
	        .val("");
	      $(".modal")
	        .find("#ends-at")
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
	        .find("#starts-at")
	        .val(calEvent.start);
	      $(".modal")
	        .find("#ends-at")
	        .val(calEvent.end);
	      $("#save-event").hide();
	      $("input").prop("readonly", true);
	    },
	    events:[
			   <c:forEach items="${eventList}" var="eventList">
			   <fmt:formatDate value="${eventList.startDate}" var="startDate" type="date" pattern="yyyy-MM-dd'T'HH:mm:ssz"/>
			   <fmt:formatDate value="${eventList.endDate}" var="endDate" type="date" pattern="yyyy-MM-dd'T'HH:mm:ssz"/>
			   {
			 		id: 1,
			 		title: '${eventList.eventName}',
			 		start: '${startDate}',
			 		end:'${endDate}',
			 		allDay: false,
			 		textColor:'white',
			 		place:'학교',
			 		color: '#326295'
			 	},
			 	</c:forEach>
			 	{
			 		title: "",
			 		start: "1990-01-01",
			 		allDay: false
			 	}
		   ]
	  });

	  // Bind the dates to datetimepicker.
	  $("#starts-at, #ends-at").datetimepicker();

	  //click to save "save"
	  $("#save-event").on("click", function(event) {
	    var title = $("#title").val();
	    if (title) {
	      var eventData = {
	        title: title,
	        start: $("#starts-at").val(),
	        end: $("#ends-at").val()
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
		
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.15.1/moment-with-locales.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.0.1/fullcalendar.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.42/js/bootstrap-datetimepicker.min.js"></script>

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
