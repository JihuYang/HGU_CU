<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table
	class="table align-items-center justify-content-center text-center ">
	<thead class="p-4">
	</thead>
	<tbody class="align-items-center p-4">
		<c:forEach items="${settingList}" var="settingList" varStatus="status">
			<tr>
				<td class="col-1" id="">환경변수 ${status.count}</td>
				<td class="col-1 key">${settingList.key}</td>
				<td class="col-1 value">
				<input id="setting-input" class="form-control form-control-sm w-5" value="${settingList.value}">
				</td>
				
			</tr>
		</c:forEach>
	</tbody>
</table>