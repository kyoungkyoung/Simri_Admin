<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<input type="hidden" id="pg" value="${pg}">
<input type="hidden" id="comCategory1" value="${comCategory1}">
<input type="hidden" id="condition1" value="${condition1}">
<!-- 메인 화면 -->
<div class="p-2">
	<h3>
		신고 게시물
	</h3>
</div>
<h4 style="margin-bottom: 0;">
		<div class="btn-group">
			<select class="btn btn-outline-danger dropdown-toggle mr-1" id="comCategory" aria-expanded="false" >
				<option value="[전체 게시글]팔레트">[전체 게시글]팔레트</option>		
				<option value="유머 게시판">유머 게시판</option>
				<option value="연애 게시판">연애 게시판</option>
				<option value="고민&상담 게시판">고민&상담 게시판</option>
			</select>
		</div>
	<button type="button" id="singoDeleteBtn" class="btn btn-outline-danger float-right mb-1">삭제</button>
</h4>
	
<table class="table table-hover" id="adTable">
	<thead>
		<tr>
			<th scope="col" width="11%">
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="" id="all" onclick="checkAll(this)"> 
						<label class="form-check-label" for="flexCheckDefault">글번호</label>
				</div>
			</th>
			<th scope="col" width="13%">카테고리</th>
			<th scope="col" width="33%">제목</th>
			<th scope="col" width="25%">신고</th>
			<th scope="col" width="20%">신고날짜</th>
		</tr>
	</thead>


</table>

<!-- 페이징 -->
<nav aria-label="Page navigation example">
      <ul class="pagination justify-content-center my-4" id="communityPagingDiv">
      </ul>
</nav>


<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
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
		type: 'post',
		url: '/simri/community/singoList',
		data: {
			'comCategory': $('#comCategory').val(),
			'pg': $('#pg').val()	
		},
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
					text: items.category
				})).append($('<td/>',{
					
					}).append($('<a/>',{
						style: 'text-decoration: none; color: black;',
						href: '/simri/community/communityView?seq='+items.seq,
						text: items.subject
						
				}))).append($('<td/>',{
					text: items.comSingo
				})).append($('<td/>',{
					text: items.comLogtime
				})).appendTo($('#adTable'))
			});
			$('#communityPagingDiv').html(data.communityPaging.pagingHTML);
		},
		error: function(err){
			console.log(err)
		}
	});
});

 $(document).ready(function(){
	 
	 $('#comCategory').change(function() {
		 
	 
	 
		$.ajax({
			type: 'post',
			url: '/simri/community/singoList',
			data: {
				'comCategory': $('#comCategory').val(),
				'pg': $('#pg').val()	
			},
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
						text: items.category
					})).append($('<td/>',{
						
						}).append($('<a/>',{
							style: 'text-decoration: none; color: black;',
							href: '/simri/community/communityView?seq='+items.seq,
							text: items.subject
							
					}))).append($('<td/>',{
						text: items.comSingo
					})).append($('<td/>',{
						text: items.comLogtime
					})).appendTo($('#adTable'))
				});
				$('#communityPagingDiv').html(data.communityPaging.pagingHTML);
			},
			error: function(err){
				console.log(err)
			}
		});
	});
	$('#pg').val('1');
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
$('#singoDeleteBtn').click(function(){
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

function communityPaging(pg, num){
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
	location.href = '/simri/community/singoCommunity?pg='+pg+'&comCategory1='+comCategory1;
}
		

</script>