//default : 일간
$(function(){
	if($('#comCategory1').val() === 'comCategoryAll'){
		$('#comCategory').val('comCategoryAll').attr("selected", "selected");
	}else if($('#comCategory1').val() === '심리테스트'){
		$('#comCategory').val('심리테스트').attr("selected", "selected");
	}else if($('#comCategory1').val() === '연애심리글'){
		$('#comCategory').val('연애심리글').attr("selected", "selected");
	}
	
	if($('#condition1').val() === 'seq'){
		$('#condition').val('seq').attr("selected", "selected");
	}else if($('#condition1').val() === 'hit'){
		$('#condition').val('hit').attr("selected", "selected");
	}else if($('#condition1').val() === 'comlike'){
		$('#condition').val('comlike').attr("selected", "selected");
	}
	
	$.ajax({
		type: 'post',
		url: '/simri/chart/getHitInfoDay',
		data: {
			'comCategory': $('#comCategory').val(),
			'condition': $('#condition').val(),
			'date' :'month',
			'pg': $('#pg').val()
		},
		dataType: 'json',
		success: function(data){
			
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
						href: "javascript:void(0)",
						onclick: 'goView('+items.seq+'); return false;',
						text: items.subject,
						id: 'hitInfo'
						
				}))).append($('<td/>',{
					text: items.hit
					
				})).append($('<td/>',{
					text: items.comLike
					
				})).append($('<td/>',{
					text: items.comLogtime
					
				})).appendTo('#hitInfoTable');
			});
			
			$('#hitInfoPagingDiv').html(data.chartPaging.pagingHTML);
			
		},
		error: function(err){
			console.log(err);
		}
	});
	
});


$('#day').click(function(event){
	$.ajax({
		type: 'post',
		url: '/simri/chart/getHitInfoDay',
		data: {
			'comCategory': $('#comCategory').val(),
			'condition': $('#condition').val(),
			'date' : 'day',
			'pg': $('#pg').val()
		},
		dataType: 'json',
		success: function(data){
			
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
						href: "javascript:void(0)",
						onclick: 'goView('+items.seq+'); return false;',
						text: items.subject,
						
						
				}))).append($('<td/>',{
					text: items.hit
					
				})).append($('<td/>',{
					text: items.comLike
					
				})).append($('<td/>',{
					text: items.comLogtime
					
				})).appendTo('#hitInfoTable');
				
			});
			
			$('#hitInfoPagingDiv').html(data.chartPaging.pagingHTML);
			
		},
		error: function(err){
			console.log(err);
		}
	});
	$('#pg').val('1');
});



$('#week').click(function(event){
	
	$.ajax({
		type: 'post',
		url: '/simri/chart/getHitInfoDay',
		data: {
			'comCategory': $('#comCategory').val(),
			'condition': $('#condition').val(),
			'date' : 'week',
			'pg': $('#pg').val()
		},
		dataType: 'json',
		success: function(data){
			
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
						href: "javascript:void(0)",
						onclick: 'goView('+items.seq+'); return false;',
						text: items.subject
						
				}))).append($('<td/>',{
					text: items.hit
					
				})).append($('<td/>',{
					text: items.comLike
					
				})).append($('<td/>',{
					text: items.comLogtime
					
				})).appendTo('#hitInfoTable');
				
			});
			
			$('#hitInfoPagingDiv').html(data.chartPaging.pagingHTML);
			
		},
		error: function(err){
			console.log(err);
		}
	});
	$('#pg').val('1');
});


$('#month').click(function(event){
	
	$.ajax({
		type: 'post',
		url: '/simri/chart/getHitInfoDay',
		data: {
			'comCategory': $('#comCategory').val(),
			'condition': $('#condition').val(),
			'date' :'month',
			'pg': $('#pg').val()
		},
		dataType: 'json',
		success: function(data){
			
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
						href: "javascript:void(0)",
						onclick: 'goView('+items.seq+'); return false;',
						text: items.subject,
						id: 'hitInfo'
						
				}))).append($('<td/>',{
					text: items.hit
					
				})).append($('<td/>',{
					text: items.comLike
					
				})).append($('<td/>',{
					text: items.comLogtime
					
				})).appendTo('#hitInfoTable');
			});
			
			$('#hitInfoPagingDiv').html(data.chartPaging.pagingHTML);
			
		},
		error: function(err){
			console.log(err);
		}
	});
	$('#pg').val('1');
});

function goView(seq){
	location.href="/simri/post/postView?seq="+seq;
	return false;
}

function chartPaging(pg, comCategoryNum, conditionNum, dateNum){
	var comCategory1;
	var condition1;
	
	$('#pg').val(pg);
	
	if(comCategoryNum == 1){
		comCategory1 = "comCategoryAll";
		$('#comCategory').val('comCategoryAll').attr("selected", "selected");
	}else if(comCategoryNum == 2){
		comCategory1 = "심리테스트";
		$('#comCategory').val('심리테스트').attr("selected", "selected");
	}else if(comCategoryNum == 3){
		comCategory1 = "연애심리글";
		$('#comCategory').val('연애심리글').attr("selected", "selected");
	}
	
	if(conditionNum == 1){
		condition1 = "seq";
		$('#condition').val('seq').attr("selected", "selected");
	}else if(conditionNum == 2){
		condition1 = "hit";
		$('#condition').val('hit').attr("selected", "selected");
	}else if(conditionNum == 3){
		condition1 = "comlike";
		$('#condition').val('comlike').attr("selected", "selected");
	}
	
	if(dateNum == 1){
		$('#date').trigger('click');
	}else if(dateNum == 2){
		$('#week').trigger('click');
	}else if(dateNum == 3){
		$('#month').trigger('click');
	}
}
