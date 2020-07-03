package com.job.coverletter.model.supportPay.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.job.coverletter.model.supportPay.dao.SupportPayDao;
import com.job.coverletter.model.supportPay.dto.SupportPayDto;

@Service
public class SupportPayBizImpl implements SupportPayBiz {
	@Autowired
	private SupportPayDao supportpaydao;

	@Override
	public int payInsert(SupportPayDto dto) {
		return supportpaydao.payInsert(dto);
	}

	@Override
	public int payListCount(SupportPayDto dto) {
		// TODO Auto-generated method stub
		return supportpaydao.payListCount(dto);
	}

	@Override
	public List<SupportPayDto> payList(SupportPayDto dto) {
		// TODO Auto-generated method stub
		return supportpaydao.payList(dto);
	}

}
