package com.job.coverletter.model.company.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import com.job.coverletter.all.pagination.MariaPagination;
import com.job.coverletter.model.board.dto.BoardDto;
import com.job.coverletter.model.company.dto.CompanyDto;

@Repository
public class CompanyDaoImpl implements CompanyDao {

	@Resource
	private SqlSessionTemplate sqlSessionTemPlateMariaDB;

	// 전체선택 + 페이징
	@Override
	public List<CompanyDto> selectList(MariaPagination pagination) {
		return sqlSessionTemPlateMariaDB.selectList(NAMESPACE + "selectList", pagination);
	}

	// 하나 선택
	@Override
	public CompanyDto selectOne(int companyseq) {
		return sqlSessionTemPlateMariaDB.selectOne(NAMESPACE + "selectOne", companyseq);
	}

	// 전체 게시판 개수 가져오기
	@Override
	public int companyListCount() {
		return sqlSessionTemPlateMariaDB.selectOne(NAMESPACE + "companyListCount");
	}

	@Override
	public List<CompanyDto> selectList_cnt20(int startList) {

		return sqlSessionTemPlateMariaDB.selectList(NAMESPACE + "selectList_cnt20", startList);
	}

	@Override
	public List<CompanyDto> selectAll_group(int groupno) {

		List<CompanyDto> dto = sqlSessionTemPlateMariaDB.selectList(NAMESPACE + "selectAll_group", groupno);

		return dto;
	}

	@Override
	public List<CompanyDto> selectList_web() {
		return sqlSessionTemPlateMariaDB.selectList(NAMESPACE + "selectList_web");
	}

	@Override
	public List<CompanyDto> selectList_front() {
 
		return sqlSessionTemPlateMariaDB.selectList(NAMESPACE + "selectList_front");
	}

	@Override
	public List<CompanyDto> selectList_back() {
		return sqlSessionTemPlateMariaDB.selectList(NAMESPACE + "selectList_back");
	}

}
