package com.job.coverletter.model.school.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.job.coverletter.model.school.dao.SchoolDao;

@Service
public class SchoolBizImpl implements SchoolBiz {
	@Autowired
	private SchoolDao schooldao;

}
