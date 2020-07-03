package com.job.coverletter.model.jobcalendar.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.coverletter.model.jobcalendar.dao.JobCalendarDao;
import com.job.coverletter.model.jobcalendar.dto.JobCalendarDto;

@Service
public class JobCalendarBizImpl implements JobCalendarBiz {

	@Autowired
	private JobCalendarDao jobcalendardao;

	@Override
	public int boardJobListCount(JobCalendarDto dto) {
		return jobcalendardao.boardJobListCount(dto);
	}

	@Override
	public List<JobCalendarDto> boardJobList(JobCalendarDto dto) {
		return jobcalendardao.boardJobList(dto);
	}

	// 풀캘 데이터 조회
	@Override
	public List<JobCalendarDto> getFullCalendarData(String joinemail) {
		return jobcalendardao.getFullCalendarData(joinemail);
	}
	
	//채용 개시판 즐겨찾기 추가
	@Override
	public int boardJobInsert(JobCalendarDto dto) {
		return jobcalendardao.boardJobInsert(dto);
	}

	// 즐겨찾기 유무
	@Override
	public boolean isJobBookmark(JobCalendarDto dto) {
		return jobcalendardao.isJobBookmark(dto);
	}

	
	// 즐겨찾기 삭제
	@Override
	public int bookmarkDelete(JobCalendarDto dto) {
		return jobcalendardao.bookmarkDelete(dto);
	}

	

}