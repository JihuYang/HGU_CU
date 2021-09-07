<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<link
	href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.15.3/css/fontawesome.min.css"
	rel="stylesheet">
<!-- Core theme CSS (includes Bootstrap)-->
<jsp:include page= "<%=\"./inc/\".concat(((String)request.getAttribute(\"header\")))%>" />
<link href="<%=request.getContextPath()%>/resources/css/reservation.css" rel="stylesheet" />
<link href="<%=request.getContextPath()%>/resources/css/calendar.css" rel="stylesheet" />
</head>
<script src="https://kit.fontawesome.com/6333a60c65.js"></script>

<body id="page-top">
	<div class="R_container h-auto h-min">
		<div class="side_bar">
			<div class="reservation" style="background-color: #D0D0CE">
				<div OnClick="location.href ='./reservation?spaceName=전체'" style="cursor:pointer;">
					<i class="fa fa-home fa-2x white" aria-hidden="true"
						style="padding-top: 10px;"></i><br>
					<div class="side_text">조회 및 예약하기</div>
				</div>
			</div>
			<div class="reservation" style="background-color: #212721">
					<div OnClick="location.href ='./myReservation?spaceName=전체'" style="cursor:pointer;">
						<i class="fa fa-user fa-2x" aria-hidden="true"
							style="padding-top: 10px;"></i><br>
						<div class="side_text">내 예약</div>
					</div>
			</div>

		</div>

		<div class="content">

			<h3 style="text-align: center;">내 예약 목록</h3>
			<br>
			<br>

			<div class="top-btns">
				<c:if test="${empty spaceName || spaceName ne '전체'}">
	            	<input type="button" class="btn dp-none" name="btn_name" value="전체" onclick="btn_listener(event)"/>
	            </c:if><!-- 
	            <input type="button" class="btn dp-none" name="btn_name" value="전체" onclick="btn_listener(event)"/> -->
	            <c:if test="${spaceName eq '전체'}">
	            	<input type="button" class="btn active" name="btn_name" value="전체" onclick="btn_listener(event)"/>
	            </c:if>
				<c:set var="spaceName" value="${spaceName}" />
	            <c:forEach items="${spaceList}" var="spaceList">
	            	<c:choose>
	        			<c:when test="${spaceList.name eq spaceName}">
	        				<input type="button" class="btn active" name="btn_name" value="${spaceList.name}" onclick="btn_listener(event)"/>
	        			</c:when>        
	       				<c:when test="${spaceList.name ne spaceName}">
	           				<input type="button" class="btn" name="btn_name" value="${spaceList.name}" onclick="btn_listener(event)"/>
	         			</c:when>
	    			</c:choose>
				</c:forEach>
			</div>


			<div class="myRvTable">
				<select id="selectbox" class="form-select form-select-sm"
					aria-label=".form-select-sm example">
					<option selected>정렬 방법 선택</option>
					<option value="1">신청일 순</option>
					<option value="2">사용일 순</option>
				</select>
			
                <table class="table">
				  <thead class="table-light">
				  	<tr>
					    <td>NO</td>
					    <td>공간</td>
					    <td>승인여부</td>
					    <td>사용날짜</td>
					    <td>사용시간</td>
					    <td>사용목적</td>
					    <td>신청인</td>
					    <td>신청일</td>
					    <td>예약상태</td>
				    </tr>
				  </thead>
				  <tbody>
				  <%@ include file="./ajaxContent/myReservationList.jsp"%>
				  </tbody>

				</table>
			</div>

		</div>
	</div>
	
	<script>
		function btn_listener(event){
				var spaceName = event.target.value;
		   
				if(spaceName == "전체")
					document.getElementsByClassName("dp-none")[0].style.display = "none";
				//alert(spaceName);
				location.href = "/myReservation?spaceName=" + spaceName;
				        
	    }
	</script>

	<!-- calendar -->


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
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<!-- * *                               SB Forms JS                               * *-->
	<!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>
</html>
