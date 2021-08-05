function createCommunityInfo() {
	$.ajax({
		url: "/hgu/communityInfo/write/create",
		type: "POST",
		async: false,
		data: {
			userId: $('#userId').val(),
			title: $('#title').val(),
			content: $('#content').val(),
			originalUrl: $('#originalUrl').val(),
		},
		success: function(data) {
			console.log("커뮤니티 글쓰기 성공!!");
			console.log("userId: " + userId);
			location.href = "/hgu/communityInfo";
		},
		error: function(request, status, error) {
			console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
		}
	});
}

function createCommunityMaterial() {
	$.ajax({
		url: "/hgu/communityMaterials/write/create",
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
			location.href = "/hgu/communityMaterials";
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
		url: "/hgu/communityInfo/upload.do",
		data: {
			originalUrl: $("input[name=file]")[0].files[0]
		},
		processData: false,
		contentType: false,
		success: function(data) {
			console.log("파일 업로드 성공!!");		
			//location.href = "/hgu/communityInfo";
		},
		error: function(e) {
			console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
		}
	});
}

