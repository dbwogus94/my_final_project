var idx = 1;

/*---------- cv-container 하나만 있으면 삭제불가 : removeBtn func ----------*/
$(function() {
	removeBtn ();
});

function removeBtn () {
	var removeBtn =  document.querySelectorAll('.remove-btn');
	if(removeBtn.length == 1){
		$(removeBtn).attr('disabled', true);
	} else {
		$(removeBtn).attr('disabled', false);
	}
}

/*---------- cv-container 복제 : add func ----------*/
function add() {
	// 마지막 cv-container를 복제
	var lastCVcontainer = $('.cv-container').last();
	var cloneElements = $(lastCVcontainer).clone(false);

	// 마지막 cv-container에 추가
	lastCVcontainer.after(cloneElements);

	// CLONE : 소제목 영역, 작성영역 clear & button 활성화
	cloneElements.find('input[type=text]').val('');
	cloneElements.find('textarea').val('');
	cloneElements.find('.cv-spell').text('');
	cloneElements.find('#cntArea-a').text('0');
	cloneElements.find('#cntArea-b').text('0');
	cloneElements.find('.remove-btn').attr('disabled', false);
	
	// insert path 지정 
	cloneElements.find('input[id=title]').attr('name', 'targets[' + idx + '].title');
	cloneElements.find('input[id=subtitle]').attr('name', 'targets[' + idx + '].subtitle');
	cloneElements.find('select[id=question]').attr('name', 'targets[' + idx + '].question');
	cloneElements.find('textarea[id=content]').attr('name', 'targets[' + idx + '].content');
	
	idx++;
	removeBtn();
}

/*---------- cv-container 삭제 : remove func ----------*/
function remove(btn) {
	// 누른 버튼의 상위 cv-container 찾아서 삭제
	var btn = btn;
	var thisElements = $(btn).parents('.cv-container');
	thisElements.remove();
	removeBtn();
}

/*---------- 글자수 세기 : contentCnt func ----------*/
function contentCnt(textarea) {
	var thisElement = textarea;
	var cntRes = $(thisElement).val();
	var parent = $(thisElement).parents('.cv-container');

	// 공백포함
	var cntAreaA = $(parent).find('#cntArea-a');
	$(cntAreaA).text(cntRes.length);

	// 공백제거
	var cntAreaB = $(parent).find('#cntArea-b');
	var cntResTrim = cntRes.replace(/ /g, '');
	$(cntAreaB).text(cntResTrim.length);
}

/*---------- 맞춤법 검사 : spellCheck func ----------*/
function spellCheck(btn) {
	console.log('ajax start!');
	
	// 보낼 데이터 (맞춤법 검사할 데이터)
	var thisElement = btn;
	var parent = $(thisElement).parents('.cv-container');
	// 입력영역
	var ta = $(parent).find('textarea');
	var checkData = ta.val();
	// 검사영역
	var sd = $(parent).find('.cv-spell');
	// 오류어, 수정어
	var token;
	var suggestions = [];
	
	// 검사마다 데이터 쌓이는 것 방지 (clear)
	sd.text('');
	
	// node server로 보내기
	$.ajax({
		type : 'post',
		url : 'http://127.0.0.1:3003/spellCheck/',
		data : checkData,
		crossOrigin : true,
	    crossDomain : true,
		dataType: 'json',
		beforeSend:function(){
			$('#myModal').modal('show');
		},
		success : function(data) {
			console.log('통신성공');
			console.log('넘어오는 데이터 : ' + data);
			$('#myModal').modal('hide');
			
			if(data == null || data.length == 0){
				sd.append("<p class='non-err'>오류가 없습니다.</p>");
			}
			
			$.each(data, function(idx, obj) {
				console.log('idx = ' + data[idx]);
				$.each(obj, function(key, value) {
					/*
					 * -- KEY --
					 * token : 오류
					 * suggestions : 교정어
					 * info : 맞춤법 검사 결과 설명
					 * */
				
					if(key == 'token'){
						token = value;
					}
					
					if(key == 'suggestions'){
						 suggestions = value;
						 console.log(typeof(suggestions));
						 
						 // 검사결과 버튼 생성
						 for(var i = 0; i < suggestions.length; i++){
							 sd.append
							 		("<div class='sugg-div'>" 
									 + "<input class='sugg-value' type='hidden' value='" + token + "'>"
							 		 + "<button class='btn sugg-btn' type='button' name='" + token + "'>"
									 + suggestions[i]
							         + "</button></div>");
						 }
					}
					
				});
			 });
			
		},
		error : function(request, status, error) {
			console.log('통신실패');
			console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}

	});
};
/*---------- 맞춤법검사 : 검사결과 영역 버튼 클릭했을 때  ----------*/
$(function() {
	$(document).on("click",".sugg-btn",function(){  
		console.log('버튼 누름');
		// 보낼 데이터 (맞춤법 검사할 데이터)
		var thisElement = this;
		var parent = $(thisElement).parents('.cv-container');
		// 입력영역 -> 영역 안 데이터
		var ta = $(parent).find('textarea');
		var checkData = ta.val();
		
		// 오류어
		var token = $(thisElement).attr('name');
		
		// 수정어
		var suggestion = $(thisElement).text();
		// 누른 수정어는 검사영역에서 삭제
		var clickSugg = $('.sugg-value[value=' + $.escapeSelector(token) + ']');
		var clickSuggParent = clickSugg.parents('.sugg-div');
		clickSuggParent.remove();
		
		// 오류어 -> 수정어
		checkData = checkData.replace(token, suggestion);
		console.log('변경 후 : ' + checkData);
		ta.val(checkData);
	});
});

