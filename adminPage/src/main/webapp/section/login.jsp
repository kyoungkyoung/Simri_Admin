<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>관리자 페이지</title>
<!-- Bootstrap CDN -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>

<!-- css -->
<link href="/simri/css/sidebar.css" rel="stylesheet">
<link href="/simri/css/footer.css" rel="stylesheet">
<body>	
	<!-- 상단 메뉴 -->
	<jsp:include page="/main/top.jsp" />
	
	<div class="container" style="margin-top:50px;">
		<div class="row">
		
			<!-- 메인 화면 -->
			<div class="col-sm-10" style="margin-top: 20px; margin-bottom:100px;">
				<c:if test="${empty display }">
					<jsp:include page="/chart/graph.jsp" />
				</c:if>
				<c:if test="${not empty display }">		
					<jsp:include page="${display }" />
				</c:if>
			</div>
			<!-- 사이드 메뉴 -->
			<div class="col-sm-2" style="margin-top: 20px">
				<jsp:include page="/main/side.jsp" />
			</div>
			
		</div> 
	</div>
	
	
<jsp:include page="/main/footer.jsp" />	
<script src="/simri/js/sidebar.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
//팝업창
$('#memberModify').click(function(){
	window.open('/simri/section/adminModify', 'ss', 'width=800 height=327 left=800 top=200 scrollbars=yes');
});
</script>
</body>
</html>