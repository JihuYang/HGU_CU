<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:forEach items="${clubIntroList}" var="clubIntroList"
	varStatus="status">
	<fmt:formatDate value="${clubIntroList.foundationDate}"
		var="formattedFdDate" type="date" pattern="yyyy-MM-dd" />
	<div class="col-xs-6 col-sm-4 pd-0">
		<div class="overlay-item overlay-effect">
			<img
				src="<%=request.getContextPath()%>/resources/img/${clubIntroList.originalUrl}"
				alt="임시" /> <a
				href="<%=request.getContextPath()%>/clubIntroduction/${clubIntroList.categoryId}/${clubIntroList.id}"
				class="mask"> [${clubIntroList.clubName}]<br>창립일자:
				${formattedFdDate}<br>대표자명: ${clubIntroList.clubCeoName}<br>연락처:
				${clubIntroList.phone}<br>동방: ${clubIntroList.clubLocation}<br>인스타그램:
				${clubIntroList.instagramLink}<br>페이스북:
				${clubIntroList.facebookLink}
			</a>
		</div>
	</div>
</c:forEach>