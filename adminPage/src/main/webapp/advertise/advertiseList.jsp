<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 메인 화면 -->
<input type="hidden" id="pg" value="${pg}"/>
<div class="p-2">
	<h3>
		광고목록
	</h3>
		<button type="button" id="adDeleteBtn" class="btn btn-outline-danger float-right mb-1">삭제</button>
</div>

	<div></div>
		<br>
  <table class="table table-hover" id="adTable">
	<thead>
		<tr>
			<th scope="col" width="11%">
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="" id="all" onclick="checkAll(this)"> 
						<label class="form-check-label" for="flexCheckDefault">글번호</label>
				</div>
			</th>
			<th scope="col" width="9%">포인트</th>
			<th scope="col" width="13%">카테고리</th>
			<th scope="col" width="25%">제목</th>
			<th scope="col" width="25%">이미지파일</th>
			<th scope="col" width="20%">광고 등록 날짜</th>
		</tr>
	</thead>
	
	
 </table>

<!-- 페이징 -->
<nav aria-label="Page navigation example">
      <ul class="pagination justify-content-center my-4" id="advertisePagingDiv">
      </ul>
</nav>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="../js/adList.js"></script>
