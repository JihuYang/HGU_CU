<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Modal -->
<%@ include file="adminReservationModal.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<table
	class="table align-items-center justify-content-center text-center ">
	<thead class="p-4">
		<tr class="tr-border">
			<th scope="col" class="username col-2"><h5>대여자 이름</h5></th>
			<th scope="col" class="reservation-space col-1"><h5>장소</h5></th>
			<th scope="col" class="time col-2"><h5>대여시간</h5></th>
			<th scope="col" class="purpose col-1"><h5>사용목적</h5></th>
			<th scope="col" class="email col-2"><h5>연락처(이메일)</h5></th>
			<th scope="col" class="manage col-2"><h5>관리</h5></th>
		</tr>
	</thead>
	<tbody class="align-items-center p-4">
		<c:forEach items="${reservationInfoList}" var="reservationList" varStatus="status">
		<div id="id" style="display:none">${reservationList.id}</div>
		<c:if test="${reservationList.person != null}">
			<tr>
			<fmt:formatDate value="${reservationList.startTime}"
				var="formattedStartTime" type="date" pattern="H:mm" />
			<fmt:formatDate value="${reservationList.endTime}"
				var="formattedEndTime" type="date" pattern="H:mm" /> 
				<td id="username${status.count}" class="username">${reservationList.person}</td>
				<td id="space${status.count}" class="reservation-space">${reservationList.spaceName}</td>	
				<td id="time${status.count}" class="time">
					<span id='reservationDate${status.count}'>${reservationList.reservationDate}</span>
					<br><span id='startTime${status.count}'>${formattedStartTime}</span> ~ 
					<span id='endTime${status.count}'>${formattedEndTime}</span>
				</td>
				<td id="purpose${status.count}" class="purpose">${reservationList.purpose}</td>
				<td class="email"><span id="phone${status.count}">${reservationList.phone}</span> <span id="email${status.count}">${reservationList.email}</span> </td>
				<td id="manage${status.count}" class="manage">
					<button type="button" class="btn btn-warning" id="${status.count}"
					onclick="editBtn(this.id)"data-toggle="modal" data-target="#editModal${status.count}">수정</button>
					<button type="button" class="btn btn-warning" onclick="location.href='<%=request.getContextPath()%>/adminReservation/delete/${reservationList.id}'">삭제</button>
				</td>
			</tr>
		</c:if>
		</c:forEach>

	</tbody>
</table>
