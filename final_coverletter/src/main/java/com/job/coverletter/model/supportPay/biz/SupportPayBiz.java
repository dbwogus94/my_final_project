package com.job.coverletter.model.supportPay.biz;

import java.util.List;

import com.job.coverletter.model.supportPay.dto.SupportPayDto;

public interface SupportPayBiz {
	
	public int payInsert(SupportPayDto dto);
	
	public int payListCount(SupportPayDto dto);
	public List<SupportPayDto> payList(SupportPayDto dto);

}
