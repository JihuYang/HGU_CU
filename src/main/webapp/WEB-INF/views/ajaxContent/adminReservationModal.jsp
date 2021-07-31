<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.js"></script>

<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-body">
        <label for="reservationPerson">대여자 이름</label>
  			<input class="form-control form-control-sm" id="reservationPerson">
        <label for="user">사용 단체</label>
  			<input class="form-control form-control-sm" id="user">
        <label for="user">대여 시간</label>
        <div style="display:flex;">
  				<input type="text" class="form-control date" placeholder="yyyy-mm-dd">
  				<input class="form-control form-control-sm" placeholder="시작시간" id="user">
  				<input class="form-control form-control-sm" placeholder="종료시간"id="user">
  			</div>
        <label for="purpose">사용 목적</label>
  			<input class="form-control form-control-sm" id="purpose">
        <label for="contact">연락처(이메일)</label>
        <div style="display:flex;">
   			<input class="form-control form-control-sm" placeholder="전화번호" id="phone">
   			<input class="form-control form-control-sm" placeholder="이메일" id="email">
  			</div>
        <label for="etc">비고</label>
  			<input class="form-control form-control-sm" id="etc">
      </div>
      
      <div class="modal-footer">
	      	<button type="button" class="btn btn-outline-secondary">등록</button>
	        <button type="button" class="btn btn-outline-secondary" data-bs-dismiss="modal">취소</button>
      </div>
      
    </div>
  </div>
</div>

<script>
	$("#openModalBtn").on('click', function(){
		$('#addModal').modal('show');
	});

	$('.date').datepicker({
		format: 'yyyy-mm-dd'
	});
</script>




