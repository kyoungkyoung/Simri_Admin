<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<input type="hidden" id="pg" value="${pg}">
<input type="hidden" id="comCategory1" value="${comCategory1}">
<input type="hidden" id="condition1" value="${condition1}">
<!-- 메인 화면 -->
<div class="p-2">
	<h3>
		댓글신고 관리
	</h3>
</div>
<h4 style="margin-bottom: 0;">
	<button type="button" id="singoDeleteBtn" class="btn btn-outline-danger float-right mb-1">삭제</button>
</h4>
	
<table class="table table-hover" id="adTable">
	<thead>
		<tr>
			<th scope="col" width="5%">
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="" id="all" onclick="checkAll(this)"> 
						<label class="form-check-label" for="flexCheckDefault"></label>
				</div>
			</th>
			<th scope="col" width="15%">이메일</th>
			<th scope="col" width="45%">내용</th>
			<th scope="col" width="10%">신고</th>
			<th scope="col" width="25%">신고날짜</th>
		</tr>
	</thead>


</table>

<!-- 페이징 -->
<nav aria-label="Page navigation example">
      <ul class="pagination justify-content-center my-4" id="replyPagingDiv">
      </ul>
</nav>


<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
$(function(){
	$.ajax({
		type: 'post',
		url: '/simri/community/singoReplyList',
		data: {
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
							value: items.replyseq,
							name: 'check',
							onclick: 'checkSelectAll(this)'
							
						})).append($('<label/>',{
							class: 'form-check-label',
							//text: items.replyseq
				})))).append($('<td/>',{
					text: items.email
				})).append($('<td/>',{
					text: items.replycomment
				})).append($('<td/>',{
					text: items.replysingo
				})).append($('<td/>',{
					text: items.replylogtime
				})).appendTo($('#adTable'))
			});
			$('#replyPagingDiv').html(data.replyPaging.pagingHTML);
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
				url: '/simri/community/replyDelete',
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

function replyPaging(pg){
	location.href = '/simri/community/singoReply?pg='+pg;
	$('#pg').val(pg);
}
		

</script>