/*---------- Toasts : bootstrap4 toast ----------*/
$(function() {
	$(".toast-question").change(function(){
	    var selected = $("option:selected", this);
	    
	    // toast 속성
		$('.toast').toast({
			delay: 9000
		});
		
		// 기본
	    if(selected.parent()[0].id == "one"){
	    	$('.toast-body').html('이 항목은 회사마다 달라야합니다. <br/> 질문의 의도에 맞게 <b>핵심</b> 위주로 대답하는 것이 좋습니다.');
	    	$('.toast').toast('show');
	    
	    // 개인	
	    } else if(selected.parent()[0].id == "two"){
	    	$('.toast-body').html('지원자와 관련된 것을 물어보는 의도를 잘 생각해봅시다. <br/> 나의 인생 전체를 구술하기보다 기업과 직무에 연관되는 <b>특정한 사건, 인물 위주</b>로 작성하는 것이 좋습니다.');
	    	$('.toast').toast('show');
	    	
	    // 직무역량 
	    } else if(selected.parent()[0].id == "three"){
	    	$('.toast-body').html('자신이 해당 직무에 얼마나 <b>적합한 인재</b>인지 어필하는 항목입니다! <br/> 지원하는 직무에 필요한 역량을 분석하고 자신과 잘 연관시켜 작성하면 되겠죠? <br/> 마지막으로, 다짐까지 한 줄 추가해준다면 더 좋을 거예요.');
	    	$('.toast').toast('show');
	    	
	    // 경험과 사례 	
	    } else if(selected.parent()[0].id == "four"){
	    	$('.toast-body').html('경험과 사례는 최대한 구체적으로 작성해야합니다. <br/> 또한 나의 이야기를 설득력있게 전달하기 위해서는 이를 뒷받침해줄 <b>충분한 근거</b>가 필요합니다. <br/> 이 점을 잊지 말고 작성해보세요! 😊');
	    	$('.toast').toast('show');
	    
	    // 기타	
	    } else if(selected.parent()[0].id == "five"){
	    	$('.toast-body').html('자기소개서는 내가 어떤 사람인지 궁금해질 수 있도록, <br/> 나에 대한 <b>예고편</b>을 보여주는 것입니다.');
	    	$('.toast').toast('show');
	    } 
	});
});

/*---------- 음성인식 : speech_to_text func ----------*/
$(document).ready(function(){
	   
	   var message = document.getElementById("message");
	   var button = document.getElementById("speech");
	   var content = document.getElementById("content"); // div
	   console.log(content);
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
	      content.textContent = resText; // textera에 넣는거

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






