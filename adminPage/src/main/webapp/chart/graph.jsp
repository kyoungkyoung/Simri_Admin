<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<!-- <html lang="en" style="height: 100%"> -->

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <meta http-equiv="X-UA-Compatible" content="ie=edge">
   <title>부트스트랩 차트그리기</title>
   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
   
   <!-- 차트 시작 -->
   <!-- 차트 링크 -->
   <script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
</head>

<body>

<!-- 차트 -->

<main class="col-md-9 ms-sm-auto col-lg-12 px-md-4">
      <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h1 class="h2">Dashboard</h1>
        <div class="btn-toolbar mb-2 mb-md-0">
          
          <div class="btn-group">
          <button class="btn btn-sm btn-outline-secondary dropdown-toggle" 
          		  type="button" id="dropdownMenuButton" data-bs-toggle="dropdown" aria-expanded="true">일간 </button>

             <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
             	<li><a class="dropdown-item" href="#">일간</a></li>
				<li><a class="dropdown-item" href="#">주간</a></li>
				<li><a class="dropdown-item" href="#">월간</a></li>
			 </ul>
        </div>
        </div>      
      </div>


	<div class="container">
		<canvas id="myChart"></canvas>
	</div> <!-- 부트스트랩 -->
 
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
     integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
     crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
     integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
     crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
     integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
     crossorigin="anonymous"></script> <!-- 차트 -->
<script> 
	var chartLabels = [];
	var chartData = [];
	
	$.ajax({
		type:'post',
		url: '',
		dataType:'json',
		success: function(data){
			alert(JSON.stringify(data));
			
			
			
			
			
			
			
			
			
		},
		error : function(err){
			console.log(err);
		}
	});
</script>
<!-- 차트 끝 -->


<br>
<br>
<br>
<div class="container2">
<div class="col">
   <div class="row">

       <div class="col-6">
      <h5>테스트 조회수 순위</h5>
      
      <table class="table table-sm">
           <thead>
             <tr>
               <th scope="col">순위</th>
               <th scope="col">제목</th>
               <th scope="col">조회수</th>
             </tr>
           </thead>
           <tbody>
             <tr>
               <th scope="row">1</th>
               <td>색깔로 보는 mbti test</td>
               <td>301</td>
             </tr>
             <tr>
               <th scope="row">2</th>
               <td>짱구 심리테스트</td>
               <td>86</td>
             </tr>
             <tr>
               <th scope="row">3</th>
               <td>당신의 연애스타일</td>
               <td>66</td>
             </tr>
           </tbody>
      </table>
      
      
      
      </div>
   
      <div class="col-6">
      <h5>게시물 조회수 순위</h5>
      
      <table class="table table-sm" >
           <thead>
             <tr>
               <th scope="col" width="60px">순위</th>
               <th scope="col" width="280px" >제목</th>
               <th scope="col">조회수</th>
             </tr>
           </thead>
           <tbody>
             <tr>
               <th scope="row">1</th>
               <td>외로움은 없애야 하는 </td>
               <td>514</td>
             </tr>
             <tr>
               <th scope="row">2</th>
               <td>그녀가 소개팅에 실패한 </td>
               <td>421</td>
             </tr>
             <tr>
               <th scope="row">3</th>
               <td>이성에게 연락이 끊이지 않는 </td>
               <td>301</td>
             </tr>
           </tbody>
      </table>
      
      
      </div>
  
   </div>
</div>
</div>








</main>
</body>

</html>