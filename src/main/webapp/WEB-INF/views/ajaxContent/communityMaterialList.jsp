<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:if test="${empty communityMaterialList}">
			<hr class="headLine">
			<h5><span class="noResult">'${page.keyword}'</span>에 대한 검색 결과를 찾지 못하였습니다.</h5>
			<p class="text-muted">* 단어의 철자가 정확한지 확인해 주세요<br>* 띄어쓰기가 정확한지 획인해 주세요</p>
</c:if>
<c:if test="${ !empty communityMaterialList}">
<table class="table text-center table-layout-f">
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
		<c:forEach items="${communityMaterialList}" var="communityMaterial"
			varStatus="status">
			<fmt:formatDate value="${communityMaterial.regdate}"
				var="formattedRegDate" type="date" pattern="yyyy-MM-dd" />
			<tr class="tr-hover" style="cursor:pointer;" onClick="location.href='<%=request.getContextPath()%>/communityMaterials/detail/${communityMaterial.id}'">
				<%-- <th scope="row">${fn:length(communityMaterialList) - status.index}</th> --%>
				<th scope="row">${communityMaterial.id}</th>
				<td class="text-start title-shortening">${communityMaterial.title}</td>
				<c:choose>
					<c:when test="${admin == 0}">
					<td id="writer">${communityMaterial.writer}</td>
					</c:when>
					<c:otherwise>
					<td id="writer">관리자</td>							
					</c:otherwise>
				</c:choose>				
				<td id="date">${formattedRegDate}</td>
				<td id="count">${communityMaterial.viewCount}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</c:if>