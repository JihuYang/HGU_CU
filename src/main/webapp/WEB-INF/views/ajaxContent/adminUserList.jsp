<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table
	class="table align-items-center justify-content-center text-center ">
	<thead class="p-4">
		<tr class="tr-border">
			<th scope="col" class="col-1" id="username"><h5>이름</h5></th>
			<th scope="col" class="col-3" id="contact"><h5>연락처</h5></th>
			<th scope="col" class="col-3" id="email"><h5>이메일</h5></th>
			<th scope="col" class="col-2" id="club"><h5>소속단체</h5></th>
			<th scope="col" class="col-1" id="authority"><h5>권한</h5></th>
		</tr>
	</thead>
	<tbody class="align-items-center p-4">
		<c:forEach items="${userList}" var="userList" varStatus="status">
			<tr>
				<td id="username">${userList.name}</td>
				<td id="contact">${userList.phone}</td>
				<td id="email">${userList.email}</td>
				<td id="club">
					<select class="clubSelect">
						<c:forEach items="${clubList}" var="clubList" varStatus="status">
							<option <c:if test="${userList.clubName eq clubList.clubName}">selected</c:if>>${clubList.clubName}</option>
						</c:forEach>
					</select>
				</td>

				<td id="authority"><c:if test="${userList.admin == 2}">
						<select class="adminSelect">
							<option value="2" selected>일반회원</option>
							<option value="1">동아리대표자</option>
							<option value="3">차단</option>
							<option value="0">관리자</option>
						</select>
					</c:if> <c:if test="${userList.admin == 1}">
						<select class="adminSelect">
							<option value="2">일반회원</option>
							<option value="1" selected>동아리대표자</option>
							<option value="3">차단</option>
							<option value="0">관리자</option>
						</select>
					</c:if> <c:if test="${userList.admin == 3}">
						<select class="adminSelect">
							<option value="2">일반회원</option>
							<option value="1">동아리대표자</option>
							<option value="3" selected>차단</option>
							<option value="0">관리자</option>
						</select>
					</c:if> <c:if test="${userList.admin == 0}">
						<select class="adminSelect">
							<option value="2">일반회원</option>
							<option value="1">동아리대표자</option>
							<option value="3">차단</option>
							<option value="0" selected>관리자</option>
						</select>
					</c:if></td>
			</tr>
		</c:forEach>

	</tbody>
</table>