package com.job.coverletter.model.total.dto;

import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class TotalDto {
	//total_seq
	private int totalseq;
	// ----------------------JoinUserDto--------------------------
	// 회원번호(SEQ) 
    private int joinseq;

	 // 이메일(ID) 
    @NotEmpty(message = "이메일을 입력해주세요")
    @Email(message = "이메일 형식이 아닙니다.")
    private String joinemail;

    // 이름 
    @NotEmpty(message = "이름을 입력해주세요")
    @Pattern(regexp = "[가-힣]*$", message = "이름은 한글만 사용해주세요")
    private String joinname;

    // 비밀번호 
    @Pattern(regexp="^.*(?=.{6,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$", message = "숫자 영어 혼합으로 6~20자리로")
    private String joinpw;

    // 생년월일 
    @Pattern(regexp = "^[0-9]{8}$", message = "생년월일을 입력해주세요.")
    private String joinbirth;

    // 성별 
    @Pattern(regexp = "^(남성)|(여성)|(중성)$", message = "성별을 선택해주세요.")
    private String joinsex;

    // 사진 
    private String photo;

    // 병역 
    @Pattern(regexp = "^(미필)|(군필)|(면제)$", message = "병역을 선택해주세요.")
    private String mililtary;

    // 전화번호 
    @NotEmpty(message = "전화번호를 입력해주세요.")
    private String phone;

    // 주소
    @NotEmpty(message = "주소를 입력해주세요.")
    private String address;

    // 카카오 
    private String kakao;

    // 회원가입 여부 
    private String singup;
    
	// ----------------------SkillDto--------------------------
    
    // 시퀀스 
    private int skillseq;

    // 구분 IT,자격증,어학,공모전
    private String category;

    // it기술 IT
    @NotEmpty(message = "1번째 기술을 입력해주세요.")
    private String itskill1;
    @NotEmpty(message = "2번째 기술을 입력해주세요.")
    private String itskill2;
    @NotEmpty(message = "3번째 기술을 입력해주세요.")
    private String itskill3;
    @NotEmpty(message = "4번째 기술을 입력해주세요.")
    private String itskill4;
    @NotEmpty(message = "5번째 기술을 입력해주세요.")
    private String itskill5;
    
    

    // 점수 IT, 1~10
    @Pattern(regexp = "[0-9]$|(10)$", message = "1번째 기술의 점수를 표시해주세요")
    private String itscore1;
    @Pattern(regexp = "[0-9]$|(10)$", message = "2번째 기술의 점수를 표시해주세요")
    private String itscore2;
    @Pattern(regexp = "[0-9]$|(10)$", message = "3번째 기술의 점수를 표시해주세요")
    private String itscore3;
    @Pattern(regexp = "[0-9]$|(10)$", message = "4번째 기술의 점수를 표시해주세요")
    private String itscore4;
    @Pattern(regexp = "[0-9]$|(10)$", message = "5번째 기술의 점수를 표시해주세요")
    private String itscore5;
    

    // 자격증명(n급) 자격증
    private String certificate;

    // 공인시험명 어학점수
    private String languagename;

    // 공인시험점수 어학점수
    private String languagescore;
    
    // 취득일자 어학점수
    private String languageregdate;
    
    // 공모전명 공모전
    private String contest;

    // 수상이력 공모전
    private String prize;

    //발행기관 자격증
    private String organization;
    
    //시행기관 공모전참여이력
    private String startorganization;

    // 모든 취득일자 it는 제외, 자격증
    private String regdate;

	// ----------------------SchoolDto--------------------------

    // SCHOOLSEQ 
    private int schoolseq;

    @Pattern(regexp ="^(대졸)|(전문대졸)|(고졸)$", message = "학력구분을 선택해주세요.")
    private String career;

    @NotEmpty(message = "학교이름을 입력해주세요.")
    private String schoolname;
    
    @Pattern(regexp = "^([0-9][0-9])[.]([0][1-9])|([0-9][0-9])[.]([1][0-2])$", message = "YY.MM 형식으로 작성해주세요")
    private String admission;
    
    @Pattern(regexp = "^([0-9][0-9])[.]([0][1-9])|([0-9][0-9])[.]([1][0-2])$", message = "YY.MM 형식으로 작성해주세요")
    private String graduate;

    @NotEmpty(message = "전공을 입력해주세요.")
    private String major;
    
    @Pattern(regexp = "^[0-3][.]\\d{1}?$|[4][.][0-5]{1}?$",message = "학점은 4.5 형태로 입력해주세요")
    private String grade;

 // ----------------------JoinUserDto--------------------------
    
    
    
    public int getJoinseq() {
		return joinseq;
	}

	public int getTotalseq() {
		return totalseq;
	}

	public void setTotalseq(int totalseq) {
		this.totalseq = totalseq;
	}

	public void setJoinseq(int joinseq) {
		this.joinseq = joinseq;
	}
    
	public String getJoinemail() {
		return joinemail;
	}

	public void setJoinemail(String joinemail) {
		this.joinemail = joinemail;
	}

	public String getJoinname() {
		return joinname;
	}

	public void setJoinname(String joinname) {
		this.joinname = joinname;
	}

	public String getJoinpw() {
		return joinpw;
	}

	public void setJoinpw(String joinpw) {
		this.joinpw = joinpw;
	}

	public String getJoinbirth() {
		return joinbirth;
	}

	public void setJoinbirth(String joinbirth) {
		this.joinbirth = joinbirth;
	}

	public String getJoinsex() {
		return joinsex;
	}

	public void setJoinsex(String joinsex) {
		this.joinsex = joinsex;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getMililtary() {
		return mililtary;
	}

	public void setMililtary(String mililtary) {
		this.mililtary = mililtary;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getKakao() {
		return kakao;
	}

	public void setKakao(String kakao) {
		this.kakao = kakao;
	}

	public String getSingup() {
		return singup;
	}

	public void setSingup(String singup) {
		this.singup = singup;
	}
	
	
	
	public TotalDto() {
		
	}
	

	public TotalDto(int totalseq) {
		this.totalseq = totalseq;
	}

	public TotalDto(int joinseq, String joinemail, String joinname, String joinpw, String joinbirth, String joinsex, String photo, String mililtary, String phone,
			String address, String kakao, String singup) {
		this.joinseq = joinseq;
		this.joinemail = joinemail;
		this.joinname = joinname;
		this.joinpw = joinpw;
		this.joinbirth = joinbirth;
		this.joinsex = joinsex;
		this.photo = photo;
		this.mililtary = mililtary;
		this.phone = phone;
		this.address = address;
		this.kakao = kakao;
		this.singup = singup;
	}

	// ----------------------SkillDto--------------------------
	
	public int getSkillseq() {
		return skillseq;
	}

	public void setSkillseq(int skillseq) {
		this.skillseq = skillseq;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getItskill1() {
		return itskill1;
	}

	public void setItskill1(String itskill1) {
		this.itskill1 = itskill1;
	}
	

	public String getItskill2() {
		return itskill2;
	}

	public void setItskill2(String itskill2) {
		this.itskill2 = itskill2;
	}

	public String getItskill3() {
		return itskill3;
	}

	public void setItskill3(String itskill3) {
		this.itskill3 = itskill3;
	}

	public String getItskill4() {
		return itskill4;
	}

	public void setItskill4(String itskill4) {
		this.itskill4 = itskill4;
	}

	public String getItskill5() {
		return itskill5;
	}

	public void setItskill5(String itskill5) {
		this.itskill5 = itskill5;
	}

	public String getItscore1() {
		return itscore1;
	}

	public void setItscore1(String itscore1) {
		this.itscore1 = itscore1;
	}
	
	public String getItscore2() {
		return itscore2;
	}

	public void setItscore2(String itscore2) {
		this.itscore2 = itscore2;
	}

	public String getItscore3() {
		return itscore3;
	}

	public void setItscore3(String itscore3) {
		this.itscore3 = itscore3;
	}

	public String getItscore4() {
		return itscore4;
	}

	public void setItscore4(String itscore4) {
		this.itscore4 = itscore4;
	}

	public String getItscore5() {
		return itscore5;
	}

	public void setItscore5(String itscore5) {
		this.itscore5 = itscore5;
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public String getLanguagename() {
		return languagename;
	}

	public void setLanguagename(String languagename) {
		this.languagename = languagename;
	}

	public String getLanguagescore() {
		return languagescore;
	}

	public void setLanguagescore(String languagescore) {
		this.languagescore = languagescore;
	}
	

	public String getLanguageregdate() {
		return languageregdate;
	}

	public void setLanguageregdate(String languageregdate) {
		this.languageregdate = languageregdate;
	}

	public String getContest() {
		return contest;
	}

	public void setContest(String contest) {
		this.contest = contest;
	}

	public String getPrize() {
		return prize;
	}

	public void setPrize(String prize) {
		this.prize = prize;
	}

	public String getStartorganization() {
		return startorganization;
	}

	public void setStartorganization(String startorganization) {
		this.startorganization = startorganization;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public TotalDto(String joinemail, int skillseq, String category, String itskill1, String itskill2, String itskill3, String itskill4, String itskill5, String itscore1,String itscore2,String itscore3,String itscore4,String itscore5, String certificate, String languagename, String languagescore,String languageregdate, String contest,
			String prize, String organization, String startorganization, String regdate) {
		this.joinemail = joinemail;
		this.skillseq = skillseq;
		this.category = category;
		this.itskill1 = itskill1;
		this.itskill2 = itskill2;
		this.itskill3 = itskill3;
		this.itskill4 = itskill4;
		this.itskill5 = itskill5;
		
		this.itscore1 = itscore1;
		this.itscore2 = itscore2;
		this.itscore3 = itscore3;
		this.itscore4 = itscore4;
		this.itscore5 = itscore5;
		
		this.certificate = certificate;
		this.languagename = languagename;
		this.languagescore = languagescore;
		this.languageregdate = languageregdate;
		this.contest = contest;
		this.prize = prize;
		this.organization = organization;
		this.startorganization = startorganization;
		this.regdate = regdate;
	}

	// ----------------------SchoolDto--------------------------
	
	public int getSchoolseq() {
		return schoolseq;
	}

	public void setSchoolseq(int schoolseq) {
		this.schoolseq = schoolseq;
	}

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	public String getSchoolname() {
		return schoolname;
	}

	public void setSchoolname(String schoolname) {
		this.schoolname = schoolname;
	}

	public String getAdmission() {
		return admission;
	}

	public void setAdmission(String admission) {
		this.admission = admission;
	}

	public String getGraduate() {
		return graduate;
	}

	public void setGraduate(String graduate) {
		this.graduate = graduate;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public TotalDto(String joinemail, int schoolseq, String career, String schoolname, String admission, String graduate, String major, String grade) {
		this.joinemail = joinemail;
		this.schoolseq = schoolseq;
		this.career = career;
		this.schoolname = schoolname;
		this.admission = admission;
		this.graduate = graduate;
		this.major = major;
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "TotalDto [totalseq=" + totalseq + ", joinseq=" + joinseq + ", joinemail=" + joinemail + ", joinname="
				+ joinname + ", joinpw=" + joinpw + ", joinbirth=" + joinbirth + ", joinsex=" + joinsex + ", photo="
				+ photo + ", mililtary=" + mililtary + ", phone=" + phone + ", address=" + address + ", kakao=" + kakao
				+ ", singup=" + singup + ", skillseq=" + skillseq + ", category=" + category + ", itskill1=" + itskill1
				+ ", itskill2=" + itskill2 + ", itskill3=" + itskill3 + ", itskill4=" + itskill4 + ", itskill5="
				+ itskill5 + ", itscore1=" + itscore1 + ", itscore2=" + itscore2 + ", itscore3=" + itscore3
				+ ", itscore4=" + itscore4 + ", itscore5=" + itscore5 + ", certificate=" + certificate
				+ ", languagename=" + languagename + ", languagescore=" + languagescore + ", languageregdate="
				+ languageregdate + ", contest=" + contest + ", prize=" + prize + ", organization=" + organization
				+ ", startorganization=" + startorganization+ ", regdate=" + regdate + ", schoolseq=" + schoolseq
				+ ", career=" + career + ", schoolname=" + schoolname + ", admission=" + admission + ", graduate="
				+ graduate + ", major=" + major + ", grade=" + grade + "]";
	}
	

}
