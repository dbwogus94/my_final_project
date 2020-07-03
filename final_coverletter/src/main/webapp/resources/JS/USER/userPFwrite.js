	//PFdetail 추가 
	function plus() {
		var idx = 0;
		var plus = $("#PFdetail").clone(true);
		var chk = plus.children().next().children().next().children('#photo').children('.img_wrap').children();
		var chk2 = plus.children().next().children().next().children().next().next().children("textarea");
		var chk3 = plus.children().next().next().children().children("textarea");
		var input = plus.children().children().next();
		console.log(input);
		console.log(chk3);
		
		chk.removeAttr('src');
		chk2.val('');
		chk3.val('');

		input.attr('name', 'targets[' + idx + '].filedpath');
		chk2.attr('name', 'targets[' + idx + '].functioninfo');
		chk3.attr('name', 'targets[' + idx + '].viewinfo');
		
		idx++;
		
		$("#filed").append(plus);		
	}
	
	//PDdtail 삭제
	function minus(e) {
		
		e.parentNode.parentNode.remove();

	}
	
	// 파일추가
	$(document).ready(function() {
		$(".input_img").on("change", handleImgFileSelect);
		
		$("#pdfScr").hide();
	});

	function handleImgFileSelect(e) {
		var target = e.target;
		var field = $(target).parent().next().children().next();
		console.log(field);
		var files = target.files;
		var filesArr = Array.prototype.slice.call(files);

		filesArr.forEach(function(f) {
			if (!f.type.match("image.*")) {
				alert("이미지파일을 올려주세요");
				return;
			}

			sel_file = f;

			var reader = new FileReader();
			reader.onload = function(e) {
				
				field.children("#photo").children().children().attr('src', e.target.result);
				console.log(field.children("#photo").children().children());
			}
			reader.readAsDataURL(f);
		});
	}
	
	
	//pdf 변환
	function pdfprint() {
		
		window.scrollTo(0,0);
		html2canvas(document.querySelector("#pdfwrap")).then(function(canvas) {
			
			// 캔버스를 이미지로 변환
            var imgData = canvas.toDataURL('image/png');

            var imgWidth = 210; // 이미지 가로 길이(mm) A4 기준
            var pageHeight = imgWidth * 1.414;  // 출력 페이지 세로 길이 계산 A4 기준
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
            doc.save('portfolio.pdf');
            
            
            //PFform.submit();

            //파일 서버로 저장 
//          var pdf = btoa(doc.output());
//          
//          var data = new FormData();
//          data.append("pdf", pdf);
//    
//          $("#pfSrc").val(data);
//
//          var form = $("#test")[0];
//          var formdata = new FormData(form);
//          $.ajax({
//          	type:"post",
//          	enctype: 'multipart/form-data',
//          	url:"PFinsert.do",
//          	data:formdata,
//          	processData: false,
//              contentType: false,
//          	success : function(msg) {
//					alert("성공 : "+data);
//					
//				},
//				error : function(e) {
//					alert("통신실패 : "+e);
//				}
//          });
          
		});
	}
	

	
	