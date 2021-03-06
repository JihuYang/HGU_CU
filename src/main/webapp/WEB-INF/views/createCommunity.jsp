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
<jsp:include page= "<%=\"./inc/\".concat(((String)request.getAttribute(\"header\")))%>" />

<link href="./resources/css/styles.css" rel="stylesheet" />
<link href="./resources/css/createClubAd.css" rel="stylesheet" />

</head>
<script src="https://kit.fontawesome.com/6333a60c65.js" crossorigin="anonymous"></script>
<body id="page-top">
	<!-- Masthead-->
	<div class="container px-4 px-lg-5 h-100">
		<div class="row gx-4 gx-lg-5 align-items-center justify-content-center text-center">
			<div class="col-lg-8 align-self-center">
				<h3 class="font-weight-bold pt-title">공지사항</h3>
			</div>
			<!-- 홍보글 테이블 -->
			<div class="col-sm-10 justify-content-md-center">
				<form accept-charset="UTF-8" name="searchForm" action="<%=request.getContextPath()%>/createCommunity" method="POST" >
					<div class="title-bar">
						<p class="rows title-bold">제목</p><input class="form-control title-input" type="text">
					</div>
					<div class="mb-3">
						<textarea class="form-control textarea justify-content-center" rows="13"></textarea>
					</div>
					<div class="mb-3">
  						<input class="form-control file" type="file" multiple>
					</div>
					<div>
						<a class="btn btn-primary back-btn bottom-btn" href="javascript:history.back()" role="button">뒤로</a>
					</div>
				</form>
				
				<form action="upload.do" method="post" enctype="multipart/form-data"> 
							<label><input type="file" name="upload" id = "upload"/></label> 
							<input type="submit" value="업로드" /> 
				</form>
			</div>
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
	<script src="js/scripts.js"></script>
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<!-- * *                               SB Forms JS                               * *-->
	<!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
<!-- 	<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
 --></body>
</html>
