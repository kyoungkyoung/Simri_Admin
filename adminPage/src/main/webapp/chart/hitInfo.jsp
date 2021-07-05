<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<select class="btn btn-outline-danger dropdown-toggle mr-1" id="condition" aria-expanded="false" >
				<option value="seq">최신순</option>		
				<option value="hit">조회수</option>
				<option value="comlike">좋아요</option>
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
			<th scope="col">글번호</th>
			<th scope="col">카테고리</th>
			<th scope="col">제목</th>
			<th scope="col">조회수</th>
			<th scope="col">좋아요</th>
			<th scope="col">작성일</th>

		</tr>
</table>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="../js/hitInfo.js"></script>
<!-- <script>
//팝업창
$('#memberInfo').click(function(){
	window.open('/simri/section/memberView', 'ss', 'width=640 height=540 left=800 top=200 scrollbars=yes');
});// click
</script> -->