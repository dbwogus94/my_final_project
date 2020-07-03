
function add_div(id){
	var field = document.getElementById(id);
	console.log(field);
	console.log("1");
	var parent = field.parentNode;
	console.log(parent);
	console.log("2");
	var bro = parent.previousSibling.previousSibling;
	console.log(bro);
	console.log("3");
	var bro2 = parent.previousSibling.previousSibling.previousSibling.previousSibling;
	console.log(bro2);
	console.log("4");

	var div = document.createElement('div');
	
	 div.innerHTML = document.getElementById(bro2.id).innerHTML;
	 document.getElementById(bro.id).appendChild(div);
}

function remove_div(obj){
	
	var object = obj;
	var object_p = object.parentNode;
	var p_bro = object_p.previousSibling.previousSibling;
	 
	var tag = document.getElementById( p_bro.id );
     tag.removeChild( tag.lastChild );
}


function Address() {
	window.open("Address.do","","width=500px,height=500px");
	
}

window.onload = function () {                
	let sliderArr = document.getElementsByClassName("slider")
	let valueArr = []
	for(let i = 0; i<sliderArr.length; i++){
		 valueArr.push(sliderArr[i].value)
	}
    var slider1 = new rSlider({
        target: '#slider1',
        values: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10],
        range: false,
        width: '700px',
        set: [Number(valueArr[0])],
        tooltip: false,
        onChange: function (vals) {
        }
    });
    var slider2 = new rSlider({
        target: '#slider2',
        values: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10],
        range: false,
        width: '700px',
        set: [Number(valueArr[1])],
        tooltip: false,
        onChange: function (vals) {
        }
    });
    var slider3 = new rSlider({
        target: '#slider3',
        values: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10],
        range: false,
        width: '700px',
        set: [Number(valueArr[2])],
        tooltip: false,
        onChange: function (vals) {
        }
    });
    var slider4 = new rSlider({
        target: '#slider4',
        values: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10],
        range: false,
        width: '700px',
        set: [Number(valueArr[3])],
        tooltip: false,
        onChange: function (vals) {
        }
    });
    var slider5 = new rSlider({
        target: '#slider5',
        values: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10],
        range: false,
        width: '700px',
        set: [Number(valueArr[4])],
        tooltip: false,
        onChange: function (vals) {
        }
    });
    
    //자격증 재구성
    restructure_certificate()
    //어학점수 재구성
    restructure_language()
    //공모전 재구성
    restructure_contest()
};


// 학력 selectBox
function careerfunc(select){
	let selectOne = select.options[select.selectedIndex].value;
	
	let selectAll = document.getElementsByName("career")
	
	let target = document.getElementsByName("grade")
	
	for(let i = 0; i<selectAll.length; i++){
		if(selectAll[i] === select){
			if(selectOne === "고졸"){
				target[i].value = "0.0"		// 유효성검사로 인해 값을 넣어줘야함
				target[i].setAttribute("readonly", "true")
			}
		} 
	}
}


// 자격증 재구성
function restructure_certificate(){
	let certificate = document.getElementsByName("certificate")
	let organization = document.getElementsByName("organization")
	let regdate = document.getElementsByName("regdate")
	
	let certificateArr = certificate[0].value.split(",")
	let organizationArr = organization[0].value.split(",")
	let regdateArr = regdate[0].value.split(",")
	
	let button4 = document.getElementById("button4")
	
	for(let i = 0; i<certificateArr.length; i++){
		if(i>0){
			button4.click()
		}
	}
	certificate = document.getElementsByName("certificate")
	organization = document.getElementsByName("organization")
	regdate = document.getElementsByName("regdate")
	
	for(let i = 0; i<certificateArr.length; i++){
		certificate[i].value = certificateArr[i]
		organization[i].value = organizationArr[i]
		regdate[i].value = regdateArr[i]
	}
}

//어학점수 재구성
function restructure_language(){
	let languagename = document.getElementsByName("languagename")
	let languagescore = document.getElementsByName("languagescore")
	let languageregdate = document.getElementsByName("languageregdate")
	
	let languagenameArr = languagename[0].value.split(",")
	let languagescoreArr = languagescore[0].value.split(",")
	let languageregdateArr = languageregdate[0].value.split(",")
	
	let button5 = document.getElementById("button5")
	
	for(let i = 0; i<languagenameArr.length; i++){
		if(i>0){
			button5.click()
		}
	}
	languagename = document.getElementsByName("languagename")
	languagescore = document.getElementsByName("languagescore")
	languageregdate = document.getElementsByName("languageregdate")
	
	for(let i = 0; i<languagenameArr.length; i++){
		languagename[i].value = languagenameArr[i]
		languagescore[i].value = languagescoreArr[i]
		languageregdate[i].value = languageregdateArr[i]
	}
}


// 공모전 재구성
function restructure_contest(){
	let contest = document.getElementsByName("contest")
	let Startorganization = document.getElementsByName("Startorganization")
	let prize = document.getElementsByName("prize")
	
	let contestArr = contest[0].value.split(",")
	let StartorganizationArr = Startorganization[0].value.split(",")
	let prizeArr = prize[0].value.split(",")
	
	let button6 = document.getElementById("button6")
	
	for(let i = 0; i<contestArr.length; i++){
		if(i>0){
			button6.click()
		}
	}
	contest = document.getElementsByName("contest")
	Startorganization = document.getElementsByName("Startorganization")
	prize = document.getElementsByName("prize")
	
	for(let i = 0; i<contestArr.length; i++){
		contest[i].value = contestArr[i]
		Startorganization[i].value = StartorganizationArr[i]
		prize[i].value = prizeArr[i]
	}
}


