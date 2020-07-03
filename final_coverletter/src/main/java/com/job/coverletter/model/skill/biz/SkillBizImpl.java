package com.job.coverletter.model.skill.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.coverletter.model.skill.dao.SkillDao;

import net.sf.json.JSONArray;

@Service
public class SkillBizImpl implements SkillBiz {
	@Autowired
	private SkillDao skilldao;



}
