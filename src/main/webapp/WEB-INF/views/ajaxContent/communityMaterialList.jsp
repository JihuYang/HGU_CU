<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

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
		<c:forEach items="${communityMaterialList}" var="communityMaterial"
			varStatus="status">
			<fmt:formatDate value="${communityMaterial.regdate}"
				var="formattedRegDate" type="date" pattern="yyyy-MM-dd" />
			<tr class="tr-hover" style="cursor:pointer;" onClick="location.href='<%=request.getContextPath()%>/communityMaterials/detail/${communityMaterial.id}'">
				<th scope="row">${fn:length(communityMaterialList) - status.index}</th>
				<td class="text-start">${communityMaterial.title}</td>
				<td id="writer">${communityMaterial.writer}</td>
				<td id="date">${formattedRegDate}</td>
				<td id="count">${communityMaterial.viewCount}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>