<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>채용공고 상세보기</title>
<!-- include JQeury/CSS/JS -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/JS/jquery-3.4.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/JS/JOB/jobDetail.js"></script>
<link href="${pageContext.request.contextPath}/resources/CSS/JOB/jobDetail.css" rel="stylesheet">

</head>
<body>
	<c:choose>
		<c:when test="${empty login }">
			<%@ include file="../ALL/header_logout.jsp"%>
		</c:when>
		<c:otherwise>
			<%@ include file="../ALL/header_login.jsp"%>
		</c:otherwise>
	</c:choose>
	
	<div id="All">
		<input type="hidden" id="companyseq" value="${companydto.companyseq }"/>

		<div class="container" id="main">
			<div class="container" id=null></div>
				<div class="row" id="img">
					<div class="col-md-12">
						<div class="logo_img">
							<img class="img" src="${companydto.imgurl }">
						</div>
					</div>
					<div class="row" id="companyname">
						<div class="col-md-1"></div>
						<div class="col-md-10">${companydto.companyname }</div>
						<div class="col-md-1"></div>
					</div>
				</div>

				<div class="row" id="oneintro">
					<div class="col-md-1"></div>
					<div class="col-md-10">${companydto.oneintro }</div>
					<div class="col-md-1"></div>
				</div>
				<br/>
				<div class="row">
					<div class="col-md-2"></div>
					<div class="col-md-8">
						<div>
							<h5><b>채용 분야</b></h5>
							<h4>${companydto.business }</h4>
					
							<b>경력</b> <span>${companydto.target }</span><br/>
							<b>연봉</b> <span>${companydto.salary }</span><br/> 
							
							<h5><b>필요 스펙</b></h5>
							<h5>${companydto.languages }</h5>

						</div>
					</div>
					<div class="col-md-2"></div>
				</div>
				<c:if test="${not empty login }">
					<div class="row">
						<div class="col-md-12">
							<div class="bookmark" id="button">
								<input type="button" id="bookmarkBtn" class="btn btn-success" value="회사 즐겨찾기" onclick="bookmark('${companydto.companyseq }');">
							</div>
						</div>
					</div>
				</c:if>				
				<br/>
			</div>	
			<br/>
			<div class="container" id="companyContainer">
				
				<br/>
				<br/>
				<div class="row">
					<div class="col-md-1"></div>
					<div class="col-md-10">
						<h4><b>기업소개</b></h4>
					</div>
					<div class="col-md-1"></div>
				</div>
				
				<div class="row">
					<div class="col-md-1"></div>
					<div class="col-md-10">
						<div class="companyBody">
							${companydto.intro }
						</div>
					</div>
					<div class="col-md-1"></div>
				</div>
				
				<br/>
				<br/>
				<div class="row">
					<div class="col-md-1"></div>
					<div class="col-md-10">
						<h4><b>주요업무</b></h4>
					</div>
					<div class="col-md-1"></div>
				</div>
				<div class="row">
					<div class="col-md-1"></div>
					<div class="col-md-10">
						<div class="companyBody">
							${companydto.mainbusiness }
						</div>
					</div>
					<div class="col-md-1"></div>
				</div>
				<br/>
				<br/>
				<div class="row">
					<div class="col-md-1"></div>
					<div class="col-md-10">
						<h4><b>채용 상세정보</b></h4>
					</div>
					<div class="col-md-1"></div>
				</div>
				<div class="row">
					<div class="col-md-1"></div>
					<div class="col-md-10">
						<div class="companyBody">
							${companydto.jobdetail }
						</div>
					</div>
					<div class="col-md-1"></div>
				</div>
				
				<br/>
				<br/>
				<div class="row">
					<div class="col-md-1"></div>
					<div class="col-md-10">
						<h4><b>복지 혜택</b></h4>
					</div>
					<div class="col-md-1"></div>
				</div>
				<div class="row">
					<div class="col-md-1"></div>
					<div class="col-md-10">
						<div class="companyBody">
							<c:if test="${not empty companydto.givetool}">
								<div class="row">	
									<div class="col-md-2">
										<span class="welfare">개인장비</span>
									</div>
									<div class="col-md-10">
										${companydto.givetool }
									</div>
								</div>
							</c:if>
							<c:if test="${not empty companydto.selfgrowth}">
								<div class="row">	
									<div class="col-md-2">
										<span class="welfare">자기개발</span>
									</div>
									<div class="col-md-10">
										${companydto.selfgrowth }
									</div>
								</div>
							</c:if>
							<c:if test="${not empty companydto.mealtime}">
								<div class="row">	
									<div class="col-md-2">
										<span class="welfare">식사시간</span>
									</div>
									<div class="col-md-10">
										${companydto.mealtime }
									</div>
								</div>
							</c:if>
							<c:if test="${not empty companydto.holiday}">
								<div class="row">	
									<div class="col-md-2">
										<span class="welfare">연차휴가</span>
									</div>
									<div class="col-md-10">
										${companydto.holiday }
									</div>
								</div>
							</c:if>
							<c:if test="${not empty companydto.workinghour}">
								<div class="row">	
									<div class="col-md-2">
										<span class="welfare">근무형태</span>
									</div>
									<div class="col-md-10">
										${companydto.workinghour }
									</div>
								</div>
							</c:if>
							<c:if test="${not empty companydto.insurance}">
								<div class="row">	
									<div class="col-md-2">
										<span class="welfare">의료보험</span>
									</div>
									<div class="col-md-10">
										${companydto.insurance }
									</div>
								</div>
							</c:if>
						</div>
					</div>
					<div class="col-md-1"></div>
				</div>

				<br/>
				<br/>
				<div class="row">
					<div class="col-md-1"></div>
					<div class="col-md-10">
						<h4><b>기업 정보</b></h4>
					</div>
					<div class="col-md-1"></div>
				</div>
				<div class="row">
					<div class="col-md-1"></div>
					<div class="col-md-10">
						<div class="companyBody">
							<c:if test="${not empty companydto.incorporation}">
								<div class="row">	
									<div class="col-md-2">
										<span class="welfare">설립일</span>
									</div>
									<div class="col-md-10">
										${companydto.incorporation }
									</div>
								</div>
							</c:if>
							<c:if test="${not empty companydto.totalmember}">
								<div class="row">	
									<div class="col-md-2">
										<span class="welfare">구성원</span>
									</div>
									<div class="col-md-10">
										${companydto.totalmember }
									</div>
								</div>
							</c:if>
							<c:if test="${not empty companydto.homepage}">
								<div class="row">	
									<div class="col-md-2">
										<span class="welfare">홈페이지</span>
									</div>
									<div class="col-md-10">
										${companydto.homepage }
									</div>
								</div>
							</c:if>
							<c:if test="${not empty companydto.location}">
								<div class="row">	
									<div class="col-md-2">
										<span class="welfare">사무실위치</span>
									</div>
									<div class="col-md-10">
										${companydto.location }
									</div>
								</div>
							</c:if>
							<c:if test="${not empty companydto.mainfield}">
								<div class="row">	
									<div class="col-md-2">
										<span class="welfare">산업분야</span>
									</div>
									<div class="col-md-10">
										${companydto.mainfield }
									</div>
								</div>
							</c:if>
						</div>				
					</div>
					<div class="col-md-1"></div>
				</div>
				
				<br/>
				<br/>
			</div>		
	</div>
</body>
</html>