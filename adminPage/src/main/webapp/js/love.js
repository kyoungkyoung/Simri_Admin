$('#postWriteBtn').click(function(){
	//alert("릴");
	if($('#subject').val() == ''){
		alert("제목을 입력해주세요.");
	}else if($('#content').val() == ''){
		alert("내용을 입력해주세요.");
	}else if($('#testURL').val() == ''){
		alert("URL을 입력해주세요.");
	}else if($('#point').val() == ''){
		alert("포인트를 입력해주세요.");
	}else{
		var formData = new FormData($('#loveWriteForm')[0]); //form 안에 있는 모든 것을 넘겨라
		
		$.ajax({
			type: 'post',
			url: '/simri/post/loveWrite',
			enctype: 'multipart/form-data',
			processData: false,
			contentType: false,
			data: formData,
			success: function(data){
				alert("게시물 등록이 완료되었습니다.");
				
				location.href = "/simri/post/writeLove";
					
			},
			error: function(err){
				console.log(err);
			}
		});
	}
});