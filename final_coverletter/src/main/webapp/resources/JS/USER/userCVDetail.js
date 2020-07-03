function pdfPrint() {

	// 현재 document.body의 html을 A4 크기에 맞춰 PDF로 변환
	html2canvas(document.getElementById("PDF_container"), {
		onrendered : function(canvas) {

			// 캔버스를 이미지로 변환
			var imgData = canvas.toDataURL('image/png');

			var imgWidth = 210; // 이미지 가로 길이(mm) A4 기준
			var pageHeight = imgWidth * 1.414; // 출력 페이지 세로 길이 계산 A4 기준
			var imgHeight = canvas.height * imgWidth / canvas.width;
			var heightLeft = imgHeight;

			var doc = new jsPDF('p', 'mm');
			var position = 0;

			// 첫 페이지 출력
			doc.addImage(imgData, 'PNG', 0, position, imgWidth, imgHeight);
			heightLeft -= pageHeight;

			// 한 페이지 이상일 경우 루프 돌면서 출력
			while (heightLeft >= 20) {
				position = heightLeft - imgHeight;
				doc.addPage();
				doc.addImage(imgData, 'PNG', 0, position, imgWidth, imgHeight);
				heightLeft -= pageHeight;
			}

			// 파일 저장
			doc.save('sample.pdf');

			// 이미지로 표현
			// document.write('<img src="'+imgData+'" />');
		}

	});

}

window.onload = function() {
	$('#cmd').click(function() {
		pdfPrint();
	});
	restructure_certificate()
	restructure_language()
	restructure_contest()
}


//자격증 재구성
function restructure_certificate(){
	let certificate = document.getElementsByClassName("certificate")
	let organization = document.getElementsByClassName("organization")
	let regdate = document.getElementsByClassName("regdate")
	
	let certificateArr = certificate[0].childNodes[0].nodeValue.split(",")
	let organizationArr = organization[0].childNodes[0].nodeValue.split(",")
	let regdateArr = regdate[0].childNodes[0].nodeValue.split(",")
	
	let tbody_certificate = document.getElementById("tbody_certificate")
	
	for(let i = 0; i<certificateArr.length; i++){
			if(i == 0){
				certificate[0].innerHTML = certificateArr[0]
				organization[0].innerHTML = organizationArr[0]
				regdate[0].innerHTML = regdateArr[0]
			} else {
				let row = tbody_certificate.insertRow( tbody_certificate.rows.length)
				let td1 = row.insertCell(0)
				td1.innerHTML = certificateArr[i]
				let td2 = row.insertCell(1)
				td2.innerHTML = organizationArr[i]
				let td3 = row.insertCell(2)
				td3.innerHTML = regdateArr[i]
			}
	}
}


//어학점수 재구성
function restructure_language(){
	let languagename = document.getElementsByClassName("languagename")
	let languagescore = document.getElementsByClassName("languagescore")
	let languageregdate = document.getElementsByClassName("languageregdate")
	
	let languagenameArr = languagename[0].childNodes[0].nodeValue.split(",")
	let languagescoreArr = languagescore[0].childNodes[0].nodeValue.split(",")
	let languageregdateArr = languageregdate[0].childNodes[0].nodeValue.split(",")
	
	let tbody_language = document.getElementById("tbody_language")
	
	for(let i = 0; i<languagenameArr.length; i++){
			if(i == 0){
				languagename[0].innerHTML = languagenameArr[0]
				languagescore[0].innerHTML = languagescoreArr[0]
				languageregdate[0].innerHTML = languageregdateArr[0]
			} else {
				let row = tbody_language.insertRow(tbody_language.rows.length)
				let td1 = row.insertCell(0)
				td1.innerHTML = languagenameArr[i]
				let td2 = row.insertCell(1)
				td2.innerHTML = languagescoreArr[i]
				let td3 = row.insertCell(2)
				td3.innerHTML = languageregdateArr[i]
			}
	}
}


//공모전 재구성
function restructure_contest(){
	let contest = document.getElementsByClassName("contest")
	let startorganization = document.getElementsByClassName("startorganization")
	let prize = document.getElementsByClassName("prize")
	
	let contestArr = contest[0].childNodes[0].nodeValue.split(",")
	let startorganizationArr = startorganization[0].childNodes[0].nodeValue.split(",")
	let prizeArr = prize[0].childNodes[0].nodeValue.split(",")
	
	let tbody_contest = document.getElementById("tbody_contest")
	
	for(let i = 0; i<contestArr.length; i++){
			if(i == 0){
				contest[0].innerHTML = contestArr[0]
				startorganization[0].innerHTML = startorganizationArr[0]
				prize[0].innerHTML = prizeArr[0]
			} else {
				let row = tbody_contest.insertRow(tbody_contest.rows.length)
				let td1 = row.insertCell(0)
				td1.innerHTML = contestArr[i]
				let td2 = row.insertCell(1)
				td2.innerHTML = startorganizationArr[i]
				let td3 = row.insertCell(2)
				td3.innerHTML = prizeArr[i]
			}
	}
}
