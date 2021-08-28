function createAdminReservationInfo(){	
	var s=document.getElementById("startTime");
	var st=s.options[s.selectedIndex].value;
	st=st+":00";
	var e=document.getElementById("endTime");
	var et=e.options[e.selectedIndex].value;
	et=et+":00";
	var spaceId=document.getElementById("spaceSelect").selectedIndex+1;
	var userId=document.getElementById("userSelect").selectedIndex+1;

	$.ajax({
		url: "/adminReservation/create",
		type: "POST",
		async: false,
		data: {
			userId: userId,
			spaceId: spaceId,
			startTime: st,
			endTime: et,
			purpose: $('#purpose').val(),
			reservationDate: $('#reservationDate').val()
		},
		success: function(){	
			console.log("예약 추가 성공!!");
			location.href="/adminReservation?num=1";
		}, 
		error:function(request, error){
			console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
        }
	});
}

function updateAdminReservationInfo(){
	var s=document.getElementById("startTime");
	var st=s.options[s.selectedIndex].value;
	st=st+":00";
	var e=document.getElementById("endTime");
	var et=e.options[e.selectedIndex].value;
	et=et+":00";
	var spaceId=document.getElementById("spaceSelect").selectedIndex+1;
	var userId=document.getElementById("userSelect").selectedIndex+1;
	var id = $('#updateId').val();
	id=parseInt(id);

	$.ajax({
		url: "/adminReservation/update",
		type: "POST",
		async: false,
		data: {
			id:$('#updateId').val(),
			userId: userId,
			spaceId: spaceId,
			startTime: st,
			endTime: et,
			purpose: $('#purpose').val(),
			reservationDate: $('#reservationDate').val()
		},
		success: function(){	
			console.log("예약 추가 성공!!");
			location.href="/adminReservation?num=1"
		}, 
		error:function(request, error){
			console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
        }
	});
}

function createReservation(){	
	var s=document.getElementById("startTime");
	var st=s.options[s.selectedIndex].value;
	st=st+":00";
	var e=document.getElementById("endTime");
	var et=e.options[e.selectedIndex].value;
	et=et+":00";
	var reservationDate=document.getElementById("date").value;
	var spaceId=document.getElementById("spaceSelect").selectedIndex+1;
	/*
	if(true){
		alert("예약이 마감 되었습니다. 다른 시간을 선택해 주세요");
		location.href = location.href;
		return;
	}
	*/

	$.ajax({
		url: "/reserve",
		type: "POST",
		async: false,
		data: {
			userId: 1,
			spaceId: spaceId,
			startTime: st,
			endTime: et,
			purpose: $('#purpose').val(),
			reservationDate: reservationDate,
			memo: $('#memo').val()
		},
		success: function(){	
			console.log("예약 추가 성공!!");
			location.href="/reservation";
		}, 
		error:function(request, error){
			console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
        }
	});
	
}

function search(){
 		document.getElementById("searchBtn").onclick = function () {
    
  			let keyword =  document.getElementsByName("keyword")[0].value;
  
  			/* console.log(searchType)
  			console.log(keyword) */
  			//alert(keyword);
  			location.href = "/adminReservation?num=1" + "&keyword=" + keyword;
 		};
}


