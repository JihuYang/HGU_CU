<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Modal -->
<%@ include file="adminReservationModal.jsp"%>

<table
	class="table align-items-center justify-content-center text-center ">
	<thead class="p-4">
		<tr class="tr-border">
			<th scope="col" class="username col-2"><h5>대여자 이름</h5></th>
			<th scope="col" class="contact col-2"><h5>사용단체</h5></th>
			<th scope="col" class="time col-1"><h5>대여시간</h5></th>
			<th scope="col" class="purpose col-2"><h5>사용목적</h5></th>
			<th scope="col" class="email col-2"><h5>연락처(이메일)</h5></th>
			<th scope="col" class="etc col-1"><h5>비고</h5></th>
			<th scope="col" class="manage col-2"><h5>관리</h5></th>
		</tr>
	</thead>
	<tbody class="align-items-center p-4">
		<c:forEach items="${reservationInfoList}" var="reservationList" varStatus="status">
		<c:if test="${reservationList.person != null}">
			<tr>
				<td id="username${status.count}" class="username">${reservationList.person}</td>
				<td id="contact${status.count}" class="contact">${reservationList.spaceName}</td>
				<td id="time${status.count}" class="time">${reservationList.startTime}</td>
				<td id="purpose${status.count}" class="purpose">${reservationList.purpose}</td>
				<td id="email${status.count}" class="email">${reservationList.phone} ${reservationList.email} </td>
				<td id="etc${status.count}" class="etc"></td>	
				<td id="manage${status.count}" class="manage">
					<button type="button" class="btn btn-warning" id="${status.count}"
					onclick="editBtn(this.id)"data-toggle="modal" data-target="#editModal${status.count}">수정</button>
					<button type="button" class="btn btn-warning">삭제</button>
				</td>
			</tr>
		</c:if>
		</c:forEach>

	</tbody>
</table>

<script>
	function editBtn(clickedId){
		/* var name = "username"+clickedId; *//* 
		var name = ${reservationInfoList[count].person}; */
		var name = '${reservationInfoList.get(clicked).person}';
		
		$('#editModal'+clickedId).modal('show');
		$('#modal-user'+clickedId).val(name);	
	}

	$('.date').datepicker({
		format: 'yyyy-mm-dd'
	});

</script>
