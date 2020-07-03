package com.job.coverletter.model.coverletter.biz;

import java.util.List;

import com.job.coverletter.all.util.MultiRowTarget;
import com.job.coverletter.model.coverletter.dto.CoverLetterDto;

public interface CoverLetterBiz {

	// 자기소개서 총 게시글 수
	public int boardCVListCount(CoverLetterDto dto);

	// 자기소개서 글목록 (페이징)
	public List<CoverLetterDto> boardCVList(CoverLetterDto dto);

	// 자기소개서 INSERT
	public int CVinsert(CoverLetterDto dto);

	// 자기소개서 같은 타이틀 기준으로 가져오기
	public List<CoverLetterDto> CVselectList(CoverLetterDto dto);

	// 자기소개서 삭제
	public int CVdelete(String[] seq);

	
	// 포토폴리오 총 게시글 수
	public int boardPFListCount(CoverLetterDto dto);

	// 포토폴리오 글목록 (페이징)
	public List<CoverLetterDto> boardPFList(CoverLetterDto dto);

	// 포토폴리오 그룹번호 가져오기
	public CoverLetterDto getGroupno(String joinemail);

	// 포토폴리오 작성
	public int PFwrite(CoverLetterDto dto);

	// 포토폴리오 같은 grupno를 기준으로 가져오기
	public List<CoverLetterDto> PFselectGroupnoList(CoverLetterDto dto);

	// 포토폴리오 삭제
	public int PFdelete(String[] seq);

}
