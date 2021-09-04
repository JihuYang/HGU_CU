function createClubIntro(){	
/*	//var categoryId=document.getElementById("categoryId").selectedIndex+2;
	var categoryId=1;
	//var foundationDate = $('#foundationDate').val();
	//foundationDate+="-01-01";
	
	//var val = foundationDate.options[foundationDate.selectedIndex].value;
	console.log(categoryId);
	$.ajax({
		url: "/clubIntroduction/write/create",
		type: "POST",
		async: false,
		data: {
			userId:$('#userId').val(),
			categoryId: categoryId,
			clubName: $('#clubName').val(),
			clubLocation: $('#clubLocation').val(),
			//foundationDate: val,
			instagramLink: $('#instagramLink').val(),
			facebookLink: $('#facebookLink').val(),
			clubDescription: $('#clubDescription').val(),
			originalUrl: $('#originalUrl').val()
		},
		success: function(){	
			console.log("동아리 소개 글쓰기 성공!!");
			console.log("clubName: " + clubName);
			location.href="/clubIntroduction";
		}, 
		error:function(request, error){
			console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
        }
	});*/
	document.getElementById("newContent").value = content.getHTML();
	alert("update 내용 : "+document.getElementById("newContent").value);
}

function search(){
	
 		document.getElementById("button-addon2").onclick = function () {
    
  			let keyword =  document.getElementsByName("keyword")[0].value;
  
  			/* console.log(searchType)
  			console.log(keyword) */
  			//alert(keyword);
  			location.href = "/clubIntroduction" + "?keyword=" + keyword;
 		};
}

function searchInCategory(categoryId){

		document.getElementById("button-addon2").onclick = function () {
    
  			let keyword =  document.getElementsByName("keyword")[0].value;
  
  			/* console.log(searchType)
  			console.log(keyword) */
  			//alert(keyword);
  			location.href = "/clubIntroduction/"+ categoryId + "?keyword=" + keyword;
 		};
}

function updateClub(){
	alert("수정");
	document.getElementById("newContent").value = content.getHTML();
	alert("update 내용 : "+document.getElementById("newContent").value);
}