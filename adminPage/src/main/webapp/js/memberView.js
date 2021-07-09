
$('#pointBtn').click(function(){
	$.ajax({
		type: 'post',
		url: '/simri/member/setPoint',
		data: { 'point': $('#point').val(),
				'email': $('#email').val()},
		success: function(data){
			alert('적립완료');
			window.location.reload();
		},
		error: function(err){
			console.log(err);
		}
	});
});

$('#closeBtn').click(function(){
	opener.document.location.reload();
	window.close();
});