<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 메인 화면 -->
<div class="p-2">
	<h3>
		카테고리별  순위
		

		
		
	</h3>
</div>
<h4 style="margin-bottom: 0;">

 
<div class="d-grid gap-2 d-sm-flex justify-content-sm-center">




</div>
		<div class="btn-group" style="margin-right: 490px; margin-top: 10px;">
			<div class="btn-group">
			<select class="btn btn-danger dropdown-toggle mr-1" type="button"
				id="dropdownMenuButton" data-bs-toggle="dropdown"
				aria-expanded="false" >
				<option>전체목록</option>		
				<option>심리테스트</option>
				<option>심리글</option>
			
			</select>
		</div>
			
			<div class="btn-group">
			<select class="btn btn-danger dropdown-toggle mr-1" type="button"
				id="dropdownMenuButton" data-bs-toggle="dropdown"
				aria-expanded="false" >
				<option>전체목록</option>		
				<option>좋아요</option>
				<option>조회수</option>
			
			</select>
		</div>
			
			
					
		</div>
		
	
		<div class="btn-group mt-3 mb-2" role="group" aria-label="Basic outlined example " >
		  <button type="button" class="btn btn-outline-danger">일간</button>
		  <button type="button" class="btn btn-outline-danger">주간</button>
		  <button type="button" class="btn btn-outline-danger">월간</button>
		</div>
	</h4>
	

  
		
<table class="table table-hover">
	<thead>
		<tr>
			<th scope="col"><div class="form-check">
					<label class="form-check-label"
						for="flexCheckDefault">순위</label>
				</div></th>

			<th scope="col">제목</th>
			<th scope="col">조회수</th>
			<th scope="col">카테고리</th>
		</tr>
	</thead>
	<tbody>
		<tr id="memberInfo" style="cursor: pointer;">
			<th scope="row">
				<div class="form-check">
				<label class="form-check-label"
						for="flexCheckDefault"> 1 </label>
				</div>
			</th>
			<td>안읽씹하는 남자친구의 심리</td>
			<td>200</td>
			<td>심리글</td>
		</tr>
		<tr>
			<th scope="row">
				<div class="form-check">
				<label class="form-check-label"
						for="flexCheckDefault"> 2 </label>
				</div>
			</th>
			<td>짱구심리테스트</td>
			<td>135</td>
			<td>심리테스트</td>
		</tr>
		<tr>
			<th scope="row">
				<div class="form-check">
					<label class="form-check-label"
						for="flexCheckDefault"> 3 </label>
				</div>
			</th>
			<td>삼겹살 먹자고 했는데 돈이 없대요 무슨 의미일까요?</td>
			<td>110</td>
			<td>심리글</td>
		</tr>
	</tbody>
</table>
<hr />

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