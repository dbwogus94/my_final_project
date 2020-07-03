package com.job.coverletter.model.board.biz;

import java.util.List;

import com.job.coverletter.model.board.dto.BoardDto;

public interface BoardBiz {
	// 총 게시글 수
	public int boardListCount(BoardDto dto);

	// 글목록 (페이징)
	public List<BoardDto> boardList(BoardDto dto);

	// 글작성
	public int boardInsert(BoardDto dto);

	// 글상세
	public BoardDto boardDetail(BoardDto dto);

	// 글수정
	public int boardUpdate(BoardDto dto);

	// 글삭제 (달린 댓글도 다 같이 삭제)
	public int boardDelete(int groupno);

	// 댓글상세
	public List<BoardDto> replyList(BoardDto dto);

	// 댓글작성
	public int replyInsert(BoardDto dto);

	// 대댓글작성
	public int rereInsert(BoardDto dto);

	// 댓글삭제
	public int replyDelete(int groupno);
}
