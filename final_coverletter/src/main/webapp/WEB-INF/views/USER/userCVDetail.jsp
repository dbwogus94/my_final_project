<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자기소개서 입력</title>
<%@ include file="../ALL/header_login.jsp"%>
<!-- include JQeury/CSS/JS -->
<script type="text/javascript"
   src="${pageContext.request.contextPath}/resources/JS/jquery-3.4.1.js"></script>
<script type="text/javascript"
   src="${pageContext.request.contextPath}/resources/JS/USER/userCVDetail.js"></script>
<link
   href="${pageContext.request.contextPath}/resources/CSS/USER/userCVDetail.css"
   rel="stylesheet">
   
<!-- include cross origin -->
<script type="text/javascript"
   src="${pageContext.request.contextPath}/resources/JS/jquery.ajax-cross-origin.min.js"></script>   
   
<!-- include -->   
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

<script src="https://html2canvas.hertzen.com/dist/html2canvas.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/JS/jspdf.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/JS/bluebird.min.js"></script>
	

<script type="text/javascript">


</script>
</head>
<body>

<div class="container">
	<div class="row">
		<button id="cmd" class="btn btn-success">PDF다운로드</button>
	</div>

	<div class="container" id="PDF_container">
		<div id="title">입 사 지 원  이 력 서</div>
		<br/>
	<div class="container" id="table_div">
		<div class="row" id="header">
			<table class="table table-bordered">
						<tr class="header-bar">
							<th>지원회사</th>
							<th>지원분야</th>
							<th>희망연봉</th>
							<th>입사구분</th>
						</tr>
						<tr>
							<td><input type="text" class="form-control" id="usr"></td>
							<td><input type="text" class="form-control" id="usr"></td>
							<td><input type="text" class="form-control" id="usr"></td>
							<td><input type="text" class="form-control" id="usr"></td>
						</tr>
				</table>
		</div>
		<br/>
		<div class="row">
			<h4>인적사항</h4>
			<table class="table table-bordered">
				<col width="100">
				<col width="100">
				<col width="100">
				<col width="100">
						<tr>
							<td>${totalDto.joinname }</td>
							<td>${totalDto.joinbirth }</td>
							<td>${totalDto.joinsex }</td>
							<td>${totalDto.joinemail }</td>
						</tr>
						<tr>
							<td>${totalDto.mililtary }</td>
							<td>${totalDto.phone }</td>
							<td colspan="2">${totalDto.address }</td>
						</tr>
			</table>
		</div>
		
		<div class="row">
			<h4>학력</h4>
			<table class="table table-bordered">
						<tr>
							<td>${totalDto.career }</td>
							<td>${totalDto.schoolname }</td>
							<td>${totalDto.admission }</td>
							<td>${totalDto.graduate }</td>
						</tr>
						<tr>
							<td colspan="2">${totalDto.major }</td>
							<td colspan="2">${totalDto.grade }</td>
						</tr>
			</table>
		</div>
		<br/>
		<div class="row">
			<h4>자격증</h4>
			<table class="table table-bordered">
				<col width="200">
				<col width="200">
				<col width="200">
				<tbody id="tbody_certificate">
					<tr>
						<th>자격증명</th>
						<th>발행기관</th>
						<th>취득일</th>
					</tr>
					<tr>
						<td class="certificate">${totalDto.certificate }</td>
						<td class="organization">${totalDto.organization }</td>
						<td class="regdate">${totalDto.regdate }</td>
					</tr>
				</tbody>	
			</table>
		</div>
		
		<div class="row">
			<h4>어학점수</h4>
			<table class="table table-bordered">
				<col width="200">
				<col width="200">
				<col width="200">
				<tbody id="tbody_language">
					<tr>
						<th>시험명</th>
						<th>점수</th>
						<th>취득일</th>
					</tr>
					<tr>	
						<td class="languagename">${totalDto.languagename }</td>
						<td class="languagescore">${totalDto.languagescore }</td>
						<td class="languageregdate">${totalDto.languageregdate }</td>
					</tr>
				</tbody>
			</table>
		</div>
		
		<div class="row">
			<h4>공모전</h4>
			<table class="table table-bordered">
				<col width="200">
				<col width="200">
				<col width="200">
				<tbody id="tbody_contest">
				<tr>
					<th>공모전명</th>
					<th>시행기관</th>
					<th>입상</th>
				</tr>
				<tr>
					<td class="contest">${totalDto.contest }</td>
					<td class="startorganization">${totalDto.startorganization }</td>
					<td class="prize">${totalDto.prize }</td>
				</tr>
				</tbody>
			</table>
		</div>
		<br/>
		<br/>
		<br/>
		<br/>
		<hr/>
		<div id="title">자 기 소 개 서</div>
	</div>
	<div id="whole">
		<form action="#">
			<c:forEach items="${CVDto }" var="dto" begin="1" step="1" varStatus="index">
				<c:if test="${index.first}">
					<div class="main_text">
						<div class="subtitle">
							<b style="font-size: 20px;">제목 : ${dto.title }</b><br/><br/>
							
							소제목 : ${dto.subtitle }<br/>
							질문 : ${dto.question }
						</div>
						<div class="line"></div>
						<div class="content">
							<textarea class="text" rows="20" cols="104">${dto.content }</textarea>
						</div>
					</div>
				</c:if>
				<div class="main_text">
					<div class="subtitle">
						소제목 : ${dto.subtitle }<br/>
						질문 : ${dto.question }
					</div>
					<div class="line"></div>
					<div class="content">
						<textarea class="text" rows="20" cols="104">${dto.content }</textarea>
					</div>
				</div>
			</c:forEach>
			
			
			<br>
			<br>
		</form>
	 </div>
	 </div>
	</div>
</body>
</html>