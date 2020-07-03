package com.job.coverletter.model.supportPay.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.job.coverletter.model.jobcalendar.dto.JobCalendarDto;
import com.job.coverletter.model.supportPay.dto.SupportPayDto;

@Repository
public class SupportPayDaoImpl implements SupportPayDao {
	
	@Autowired  @Qualifier("sqlSessionTemPlate")
	private SqlSessionTemplate sqlSession;

	@Override
	public int payInsert(SupportPayDto dto) {
		
		int res = 0;
		try {
			res = sqlSession.insert(NAMESPACE + "payInsert", dto);
		} catch (Exception e) {
			System.out.println("[error] : payInsert");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int payListCount(SupportPayDto dto) {
		  int res = 0;
	      try {
	         res = sqlSession.selectOne(NAMESPACE + "payListCount", dto); 
	      } catch (Exception e) {
	         System.out.println("[error] : payListCount");
	         e.printStackTrace();
	      }
	      return res;
	}

	@Override
	public List<SupportPayDto> payList(SupportPayDto dto) {
		List<SupportPayDto> list = new ArrayList<SupportPayDto>();
	      try {
	         list = sqlSession.selectList(NAMESPACE + "payList", dto);
	      } catch (Exception e) {
	         System.out.println("[error] : payList");
	         e.printStackTrace();
	      }
	      return list;}

}
