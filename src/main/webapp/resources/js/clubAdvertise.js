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

function search(){
	
 		document.getElementById("searchBtn").onclick = function () {
    
  			let searchType = document.getElementsByName("searchType")[0].value;
  			let keyword =  document.getElementsByName("keyword")[0].value;
  
  			/* console.log(searchType)
  			console.log(keyword) */
  			//alert("23");
  			location.href = "/hgu/clubAdvertise?num=1"+ "&searchType=" + searchType + "&keyword=" + keyword;
 		};
}