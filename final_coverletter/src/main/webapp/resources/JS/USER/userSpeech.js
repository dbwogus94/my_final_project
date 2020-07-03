function add_div() {
	var original = $("#original").clone();
	console.log(original);

	$("#cloneDiv").append(original);

}

////////////////////////////////////////////////// 추가하기

function remove_div(id) {
	var field = document.getElementById(id);
	var parent = field.parentNode;
	var bro = parent.previousSibling.previousSibling;
	console.log(bro);
	bro.lastChild.remove();
}

////////////////////////////////////////////////// 제거하기

$(document).ready(function(){
	
	var message = document.getElementById("message");
	var button = document.getElementById("speech");
	var korea = document.getElementById("korea"); // div
	var pract = document.getElementById("pract"); // div
	var isRecognizing = false;
})

	try {
		var recognition = new (window.SpeechRecognition
				|| window.webkitSpeechRecognition || window.mozSpeechRecognition || window.msSpeechRecognition)();
	} catch (e) {
		console.error(e);
	}
	
	recognition.lang = 'ko-KR'; // 한국어 인식.
	recognition.interimResults = false;
	recognition.maxAlternatives = 5;

// recognition.continuous = true;

function speech_to_text() {

	recognition.start();
	isRecognizing = true;

	recognition.onstart = function() {
		console.log("음성인식이 시작 되었습니다.")
		message.innerHTML = "음성인식 시작...";
		button.innerHTML = "Listening...";
		button.disabled = true;
	}

	recognition.onspeechend = function() {
		message.innerHTML = "버튼을 누르고 아무말이나 하세요.";
		button.disabled = false;
		button.innerHTML = "Start STT";
	}

	recognition.onresult = function(event) { // 인식된 음성이 있을 경우 실행
		console.log('You said: ', event.results[0][0].transcript);
		// 결과를 출력
		var resText = event.results[0][0].transcript;
		korea.textContent = resText;

		// text to sppech
		text_to_speech(resText);

	};

	recognition.onend = function() {
		message.innerHTML = "버튼을 누르고 아무말이나 하세요.";
		button.disabled = false;
		button.innerHTML = "Start STT";
		isRecognizing = false;

	}
}

function stop() { // 음성 인식 종료
	recognition.stop();
	message.innerHTML = "버튼을 누르고 아무말이나 하세요.";
	button.disabled = false;
	button.innerHTML = "Start STT";
	isRecognizing = false;

}

// Text to speech
function text_to_speech(txt) {
	// Web Speech API - speech synthesis
	if ('speechSynthesis' in window) {
		// Synthesis support. Make your web apps talk!
		console.log("음성합성을 지원하는  브라우저입니다.");
	}
	var msg = new SpeechSynthesisUtterance();
	var voices = speechSynthesis.getVoices();
	// msg.voice = voices[9]; // 두번째 부터 완전 외국인 발음이 됨. 사용하지 말것.
	msg.voiceURI = 'Google 한국의';
	msg.voiceURI = 'native';
	msg.volume = 1; // 0 to 1 볼륨
	msg.rate = 1.5; // 0.1 to 10 말하는속도
	// msg.pitch = 1.5; //0 to 2 음의 높이
	msg.text = txt;
	msg.lang = 'ko-KR';

	msg.onend = function(e) {
		if (isRecognizing == false) {
			recognition.start();
		}
		console.log('Finished in ' + event.elapsedTime + ' seconds.');
	};
	window.speechSynthesis.speak(msg);
}

// recognition.continuous = true;
////////////////////////////////////////////////////////////////////대본 음성부분
function pract_speech_to_text(){

	recognition.start();
	isRecognizing = true;

	recognition.onstart = function() {
		message.innerHTML = "음성인식 시작...";
		button.innerHTML = "Listening...";
		button.disabled = true;
	}

	recognition.onspeechend = function() {
		message.innerHTML = "버튼을 누르고 아무말이나 하세요.";
		button.disabled = false;
		button.innerHTML = "Start STT";
	}

	recognition.onresult = function(event) { // 인식된 음성이 있을 경우 실행
		console.log('You said: ', event.results[0][0].transcript);
		// 결과를 출력
		var resText = event.results[0][0].transcript;
		pract.textContent = resText;

		// text to sppech
		pract_text_to_speech(resText);

	};

	recognition.onend = function() {
		message.innerHTML = "버튼을 누르고 아무말이나 하세요.";
		button.disabled = false;
		button.innerHTML = "Start STT";
		isRecognizing = false;

	}
}

function stop() { // 음성 인식 종료
	recognition.stop();
	message.innerHTML = "버튼을 누르고 아무말이나 하세요.";
	button.disabled = false;
	button.innerHTML = "Start STT";
	isRecognizing = false;
}

