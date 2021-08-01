function search(){	
	$.ajax({
		url: "/hgu/search",
		async: false,
		success: function(data){	
			console.log("검색 성공!!");
			location.href="/hgu/search";
		}, 
		error:function(request, status, error){
			console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
        }
	});
}
