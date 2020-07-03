/*---------- 글/댓글 삭제 모달 : deleteAlert func ----------*/
function deleteAlert(text, replyseq) {
	//글삭제 (그룹번호로 아래 달린 댓글도 함께 모두 삭제)
	var board = $('#board-groupno').val();
	//댓글삭제 (글고유번호로 댓글만 삭제)
	
	$('.modal-title').addClass('glyphicon glyphicon-alert');
	$('.modal-title').text(' 경고!');
	$('.modal-body').text(text + '을 삭제하시겠습니까? 삭제된 ' + text + '은 다시 복구되지 않습니다.');
	
	if(text == '글'){
		$('#yes-btn').attr('onclick', 'boardDelete(' + board +');');
	} else if (text == '댓글') {
		$('#yes-btn').attr('onclick', 'replyDelete(' + replyseq +');');
	}

	$('#myModal').modal('show');
}

/*---------- 글삭제 : boardDelete func ----------*/
function boardDelete(groupno) {
	//현재 페이지
	var curPage = $('#board-curpage').val();
	location.href = 'BOARD_boardDelete.do?groupno=' + groupno  + '&curPage=' + curPage;
}

/*---------- 댓글삭제 : replyDelete func ----------*/
function replyDelete(replyseq) {
	//현재 페이지
	var curPage = $('#board-curpage').val();
	//부모글고유번호
	var parentboardseq = $('#board-boardseq').val();
	location.href = 'BOARD_replyDelete.do?boardseq=' + replyseq + '&parentboardseq=' + parentboardseq  + '&curPage=' + curPage;
}

/*---------- 댓글(엔터치면 입력) : onKeyDown func ----------*/
function onKeyDown(boardseq) {
     if(event.keyCode == 13) {
          replyInsert(boardseq);
     }
}

/*---------- 댓글 : replyInsert func ----------*/
function replyInsert(boardseq) {
	//댓글 작성내용
	var content = $('.form-control').val();
	
	//현재 페이지
	var curPage = $('#board-curpage').val();

	//새댓글 (부모 boardseq,  content)
	location.href = 'BOARD_replyInsert.do?boardseq=' + boardseq + '&content=' + content + '&curPage=' + curPage;
	
	//댓글작성폼 초기화
	$('.form-control').val(' ');

}

/*---------- 대댓글 : rereply func ----------*/
//param : 부모댓글이메일, 부모댓글번호
function rereply(replyemail, boardseq) {
	//댓글작성폼에 부모댓글이메일 넣기
	$('.form-control').val('  ㄴ ' + replyemail + ' 님에게 답글 : ');
	$('.form-control').focus();
	
	//댓글작성폼 대댓글에 맞는 함수로 바꿔주기
	$('.form-control').attr("onclick", "rereInsert(" + boardseq + ")");
	$('.form-control').attr('onKeyDown', "reonKeyDown(" +  boardseq + ")");
	
	//대댓글작성함수 rereplyInsert
}

/*---------- 대댓글(엔터치면 입력) : ReonKeyDown func ----------*/
function reonKeyDown(boardseq) {
	if(event.keyCode == 13) {
        rereInsert(boardseq);
   }
}

/*---------- 대댓글 : rereInsert func ----------*/
function rereInsert(boardseq) {
	//댓글작성내용
	var content = $('.form-control').val();
	//부모글고유번호
	var parentboardseq = $('#board-boardseq').val();
	
	//현재 페이지
	var curPage = $('#board-curpage').val();
	
	//새대댓글 (부모댓글 boardseq, content, 글고유번호)
	location.href = 'BOARD_rereInsert.do?boardseq=' + boardseq + '&content=' + content +'&parentboardseq=' + parentboardseq +'&curPage=' + curPage ;
	//댓글작성폼 초기화
	$('.form-control').val(' ');
}

