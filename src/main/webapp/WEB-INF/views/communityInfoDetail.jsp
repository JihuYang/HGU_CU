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
<link href="<%=request.getContextPath()%>/resources/css/styles.css"
	rel="stylesheet" />

</head>
<jsp:include page="/WEB-INF/views/inc/header.jsp" />
<link href="<%=request.getContextPath()%>/resources/css/community.css"
	rel="stylesheet" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="https://kit.fontawesome.com/6333a60c65.js"></script>
<body id="page-top">
	<div class="container width-80 h-100 h-auto">
		<div
			class="row h-25 align-items-center justify-content-center text-center">
			<div class="align-self-end">
				<h3 class="font-weight-bold pt-title">공지사항</h3>
			</div>
		</div>
		<div
			class="row h-auto align-items-center justify-content-center text-center">
			<div class="community-detail-title py-5">
				<h4>${communityInfoDetailList[0].title}</h4>
			</div>
		</div>
		<div
			class="row h-auto align-items-center justify-content-end text-end">
			<fmt:formatDate value="${communityInfoDetailList[0].regdate}"
				var="formattedRegDate" type="date" pattern="yyyy-MM-dd" />
			<div class="py-3 detail-info">작성자:
				${communityInfoDetailList[0].writer} | 조회수 :
				${communityInfoDetailList[0].viewCount} | ${formattedRegDate}</div>
		</div>
		<div class="row h-auto align-items-center justify-content-center">
			<div class="px-4 detail-content">${communityInfoDetailList[0].content}</div>
		</div>
		<div
			class="row h-25 align-items-center justify-content-center text-center">

			<table class="table text-center">
				<tbody>
					<tr>
						<th scope="col" class="col-3 text-center file py-4">첨부파일</th>
						<th scope="col" class="col-7 text-start px-3 py-4">파일이름.exel</th>
					</tr>
					<tr>
						<th scope="col" class="col-3 text-center file py-4">첨부파일</th>
						<th scope="col" class="col-7 text-start px-3 py-4"><a href="/communityInfo/detail/filedownload">파일다운로드클릭</a></th>
					</tr>
				</tbody>
			</table>

			<div class="row justify-content-start mt-4 list-btn">
				<button class="btn btn-primary search-btn list-btn">목록</button>
			</div>
		</div>

	</div>

	<!-- Footer-->
	<jsp:include page="/WEB-INF/views/inc/footer.jsp" />
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
