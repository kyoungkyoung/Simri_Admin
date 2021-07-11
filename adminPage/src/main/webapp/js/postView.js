$('#viewModify').click(function(){
	
	if($('#subject').val() == '') {
		alert("제목 입력");
		
	}else if($('#content').val() == '') {
		alert("내용 입력");
	}else{
		//2. AJax 통신
		var formData = new FormData($('#viewModifyForm')[0]); //form 안에 있는 모든 것을 넘겨라
		$.ajax({
			type: 'post',
			url: '/simri/post/viewModify',
			enctype: 'multipart/form-data',
			processData: false,
			contentType: false,
			data: formData,
			success: function(data){
				alert("수정완료");
				location.href = '/simri/post/writeManage?pg=1';
			},
			error: function(err){
				console.log(err);
			}
		});
	}
	
});

$('#resetBtn').click(function(){
	location.reload();
});
