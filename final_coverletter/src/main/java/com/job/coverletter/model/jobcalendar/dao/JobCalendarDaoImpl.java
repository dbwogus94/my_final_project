package com.job.coverletter.model.jobcalendar.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.job.coverletter.model.coverletter.dto.CoverLetterDto;
import com.job.coverletter.model.jobcalendar.dto.JobCalendarDto;

@Repository
public class JobCalendarDaoImpl implements JobCalendarDao {

	@Autowired
	@Qualifier("sqlSessionTemPlate")
	private SqlSessionTemplate sqlSession;

	@Override
	public int boardJobListCount(JobCalendarDto dto) {
		int res = sqlSession.selectOne(NAMESPACE + "boardJobListCount", dto);
		return res;
	}

	@Override
	public List<JobCalendarDto> boardJobList(JobCalendarDto dto) {
		List<JobCalendarDto> list = new ArrayList<JobCalendarDto>();
		try {
			list = sqlSession.selectList(NAMESPACE + "boardJobList", dto);
		} catch (Exception e) {
			System.out.println("[error] : boardJobList");
			e.printStackTrace();
		}
		return list;
	}

	// 풀캘 데이터 조회
	@Override
	public List<JobCalendarDto> getFullCalendarData(String joinemail) {
		return sqlSession.selectList(NAMESPACE + "getFullCalendarData", joinemail);
	}

	// 채용캘린더 즐겨찾기 추가
	@Override
	public int boardJobInsert(JobCalendarDto dto) {
		int res = sqlSession.insert(NAMESPACE + "boardJobInsert", dto);
		return res;
	}

	// 즐겨찾기 유무
	@Override
	public boolean isJobBookmark(JobCalendarDto dto) {
		System.out.println("dao 확인1 : " + dto);
		JobCalendarDto jobCalendarDto = sqlSession.selectOne(NAMESPACE + "isJobBookmark", dto);
		System.out.println("dao 확인2 : " + jobCalendarDto);

		if (jobCalendarDto == null) { // 값이 없으면 사용가능
			return true;
		} else {
			return false;
		}
	}

	// 즐겨찾기 삭제
	@Override
	public int bookmarkDelete(JobCalendarDto dto) {
		int res = sqlSession.delete(NAMESPACE + "bookmarkDelete", dto);
		return res;
	}

}