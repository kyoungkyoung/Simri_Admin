<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!-- Blog entries-->
<div class="col-lg-12">
   <div class="card mb-4">
      <div class="card-header ">공지사항 등록</div>

      <form id="communityWriteForm" >
		<input type="hidden" id="category" name="category" value="[공지사항]"/>

         <div class="form-group mb-3"
            style="padding-left: 20px; padding-right: 20px">
            <label for="board_subject">제목</label>
            <input type="text" id="subject" name="subject" class="form-control" value="[공지사항]">
         </div>
     		
     	 <div id="subjectDiv"></div> 
         
         <div class="form-group mb-3"
            style="padding-left: 20px; padding-right: 20px">
            <label for="board_content">내용</label>
            <textarea id="content" name="content" class="form-control" rows="10" style="resize: none; height: 325px;"></textarea>
         <div id="contentDiv"></div>
         </div>
         
         <div class="form-group mb-3"
            style="padding-left: 20px; padding-right: 20px">
            <label for="board_file">첨부 이미지</label> 
            <input type="file"  name="img" class="form-control" />
         </div>
         
         <div class="form-group mb-3"
            style="padding-left: 20px; padding-right: 20px">
            <div class="text-right">
               <button type="reset" class="btn btn-outline-primary mb-3" style="float: right; margin-right: 20px;">다시 쓰기</button>
               <button type="button" class="btn btn-outline-primary mb-3" id="noticeBtn" style="float: right; margin-right: 20px;">등록하기</button>
            </div>
         </div>
         
      </form>

   </div>
</div>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="../js/communityList.js"></script>
