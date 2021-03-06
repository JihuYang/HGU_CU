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
<!-- Favicon-->
<link rel="icon" type="image/x-icon"
	href="<%=request.getContextPath()%>/resources/assets/img/favicon.ico" />
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

<link href="<%=request.getContextPath()%>/resources/css/createClubIntro.css" rel="stylesheet" />
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
			<div class="row h-auto align-items-center justify-content-center text-center">
			<div class="col-lg-6 align-self-end">
				<h3 class="font-weight-bold pt-title">동아리 소개</h3>
			</div>
			<!-- 소개글 내용쓰기 -->
			<div class="col-sm-10 justify-content-md-center">
			<form method="POST" enctype="multipart/form-data" id="uploadForm"
				action="<%=request.getContextPath()%>/clubIntroduction/write/update"
				onsubmit="return confirm('글을 수정하시겠습니까?');">
				<input id="id" name="id" value='${clubDetailList[0].id}'
					style="display: none;"></input>
				<div class="dp-it">
					<div class="title-bar">
					<input id="userId" name="userId" value="1" style="display:none">
						<p class="rows">동아리 분과  </p><!-- <input class="form-control title-input" type="text" id="categoryName"> -->
						<select class="form-select select-option" aria-label="Default select example" name="categoryName">
							<option value="${categoryName}">${categoryName}</option>
						  <c:forEach  items="${categoryNameList}" var="categoryNameList" varStatus="status">
						  	<option value="${categoryNameList.categoryName}">${categoryNameList.categoryName}</option>
						  </c:forEach>
						</select>
					</div>
					<div class="title-bar">
						<p class="rows">동아리 이름  </p><input class="form-control title-input" type="text" id="clubName" name="clubName" value="${clubDetailList[0].clubName}">
					</div>
					<div class="title-bar">
						<p class="rows">동아리방 위치 </p><input class="form-control title-input" type="text" id="clubLocation" name="clubLocation" value="${clubDetailList[0].clubLocation}">
					</div>
					<div class="title-bar">
						<p class="rows select-bar">창립연도   </p>
						<!-- <input class="form-control title-input" type="date" id="foundationDate"> -->
						<fmt:formatDate value="${clubDetailList[0].foundationDate}" var="formattedFdDate" type="date" pattern="yyyy" />
						<select class="form-select select-option" aria-label="Default select example" id="foundationDate" name="foundationDate">
						  <option value="${formattedFdDate}">${formattedFdDate}</option>
						  <c:forEach  items="${foundationYearList}" var="foundationYearList" varStatus="status">
						  	<option value="${foundationYearList}">${foundationYearList}</option>
						  </c:forEach>
						</select>
					</div>
							
					<div class="title-bar">
						<p class="rows">인스타그램 주소</p>
						<input class="form-control title-input" type="text" id="instagramLink" name="instagramLink" value="${clubDetailList[0].instagramLink}">
					</div>
					<div class="title-bar">
						<p class="rows">페이스북 주소</p>
						<input class="form-control title-input" type="text" id="facebookLink" name="facebookLink" value="${clubDetailList[0].facebookLink}">
					</div>
				</div>
					<div class="mb-3" id="content" style="display:inline-block;width:100%;text-align:left;">
						<%-- <textarea class="form-control textarea justify-content-center" rows="13" 
						id="clubDescription" name="clubDescription">${clubDetailList[0].clubDescription}</textarea> --%>
					</div>
					<input id="newContent" type="hidden" name="newContent" value="">
					<script src="https://uicdn.toast.com/editor/latest/toastui-editor-all.min.js"></script>
					<script type="text/javascript">
						 /*alert('${communityInfoDetail.content}');*/
						/*const oldContent = '${communityInfoDetail.content}'; */
						
					
					      const content = new toastui.Editor({
					        el: document.querySelector('#content'),
					        height: '500px',
					        initialValue: '',
					        initialEditType: 'wysiwyg',
					        hideModeSwitch: 'true'
					      });

					      content.setHTML('${clubDetailList[0].clubDescription}',true);
					</script>
					<div class="mb-3 text-start">
						기존 파일명 :
							<c:forEach items="${clubImgList}"
								var="clubImgList" varStatus="status">${status.count}. ${clubImgList.originalUrl}
							</c:forEach>
					</div>
					<div class="mb-3">
  						<input class="form-control file" type="file" id="file" name="file" accept="image/*" multiple>
					</div>
					
					<div>
						<a class="btn btn-primary back-btn bottom-btn" href="javascript:history.back()" role="button">뒤로</a> <!-- href="<%=request.getContextPath()%>/clubIntroduction/${categotyId}" -->
						<button class="btn btn-primary submit-btn bottom-btn" onclick="updateClub()">저장</button> 
					</div>
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
	<script src="<%=request.getContextPath()%>/resources/js/scripts.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/club.js"></script>
</body>
</html>
