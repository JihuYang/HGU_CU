<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>	

<!-- 추가 모달 -->
		<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog modal-lg modal-dialog-centered" role="document">
		    <div class="modal-content">
		      <form class="modal-body">
		        <label for="eventName">행사이름</label>
		  			<input class="form-control form-control-sm" id="eventName">
		        <label for="place">장소</label>
		  			<input class="form-control form-control-sm" id="place">
		        <label for="eventDate">날짜/시간</label>
		        <div style="display:flex;">
  				<input class="form-control date" placeholder="yyyy-mm-dd" id="eventDate">
  				<select id='startTime' class="startTime input-resize" onchange="handleTimeLimit(this)">
  					<!-- <option value='8:00' selected>8:00</option>
  					<option value='8:30'>8:30</option> -->
  				</select>
  				<select id='endTime' class="endTime input-resize">
			        <!-- <option value='9:00' selected>9:00</option>
			        <option value='10:00' >10:00</option> -->
				</select>
  			</div>
		      </form>
		      
		      <div class="modal-footer">
			      	<button type="button" class="btn btn-outline-secondary" onclick="createAdminReservationInfo()">등록</button>
			        <button type="button" class="btn btn-outline-secondary" data-bs-dismiss="modal" onclick="location.reload(true);">취소</button>
		      </div>
		      
		    </div>
		  </div>
		</div>
		
		<script>
			$("#modal-btn").on('click', function(){
				$('#addModal').modal('show');
			});
			
			$(function () {
		        $("#eventDate").datepicker({format: 'yyyy-mm-dd'});
		    });
		</script>