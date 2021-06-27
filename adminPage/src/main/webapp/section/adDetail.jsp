<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<h4>광고이름
<button type="button" class="btn btn-outline-danger btn-sm">게시물보기</button>
</h4>
<hr>

<div class="container">
  <div class="row" style="padding-right: 15px;">
    <div class="col-12">
<div class="card" style="width: 18rem;">
  <div class="card-body">
    <p class="card-text text-danger"><strong>누적 노출수</strong></p>
    <h3 class="card-title text-danger">301</h3>
   
  </div>
</div>
</div>



<div class="d-grid gap-2 d-sm-flex justify-content-sm-center mt-1" style="margin-left: 360px;">

<h4 class="mt-3">
		
<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-caret-left mt-1" viewBox="0 0 16 16">
  <path d="M10 12.796V3.204L4.519 8 10 12.796zm-.659.753-5.48-4.796a1 1 0 0 1 0-1.506l5.48-4.796A1 1 0 0 1 11 3.204v9.592a1 1 0 0 1-1.659.753z"/>
</svg> 

2021.06.

<svg xmlns="http://www.w3.org/2000/svg"  width="21" height="21" fill="currentColor" class="bi bi-calendar3 mt-1 ml-1" viewBox="0 0 16 16">
  <path d="M14 0H2a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2zM1 3.857C1 3.384 1.448 3 2 3h12c.552 0 1 .384 1 .857v10.286c0 .473-.448.857-1 .857H2c-.552 0-1-.384-1-.857V3.857z"/>
  <path d="M6.5 7a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm-9 3a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm-9 3a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2z"/>
</svg>

<svg xmlns="http://www.w3.org/2000/svg"  width="25" height="25" fill="currentColor" class="bi bi-caret-right mt-1" viewBox="0 0 16 16">
  <path d="M6 12.796V3.204L11.481 8 6 12.796zm.659.753 5.48-4.796a1 1 0 0 0 0-1.506L6.66 2.451C6.011 1.885 5 2.345 5 3.204v9.592a1 1 0 0 0 1.659.753z"/>
</svg>

	</h4>



<hr>

<strong>기간별 노출현황</strong> 

<br>


<div class="card-group mt-2">
  <div class="card">
   
    <div class="card-body">
      <p class="card-text">노출수</p>
      <h5 class="card-title">0</h5>
    </div>
  
  </div>
</div>

<br>

<strong>주간 노출수 현황</strong>



<div class="container">
  <div class="row" >
    <div class="col-12" style="padding-right: 0px; padding-left: 0px;">
    
 <!-- 차트 시작 -->
   <!-- 차트 링크 -->
   <script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>


<!-- 차트 -->


      <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
      
        </div>      
      </div>


   <div class="container"> <canvas id="myChart"></canvas> </div> <!-- 부트스트랩 -->
 
   <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
      integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
      crossorigin="anonymous"></script>
   <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
      integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
      crossorigin="anonymous"></script>
   <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
      integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
      crossorigin="anonymous"></script> <!-- 차트 -->
   <script> var ctx = document.getElementById('myChart').getContext('2d'); var chart = new Chart(ctx, { type: 'line', data: { labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'], datasets: [{ label: 'visitor', backgroundColor: 'transparent', borderColor: 'red', data: [0, 10, 5, 2, 20, 30, 45] }] }, options: {} }); </script>
</div>
</div>

<!-- 차트 끝 -->
</body>
</html>