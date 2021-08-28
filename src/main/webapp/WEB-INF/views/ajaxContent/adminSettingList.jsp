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
				<td  id="">환경변수 ${status.count}</td>
				<td class=" key">${settingList.key}</td>
				<td class=" value">
				<input id="setting-input" class="form-control form-control-sm w-5" name="settingValue" value="${settingList.value}" onchange="updateSetting(this.value,${settingList.id})">
				</td>
				
			</tr>
		</c:forEach>
		<c:forEach items="${officeHour}" var="officeHour" varStatus="status">
			<tr>
				<td  id="">환경변수 ${status.count + 2}</td>
				<td class=" key">오피스 아워 - ${officeHour.day}</td>
				<td class=" value">
				<input class="form-control form-control-sm w-5 officeHour-start" name="timeValue" value="${officeHour.startTime}" onchange="updateStartHour(this.value,${officeHour.id})">
				</td>
				<td >
				~
				</td>
				<td class=" value">
				<input class="form-control form-control-sm w-5 officeHour-end" name="timeValue" value="${officeHour.endTime}" onchange="updateEndHour(this.value,${officeHour.id})">
				</td>
				
			</tr>
		</c:forEach>
	</tbody>
</table>