package com.job.coverletter.model.qnaboard.biz;

import java.util.List;

import com.job.coverletter.model.qnaboard.dto.QnaBoardDto;

public interface QnaBoardBiz {
	
	public QnaBoardDto boardQnaListOne(int seq);

	public QnaBoardDto QnaAnswer(int qnaboardseq);
	
	public int boardQnaListCount();
}
