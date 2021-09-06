function createCommunityInfo() {
	//alert(content.getHTML());
	//alert("ㄹ어라ㅣㅇ러");
	//const content = document.querySelector('#content').getHTML();
	$.ajax({
		url: "/communityInfo/write/create",
		type: "POST",
		async: false,
		data: {
			userId: $('#userId').val(),
			title: $('#title').val(),
			content: content.getHTML(),
			originalUrl: $('#originalUrl').val(),
		},
		success: function(data) {
			console.log("커뮤니티 글쓰기 성공!!");
			console.log("userId: " + userId);
			location.href = "/communityInfo";
		},
		error: function(request, status, error) {
			console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
		}
	});
}

function createCommunityMaterial() {
	$.ajax({
		url: "/communityMaterials/write/create",
		type: "POST",
		async: false,
		data: {
			userId: $('#userId').val(),
			title: $('#title').val(),
			content: $('#content').val()
		},
		success: function(data) {
			console.log("커뮤니티 글쓰기 성공!!");
			console.log("userId: " + userId);
			location.href = "/communityMaterials";
		},
		error: function(request, status, error) {
			console.log("커뮤니티 글쓰기 실패..");
			console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
		}
	});
}

function uploadFile() {


	$.ajax({
		type: "POST",
		enctype: 'multipart/form-data',
		url: "/communityInfo/upload.do",
		data: {
			originalUrl: $("input[name=file]")[0].files[0]
		},
		processData: false,
		contentType: false,
		success: function(data) {
			console.log("파일 업로드 성공!!");
			//location.href = "/communityInfo";
		},
		error: function(e) {
			console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
		}
	});
}

function searchInfo() {

	document.getElementById("searchBtn").onclick = function() {

		let searchType = document.getElementsByName("searchType")[0].value;
		let keyword = document.getElementsByName("keyword")[0].value;

		/* console.log(searchType)
		console.log(keyword) */
		//alert("23");
		location.href = "/communityInfo?num=1" + "&searchType=" + searchType + "&keyword=" + keyword;
	};
}

function searchMaterial() {

	document.getElementById("searchBtn2").onclick = function() {

		let searchType = document.getElementsByName("searchType")[0].value;
		let keyword = document.getElementsByName("keyword")[0].value;

		/*console.log(searchType)
		console.log(keyword)*/

		location.href = "/communityMaterials?num=1" + "&searchType=" + searchType + "&keyword=" + keyword;

	};
}

function deleteInfo(){
	if(confirm("정말 삭제하시겠습니까?"))
		location.href="/communityInfo/delete/"+$("#communityInfoDetailId").text();
}

function updateInfo(){
	document.getElementById("newContent").value = content.getHTML();
	alert("update 내용 : "+document.getElementById("newContent").value);
}

function createMate(){
		document.getElementById("newContent").value = content.getHTML();
	//alert("create 내용 : "+document.getElementById("newContent").value);
}

function updateMate(){
		document.getElementById("newContent").value = content.getHTML();
	alert("update 내용 : "+document.getElementById("newContent").value);
}
