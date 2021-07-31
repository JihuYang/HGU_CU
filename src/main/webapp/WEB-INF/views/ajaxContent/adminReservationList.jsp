<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table
	class="table align-items-center justify-content-center text-center ">
	<thead class="p-4">
		<tr class="tr-border">
			<th scope="col" class="col-2" id="username"><h5>대여자 이름</h5></th>
			<th scope="col" class="col-2" id="contact"><h5>사용단체</h5></th>
			<th scope="col" class="col-1" id="time"><h5>대여시간</h5></th>
			<th scope="col" class="col-2" id="purpose"><h5>사용목적</h5></th>
			<th scope="col" class="col-2" id="email"><h5>연락처(이메일)</h5></th>
			<th scope="col" class="col-1" id="etc"><h5>비고</h5></th>
			<th scope="col" class="col-2" id="manage"><h5>관리</h5></th>
		</tr>
	</thead>
	<tbody class="align-items-center p-4">
		<c:forEach items="${reservationInfoList}" var="reservationList" varStatus="status">
		<c:if test="${reservationList.person != null}">
			<tr>
				<td id="username">${reservationList.person}</td>
				<td id="contact">${reservationList.spaceName}</td>
				<td id="time">${reservationList.startTime}</td>
				<td id="club">${reservationList.purpose}</td>
				<td id="email">${reservationList.phone} ${reservationList.email} </td>
				<td></td>	
				<td id="">
				<button type="button" class="btn btn-warning">수정</button>
				<button type="button" class="btn btn-warning">삭제</button>
				</td>
			</tr>
		</c:if>
		</c:forEach>

	</tbody>
</table>
