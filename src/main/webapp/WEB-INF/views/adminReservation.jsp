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
<link href="./resources/css/styles.css" rel="stylesheet" />

</head>
<jsp:include page="/WEB-INF/views/inc/header.jsp" />
<link href="<%=request.getContextPath()%>/resources/css/admin.css" rel="stylesheet" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="https://kit.fontawesome.com/6333a60c65.js"></script>
<body id="page-top">
	<div class="container width-80 h-auto h-min">
		<div
			class="row h-25 align-items-center justify-content-center text-center">
			<div class="col-lg-6 align-self-center">
				<h3 class="font-weight-bold pt-title">관리자 페이지</h3>
			</div>
		</div>
		<nav class="navbar navbar-expand-lg bg-white justify-content-center">
			<div
				class="h-auto align-items-center justify-content-center text-center admin-nav-border">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item mx-3"><a class="nav-link font-weight"
						href="<%=request.getContextPath()%>/admin">홈페이지 관리</a></li>
					<li class="nav-item mx-3"><a class="nav-link font-weight"
						href="<%=request.getContextPath()%>/adminUser">회원 관리</a></li>
					<li class="nav-item mx-3"><a class="nav-link font-weight" style="background-color: rgb(239, 247, 253);"
						href="<%=request.getContextPath()%>/adminReservation">예약 관리</a></li>
				</ul>
			</div>
		</nav>
		
		<div class="d-flex justify-content-between align-items-center mt-3">
			<nav class="navbar-expand-lg">
			  <form class="d-inline-flex p-2 align-items-center ">
			    <input class="form-control mr-sm-2 " type="search" id="search" placeholder="이름, 단체, 이메일 등을 입력하세요" aria-label="Search">
			    <button class="btn btn-primary search-btn my-2 my-sm-0" type="submit">검색</button>
			  </form>
			</nav>
			<button class="btn btn-primary search-btn justify-content-end" data-toggle="modal" id="openModalBtn" data-target="#addModal">추가</button>
		</div>
		
		<!-- Modal -->
		<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog modal-lg modal-dialog-centered" role="document">
		    <div class="modal-content">
		      <div class="modal-body">
		        <label for="reservationPerson">대여자 이름</label>
    			<input type="name" class="form-control form-control-sm" id="reservationPerson">
		        <label for="user">사용 단체</label>
    			<input type="name" class="form-control form-control-sm" id="user">
		        <label for="user">대여 시간</label>
		        <div style="display:flex;">
    				<input type="name" class="form-control form-control-sm" placeholder="yyyy-mm-dd" id="user">
    				<input type="name" class="form-control form-control-sm" placeholder="시작시간" id="user">
    				<input type="name" class="form-control form-control-sm" placeholder="종료시간"id="user">
    			</div>
		        <label for="purpose">사용 목적</label>
    			<input type="name" class="form-control form-control-sm" id="purpose">
		        <label for="contact">연락처(이메일)</label>
		        <div style="display:flex;">
	    			<input type="name" class="form-control form-control-sm" placeholder="전화번호" id="phone">
	    			<input type="name" class="form-control form-control-sm" placeholder="이메일" id="email">
    			</div>
		        <label for="etc">비고</label>
    			<input type="name" class="form-control form-control-sm" id="etc">
		      </div>
		      
		      <div class="modal-footer">
			      	<button type="button" class="btn btn-outline-secondary">등록</button>
			        <button type="button" class="btn btn-outline-secondary" data-bs-dismiss="modal">취소</button>
		      </div>
		      
		    </div>
		  </div>
		</div>
		
		<script>
			$("#openModalBtn").on('click', function(){
				$('#addModal').modal('show');
			});
		</script>

	

		<div
			class="row h-auto align-items-center justify-content-center text-center">

			<!-- 회원 리스트  -->
			<%@ include file="./ajaxContent/adminReservationList.jsp"%>

		</div>
		<div class="row h-auto align-items-center text-center">
			<nav>
				<ul class="pagination align-items-center justify-content-center">
					<li class="page-item"><a class="page-link" href="#"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							<span class="sr-only">Previous</span>
					</a></li>
					<li class="page-item"><a class="page-link" href="#">1</a></li>
					<li class="page-item"><a class="page-link" href="#">2</a></li>
					<li class="page-item"><a class="page-link" href="#">3</a></li>
					<li class="page-item"><a class="page-link" href="#"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span> <span
							class="sr-only">Next</span>
					</a></li>
				</ul>
			</nav>
		</div>
	</div>

	<!-- Footer-->
	<jsp:include page="/WEB-INF/views/inc/footer.jsp" />

	<!-- Bootstrap core JS-->
	<script
		src="<%=request.getContextPath()%>/resources/assets/js/pagenation.js"></script>

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