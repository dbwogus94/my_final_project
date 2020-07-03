var page;		
var startFrom;  	
var range;		 	
var startPage;	 	
var endPage;	 	
var totalPage;		
var from;		 	

var cat1_num = new Array(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16);
var cat1_name = new Array('서울','부산','대구','인천','광주','대전','울산','강원','경기','경남','경북','전남','전북','제주','충남','충북');

var cat2_num = new Array();
var cat2_name = new Array();
cat2_num[1] = new Array(17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41);
cat2_name[1] = new Array('강남구','강동구','강북구','강서구','관악구','광진구','구로구','금천구','노원구','도봉구','동대문구','동작구','마포구','서대문구','서초구','성동구','성북구','송파구','양천구','영등포구','용산구','은평구','종로구','중구','중랑구');
cat2_num[2] = new Array(42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57);
cat2_name[2] = new Array('강서구','금정구','남구','동구','동래구','부산진구','북구','사상구','사하구','서구','수영구','연제구','영도구','중구','해운대구','기장군');
cat2_num[3] = new Array(58,59,60,61,62,63,64,65);
cat2_name[3] = new Array('남구','달서구','동구','북구','서구','수성구','중구','달성군');
cat2_num[4] = new Array(66,67,68,69,70,71,72,73,74,75);
cat2_name[4] = new Array('계양구','남구','남동구','동구','부평구','서구','연수구','중구','강화군','옹진군');
cat2_num[5] = new Array(76,77,78,79,80);
cat2_name[5] = new Array('광산구','남구','동구','북구','서구');
cat2_num[6] = new Array(81,82,83,84,85);
cat2_name[6] = new Array('대덕구','동구','서구','유성구','중구');
cat2_num[7] = new Array(86,87,88,89,90);
cat2_name[7] = new Array('남구','동구','북구','중구','울주군');
cat2_num[8] = new Array(91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108);
cat2_name[8] = new Array('강릉시','동해시','삼척시','속초시','원주시','춘천시','태백시','고성군','양구군','양양군','영월군','인제군','정선군','철원군','평창군','홍천군','화천군','횡성군');
cat2_num[9] = new Array(109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126,127,128,129,130,131,132,133,134,135,136,137,138,139,140,141,142,143,144,145,146,147,148);
cat2_name[9] = new Array('고양시 덕양구','고양시 일산구','과천시','광명시','광주시','구리시','군포시','김포시','남양주시','동두천시','부천시 소사구','부천시 오정구','부천시 원미구','성남시 분당구','성남시 수정구','성남시 중원구','수원시 권선구','수원시 장안구','수원시 팔달구','시흥시','안산시 단원구','안산시 상록구','안성시','안양시 동안구','안양시 만안구','오산시','용인시','의왕시','의정부시','이천시','파주시','평택시','하남시','화성시','가평군','양주군','양평군','여주군','연천군','포천군');
cat2_num[10] = new Array(149,150,151,152,153,154,155,156,157,158,159,160,161,162,163,164,165,166,167,168);
cat2_name[10] = new Array('거제시','김해시','마산시','밀양시','사천시','양산시','진주시','진해시','창원시','통영시','거창군','고성군','남해군','산청군','의령군','창녕군','하동군','함안군','함양군','합천군');
cat2_num[11] = new Array(169,170,171,172,173,174,175,176,177,178,179,180,181,182,183,184,185,186,187,188,189,190,191,192);
cat2_name[11] = new Array('경산시','경주시','구미시','김천시','문경시','상주시','안동시','영주시','영천시','포항시 남구','포항시 북구','고령군','군위군','봉화군','성주군','영덕군','영양군','예천군','울릉군','울진군','의성군','청도군','청송군','칠곡군');
cat2_num[12] = new Array(193,194,195,196,197,198,199,200,201,202,203,204,205,206,207,208,209,210,211,212,213,214);
cat2_name[12] = new Array('광양시','나주시','목포시','순천시','여수시','강진군','고흥군','곡성군','구례군','담양군','무안군','보성군','신안군','영광군','영암군','완도군','장성군','장흥군','진도군','함평군','해남군','화순군');
cat2_num[13] = new Array(215,216,217,218,219,220,221,222,223,224,225,226,227,228,229);
cat2_name[13] = new Array('군산시','김제시','남원시','익산시','전주시 덕진구','전주시 완산구','정읍시','고창군','무주군','부안군','순창군','완주군','임실군','장수군','진안군');
cat2_num[14] = new Array(230,231,232,233);
cat2_name[14] = new Array('서귀포시','제주시','남제주군','북제주군');
cat2_num[15] = new Array(234,235,236,237,238,239,240,241,242,243,244,245,246,247,248);
cat2_name[15] = new Array('공주시','논산시','보령시','서산시','아산시','천안시','금산군','당진군','부여군','서천군','연기군','예산군','청양군','태안군','홍성군');
cat2_num[16] = new Array(249,250,251,252,253,254,255,256,257,258,259,260);
cat2_name[16] = new Array('제천시','청주시 상당구','청주시 흥덕구','충주시','괴산군','단양군','보은군','영동군','옥천군','음성군','진천군','청원군');


