<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

   <title>부트스트랩 차트그리기</title>
   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
   
   <!-- 차트 시작 -->
   <!-- 차트 링크 -->
   <script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>


<body>

<!-- 차트 -->

<main class="col-md-9 ms-sm-auto col-lg-12 px-md-4">
      <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h2 class="h2">회원가입 통계</h2>
        <div class="btn-toolbar mb-2 mb-md-0">
			<div class="btn-group"> 
				<select class="btn btn-sm btn-outline-secondary dropdown-toggle mb-3" id="date" aria-expanded="false">
					<option value="day" >일간</option>
					<option value="month" >월간</option>
				</select>
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
     
     
     
     
     
     

<!-- 차트 끝 -->


<br>
<br>
<br>
<div class="container2">
<div class="col">
   <div class="row">

       <div class="col-6">
      <h5>심리 테스트 조회수 순위</h5>
      
      <table class="table table-sm" id="testHitTable">
           <thead>
             <tr>
               <th scope="col"width="60px" style="text-align:center;">번호</th>
               <th scope="col" width="280px" style="text-align:center;">제목</th>
               <th scope="col" style="text-align:center;">조회수</th>
             </tr>
           </thead>
      </table>
      
      
      
      </div>
   
      <div class="col-6">
      <h5>연애 심리 게시물 조회수 순위</h5>
      
      <table class="table table-sm" id="loveHitTable">
           <thead>
             <tr>
              <th scope="col"width="60px" style="text-align:center;">번호</th>
               <th scope="col" width="280px" style="text-align:center;">제목</th>
               <th scope="col" style="text-align:center;">조회수</th>
             </tr>
           </thead>
      </table>
      
      
      </div>
  
   </div>
</div>
</div>

</main>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.6.0/Chart.js"></script>
<script src="../js/memberChart.js"></script>
