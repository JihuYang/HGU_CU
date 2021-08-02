function createClubAd(){
	$.ajax({
		url: "/hgu/clubAdvertise/write/create",
		type: "POST",
		async: false,
		data: {
			title: $('#title').val(),
			content: $('#content').val(),
			originalUrl: $('#originalUrl').val(),
			fileOriginalUrl: $('#fileOriginalUrl').val()
		},
		success: function(data){	
			console.log("동아리 홍보 글쓰기 성공!!");
			console.log("title: " + title);
			location.href="/hgu/clubAdvertise";
		}, 
		error:function(request, status, error){
		console.log("동아리 홍보 글쓰기 실패..");
			console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
        }
	});
}