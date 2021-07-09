<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
   content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.83.1">
<title>Signin Template · Bootstrap v5.0</title>
<!-- Bootstrap CDN -->
<link
   href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
   rel="stylesheet"
   integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
   crossorigin="anonymous">
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
   src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<script
   src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
   integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
   crossorigin="anonymous"></script>
<link rel="canonical"
   href="https://getbootstrap.com/docs/5.0/examples/sign-in/">
<link href="/simri/css/login.css" rel="stylesheet">
<link href="/simri/css/signin.css" rel="stylesheet">





<style>
.bd-placeholder-img {
   font-size: 1.125rem;
   text-anchor: middle;
   -webkit-user-select: none;
   -moz-user-select: none;
   user-select: none;
}

@media ( min-width : 768px) {
   .bd-placeholder-img-lg {
      font-size: 3.5rem;
   }
}
</style>


<!-- Custom styles for this template -->
</head>
<body class="text-center">

   <main class="form-signin">
      <form id="adminLogin">
         <img class="rounded-circle ms-3 me-4" src="/simri/img/admin.png" style="width: 150px; height: 150px;" alt="admin image" >
         <h1 class="h3 mb-3 fw-normal">관리자 로그인</h1>

         <div class="form-floating">
            <input type="text" class="form-control" id="id"
               placeholder="name@example.com"> <label for="floatingInput">아이디</label>
         </div>
         <div class="form-floating">
            <input type="password" class="form-control" id="pwd"
               placeholder="Password"> <label for="floatingPassword">Password</label>
         </div>

         <button class="w-100 btn btn-lg btn-primary" type="button" id="signBtn">Login</button>
      </form>
   </main>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
//로그인
$('#signBtn').click(function(){
   
   
   if($('#id').val() == ''){
      alert('아이디를 입력하세요');
      
   }else if($('#pwd').val() == ''){
      alert('비밀번호를 입력하세요');
   }else{
      $.ajax({
         type: 'post',
         url: '/simri/section/sign',
         data: {
            'id': $('#id').val(),
            'pwd': $('#pwd').val(),
         },
         dataType: 'text',
         success: function(data){
            //alert(data);
            if(data == 'success'){
               //alert('로그인 성공');
               location.href = '/simri/section/login';
            }else{
               alert('아이디 또는 비밀번호가 틀렸습니다 다시 확인해 주세요');
            }
            
         },error: function(err){
            console.log(err)
         }
      });
   }
   
});
</script>


</body>
</html>