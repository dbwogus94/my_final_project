package com.job.coverletter.all;

//페이징처리
public class Pagination {

	// 한 페이지당 게시글 수 (목록에 표시될 글 개수)
	private int pageSize = 10;

	// 한 블록(range)당 페이지 수 (예를 들어 10개면 << 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 >> )
	private int rangeSize = 5;

	// 현재 페이지
	private int curPage;

	// 현재 블록
	private int curRange = 1;

	// 총 게시글 수
	private int listCnt;

	// 총 페이지 수
	private int pageCnt;

	// 총 블록 수
	private int rangeCnt;

	// 시작 페이지
	private int startPage = 1;

	// 끝 페이지
	private int endPage = 1;

	// 시작 인덱스
	private int startIndex = 0;

	// 이전 페이지
	private int prevPage;

	// 다음 페이지
	private int nextPage;

	public Pagination() {
		super();
	}

	/*---------- 페이징 생성자 ----------*/
	// boardController param : 총 게시물 수, 현재 페이지
	// 페이징 처리 순서 1. 총 페이지 수 2. 총 블록 수 (range) 3. 블록 세팅 (range setting)
	public Pagination(int listCnt, int curPage) {	//총 게시글 수, 현재페이지

		// 총 페이지 수
		setPageCnt(listCnt);

		// 총 게시글 수
		setListCnt(listCnt);

		// 총 블록 수
		setRangeCnt(pageCnt);

		// 블록 세팅
		rangeSetting(curPage);

		// 현재 페이지
		setCurPage(curPage);

		// db쿼리문 작성
		setStartIndex(curPage); // 페이지당 가져올 게시글 시작 시퀀스
	}

	/*---------- 총 페이지 수  ----------*/
	public void setPageCnt(int listCnt) {
		this.pageCnt = (int) Math.ceil(listCnt * 1.0 / pageSize);	// 소수점 올림
	}

	/*---------- 총 블록 수  ----------*/
	public void setRangeCnt(int pageCnt) {
		this.rangeCnt = (int) Math.ceil(pageCnt * 1.0 / rangeSize);
	}

	/*---------- 블록세팅 : 현재 페이지 기준으로 현재 블록 세팅 ----------*/
	public void rangeSetting(int curPage) {

		setCurRange(curPage);
		this.startPage = (curRange - 1) * rangeSize + 1;
		this.endPage = startPage + rangeSize - 1;

		if (endPage > pageCnt) {
			this.endPage = pageCnt;
		}

		this.prevPage = curPage - 1;
		this.nextPage = curPage + 1;
	}

	/*---------- 현재 페이지 기준 현재 블록  ----------*/
	public void setCurRange(int curPage) {
		this.curRange = (int) ((curPage - 1) / rangeSize) + 1;
	}

	/*---------- 쿼리문 작성을 위한 시작 인덱스  ----------*/
	public void setStartIndex(int curPage) {
		this.startIndex = ((curPage - 1) * pageSize);
		// (1페이지 -1) * 10 = 0 >>> 0번부터 시작 >>> 쿼리문에서 +1을 해준다
	}

	public void setListCnt(int listCnt) {
		this.listCnt = listCnt;
	}

	/*---------- 기본 getter setter  ----------*/
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getRangeSize() {
		return rangeSize;
	}

	public void setRangeSize(int rangeSize) {
		this.rangeSize = rangeSize;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getCurRange() {
		return curRange;
	}

	public int getListCnt() {
		return listCnt;
	}

	public int getPageCnt() {
		return pageCnt;
	}

	public int getRangeCnt() {
		return rangeCnt;
	}

	public int getStartIndex() {
		return startIndex;
	}

}