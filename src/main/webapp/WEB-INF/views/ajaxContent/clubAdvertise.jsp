<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:if test="${empty clubAdvertiseList}">
			<hr>
			<h5><span class="noResult">'${page.keyword}'</span>에 대한 검색 결과를 찾지 못하였습니다.</h5>
			<p class="text-muted">* 단어의 철자가 정확한지 확인해 주세요<br>* 띄어쓰기가 정확한지 획인해 주세요</p>
</c:if>
<c:if test="${ !empty clubAdvertiseList}">
<table class="table table-hover table-mb">
	<c:forEach items="${clubAdvertiseList}" var="clubAdvertiseList" varStatus="status">
		<tr style="cursor:pointer;" onClick="location.href='<%=request.getContextPath()%>/clubAdvertise/detail/${clubAdvertiseList.id}'">
			<c:choose>
				<c:when test="${clubAdvertiseList.originalUrl eq null}">
					<td><img
						src="${defaultImage}"
						class="img-thumbnail rounded clubAd-img"></td>
				</c:when>
				<c:when test="${clubAdvertiseList.originalUrl != null}">
<%-- 					<td><img
						src="<%=request.getContextPath()%>/resources/upload/file/clubAd/${clubAdvertiseList.originalUrl}"
						class="img-thumbnail rounded clubAd-img"></td> --%>
					<td><img
						src="http://hsca219.cafe24.com/uploads/clubAdvertise/${clubAdvertiseList.originalUrl}"
						class="img-thumbnail rounded clubAd-img"></td>		
				</c:when>
			</c:choose>
			<td>
				<h5 class="clubAd-content">${clubAdvertiseList.title}</h5>
				<div class="p-content">${clubAdvertiseList.content}</div>
			</td>
		</tr>
	</c:forEach>
</table>
</c:if>

<script type="text/javascript">
var content = document.getElementsByClassName('p-content');

for(i=0;i<content.length;i++){
	content[i].firstChild.className = 'text-muted p-size clubAd-content';	
}
</script>