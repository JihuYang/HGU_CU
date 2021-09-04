<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
<jsp:include page= "<%=\"./inc/\".concat(((String)request.getAttribute(\"header\")))%>" />

<!-- Core theme CSS (includes Bootstrap)-->
<link href="<%=request.getContextPath()%>/resources/css/styles.css"
	rel="stylesheet" />
<link
	href="<%=request.getContextPath()%>/resources/css/clubAdvertiseDetail.css"
	rel="stylesheet" />

</head>
<script src="https://kit.fontawesome.com/6333a60c65.js"></script>
<body id="page-top">
	<div class="container width-80 h-auto h-min">
		<div class="row align-items-center justify-content-center text-center">
			<div class="align-self-end">
				<h3 class="font-weight-bold pt-title">동아리홍보</h3>
			</div>
		</div>
		<div
			class="row h-auto align-items-center justify-content-center text-center">
			<div class="clubAd-detail-title py-5">
				<h4>${clubAdDetailList[0].title}</h4>
			</div>
		</div>
		<div
			class="row h-auto align-items-center justify-content-end text-end">
			<fmt:formatDate value="${clubAdDetailList[0].regdate}"
				var="formattedRegDate" type="date" pattern="yyyy-MM-dd" />
			<div class="py-3 detail-info">작성일 : ${formattedRegDate}</div>
		</div>
		<div class="row h-auto align-items-center justify-content-center">
			<div class="px-4 detail-content">${clubAdDetailList[0].content}</div>
			<c:forEach var="clubAdImgList" items="${clubAdImgList}"
				varStatus="status">
				<div id="img-div" class="p-4">
					<img id="clubAdImg"
						src="<%=request.getContextPath()%>/resources/upload/file/clubAd/${clubAdImgList.originalUrl}"
						alt="...">
				</div>
			</c:forEach>
		</div>
		<div
			class="row h-25 align-items-center justify-content-center text-center">

			<table class="table text-center">
				<c:forEach items="${clubAdFileList}" var="clubAdFileList"
					varStatus="status">
					<tr>
						<th scope="col" class="col-3 text-center file py-4">첨부파일</th>
						<th scope="col" class="col-7 text-start px-3 py-4"><a
							href="/clubAdvertise/detail/${clubAdFileList.id}/filedownload">${clubAdFileList.fileOriginalUrl}</a></th>
					</tr>
				</c:forEach>
			</table>

			<div class="row justify-content-start mt-4 list-btn">
				<button class="btn btn-primary search-btn list-btn"
					onclick="location.href='<%=request.getContextPath()%>/clubAdvertise?num=1'">목록</button>
				<c:if test="${userId eq clubAdDetailList[0].writer || admin eq 0}">
				<button class="btn btn-primary search-btn list-btn"
					onclick="location.href='<%=request.getContextPath()%>/clubAdvertise/update/${clubAdDetailList[0].id}'">수정</button>
				<button class="btn btn-primary search-btn list-btn"
					onclick="location.href='<%=request.getContextPath()%>/clubAdvertise/delete/${clubAdDetailList[0].id}'">삭제</button>
				</c:if>
			</div>
		</div>
	</div>
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
