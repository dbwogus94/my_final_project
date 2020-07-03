/*---------- 
 * curPage = 
 * 페이징 시 필요한 현재 머물러있는 페이지
 * 이걸 계속 넘겨줘야 뒤로가기 눌렀을 때 해당 페이지로 고정된다.
 * 예를 들어 현재 글이 3페이지에 존재하는 글이라면, 그 정보를 계속 넘겨줘야 댓글작성 등 작업 후에 뒤로가기했을때
 * 3페이지에 머물러 있음
 * ----------*/
curPage = $('.paging-focus').text();


/*---------- 페이징 : paging func ----------*/
function paging(curPage) {
	location.href = "USER_userPFList.do?curPage=" + curPage;
}

/*---------- 상세글보기 : boardDetail func ----------*/
//function boardDetail(boardseq) {
//	var curPage = $('.paging-focus').text();
//	location.href='BOARD_boardDetail.do?boardseq=' + boardseq + '&curPage=' + curPage;
//}

/*---------- 검 색 : search func ----------*/
function search() {
	
	// category : 제목(title), 본문(content), 작성자(joinemail)
	var category = $('#search-category').val();
	// keyword : input keyword
	var keyword = $('#keyword').val();
	
	// controller
	location.href='USER_userPFList.do?category=' + category + '&keyword=' + keyword;
}

/*---------- 검색(엔터치면 입력) : onKeyDown func ----------*/
function onKeyDown() {
    if(event.keyCode == 13) {
         search();
    }
}

$(function(){
	$("#all").click(function(){
		if( $("#all").prop("checked") ) {
			$("input[name=chk]").prop("checked",true);
		}else {
			$("input[name=chk]").prop("checked",false);
		}
	});
	
	$("input[name=chk]").click(function(){
		if( $("input[name=chk]").length == $("input[name=chk]:checked").length ){
			$("#all").prop("checked",true);
		}else{
			$("#all").prop("checked",false);
		}
	});
})

function deleteSubmit() {
	
	if ($("input[name=chk]:checked").length == 0) {
		$('.modal-title').addClass('glyphicon glyphicon-alert');
		$('.modal-title').text(' ERROR');
		$('.modal-body').text('내용을 입력해주세요.');
		$('#myModal').modal('show');

		return false;
		
	} else {
		var form = $('form');
		form.submit();
		
	}

}
