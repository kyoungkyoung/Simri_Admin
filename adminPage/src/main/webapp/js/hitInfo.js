$(function(){
	$.ajax({
		type: 'post',
		url: '/simri/chart/getHitInfo',
		data: {
			'comCategory': $('#comCategory').val(),
			'condition': $('#condition').val()
		}
	});
});