package com.job.coverletter.model.joinUser.dao;

import java.util.HashMap;

import com.job.coverletter.model.joinUser.dto.JoinUserDto;

public interface JoinUserDao {
	String NAMESPACE = "com.job.coverletter.JoinUser.";
	
	int insertUser(JoinUserDto dto);
	
	JoinUserDto selectOne(String joinemail);
	
	int updateJoinuser(JoinUserDto dto);
	
	int deletejoinuser(String joinemail);
	
	JoinUserDto login(JoinUserDto dto);
	
	String checkemail (String joinemail);
	
	String kakaoLogin(String joinemail);

}
