package com.job.coverletter.model.qnaboard.dto;

public class QnaBoardDto {

    // 시퀀스 
    private int qnaboardseq;

    // 문제 
    private String question;

    // 답 
    private String answer;
    
    public QnaBoardDto() {
		super();
	}

	public QnaBoardDto(int qnaboardseq, String question, String answer) {
		super();
		this.qnaboardseq = qnaboardseq;
		this.question = question;
		this.answer = answer;
	}

	public int getqnaboardseq() {
        return qnaboardseq;
    }

    public void setqnaboardseq(int qnaboardseq) {
        this.qnaboardseq = qnaboardseq;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

	@Override
	public String toString() {
		return "QnaBoardDto [qnaboardseq=" + qnaboardseq + ", question=" + question + ", answer=" + answer + "]";
	}

}