<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!-- Blog entries-->
<div class="col-lg-12">
   <div class="card mb-4">
      <div class="card-header ">공지사항 등록</div>

      <form>
         <div class="form-group mb-3 mt-3"
            style="padding-left: 20px; padding-right: 20px">
            <select name="searchOption" id="searchOption" class="bg-light border-1 " style="width: 100%; border-color: lightgray">
                   <option value="">[전체 게시글]팔레트</option>
	               <option value="">[팔레트]빨강</option>
	               <option value="">[팔레트]파랑</option>
	               <option value="">[팔레트]초록</option>
	               <option value="">[팔레트]노랑</option>
	               <option value="">유머 게시판</option>
	               <option value="">연애 게시판</option>
	               <option value="">고민&상담 게시판</option>
            </select>
         </div>

         <div class="form-group mb-3"
            style="padding-left: 20px; padding-right: 20px">
            <label for="board_subject">제목</label> <input type="text"
               id="board_subject" name="board_subject" class="form-control" />
         </div>
         <div class="form-group mb-3"
            style="padding-left: 20px; padding-right: 20px">
            <label for="board_content">내용</label>
            <textarea id="board_content" name="board_content"
               class="form-control" rows="10" style="resize: none; height: 325px;"></textarea>
         </div>
         <div class="form-group mb-3"
            style="padding-left: 20px; padding-right: 20px">
            <label for="board_content">심리테스트 URL</label>
         <input type="text"
               id="board_subject" name="board_subject" class="form-control" />
         </div>
         <div class="form-group mb-3"
            style="padding-left: 20px; padding-right: 20px">
            <label for="board_file">첨부 이미지</label> <input type="file"
               id="board_file" name="board_file" class="form-control"
               accept="image/*" />
         </div>
         <div class="form-group mb-3"
            style="padding-left: 20px; padding-right: 20px">
            <div class="text-right">
               <button class="btn btn-outline-primary mb-3"
                  style="float: right; margin-right: 20px;">등록하기</button>
               <button type="reset" class="btn btn-outline-primary mb-3"
                  style="float: right; margin-right: 20px;">다시 쓰기</button>
            </div>
         </div>
      </form>

   </div>
</div>

