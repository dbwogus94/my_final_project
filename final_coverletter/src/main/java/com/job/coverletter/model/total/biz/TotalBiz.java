package com.job.coverletter.model.total.biz;

import com.job.coverletter.model.total.dto.TotalDto;

import net.sf.json.JSONArray;

public interface TotalBiz {
	public int ToTalInsert(TotalDto dto);

	// 선택
	public TotalDto selectOne(String joinemail);

	// 업데이트
	public int updateOne(TotalDto dto);

	// IT역량차트
	public JSONArray selectItSkill(String joinemail);

	// 스킬차트
	public JSONArray selectMySkill(String joinemail);

}
