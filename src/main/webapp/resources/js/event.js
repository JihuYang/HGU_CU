function createCommutinyEvent(){
	
	var startDate = $('#startDate').val();
	var endDate = $('#endDate').val();
	
	startDate=startDate.replace("T"," ")+":00"; 
	endDate=endDate.replace("T"," ")+":00"; 	
	
	$.ajax({
		url: "/hgu/communityEvent",
		type: "POST",
		async: false,
		data: {
			eventName: $('#title').val(),
			eventSpace:$('#eventSpace').val(),
			eventContent:$('#eventContent').val(),
			startDate: startDate,
			endDate: endDate
		},
		success: function(data){	
			console.log("행사일정 추가 성공!!");
			location.href="/hgu/communityEvent";
		}, 
		error:function(request, error){
			console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
        }
	});
}
