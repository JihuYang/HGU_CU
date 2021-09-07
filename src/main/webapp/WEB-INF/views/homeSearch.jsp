<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
<jsp:include page= "<%=\"./inc/\".concat(((String)request.getAttribute(\"header\")))%>" />
<link href="<%=request.getContextPath()%>/resources/css/homeSearch.css"
	rel="stylesheet" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="https://kit.fontawesome.com/6333a60c65.js"></script>
<body id="page-top">
	<div class="container width-80 h-auto h-min">
		<div
			class="row h-auto align-items-center justify-content-center text-center">
			<form accept-charset="UTF-8" name="searchForm"
				class="background-gray py-4 search-margin">
				<div class="rows justify-content-center">
					<select class="form-select form-select-sm search-selector" name="searchType">
						<option value="title" <c:if test="${page[0].searchType eq 'title'}">selected</c:if> >제목</option>
						<option value="content" <c:if test="${page[0].searchType eq 'content'}">selected</c:if> >내용</option>
						<option value="title_content" <c:if test="${page[0].searchType eq 'title_content'}">selected</c:if>>제목+내용</option>
					</select>
				</div>
				<div class="rows justify-content-center">
					<input class="form-control form-control-sm search-input backgrond-white" type="text" name="keyword" value="${page[0].keyword}">
					<button class="btn btn-primary search-btn" type="button" id="searchBtn" onclick="searchInSearchPage()">검색</button>
				</div>
			</form>
			<div class="tag-list mb-5 text-start">
				<c:if test="${tag eq '전체' || empty tag}">
					<input type="button" class="tag backgrond-white py-2" name="btn_name" onclick="getContent('전체','${page[0].searchType}','${page[0].keyword}')" value="전체 ${allCount}" /> 
					<input type="button" class="no-tag backgrond-white py-2" name="btn_name" onclick="getContent('공지사항','${page[0].searchType}','${page[0].keyword}')" value="공지사항 ${communityInfoListCount}" /> 
					<input type="button" class="no-tag backgrond-white py-2" name="btn_name" onclick="getContent('자료실','${page[0].searchType}','${page[0].keyword}')" value="자료실 ${communityMaterialListCount}" />
					<input type="button" class="no-tag backgrond-white py-2" name="btn_name" onclick="getContent('동아리소개','${page[0].searchType}','${page[0].keyword}')" value="동아리 소개 ${clubIntroListCount}" />
					<input type="button" class="no-tag backgrond-white py-2" name="btn_name" onclick="getContent('동아리홍보','${page[0].searchType}','${page[0].keyword}')" value="동아리 홍보 ${clubAdvertiseListCount}" />
				</c:if>
				<c:if test="${tag eq '공지사항'}">
					<input type="button" class="no-tag backgrond-white py-2" name="btn_name" onclick="getContent('전체','${page[0].searchType}','${page[0].keyword}')" value="전체 ${allCount}" /> 
					<input type="button" class="tag backgrond-white py-2" name="btn_name" onclick="getContent('공지사항','${page[0].searchType}','${page[0].keyword}')" value="공지사항 ${communityInfoListCount}" /> 
					<input type="button" class="no-tag backgrond-white py-2" name="btn_name" onclick="getContent('자료실','${page[0].searchType}','${page[0].keyword}')" value="자료실 ${communityMaterialListCount}" />
					<input type="button" class="no-tag backgrond-white py-2" name="btn_name" onclick="getContent('동아리소개','${page[0].searchType}','${page[0].keyword}')" value="동아리 소개 ${clubIntroListCount}" />
					<input type="button" class="no-tag backgrond-white py-2" name="btn_name" onclick="getContent('동아리홍보','${page[0].searchType}','${page[0].keyword}')" value="동아리 홍보 ${clubAdvertiseListCount}" />
				</c:if>
				<c:if test="${tag eq '자료실'}">
					<input type="button" class="no-tag backgrond-white py-2" name="btn_name" onclick="getContent('전체','${page[0].searchType}','${page[0].keyword}')" value="전체 ${allCount}" /> 
					<input type="button" class="no-tag backgrond-white py-2" name="btn_name" onclick="getContent('공지사항','${page[0].searchType}','${page[0].keyword}')" value="공지사항 ${communityInfoListCount}" /> 
					<input type="button" class="tag backgrond-white py-2" name="btn_name" onclick="getContent('자료실','${page[0].searchType}','${page[0].keyword}')" value="자료실 ${communityMaterialListCount}" />
					<input type="button" class="no-tag backgrond-white py-2" name="btn_name" onclick="getContent('동아리소개','${page[0].searchType}','${page[0].keyword}')" value="동아리 소개 ${clubIntroListCount}" />
					<input type="button" class="no-tag backgrond-white py-2" name="btn_name" onclick="getContent('동아리홍보','${page[0].searchType}','${page[0].keyword}')" value="동아리 홍보 ${clubAdvertiseListCount}" />
				</c:if>
				<c:if test="${tag eq '동아리소개'}">
					<input type="button" class="no-tag backgrond-white py-2" name="btn_name" onclick="getContent('전체','${page[0].searchType}','${page[0].keyword}')" value="전체 ${allCount}" /> 
					<input type="button" class="no-tag backgrond-white py-2" name="btn_name" onclick="getContent('공지사항','${page[0].searchType}','${page[0].keyword}')" value="공지사항 ${communityInfoListCount}" /> 
					<input type="button" class="no-tag backgrond-white py-2" name="btn_name" onclick="getContent('자료실','${page[0].searchType}','${page[0].keyword}')" value="자료실 ${communityMaterialListCount}" />
					<input type="button" class="tag backgrond-white py-2" name="btn_name" onclick="getContent('동아리소개','${page[0].searchType}','${page[0].keyword}')" value="동아리 소개 ${clubIntroListCount}" />
					<input type="button" class="no-tag backgrond-white py-2" name="btn_name" onclick="getContent('동아리홍보','${page[0].searchType}','${page[0].keyword}')" value="동아리 홍보 ${clubAdvertiseListCount}" />
				</c:if>
				<c:if test="${tag eq '동아리홍보'}">
					<input type="button" class="no-tag backgrond-white py-2" name="btn_name" onclick="getContent('전체','${page[0].searchType}','${page[0].keyword}')" value="전체 ${allCount}" /> 
					<input type="button" class="no-tag backgrond-white py-2" name="btn_name" onclick="getContent('공지사항','${page[0].searchType}','${page[0].keyword}')" value="공지사항 ${communityInfoListCount}" /> 
					<input type="button" class="no-tag backgrond-white py-2" name="btn_name" onclick="getContent('자료실','${page[0].searchType}','${page[0].keyword}')" value="자료실 ${communityMaterialListCount}" />
					<input type="button" class="no-tag backgrond-white py-2" name="btn_name" onclick="getContent('동아리소개','${page[0].searchType}','${page[0].keyword}')" value="동아리 소개 ${clubIntroListCount}" />
					<input type="button" class="tag backgrond-white py-2" name="btn_name" onclick="getContent('동아리홍보','${page[0].searchType}','${page[0].keyword}')" value="동아리 홍보 ${clubAdvertiseListCount}" />
				</c:if>
			</div>
		</div>
		<div
			class="row h-auto align-items-center justify-content-center text-center">
			<c:if test="${empty tag || tag eq '전체' || tag eq '공지사항'}">
				<div class="text-start p-3">
					<h4>공지사항 내 검색결과 ${communityInfoListCount}건</h4>
				</div>
				<!-- 공지사항 리스트  -->
				<%-- <%@ include file="./ajaxContent/communityInfoList.jsp"%> --%>
				<c:if test="${empty communityInfoList}">
				<hr class="headLine">
				<h5><span class="noResult">'${page[0].keyword}'</span>에 대한 검색 결과를 찾지 못하였습니다.</h5>
				<p class="text-muted">* 단어의 철자가 정확한지 확인해 주세요<br>* 띄어쓰기가 정확한지 획인해 주세요</p>
				</c:if>
				<c:if test="${ !empty communityInfoList}">
					<table class="table text-center">
						<thead>
							<tr>
								<th scope="col" class="col-1 text-center">번호</th>
								<th scope="col" class="col-5 text-center">제목</th>
								<th scope="col" class="col-1 text-center" id="writer">작성자</th>
								<th scope="col" class="col-2 text-center" id="date">날짜</th>
								<th scope="col" class="col-1 text-center" id="count">조회</th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${empty tag || tag eq '전체'}">
								<c:forEach items="${communityInfoList}" var="communityInfo" end="2" >
									<fmt:formatDate value="${communityInfo.regdate}"
										var="formattedRegDate" type="date" pattern="yyyy-MM-dd" />
									<tr class="tr-hover" style="cursor:pointer;" onClick="location.href='<%=request.getContextPath()%>/communityInfo/detail/${communityInfo.id}'">
											<%-- <th scope="row">${fn:length(communityInfoList) - status.index}</th> --%>
											<th scope="row">${communityInfo.id}</th>
											<td class="text-start">${communityInfo.title}</td>
											<td id="writer">${communityInfo.writer}</td>
											<td id="date">${formattedRegDate}</td>
											<td id="count">${communityInfo.viewCount}</td>
										</tr>
								</c:forEach>
							</c:if>
							<c:if test="${!empty tag && tag ne '전체'}">
								<c:forEach items="${communityInfoList}" var="communityInfo">
									<fmt:formatDate value="${communityInfo.regdate}"
										var="formattedRegDate" type="date" pattern="yyyy-MM-dd" />
									<tr class="tr-hover" style="cursor:pointer;" onClick="location.href='<%=request.getContextPath()%>/communityInfo/detail/${communityInfo.id}'">
											<%-- <th scope="row">${fn:length(communityInfoList) - status.index}</th> --%>
											<th scope="row">${communityInfo.id}</th>
											<td class="text-start">${communityInfo.title}</td>
											<td id="writer">${communityInfo.writer}</td>
											<td id="date">${formattedRegDate}</td>
											<td id="count">${communityInfo.viewCount}</td>
									</tr>
								</c:forEach>
							</c:if>
						</tbody>
					</table>
					<c:if test="${empty tag || tag eq '전체'}">
						<c:if test="${communityInfoListCount > 3}">
							<div class="more" onclick="getContent('공지사항','${page[0].searchType}','${page[0].keyword}')">더보기</div>
						</c:if>
					</c:if>
					<c:if test="${!empty tag && tag ne '전체'}">
						<nav id="pagination-comInfo">
							<ul class="pagination align-items-center justify-content-center">
								<c:if test="${page[0].prev}">
									<li class="page-item">
										<a class="page-link" href="<%=request.getContextPath()%>/search?num=${page[0].startPageNum - 1}${page[0].searchTypeKeyword}&tag=공지사항" aria-label="Previous"> 
											<span aria-hidden="true">&laquo;</span>
											<span class="sr-only">Previous</span>
										</a>
									</li>
								</c:if>		
								<c:forEach begin="${page[0].startPageNum}" end="${page[0].endPageNum}" var="num">
								 	<c:if test="${selected != num}">
								 		<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/search?num=${num}${page[0].searchTypeKeyword}&tag=공지사항">${num}</a></li>
								 	</c:if>			 	
									<c:if test="${selected == num}">
										<li class="page-item active"><a class="page-link" href="#">${num}</a></li>
								 	</c:if>
					 			</c:forEach>				
					 			<c:if test="${page[0].next}">
									<li class="page-item">
										<a class="page-link"  href="<%=request.getContextPath()%>/search?num=${page[0].endPageNum + 1}${page[0].searchTypeKeyword}&tag=공지사항" aria-label="Next"> 
											<span aria-hidden="true">&raquo;</span> 
											<span class="sr-only">Next</span>
										</a>
									</li>
								</c:if>
							</ul>
						</nav>
					</c:if>
				</c:if>
			</c:if>
			
			<!-- 자료실 내용  -->
			<c:if test="${empty tag || tag eq '전체' || tag eq '자료실'}">
				<div class="text-start p-3">
					<h4>자료실 내 검색결과 ${communityMaterialListCount}건</h4>
				</div>
				<!-- 자료실 리스트  -->
				<%-- <%@ include file="./ajaxContent/communityMaterialList.jsp"%> --%>
					<c:if test="${empty communityMaterialList}">
						<hr class="headLine">
						<h5><span class="noResult">'${page[1].keyword}'</span>에 대한 검색 결과를 찾지 못하였습니다.</h5>
						<p class="text-muted">* 단어의 철자가 정확한지 확인해 주세요<br>* 띄어쓰기가 정확한지 획인해 주세요</p>
					</c:if>
					<c:if test="${ !empty communityMaterialList}">
						<table class="table text-center">
							<thead>
								<tr>
									<th scope="col" class="col-1 text-center">번호</th>
									<th scope="col" class="col-5 text-center">제목</th>
									<th scope="col" class="col-1 text-center" id="writer">작성자</th>
									<th scope="col" class="col-2 text-center" id="date">날짜</th>
									<th scope="col" class="col-1 text-center" id="count">조회</th>
								</tr>
							</thead>
							<tbody>
								<c:if test="${empty tag || tag eq '전체'}">
									<c:forEach items="${communityMaterialList}" var="communityMaterial" end="2">
										<fmt:formatDate value="${communityMaterial.regdate}"
											var="formattedRegDate" type="date" pattern="yyyy-MM-dd" />
										<tr class="tr-hover" style="cursor:pointer;" onClick="location.href='<%=request.getContextPath()%>/communityMaterials/detail/${communityMaterial.id}'">
											<%-- <th scope="row">${fn:length(communityMaterialList) - status.index}</th> --%>
											<th scope="row">${communityMaterial.id}</th>
											<td class="text-start">${communityMaterial.title}</td>
											<td id="writer">${communityMaterial.writer}</td>
											<td id="date">${formattedRegDate}</td>
											<td id="count">${communityMaterial.viewCount}</td>
										</tr>
									</c:forEach>
								</c:if>
								<c:if test="${!empty tag && tag ne '전체'}">
									<c:forEach items="${communityMaterialList}" var="communityMaterial">
										<fmt:formatDate value="${communityMaterial.regdate}"
											var="formattedRegDate" type="date" pattern="yyyy-MM-dd" />
										<tr class="tr-hover" style="cursor:pointer;" onClick="location.href='<%=request.getContextPath()%>/communityMaterials/detail/${communityMaterial.id}'">
											<%-- <th scope="row">${fn:length(communityMaterialList) - status.index}</th> --%>
											<th scope="row">${communityMaterial.id}</th>
											<td class="text-start">${communityMaterial.title}</td>
											<td id="writer">${communityMaterial.writer}</td>
											<td id="date">${formattedRegDate}</td>
											<td id="count">${communityMaterial.viewCount}</td>
										</tr>
									</c:forEach>
								</c:if>
							</tbody>
						</table>
					</c:if>
				<c:if test="${empty tag || tag eq '전체'}">
					<c:if test="${communityMaterialListCount > 3}">
								<div class="more" onclick="getContent('자료실','${page[1].searchType}','${page[1].keyword}')">더보기</div>
					</c:if>	
				</c:if>
				<c:if test="${!empty tag && tag ne '전체'}">
					<nav id="pagination-mate">
						<ul class="pagination align-items-center justify-content-center">
							<c:if test="${page[1].prev}">
								<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/search?num=${page[1].startPageNum - 1}${page[1].searchTypeKeyword}&tag=자료실"
									aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
										<span class="sr-only">Previous</span>
								</a></li>
							</c:if>
							
							 <c:forEach begin="${page[1].startPageNum}" end="${page[1].endPageNum}" var="num">
							 	<c:if test="${selected != num}">
							 		<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/search?num=${num}${page[1].searchTypeKeyword}&tag=자료실">${num}</a></li>
							 	</c:if>
							 	
							 	<c:if test="${selected == num}">
							 		<li class="page-item active"><a class="page-link" href="#">${num}</a></li>
							 	</c:if>
		 					</c:forEach>
		 					
		 					<c:if test="${page[1].next}">
			 					<li class="page-item"><a class="page-link"  href="<%=request.getContextPath()%>/search?num=${page[1].endPageNum + 1}${page[1].searchTypeKeyword}&tag=자료실"
									aria-label="Next"> <span aria-hidden="true">&raquo;</span> <span
										class="sr-only">Next</span>
								</a></li>
							</c:if>
						</ul>
					</nav>
				</c:if>
			</c:if>
			
			
			
			<!-- 동아리소개 파트  -->
			<c:if test="${empty tag || tag eq '전체' || tag eq '동아리소개'}">
				<div class="text-start p-3">
					<h4>동아리 소개 내 검색결과 ${clubIntroListCount}건</h4>
				</div>
				<!-- 동아리 소개 리스트 -->
				<c:if test="${empty clubIntroList}">
						<div class="mt-5rem">
						<hr>
						<h5><span class="noResult">'${page[2].keyword}'</span>에 대한 검색 결과를 찾지 못하였습니다.</h5>
						<p class="text-muted">* 단어의 철자가 정확한지 확인해 주세요<br>* 띄어쓰기가 정확한지 획인해 주세요</p>
						</div>
				</c:if>
				<c:if test="${ !empty clubIntroList}">
				<div class="club-content" style="display: flex;">
					<div class="row logo-display">
						<%-- <jsp:include page="/WEB-INF/views/ajaxContent/clubIntroduction.jsp" /> --%>
						<c:if test="${empty tag || tag eq '전체'}">
							<c:forEach items="${clubIntroList}" var="clubIntroList" end="2">
								<fmt:formatDate value="${clubIntroList.foundationDate}"
									var="formattedFdDate" type="date" pattern="yyyy" />
								<div class="col-xs-6 col-sm-4 pd-0">
									<div class="overlay-item overlay-effect">
										<img src="resources/upload/clubIntro/${clubIntroList.originalUrl}" alt="임시" /> 
											<a href="<%=request.getContextPath()%>/clubIntroduction/${clubIntroList.categoryId}/${clubIntroList.id}" class="mask"> 
											[${clubIntroList.clubName}]<br>창립일자:
											${formattedFdDate}년<br>대표자명: ${clubIntroList.clubCeoName}<br>연락처:
											${clubIntroList.phone}<br>동방: ${clubIntroList.clubLocation}<br>인스타그램:
											${clubIntroList.instagramLink}<br>페이스북:
											${clubIntroList.facebookLink}
											</a>
									</div>
								</div>
							</c:forEach>
						</c:if>
						<c:if test="${!empty tag && tag ne '전체'}">
							<c:forEach items="${clubIntroList}" var="clubIntroList">
								<fmt:formatDate value="${clubIntroList.foundationDate}"
									var="formattedFdDate" type="date" pattern="yyyy" />
								<div class="col-xs-6 col-sm-4 pd-0">
									<div class="overlay-item overlay-effect">
										<img src="resources/upload/clubIntro/${clubIntroList.originalUrl}" alt="임시" /> 
											<a href="<%=request.getContextPath()%>/clubIntroduction/${clubIntroList.categoryId}/${clubIntroList.id}" class="mask"> 
											[${clubIntroList.clubName}]<br>창립일자:
											${formattedFdDate}년<br>대표자명: ${clubIntroList.clubCeoName}<br>연락처:
											${clubIntroList.phone}<br>동방: ${clubIntroList.clubLocation}<br>인스타그램:
											${clubIntroList.instagramLink}<br>페이스북:
											${clubIntroList.facebookLink}
											</a>
									</div>
								</div>
							</c:forEach>
						</c:if>
					</div>
				</div>
				</c:if>
				<c:if test="${empty tag || tag eq '전체'}">
					<c:if test="${clubIntroListCount > 3}">
								<div class="more" onclick="getContent('동아리소개','${page[2].searchType}','${page[2].keyword}')">더보기</div>
					</c:if>	
				</c:if>
			</c:if>
			
			
			
			
			<!-- 동아리 홍보 구역  -->
			<c:if test="${empty tag || tag eq '전체' || tag eq '동아리홍보'}">
				<div class="text-start p-3">
					<h4>동아리 홍보 내 검색결과 ${clubAdvertiseListCount}건</h4>
				</div>
				<div
					class="col-sm-10 align-self-baseline table-responsive table-height">
					<%-- <jsp:include page="/WEB-INF/views/ajaxContent/clubAdvertise.jsp" /> --%>
					<c:if test="${empty clubAdvertiseList}">
						<hr>
						<h5><span class="noResult">'${page[3].keyword}'</span>에 대한 검색 결과를 찾지 못하였습니다.</h5>
						<p class="text-muted">* 단어의 철자가 정확한지 확인해 주세요<br>* 띄어쓰기가 정확한지 획인해 주세요</p>
					</c:if>
					<c:if test="${ !empty clubAdvertiseList}">
					<table class="table table-hover table-mb" style="table-layout: fixed;">
						<thead>
								<tr>
									<th scope="col" class="col-3 text-center">제목</th>
									<th scope="col" class="col-5 text-center">내용</th>
								</tr>
						</thead>
						<tbody>
							<c:if test="${empty tag || tag eq '전체'}">
								<c:forEach items="${clubAdvertiseList}" var="clubAdvertiseList" end="2">
									<tr style="cursor:pointer;" onClick="location.href='<%=request.getContextPath()%>/clubAdvertise/detail/${clubAdvertiseList.id}'">
										<%-- <c:choose>
											<c:when test="${clubAdvertiseList.originalUrl eq null}">
												<td><img src="https://cdn.pixabay.com/photo/2014/09/26/04/22/water-461597__340.jpg" class="img-thumbnail rounded clubAd-img"></td>
											</c:when>
											<c:when test="${clubAdvertiseList.originalUrl != null}">
												<td><img src="<%=request.getContextPath()%>/resources/img/${clubAdvertiseList.originalUrl}" class="img-thumbnail rounded clubAd-img"></td>
											</c:when>
										</c:choose> --%>
										<th class="col-3 text-center">${clubAdvertiseList.title}</th>
										<td id="clubAd-content"class="col-5">${clubAdvertiseList.content}</td>
									</tr>
								</c:forEach>
							</c:if>
							<c:if test="${!empty tag && tag ne '전체'}">
								<c:forEach items="${clubAdvertiseList}" var="clubAdvertiseList" varStatus="status">
									<tr style="cursor:pointer;" onClick="location.href='<%=request.getContextPath()%>/clubAdvertise/detail/${clubAdvertiseList.id}'">
										<%-- <c:choose>
											<c:when test="${clubAdvertiseList.originalUrl eq null}">
												<td><img src="https://cdn.pixabay.com/photo/2014/09/26/04/22/water-461597__340.jpg" class="img-thumbnail rounded clubAd-img"></td>
											</c:when>
											<c:when test="${clubAdvertiseList.originalUrl != null}">
												<td><img src="<%=request.getContextPath()%>/resources/img/${clubAdvertiseList.originalUrl}" class="img-thumbnail rounded clubAd-img"></td>
											</c:when>
										</c:choose> --%>
										<th class="col-3 text-center">${clubAdvertiseList.title}</th>
										<td id="clubAd-content"class="col-5">${clubAdvertiseList.content}</td>
									</tr>
								</c:forEach>
							</c:if>
						</tbody>
					</table>
					</c:if>
					<c:if test="${empty tag || tag eq '전체'}">
						<c:if test="${clubAdvertiseListCount > 3}">
								<div class="more" onclick="getContent('동아리홍보','${page[3].searchType}','${page[3].keyword}')">더보기</div>
						</c:if>
					</c:if>	
					<c:if test="${!empty tag && tag ne '전체'}">
						<nav id="pagination-clubAd">
							<ul class="pagination align-items-center justify-content-center">
							<c:if test="${page[3].prev}">
								<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/search?num=${page[3].startPageNum - 1}${page[3].searchTypeKeyword}&tag=동아리홍보"
									aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
										<span class="sr-only">Previous</span>
								</a></li>
							</c:if>
							
							 <c:forEach begin="${page[3].startPageNum}" end="${page[3].endPageNum}" var="num">
							 	<c:if test="${selected != num}">
							 		<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/search?num=${num}${page[3].searchTypeKeyword}&tag=동아리홍보">${num}</a></li>
							 	</c:if>
							 	
							 	<c:if test="${selected == num}">
							 		<li class="page-item active"><a class="page-link" href="#">${num}</a></li>
							 	</c:if>
		 					</c:forEach>
		 					
		 					<c:if test="${page[3].next}">
			 					<li class="page-item"><a class="page-link"  href="<%=request.getContextPath()%>/search?num=${page[3].endPageNum + 1}${page[3].searchTypeKeyword}&tag=동아리홍보"
									aria-label="Next"> <span aria-hidden="true">&raquo;</span> <span
										class="sr-only">Next</span>
								</a></li>
							</c:if>
							</ul>
						</nav>
					</c:if>
				</div>
			</c:if>
			<script type="text/javascript">
				var content = document.getElementById('clubAd-content');
				var realContent = content.firstChild;
	
				realContent.className = 'text-center text-muted p-size clubAd-content';
			</script>
			
			
			
		</div>

	</div>

	<!-- Footer-->
	<jsp:include page="/WEB-INF/views/inc/footer.jsp" />
	<!-- Bootstrap core JS-->
	<script
		src="<%=request.getContextPath()%>/resources/js/home.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/community.js"></script>

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