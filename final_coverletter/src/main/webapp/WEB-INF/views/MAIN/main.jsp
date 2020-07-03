<%@page import="java.util.ArrayList"%>
<%@page import="com.job.coverletter.model.company.dto.CompanyDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
<!-- include JQeury/CSS/JS -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/JS/jquery-3.4.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/JS/MAIN/main.js"></script>
<link
	href="${pageContext.request.contextPath}/resources/CSS/MAIN/main.css"
	rel="stylesheet">
	
	
<!-- include animate css -->	
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.2/animate.min.css">
 	
</head>



<body>

	<c:if test="${empty list_cnt20}">
		<c:set var="list_cnt20" value="<%=new ArrayList<CompanyDto>()%>" />
	</c:if>

	<c:choose>
		<c:when test="${empty login }">
			<%@ include file="../ALL/header_logout.jsp"%>
		</c:when>
		<c:otherwise>
			<%@ include file="../ALL/header_login.jsp"%>
		</c:otherwise>
	</c:choose>

	<div class="container" style="background-color: #ebe6e6;">
		<div id="MaintopDiv">
			<h1 class="title animated  bounce delay-1s duration-3s">자소서 성공 패키지</h1>
		</div>
		
		<div class="company">
			<h5 class="h5" >- 웹 개발자 -</h5>

			<c:choose>
				<c:when test="${empty list_web}">
					<h3>--데이터가 비었습니다--</h3>
				</c:when>
				<c:otherwise>
					<c:forEach items="${list_web}" var="list_web">
						<div class="webItem">
							<div class="webItemTop">
								<a
									href="MAIN_mainDetail.do?companyseq=${list_web.companyseq }&groupno=${list_web.groupno}">
									<img class="companyImg2" src="${list_web.imgurl}" />
								</a>

							</div>
							<div class="webItemItemBottom">
								<div class="companyname" id="companyname">${list_web.companyname}</div>
								<div class="business">${list_web.business}</div>
							</div>
						</div>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</div>

		<div class="company">
			<h5 class="h5">- 프론트앤드 -</h5>
		<c:choose>
				<c:when test="${empty list_front}">
					<h3>--데이터가 비었습니다--</h3>
				</c:when>
				<c:otherwise>
					<c:forEach items="${list_front}" var="list_front">
						<div class="frontItem">
							<div class="frontItemTop">
								<a
									href="MAIN_mainDetail.do?companyseq=${list_front.companyseq }&groupno=${list_front.groupno}">
									<img class="companyImg2" src="${list_front.imgurl}" />
								</a>

							</div>
							<div class="frontItemBottom">
								<div class="companyname" id="companyname">${list_front.companyname}</div>
								<div class="business">${list_front.business}</div>
							</div>
						</div>

					</c:forEach>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="company">
			<h5 class="h5">- 백앤드 -</h5>
			<c:choose>
				<c:when test="${empty list_back}">
					<h3>--데이터가 비었습니다--</h3>
				</c:when>
				<c:otherwise>
					<c:forEach items="${list_back}" var="list_back">
						<div class="backItem">
							<div class="backItemTop">
								<a
									href="MAIN_mainDetail.do?companyseq=${list_back.companyseq }&groupno=${list_back.groupno}">
									<img class="companyImg2" src="${list_back.imgurl}" />
								</a>

							</div>
							<div class="backItemBottom">
								<div class="companyname" id="companyname">${list_back.companyname}</div>
								<div class="business">${list_back.business}</div>
							</div>
						</div>
					</c:forEach>
				</c:otherwise>
			</c:choose>

		</div>

		<article>
			<div class="totalCompany" id="totalCompany">

				<h5 class="h5">- 전체 -</h5>

				
				<c:choose>
					<c:when test="${empty list_cnt20}">
						<h5 class="h5">==================== 데이터가 없습니다. ===================</h5>
					</c:when>
					<c:otherwise>
						<c:forEach items="${list_cnt20}" var="companyDto">
							<div class="totalCompanyItem" id="totalCompanyItem">
								<div class="companyItemTop" id="companyItemTop">
									<a
										href="MAIN_main	Detail.do?companyseq=${companyDto.companyseq }&groupno=${companyDto.groupno}">
										<img class="companyImg2" src="${companyDto.imgurl}" />
									</a>

								</div>
								<div class="companyItemBottom">
									<div class="companyname" id="companyname">${companyDto.companyname}</div>
									<div class="business">${companyDto.business}</div>
								</div>
							</div>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</div>
		</article>
	
	</div>
	<div class="container" id="bottom">
		<div class="row">
			<div class="col-md-12">
				<input type="button" id="scrollButton" value="▽ 더보기" onclick="scrollPaging();">
			</div>
		</div>
	</div>
</body>
</html>