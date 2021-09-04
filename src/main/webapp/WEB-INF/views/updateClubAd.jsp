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
<jsp:include page= "<%=\"./inc/\".concat(((String)request.getAttribute(\"header\")))%>" />

<link href="<%=request.getContextPath()%>/resources/css/styles.css"
	rel="stylesheet" />
<link
	href="<%=request.getContextPath()%>/resources/css/createClubAd.css"
	rel="stylesheet" />
	<!-- Editor's Dependecy Style -->
  <link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.48.4/codemirror.min.css"
  />
<!-- Editor's Style -->
  <link
    rel="stylesheet"
    href="https://uicdn.toast.com/editor/latest/toastui-editor.min.css"
  />
  
</head>
<script src="https://kit.fontawesome.com/6333a60c65.js"></script>
<body id="page-top">
	<div class="container width-80 h-auto h-min">
		<div
			class="row h-auto align-items-center justify-content-center text-center">
			<div class="col-lg-6 align-self-center">
				<h3 class="font-weight-bold pt-title">동아리 홍보</h3>
			</div>
			<!-- 동아리 소개 수정 -->
			<div class="justify-content-md-center align-items-center">
				<form method="POST" enctype="multipart/form-data" id="uploadForm"
					action="<%=request.getContextPath()%>/clubAdvertise/write/update">
					<input id="id" name="id" value='${clubAdDetailList[0].id}'
						style="display: none;"></input>
					<div class="title-bar">
						<p class="rows title-bold">제목</p>
						<input class="form-control title-input" type="text" id="title"
							name="title" value="${clubAdDetailList[0].title}">
					</div>
					<div class="mb-3" id="content" style="display:inline-block;width:100%;text-align:left;">
						<%-- <textarea class="form-control textarea justify-content-center"
							rows="13" id="content" name="content" required>${clubAdDetailList[0].content}</textarea> --%>
					</div>
					<input id="newContent" type="hidden" name="newContent" value="">
					<script src="https://uicdn.toast.com/editor/latest/toastui-editor-all.min.js"></script>
					<script type="text/javascript">
						 alert('${clubAdDetailList[0].content}');
						/*const oldContent = '${communityInfoDetail.content}'; */
						
					
					      const content = new toastui.Editor({
					        el: document.querySelector('#content'),
					        height: '600px',
					        initialValue: '',
					        initialEditType: 'wysiwyg',
					        hideModeSwitch: 'true'
					      });

					      content.setHTML('${clubAdDetailList[0].content}',true);
					</script>
					
					<div class="mb-3 text-start">
						기존 파일명 :
						<c:forEach items="${clubAdImgList}" var="clubAdImgList"
							varStatus="status">${status.count}. ${clubAdImgList.originalUrl}
					</c:forEach>
					</div>
					<div class="mb-3">
						<p class="float-l">이미지 파일용</p>
						<input class="form-control file" type="file" id="imagefile"
							name="imagefile" accept="image/*" multiple>
					</div>
					<div class="mb-3 text-start">
						기존 파일명 :
						<c:forEach items="${clubAdFileList}" var="clubAdFileList"
							varStatus="status">${status.count}. ${clubAdFileList.fileOriginalUrl}
					</c:forEach>
					</div>
					<div class="mb-3">
						<p class="float-l">첨부파일용</p>
						<input class="form-control file" type="file" id="adfile"
							name="adfile" multiple>
					</div>
					<div>
						<a class="btn btn-primary back-btn bottom-btn" href="./"
							role="button">뒤로</a>
						<button class="btn btn-primary submit-btn bottom-btn" onclick="updateClubAd()">
							<!-- onclick="createClubAd()" -->
							저장
						</button>
					</div>
				</form>
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
	<script src="<%=request.getContextPath()%>/resources/js/scripts.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/clubAdvertise.js"></script>
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<!-- * *                               SB Forms JS                               * *-->
	<!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>
</html>
