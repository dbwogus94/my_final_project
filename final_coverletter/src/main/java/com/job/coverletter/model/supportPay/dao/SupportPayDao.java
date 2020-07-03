package com.job.coverletter.model.supportPay.dao;

import java.util.List;

import com.job.coverletter.model.supportPay.dto.SupportPayDto;

public interface SupportPayDao {
	String NAMESPACE = "com.job.coverletter.SupportPay.";
	
	public int payInsert(SupportPayDto dto);
	
	public int payListCount(SupportPayDto dto);
	public List<SupportPayDto> payList(SupportPayDto dto);

}
