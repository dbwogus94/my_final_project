package com.job.coverletter.model.jobcalendar.dto;

public class JobCalendarDto {

	// 시퀀스
	private int jobcalendarseq;

	// 이메일(ID)
	private String joinemail;

	private int companyseq;
	// 회사명
	private String companyname;

	private String business;

	private String enddate;

	private int StartIndex;
	private int CntPerPage;
	// 현재페이지
	private int curPage;

	/*---------- 검색 ----------*/
	private String category;
	private String keyword;

	public JobCalendarDto() {
		super();
	}

	public JobCalendarDto(int jobcalendarseq, String joinemail, int companyseq, String companyname, String business,
			String enddate, int startIndex, int cntPerPage, int curPage, String category, String keyword) {
		super();
		this.jobcalendarseq = jobcalendarseq;
		this.joinemail = joinemail;
		this.companyseq = companyseq;
		this.companyname = companyname;
		this.business = business;
		this.enddate = enddate;
	}

	public int getJobcalendarseq() {
		return jobcalendarseq;
	}

	public void setJobcalendarseq(int jobcalendarseq) {
		this.jobcalendarseq = jobcalendarseq;
	}

	public String getJoinemail() {
		return joinemail;
	}

	public void setJoinemail(String joinemail) {
		this.joinemail = joinemail;
	}

	public int getCompanyseq() {
		return companyseq;
	}

	public void setCompanyseq(int companyseq) {
		this.companyseq = companyseq;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getBusiness() {
		return business;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public int getStartIndex() {
		return StartIndex;
	}

	public void setStartIndex(int startIndex) {
		StartIndex = startIndex;
	}

	public int getCntPerPage() {
		return CntPerPage;
	}

	public void setCntPerPage(int cntPerPage) {
		CntPerPage = cntPerPage;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "JobCalendarDto [jobcalendarseq=" + jobcalendarseq + ", joinemail=" + joinemail + ", companyseq="
				+ companyseq + ", companyname=" + companyname + ", business=" + business + ", enddate=" + enddate
				+ ", StartIndex=" + StartIndex + ", CntPerPage=" + CntPerPage + ", curPage=" + curPage + ", category="
				+ category + ", keyword=" + keyword + "]";
	}

	
}
