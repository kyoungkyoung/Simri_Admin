//리스트 부르기----------------------------------------------------------------------------------------------
$(function(){
	if($('#btnId').val() === 'warning'){
		$('#warning-tab').addClass('active');
		$('#general-tab').removeClass('active');
		$('#stop-tab').removeClass('active');
		
		$('#general').removeClass('show active');
		$('#warning').addClass('show active');
		$('#stop').removeClass('show active');
		
	}else if($('#btnId').val() === 'stop'){
		$('#stop-tab').addClass('active');
		$('#general-tab').removeClass('active');
		$('#warning-tab').removeClass('active');
		
		$('#general').removeClass('show active');
		$('#warning').removeClass('show active');
		$('#stop').addClass('show active');
	}
	
	var buttonId = $('.active').attr('id');
	
	if(buttonId == 'general-tab'){
		$('#general-tab').trigger('click')
	}else if(buttonId == 'warning-tab'){
		$('#warning-tab').trigger('click');
	}else if(buttonId == 'stop-tab'){
		$('#stop-tab').trigger('click');
	}
});

$('#general-tab').click(function(){
	$('#general-tab').addClass('active');
	$('#warning-tab').removeClass('active');
	$('#stop-tab').removeClass('active');
	
	$('#searchText').val('');
	$.ajax({
		type:'post',
		url:'/simri/member/getMemberList',
		data:'pg='+$('#pg').val(),
		dataType:'json',
		success: function(data){
			
			$('#memberListTable tr:gt(0)').remove();
			
			$.each(data.list, function(index, items){
				
			$('<tr/>').append($('<th/>',{
							scope: 'row'
							}).append($('<div/>',{
								class: 'form-check'
								}).append($('<input/>',{
									class: 'form-check-input',
									type: 'checkbox',
									name: 'check',
									value: items.email,
									onclick: 'checkSelectAll(this)'
							})))
						).append($('<td/>',{
							text: items.name
							
						})).append($('<td/>',{
							text: items.email,
							id: 'memberInfo',
							style: 'cursor: pointer'
						})).append($('<td/>',{
						text: items.palette
							
						})).append($('<td/>',{
							text: items.point
							
						})).append($('<td/>',{
							text: items.memsingo
							
						})).append($('<td/>',{
							text: items.condition
							
						})).append($('<td/>',{
							text: items.signlogtime
							
						})).appendTo($('#memberListTable'));
			});//each
			
			//페이징 처리
			
			$('#memberPagingDiv').html(data.memberPaging.pagingHTML);
			
			
			$(document).on('click', '#memberInfo', function(){
				
				window.open('/simri/member/memberView?email='+$(this).text(), 'ss', 'width=640 height=540 left=800 top=200 scrollbars=yes');
				  
				
			});
			
		},
		error: function(err){
			console.log(err);
		}
	});
	
	$('#pg').val('1');
	
	
});




$('#warning-tab').click(function(){
	$('#warning-tab').addClass('active');
	$('#general-tab').removeClass('active');
	$('#stop-tab').removeClass('active');
	$('#searchText').val('');
	
	$.ajax({
		type:'post',
		url:'/simri/member/getMemberWarningList',
		data:'pg='+$('#pg').val(),
		dataType:'json',
		success: function(data){
			$('#memberWarningListTable tr:gt(0)').remove();
			
			$.each(data.list, function(index, items){
				$('<tr/>').append($('<th/>',{
							scope: 'row'
							}).append($('<div/>',{
								class: 'form-check'
								}).append($('<input/>',{
									class: 'form-check-input',
									type: 'checkbox',
									name: 'checkWarning',
									value: items.email,
									onclick: 'checkSelectAllWarning(this)'
							})))
						).append($('<td/>',{
							text: items.name,
							
						})).append($('<td/>',{
							text: items.email,
							id: 'memberInfo',
							style: 'cursor: pointer'
						})).append($('<td/>',{
						text: items.palette
							
						})).append($('<td/>',{
							text: items.point
							
						})).append($('<td/>',{
							text: items.memsingo
							
						})).append($('<td/>',{
							text: items.singoReason
							
						})).append($('<td/>',{
							text: items.condition
							
						})).appendTo($('#memberWarningListTable'));
			});//each
			
			//페이징 처리
			$('#memberWarningPagingDiv').html(data.memberWarningPaging.pagingHTML);
			
			$(document).on('click', '#memberInfo', function(){
				window.open('/simri/member/memberView?email='+$(this).text(), 'ss', 'width=640 height=540 left=800 top=200 scrollbars=yes');
				  
				
			});
		},
		error: function(err){
			console.log(err);
		}
	});
	$('#pg').val('1');
});


