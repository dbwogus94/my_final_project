package com.job.coverletter.model.company.biz;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.job.coverletter.all.pagination.MariaPagination;
import com.job.coverletter.model.company.dao.CompanyDao;
import com.job.coverletter.model.company.dto.CompanyDto;

@Service
public class CompanyBizImpl implements CompanyBiz {

	@Autowired
	private CompanyDao companydao;

	@Override
	public List<CompanyDto> selectList(MariaPagination pagination) {
		return companydao.selectList(pagination);
	}

	@Override
	public CompanyDto selectOne(int companyseq) {
		return companydao.selectOne(companyseq);
	}

	@Override
	public int companyListCount() {
		return companydao.companyListCount();
	}

	@Override
	public List<CompanyDto> selectList_cnt20(int startList) {

		return companydao.selectList_cnt20(startList);
	}

	@Override
	public List<CompanyDto> selectAll_group(int groupno) {

		return companydao.selectAll_group(groupno);
	}

	@Override
	public List<CompanyDto> selectList_web() {

		return companydao.selectList_web();
	}

	@Override
	public List<CompanyDto> selectList_front() {
		return companydao.selectList_front();
	}

	@Override
	public List<CompanyDto> selectList_back() {
		return companydao.selectList_back();
	}

}
