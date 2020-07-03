package com.job.coverletter.model.company.dto;

import org.springframework.web.multipart.MultipartFile;

public class CompanyDto {
	// 시퀀스
	private int companyseq;

	// 그룹번호
	private int groupno;

	// 회사명
	private String companyname;

	// 이미지url
	private String imgurl;

	// 한 줄 소개
	private String oneintro;

	// 채용분야 웹, 프론트, 백, ...
	private String business;

	// 주요업무
	private String mainbusiness;

	// 채용상세
	private String jobdetail;

	// 연봉
	private String salary;

	// 경력OR신입 마감일 or 상시모집
	private String target;

	// 언어특기
	private String languages;

	// 마감일
	private String enddate;

	// 기업 소개글
	private String intro;

	// 개인장비 복지해택
	private String givetool;

	// 자기개발 복지해택
	private String selfgrowth;

	// 식사시간 복지해택
	private String mealtime;

	// 연차휴가 복지해택
	private String holiday;

	// 근무형태 복지해택
	private String workinghour;

	// 보험의료 복지해택
	private String insurance;

	// 설립일 기업상세정보
	private String incorporation;

	// 구성원 기업상세정보
	private String totalmember;

	// 홈페이지 기업상세정보
	private String homepage;

	// 사무실위치 기업상세정보
	private String location;

	// 산업분야 기업상세정보
	private String mainfield;

	private String from;

	public CompanyDto() {
		super();
	}

	public CompanyDto(int companyseq, int groupno, String companyname, String imgurl, String oneintro, String business,
			String mainbusiness, String jobdetail, String salary, String target, String languages, String enddate,
			String intro, String givetool, String selfgrowth, String mealtime, String holiday, String workinghour,
			String insurance, String incorporation, String totalmember, String homepage, String location,
			String mainfield, String from) {
		super();
		this.companyseq = companyseq;
		this.groupno = groupno;
		this.companyname = companyname;
		this.imgurl = imgurl;
		this.oneintro = oneintro;
		this.business = business;
		this.mainbusiness = mainbusiness;
		this.jobdetail = jobdetail;
		this.salary = salary;
		this.target = target;
		this.languages = languages;
		this.enddate = enddate;
		this.intro = intro;
		this.givetool = givetool;
		this.selfgrowth = selfgrowth;
		this.mealtime = mealtime;
		this.holiday = holiday;
		this.workinghour = workinghour;
		this.insurance = insurance;
		this.incorporation = incorporation;
		this.totalmember = totalmember;
		this.homepage = homepage;
		this.location = location;
		this.mainfield = mainfield;
		this.from = from;
	}



	public int getCompanyseq() {
		return companyseq;
	}

	public void setCompanyseq(int companyseq) {
		this.companyseq = companyseq;
	}

	public int getGroupno() {
		return groupno;
	}

	public void setGroupno(int groupno) {
		this.groupno = groupno;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public String getOneintro() {
		return oneintro;
	}

	public void setOneintro(String oneintro) {
		this.oneintro = oneintro;
	}

	public String getBusiness() {
		return business;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

	public String getMainbusiness() {
		return mainbusiness;
	}

	public void setMainbusiness(String mainbusiness) {
		this.mainbusiness = mainbusiness;
	}

	public String getJobdetail() {
		return jobdetail;
	}

	public void setJobdetail(String jobdetail) {
		this.jobdetail = jobdetail;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getGivetool() {
		return givetool;
	}

	public void setGivetool(String givetool) {
		this.givetool = givetool;
	}

	public String getSelfgrowth() {
		return selfgrowth;
	}

	public void setSelfgrowth(String selfgrowth) {
		this.selfgrowth = selfgrowth;
	}

	public String getMealtime() {
		return mealtime;
	}

	public void setMealtime(String mealtime) {
		this.mealtime = mealtime;
	}

	public String getHoliday() {
		return holiday;
	}

	public void setHoliday(String holiday) {
		this.holiday = holiday;
	}

	public String getWorkinghour() {
		return workinghour;
	}

	public void setWorkinghour(String workinghour) {
		this.workinghour = workinghour;
	}

	public String getInsurance() {
		return insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	public String getIncorporation() {
		return incorporation;
	}

	public void setIncorporation(String incorporation) {
		this.incorporation = incorporation;
	}

	public String getTotalmember() {
		return totalmember;
	}

	public void setTotalmember(String totalmember) {
		this.totalmember = totalmember;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getMainfield() {
		return mainfield;
	}

	public void setMainfield(String mainfield) {
		this.mainfield = mainfield;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	@Override
	public String toString() {
		return "CompanyDto [companyseq=" + companyseq + ", groupno=" + groupno + ", companyname=" + companyname
				+ ", imgurl=" + imgurl + ", oneintro=" + oneintro + ", business=" + business + ", mainbusiness="
				+ mainbusiness + ", jobdetail=" + jobdetail + ", salary=" + salary + ", target=" + target
				+ ", languages=" + languages + ", enddate=" + enddate + ", intro=" + intro + ", givetool=" + givetool
				+ ", selfgrowth=" + selfgrowth + ", mealtime=" + mealtime + ", holiday=" + holiday + ", workinghour="
				+ workinghour + ", insurance=" + insurance + ", incorporation=" + incorporation + ", totalmember="
				+ totalmember + ", homepage=" + homepage + ", location=" + location + ", mainfield=" + mainfield + "]";
	}

}
