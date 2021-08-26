<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="<%=request.getContextPath()%>/resources/css/footer.css" rel="stylesheet" />

	<footer class="bg-light py-5">
		<div class="container px-4 px-lg-5">
			<div class="footer-content">
				<div class="small text-center text-muted align-self-center">
					오피스 위치: 학관 219호(A)/218<br>
					전화번호: 내선번호 1635(054-260)<br>
					메일: clubunion@handong.edu <br>
					총동연 인스타 계정: @hgu_clubunion<br>
					개인정보처리 방침<br>
				</div>
				<div class="small text-center text-muted">
					오피스 아워 시간: <br>
					<c:forEach items="${officeHour}" var="officeHour" varStatus="status">
					<fmt:formatDate value="${officeHour.startTime}" var="formattedStartTime" type="time" pattern="HH:mm"/>
					<fmt:formatDate value="${officeHour.endTime}" var="formattedEndTime" type="time" pattern="HH:mm"/>
						${officeHour.day} : ${formattedStartTime} ~ ${formattedEndTime}<br>
					</c:forEach>
				</div>
			</div>
			<br>
			<div class="small text-center text-muted">
			Copyright &copy; 2021 - 한동대학교 총동아리연합회</div>
		</div>
	</footer>