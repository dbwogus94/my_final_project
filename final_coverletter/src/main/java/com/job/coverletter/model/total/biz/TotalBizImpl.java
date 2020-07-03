package com.job.coverletter.model.total.biz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.coverletter.model.total.dao.TotalDao;
import com.job.coverletter.model.total.dto.TotalDto;

import net.sf.json.JSONArray;


@Service
public class TotalBizImpl implements TotalBiz {
	
	@Autowired
	private TotalDao totaldao;

	@Override
	public int ToTalInsert(TotalDto dto) {
		return totaldao.ToTalInsert(dto);
	}
	
	@Override
	public TotalDto selectOne(String joinemail) {
		return totaldao.selectOne(joinemail);
	}

	@Override
	public int updateOne(TotalDto dto) {
		return totaldao.updateOne(dto);
	}
	

	@Override
	public JSONArray selectItSkill(String joinemail) {
		// TODO Auto-generated method stub
		return totaldao.selectItSkill(joinemail);
	}

	@Override
	public JSONArray selectMySkill(String joinemail) {
		// TODO Auto-generated method stub
		return totaldao.selectMySkill(joinemail);
	}

	

}
