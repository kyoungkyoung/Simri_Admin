<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 메인 화면 -->
<div class="p-2">
	<h3>
		광고목록
		<button type="button" class="btn btn-outline-danger float-right ">삭제</button>
	</h3>
</div>

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
					<input class="form-check-input" type="checkbox" value="" id="flexCheckDefault"> <label class="form-check-label" for="flexCheckDefault"> 1 </label>
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
					<input class="form-check-input" type="checkbox" value=""id="flexCheckDefault"> <label class="form-check-label"for="flexCheckDefault"> 2 </label>
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
					<input class="form-check-input" type="checkbox" value="" id="flexCheckDefault"> <label class="form-check-label" for="flexCheckDefault"> 3 </label>
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
<script src="../js/loveList.js"></script>


<script>
//팝업창
$('#memberInfo').click(function(){
	window.open('/simri/section/memberView', 'ss', 'width=640 height=540 left=800 top=200 scrollbars=yes');
});// click
</script>