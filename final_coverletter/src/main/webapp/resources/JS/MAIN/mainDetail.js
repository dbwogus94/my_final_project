
//기업소개 없을 때 디브를 숨김.
$(function() {
	var intro = $("#intro_id").text();
	if (intro === "None") {
		var parent = document.getElementById("intro_id").parentNode;
		$(parent).css("display", "none");
	}

});

//개인장비 None일때 디브숨김
$(function(){
	var givetool = $("#givetool_id").text();
	if (givetool === "None") {
		var parent = document.getElementById("givetool_id").parentNode;
		$(parent).css("display", "none");
	}
});


//자계개발  None일때 디브숨김
$(function(){
	var selefgrowth = $("#selefgrowth_id").text();
	if (selefgrowth === "None") {
		var parent = document.getElementById("selefgrowth_id").parentNode;
		$(parent).css("display", "none");
	}
});

//식사시간 None일때 디브숨김
$(function(){
	var mealtime = $("#mealtime_id").text();
	if (mealtime === "None") {
		var parent = document.getElementById("mealtime_id").parentNode;
		$(parent).css("display", "none");
	}
});

//연차 휴가 None일때 디브숨김
$(function(){
	var holiday = $("#holiday_id").text();
	if (holiday === "None") {
		var parent = document.getElementById("holiday_id").parentNode;
		$(parent).css("display", "none");
	}
});

//근무형태 None일때 디브숨김
$(function(){
	var workinghour = $("#workinghour_id").text();
	if (workinghour === "None") {
		var parent = document.getElementById("workinghour_id").parentNode;
		$(parent).css("display", "none");
	}
});

//보험,의료 None일때 디브숨김
$(function(){
	var insurance = $("#insurance_id").text();
	if (insurance === "None") {
		var parent = document.getElementById("insurance_id").parentNode;
		$(parent).css("display", "none");
	}
});


//복지란이 모두 NON값일때 복지 div자체를 숨겨버림
$(function(){
	var givetool = $("#givetool_id").text();
	var selefgrowth = $("#selefgrowth_id").text();
	var mealtime = $("#mealtime_id").text();
	var holiday = $("#holiday_id").text();
	var workinghour = $("#workinghour_id").text();
	var insurance = $("#insurance_id").text();
	
	if (insurance && selefgrowth && mealtime&&holiday&&workinghour&&insurance=== "None" ) {
		var parent = document.getElementById("insurance_id").parentNode.parentNode.parentNode;
		$(parent).css("display", "none");
	}
});


//기업정보 None 숨김
$(function(){
	var incorporation = $("#incorporation_id").text();
	if (incorporation === "None") {
		var parent = document.getElementById("incorporation_id").parentNode;
		$(parent).css("display", "none");
	}
});


//구성원 None 숨김
$(function(){
	var totalmember = $("#totalmember_id").text();
	if (totalmember === "None") {
		var parent = document.getElementById("totalmember_id").parentNode;
		$(parent).css("display", "none");
	}
});

//홈페이지 None 숨김
$(function(){
	var homepage = $("#homepage_id").text();
	if (homepage === "None") {
		var parent = document.getElementById("homepage_id").parentNode.parentNode;
		$(parent).css("display", "none");
	}
});

//산업분야 None 숨김
$(function(){
	var mainfield = $("#mainfield_id").text();
	if (mainfield === "None") {
		var parent = document.getElementById("mainfield_id").parentNode;
		$(parent).css("display", "none");
	}
});


//위치 None 숨김
$(function(){
	var location = $("#location_id").text();
	if (location === "None") {
		var parent = document.getElementById("location_id").parentNode.parentNode;
		$(parent).css("display", "none");
	}
});


 
 