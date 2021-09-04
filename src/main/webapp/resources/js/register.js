$(document).ready(function() {

	$("#userInfoBtn").click(function() {
		if ($('input[name="phone"]').val() == "") {
			alert("전화번호를 입력하세요.");
			return;
		}
		if (confirm("회원가입을 하시겠습니까?")) {
			$.ajax({
				url: "/register/registerSave",
				type: "POST",
				async: false,
				data: {
					name: $('input[name="userName"]').val(),
					email: $('input[name="email"]').val(),
					phoneNumber: $('input[name="phone"]').val(),
				},
				success: function(data) {
					console.log(name);
					alert("성공적으로 정보가 등록되었습니다.");
					location.href = "/";
				},
				error: function(request, status, error) {
					console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
				}
			});
		}
	});

})