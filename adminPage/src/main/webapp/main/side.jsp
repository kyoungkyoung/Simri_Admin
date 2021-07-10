<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
li{
	list-style: none;
}
</style>
<!-- 사이드 메뉴 -->
	<div class="flex-shrink-0 p-3 bg-white"
		style="width: 280px; height: 793px;">
		<div
			class="d-flex align-items-center pb-3 mb-3 link-dark text-decoration-none border-bottom">
			<svg class="bi me-2" width="30" height="24">
				<use xlink:href="#bootstrap" /></svg>
			<span class="fs-5 fw-semibold"><a class="link-dark rounded" style="text-decoration: none; color: black;">관리자 메뉴</a></span>
		</div>
			<li class="mb-1">
				<button class="btn btn-toggle align-items-center rounded collapsed"
					data-bs-toggle="collapse" data-bs-target="#dashboard1-collapse"
					aria-pressed="true">게시물 관리</button>
				<div class="collapse" id="dashboard1-collapse">
					<ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
						<li><a href="/simri/post/writeManage" class="link-dark rounded">심리테스트</a></li>
						<li><a href="/simri/post/writeLove" class="link-dark rounded">연애심리</a></li>
					</ul>
				</div>
			</li>
		
			<li class="mb-1">
				<button class="btn btn-toggle align-items-center rounded collapsed"
					data-bs-toggle="collapse" data-bs-target="#dashboard-collapse"
					aria-pressed="true">커뮤니티</button>
				<div class="collapse" id="dashboard-collapse">
					<ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
						<li><a href="/simri/community/community" class="link-dark rounded">커뮤니티 관리</a></li>
						<li><a href="/simri/community/singoCommunity" class="link-dark rounded">신고 커뮤니티 관리</a></li>
						<li><a href="/simri/community/singoReply" class="link-dark rounded">신고 댓글 관리</a></li>
					</ul>
				</div>
			</li>
			<li class="mb-1">
				<button class="btn btn-toggle align-items-center rounded collapsed"
					data-bs-toggle="collapse" data-bs-target="#orders-collapse"
					aria-expanded="false">회원관리</button>
				<div class="collapse" id="orders-collapse">
					<ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
						<li><a href="/simri/member/memberList" class="link-dark rounded">회원목록</a></li>

					</ul>
				</div>
			</li>

			<li class="mb-1">
				<button class="btn btn-toggle align-items-center rounded collapsed"
					data-bs-toggle="collapse" data-bs-target="#visit-collapse"
					aria-expanded="false">통계관리</button>
				<div class="collapse" id="visit-collapse">
					<ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
						<li><a href="/simri/chart/graph" class="link-dark rounded">통계</a></li>
						<li><a href="/simri/chart/hitInfo" class="link-dark rounded">카테고리별 순위</a></li>
					</ul>
				</div>
			</li>
			
			<li class="mb-1">
				<button class="btn btn-toggle align-items-center rounded collapsed"
					data-bs-toggle="collapse" data-bs-target="#ad-collapse"
					aria-expanded="false">광고관리</button>
				<div class="collapse" id="ad-collapse">
					<ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
						<li><a href="/simri/advertise/advertiseList" class="link-dark rounded">광고목록</a></li>
					</ul>
				</div>
			</li>
			<div class="border-top my-3"></div>
		</ul>
	</div>