//글자수 자르기
function StringCut(textLen, text){
	if(text.length > 0){
		if(text.length >= textLen){
			text = text.substring(0, textLen) + '...'
		}
	}
	return text 
}

//동기 이전 버튼 이벤트
function prev_maria(page, range, rangeSize) {
	var page = parseInt((range - 2) * rangeSize) + 1;
	var range = parseInt(range) - 1;
	var url = "JOB_jobSearch.do";
	url = url + "?page=" + page;
	url = url + "&range=" + range;
	location.href = url;
}

//동기 페이지 번호 클릭
function pagination_maria(page, range) {
	var url = "JOB_jobSearch.do";
	page = page
	url = url + "?page=" + page;
	url = url + "&range=" + range;
	location.href = url;	
}

//동기 다음 버튼 이벤트
function next_maria(page, range, rangeSize) {
	var page = parseInt((range * rangeSize)) + 1;
	var range = parseInt(range) + 1;
	var url = "JOB_jobSearch.do";
	url = url + "?page=" + page;
	url = url + "&range=" + range;
	location.href = url;
}

/* 중복가능 selectbox */
function selected_overlap(select){
	let res = select.options[select.selectedIndex];
    let search_company = document.getElementById("search_company")
    res.disabled = true
    
    let h5 = document.createElement("h5")
    h5.setAttribute("class", "keyword_h5")
    search_company.append(h5)
    
    let span = document.createElement("span")
    span.setAttribute("class", "label label-default")
    h5.appendChild(span)
    if(select.id === "location_front"){
    	span.textContent = res.text + " "
    } else {
    	span.textContent = res.value + " "
    }
    
    
    
    let btn = document.createElement("input")
    btn.setAttribute("type", "button")
    btn.setAttribute("value","X")
    btn.setAttribute("class", "keyword_button")
    btn.setAttribute("onclick", "keywordBut_overlap(this," + "'"+ res.value + "'" + ");")
    span.appendChild(btn)
}

/* 중복 키워드 버튼 삭제 */
function keywordBut_overlap(btn, text) {
	let search_company = document.getElementById("search_company")
	let btns = document.getElementsByClassName("keyword_button")
	let h5s = document.getElementsByClassName("keyword_h5")
	let selectList = document.querySelectorAll(".form-control")
	
	for(var i = 0; i < btns.length; i++){
		if(btns[i] == btn){
			search_company.removeChild(h5s[i])
		}
	}
	for(var i = 0; i<selectList.length -5 ; i++){
		let select_options = document.querySelectorAll(".form-control")[i].options
		
		for(var j = 0; j < select_options.length; j++){
			console.log(select_options[j].value)
			if(select_options[j].value === text){
				select_options[j].disabled = false
			}
		}
	}
}



/* 중복불가 selectbox */
function selected_only(select){
	var res = select.options[select.selectedIndex];
	// 클릭한 selectBox 잠금
    select.disabled = true
    
    let h5 = document.createElement("h5")
    h5.setAttribute("class", "keyword_h5")
    search_company.append(h5)
    
    let span = document.createElement("span")
    span.setAttribute("class", "label label-default")
    h5.appendChild(span)
    span.textContent = res.value + " "
    
    let btn = document.createElement("input")
    btn.setAttribute("type", "button")
    btn.setAttribute("value","X")
    btn.setAttribute("class", "keyword_button")
    btn.setAttribute("onclick", "keywordBut_only(this," + "'"+ res.value + "'" + ");")
    span.appendChild(btn)
    
}

