package com.job.coverletter.model.qnaboard.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.coverletter.model.qnaboard.dao.QnaBoardDao;
import com.job.coverletter.model.qnaboard.dto.QnaBoardDto;
@Service
public class QnaBoardBizImpl implements QnaBoardBiz {
	
	@Autowired
	private QnaBoardDao qnaboarddao;

	@Override
	public QnaBoardDto boardQnaListOne(int seq) {
		// TODO Auto-generated method stub
		return qnaboarddao.boardQnaListOne(seq);
	}

	@Override
	public QnaBoardDto QnaAnswer(int qnaboardseq) {
		// TODO Auto-generated method stub
		return qnaboarddao.QnaAnswer(qnaboardseq);
	}

	@Override
	public int boardQnaListCount() {
		return qnaboarddao.boardQnaListCount();
	}

}
