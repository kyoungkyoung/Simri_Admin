<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<h1>${communityDTO.category}<br><br></h1>
<h4>[${communityDTO.seq}] ${communityDTO.subject }</h4>
<hr>
<input type="hidden" id="seq" value="${seq}"> <!-- 넘어온 seq값을 hidden으로 값 저장해서 넘겨주기 -->

<div class="container">
  <div class="row" style="padding-right: 15px;">
    <div class="col-4">
<div class="card" style="width: 18rem;">
  <div class="card-body">
    <p class="card-text text-danger"><strong>누적 조회수</strong></p>
    <h3 class="card-title text-danger">${communityDTO.hit}</h3>
   
  </div>
</div>
</div>

<div class="col-4">
<div class="card" style="width: 18rem;">
  <div class="card-body">
     <p class="card-text">누적 좋아요수</p>
    <h3 class="card-title">${communityDTO.comLike}</h3>
  </div>
</div>
</div>

 <div class="col-4">
<div class="card" style="width: 18rem;">
  <div class="card-body">
     <p class="card-text">누적 댓글수</p>
    <h3 class="card-title">${communityDTO.reply}</h3>
  </div>
</div>
</div>
</div>
</div>
<br>
<hr>
<br>
<div class="d-grid gap-2 d-sm-flex justify-content-sm-center mt-1" style="text-align:center">

   <h4 class="mt-3">
      
      <div class="input-group">
      <span class="input-group-addon">
      <i class="fa fa-calendar bigger-110"></i>
      </span>
         <svg xmlns="http://www.w3.org/2000/svg"  width="40" height="40" fill="currentColor" class="bi bi-calendar3 mt-1 ml-1" viewBox="0 0 16 16">
           <path d="M14 0H2a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2zM1 3.857C1 3.384 1.448 3 2 3h12c.552 0 1 .384 1 .857v10.286c0 .473-.448.857-1 .857H2c-.552 0-1-.384-1-.857V3.857z"/>
          <path d="M6.5 7a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm-9 3a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm-9 3a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2z"/>
          </svg> &ensp;
      <input type="text" name="datefilter" value="" id="date" style="text-align:center"/> &ensp;
      <button class="btn btn-outline-info" type="button" id="dateBtn">조회</button>
      </div>

</h4>
</div>
<br><br>
<strong>통계</strong>



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
 
   
   
   
   
     <!-- 달력 -->


<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.6.0/Chart.js"></script>
<script src="../js/chart.js"></script>
	
	   


</div>
</div>

<!-- 차트 끝 -->