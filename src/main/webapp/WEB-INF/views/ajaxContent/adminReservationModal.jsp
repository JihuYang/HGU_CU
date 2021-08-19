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
      <form class="modal-body">
        <label for="reservationPerson">대여자 이름</label>
  			<!-- <input class="form-control form-control-sm" id="reservationPerson"> -->
        	<select class='userSelect' id='userSelect'>
		      	<c:forEach items="${userList}" var="userList">
					<option value="${userList.id}">${userList.name} / ${userList.email}</option>
				</c:forEach>
			</select>
  		<label for="etc">장소</label>
  			<select class='spaceSelect' id='spaceSelect'>
		      	<c:forEach items="${spaceList}" var="spaceList">
					<option value="${spaceList.name}">${spaceList.name}</option>
				</c:forEach>
			</select>
        <label for="user">대여 시간</label>
        <div style="display:flex;">
  				<input class="form-control date" placeholder="yyyy-mm-dd" id="reservationDate">
  				<select id='startTime' class="startTime input-resize" onchange="handleTimeLimit(this)">
  					<!-- <option value='8:00' selected>8:00</option>
  					<option value='8:30'>8:30</option> -->
  				</select>
  				<select id='endTime' class="endTime input-resize">
			        <option value='9:00' selected>9:00</option>
			        <option value='10:00' >10:00</option>
				</select>
  			</div>
        <label for="purpose">사용 목적</label>
  			<input class="form-control form-control-sm" id="purpose">

  		<input class="form-control form-control-sm" id="updateId" style="display:none">
      </form>
      
      <div class="modal-footer">
	      	<button type="button" class="btn btn-outline-secondary" id="createBtn" onclick="createAdminReservationInfo()">등록</button>
	      	<button type="button" class="btn btn-outline-secondary" id="updateBtn" onclick="updateAdminReservationInfo()">등록</button>
	        <button type="button" class="btn btn-outline-secondary" data-bs-dismiss="modal" onclick="location.reload(true);">취소</button>
      </div>
      
    </div>
  </div>
</div>

<script>
	$("#openModalBtn").on('click', function(){
		$(".modal-body")[0].reset();
		document.getElementById("updateBtn").style.display = "none";
		document.getElementById("createBtn").style.display = "block";
		$('#addModal').modal('show');
	});
	
	function editBtn(clickedId){
		$(".modal-body")[0].reset();
		document.getElementById("createBtn").style.display = "none";
		document.getElementById("updateBtn").style.display = "block";
		var name = $('#userName'+clickedId).text();
		var userId = $('#userId'+clickedId).text();
		var purpose = $('#purpose'+clickedId).text();
		var space = $('#space'+clickedId).text();
		var email = $('#email'+clickedId).text();
		var reservationDate = $('#reservationDate'+clickedId).text();
		var startTime = $('#startTime'+clickedId).text();
		var endTime = $('#endTime'+clickedId).text();
		var updateId = $('#updateId'+clickedId).text();
		
		$('#addModal').modal('show');
		$('#updateId').val(updateId);
		$('#userSelect').val(userId).attr("selected", "selected");
		$('#purpose').val(purpose);
		$("#spaceSelect").val(space).attr("selected", "selected");
		$('#reservationDate').val(reservationDate);
		$("#startTime").val(startTime).attr("selected", "selected");
		$("#endTime")[0].innerHTML="<option value='"+endTime+"' selected>"+endTime+"</option>";
	}

	$(function () {
        $("#reservationDate").datepicker({format: 'yyyy-mm-dd'});
    });
	
	/* 시작시간 구하기 */
	var hour=7;
  	var startTime = document.getElementById('startTime');
	for(var i =0; i<32; i++){
		var min =':00';
		if(hour<10)
			hour='0'+hour;
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
	 var endTime = document.getElementById('endTime');
	 var time = text.split(':');
	 time[0]++;
	 
	 endTime.innerHTML=
	    "<option value="+time[0]+":"+time[1]+">"
			+time[0]+':'
			+time[1]
			+"</option>";
	

	 time[0]++;
	 
	 if(time[0]==25)
		 time[0]=1;
 	endTime.innerHTML+=
	    "<option value="+time[0]+":"+time[1]+">"
			+time[0]+':'
			+time[1]
			+"</option>";
	
  }

</script>



