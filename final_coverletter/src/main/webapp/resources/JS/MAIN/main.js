
//Javascript

//var lastScrollTop = 0;
//var delta = 5;
//var fixBox = document.getElementById("totalCompany");
//var fixBoxHeight = document.body.offsetHeight;
//var didScroll;
var count = 0

function scrollPaging() {
		count++
		console.log(count)
		$.ajax({
			url : "MAIN_scrollPaging.do",
			type : "POST",
			data:{startList : count * 40},
			dataType : "JSON",
			success : function(data) {
				let companyList = data.res
				let totalCompany = document.getElementById("totalCompany")
				for(let i = 0; i<companyList.length; i++){
					let dto = companyList[i]
					
					// dom 생성
					let totalCompanyItem = document.createElement("div")
					totalCompanyItem.setAttribute("class", "totalCompanyItem")
					
					// companyItemTop 생성 시작
					let companyItemTop = document.createElement("div")
					companyItemTop.setAttribute("class", "companyItemTop")
					
					let a = document.createElement("a")
					a.setAttribute("href", "MAIN_mainDetail.do?companyseq="+dto.companyseq)
					
					let img = document.createElement("img")
					img.setAttribute("class", "companyImg2")
					img.setAttribute("src", dto.imgurl)
				
					a.appendChild(img)
					
					companyItemTop.appendChild(a)
					
					// companyItemBottom 생성 시작 
					let companyItemBottom = document.createElement("div")
					companyItemBottom.setAttribute("class", "companyItemBottom")
					
					let companyname = document.createElement("div")
					companyname.setAttribute("class", "companyname")
					companyname.textContent = dto.companyname
					
					let business = document.createElement("div")
					business.setAttribute("class", "business")
					business.textContent = dto.business
					
					companyItemBottom.appendChild(companyname)
					companyItemBottom.appendChild(business)
					
					totalCompanyItem.appendChild(companyItemTop)
					totalCompanyItem.appendChild(companyItemBottom)
					
					// 본문에 추가
					totalCompany.append(totalCompanyItem)
				}
			},
			error : function() {
				alert("통신 실패");
			}
		})
}





/*
window.onscroll = function(e) {
	//console.log(window.scrollY)
	//var count = 0;
	// 추가되는 임시 콘텐츠
	// 스크롤 바닥 감지     
	// window height + window scrollY 값이 document height보다 클 경우,
	if ((window.innerHeight + window.scrollY) >= (document.body.offsetHeight - 1) ) {
		console.log("끝")
		count++;
		scrollPaging(count)
		console.log(count)
	}	
	//document.body.scrollHeight
	//document.body.offsetHeight
		
//	$(window).scroll(function(){   //스크롤이 최하단 으로 내려가면 리스트를 조회하고 page를 증가시킨다.
//	     if($(window).scrollTop() >= $(document).height() - $(window).height()){
//	    	 count++
//	    	 scrollPaging(count)
//	     } 
//	});

}
*/


window.addEventListener('scroll', () => {
	let scrollLocation = document.documentElement.scrollTop; // 현재 스크롤바 위치
	let windowHeight = window.innerHeight; // 스크린 창
	let fullHeight = document.body.scrollHeight; //  margin 값은 포함 x
	console.log("a : " + scrollLocation)
	console.log("b : " + windowHeight)
	
	console.log("a+b : " + (scrollLocation+windowHeight)) 
	
	console.log("c : " + fullHeight)
	
	
	if(scrollLocation + windowHeight >= (fullHeight - 1)){
		console.log('끝')
	}
})

/*
// 스크롤 이벤트
window.onscroll = function(e) {
	didScroll = true;

	// 0.25초마다 스크롤 여부 체크하여 스크롤 중이면 hasScrolled() 호출
	setInterval(function() {
		if (didScroll) {
			hasScrolled();
			didScroll = false;
		}
	}, 25000);

	function hasScrolled() {
		var nowScrollTop = window.scrollY;
		if (Math.abs(lastScrollTop - nowScrollTop) <= delta) {
			return;
		}
		if (nowScrollTop > lastScrollTop && nowScrollTop > fixBoxHeight) {
			// Scroll down
			console.log('scroll down');
		} else {
			if (nowScrollTop + window.innerHeight < document.body.offsetHeight) {
				// Scroll up
				console.log('scroll up');
			}
		}
		lastScrollTop = nowScrollTop;
	}

}*/
