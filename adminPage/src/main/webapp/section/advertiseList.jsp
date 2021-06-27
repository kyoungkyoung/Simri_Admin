<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 메인 화면 -->
<div class="p-2">
	<h3>
		광고목록
		<button type="button" class="btn btn-outline-danger float-right ">삭제</button>
		<button type="button" class="btn btn-outline-danger float-right mr-2" data-bs-toggle="modal" data-bs-target="#exampleModal">등록</button>
	</h3>
</div>
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
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
		  	 
		  	정지 기간 : <div class="form-check form-check-inline mt-3 ml-1">
  <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1">
  <label class="form-check-label" for="inlineRadio1">1일</label>
</div>
<div class="form-check form-check-inline">
  <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2">
  <label class="form-check-label" for="inlineRadio2">3일</label>
</div>
<div class="form-check form-check-inline">
  <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio3" value="option3">
  <label class="form-check-label" for="inlineRadio3">1주일</label>
</div>

		  	 
		  	 
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary">등록</button>
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
      </div>
    </div>
  </div>
</div>






<div class="p-3 ">
	<div class="d-flex">
		<div class="btn-group">
			<select class="btn btn-danger dropdown-toggle mr-1" type="button"
				id="dropdownMenuButton" data-bs-toggle="dropdown"
				aria-expanded="false" >
				<option>검색</option>		
				<option>이름</option>
				<option>아이디</option>
			
			</select>
		</div>
		<input class="form-control me-2" type="search" placeholder="Search"
			aria-label="Search">
		<button class="btn btn-outline-danger ml-1 " type="submit">Search</button>
	</div>
</div>




<!-- 상태넣기 -->
<ul class="nav nav-tabs" id="myTab" role="tablist">
  <li class="nav-item" role="presentation">
    <button class="nav-link active btn-sm" id="general-tab" data-bs-toggle="tab" data-bs-target="#general" type="button" role="tab" aria-controls="general" aria-selected="true">전체 회원</button>
  </li>
  <li class="nav-item" role="presentation">
    <button class="nav-link btn-sm" id="warning-tab" data-bs-toggle="tab" data-bs-target="#warning" type="button" role="tab" aria-controls="warning" aria-selected="false">신고 회원</button>
  </li>  
    <li class="nav-item" role="presentation">
    <button class="nav-link btn-sm" id="warning-tab" data-bs-toggle="tab" data-bs-target="#warning" type="button" role="tab" aria-controls="warning" aria-selected="false">정지 회원</button>
  </li> 
</ul>



<!-- 일반멤버탭 -->
<div class="tab-content" id="myTabContent">
<div class="tab-pane fade show active" id="general" role="tabpanel" aria-labelledby="general-tab">
  <table class="table table-hover">
	<thead>
		<tr>
			<th scope="col"><div class="form-check">
					<input class="form-check-input" type="checkbox" value=""
						id="flexCheckDefault"> <label class="form-check-label"
						for="flexCheckDefault"> # </label>
				</div></th>
			<th scope="col">이름</th>
			<th scope="col">이메일</th>
			<th scope="col">포인트</th>
			<th scope="col">신고내역</th>
			<th scope="col">회원상태</th>
		</tr>
	</thead>
	<tbody>
		<tr id="memberInfo" style="cursor: pointer;">
			<th scope="row">
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value=""
						id="flexCheckDefault"> <label class="form-check-label"
						for="flexCheckDefault"> 1 </label>
				</div>
			</th>
			<td>Mark</td>
			<td>Otto123</td>
			<td>100</td>
			<td>1 회</td>
			<td>일반회원</td>
		</tr>
		<tr>
			<th scope="row">
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value=""
						id="flexCheckDefault"> <label class="form-check-label"
						for="flexCheckDefault"> 2 </label>
				</div>
			</th>
			<td>Jacob</td>
			<td>jc33</td>
			<td>5</td>
			<td>6 회</td>
			<td>경고</td>
		</tr>
		<tr>
			<th scope="row">
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value=""
						id="flexCheckDefault"> <label class="form-check-label"
						for="flexCheckDefault"> 3 </label>
				</div>
			</th>
			<td>Harry</td>
			<td>potter78</td>
			<td>180</td>
			<td>1 회</td>
			<td>일반회원</td>
		</tr>
		

	</tbody>
</table>
<hr />
</div>
<div class="tab-pane fade" id="warning" role="tabpanel" aria-labelledby="warning-tab">
<table class="table table-hover">
	<thead>
		<tr>
			<th scope="col"><div class="form-check">
					<input class="form-check-input" type="checkbox" value=""
						id="flexCheckDefault"> <label class="form-check-label"
						for="flexCheckDefault"> # </label>
				</div></th>
			<th scope="col">이름</th>
			<th scope="col">이메일</th>
			<th scope="col">포인트</th>
			<th scope="col">신고내역</th>
			<th scope="col">회원상태</th>
		</tr>
	</thead>
	<tbody>
		<tr id="memberInfo" style="cursor: pointer;">
			<th scope="row">
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value=""
						id="flexCheckDefault"> <label class="form-check-label"
						for="flexCheckDefault"> 1 </label>
				</div>
			</th>
			<td>Mark</td>
			<td>Otto123</td>
			<td>100</td>
			<td>1 회</td>
			<td>일반회원</td>
		</tr>
		<tr>
			<th scope="row">
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value=""
						id="flexCheckDefault"> <label class="form-check-label"
						for="flexCheckDefault"> 2 </label>
				</div>
			</th>
			<td>Jacob</td>
			<td>jc33</td>
			<td>5</td>
			<td>6 회</td>
			<td>경고</td>
		</tr>
		<tr>
			<th scope="row">
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value=""
						id="flexCheckDefault"> <label class="form-check-label"
						for="flexCheckDefault"> 3 </label>
				</div>
			</th>
			<td>Harry</td>
			<td>potter78</td>
			<td>180</td>
			<td>1 회</td>
			<td>일반회원</td>
		</tr>
		

	</tbody>
</table>
<hr />


</div>

</div>












<!-- 페이징 -->
<div class= "col text-center">
<nav aria-label="Page navigation example" class="d-grid gap-2 d-sm-flex justify-content-sm-center">
  <ul class="pagination" >
    <li class="page-item">
      <a class="page-link" href="#" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">2</a></li>
    <li class="page-item"><a class="page-link" href="#">3</a></li>
    <li class="page-item">
      <a class="page-link" href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>
</div>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
//팝업창
$('#memberInfo').click(function(){
	window.open('/simri/section/memberView', 'ss', 'width=640 height=540 left=800 top=200 scrollbars=yes');
});// click
</script>