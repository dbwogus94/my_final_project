<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>취업센터</title>
<!-- include JQeury/CSS/JS -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/JS/jquery-3.4.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/JS/JOB/jobCenter.js"></script>
<link
	href="${pageContext.request.contextPath}/resources/CSS/JOB/jobCenter.css"
	rel="stylesheet">

<!-- web font icon -->
<link rel="stylesheet"
	href="https://pro.fontawesome.com/releases/v5.12.0/css/all.css">
	
</head>
<body>
	<%@ include file="../ALL/header_login.jsp"%>
	<div class="container">
		<h1>취업센터</h1>
		<div class="row" id="center-box">
			<div class="col-sm-4">
				<i class="fas fa-file-alt fa-5x"></i>
				<p>합격율을 높여주는</p>
				<p>자소서 작성이 필요하다면?</p>
				<button class="btn" onclick="location.href='USER_userCVwriteForm.do'">자기소개서</button>
			</div>

			<div class="col-sm-4">
				<i class="fas fa-file-powerpoint fa-5x"></i>
				<p>프로젝트 포트폴리오를</p>
				<p>10분만에 작성하려면?</p>
				<button class="btn" onclick="location.href='USER_userPFwrite.do'">포트폴리오</button>
			</div>
			<div class="col-sm-4">
				<i class="fas fa-microphone fa-5x"></i>
				<p>면접대비</p>
				<p>말하기 연습이 필요하다면?</p>
				<button class="btn" onclick="location.href='USER_speechForm.do'">스피치연습</button>
			</div>
		</div>
	</div>
</body>
</html>