package com.job.coverletter.model.coverletter.dto;

import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class CoverLetterDto {

   // 시퀀스
   private int coverletterseq;

   // 이메일(ID)
   private String joinemail;

   // 구분
   private String cvcategory;

   // 그룹시퀀스
   private int groupseq;

   // 작업단위 그룹번호
   private int groupno;

   // 항목(질문), 수행기간
   private String question;

   // 제목, 프로젝트명
   @NotEmpty(message = "제목을 입력하여 주세요.")
   private String title;

   // 소제목, 개발목표
   private String subtitle;

   // 내용, 개발환경
   private String content;

   // 구현기능
   private String functions;

   // 담당역할
   private String positions;

   // 참여도
   private String participation;

   // 기능설명
   private String functioninfo;

   // 화면설명
   private String viewinfo;

   // 작성일
   private Date regdate;

   // 파일경로
   private String filepath;

   private List<MultipartFile> fileUpload;

   // 페이징
   private int StartIndex;
   private int CntPerPage;
   // 현재페이지
   private int curPage;

   /*---------- 검색 ----------*/
   private String category;
   private String keyword;

   public CoverLetterDto() {
      super();
   }

   public CoverLetterDto(int coverletterseq, String joinemail, String cvcategory, int groupseq, int groupno,
         String question, String title, String subtitle, String content, String functions, String positions,
         String participation, String functioninfo, String viewinfo, Date regdate, String filepath, int startIndex,
         int cntPerPage, int curPage, String category, String keyword) {
      super();
      this.coverletterseq = coverletterseq;
      this.joinemail = joinemail;
      this.cvcategory = cvcategory;
      this.groupseq = groupseq;
      this.groupno = groupno;
      this.question = question;
      this.title = title;
      this.subtitle = subtitle;
      this.content = content;
      this.functions = functions;
      this.positions = positions;
      this.participation = participation;
      this.functioninfo = functioninfo;
      this.viewinfo = viewinfo;
      this.regdate = regdate;
      this.filepath = filepath;
      StartIndex = startIndex;
      CntPerPage = cntPerPage;
      this.curPage = curPage;
      this.category = category;
      this.keyword = keyword;
   }

   public int getCoverletterseq() {
      return coverletterseq;
   }

   public void setCoverletterseq(int coverletterseq) {
      this.coverletterseq = coverletterseq;
   }

   public String getJoinemail() {
      return joinemail;
   }

   public void setJoinemail(String joinemail) {
      this.joinemail = joinemail;
   }

   public String getCvcategory() {
      return cvcategory;
   }

   public void setCvcategory(String cvcategory) {
      this.cvcategory = cvcategory;
   }

   public int getGroupseq() {
      return groupseq;
   }

   public void setGroupseq(int groupseq) {
      this.groupseq = groupseq;
   }

   public int getGroupno() {
      return groupno;
   }

   public void setGroupno(int groupno) {
      this.groupno = groupno;
   }

   public String getQuestion() {
      return question;
   }

   public void setQuestion(String question) {
      this.question = question;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getSubtitle() {
      return subtitle;
   }

   public void setSubtitle(String subtitle) {
      this.subtitle = subtitle;
   }

   public String getContent() {
      return content;
   }

   public void setContent(String content) {
      this.content = content;
   }

   public String getFunctions() {
      return functions;
   }

   public void setFunctions(String functions) {
      this.functions = functions;
   }

   public String getPositions() {
      return positions;
   }

   public void setPositions(String positions) {
      this.positions = positions;
   }

   public String getParticipation() {
      return participation;
   }

   public void setParticipation(String participation) {
      this.participation = participation;
   }

   public String getFunctioninfo() {
      return functioninfo;
   }

   public void setFunctioninfo(String functioninfo) {
      this.functioninfo = functioninfo;
   }

   public String getViewinfo() {
      return viewinfo;
   }

   public void setViewinfo(String viewinfo) {
      this.viewinfo = viewinfo;
   }

   public Date getRegdate() {
      return regdate;
   }

   public void setRegdate(Date regdate) {
      this.regdate = regdate;
   }

   public String getFilepath() {
      return filepath;
   }

   public void setFilepath(String filepath) {
      this.filepath = filepath;

   }

   public List<MultipartFile> getFileUpload() {
      return fileUpload;
   }

   public void setFileUpload(List<MultipartFile> fileUpload) {
      this.fileUpload = fileUpload;
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
      return "CoverLetterDto [coverletterseq=" + coverletterseq + ", joinemail=" + joinemail + ", cvcategory="
            + cvcategory + ", groupseq=" + groupseq + ", groupno=" + groupno + ", question=" + question + ", title="
            + title + ", subtitle=" + subtitle + ", content=" + content + ", functions=" + functions
            + ", positions=" + positions + ", participation=" + participation + ", functioninfo=" + functioninfo
            + ", viewinfo=" + viewinfo + ", regdate=" + regdate + ", filepath=" + filepath + ", StartIndex="
            + StartIndex + ", CntPerPage=" + CntPerPage + ", curPage=" + curPage + ", category=" + category
            + ", keyword=" + keyword + "]";
   }

}