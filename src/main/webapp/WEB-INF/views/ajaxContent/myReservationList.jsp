<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:forEach items="${reservationInfoList}" var="reservationInfo" varStatus="status">
 <c:if test="${reservationInfo.userId!=0}">
 <fmt:formatDate value="${reservationInfo.regdate}" var="formattedRegDate" type="date" pattern="yyyy-MM-dd" />
 <fmt:formatDate value="${reservationInfo.reservationDate}" var="formattedDate" type="date" pattern="yyyy-MM-dd" />
 <fmt:formatDate value="${reservationInfo.startTime}" var="startTime" type="time" pattern="HH" />
 <fmt:parseNumber value="${(startTime / (1000*60))/60}" integerOnly="true" var="endDate"></fmt:parseNumber>
 <fmt:formatDate value="${reservationInfo.endTime}" var="endTime" type="time" pattern="HH" />
 <fmt:parseNumber value="${(endTime / (1000*60))/60}" integerOnly="true" var="endDate"></fmt:parseNumber>

  <tr>
  	<td>${status.count}</td> 
    <td>${reservationInfo.spaceName}</td>
    <td>??</td>
    <td>${formattedDate}</td>
    <td>${endTime-startTime}</td>
    <td>${reservationInfo.purpose}</td>
    <td>${reservationInfo.person}</td>
    <td>${formattedRegDate}</td>
    <td>??</td>
  </tr>
  </c:if>
 </c:forEach>