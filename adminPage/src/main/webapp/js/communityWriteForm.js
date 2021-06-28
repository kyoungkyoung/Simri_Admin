// 공지사항 등록Btn

$('#noticeBtn').click(function(){
	
	
	if($('#subject').val() == '[공지사항]') {
		alert("제목 입력");
		
	}else if($('#content').val() == '') {
		alert("내용 입력");
		
	}else{
		
		//2. AJax 통신
		var formData = new FormData($('#communityWriteForm')[0]); //form 안에 있는 모든 것을 넘겨라
		$.ajax({
			type: 'post',
			url: '/simri/community/noticeWrite',
			enctype: 'multipart/form-data',
			processData: false,
			contentType: false,
			data: formData,
			success: function(data){
				alert("공지사항 등록 완료되었습니다.");
				location.href = 'simri/community/community?pg=1&comCategory1=공지사항';
			},
			error: function(err){
				console.log(err);
			}
		});
		
	}
	
});
