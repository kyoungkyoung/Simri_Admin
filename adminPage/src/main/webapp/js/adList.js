$(function(){
	$.ajax({
		type: 'post',
		url: '/simri/advertise/getAdList',
		data: 'pg='+$('#pg').val(),
		dataType: 'json',
		success: function(data){
			
			$('#adTable tr:gt(0)').remove();
			
			$.each(data.list, function(index, items){
				$('<tr/>',{
					
				}).append($('<th/>',{
						scope: 'row'
					}).append($('<div/>',{
							class: 'form-check'
						}).append($('<input/>',{
							class: 'form-check-input',
							type: 'checkbox',
							value: items.seq,
							name: 'check',
							onclick: 'checkSelectAll(this)'
							
						})).append($('<label/>',{
							class: 'form-check-label',
							text: items.seq
				})))).append($('<td/>',{
					text: items.point
				})).append($('<td/>',{
					text: items.category
				})).append($('<td/>',{
					text: items.subject
				})).append($('<td/>',{
					text: items.image
				})).append($('<td/>',{
					text: items.cflogtime
				})).appendTo($('#adTable'))
			});
			$('#advertisePagingDiv').html(data.advertisePaging.pagingHTML);
		},
		error: function(err){
			console.log(err)
		}
	});
});

//----체크박스---
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

//-----삭제----
$('#adDeleteBtn').click(function(){
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
	
	if(count == 0 && yn == 0){
		alert('삭제할 글을 선택해주세요.');
	}else if(count != 0 && yn == 0){
		alert('삭제할 글을 선택해주세요.');
	}else{
		if(confirm("정말 삭제하시겠습니까?")){
			$.ajax({
				type: 'post',
				url: '/simri/advertise/adDelete',
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

function adPaging(pg){
		location.href= '/simri/advertise/advertiseList?pg='+pg;
		$('#pg').val(pg);
}