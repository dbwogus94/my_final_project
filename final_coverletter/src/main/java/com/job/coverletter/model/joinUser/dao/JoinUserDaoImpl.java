package com.job.coverletter.model.joinUser.dao;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.job.coverletter.model.joinUser.dto.JoinUserDto;

@Repository
public class JoinUserDaoImpl implements JoinUserDao {
	
	@Autowired  @Qualifier("sqlSessionTemPlate")
	private SqlSessionTemplate sqlSession;

	@Override
	public int insertUser(JoinUserDto dto){
		return sqlSession.insert("com.job.coverletter.JoinUser.joinuser",dto);
	}

	@Override
	public JoinUserDto selectOne(String joinemail) {
		
		JoinUserDto dto = new JoinUserDto();
		
		dto = sqlSession.selectOne("com.job.coverletter.JoinUser.loginuser",joinemail);
		
		return dto;
	}

	@Override
	public int updateJoinuser(JoinUserDto dto) {

		return sqlSession.update("com.job.coverletter.JoinUser.updateuser",	dto);
	}

	@Override
	public int deletejoinuser(String joinemail) {

		return sqlSession.delete("com.job.coverletter.JoinUser.userdelete", joinemail);
	}
	
	
	@Override
	public JoinUserDto login(JoinUserDto dto) {
		dto = sqlSession.selectOne("com.job.coverletter.JoinUser.login", dto);
		return dto;
	}

	@Override
	public String checkemail(String joinemail) {
		JoinUserDto dto = sqlSession.selectOne("com.job.coverletter.JoinUser.checkEmail", joinemail);
		
		if(dto == null) {
			return "사용가능";
		} else {
			return "중복";
		}
	}

	@Override
	public String kakaoLogin(String joinemail) {

		JoinUserDto dto = sqlSession.selectOne("com.job.coverletter.JoinUser.checkEmail", joinemail);
		
		if(dto == null) {
			return "회원가입";
		}else {
			return "가입";
		}
	}
	
	
	
	
}
