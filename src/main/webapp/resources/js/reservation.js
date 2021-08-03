function createAdminReservationInfo(){	
	var s=document.getElementById("startTime");
	var st=s.options[s.selectedIndex].value;
	st=st+":00";
	var e=document.getElementById("endTime");
	var et=e.options[e.selectedIndex].value;
	et=et+":00";
	var space=document.getElementById("spaceSelect");
	var spaceId=space.options[space.selectedIndex].value;
	//if(spaceId eq )

	$.ajax({
		url: "/hgu/adminReservation",
		type: "POST",
		async: false,
		data: {
			userId: $('#reservationPerson').val(),
			spaceId: spaceId,
			startTime: st,
			endTime: et,
			purpose: $('#purpose').val(),
			reservationDate: $('#reservationDate').val()
		},
		success: function(data){	
			console.log("예약 추가 성공!!");
			console.log("userId: " + userId);
			location.href="/hgu/adminReservation";
		}, 
		error:function(request, status, error){
			console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
        }
	});
}

function createReservationInfo(){	
	var s=document.getElementById("startTime");
	var st=s.options[s.selectedIndex].value;
	st=st+":00";
	var e=document.getElementById("endTime");
	var et=e.options[e.selectedIndex].value;
	et=et+":00";
	var reservationDate=document.getElementById("reservationDate").value;

	$.ajax({
		url: "/hgu/adminReservation",
		type: "POST",
		async: false,
		data: {
			userId: $('#reservationPerson').val(),
			startTime: st,
			endTime: et,
			purpose: $('#purpose').val(),
			reservationDate: reservationDate
		},
		success: function(data){	
			console.log("예약 추가 성공!!");
			console.log("userId: " + userId);
			location.href="/hgu/adminReservation";
		}, 
		error:function(request, status, error){
			console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
        }
	});
}