// Text to speech
function pract_text_to_speech(txt) {
	// Web Speech API - speech synthesis
	if ('speechSynthesis' in window) {
		// Synthesis support. Make your web apps talk!
		console.log("음성합성을 지원하는  브라우저입니다.");
	}
	var msg = new SpeechSynthesisUtterance();
	var voices = speechSynthesis.getVoices();
	// msg.voice = voices[9]; // 두번째 부터 완전 외국인 발음이 됨. 사용하지 말것.
	msg.voiceURI = 'Google 한국의';
	msg.voiceURI = 'native';
	msg.volume = 1; // 0 to 1 볼륨
	msg.rate = 1.5; // 0.1 to 10 말하는속도
	// msg.pitch = 1.5; //0 to 2 음의 높이
	msg.text = txt;
	msg.lang = 'ko-KR';

	msg.onend = function(e) {
		if (isRecognizing == false) {
			recognition.start();
		}
		console.log('Finished in ' + event.elapsedTime + ' seconds.');
	};
	window.speechSynthesis.speak(msg);
}

//////////////////////////////////////////////연습 음성부분

$(function(){ // 타이머
	var x;
	console.log("randomSeq:"+$("#randomSeq").val());
	
	$("#timer").click(function(){
		var time = 60;
		var min = "";
		var sec = "";
		
		x = setInterval(function(){
		min = parseInt(time/60);
		sec = time%60;
			
		document.getElementById("timerP").textContent = min + "분" + sec + "초";
			time--;
			 
			if(time < 0) {
				clearInterval(x);
				document.getElementById("timerP").textContent = "타이머";
				$("#timerP").css("color","black");
			}else if(time <= 30 ){
				$("#timerP").css("color","red");
			}
		},1000);
	});
	
	$("#end").click(function(){
		$("#timerP").html("타이머");
		$("#timerP").css("color","black");
		clearInterval(x);
		
	});
	
	$("#nextQuestion").hide();
	$("#quiz").hide(); //다음문제
	
	
})
///////////////////////////////////////////////////////////타이머


function fristQuestion(){ // 맨 처음 문제 뿌리기
	var question = $("#question");
	console.log(question);
	var count = $("#count").val();
	console.log("count: "+count);
	var random = Math.floor(Math.random() * (count-1))+1;
	$("#randomSeq").val(random);
	console.log("random: "+random);
	var randomSeq = {
			"qnaboardseq" : random
	};
	
	$.ajax({
		type: "post",
		url: "USER_question.do",
		data: JSON.stringify(randomSeq),
		contentType: "application/json",
		dataType: "text",
		success: function(data){
			$("#korea").html(data);
		},
		error: function(){
			alert("통신실패");
		}
	});
}

/////////////////////////////////////////////처음 문제 뿌리기

function nextQuestion(){//다음 문제 뿌리기
	var count = $("#count").val();
	var random = Math.floor(Math.random() * (count-1))+1;
	var inputSeq = $("#randomSeq").val();
	
	if(random === inputSeq){
		random = Math.floor(Math.random() * (count-1))+1;
	} else {
		var randomSeq = {
				"qnaboardseq" : random
		};
		$.ajax({
			type: "post",
			url: "USER_question.do",
			data: JSON.stringify(randomSeq),
			contentType: "application/json",
			dataType: "text",
			success: function(data){
				$("#korea").html(data);
			},
			error: function(){
				alert("통신실패");
			}
		});
	}
}

///////////////////////////////////////////다음 문제 뿌리기

function question(){ //정답 맞추기
	
	
	var anvalue = { 
			"answer" : $("#pract").val(),
			"qnaboardseq" : $("#randomSeq").val()
	};
	console.log(anvalue);
//	location.href="USER_question.do?anvalue="+anvalue;
	$.ajax({
		type : "post",
		url : "USER_answer.do",
		data : JSON.stringify(anvalue),
		contentType: "application/json",
		dataType: "json",
		success : function(data){
			console.log("통신됌 "+ data.result);
			$.each(data , function(key,value){
				if(data.result === "정답"){
					console.log(data.result);
					$("#answerRes").css("color","blue");
					$("#answerRes").html(data.result+'<br/>'+data.answer);
				}else {
					console.log(data.result);
					$("#answerRes").css("color","red");
					$("#answerRes").html(data.result+'<br/>'+data.answer);
				}
			});
			
		},
		error : function() {
			alert("통신안됌");
		}
	});
}

///////////////////////////정답 맞추기

function formChange(select) {
	var chk = select.options[select.selectedIndex].value
	
	if(chk === "스피치연습"){
		$("#korea").html("");
		$("#pract").html("");
		$("#legend1").html("대본");
		$("#legend2").html("연습");
		$("#speech").val("대본녹음");
		$("#answer").val("스피치연습");
		$("#speech").attr({"onclick":"speech_to_text();"});
		$("#answer").attr({"onclick":"pract_speech_to_text();"});
		$("#nextQuestion").hide();
		$("#quiz").hide(); //다음문제 , 확인버튼 하이드
		$("#custom_button2").show(); //+- clone 기능 버튼 show
	} else {
		$("#cloneDiv").children().remove()
		$("#custom_button2").css("display","none"); //+- clone 기능 버튼 hide
		$("#nextQuestion").show();
		$("#quiz").show(); //다음문제 , 확인버튼 하이드
		fristQuestion();
		$("#legend1").html("문제");
		$("#legend2").html("정답");
		$("#pract").html("");
		$("#speech").val("정답녹음");
		$("#answer").val("정답확인");
		$("#speech").attr({"onclick":"pract_speech_to_text();"});
		$("#answer").attr({"onclick":"question();"});
	}
	///////////////////////////////////////////////////////////////////폼 바꾸기
}


