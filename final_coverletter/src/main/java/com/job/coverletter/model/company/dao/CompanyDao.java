package com.job.coverletter.model.company.dao;

import java.util.List;
import com.job.coverletter.all.pagination.MariaPagination;
import com.job.coverletter.model.company.dto.CompanyDto;

public interface CompanyDao {
	String NAMESPACE = "com.job.coverletter.Company.";
	
	// 전체 선택
	public List<CompanyDto> selectList(MariaPagination pagination);
	

	// 하나선택
	public CompanyDto selectOne(int companyseq);
	
	// 총 게시글 수
	public int	companyListCount();
	
	//메인화면 리스트 20개 출력
	public List<CompanyDto> selectList_cnt20(int startList);

	//회사가 가지고 있는 그룹번호
	public List<CompanyDto> selectAll_group(int groupno);


	
	//메인 웹개발자(4개)
	
	public List<CompanyDto> selectList_web();
	
	//메인 프론트앤드 (4개)
	
	public List<CompanyDto> selectList_front();
	
	//메인 백앤드 (4개)
	
	public List<CompanyDto> selectList_back();
	

	

}
