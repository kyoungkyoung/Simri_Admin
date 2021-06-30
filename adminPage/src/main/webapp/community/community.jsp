<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 메인 화면 -->



<h3>
	커뮤니티 관리
	<button type="button" class="btn btn-outline-secondary float-right" id="comDeleteBtn">삭제</button>
	<button type="button" onclick="location.href='/simri/community/communityWriteForm'" class="btn btn-outline-secondary float-right mr-2">공지사항 등록</button>
	
</h3>

<input type="hidden" id="pg" value="${pg}">
<input type="hidden" id="comCategory1" value="${comCategory1}">
<input type="hidden" id="image" value="${image}">

<div class="card shadow mb-3 mt-3">
	<div class="form-check ml-3 mt-2 pt-2">
	 	<form class="d-flex">
			<input class="form-check-input " type="checkbox" value="" id="all" style="margin-top:12px;" onclick="checkAll(this)">
				<div class="btn-group">
					<select class="btn btn-white dropdown-toggle mb-3" id="comCategory" aria-expanded="false">
					   <option value="[전체 게시글]팔레트">[전체 게시글]팔레트</option>
		               <option value="[팔레트]빨강">[팔레트]빨강</option>
		               <option value="[팔레트]파랑">[팔레트]파랑</option>
		               <option value="[팔레트]초록">[팔레트]초록</option>
		               <option value="[팔레트]노랑">[팔레트]노랑</option>
		               <option value="유머 게시판">유머 게시판</option>
		               <option value="연애 게시판">연애 게시판</option>
		               <option value="고민&상담 게시판">고민&상담 게시판</option>
		               <option value="[공지사항]">[공지사항]</option>
					</select>
				</div>
	         <input class="form-control me-2" type="search" placeholder="닉네임입력" value="${comSearchText }" id="comSearchText" aria-label="Search" style="margin-left: 400px; margin-right: 10px; margin-bottom:13px;">
	         
	         <button class="btn btn-outline-danger" type="button" id="comSearchBtn" style="margin-right: 10px; margin-bottom:13px;">Search</button>
        </form>
	</div>
</div>

<div class="card shadow mb-5">
	<div class="card-body ">
		
		<h4 class="card-title">글목록</h4>
		
		<ul class="list-group list-group-flush">
			<form id="communityList">
		
			
			</form>
		</ul>
	</div>
</div>

<!-- 페이징 -->
<nav aria-label="Page navigation example">
      <ul class="pagination justify-content-center my-4" id="communityPagingDiv">
      </ul>
</nav>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="../js/communityList.js"></script>

