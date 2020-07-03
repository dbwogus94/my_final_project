package com.job.coverletter.model.qnaboard.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.job.coverletter.model.qnaboard.dto.QnaBoardDto;
@Repository
public class QnaBoardDaoImpl implements QnaBoardDao {

	@Autowired
	@Qualifier("sqlSessionTemPlate")
	private SqlSessionTemplate sqlSession;

	@Override
	public QnaBoardDto boardQnaListOne(int seq) {
		QnaBoardDto list = null;

		try {
			list = sqlSession.selectOne(NAMESPACE + "boardList",seq);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("boardList");
		}

		return list;
	}

	@Override
	public QnaBoardDto QnaAnswer(int qnaboardseq) {
		QnaBoardDto dto = new QnaBoardDto();
		
		try {
			dto = sqlSession.selectOne(NAMESPACE + "qnaAnswer",qnaboardseq);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}

	@Override
	public int boardQnaListCount() {
		
		int res = 0;
		
		try {
			res = sqlSession.selectOne(NAMESPACE+"boardCount");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return res;
	}
	
	

}
