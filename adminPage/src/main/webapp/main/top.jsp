<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 탑 --%>
<nav class="navbar navbar-expand-md bg-dark navbar-dark fixed-top shadow-lg mb-6">
	<a class="navbar-brand" href="/simri/section/login">관리자페이지</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
	        data-target="#navMenu">
		<span class="navbar-toggler-icon"></span>        
	</button>
	<div class="collapse navbar-collapse" id="navMenu">
		<ul class="navbar-nav">
		</ul>
		
		<ul class="navbar-nav ml-auto">
			<li class="nav-item">
				<a href="#" class="nav-link" id="memberModify">정보수정</a>
			</li>
			<li class="nav-item">
				<a href="/simri/section/logout" class="nav-link">로그아웃</a>
			</li>
		</ul>
	</div>
</nav>

<br>
