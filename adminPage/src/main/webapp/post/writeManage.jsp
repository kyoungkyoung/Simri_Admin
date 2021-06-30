<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 메인 화면 -->

<input type="hidden" id="pg" value="${pg}">
<input type="hidden" id="category" value="심리 테스트">

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
		
		       
          <input class="form-control me-2" type="search" id="postSearchText" placeholder="제목입력" aria-label="Search" style="margin-top:10px; margin-left: 400px; margin-right: 10px; margin-bottom:10px;">
          <button class="btn btn-outline-success" type="button" id="postSearchBtn" style="margin-top:10px; margin-right: 10px; margin-bottom:13px;">Search</button>
		
		
        </form>
	</div>
</div>


<div class="card shadow mb-5">
	<div class="card-body ">
		<h4 class="card-title">글목록</h4>
		<ul class="list-group list-group-flush">
			<form id="simriPostList">
			</form>
		</ul>
	</div>
</div>


<!-- 페이징 -->
<nav aria-label="Page navigation example">
      <ul class="pagination justify-content-center my-4" id="postPagingDiv">
      </ul>
</nav>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="../js/postList.js"></script>
