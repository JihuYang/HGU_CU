<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table class="table table-hover table-mb">
	<c:forEach items="${clubAdvertiseList}" var="clubAdvertiseList" varStatus="status">
		<tr>
			<td><img
				src="<%=request.getContextPath()%>/resources/img/${clubAdvertiseList.originalUrl}"
				class="img-thumbnail rounded"></td>
			<td>
				<h5>${clubAdvertiseList.title}</h5>
				<p class="text-muted p-size">${clubAdvertiseList.content}</p>
			</td>
		</tr>
	</c:forEach>
</table>