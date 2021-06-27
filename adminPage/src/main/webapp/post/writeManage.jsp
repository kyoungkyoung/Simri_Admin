<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 메인 화면 -->



<h3>
	글관리
	<button type="button" class="btn btn-outline-secondary float-right">삭제</button>
	<button type="button" onclick="location.href='/simri/post/writeForm'" class="btn btn-outline-secondary float-right mr-2">글쓰기</button>
	
</h3>
<div class="card shadow mb-3">
	<div class="form-check ml-3 mt-2 mb-2">
 	<form class="d-flex">
		<input class="form-check-input" type="checkbox" value=""
			id="flexCheckDefault" style="margin-top:25px;" >
		
		
		<div class="btn-group">
			<select class="btn btn-danger dropdown-toggle mr-1" type="button"
				id="dropdownMenuButton" data-bs-toggle="dropdown"
				aria-expanded="false"  style="margin-top:10px; margin-right: 10px; margin-bottom:13px;">
				<option>조회수</option>
				<option>좋아요</option>
			
			</select>
		</div>
		
		       
          <input class="form-control me-2" type="search" placeholder="제목입력" aria-label="Search" style="margin-top:10px; margin-left: 400px; margin-right: 10px; margin-bottom:10px;">
          <button class="btn btn-outline-success" type="submit" style="margin-top:10px; margin-right: 10px; margin-bottom:13px;">Search</button>
		
		
        </form>
	</div>
</div>


<div class="card shadow mb-5">
	<div class="card-body ">
		<h4 class="card-title">글목록</h4>
		<ul class="list-group list-group-flush">
			<li class="list-group-item"><input
				class="form-check-input me-1 pr-1" type="checkbox" value=""
				aria-label="..." style="margin-top:30px;"> <a href="#"
				class="list-group-item list-group-item-action">

					<div class="d-flex w-100 justify-content-between">
						<h5 class="mb-1">[글번호]210608</h5>
						<input type="hidden" id="seq" value="21"><!-- ${community.seq}넣어주기 -->
						<small class="text-muted">1 days ago</small>
					</div>

					<small class="text-muted"><strong>[100 P]</strong> 

						<button type="button"
							class="btn btn-outline-secondary float-right" onclick="location.href='/simri/chart/postGraphDetail'">통계</button>

						<button type="button"
							class="btn btn-outline-secondary float-right mr-1" onclick="location.href='/simri/post/postModify'">수정</button>

				</small>
			</a></li>

			
			
			
			
			
			
		</ul>
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
