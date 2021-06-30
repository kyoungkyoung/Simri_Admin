$(function(){
	$.ajax({
		type:'post',
		url: '/simri/post/getSimriPostList',
		data: {
			'comCategory': $('#category').val(),
			'pg': $('#pg').val()
		},
		dataType: 'json',
		success: function(data){
			alert(JSON.stringify(data));
			$('#simriPostList').empty();
			
			$.each(data.list, function(index, items){
				
				$('<li/>',{
					class : 'list-group-item mb-3'
				}).append($('<div/>',{
					  class: 'list-group-item list-group-item-action'
						  
				  		}).append($('<div/>',{
				  			class: 'd-flex w-100'
				  				
				  			}).append($('<input/>',{
				  				class: 'form-check-in mr-3 mt-2', 
				  				type: 'checkbox',
			  					name: 'check',
								value: items.seq,
								onclick: 'checkSelectAll(this)'
				  			})).append($('<a/>',{
				  				href: '#',//'/simri/community/communityView?seq='+items.seq,
				  				class: 'mb-1 flex-fill',
				  				style: 'text-decoration: none; color: black;'
					  			}).append($('<h5/>',{
					  				text: '['+items.seq+'] '+items.subject,
					  				style: 'color: black;',
					  				id: 'comSeq'
				  			}))).append($('<small/>',{
				  				class: 'text-muted',
				  				text: items.comLogtime
				  				
				  		}))).append($('<small/>',{
				  			class: 'text-muted ml-4',
				  			text: '['+items.point+']'
				  			
				  		})).append($('<div/>',{
				  			class: 'd-flex w-100 justify-content-end'
				  			}).append($('<button/>',{
				  				type: 'button', 
				  				class: 'btn btn-outline-secondary float-right mr-1 chartBtn'+items.seq,
				  				text: '통계'
				  			})))).appendTo('#simriPostList');	
				$('.chartBtn'+items.seq).click(function(){
					location.href="/simri/chart/postGraphDetail?seq="+items.seq;
				});
				
			});
			$('#postPagingDiv').html(data.postPaging.pagingHTML);
		},
		error: function(err){
			console.log(err);
		}
	});
	$('#pg').val('1');
});

$('#postSearchBtn').click(function(event){
	
	$.ajax({
		type:'post',
		url: '/simri/post/postSearch',
		data: {
			'comCategory': $('#category').val(),
			'pg': $('#pg').val(),
			'postSearchText': $('#postSearchText').val()
		},
		dataType: 'json',
		success: function(data){
			alert(JSON.stringify(data));
			$('#simriPostList').empty();
			
			$.each(data.list, function(index, items){
				
				$('<li/>',{
					class : 'list-group-item mb-3'
				}).append($('<div/>',{
					  class: 'list-group-item list-group-item-action'
						  
				  		}).append($('<div/>',{
				  			class: 'd-flex w-100'
				  				
				  			}).append($('<input/>',{
				  				class: 'form-check-in mr-3 mt-2', 
				  				type: 'checkbox',
			  					name: 'check',
								value: items.seq,
								onclick: 'checkSelectAll(this)'
				  			})).append($('<a/>',{
				  				href: '#',//'/simri/community/communityView?seq='+items.seq,
				  				class: 'mb-1 flex-fill',
				  				style: 'text-decoration: none; color: black;'
					  			}).append($('<h5/>',{
					  				text: '['+items.seq+'] '+items.subject,
					  				style: 'color: black;',
					  				id: 'comSeq'
				  			}))).append($('<small/>',{
				  				class: 'text-muted',
				  				text: items.comLogtime
				  				
				  		}))).append($('<small/>',{
				  			class: 'text-muted ml-4',
				  			text: '['+items.point+']'
				  			
				  		})).append($('<div/>',{
				  			class: 'd-flex w-100 justify-content-end'
				  			}).append($('<button/>',{
				  				type: 'button', 
				  				class: 'btn btn-outline-secondary float-right mr-1 chartBtn'+items.seq,
				  				text: '통계'
				  			})))).appendTo('#simriPostList');	
				$('.chartBtn'+items.seq).click(function(){
					location.href="/simri/chart/postGraphDetail?seq="+items.seq;
				});
				
			});
			$('#postPagingDiv').html(data.postPaging.pagingHTML);
		},
		error: function(err){
			console.log(err);
		}
	});
	$('#pg').val('1');
});

function postPaging(pg){
	var postSearchText = document.getElementById('postSearchText').value;
	alert(postSearchText);
	
	if(postSearchText == ''){
		alert("오니");
		location.href= '/simri/post/writeManage?pg='+pg;
	}else{
		$('#pg').val(pg);
		$('#postSearchBtn').trigger('click');
		$('#postSearchText').val(postSearchText);
		
	}
	

}