$('#stop-tab').click(function(){
	$('#stop-tab').addClass('active');
	$('#general-tab').removeClass('active');
	$('#warning-tab').removeClass('active');
	$('#searchText').val('');
	
	$.ajax({
		type:'post',
		url:'/simri/member/getMemberStopList',
		data:'pg='+$('#pg').val(),
		dataType:'json',
		success: function(data){
			$('#memberStopListTable tr:gt(0)').remove();
			$.each(data.list, function(index, items){
				
				$('<tr/>').append($('<th/>',{
							scope: 'row'
							}).append($('<div/>',{
								class: 'form-check'
								}).append($('<input/>',{
									class: 'form-check-input',
									type: 'checkbox',
									name: 'checkStop',
									value: items.email,
									onclick: 'checkSelectAllStop(this)'
							})))
						).append($('<td/>',{
							text: items.name,
							
						})).append($('<td/>',{
							text: items.email,
							id: 'memberInfo',
							style: 'cursor: pointer'
						})).append($('<td/>',{
						text: items.palette
							
						})).append($('<td/>',{
							text: items.point
							
						})).append($('<td/>',{
							text: items.stopPeriod
							
						})).append($('<td/>',{
							text: items.stopReason
							
						})).append($('<td/>',{
							text: items.condition
							
						})).append($('<td/>',{
							text: items.singologtime
							
						})).appendTo($('#memberStopListTable'));
			});//each
			
			//페이징 처리
			$('#memberStopPagingDiv').html(data.memberStopPaging.pagingHTML);
			
			$(document).on('click', '#memberInfo', function(){
				window.open('/simri/member/memberView?email='+$(this).text(), 'ss', 'width=640 height=540 left=800 top=200 scrollbars=yes');
				  
				
			});
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



function checkAllWarning(){
	var check2 = document.getElementsByName("checkWarning");
	
	if(document.getElementById("allWarning").checked){
		for(var i=0; i<check2.length; i++){
			check2[i].checked = true;
		}
	}else if(!document.getElementById("allWarning").checked){
		for(var i=0; i<check2.length; i++){
			check2[i].checked = false;
		}
	}
}
 
function checkSelectAllWarning(checkbox)  {
	  const selectall2 
	    = document.querySelector('input[id="allWarning"]');
	  
	  if(checkbox.checked === false)  {
	    selectall2.checked = false;
	  }
	}

function checkAllStop(){
	var check3 = document.getElementsByName("checkStop");
	
	if(document.getElementById("allStop").checked){
		for(var i=0; i<check3.length; i++){
			check3[i].checked = true;
		}
	}else if(!document.getElementById("allStop").checked){
		for(var i=0; i<check3.length; i++){
			check3[i].checked = false;
		}
	}
}
function checkSelectAllStop(checkbox)  {
	  const selectall3 
	    = document.querySelector('input[id="allStop"]');
	  
	  if(checkbox.checked === false)  {
	    selectall3.checked = false;
	  }
	}

//활동 정지 버튼-------------------------------------------------------------------------------------------

$('#stopBtn').click(function(){
//check1----------------------------------------------------------------
	let count=0;
	let yn=0;
	let count2=0;
	let yn2=0;
	
		var buttonId = $('.active').attr('id');
		
		if(buttonId=='general-tab'){
			
			let check1 = document.getElementsByName("check");
			var alertCheck=0;
			
			var listEmail = new Array();
			var listNum = new Array();
			
			for(var i=0; i<check1.length; i++){
				if(check1[i].checked == false){
					count++;
					
				}else if(check1[i].checked == true){
					var dataEmail = new Object();
					var dataNum = new Object();
					
					dataNum.number = i;
					dataEmail.email = check1[i].value;
					listNum.push(dataNum);
					listEmail.push(dataEmail);
					
					yn++;
					
				}//else if
			}//for
			
			var jsonNum = JSON.stringify(listNum);
			var jsonEmail = JSON.stringify(listEmail);
			if(count != 0 && yn==0){
				alert('활동정지할 회원을 선택해주세요');			
			}else if(count >= 0 && yn != 0){
				$('#myModal').modal('show');
			}
			$('#checkNum').val(jsonNum);
			$('#checkHidden').val(jsonEmail);
			
		}//if general-tab
		
			
//check2-------------------------------------------------------------------------	
		if(buttonId=='warning-tab'){
			
			var check2 = document.getElementsByName("checkWarning");
			var listEmail2 = new Array();
			var listNum2 = new Array();
			
			for(var i=0; i<check2.length; i++){
				if(check2[i].checked == false){
					count2++;
					
				}else if(check2[i].checked == true){
					
					var dataEmail2 = new Object();
					var dataNum2 = new Object();
					
					dataNum2.number = i;
					dataEmail2.email = check2[i].value;
					listNum2.push(dataNum2);
					listEmail2.push(dataEmail2);
					
					yn2++;
					
				}//else if
			}//for
			
			var jsonNum2 = JSON.stringify(listNum2);
			var jsonEmail2 = JSON.stringify(listEmail2);
			
//--------------------------------------------------------------	 
			
			if(count2 != 0 && yn2==0){
					alert('활동정지할 회원을 선택해주세요');			   
			}else if (count2>=0 && yn2!=0){
				$('#myModal').modal('show');
				$('#checkNum').val(jsonNum2);
				$('#checkHidden').val(jsonEmail2);
			}
			
			
		}
		
		
		
	});

$('#stopInsertBtn').click(function(){
	var radioId = $('input:radio[name="inlineRadioOptions"]:checked').val();
	var aaa = $('input[name=stopReason]').val()
	
	if(aaa == ''){
		alert('정지 사유를 입력해주세요 ');
	}else{
	$.ajax({
		type: 'post',
		url: '/simri/member/stopInsert',
		data: { 'num' : $('#checkNum').val(),
			'email': $('#checkHidden').val(),
			'stopReason': $('input[name=stopReason]').val(),
			'period': $('label[for="'+radioId+'"]').text()
		},
		success: function(data){
			alert('정지되었습니다.');
			$('#myModal').modal('hide');
			window.location.reload();
		},
		error: function(err){
			console.log(err);
		}
	});
	}
});

$('#stopPeriodBtn').click(function(){
	let count2=0;
	let yn2=0;
	var buttonId = $('.active').attr('id');
	if(buttonId=='warning-tab'){
		
		var check2 = document.getElementsByName("checkWarning");
		var listEmail2 = new Array();
		var listNum2 = new Array();
		
		for(var i=0; i<check2.length; i++){
			if(check2[i].checked == false){
				count2++;
				
			}else if(check2[i].checked == true){
				var dataEmail2 = new Object();
				var dataNum2 = new Object();
				
				dataNum2.number = i;
				dataEmail2.email = check2[i].value;
				listNum2.push(dataNum2);
				listEmail2.push(dataEmail2);
				
				yn2++;
				
			}//else if
		}//for
		
		var jsonNum2 = JSON.stringify(listNum2);
		var jsonEmail2 = JSON.stringify(listEmail2);
		
		if(count2 != 0 && yn2==0){
				alert('정지 연장할 회원을 선택해주세요');			   
		}else if (count2>=0 && yn2!=0){
			$('#myModalPeriod').modal('show');
			$('#checkNum').val(jsonNum2);
			$('#checkHidden').val(jsonEmail2);
		}
		
		
	}

	//check3----------------------------------------------------------------
	let count3=0;
	let yn3=0;
		
			if(buttonId=='stop-tab'){
				var check3 = document.getElementsByName("checkStop");
				var listEmail3 = new Array();
				var listNum3 = new Array();
				
				for(var i=0; i<check3.length; i++){
					if(check3[i].checked == false){
						count3++;
						
					}else if(check3[i].checked == true){
						
						var dataEmail3 = new Object();
						var dataNum3 = new Object();
						
						dataNum3.number = i;
						dataEmail3.email = check3[i].value;
						listNum3.push(dataNum3);
						listEmail3.push(dataEmail3);
						
						yn3++;
						
					}//else if
				}//for
				
				var jsonNum3 = JSON.stringify(listNum3);
				var jsonEmail3 = JSON.stringify(listEmail3);
				
				if(count3 != 0 && yn3==0){
					alert('정지 연장할 회원을 선택해주세요');	   
				}else if(count3>=0 && yn3 != 0){
					$('#myModalPeriod').modal('show');
					$('#checkNum').val(jsonNum3);
					$('#checkHidden').val(jsonEmail3);
				}
			}//if stop-tab
});

$('#stopPeriodInsertBtn').click(function(){
	var radioId = $('input:radio[name="inlinePeriodRadioOptions"]:checked').val();

	$.ajax({
		type: 'post',
		url: '/simri/member/stopPeriodInsert',
		data: { 'num' : $('#checkNum').val(),
			'email': $('#checkHidden').val(),
			'period': $('label[for="'+radioId+'"]').text()
		},
		success: function(data){
			alert('정지기간이 연장되었습니다.');
			$('#myModalPeriod').modal('hide');
			window.location.reload();
		},
		error: function(err){
			console.log(err);
		}
	});
});

$('#deleteBtn').click(function(){
	let count=0;
	let yn=0;
	let count2=0;
	let yn2=0;
	let count3=0;
	let yn3=0;
	
	var buttonId = $('.active').attr('id');
	
	if(buttonId=='general-tab'){
	
	var check1 = document.getElementsByName("check");
	var listEmail = new Array();
	
	for(var i=0; i<check1.length; i++){
		if(check1[i].checked == false){
			count++;
			
		}else if(check1[i].checked == true){
			var dataEmail = new Object();

			dataEmail.email = check1[i].value;
			listEmail.push(dataEmail);
			yn++;
			
		}//else if
	}//for
	
	var jsonEmail = JSON.stringify(listEmail);
	
	if(count != 0 && yn==0){
		alert('강제 탈퇴할 회원을 선택해주세요');
	}else{
		if(confirm("정말 강퇴하시겠습니까?")){
			$.ajax({
				type: 'post',
				url: '/simri/member/memberDelete',
				data: 'email='+jsonEmail,
				success: function(data){
					alert('강퇴했습니다.');
					window.location.reload();
				},
				error: function(err){
					console.log(err);
				}
				
			});
		}
		
			
		
	}

		
	}//if general-tab
	
	
//---------------------------------------------------------
	
	if(buttonId=='warning-tab'){
		var check2 = document.getElementsByName("checkWarning");
		var listEmail2 = new Array();
		
		for(var i=0; i<check2.length; i++){
			if(check2[i].checked == false){
				count2++;
				
			}else if(check2[i].checked == true){
				
				var dataEmail2 = new Object();
				
				dataEmail2.email = check2[i].value;
				listEmail2.push(dataEmail2);
				yn2++;
				
			}//else if
		}//for
		
		var jsonEmail2 = JSON.stringify(listEmail2);
		if(count2==0 && yn2==0){
			alert('강제 탈퇴할 회원을 선택해주세요');
		}else if(count2 != 0 && yn2==0){
			alert('강제 탈퇴할 회원을 선택해주세요');	   
		}else {
			if(confirm("정말 강퇴하시겠습니까?")){
				$.ajax({
					type: 'post',
					url: '/simri/member/memberDelete',
					data: 'email='+jsonEmail2,
					success: function(data){
						alert('강퇴했습니다.');
						window.location.reload();
					},
					error: function(err){
						console.log(err);
					}
					
				});
			}
		}
		
		
	}//if warning-tab
	
//----------------------------------------------------------
	if(buttonId=='stop-tab'){
		var check3 = document.getElementsByName("checkStop");
		var listEmail3 = new Array();
		
		for(var i=0; i<check3.length; i++){
			if(check3[i].checked == false){
				count3++;
				
			}else if(check3[i].checked == true){
				
				var dataEmail3 = new Object();
				
				dataEmail3.email = check3[i].value;
				listEmail3.push(dataEmail3);
				yn3++;
				
			}//else if
		}//for
		
		var jsonEmail3 = JSON.stringify(listEmail3);
		if(count3==0 && yn3==0){
			alert('강제 탈퇴할 회원을 선택해주세요');
		}else if(count3 != 0 && yn3==0){
			alert('강제 탈퇴할 회원을 선택해주세요');	   
		}else {
			if(confirm("정말 강퇴하시겠습니까?")){
				$.ajax({
					type: 'post',
					url: '/simri/member/memberDelete',
					data: 'email='+jsonEmail3,
					success: function(data){
						alert('강퇴했습니다.');
						window.location.reload();
					},
					error: function(err){
						console.log(err);
					}
					
				});
			}
		}
		
		
	}//if stop-tab
	
	
	
	
	
	
});


$('#searchBtn').click(function(event, str){
	
	$('#general-tab').addClass('active');
	$('#stop-tab').removeClass('active');
	$('#warning-tab').removeClass('active');
	
	$('#general').addClass('active show');
	$('#stop').removeClass('active show');
	$('#warning').removeClass('active show');
	
	
	if($('#searchText').val() == '')
		alert('검색어를 입력하세요');
	else{
		$('#memberListTable tr:gt(0)').remove();
		$.ajax({
			type: 'get',
			url: '/simri/member/getMemberSearch',
			data: {
				'pg': $('#pg').val(),
				'category': $('#category').val(),
				'searchText': $('#searchText').val()
			},
			dataType: 'json',
			success: function(data){
				$('#memberListTable tr:gt(0)').remove();
				
				$.each(data.list, function(index, items){
					$('<tr/>').append($('<th/>',{
								scope: 'row'
								}).append($('<div/>',{
									class: 'form-check'
									}).append($('<input/>',{
										class: 'form-check-input',
										type: 'checkbox',
										name: 'check',
										value: items.email,
										onclick: 'checkSelectAll(this)'
								})))
							).append($('<td/>',{
								text: items.name,
									
							})).append($('<td/>',{
								text: items.email,
								id: 'memberInfo',
								style: 'cursor: pointer'
							})).append($('<td/>',{
							text: items.palette
								
							})).append($('<td/>',{
								text: items.point
								
							})).append($('<td/>',{
								text: items.memsingo
								
							})).append($('<td/>',{
								text: items.condition
								
							})).append($('<td/>',{
								text: items.signlogtime
								
							})).appendTo($('#memberListTable'));
					
					});//each
				
				//페이징 처리
				$('#memberPagingDiv').html(data.memberPaging.pagingHTML);
				 
				$(document).on('click', '#memberInfo', function(){
					
					window.open('/simri/member/memberView?email='+$(this).text(), 'ss', 'width=640 height=540 left=800 top=200 scrollbars=yes');
					
				});
			},
			error: function(err){
				console.log(err);
			}
				
		});
		
	}
	
	$('#pg').val('1');
	
});


//전체 회원 페이징
function mypagePaging(pg){
	var searchText = document.getElementById('searchText').value;
	$('#general-tab').addClass('active');
	$('#warning-tab').removeClass('active');
	$('#stop-tab').removeClass('active');
	
	
	if(searchText==''){
		location.href = '/simri/member/memberList?pg='+pg;
	}else{
		$('#pg').val(pg);
		$('#searchBtn').trigger('click', 'search');
	}
	
}


//신고 회원 페이징
function memberWarningPaging(pg){
	var searchText = document.getElementById('searchText').value;
	$('#warning-tab').addClass('active');
	$('#general-tab').removeClass('active');
	$('#stop-tab').removeClass('active');
	
	if(searchText==''){
		location.href = '/simri/member/memberList?pg='+pg+"&btnId=warning";
	}else{
		$('#pg').val(pg);
		$('#searchBtn').trigger('click', 'search');
	}
	
}

//정지 회원 페이징
function memberStopPaging(pg){
	var searchText = document.getElementById('searchText').value;
	$('#stop-tab').addClass('active');
	$('#general-tab').removeClass('active');
	$('#warning-tab').removeClass('active');
	
	if(searchText==''){
		location.href = '/simri/member/memberList?pg='+pg+"&btnId=stop";
	}else{
		$('#pg').val(pg);
		$('#searchBtn').trigger('click', 'search');
	}
	
}



