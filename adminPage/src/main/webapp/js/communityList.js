$(function(){   
	if($('#comCategory1').val()==='전체게시글팔레트'){
		$("#comCategory").val("[전체 게시글]팔레트").attr("selected", "selected");
	}else if($('#comCategory1').val()==='팔레트빨강'){
		$("#comCategory").val("[팔레트]빨강").attr("selected", "selected");

	}else if($('#comCategory1').val()==='팔레트파랑'){
		$("#comCategory").val("[팔레트]파랑").attr("selected", "selected");

	}else if($('#comCategory1').val()==='팔레트초록'){
		$("#comCategory").val("[팔레트]초록").attr("selected", "selected");

	}else if($('#comCategory1').val()==='팔레트노랑'){
		$("#comCategory").val("[팔레트]노랑").attr("selected", "selected");
		
	}else if($('#comCategory1').val()==='유머게시판'){
		$("#comCategory").val("유머 게시판").attr("selected", "selected");
		
	}else if($('#comCategory1').val()==='연애게시판'){
		$("#comCategory").val("연애 게시판").attr("selected", "selected");
	}else if($('#comCategory1').val()==='고민상담게시판'){
		$("#comCategory").val("고민&상담 게시판").attr("selected", "selected");
		
	}else if($('#comCategory1').val()==='공지사항'){
		$("#comCategory").val("[공지사항]").attr("selected", "selected");
	}
	
	$.ajax({
		type:'post',
		url: '/simri/community/getCommunity',
		data: {
			'comCategory': $('#comCategory').val(),
			'pg': $('#pg').val()
		},
		dataType: 'json',
		success: function(data){
			$('#communityListTable').empty();
			
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
				  				href: '#',
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
				  			text: '['+items.nickname+']'
				  			
				  		})).append($('<div/>',{
				  			class: 'd-flex w-100 justify-content-end'
				  			}).append($('<button/>',{
				  				type: 'button', 
				  				class: 'btn btn-outline-secondary float-right mr-1 chartBtn'+items.seq,
				  				text: '통계'
				  			})))).appendTo('#communityListTable');	
				$('.chartBtn'+items.seq).click(function(){
					location.href="/simri/chart/postGraphDetail?seq="+items.seq;
				});
				
			});//each
			
			$('#communityPagingDiv').html(data.communityPaging.pagingHTML);
		},
		error: function(err){
			console.log(err);
		}
	});
	

});

$(document).ready(function(){

	$('#comCategory').change(function() {
		
		$.ajax({
			type:'post',
			url: '/simri/community/getCommunity',
			data: {
				'comCategory': $('#comCategory').val(),
				'pg': $('#pg').val()
			},
			dataType: 'json',
			success: function(data){
				$('#communityListTable').empty();
				
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
					  				href: '#',
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
					  			text: '['+items.nickname+']'
					  			
					  		})).append($('<div/>',{
					  			class: 'd-flex w-100 justify-content-end'
					  			}).append($('<button/>',{
					  				type: 'button', 
					  				class: 'btn btn-outline-secondary float-right mr-1 chartBtn'+items.seq,
					  				text: '통계'
					  			})))).appendTo('#communityListTable');	
					
					$('.chartBtn'+items.seq).click(function(){
						location.href="/simri/chart/postGraphDetail?seq="+items.seq;
					});
					
				});//each
				$('#communityPagingDiv').html(data.communityPaging.pagingHTML);
			},
			error: function(err){
				console.log(err);
			}
		});
		
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
	alert("클릭됨");
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
				url: '/simri/community/communityDelete',
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

//공지사항 등록Btn

$('#noticeBtn').click(function(){
	if($('#subject').val() == '[공지사항]') {
		alert("제목 입력");
		
	}else if($('#content').val() == '') {
		alert("내용 입력");
		
	}else{
		
		//2. AJax 통신
		var formData = new FormData($('#communityWriteForm')[0]); //form 안에 있는 모든 것을 넘겨라
		$.ajax({
			type: 'post',
			url: '/simri/community/noticeWrite',
			enctype: 'multipart/form-data',
			processData: false,
			contentType: false,
			data: formData,
			success: function(data){
				alert("공지사항 등록 완료되었습니다.");
				location.href = '/simri/community/community?pg=1&comCategory1=공지사항';
			},
			error: function(err){
				console.log(err);
			}
		});
		
	}
	
});






//페이징
function communityPaging(pg, num){
	//var searchText = document.getElementById('searchText').value;
	var comCategory1;
	
	if(num == 1) {
		comCategory1="전체게시글팔레트"
	 }else if( num == 2) {
		 comCategory1="팔레트빨강";
	 }else if(num == 3) {
		 comCategory1="팔레트파랑";
	 }else if( num == 4) {
		 comCategory1="팔레트초록";
	 }else if(num == 5) {
		 comCategory1="팔레트노랑";
	 }else if( num == 6) {
		 comCategory1="유머게시판";
	 }else if(num == 7) {
		 comCategory1="연애게시판";
	 }else if( num == 8) {
		 comCategory1="고민상담게시판";
	 }else if( num == 9) {
		 comCategory1="공지사항";
	 }
	
	
	
	//if(searchText==''){
		//$('#pg').val(pg);  $('input[name=이름명]').attr("속성명","값");
		location.href = '/simri/community/community?pg='+pg+'&comCategory1='+comCategory1;
		
		
	//}
	//else{
		//$('#pg').val(pg);
		//$('#searchBtn').trigger('click', 'search');
	//}
	 
}
















