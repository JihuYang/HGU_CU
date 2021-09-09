<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.js"></script>


<!-- 추가 모달 -->
<div class="modal fade" id="addModal" tabindex="-1" role="dialog" 
aria-labelledby="exampleModalLabel" aria-hidden="true">
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
  			<select class='spaceSelect' id='spaceSelect' onchange="changeSpace(this)">
		      	<c:forEach items="${spaceList}" var="spaceList">
					<option value="${spaceList.name}">${spaceList.name}</option>
				</c:forEach>
			</select>
        <label for="user">대여 시간</label>
        <div style="display:flex;">
  				<!-- <input class="form-control date" placeholder="yyyy-mm-dd" id="reservationDate" onchange="changeDate(this)"> -->
  				<input class="input-resize" id="date" type="date" name="date" onchange="changeDate(this)"
						value=""						min=1999-01-01						max=2100-12-30>
  				<select id='startTime' class="startTime input-resize" onchange="handleTimeLimit(this)">
  				</select>
  				<select id='endTime' class="endTime input-resize">
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
	var hour=7;
	var startTime = document.getElementById('startTime');
	var endTime = document.getElementById('endTime');
	var spaceElem = document.getElementById('spaceSelect');
	var spaceIndex = spaceElem.selectedIndex + 1;
	var rvDate=$("#date").val();
	var time;
	var reservationList = new Array();
	var StimeIdx;
	
	
	Date.prototype.addDays = function(days) {
		var date = new Date(this.valueOf());
		date.setDate(date.getDate() + days);
		return date;
	}
		   
	function DateFormat(date) {
	    var year = date.getFullYear();
	    var month = date.getMonth() + 1;
	    month = month >= 10 ? month : '0' + month;
	    var day = date.getDate();
	    day = day >= 10 ? day : '0' + day;
	    return [year, month, day].join('-');
	}
	
	var today =new Date();
	var endDate = new Date();

	today=DateFormat(today);
	      
	endDate.setDate(endDate.getDate() + 7);
	endDate=DateFormat(endDate);
		  
	//today = yyyy+'-'+mm+'-'+dd;
	document.getElementById("date").setAttribute("min", today);
	document.getElementById("date").value = new Date().toISOString().substring(0, 10);
	  
	//오늘 날짜부터 일주일까지
	document.getElementById("date").setAttribute("max", endDate);
		  
	document.getElementById("date").value = new Date().toISOString().substring(0, 10);
	

	
	$("#openModalBtn").on('click', function(){
		$(".modal-body")[0].reset();
		document.getElementById("updateBtn").style.display = "none";
		document.getElementById("createBtn").style.display = "block";
		$('#addModal').modal('show');
		$('#startTime').find('option:first').attr('selected', 'selected');
		$('#endTime').find('option:first').attr('selected', 'selected');
		document.getElementById("date").value = new Date().toISOString().substring(0, 10);
	});
	
	function editBtn(clickedId){
		$(".modal-body")[0].reset();
		$('#startTime option').each(function() {
  		    $(this).prop('disabled', false);
  		});
		document.getElementById("createBtn").style.display = "none";
		document.getElementById("updateBtn").style.display = "block";
		var name = $('#userName'+clickedId).text();
		var userId = $('#userId'+clickedId).text();
		var eiditPurpose = $('#purpose'+clickedId).text();
		var editSpace = $('#space'+clickedId).text();
		var email = $('#email'+clickedId).text();
		var editReservationDate = $('#reservationDate'+clickedId).text();
		var editStartTime = $('#startTime'+clickedId).text();
		var editEndTime = $('#endTime'+clickedId).text();
		var updateId = $('#updateId'+clickedId).text();
		
		$('#addModal').modal('show');
		$('#updateId').val(updateId);
		$('#userSelect').val(userId).attr("selected", "selected");
		$('#purpose').val(eiditPurpose);
		$("#spaceSelect").val(editSpace).attr("selected", "selected");
		$('#date').val(editReservationDate);
		$("#startTime").val(editStartTime).attr("selected", "selected");
		$("#endTime")[0].innerHTML="<option value='"+editEndTime+"' selected>"+editEndTime+"</option>";
		
	}


	/* 시작시간 구하기 */
	

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
	
	/* 종료시간 기본 값 설정 */
	  var selectedStart = $("#startTime option:selected").val();
	  time = selectedStart.split(':');
	  time[0]++;
	  endTime.innerHTML=
		    "<option value="+time[0]+':'+time[1]+">"
				+time[0]+':'
				+time[1]
				+"</option>";
				
		time[0]++;
		 if(time[0]==25)
			 time[0]=1;
		 endTime.innerHTML+=
			    "<option value="+time[0]+':'+time[1]+">"
					+time[0]+':'
					+time[1]
					+"</option>";
  
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
 	if(e.options[e.selectedIndex+1].disabled==true){
		$('#endTime option').each(function() {
		    $(this).prop('disabled', true);
		});
	}
	if(e.options[e.selectedIndex+2].disabled==true || e.options[e.selectedIndex+3].disabled==true)
		$("#endTime option:eq(1)").prop('disabled',true);
	
  }
  /* 예약 가능한 시간 설정하기 */
	function disabledTime(){
		<c:forEach items="${reservationInfoList}" var="reservationList">
		<fmt:formatDate value="${reservationList.startTime}" var="formattedSTime" pattern="H:mm"/>
		<fmt:formatDate value="${reservationList.endTime}" var="formattedETime" pattern="H:mm"/>
	 	reservationList.push({disabledSTime:"${formattedSTime}",disabledETime:"${formattedETime}",
	 			spaceId:"${reservationList.spaceId}",reservationDate:"${reservationList.reservationDate}"});
		</c:forEach>
	
	
		for(var j=0;j<reservationList.length;j++){
			if(reservationList[j].spaceId==spaceIndex && reservationList[j].reservationDate==rvDate){
				Stime = reservationList[j].disabledSTime.split(':');
				Etime = reservationList[j].disabledETime.split(':');
				var timeLimit = Etime[0]-Stime[0];
				StimeIdx = $("#startTime option[value='"+reservationList[j].disabledSTime+"']").index();
				console.log("index is "+StimeIdx);
				Stime[0]++;
				if(Stime[0]==8 || Stime[0]==9){
					$('#endTime option').each(function() {
		    		    $(this).prop('disabled', true);
		    		});
				}
				else{
					$("#endTime option[value='"+Stime[0]+":"+Stime[1]+"']").prop('disabled',true);
				}
					
				for(var k=0;k<=(2*timeLimit-1);k++){
					$("#startTime option:eq("+StimeIdx+")").prop('disabled',true);
					console.log("loof index is "+StimeIdx);
					StimeIdx++;
				}
			}
		}
	}
  
 	disabledTime();
 	
 	function changeSpace(e){
  	  spaceIndex = e.options[e.selectedIndex].index+1;
  	  
  	  $('#startTime option').each(function() {
  		    $(this).prop('disabled', false);
  		});
  	  disabledTime();
  	  console.log(spaceIndex);
    }
    
    function changeDate(e){
  	  rvDate=e.value;

  	  $('#startTime option').each(function() {
  		    $(this).prop('disabled', false);
  		});
  	  disabledTime();
  	  console.log(rvDate);
    }

</script>



