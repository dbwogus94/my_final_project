package com.job.coverletter.model.company.biz;

import java.util.List;


import com.job.coverletter.all.pagination.MariaPagination;
import com.job.coverletter.model.company.dto.CompanyDto;

public interface CompanyBiz {
	
	
	// 전체 선택
	public List<CompanyDto> selectList(MariaPagination pagination);
	
	// 하나선택
	public CompanyDto selectOne(int companyseq);
	
	// 총 게시글 수
	public int	companyListCount();
	

	//회사목록

	public List<CompanyDto> selectList_cnt20(int startList);
	
	//회사 채용진행 정보를 위한 그룹번호
	
	public List<CompanyDto> selectAll_group(int groupno);

	//메인에 웹 개발자 모집(4개)
	public List<CompanyDto> selectList_web();
	//메인에 프론트 개발자 모집(4개)
	public List<CompanyDto> selectList_front();
	//메인에 백앤드개발자 모집(4개)
	public List<CompanyDto> selectList_back();
	
}
