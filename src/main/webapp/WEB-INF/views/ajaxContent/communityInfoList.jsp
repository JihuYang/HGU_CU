<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
		<c:forEach items="${communityInfoList}" var="communityInfo"
			varStatus="status">
			<fmt:formatDate value="${communityInfo.regdate}"
				var="formattedRegDate" type="date" pattern="yyyy-MM-dd" />
			<tr style="cursor:pointer;" onClick="location.href='<%=request.getContextPath()%>/communityInfo/detail/${communityInfo.id}'">
				<th scope="row">${status.count}</th>
				<td class="text-start">${communityInfo.title}</td>
				<td id="writer">${communityInfo.writer}</td>
				<td id="date">${formattedRegDate}</td>
				<td id="count">${communityInfo.viewCount}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>