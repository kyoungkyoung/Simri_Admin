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
<link href="/test/sidebar.css" rel="stylesheet">
<link href="/test/footer.css" rel="stylesheet">
</head>
<body>
	<!-- 메인 화면 -->
	<div class="container">
		<div class="row">
			<div class="col-xs-12" style="margin-top: 20px">

				<div class="row">
					<div class="col-xs-3 mr-4">
					
						<img class="rounded-circle ms-3 me-4"id="profileImg"style="width: 200px; height: 200px;"alt="profile" src="${SimriMemberDTO.profile}"/>
						<input type="hidden" name="profile_url">
					
					<%-- 	<svg class="bd-placeholder-img rounded-circle" width="180" height="180" xmlns="http://www.w3.org/2000/svg" role="img" value = "${SimriMemberDTO.profile}" aria-label="Placeholder: 140x140" preserveAspectRatio="xMidYMid slice" focusable="false">
							<title>Placeholder</title><rect width="100%" height="100%"fill="#777" />
							<text x="50%" y="50%" fill="#777" dy=".3em">140x140</text>
      							
        				</svg>
        			 --%>
        			
					</div>
					<!-- /.col-lg-4 -->

					<div class="col-xs-3 border-left my-5 ml-4 mr-4"></div>

					<div class="col-xs-6 ml-4 mt-4">
						<div class="input-group input-group-sm mb-3 ">
							<span class="input-group-text mr-1" id="inputGroup-sizing-sm">이
								름</span> <input type="text " value="${SimriMemberDTO.name }" class="form-control "
								aria-label="Sizing example input"
								aria-describedby="inputGroup-sizing-sm " readonly>
						</div>

						<div class="input-group input-group-sm mb-3">
							<span class="input-group-text mr-1" id="inputGroup-sizing-sm">이 메 일</span> 
							<input type="text" id="email" value="${SimriMemberDTO.email }" class="form-control"
								aria-label="Sizing example input"
								aria-describedby="inputGroup-sizing-sm " readonly>
						</div>

						<div class="input-group input-group-sm mb-3">
							<span class="input-group-text mr-1" id="inputGroup-sizing-sm">닉네임</span>
								<input type="text" class="form-control"
									value="${SimriMemberDTO.nickname }"
									aria-label="Sizing example input"
									aria-describedby="inputGroup-sizing-sm" readonly>
						</div>

					
					</div>
				</div>
				<!-- /.col-lg-4 -->



				<div class="row">
					<div class="col-xs-12">

						<div class="border-top my-3"></div>
						<div class="input-group input-group-sm mb-3 ">
							<span class="input-group-text mr-1" id="inputGroup-sizing-sm">소
								속</span> <input type="text " value="${SimriMemberDTO.palette }" class="form-control "
								aria-label="Sizing example input"
								aria-describedby="inputGroup-sizing-sm " readonly>
						</div>

						<div class="input-group input-group-sm mb-3">
							<span class="input-group-text mr-1" id="inputGroup-sizing-sm">가
								입 일</span> <input type="text" class="form-control"
								value="${SimriMemberDTO.signlogtime }"
								aria-label="Sizing example input"
								aria-describedby="inputGroup-sizing-sm" readonly>
						</div>

						<div class="input-group input-group-sm mb-3">
							<span class="input-group-text mr-1" id="inputGroup-sizing-sm">포
								인 트</span> <input type="text" class="form-control  mr-1"
								value="${SimriMemberDTO.point }"
								aria-label="Sizing example input"
								aria-describedby="inputGroup-sizing-sm" readonly> <span
								class="input-group-text mr-1" id="inputGroup-sizing-sm">포인트적립</span>
							<input type="text" class="form-control"
								id="point"
								aria-label="Sizing example input"
								aria-describedby="inputGroup-sizing-sm"> 
							<input type="button" value="적립" id="pointBtn">

						</div>

						<div class="input-group input-group-sm mb-3">
							<span class="input-group-text mr-1" id="inputGroup-sizing-sm">회원상태</span>
							<input type="text" class="form-control" value="${SimriMemberDTO.condition }"
								aria-label="Sizing example input"
								aria-describedby="inputGroup-sizing-sm" readonly>
						</div>
						
						<div class="input-group input-group-sm mb-3">
							<span class="input-group-text mr-1" id="inputGroup-sizing-sm">신고내용</span>
							<input type="text" class="form-control" value="${SimriMemberDTO.singoReason }"
								aria-label="Sizing example input"
								aria-describedby="inputGroup-sizing-sm" readonly>
						</div>
						<div class="input-group input-group-sm mb-3">
							<span class="input-group-text mr-1" id="inputGroup-sizing-sm">정지내용</span>
							<input type="text" class="form-control" value="${SimriMemberDTO.stopReason }"
								aria-label="Sizing example input"
								aria-describedby="inputGroup-sizing-sm" readonly>
						</div>


						<div class="d-grid gap-2 d-sm-flex justify-content-sm-center">
<!-- 							<button type="button" class="btn btn-primary mr-2">저장</button>-->
							<button type="button"  id="closeBtn" class="btn btn-primary">CLOSE</button>
						</div>
					</div>
				</div>



			</div>
		</div>
	</div>



<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="../js/memberView.js"></script>
</body>
</html>