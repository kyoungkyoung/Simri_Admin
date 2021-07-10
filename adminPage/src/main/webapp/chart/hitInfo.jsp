<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<input type="hidden" id="pg" value="${pg}">
<input type="hidden" id="comCategory1" value="${comCategory1}">
<input type="hidden" id="condition1" value="${condition1}">
<!-- 메인 화면 -->
<div class="p-2">
	<h3>
		카테고리별  순위
	</h3>
</div>
<h4 style="margin-bottom: 0;">
	<div class="btn-group" style="margin-right: 490px; margin-top: 10px;">
		<div class="btn-group">
			<select class="btn btn-outline-danger dropdown-toggle mr-1" id="comCategory" aria-expanded="false" >
				<option value="comCategoryAll">전체목록</option>		
				<option value="심리테스트">심리테스트</option>
				<option value="연애심리글">연애심리글</option>
			</select>
		</div>
			
		<div class="btn-group">
			<select class="btn btn-outline-danger dropdown-toggle mr-1" id="condition" aria-expanded="false">
				<option value="seq">최신순</option>		
				<option value="hithit">조회수</option>
				<option value="likelike">좋아요</option>
			</select>
		</div>
	</div>
		
	
		<div class="btn-group mt-3 mb-2" role="group" aria-label="Basic outlined example">
		  <button type="button" id="day" class="btn btn-outline-danger">일간</button>
		  <button type="button" id="week" class="btn btn-outline-danger">주간</button>
		  <button type="button" id="month" class="btn btn-outline-danger">월간</button>
		</div>
	</h4>
	
<table class="table table-hover" id="hitInfoTable">
		<tr>
			<th scope="col" width="10%">글번호</th>
			<th scope="col" width="15%">카테고리</th>
			<th scope="col" width="40%">제목</th>
			<th scope="col" width="10%">조회수</th>
			<th scope="col" width="10%">좋아요</th>
			<th scope="col" width="15%">작성일</th>

		</tr>
</table>

<!-- 페이징 -->
<nav aria-label="Page navigation example">
      <ul class="pagination justify-content-center my-4" id="hitInfoPagingDiv">
      </ul>
</nav>


<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="../js/hitInfo.js"></script>