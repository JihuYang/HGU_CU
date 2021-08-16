function search(){	
	$.ajax({
		url: "/hgu/search?num=1",
		async: false,
		success: function(data){	
			console.log("검색 성공!!");
			location.href="/hgu/search?num=1";
		}, 
		error:function(request, status, error){
			console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
        }
	});
}
