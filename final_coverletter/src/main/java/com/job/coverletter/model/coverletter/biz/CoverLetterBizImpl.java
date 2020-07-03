package com.job.coverletter.model.coverletter.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.coverletter.all.util.MultiRowTarget;
import com.job.coverletter.model.coverletter.dao.CoverLetterDao;
import com.job.coverletter.model.coverletter.dto.CoverLetterDto;

@Service
public class CoverLetterBizImpl implements CoverLetterBiz {

	@Autowired
	private CoverLetterDao coverletterdao;

	// 유저별 자기소개서 총개수
	@Override
	public int boardCVListCount(CoverLetterDto dto) {
		return coverletterdao.boardCVListCount(dto);
	}

	// 유저별 자기소개서 목록 select
	@Override
	public List<CoverLetterDto> boardCVList(CoverLetterDto dto) {
		return coverletterdao.boardCVList(dto);
	}

	// 자기소개서 insert
	@Override
	public int CVinsert(CoverLetterDto dto) {
		return coverletterdao.CVinsert(dto);
	}

	// 유저별 타이틀 기준으로 같은 자기소개서 목록 select
	@Override
	public List<CoverLetterDto> CVselectList(CoverLetterDto dto) {
		return coverletterdao.CVselectList(dto);
	}

	// 자기소개서 delete(멀티삭제)
	@Override
	public int CVdelete(String[] seq) {
		return coverletterdao.CVdelete(seq);
	}

// =================== 포토폴리오 메서드 시작 =====================	
	
	// 유저별 포토폴리오 총 개수
	@Override
	public int boardPFListCount(CoverLetterDto dto) {
		return coverletterdao.boardPFListCount(dto);
	}

	// 유저별 포토폴리오 목록 select
	@Override
	public List<CoverLetterDto> boardPFList(CoverLetterDto dto) {
		return coverletterdao.boardPFList(dto);
	}

	// 유저별 포폴 가장 큰 그룹번호
	@Override
	public CoverLetterDto getGroupno(String joinemail) {
		System.out.println("biz 그룹 실행 ");
		CoverLetterDto dto = coverletterdao.getGroupno(joinemail);
		System.out.println("biz 그룹 실행 res" + dto);
		return dto;
	}

	// 포토폴리오 insert
	@Override
	public int PFwrite(CoverLetterDto dto) {
		System.out.println("biz 실행 ");
		return coverletterdao.PFwrite(dto);
	}

	// 유저별 그룹번호를 기준으로 포토폴리오 목록 select
	@Override
	public List<CoverLetterDto> PFselectGroupnoList(CoverLetterDto dto) {
		return coverletterdao.PFselectGroupnoList(dto);
	}

	// 포토폴리오 delete(멀티삭제)
	@Override
	public int PFdelete(String[] seq) {
		return coverletterdao.PFdelete(seq);
	}
}
