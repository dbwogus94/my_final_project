<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후원내역</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/JS/jquery-3.4.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/JS/PAY/payList.js"></script>
<link
	href="${pageContext.request.contextPath}/resources/CSS/PAY/payList.css"
	rel="stylesheet"></head>
<body>
	<%@ include file="../ALL/header_login.jsp"%>

	<div class="container">
		<!-- 글목록 영역 -->
		<div class="board-list">
			<h1> 후원내역 </h1>

				<table class="table table-bordered">
					

					<thead>
						<!-- 테이블 : 검색 영역 -->
						<tr>
							<td>
								<div class="search-label">검색</div>
							</td>
							<td colspan="4" class="search-form">
								<div class="search-select">
									<select class="form-control form-control-sm"
										name="search-category" id="search-category">
										<option value="title">제목</option>
										<option value="content">본문</option>
									</select>
								</div>
								<div class="search-input">
									<input type="text" class="form-control form-control-sm"
										name="keyword" id="keyword" onkeydown="onKeyDown();">
								</div>
								<div class="search-btn-group">
									<button class="btn btn-sm btn-primary" id="search-btn"
										onclick="search();">검색</button>
								</div>
							</td>
						</tr>

						<!-- 테이블 : 게시글 목록 영역 -->
						<tr class="header-bar">
							<th>회사</th>
							<th>회원 id</th>
							<th>결제 수단</th>
							<th>결제 금액</th>
							<th>부과세</th>
							<th>결제 내용</th>
							<th>후원금액</th>
							<th>결제시간</th>
						</tr>
					</thead>

					<tbody>
						<c:choose>
							<c:when test="${empty boardList }">
								<tr>
									<td colspan="5" id="boardlist-null">작성된 글이 없습니다.</td>
								</tr>
							</c:when>
							<c:otherwise>
								<c:forEach items="${boardList }" var="dto">
									<tr>
										<td>${dto.partner_order_id}</td>
										<td>${dto.joinemail}</td>
										<td>${dto.payment_method_type}</td>
										<td>${dto.amount_total}원</td>
										<td>${dto.amount_tax_free}원</td>
										<td>${dto.item_name}</td>
										<td>${dto.quantity}원</td>
										<td><fmt:formatDate
												value="${dto.created_at}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
									</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
		</div>
		<!-- 글목록 영역 끝 -->

		<!-- 페이징 영역 -->
		<nav aria-label="Page navigation" id="paging-nav">
			<ul class="pagination">
				<c:if test="${pagination.curRange ne 1 }">
					<li onClick="paging(1)"><a href="#" aria-label="Previous">
							<span aria-hidden="true">처음</span>
					</a></li>
				</c:if>
				<c:if test="${pagination.curPage ne 1}">
					<li onClick="paging('${pagination.prevPage }')"><a href="#"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
					</a></li>
				</c:if>
				<c:forEach var="pageNum" begin="${pagination.startPage }"
					end="${pagination.endPage }">
					<c:choose>
						<c:when test="${pageNum eq  pagination.curPage}">
							<li onClick="paging('${pageNum }')"><a href="#"
								class="paging-focus">${pageNum }</a></li>
						</c:when>
						<c:otherwise>
							<li onClick="paging('${pageNum }')"><a href="#">${pageNum }</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:if
					test="${pagination.curPage ne pagination.pageCnt && pagination.pageCnt > 0}">
					<li onClick="paging('${pagination.nextPage }')"><a href="#"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span>
					</a></li>
				</c:if>
				<c:if
					test="${pagination.curRange ne pagination.rangeCnt && pagination.rangeCnt > 0}">
					<li onClick="paging('${pagination.pageCnt }')"><a href="#"
						aria-label="Next"> <span aria-hidden="true">마지막</span>
					</a></li>
				</c:if>

			</ul>
		</nav>
		<!-- 페이징 영역 끝 -->
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