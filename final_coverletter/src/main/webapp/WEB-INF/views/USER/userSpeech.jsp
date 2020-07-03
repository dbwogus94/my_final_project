<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스피치 연습</title>
<!-- include JQeury/CSS/JS -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/JS/jquery-3.4.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/JS/USER/userSpeech.js"></script>
<link
	href="${pageContext.request.contextPath}/resources/CSS/USER/userSpeech.css"
	rel="stylesheet">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/annyang/2.6.0/annyang.min.js"></script>
</head>
<body>
	<%@ include file="../ALL/header_login.jsp"%>


	<div class="container">
	 <h1>스피치 연습</h1>
	 
		<div class="row">
			<div class="col-md-12"></div>
		</div>

		<div class="row">
			<div class="select-div">
				<div class="form-group">
					<select class="form-control" id="sel1" onchange="formChange(this);">
						<option value="스피치연습">스피치연습</option>
						<option value="문답">문답</option>
					</select>
				</div>
			</div>
			<div class="row">
			<div id="timeDP">
				<div class="col-md-6" id="timer">
					<p id="timerP">타이머</p>
				</div>
				<div class="col-md-6" id="end">
					종료
				</div>
			</div>
			</div>
		</div>

		<div id="blank"></div>
		<div id="original">
			<div class="main">
				<div class="side"></div>
				<div class="center">

					<div class="internal">
						<fieldset class="speech-box">
							<legend class="legend" id="legend1">대본 </legend>
							<textarea id="korea" rows="15" cols="40" class="textarea"></textarea>
						</fieldset>
						<input type="button" onclick="nextQuestion();" value="다음 문제"
						class="button3 btn speech-btn" id="nextQuestion" /> 
						<input type="button"
						value="대본녹음" class="speech btn speech-btn" id="speech" onclick="speech_to_text()" />
						
					</div>

					<div class="internal_bewteen"></div>

					<div class="internal">
						<fieldset class="speech-box">
							<legend class="legend" id="legend2">연습</legend>
							<textarea id="pract" rows="10" cols="40" class="textarea"></textarea>
							<div id="answerRes"></div>
						</fieldset>
						<input type="button" value="연습녹음" class="speech btn speech-btn" id="answer"
						onclick="pract_speech_to_text()" /> <input type="button"
						value="확인" onclick="question();" id="quiz" class="button3 btn speech-btn" />
					</div>

				</div>
				<div class="side"></div>
			</div>

			<div id="blank"></div>

			<!-- 						<div class="internal_bewteen"> -->
			<!-- 						<button id="stop" onclick="stop()">Stop</button> -->
			<!-- 					</div> -->

			<div class="row" id="form">
				<div class="col-md-2"></div>
				<div class="col-md-8">
					<input type="hidden" id="randomSeq" />
					<!-- 문제에 대한 seq -->
					
					
				</div>
				<div class="col-md-2"></div>
			</div>
		</div>

		<div id="cloneDiv"></div>

		<div id="custom_button2" class="clone-btn-grp">
			<button class="button2" onclick="add_div();">
				 <span class="glyphicon glyphicon-plus"></span>
			</button>
			<button class="button2" id="button2" onclick="remove_div(this.id);">
				 <span class="glyphicon glyphicon-minus"></span>
			</button>
		</div>

		<div id="blank"></div>

	</div>

	<!-- DB에서 문제 COUNT 해온 값 저장 -->
	<input type="hidden" value="${count}" id="count" />


</body>
</html>