/* 중복불가 키워드 버튼 삭제  */
function keywordBut_only(btn, text) {
	let search_company = document.getElementById("search_company")
	let btns = document.getElementsByClassName("keyword_button")
	let h5s = document.getElementsByClassName("keyword_h5")
	let selectList = document.querySelectorAll(".form-control")
	
	for(var i = 0; i < btns.length; i++){
		if(btns[i] == btn){
			search_company.removeChild(h5s[i])
		}
	}
	for(var i = 4; i<selectList.length -1 ; i++){
		let select_options = document.querySelectorAll(".form-control")[i].options
		for(var j = 0; j < select_options.length; j++){
			if(select_options[j].value === text){
				select_options[j].disabled = false
				selectList[i].disabled = false
			}
		}
	}
}

function location_change(value, thiz){

	var location_back = document.getElementById("location_back");
	
	if(value == ''){
		return;
	} 
	var name = cat2_name[value];
	var val = cat2_num[value];
	for(var i = 0; i<name.length; i++){
		location_back.options[i+1] = new Option(name[i],name[i]);
	}
	
	selected_overlap(thiz)
		
}




//검색 조건 리셋
function companyReset() {
	var text = document.getElementById("search_company").value = ""
	let searchTextDiv = document.getElementById("div_text_search")
	let select_search = document.getElementById("select_search")
	
    // 전체 select 초기화
	var selectList = document.querySelectorAll(".form-control")
    for(var i = 0; i<selectList.length; i++){
    	var select_options = document.querySelectorAll(".form-control")[i].options
    	// 옵션 초기화
    	for(var j = 0; j<select_options.length -1; j++){
    		select_options[0].selected = true
    		if(select_options[j].disabled){
    			if(j == 0){
    				select_options[j].disabled = true;
    			} else {
    				select_options[j].disabled = false;
    			}
    		}
    	}
    	selectList[i].disabled = true
    	select_search.disabled = false
    }
	
	//검색 입력창 초기화
	searchTextDiv.innerHTML = "";
	let div = document.createElement("div")
	div.setAttribute("class", "from-group")
	div.setAttribute("id", "select_search")
	
	let inputText = document.createElement("input")
	inputText.setAttribute("type", "text")
	inputText.setAttribute("id", "search_company")
	inputText.setAttribute("class", "form-control")
	inputText.setAttribute("placeholder", "검색어 키워드 입력")
	
	div.appendChild(inputText)
	searchTextDiv.appendChild(div)
}

//검색폼 변환
function searchType(selectType){
	let searchTextDiv = document.getElementById("div_text_search")
	let select_search = document.getElementById("select_search")

	if(selectType.options[selectType.selectedIndex].value =="검색"){
		// 영역 지우기
		searchTextDiv.innerHTML = "";
		
		// select Box 잠금
		var selectList = document.querySelectorAll(".form-control")
	    for(var i = 0; i<selectList.length; i++){
	    	selectList[i].disabled = true
	    	select_search.disabled = false
	    }
		
		let div = document.createElement("div")
		div.setAttribute("class", "from-group")
		div.setAttribute("id", "select_search")
		
		let inputText = document.createElement("input")
		inputText.setAttribute("type", "text")
		inputText.setAttribute("id", "search_company")
		inputText.setAttribute("class", "form-control")
		inputText.setAttribute("placeholder", "검색어 키워드 입력")
		
		div.appendChild(inputText)
		searchTextDiv.appendChild(div)

	} else if(selectType.options[selectType.selectedIndex].value =="키워드") {
		searchTextDiv.innerHTML = "";
		
		let div = document.createElement("div")
		div.setAttribute("class", "from-group")
		div.setAttribute("id", "select_search")
		
		let butDiv = document.createElement("div")
		butDiv.setAttribute("class", "well")
		butDiv.setAttribute("id", "search_company")
		
		div.appendChild(butDiv)
		searchTextDiv.appendChild(div)
		
		var selectList = document.querySelectorAll(".form-control")
	    for(var i = 0; i<selectList.length; i++){
	    	selectList[i].disabled = false
	    }
		
	}
}


