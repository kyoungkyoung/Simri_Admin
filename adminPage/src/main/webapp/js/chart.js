//마지막에 할 것 - 제일 처음에 창이 뜨면 trigger이용해서 현재 날짜에 해당하는 통계 data 뿌려주기
$(function(){
	$('#dateBtn').trigger('click');
});

$('#dateBtn').click(function(event){
	var chartLabels = [];
	var hitData = [];
	var likeData = [];
	var shareData = [];
	
	$.ajax({
		type:'get',
		url: '/simri/chart/getDate',
		data: { 'seq' : $('#seq').val(),
			'date' : $('#date').val()
			},
		dataType:'json',
		success: function(data){
			
			$.each(data.list, function(index, items){
				
				chartLabels.push(items.etcLogtime);
				hitData.push(items.hitHit);
				likeData.push(items.likeLike);
				shareData.push(items.shareShare);
			});
			createChart(chartLabels, hitData, likeData, shareData);
			
		},
		error: function(err){
			console.log(err);
		}
	});
});


$('input[name="datefilter"]').daterangepicker({
    locale: {
         format: 'YY/MM/DD'
       }
}); 

	function createChart(chartLabels, hitData, likeData, shareData) {
		
		var lineChartData = {
				
				labels : chartLabels,
				
				datasets : [
					
					{
						
						label : "Hit Data",
						
						backgroundColor: 'transparent',
						borderColor: 'red',
						borderWidth: 3,
						pointBackgroundColor: 'red',
						
						data : hitData
						
					},
					
					{
						
						label : "Like Data",
						
						backgroundColor: 'transparent',
						borderColor: 'blue',
						borderWidth: 3,
						pointBackgroundColor: 'blue',
						
						data : likeData
						
					},
					
					{
						
						label : "Share Data",
						
						backgroundColor: 'transparent',
						borderColor: 'yellow',
						borderWidth: 3,
						pointBackgroundColor: 'yellow',
						
						data : shareData
						
					}
					]
		
		}

		var ctx = document.getElementById("myChart").getContext("2d");

		LineChartDemo = Chart.Line(ctx, {

			data : lineChartData,

			options : {

				scales : {

					yAxes : [ {

						ticks : {

							beginAtZero : true

						}

					} ]

				}

			}
		})
	}

