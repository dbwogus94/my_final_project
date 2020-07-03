package com.job.coverletter.model.qnaboard.dao;

import java.util.List;

import com.job.coverletter.model.qnaboard.dto.QnaBoardDto;

public interface QnaBoardDao {
	
	String NAMESPACE = "com.job.coverletter.QnaBoard.";
	
	public QnaBoardDto boardQnaListOne(int seq);
	
	public QnaBoardDto QnaAnswer(int qnaboardseq);
	
	public int boardQnaListCount();
}
