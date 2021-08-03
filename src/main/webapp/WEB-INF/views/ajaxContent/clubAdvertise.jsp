<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table class="table table-hover table-mb">
	<c:forEach items="${clubAdvertiseList}" var="clubAdvertiseList" varStatus="status">
		<tr style="cursor:pointer;" onClick="location.href='<%=request.getContextPath()%>/clubAdvertise/detail/${clubAdvertiseList.id}'">
			<c:choose>
				<c:when test="${clubAdvertiseList.originalUrl == null}">
					<td><img
						src="https://cdn.pixabay.com/photo/2014/09/26/04/22/water-461597__340.jpg"
						class="img-thumbnail rounded clubAd-img"></td>
				</c:when>
				<c:when test="${clubAdvertiseList.originalUrl != null}">
					<td><img
						src="<%=request.getContextPath()%>/resources/img/${clubAdvertiseList.originalUrl}"
						class="img-thumbnail rounded clubAd-img"></td>
				</c:when>
			</c:choose>
			<td>
				<h5>${clubAdvertiseList.title}</h5>
				<p class="text-muted p-size clubAd-content">${clubAdvertiseList.content}</p>
			</td>
		</tr>
	</c:forEach>
</table>