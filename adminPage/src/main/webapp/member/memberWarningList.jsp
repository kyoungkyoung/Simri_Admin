<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<div class="tab-pane fade" id="warning" role="tabpanel" aria-labelledby="warning-tab">
<table class="table table-hover" id="memberWarningListTable">
   <thead>
      <tr>
         <th scope="col">
         	<div class="form-check">
               <input class="form-check-input" type="checkbox" value="" id="allWarning" onclick="checkAllWarning(this)">
               <label></label>
            </div>
         </th>
         <th scope="col">이름</th>
         <th scope="col">이메일</th>
         <th scope="col">팔레트</th>
         <th scope="col">포인트</th>
         <th scope="col">신고내역</th>
         <th scope="col">회원상태</th>
         <th scope="col">가입일</th>
      </tr>
   </thead>
</table>
<!-- 페이징 -->
<nav aria-label="Page navigation example">
      <ul class="pagination justify-content-center my-4" id="memberPagingDiv">
      </ul>
</nav>
<input type="hidden" id="pg" value="${pg}">

</div>




</body>
</html>