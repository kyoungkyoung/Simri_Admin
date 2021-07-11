<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리 상세페이지</title>
<!-- Bootstrap CDN -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
	crossorigin="anonymous"></script>


<!-- css -->
<style type="text/css">
.adminProfile {
  background-image: url("/simri/img/null3.jpg");
}
</style>
</head>
<body>
<form id="adminModifyForm">
	<!-- 메인 화면 -->
	<div class="container">
		<div class="row">
			<div class="col-lg-12" style="margin-top: 20px">

				<div class="row">
					<div class="col-xs-3 mr-4">
						<img class="adminProfile bd-placeholder-img rounded-circle" width="180"
							height="180" xmlns="http://www.w3.org/2000/svg" role="img"
							aria-label="Placeholder: 140x140"
							preserveAspectRatio="xMidYMid slice" focusable="false"
							src="/simri/img/null3.jpg">
							<title>Placeholder</title><rect width="100%" height="100%"
								fill="#777" />
					</div>
					<!-- /.col-lg-4 -->

					<div class="col-xs-3 border-left my-5 ml-4 mr-4"></div>

					<div class="col-xs-10 ml-4">
						<div class="input-group input-group-sm mb-3 ">
							<span class="input-group-text mr-1" id="inputGroup-sizing-sm">아 이 디</span> 
							<input type="text" class="form-control "
								aria-label="Sizing example input"
								aria-describedby="inputGroup-sizing-sm "
								value="admin"
								id="id" readonly>
						</div>

						<input type="hidden" value="${adminDTO.adminPwd}" id="dbPwd">
						<div class="input-group input-group-sm mb-3">
							<span class="input-group-text mr-1" id="inputGroup-sizing-sm">변경 전 비밀번호</span> 
							<input type="password" class="form-control"
								aria-label="Sizing example input"
								aria-describedby="inputGroup-sizing-sm "
								id="pwd">
						</div>
						
						<div class="input-group input-group-sm mb-3">
							<span class="input-group-text mr-1" id="inputGroup-sizing-sm">변경 후 비밀번호</span> 
							<input type="password" class="form-control"
								aria-label="Sizing example input"
								aria-describedby="inputGroup-sizing-sm "
								id="changePwd">
						</div>

						<div class="input-group input-group-sm mb-3">
							<span class="input-group-text mr-1" id="inputGroup-sizing-sm">비밀번호 재확인</span> <input type="password" class="form-control"
								aria-label="Sizing example input"
								aria-describedby="inputGroup-sizing-sm"
								id="changeRepwd">
						</div>
					</div>
				</div>
			<br>

						<div class="d-grid gap-2 d-sm-flex justify-content-sm-center">
							<button type="button" class="btn btn-primary mr-2" id="saveBtn">저장</button>
							<button type="reset" class="btn btn-primary" id="resetBtn">다시작성</button>
						</div>
					</div>
				</div>	
			</div>
</form>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
$('#saveBtn').click(function(){
	if($('#pwd').val() != $('#dbPwd').val()){
		alert('비밀번호가 맞지 않습니다. 변경 전 비밀번호를 다시 확인해주세요.');
	}else if($('#changePwd').val() == ''){
		alert('변경할 비밀번호를 입력해주세요.');
	}else if($('#changePwd').val() != $('#changeRepwd').val()){
		alert('비밀번호가 일치하지 않습니다. 변경 할 비밀번호를 다시 확인해주세요.');
	}else{
		$.ajax({
			type: 'post',
			url: '/simri/section/changePwd',
			data: 'changePwd='+$('#changePwd').val(),
			success: function(data){
			},
			error: function(err){
				console.log(err);
			}
		});
		alert('변경 완료!');
		window.close();
		//return false;
	}
});

</script>
</body>
</html>