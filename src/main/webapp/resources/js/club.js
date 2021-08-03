function createClubIntro(){	
	$.ajax({
		url: "/hgu/clubIntroduction/write/create",
		type: "POST",
		async: false,
		data: {
			categoryName: $('#categoryName').val(),
			clubName: $('#clubName').val(),
			clubLocation: $('#clubLocation').val(),
			foundationDate: $('#foundationDate').val(),
			instagramLink: $('#instagramLink').val(),
			facebookLink: $('#facebookLink').val(),
			clubDescription: $('#clubDescription').val(),
			originalUrl: $('#originalUrl').val()
		},
		success: function(data){	
			console.log("동아리 소개 글쓰기 성공!!");
			console.log("clubName: " + clubName);
			location.href="/hgu/clubIntroduction";
		}, 
		error:function(request, status, error){
			console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
        }
	});
}