/* 검색 */
function companySearch(page, startPage, from, startFrom, range){
	console.log("page: " + page, "startPage: " + startPage, "from: " + from, "startFrom: " + startFrom, "range: " + range)
	
	page = page;			//현재 페이지번호
	startPage = startPage;	// 시작 페이지 번호
	range = range;			// 시작 1쪽
	from = from;			// 결과값 시작 index
	startFrom = startFrom;	// 현재 쪽의 결과값 시작 index
	endPage = startPage + 9 
	
	var business =  document.getElementById("business").value
	var languages =  document.getElementById("languages").value
	var location_front =  document.getElementById("location_front").value
	var location_back =  document.getElementById("location_back").value
	var target =  document.getElementById("target").value
	var enddate =  document.getElementById("enddate").value
	var totalmember =  document.getElementById("totalmember").value
	var salary =  document.getElementById("salary").value

	var keyWord = document.getElementById("search_company").value
	
	var jsonKey = {
					  from : from,		// 다음 요청 시작번호
					  business : keyWord
					  //companyname : keyWord
				   }
	console.log(jsonKey)
	
	if(keyWord == ""){
		alert("키워드를 입력하세요")
	}else{
		//페이지를 다음으로 누를때는 from을 올린 검색결과 유지한 값을 보낸다.
		$.ajax({
			url:"JOB_jobSearchRes.do",
			type:"post",
			///contentType: 'application/json',
			data:jsonKey,
	        dataType :"text",
	        success : function(res){
	        	
	        	console.log(res)
	        	var jsonRes = JSON.parse(res)
	        	
	        	// 데이터 개수는 0번 ~ 9번 한페이지에 10개 출력   페이지 번호 한 번에 10개씩
				const total = jsonRes.hits.total.value
				// 올림
				totalPage = Math.ceil(total/10)
				
	        	// 데이터 결과 배열로 들어있음
	        	var comapanyArr = jsonRes.hits.hits
	        	console.log(comapanyArr)
				
	        	// 검색결과 div 초기화
	        	var container = document.getElementById("search_container")
	        	container.innerHTML = "";
	        	
	        	// 가져온 데이터 그리기(최대 10개로 가져옴)
	        	for(var i = 0; i<comapanyArr.length; i++){
					var compnay = comapanyArr[i]
					creatDiv(compnay._source.companyseq, compnay._source.imgurl, compnay._source.business, compnay._source.enddate, compnay._source.oneintro, compnay._source.mainfield, compnay._source.languages, compnay._source.companyname, compnay._source.location, compnay._source.salary, compnay._source.target)
				}
				// 페이징 그리기
	        	creatPageBtn_etc(page, startPage, endPage, startFrom, range)
			},
		    error: function(){
		       alert("통신 실패, 관리자에게 문의하세요");
		    }
		})
	}
}

//비동기 페이징 버튼 생성	
function creatPageBtn_etc(clickPage, startPage, endPage, startFrom, range) {
	var pageArea = document.getElementsByClassName("pagination")[0]
	pageArea.innerHTML = ""
	page = clickPage; // 전역변수에 할당

	if(endPage >= totalPage){ 
		endPage = totalPage		
	}
	//이전버튼
	if(startPage > 10){
		prev_etc()
	}
	//페이지 버튼 그리기
	for(var i = startPage; i < endPage+1; i++){
		pagination_etc(i, startPage, startFrom, range)
		if(i > 1){
			from += 10
		}
	}
	//다음버튼
	if((endPage != totalPage) && (endPage < totalPage)){
		next_etc()
	}
}


//비동기 페이지 버튼생성
function pagination_etc(butNum, startPage, startFrom, range){
	var pageArea = document.getElementsByClassName("pagination")[0]
	var li = document.createElement("li")
	if(butNum == page){	
		li.setAttribute("class", "page-item active")
	}
	pageArea.appendChild(li)
	li.innerHTML = "<a class='page-link' href='#' onclick='companySearch(" + butNum + ", " + startPage + ", " + ((butNum*10)-10) + ", " + startFrom + ", " + range + ")'>" + butNum + "</a>"
	
}


// 비동기 다음버튼 생성
function next_etc() {
	var pageArae = document.getElementsByClassName("pagination")[0]
	var li = document.createElement("li")
	li.setAttribute("class", "page-item")
	pageArae.appendChild(li)
	li.innerHTML = "<a class='page-link' href='#' onclick='companySearch(" + (startPage + 10) + ", " + (startPage + 10) + ", " + (startFrom + 100) + ", "+ (startFrom + 100) + ", " + (range + 1) + ")'>" + "Next" + "</a>"
	
}

