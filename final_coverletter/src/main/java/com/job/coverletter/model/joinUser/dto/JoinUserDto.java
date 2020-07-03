package com.job.coverletter.model.joinUser.dto;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;


public class JoinUserDto {

    // 회원번호(SEQ) 
    private int joinseq;

    // 이메일(ID) 
    @NotEmpty(message = "이메일을 입력해주세요")
    @Email(message = "이메일 형식이 틀렸습니다.")
    private String joinemail;

    // 이름 
    @NotEmpty(message = "이름을 입력해주세요")
    @Pattern(regexp = "[가-힣]*$", message = "이름은 한글만 사용해주세요")
    private String joinname;

    // 비밀번호 
    @Pattern(regexp="^.*(?=.{6,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$", message = "숫자 영어 혼합으로 6~20자리로")
    private String joinpw;

    // 생년월일 
    @Pattern(regexp = "^[0-9]*$", message = "형식을 맞춰주세요")
    @Length(min = 8, max = 8, message = "형식을 맞춰주세요")

    private String joinbirth;

    // 성별 
    @NotEmpty(message = "성별을 선택해주세요")
    private String joinsex;

    // 사진 
    private String photo;

    // 병역 
    private String mililtary;

    // 전화번호 
    private String phone;

    // 주소 
    private String address;

    // 카카오 
    private String kakao;

    // 회원가입 여부 
    private String singup;
    
    
    public JoinUserDto() {
      super();
   }
    
    

   public JoinUserDto(String joinemail,	String joinpw) {
		this.joinemail = joinemail;
		this.joinpw = joinpw;
	}



public JoinUserDto(int joinseq, String joinemail, String joinname, String joinpw, String joinbirth, String joinsex,
         String photo, String mililtary, String phone, String address, String kakao, String singup) {
      super();
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

   public int getJoinseq() {
        return joinseq;
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

   @Override
   public String toString() {
      return "JoinUserDto [joinseq=" + joinseq + ", joinemail=" + joinemail + ", joinname=" + joinname + ", joinpw="
            + joinpw + ", joinbirth=" + joinbirth + ", joinsex=" + joinsex + ", photo=" + photo + ", mililtary="
            + mililtary + ", phone=" + phone + ", address=" + address + ", kakao=" + kakao + ", singup=" + singup
            + "]";
   }

    
    
}