package com.job.coverletter.model.skill.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.job.coverletter.model.skill.dto.SkillDto;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Repository
public class SkillDaoImpl implements SkillDao {

	@Autowired
	@Qualifier("sqlSessionTemPlate")
	private SqlSessionTemplate sqlSession;
	
		
}
