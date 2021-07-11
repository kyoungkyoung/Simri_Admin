<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!-- 메인 화면 -->
<div class="p-2">
   <h3>
      회원관리
      <button type="button" class="btn btn-outline-danger float-right" id="deleteBtn">강제 탈퇴</button>
      <button type="button" class="btn btn-outline-danger float-right mr-2" data-bs-target="#exampleModal" id="stopBtn">활동 정지</button>
   	  <button type="button" class="btn btn-outline-danger float-right mr-2" data-bs-target="#exampleModalPeriod" id="stopPeriodBtn">정지 연장</button>
   </h3>
</div>
<!-- 활동 정지 Modal -->
<div class="modal fade" id="myModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">계정 정지</h5>
      </div>
      
      <div class="modal-body">
                  정지 사유 : <input type="text" list="stopReason" name="stopReason" placeholder="직접입력" >
            <datalist id="stopReason">    
                <option value="비속어 사용">
                <option value="음란물 등록">
                <option value="싸움조장">   
            </datalist>
            
            <br>
            
           정지 기간 (일) : <div class="form-check form-check-inline mt-3 ml-1">
  <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1" checked>
  <label class="form-check-label" for="option1">1</label>
</div>
<div class="form-check form-check-inline">
  <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2">
  <label class="form-check-label" for="option2">3</label>
</div>
<div class="form-check form-check-inline">
  <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio3" value="option3">
  <label class="form-check-label" for="option3">7</label>
</div>

<div>
	<input type="hidden" id="checkNum" value="">
	<input type="hidden" id="checkHidden" value="">
</div>
            
            
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" id="stopInsertBtn">등록</button>
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
      </div>
    </div>
  </div>
</div>


<!-- 정지 연장 Modal -->
<div class="modal fade" id="myModalPeriod" tabindex="-1" aria-labelledby="exampleModalPeriodLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalPeriodLabel">계정 정지 연장</h5>
      </div>
      
      <div class="modal-body">
	           정지 기간 (일) : 
	        <div class="form-check form-check-inline mt-3 ml-1">
  				<input class="form-check-input" type="radio" name="inlinePeriodRadioOptions" id="inlinePeriodRadio1" value="periodOption1" checked>
  				<label class="form-check-label" for="periodOption1">1</label>
			</div>
			<div class="form-check form-check-inline">
  				<input class="form-check-input" type="radio" name="inlinePeriodRadioOptions" id="inlinePeriodRadio2" value="periodOption2">
  				<label class="form-check-label" for="periodOption2">3</label>
			</div>
			<div class="form-check form-check-inline">
  				<input class="form-check-input" type="radio" name="inlinePeriodRadioOptions" id="inlinePeriodRadio3" value="periodOption3">
  				<label class="form-check-label" for="periodOption3">7</label>
			</div>

			<div>
				<input type="hidden" id="checkNum" value="">
				<input type="hidden" id="checkHidden" value="">
			</div>
            
            
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" id="stopPeriodInsertBtn">등록</button>
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
      </div>
    </div>
  </div>
</div>



<div class="p-3 ">
   <div class="d-flex">
      <div class="btn-group">
         <select class="btn btn-danger dropdown-toggle mr-1" id="category" aria-expanded="false" >
            <option>이름</option>
            <option>이메일</option>
         </select>
      </div>
      <input class="form-control me-2" type="search" placeholder="Search" id="searchText" name="searchText" aria-label="Search" value="${searchText }">
      <button class="btn btn-outline-danger ml-1 " type="button" id="searchBtn">Search</button>
   </div>
</div>


<!-- 상태넣기 -->
<ul class="nav nav-tabs" id="myTab" role="tablist">
  <li class="nav-item" role="presentation">
    <button class="nav-link btn-sm active" id="general-tab" data-bs-toggle="tab" data-bs-target="#general" type="button" role="tab" aria-controls="general" aria-selected="true">전체 회원</button>
  </li>
  <li class="nav-item" role="presentation">
    <button class="nav-link btn-sm" id="warning-tab" data-bs-toggle="tab" data-bs-target="#warning" type="button" role="tab" aria-controls="warning" aria-selected="false">신고 회원</button>
  </li>  
    <li class="nav-item" role="presentation">
    <button class="nav-link btn-sm" id="stop-tab" data-bs-toggle="tab" data-bs-target="#stop" type="button" role="tab" aria-controls="stop" aria-selected="false">정지 회원</button>
  </li> 
</ul>


<input type="hidden" value="${category}">
<input type="hidden" value="${searchText}">

<input type="hidden" id="pg" value="${pg}">


<!-- 전체회원 -->
<div class="tab-content" id="myTabContent">
<div class="tab-pane fade show active" id="general" role="tabpanel" aria-labelledby="general-tab">
  <table class="table table-hover" id="memberListTable">
   <thead>
      <tr>
         <th scope="col">
         	<div class="form-check">
               <input class="form-check-input" type="checkbox" value="" id="all" onclick="checkAll(this)">
               <label></label>
            </div>
         </th>
         <th scope="col">이름</th>
         <th scope="col">이메일</th>
         <th scope="col">팔레트</th>
         <th scope="col">포인트</th>
         <th scope="col">신고내역</th>
         <th scope="col">회원상태</th>
         <th scope="col">가입일</th>
      </tr>
   </thead>
</table>
<!-- 페이징 -->
<nav aria-label="Page navigation example">
      <ul class="pagination justify-content-center my-4" id="memberPagingDiv">
      </ul>
</nav>
<%-- <input type="hidden" id="pg" name="pg" value="${pg}"> --%>




</div>


<!-- 신고 회원 -->

<div class="tab-pane fade" id="warning" role="tabpanel" aria-labelledby="warning-tab">
<table class="table table-hover" id="memberWarningListTable">
   <thead>
      <tr>
         <th scope="col">
         	<div class="form-check">
               <input class="form-check-input" type="checkbox" value="" id="allWarning" onclick="checkAllWarning(this)">
               <label></label>
            </div>
         </th>
         <th scope="col">이름</th>
         <th scope="col">이메일</th>
         <th scope="col">팔레트</th>
         <th scope="col">포인트</th>
         <th scope="col">신고내역</th>
         <th scope="col">신고내용</th>
         <th scope="col">회원상태</th>
      </tr>
   </thead>
</table>
<!-- 페이징 -->
<nav aria-label="Page navigation example">
      <ul class="pagination justify-content-center my-4" id="memberWarningPagingDiv">
      </ul>
</nav>
<input type="hidden" id="btnId" value="${btnId}">

</div> 

<!-- 정지 회원 -->

<div class="tab-pane fade" id="stop" role="tabpanel" aria-labelledby="stop-tab">
<table class="table table-hover" id="memberStopListTable">
   <thead>
      <tr>
         <th scope="col">
         	<div class="form-check">
               <input class="form-check-input" type="checkbox" value="" id="allStop" onclick="checkAllStop(this)">
               <label></label>
            </div>
         </th>
         <th scope="col">이름</th>
         <th scope="col">이메일</th>
         <th scope="col">팔레트</th>
         <th scope="col">포인트</th>
         <th scope="col">정지기간</th>
         <th scope="col">정지내용</th>
         <th scope="col">회원상태</th>
         <th scope="col">정지일</th>
      </tr>
   </thead>
</table>
<!-- 페이징 -->
<nav aria-label="Page navigation example">
      <ul class="pagination justify-content-center my-4" id="memberStopPagingDiv">
      </ul>
</nav>
	<%-- <input type="hidden" id="pg" value="${pg}"> --%>

</div>


</div>



<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="../js/memberList.js"></script>

