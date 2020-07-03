<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 글상세</title>
<!-- include JQeury/CSS/JS -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/JS/jquery-3.4.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/JS/BOARD/boardDetail.js"></script>
<link
	href="${pageContext.request.contextPath}/resources/CSS/BOARD/boardDetail.css"
	rel="stylesheet">
</head>
<body>
	<%@ include file="../ALL/header_login.jsp"%>
	
	<div class="container">
		<h1>자유게시판</h1>
		<input type="button" value="글목록" class="btn"
			onclick="location.href='BOARD_boardList.do?curPage=${curPage }'">
		<table class="table table-bordered" class="shadow p-3 mb-5 bg-white rounded">
			
			<input type="hidden" value="${boardDetail.boardseq }"
				id="board-boardseq">
			<input type="hidden" value="${boardDetail.groupno }"
				id="board-groupno">
			<input type="hidden" value="${curPage }"
				id="board-curpage">
				
			<!-- 게시글 영역 -->
			<tbody>
				<tr>
					<th><div>제목</div></th>
					<td colspan="3">${boardDetail.title }</td>
				</tr>
				<tr>
					<th><div>작성자</div></th>
					<td colspan="3">${boardDetail.joinemail }</td>
				</tr>
				<tr>
					<th><div>작성일</div></th>
					<td colspan="3">${boardDetail.regdate }</td>
				</tr>
				<tr>
					<th><div>내용</div></th>
					<td colspan="3" id="board-content">${boardDetail.content }</td>
				</tr>
				<tr>
					<th>파일</th>
					<td colspan="3">
						<form action="download.do" method="post">
							<input type="text" name="name" value="${boardDetail.filepath }" readonly="readonly"/>
							<input type="submit" value="파일다운" class="btn" id="submit"/>
						</form>
					</td>
				</tr>
				
				<!-- eq : 로그인 기능 완성되면 로그인 세션 이메일로 바꿔야 됨 -->
				<c:choose>
					<c:when test="${boardDetail.joinemail eq login.joinemail }">
						<tr>
							<td colspan="4"><span class="board-update-delete">
							<a href="#" onclick="location.href='BOARD_boardUpdateForm.do?boardseq=${boardDetail.boardseq }&curPage=${curPage }'">수정</a> |
							<a href="#" onclick="deleteAlert('글');">삭제</a></span></td>
						</tr>
					</c:when>
				</c:choose>

			</tbody>

			<!-- 댓글 영역 -->
			<tfoot>
				<tr>
					<td colspan="4" class="reply-label">댓 글</td>
				</tr>
				<tr class="reply-area">
					<td colspan="4">
						<div class="reply-insert-area">
							<input type="text" class="form-control"
								placeholder="바르고 고운말을 사용합시다." aria-label="Recipient's username"
								aria-describedby="button-addon2"
								onkeydown="onKeyDown(${boardDetail.boardseq }, ${boardDetail.groupno });">
							<div class="input-group-append">
								<button class="btn btn-outline-secondary" type="button"
									id="button-addon2"
									onclick="replyInsert(${boardDetail.boardseq });">입  력</button>
							</div>
						</div>
					</td>
				</tr>

				<!-- eq & rereply 함수 : 로그인 기능 완성되면 로그인 세션 이메일로 바꿔야 됨 -->
				<c:forEach items="${replyList }" var="reply">
					<tr class="reply">
						<th class="reply-email">${reply.joinemail }</th>
						<td class="reply-content">${reply.content }</td>
						<td class="reply-update-delete">
						<c:choose>		
								<c:when test="${reply.joinemail eq login.joinemail }">
									<span><a href="#" onclick="deleteAlert('댓글', ${reply.boardseq });">삭제</a></span>
								</c:when>
								<c:otherwise>
									<span><a href="#" onclick="rereply('${reply.joinemail }', ${reply.boardseq }); " >답글</a></span>
								</c:otherwise>
							</c:choose>
						</td>
						<td class="reply-date"><fmt:formatDate value="${reply.regdate}" pattern="yy-MM-dd HH:mm" /></td>
					</tr>
				</c:forEach>

			</tfoot>
		</table>
	</div>

	<!-- 모달 영역 -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Modal title</h4>
				</div>
				<div class="modal-body">...</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" id="yes-btn"
						onclick="boardDelete(${boardDetail.boardseq });">예</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">아니오</button>
				</div>
			</div>
		</div>
	</div>

</body>
</html>