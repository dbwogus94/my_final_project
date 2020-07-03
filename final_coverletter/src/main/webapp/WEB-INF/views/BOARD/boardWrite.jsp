<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 글작성</title>
<%@ include file="../ALL/header_login.jsp"%>

<!-- include JQeury/CSS/JS -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/JS/jquery-3.4.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/JS/BOARD/boardWrite.js"></script>
<link
	href="${pageContext.request.contextPath}/resources/CSS/BOARD/boardWrite.css"
	rel="stylesheet">

<!-- include summernote -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.16/dist/summernote.min.css"
	rel="stylesheet">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.16/dist/summernote.min.js"></script>

</head>
<body>
	<div class="container">
		<h1>자유게시판</h1>

		<form method="post" action="BOARD_boardWrite.do" enctype="multipart/form-data">

			<div class="board-title">
				<h2>제목</h2>
				<input type="text" placeholder="제목을 입력하세요." name="title" id="title" class="form-control">
			</div>

			<div class="board-write">
				<h2>내용</h2>
				<textarea rows="100" cols="100" class="summernote" name="content"></textarea>
			</div>
			
			<div class="fileInput">
				<input type="file" name="uploadFile" id="fileupload"/>
			</div>

			<div id="btn-group">
				<input type="button" value="작성" class="btn" onclick="boardWrite();">
				<input type="button" value="취소" class="btn"
					onclick="location.href='BOARD_boardList.do'">
			</div>
		</form>
	</div>

	<!-- 모달 영역 -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					
					<h4 class="modal-title" id="myModalLabel">Modal title</h4>
				</div>
				<div class="modal-body">...</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">확인</button>
					
				</div>
			</div>
		</div>
	</div>

</body>
</html>