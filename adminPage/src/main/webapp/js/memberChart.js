$(function(){
	
	$.ajax({
		type: 'post',
		url: '/simri/chart/getMemData',
		data: 'date='+$('#date').val(),
		dataType: 'json',
		success: function(data){
			
			var chartLabels = [];
			var memData = [];
			
			$.each(data.list, function(index, items){
				
				if(items.dtmonth==null){
					chartLabels.push(items.dt);
					memData.push(items.cnt);	
				}
				if(items.dt==null){
					chartLabels.push(items.dtmonth);
					memData.push(items.cnt);					
				}
				
				
			});
			createChart(chartLabels, memData);
		},
		error: function(err){
			console.log(err);
		}
	});
	
	$.ajax({
		type: 'post',
		url: '/simri/chart/getTestHit',
		dataType: 'json',
		success: function(data){	
			
			$('#testHitTable tr:gt(0)').remove()
			
			$.each(data.list, function(index, items){
			
				
				
				$('<tr/>').append($('<th/>',{
							scope: 'col',
							text: items.seq,
							style: 'text-align: center'
						})).append($('<td/>',{
							
							}).append($('<a/>',{
								text: items.subject,
								style: 'color: black;',
								href: '/simri/chart/postGraphDetail?seq='+items.seq
								
						}))).append($('<td/>',{
							text: items.hit,
							style: 'text-align: center;'
							
						})).appendTo($('#testHitTable'));
				
			});
		},
		error: function(err){
			console.log(err);
		}
	})
	
	$.ajax({
		type: 'post',
		url: '/simri/chart/getloveHit',
		dataType: 'json',
		success: function(data){
			
			$('#loveHitTable tr:gt(0)').remove()
			
			$.each(data.list, function(index, items){
				$('<tr/>').append($('<th/>',{
							scope: 'col',
							text: items.seq,
							style: 'text-align: center'
						})).append($('<td/>',{
							
							}).append($('<a/>',{
								text: items.subject,
								style: 'color: black;',
								href: '/simri/chart/postGraphDetail?seq='+items.seq
						}))).append($('<td/>',{
							text: items.hit,
							style: 'text-align: center;'
							
						})).appendTo($('#loveHitTable'));
				
			});
		},
		error: function(err){
			console.log(err);
		}
	});
	
});


$(document).ready(function(){
	
	$('#date').change(function(){
		
		$.ajax({
			type: 'post',
			url: '/simri/chart/getMemData',
			data: 'date='+$('#date').val(),
			dataType: 'json',
			success: function(data){
				
				var chartLabels = [];
				var memData = [];
				
				$.each(data.list, function(index, items){
					
					if(items.dtmonth==null){
						chartLabels.push(items.dt);
						memData.push(items.cnt);	
					}
					if(items.dt==null){
						chartLabels.push(items.dtmonth);
						memData.push(items.cnt);					
					}
					
					
				});
				createChart(chartLabels, memData);
			},
			error: function(err){
				console.log(err);
			}
		});
	});
});




function createChart(chartLabels, memData) {
	
	var lineChartData = {
			
			labels : chartLabels,
			
			datasets : [
				
				{
					
					label : "회원가입자 수",
					
					backgroundColor: 'transparent',
					borderColor: 'red',
					borderWidth: 3,
					pointBackgroundColor: 'red',
					
					data : memData
					
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