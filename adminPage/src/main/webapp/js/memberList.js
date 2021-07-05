//리스트 부르기----------------------------------------------------------------------------------------------
$(function(){
	//alert("나오나"+$('#btnId').val());
	if($('#btnId').val() === 'warning'){
		$('#warning-tab').addClass('active');
		$('#general-tab').removeClass('active');
		
		$('#general').removeClass('show active');
		$('#warning').addClass('show active');
	}
	
	var buttonId = $('.active').attr('id');
	
	if(buttonId == 'general-tab'){
		$('#general-tab').trigger('click')
	}else if(buttonId == 'warning-tab'){
		$('#warning-tab').trigger('click');
	}
});

$('#general-tab').click(function(){
	$('#general-tab').addClass('active');
	$('#warning-tab').removeClass('active');
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
							text: items.name,
							/*id: 'memberInfo',
							style: 'cursor: pointer'*/
								
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
							text: items.condition
							
						})).append($('<td/>',{
							text: items.signlogtime
							
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
	$('#searchText').val('');
	
	$.ajax({
		type:'post',
		url:'/simri/member/getMemberStopList',
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
							text: items.memsingo
							
						})).append($('<td/>',{
							text: items.condition
							
						})).append($('<td/>',{
							text: items.signlogtime
							
						})).appendTo($('#memberStopListTable'));
			});//each
			
			 
			
			$(document).on('click', '#memberInfo', function(){
				window.open('/simri/member/memberView?email='+$(this).text(), 'ss', 'width=640 height=540 left=800 top=200 scrollbars=yes');
				  
				
			});
		},
		error: function(err){
			console.log(err);
		}
	});
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
					console.log(check1[i].value);
					
					var dataEmail = new Object();
					var dataNum = new Object();
					
					dataNum.number = i;
					dataEmail.email = check1[i].value;
					listNum.push(dataNum);
					listEmail.push(dataEmail);
					console.log(listNum);
					console.log(listEmail);
					
					yn++;
					
				}//else if
			}//for
			
			var jsonNum = JSON.stringify(listNum);
			var jsonEmail = JSON.stringify(listEmail);
			console.log(jsonNum);
			console.log(jsonEmail);
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
					console.log(check2[i].value);
					
					var dataEmail2 = new Object();
					var dataNum2 = new Object();
					
					dataNum2.number = i;
					dataEmail2.email = check2[i].value;
					listNum2.push(dataNum2);
					listEmail2.push(dataEmail2);
					console.log(listNum2);
					console.log(listEmail2);
					
					
					yn2++;
					
				}//else if
			}//for
			
			var jsonNum2 = JSON.stringify(listNum2);
			var jsonEmail2 = JSON.stringify(listEmail2);
			console.log(jsonNum2);
			console.log(jsonEmail2);
			
			
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
	console.log(radioId);

	
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
});


$('#deleteBtn').click(function(){
	var check1 = document.getElementsByName("check");
	var count=0;
	var yn=0;
	var listEmail = new Array();
	
	for(var i=0; i<check1.length; i++){
		if(check1[i].checked == false){
			count++;
			
		}else if(check1[i].checked == true){
			console.log(check1[i].value);
			
			var dataEmail = new Object();

			dataEmail.email = check1[i].value;
			listEmail.push(dataEmail);
			console.log(listEmail);
			
			
			yn++;
			
		}//else if
	}//for
	
	var jsonEmail = JSON.stringify(listEmail);
	console.log(jsonEmail);
	
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
});

$('#searchBtn').click(function(event, str){
	alert(str);
	
	alert($('#pg').val());
	//$('#general-tab').trigger('click')
	
	if($('#searchText').val() == '')
		alert('검색어를 입력하세요');
	else{
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
				alert(JSON.stringify(data));
				
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
		
		$.ajax({
			type: 'get',
			url: '/simri/member/getMemberWarningSearch',
			data: {
				'pg': $('#pg').val(),
				'category': $('#category').val(),
				'searchText': $('#searchText').val()
			},
			dataType: 'json',
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
								text: items.condition
								
							})).append($('<td/>',{
								text: items.signlogtime
								
							})).appendTo($('#memberWarningListTable'));
				});//each
				
				//페이징 처리
				$('#memberWarningPagingDiv').html(data.memberPaging.pagingHTML);
				
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
	
	if(searchText==''){
		//$('#pg').val(pg);
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
	
	if(searchText==''){
		location.href = '/simri/member/memberList?pg='+pg+"&btnId=warning";
	}else{
		$('#pg').val(pg);
		$('#searchBtn').trigger('click', 'search');
	}
	
	}
