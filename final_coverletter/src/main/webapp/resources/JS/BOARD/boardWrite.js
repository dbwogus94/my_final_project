/*---------- 썸머노트API summernote api ----------*/
$(document).ready(function() {
    $('.summernote').summernote({
          height: 300,					//에디터 높이
          toolbar: [
        	  ['style', ['style']],
        	  ['font', ['bold', 'italic', 'underline', 'clear']],
        	  ['color', ['color']],
        	  ['height', ['height']],
        	  ['table', ['table']],
        	  ['insert', ['link', 'picture', 'hr']],
        	  ['view', ['fullscreen', 'codeview']],
        	  ['help', ['help']]
          ]
    });
 });

/*---------- 글작성 : board write func ----------*/
function boardWrite() {
	// values
	var form = $('form');
	var title = $('#title').val();
	var content = $('.summernote').val();
	var file = $("#fileupload").val();
	
	
	// 글작성
	if((title.trim() != '') && (content.trim() != '')){
		//form.commandName = 'BoardDto';
		//form.action = 'BOARD_boardWrite.do';
		form.submit();
	} else if ((title.trim() == '') || (content.trim() == '')) {
	// 유효성검사
		$('.modal-title').addClass('glyphicon glyphicon-alert');
		$('.modal-title').text(' ERROR');
		$('.modal-body').text('내용을 입력해주세요.');
		$('#myModal').modal('show');
	}
	
}

