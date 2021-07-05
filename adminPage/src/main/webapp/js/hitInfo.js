$(function(){
//default : 일간
	
	$.ajax({
		type: 'post',
		url: '/simri/chart/getHitInfoDay',
		data: {
			'comCategory': $('#comCategory').val(),
			'condition': $('#condition').val(),
			'date' : 'day'
		},
		dataType: 'json',
		success: function(data){
			alert(JSON.stringify(data));
			
			$('#hitInfoTable tr:gt(0)').remove();

			$.each(data.list, function(index, items){
				
				$('<tr/>',{
					//style: 'cursor: pointer;'
						
					}).append($('<th/>',{
						scope: 'row'
							
						}).append($('<div/>',{
							class: 'form-check'
								
							}).append($('<label/>',{
								class: 'form-check-label',
								for: 'flexCheckDefault',
								text: items.seq
								
				})))).append($('<td/>',{
					text: items.category
					
				})).append($('<td/>',{
					
					}).append($('<a/>',{
						style: 'text-decoration: none; color: black;',
						//href: '/simri/post/postView?seq='+items.seq,
						text: items.subject
						
				}))).append($('<td/>',{
					text: items.hit
					
				})).append($('<td/>',{
					text: items.comLike
					
				})).append($('<td/>',{
					text: items.comLogtime
					
				})).appendTo('#hitInfoTable');
				
			});
		},
		error: function(err){
			console.log(err);
		}
	});
});


$('#day').click(function(){
	$.ajax({
		type: 'post',
		url: '/simri/chart/getHitInfoDay',
		data: {
			'comCategory': $('#comCategory').val(),
			'condition': $('#condition').val(),
			'date' : 'day'
		},
		dataType: 'json',
		success: function(data){
			//alert(JSON.stringify(data));
			
			$('#hitInfoTable tr:gt(0)').remove();
			
			$.each(data.list, function(index, items){
				
				$('<tr/>',{
					//style: 'cursor: pointer;'
						
					}).append($('<th/>',{
						scope: 'row'
							
						}).append($('<div/>',{
							class: 'form-check'
								
							}).append($('<label/>',{
								class: 'form-check-label',
								for: 'flexCheckDefault',
								text: items.seq
								
				})))).append($('<td/>',{
					text: items.category
					
				})).append($('<td/>',{
					
					}).append($('<a/>',{
						style: 'text-decoration: none; color: black;',
						//href: '/simri/post/postView?seq='+items.seq,
						text: items.subject
						
				}))).append($('<td/>',{
					text: items.hit
					
				})).append($('<td/>',{
					text: items.comLike
					
				})).append($('<td/>',{
					text: items.comLogtime
					
				})).appendTo('#hitInfoTable');
				
			});
		},
		error: function(err){
			console.log(err);
		}
	});
});



$('#week').click(function(){
	
	$.ajax({
		type: 'post',
		url: '/simri/chart/getHitInfoDay',
		data: {
			'comCategory': $('#comCategory').val(),
			'condition': $('#condition').val(),
			'date' : 'week'
		},
		dataType: 'json',
		success: function(data){
			//alert(JSON.stringify(data));
			
			$('#hitInfoTable tr:gt(0)').remove();
			
			$.each(data.list, function(index, items){
				
				$('<tr/>',{
					//style: 'cursor: pointer;'
					
					}).append($('<th/>',{
						scope: 'row'
							
						}).append($('<div/>',{
							class: 'form-check'
								
							}).append($('<label/>',{
								class: 'form-check-label',
								for: 'flexCheckDefault',
								text: items.seq
								
				})))).append($('<td/>',{
					text: items.category
					
				})).append($('<td/>',{
					
					}).append($('<a/>',{
						style: 'text-decoration: none; color: black;',
						//href: '/simri/post/postView?seq='+items.seq,
						text: items.subject
						
				}))).append($('<td/>',{
					text: items.hit
					
				})).append($('<td/>',{
					text: items.comLike
					
				})).append($('<td/>',{
					text: items.comLogtime
					
				})).appendTo('#hitInfoTable');
				
			});
		},
		error: function(err){
			console.log(err);
		}
	});
});


$('#month').click(function(){
	
	$.ajax({
		type: 'post',
		url: '/simri/chart/getHitInfoDay',
		data: {
			'comCategory': $('#comCategory').val(),
			'condition': $('#condition').val(),
			'date' :'month'
		},
		dataType: 'json',
		success: function(data){
			//alert(JSON.stringify(data));
			
			$('#hitInfoTable tr:gt(0)').remove();
			
			$.each(data.list, function(index, items){
				
				$('<tr/>',{
					//style: 'cursor: pointer;',
					
					}).append($('<th/>',{
						scope: 'row'
							
						}).append($('<div/>',{
							class: 'form-check'
								
							}).append($('<label/>',{
								class: 'form-check-label',
								for: 'flexCheckDefault',
								text: items.seq
								
				})))).append($('<td/>',{
					text: items.category
					
				})).append($('<td/>',{
					
					}).append($('<a/>',{
						style: 'text-decoration: none; color: black;',
						//href: '/simri/post/postView?seq='+items.seq,
						text: items.subject,
						id: 'hitInfo'
						
				}))).append($('<td/>',{
					text: items.hit
					
				})).append($('<td/>',{
					text: items.comLike
					
				})).append($('<td/>',{
					text: items.comLogtime
					
				})).appendTo('#hitInfoTable');
				
				$('#hitInfo').click(function(){
					window.open('/simri/post/postView?seq='+items.seq, 'ss', 'width=640 height=540 left=800 top=200 scrollbars=yes');
				});
				
			});
		},
		error: function(err){
			console.log(err);
		}
	});
});