// 비동기 이전 버튼 생성
function prev_etc() {
	var pageArae = document.getElementsByClassName("pagination")[0]
	var li = document.createElement("li")
	li.setAttribute("class", "page-item")
	pageArae.appendChild(li)
	li.innerHTML = "<a class='page-link' href='#' onclick='companySearch(" + (startPage - 10) + ", " + (startPage + 10) + ", " + (startFrom - 100) + ", "+ (startFrom - 100) +", "+ (range - 1) + ")'>" + "Previous" + "</a>"
	
}


//기업정보 div
function creatDiv(companyseq, imgurl, business, enddate, oneintro, mainfield, languages, companyname, location, salary, target){
	var row = document.createElement("div")
	row.setAttribute("class", "row")
	
	//이미지 영역
	var imgDiv_2 = document.createElement("div")
	imgDiv_2.setAttribute("class", "col-md-2")
	var imgTop = document.createElement("div")
	imgTop.setAttribute("class", "div_img_top")
	var imgMid = document.createElement("div")
	imgMid.setAttribute("class", "div_img_mid")
	var img = document.createElement("img")
	img.setAttribute("src", imgurl)
	
	imgDiv_2.appendChild(imgTop)
	imgTop.appendChild(imgMid)
	imgMid.appendChild(img)

	//회사정보 영역
	var companyDiv_10 =  document.createElement("div")
	companyDiv_10.setAttribute("class", "col-md-10")

	//company_left 영역
	var company_left = document.createElement("div")
	company_left.setAttribute("class", "company_left")
	//h5 시작
	var h5 = document.createElement("h5")
	var a = document.createElement("a")
	a.setAttribute("href", "JOB_jobDetail.do?companyseq="+companyseq)	// pk 추가 
	h5.appendChild(a)
	var b_left = document.createElement("b")
	b_left.textContent = StringCut(45, business)
	a.appendChild(b_left)
	h5.appendChild(a)
	var span = document.createElement("span")
	span.style.fontSize = "10px"
	span.textContent = "  "+enddate 		// 마감날짜 추가
	h5.appendChild(span)
	var br = document.createElement("br")
	h5.appendChild(br)
	//h5 끝
	
	//h5 추가
	company_left.appendChild(h5)

	//한줄 소개
	var span01 = document.createElement("span")
	span01.textContent = StringCut(50, oneintro)
	company_left.appendChild(span01)
	var br01 = document.createElement("br")
	company_left.appendChild(br01)
	//주요업무
	var span02 = document.createElement("span")
	span02.textContent = StringCut(50, mainfield)
	company_left.appendChild(span02)
	var br02 = document.createElement("br")
	company_left.appendChild(br02)
	// 사용언어
	var span03 = document.createElement("span")
	span03.textContent = StringCut(50, languages)
	company_left.appendChild(span03)
	var br03 = document.createElement("br")
	company_left.appendChild(br03)
	
	//company_left 영역 추가
	companyDiv_10.appendChild(company_left)
	


	//company_right 영역
	var company_right = document.createElement("div")
	company_right.setAttribute("class", "company_right")
	// 회사명
	var b_right = document.createElement("b")
	b_right.textContent = companyname
	company_right.appendChild(b_right)
	var br04 = document.createElement("br")
	company_right.appendChild(br04)
	// 위치
	var span04 = document.createElement("span")
	span04.textContent = StringCut(17, location)
	company_right.appendChild(span04)
	var br05 = document.createElement("br")
	company_right.appendChild(br05)
	// 연봉
	var span05 = document.createElement("span")
	span05.textContent = salary
	company_right.appendChild(span05)
	// 경력/신입
	var span06 = document.createElement("span")
	span06.textContent = target
	company_right.appendChild(span06)
	var br06 = document.createElement("br")
	var br07 = document.createElement("br")
	company_right.appendChild(br06)
	company_right.appendChild(br07)
	
	var button = document.createElement("input")
	button.setAttribute("type", "button")
	button.setAttribute("class", "btn_compnay")
	button.setAttribute("value", "기업정보")
	
	company_right.innerHTML += '<input type="button" class="btn_compnay" value="기업정보" onclick="location.href=\'MAIN_kakaomap.do?companyseq=' +companyseq+'\'"/>'
	
	
	//company_right 영역 추가
	companyDiv_10.appendChild(company_right)
	
	// 메인 div 추가
	var container = document.getElementById("search_container")
	container.appendChild(row)
	row.appendChild(imgDiv_2)
	row.appendChild(companyDiv_10)
} 




