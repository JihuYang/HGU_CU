<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.js"></script>


<!-- 추가 모달 -->
<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-body">
        <label for="reservationPerson">대여자 이름</label>
  			<input class="form-control form-control-sm" id="reservationPerson">
        <label for="user">사용 단체</label>
  			<input class="form-control form-control-sm" id="user">
  		<label for="etc">장소</label>
  			<!-- <input class="form-control form-control-sm" id="space"> -->
  			<select class='spaceSelect' id="spaceSelect">
		      	<c:forEach items="${spaceList}" var="spaceList">
					<option value="${spaceList.name}">${spaceList.name}</option>
				</c:forEach>
			</select>
        <label for="user">대여 시간</label>
        <div style="display:flex;">
  				<input class="form-control date" placeholder="yyyy-mm-dd" id="reservationDate">
  				<select id='startTime' class="input-resize" onchange="handleTimeLimit(this)"></select>
  				<select id='endTime' class="input-resize">
			        <option value='9:00' selected> 9:00</option>
			        <option value='10:00' >10:00</option>
				</select>
  			</div>
        <label for="purpose">사용 목적</label>
  			<input class="form-control form-control-sm" id="purpose">
        <label for="contact">연락처(이메일)</label>
        <div style="display:flex;">
   			<input class="form-control form-control-sm" placeholder="전화번호" id="phone">
   			<input class="form-control form-control-sm" placeholder="이메일" id="email">
  		</div>
      </div>
      
      <div class="modal-footer">
	      	<button type="button" class="btn btn-outline-secondary" onclick="createAdminReservationInfo()">등록</button>
	        <button type="button" class="btn btn-outline-secondary" data-bs-dismiss="modal">취소</button>
      </div>
      
    </div>
  </div>
</div>


<!-- 수정 모달 -->
<c:forEach items="${reservationInfoList}" var="reservationList" varStatus="status">
<c:if test="${reservationList.person != null}">
<div class="modal fade" id="editModal${status.count}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-body">
        <label for="reservationPerson">대여자 이름</label>
  			<input class="form-control form-control-sm" id="userId" value=''>
        <label for="user">사용 단체</label>
  			<input class="form-control form-control-sm" id="user">
		<label for="reservation-space">장소</label>
  			<input class="form-control form-control-sm" id="space">
        <label for="user">대여 시간</label>
        <div style="display:flex;">
  				<input type="text" class="form-control date" placeholder="yyyy-mm-dd">
  				<input class="form-control form-control-sm" placeholder="시작시간">
  				<input class="form-control form-control-sm" placeholder="종료시간">
  			</div>
        <label for="purpose">사용 목적</label>
  			<input class="form-control form-control-sm">
        <label for="contact">연락처(이메일)</label>
        <div style="display:flex;">
   			<input class="form-control form-control-sm" placeholder="전화번호" id="phone">
   			<input class="form-control form-control-sm" placeholder="이메일" id="email">
  		</div>
      </div>
      
      <div class="modal-footer">
	      	<button class="btn btn-outline-secondary">수정</button>
	        <button type="button" class="btn btn-outline-secondary" data-bs-dismiss="modal">취소</button>
      </div>
      
    </div>
  </div>
</div>
</c:if>
</c:forEach>

<script>
	$("#openModalBtn").on('click', function(){
		$('#addModal').modal('show');
	});

	$(function () {
        $(".date").datepicker();
    });
	
	/* 시작시간 구하기 */
	var hour=7;
  	var startTime = document.getElementById('startTime');
	for(var i =0; i<32; i++){
		var min =':00';
		hour++;
		if(i%2!=0){
			hour--;
			min=':30';
		}
		startTime.innerHTML+='<option value='+hour+min+'>'
					+hour
					+min
					+'</option>';
		}
  
  
	/* 종료 시간 설정 */
  function handleTimeLimit(e){
	 const text = e.options[e.selectedIndex].text;
	 var time = text.split(':');
	 time[0]++;
	 document.getElementById('endTime').innerHTML=
	    "<option value="+time[0]+time[1]+">"
			+time[0]+':'
			+time[1]
			+"</option>";

	 time[0]++;
	 if(time[0]==25)
		 time[0]=1;
	 document.getElementById('endTime').innerHTML+=
		    "<option value="+time[0]+time[1]+">"
				+time[0]+':'
				+time[1]
				+"</option>";
  }

</script>



