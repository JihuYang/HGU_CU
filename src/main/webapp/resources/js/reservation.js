function createAdminReservationInfo(){	
	var s=document.getElementById("startTime");
	var st=s.options[s.selectedIndex].value;
	st=st+":00";
	var e=document.getElementById("endTime");
	var et=e.options[e.selectedIndex].value;
	et=et+":00";
	var spaceId=document.getElementById("spaceSelect").selectedIndex+1;

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
		success: function(){	
			console.log("예약 추가 성공!!");
			location.href="/hgu/adminReservation";
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

	$.ajax({
		url: "/hgu/reserve",
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
			location.href="/hgu/reservation";
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
  			location.href = "/hgu/adminReservation?num=1" + "&keyword=" + keyword;
 		};
}
