package com.job.coverletter.model.school.dto;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class SchoolDto {
	 // SCHOOLSEQ 
    private int schoolseq;

    // 이메일(ID) 
    @NotEmpty(message = "이메일을 입력해주세요")
    @Email(message = "이메일 형식이 틀렸습니다.")
    private String joinemail;

    // 학력구분(학위)
    @Pattern(regexp = "^(대졸)|(전문대졸)|(고졸)", message = "학력구분을 선택해주세요")
    private String career;

    // 학교명 
    @NotEmpty(message = "값을 입력해주세요")
    private String schoolname;

    // 입학년월
    @Pattern(regexp = "^(([0-9][0-9])[년]([0-1][0-9])[월]([0-3][0-9])[일]$)", message = "yy년mm월dd일 형태로 작성해주세요.")
    private String admission;
    // 졸업년월 재학중, 중퇴...
    @Pattern(regexp = "^(([0-9][0-9])[년]([0-1][0-9])[월]([0-3][0-9])[일]$)", message = "yy년mm월dd일 형태로 작성해주세요.")
    private String graduate;

    // 전공명 
    @NotEmpty(message = "값을 입력해주세요")
    private String major;

    // 학점 4.0 / 3,5...
    @Pattern(regexp = "^[1-3][.]\\d{1}|[4][.][0-5]{1}$", message = "4.5 형태로 작성해주세요")
    private String grade;
    
    
    public SchoolDto() {
		super();
	}

	public SchoolDto(int schoolseq, String joinemail, String career, String schoolname, String admission,
			String graduate, String major, String grade) {
		super();
		this.schoolseq = schoolseq;
		this.joinemail = joinemail;
		this.career = career;
		this.schoolname = schoolname;
		this.admission = admission;
		this.graduate = graduate;
		this.major = major;
		this.grade = grade;
	}

	public int getSchoolseq() {
        return schoolseq;
    }

    public void setSchoolseq(int schoolseq) {
        this.schoolseq = schoolseq;
    }

    public String getJoinemail() {
        return joinemail;
    }

    public void setJoinemail(String joinemail) {
        this.joinemail = joinemail;
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

	@Override
	public String toString() {
		return "SchoolDto [schoolseq=" + schoolseq + ", joinemail=" + joinemail + ", career=" + career + ", schoolname="
				+ schoolname + ", admission=" + admission + ", graduate=" + graduate + ", major=" + major + ", grade="
				+ grade + "]";
	}
    
    
}
