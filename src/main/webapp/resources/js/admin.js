function update(){
				var totalReservationWeek = document.getElementsByName("settingValue")[0].value;
				var totalReservationDay = document.getElementsByName("settingValue")[1].value;
				//alert(totalReservationWeek + " " +totalReservationDay);

				$.ajax({
				    url: "/admin/update",
				    data: {"totalReservationWeek": totalReservationWeek, "totalReservationDay": totalReservationDay},
				    type: "POST",
				    success : function(data){
				      alert("저장되었습니다.")
				    },
				    error : function(){
				      alert("저장에 실패하였습니다")		
				    }
				  });
				
			}
			
function updateClub(clubName,id){
		//alert(clubName);
		
		$.ajax({
				    url: "/adminUser/clubUpdate",
				    data: {"clubName": clubName, "id": id},
				    type: "POST",
				    success : function(data){
				      alert("저장되었습니다.")
				    },
				    error : function(){
				      alert("저장에 실패하였습니다")		
				    }
				  });
}

function updateAuthority(authority,id){
	$.ajax({
				    url: "/adminUser/authorityUpdate",
				    data: {"authority": authority, "id": id},
				    type: "POST",
				    success : function(data){
				      alert("저장되었습니다.")
				    },
				    error : function(){
				      alert("저장에 실패하였습니다")		
				    }
				  });
}

function updateSetting(value,id){
		//alert(value);
		
		$.ajax({
				    url: "/admin/settingUpdate",
				    data: {"value": value, "id": id},
				    type: "POST",
				    success : function(data){
				      alert("저장되었습니다.")
				    },
				    error : function(){
				      alert("저장에 실패하였습니다")		
				    }
				  });
}

function updateStartHour(value,id){
		//alert(value);
		
		$.ajax({
				    url: "/admin/startHourUpdate",
				    data: {"value": value, "id": id},
				    type: "POST",
				    success : function(data){
				      alert("저장되었습니다.")
				    },
				    error : function(){
				      alert("저장에 실패하였습니다")		
				    }
				  });
}

function updateEndHour(value,id){
		//alert(value);
		
		$.ajax({
				    url: "/admin/endHourUpdate",
				    data: {"value": value, "id": id},
				    type: "POST",
				    success : function(data){
				      alert("저장되었습니다.")
				    },
				    error : function(){
				      alert("저장에 실패하였습니다")		
				    }
				  });
}