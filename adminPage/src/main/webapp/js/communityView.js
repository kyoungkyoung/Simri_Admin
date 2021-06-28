$('#viewModify').click(function(){
	$.ajax({
		type: 'post',
		url: '/simri/community/viewModify',
		data: $('#viewModifyForm').serialize(),
		success: function(data){
			alert('수정되었습니다');
		},
		error: function(err){
			console.log(err);
		}
	});
});