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
<jsp:include page="/WEB-INF/views/inc/header.jsp" />

<link
	href="<%=request.getContextPath()%>/resources/css/createClubAd.css"
	rel="stylesheet" />

</head>
<script src="https://kit.fontawesome.com/6333a60c65.js"></script>
<body id="page-top">
	<div class="container width-80 h-auto h-min">
		<div
			class="row h-auto align-items-center justify-content-center text-center">
			<div class="col-lg-6 align-self-center">
				<h3 class="font-weight-bold pt-title">공지사항</h3>
			</div>
		</div>
		<!-- 홍보글 테이블 -->

		<div class="justify-content-md-center align-items-center">
			<form method="POST" enctype="multipart/form-data" id="uploadForm"
				action="<%=request.getContextPath()%>/communityInfo/write/update">
				<input id="userId" name="userId" value='1' style="display: none;"></input>
				<input id="id" name="id" value='${communityInfoDetail.id}'
					style="display: none;"></input>
				<div class="title-bar">
					<p class="rows title-bold">제목</p>
					<input class="form-control title-input" type="text" id="title"
						name="title" value="${communityInfoDetail.title}">
				</div>
				<div class="mb-3">
					<textarea class="form-control textarea justify-content-center"
						rows="13" id="content" name="content">${communityInfoDetail.content}</textarea>
				</div>

				<div class="mb-3">
					기존 파일명 :
					<c:forEach items="${communityInfoFileDetail}"
						var="communityInfoFileDetail" varStatus="status">${status.count}. ${communityInfoFileDetail.originalUrl}
					</c:forEach>
				</div>


				<div class="mb-3">
					<input class="form-control file" type="file" name="newfile"
						id="newfile" multiple>
				</div>
				<div>
					<a class="btn btn-primary back-btn bottom-btn" href="./"
						role="button">뒤로</a>
					<button class="btn btn-primary submit-btn bottom-btn" type="submit">저장</button>
				</div>
			</form>

		</div>
	</div>

	<!-- Footer-->
	<jsp:include page="/WEB-INF/views/inc/footer.jsp" />
	<!-- Bootstrap core JS-->
	<script>
		var fileCheck = document.getElementById("newfile").value;
		if (!fileCheck) {
			alert("파일이 없습니다!");
			return false;
		} else {
alert('파일 있음');
			}
		
	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
	<!-- SimpleLightbox plugin JS-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/SimpleLightbox/2.1.0/simpleLightbox.min.js"></script>
	<!-- Core theme JS-->
	<script src="<%=request.getContextPath()%>/resources/js/scripts.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/community.js"></script>
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<!-- * *                               SB Forms JS                               * *-->
	<!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>
</html>