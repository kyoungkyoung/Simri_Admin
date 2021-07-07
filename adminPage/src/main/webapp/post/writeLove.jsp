<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 메인 화면 -->

<input type="hidden" id="pg" value="${pg}">
<input type="hidden" id="comCategory" value="연애 심리글">
<input type="hidden" id="DHL1" value="${DHL1}">

<h3>
	연애 심리글
	<button type="button" id="adBtn" class="btn btn-outline-secondary float-right">광고등록</button>
	<button type="button" id="comDeleteBtn" class="btn btn-outline-secondary float-right mr-1">삭제</button>
	<button type="button" onclick="location.href='/simri/post/loveWriteForm'" class="btn btn-outline-secondary float-right mr-1">글쓰기</button>
	
</h3>
<div class="card shadow mb-3">
	<div class="form-check ml-3 mt-2 pt-2 mb-2">
 	<form class="d-flex">
		<input class="form-check-input" type="checkbox" value="" id="all" style="margin-top:18px;" onclick="checkAll(this)">
		
		
		<div class="btn-group">
            <select class="btn btn-sm btn-outline-secondary dropdown-toggle mb-3" id="DHL" aria-expanded="false">
               <option value="최신순">최신순</option>
               <option value="조회수">조회수</option>
               <option value="좋아요">좋아요</option>
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
			<form id="lovePostList">
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
<script src="../js/loveList.js"></script>
