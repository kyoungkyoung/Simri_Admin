$(function(){
	if($('#DHL1').val()==='최신순'){
		$("#DHL").val("최신순").attr("selected", "selected");
	}else if($('#DHL1').val()==='조회수'){
		$("#DHL").val("조회수").attr("selected", "selected");
	}else if($('#DHL1').val()==='좋아요'){
		$("#DHL").val("좋아요").attr("selected", "selected");
	}
	
	$.ajax({
		type:'post',
		url: '/simri/post/getSimriPostList',
		data: {
			'DHL': $('#DHL').val(),
			'comCategory': $('#comCategory').val(),
			'pg': $('#pg').val()
		},
		dataType: 'json',
		success: function(data){
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
				  				href: '/simri/post/postView?seq='+items.seq,
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
			$('#postPagingDiv').html(data.postPaging2.pagingHTML);
		},
		error: function(err){
			console.log(err);
		}
	});
	
});

$(document).ready(function(){
	
	$('#DHL').change(function(){
		
		$('#postSearchText').val('');
		
		$.ajax({
			type:'post',
			url: '/simri/post/getSimriPostList',
			data: {
				'DHL': $('#DHL').val(),
				'comCategory': $('#comCategory').val(),
				'pg': $('#pg').val()
			},
			dataType: 'json',
			success: function(data){

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
					  				href: '/simri/post/postView?seq='+items.seq,
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
				$('#postPagingDiv').html(data.postPaging2.pagingHTML);
			},
			error: function(err){
				console.log(err);
			}
		});
		
	});//change
	$('#pg').val('1');
});





$('#postSearchBtn').click(function(event){
	$.ajax({
		type:'post',
		url: '/simri/post/postSearch',
		data: {
			'comCategory': $('#comCategory').val(),
			'pg': $('#pg').val(),
			'postSearchText': $('#postSearchText').val()
		},
		dataType: 'json',
		success: function(data){

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
				  				href: '/simri/post/postView?seq='+items.seq,
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

function checkAll(){
	var check = document.getElementsByName("check");
	
	if(document.getElementById("all").checked){
		for(var i=0; i<check.length; i++){
			check[i].checked = true;
		}
	}else if(!document.getElementById("all").checked){
		for(var i=0; i<check.length; i++){
			check[i].checked = false;
		}
	}
}
 
function checkSelectAll(checkbox)  {
	  const selectall 
	    = document.querySelector('input[id="all"]');
	  
	  
	  if(checkbox.checked === false)  {
	    selectall.checked = false;
	  }
	  
	}

$('#comDeleteBtn').click(function(){
	var check1 = document.getElementsByName("check");
	var count=0;
	var yn=0;
	var listSeq = new Array();
	
	for(var i=0; i<check1.length; i++){
		if(check1[i].checked == false){
			count++;
			
		}else if(check1[i].checked == true){
			
			var dataSeq = new Object();

			dataSeq.seq = check1[i].value;
			listSeq.push(dataSeq);
			
			
			yn++;
			
		}//else if
	}//for
	
	var jsonSeq = JSON.stringify(listSeq);
	
	if(count != 0 && yn == 0){
		alert('삭제할 글을 선택해주세요.');
	}else{
		if(confirm("정말 삭제하시겠습니까?")){
			$.ajax({
				type: 'post',
				url: '/simri/post/postDelete',
				data: 'seq='+jsonSeq,
				success: function(data){
					alert('삭제완료 〒▽〒');
					window.location.reload();
				},
				error: function(err){
					console.log(err);
				}
			});
		}
	}
	
});

//페이징
function postPaging2(pg, num){
	var DHL1;
	
	if(num == 1) {
		DHL1 = "최신순";
	 }else if( num == 2) {
		 DHL1="조회수";
	 }else if(num == 3) {
		 DHL1="좋아요";
	 }
		location.href = '/simri/post/writeManage?pg='+pg+'&DHL1='+DHL1;
}



function postPaging(pg){
	var postSearchText = document.getElementById('postSearchText').value;
		location.href= '/simri/post/writeManage?pg='+pg;
		$('#pg').val(pg);
		$('#postSearchText').val(postSearchText);
		$('#postSearchBtn').trigger('click');
}
//광고등록
$('#adBtn').click(function(){
	var check1 = document.getElementsByName("check");
	var count=0;
	var yn=0;
	var listSeq = new Array();
	
	for(var i=0; i<check1.length; i++){
		if(check1[i].checked == false){
			count++;
			
		}else if(check1[i].checked == true){
			
			var dataSeq = new Object();

			dataSeq.seq = check1[i].value;
			listSeq.push(dataSeq);
			
			
			yn++;
			
		}//else if
	}//for
	
	var jsonSeq = JSON.stringify(listSeq);
	
	if(count != 0 && yn == 0){
		alert('광고등록 게시물을  선택해주세요.');
	}else{
		if(confirm("정말 등록하시겠습니까?")){
			$.ajax({
				type: 'post',
				url: '/simri/advertise/addAd',
				data: 'seq='+jsonSeq,
				dataType: 'text',
				success: function(data){
					//alert(data);
					if(data == 'exist'){
						alert("이미 등록되어 있습니다.")
					}else{
						alert('등록완료');
						window.location.reload();
					}
				},
				error: function(err){
					console.log(err);
				}
			});
		}
	}
	
});
